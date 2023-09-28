package com.lallucana.API.Business.LiveTrial;


import com.lallucana.API.Business.GPS.RunnerGps;
import com.lallucana.API.Business.LiveTrial.Runner.RunnerLiveTrailObservable;
import com.lallucana.API.Business.LiveTrial.Runner.RunnerLiveTrailObserver;
import com.lallucana.API.Business.LiveTrial.Runner.RunnerLiveTrial;
import com.lallucana.API.Business.Race.Race;
import com.lallucana.API.Persistance.Exceptions.ErrorRequest;
import com.lallucana.API.Persistance.Runner.RunnerDAO;
import com.lallucana.API.Persistance.Runner.RunnerLiveTrailDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ferran Castañé on 23/09/2023
 * Document Live Trail manager class
 */

public class DocumentManager implements RunnerLiveTrailObservable {
    private Document document;
    private Race race;
    private final RunnerDAO runnerDao;
    private final List<RunnerLiveTrailObserver> runnerObservers = new ArrayList<>();
    private final HashMap<Integer, RunnerLiveTrial> hashMapRunners = new HashMap<>();
    private final String MAN = "M";
    private final String MAN_ALTERNATIVE = "H";

    /**
     * Instantiates a new Document manager.
     *
     * @param race Object race
     */
    public DocumentManager(Race race) {
        this.race = race;
        this.runnerDao = new RunnerLiveTrailDAO();
        try {
            this.document = (Document) this.runnerDao.getRunners(this.race.getStartUrl());
            for (RunnerLiveTrial runner : this.document.getRunners()) {
                this.hashMapRunners.put(runner.getDorsal(), runner);
            }
            new Thread(this::updateDocument).start();
        } catch (ErrorRequest e) {
            System.out.println("Error updating Live Trail");
            System.out.println(e);
        }
    }

    /**
     * Gets runners.
     *
     * @param isMan boolean to know
     * @param top   Number of runners
     * @return the runners
     */
    public List<RunnerLiveTrial> getRunners(Boolean isMan, Integer top) {
        try {
            List<RunnerLiveTrial> runnersMan = new ArrayList<>();
            List<RunnerLiveTrial> runnersWoman = new ArrayList<>();
            for (RunnerLiveTrial runner : this.document.getRunners()) {
                if (runner.getSex().equals(MAN) || runner.getSex().equals(MAN_ALTERNATIVE)) {
                    runnersMan.add(runner);
                } else {
                    runnersWoman.add(runner);
                }
            }
            return isMan ? (runnersMan.size() > top ? runnersMan.subList(0, top) : runnersMan) : (runnersWoman.size() > top ? runnersWoman.subList(0, top) : runnersWoman);
        } catch (NullPointerException e) {
            System.out.println("Error getting runners!! No runners found");
            return null;
        }


    }


    /**
     * Update document every minute
     */
    private void updateDocument() {
        long UPDATE_INTERVAL = 60000;
        Document auxDocument;
        while (true) {
            try {
                auxDocument = (Document) this.runnerDao.getRunners(this.race.getPointsUrl());
                System.out.println("Updating Live Trail");
                if (auxDocument != null) {
                    if (!auxDocument.getRunners().equals(this.document.getRunners())) {
                        this.document = auxDocument;
                        for (RunnerLiveTrial runner : this.document.getRunners()) {
                            if (this.hashMapRunners.containsKey(runner.getDorsal())) {
                                this.hashMapRunners.replace(runner.getDorsal(), runner);
                            }
                        }
                        this.updateRunners();
                        System.out.println("Live Trail updated");
                    }
                }
            } catch (ErrorRequest e) {
                System.out.println("Error updating Live Trail");
                System.out.println(e);

            }
            try {
                Thread.sleep(UPDATE_INTERVAL);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Add a runner live trial observer to the list of runners
     *
     * @param runnerObserver
     */
    @Override
    public void addRunnerLiveTrailObserver(RunnerLiveTrailObserver runnerObserver) {
        this.runnerObservers.add(runnerObserver);

    }

    /**
     * Delete a runner live trial observer from the list of runners
     *
     * @param runnerObserver
     */
    @Override
    public void deleteRunnerLiveTrailObserver(RunnerLiveTrailObserver runnerObserver) {
        this.runnerObservers.remove(runnerObserver);
    }

    /**
     * Notify the observers that the list of runners has been updated
     */
    @Override
    public void updateRunners() {
        for (RunnerLiveTrailObserver runnerObserver : this.runnerObservers) {
            runnerObserver.updateLiveTrail();
        }
    }

    @Override
    public void updateRunnersRealTime() {
        for (RunnerLiveTrailObserver runnerObserver : this.runnerObservers) {
            runnerObserver.updateLiveTrialRealTime();
        }
    }

    /**
     * Combine Live Trial runners with GPS runners
     *
     * @param runners List of runners from GPS
     */
    public void combineRunners(List<RunnerGps> runners) {
        System.out.println("Updating Live Trial with GPS");
        Map<Integer, RunnerGps> runnerGpsMap = new HashMap<>();
        for (RunnerGps runnerGps : runners) {
            runnerGpsMap.put(runnerGps.getDorsal(), runnerGps);
        }
        for (RunnerLiveTrial runnerLiveTrial : this.document.getRunners()) {
            RunnerGps matchingRunnerGps = runnerGpsMap.get(runnerLiveTrial.getDorsal());
            if (matchingRunnerGps != null) {
                runnerLiveTrial.setSpeed(matchingRunnerGps.getSpeed());
                runnerLiveTrial.setDistance(matchingRunnerGps.getDist());
                runnerLiveTrial.setGapTime(matchingRunnerGps.getGapTime());
                runnerLiveTrial.setGapDistance(matchingRunnerGps.getGapDistance());
            }
        }
        System.out.println("Live Trial updated with GPS");
        this.updateRunnersRealTime();

    }

    public HashMap<Integer, RunnerLiveTrial> getRealTimeRunners() {
        return this.hashMapRunners;
    }
}
