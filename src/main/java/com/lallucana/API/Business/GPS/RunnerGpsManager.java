package com.lallucana.API.Business.GPS;


import com.lallucana.API.Persistance.Exceptions.ErrorRequest;
import com.lallucana.API.Persistance.Runner.RunnerDAO;
import com.lallucana.API.Persistance.Runner.RunnerGpsDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ferran Castañé on 23/09/2023
 * Runner GPS Manager class
 */
public class RunnerGpsManager implements RunnerGpsObservable {
    private List<RunnerGps> runners;
    private final List<RunnerGpsObserver> observers = new ArrayList<>();
    private final RunnerDAO runnerGpsDAO;
    private String jsonPath;

    /**
     * Instantiates a new Runner gps manager.
     *
     * @param path the path
     */
    public RunnerGpsManager(String path) {
        this.runnerGpsDAO = new RunnerGpsDAO();
        this.jsonPath = path;
        new Thread(this::updateGpsRunners).start();
    }


    /**
     * Update gps runners.
     */
    private void updateGpsRunners() {
        long UPDATE_INTERVAL = 8000;
        while (true) {
            try {
                System.out.println("Updating GPS");
                this.runners = (List<RunnerGps>) this.runnerGpsDAO.getRunners(this.jsonPath);
                this.updateRunners();
                System.out.println("GPS updated");
            } catch (ErrorRequest e) {
                System.out.println("Error updating GPS");
            }
            try {
                Thread.sleep(UPDATE_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Add a runner to the list of runners
     *
     * @param runnerObserver the runner observer
     */
    @Override
    public void addRunnerGpsObserver(RunnerGpsObserver runnerObserver) {
        this.observers.add(runnerObserver);
    }

    /**
     * Delete a runner from the list of runners
     *
     * @param runnerObserver the runner observer
     */
    @Override
    public void deleteRunnerGpsObserver(RunnerGpsObserver runnerObserver) {
        this.observers.remove(runnerObserver);
    }

    /**
     * Update the runners observers
     */
    @Override
    public void updateRunners() {
        for (RunnerGpsObserver observer : this.observers) {
            observer.updateGpsRunners(this.runners);
        }
    }
}
