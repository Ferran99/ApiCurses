package com.lallucana.LaLlucanaLiveTrack.Business.Race;


import com.lallucana.LaLlucanaLiveTrack.Business.LiveTrial.Runner.RunnerLiveTrial;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Runner manager.
 */
public class RunnerManager {
    private final List<Runner> runners = new ArrayList<>();
    private final List<Runner> compereRunners = new ArrayList<>();

    /**
     * Instantiates a new Runner manager.
     */
    public RunnerManager(){

    }


    /**
     * Update runners live trial.
     *
     * @param runnerLiveTrial the runner live trial
     */
    public void updateRunnersLiveTrial(List<RunnerLiveTrial> runnerLiveTrial){
        this.runners.clear();
        int pos = 1;
        for (RunnerLiveTrial runner : runnerLiveTrial) {
            this.runners.add(new Runner(runner.getName(), runner.getSurname(), runner.getDorsal(), runner.getCountry(), runner.getClub(), runner.getCio(), runner.getTime(), runner.getSex(), pos, runner.getPuntDePas()));
            pos++;
        }
    }

    /**
     * Get runners list.
     *
     * @return the list
     */
    public List<Runner> getRunners(){
        return this.runners;
    }

    /**
     * Update compere runners live trial.
     *
     * @param runner1 the runner 1
     * @param runner2 the runner 2
     * @param runner3 the runner 3
     */
    public void updateCompereRunnersLiveTrial(RunnerLiveTrial runner1, RunnerLiveTrial runner2, RunnerLiveTrial runner3) {
        this.compereRunners.clear();
        this.compereRunners.add(new Runner(runner1.getName(), runner1.getSurname(), runner1.getDorsal(),
                runner1.getCountry(), runner1.getClub(), runner1.getCio(), runner1.getGapTime(),
                runner1.getSex(), runner1.getPosition(), runner1.getPuntDePas(), runner1.getGapDistance()));

        this.compereRunners.add(new Runner(runner2.getName(), runner2.getSurname(), runner2.getDorsal(),
                runner2.getCountry(), runner2.getClub(), runner2.getCio(), runner2.getGapTime(),
                runner2.getSex(), runner2.getPosition(), runner2.getPuntDePas(), runner2.getGapDistance()));

        this.compereRunners.add(new Runner(runner3.getName(), runner3.getSurname(), runner3.getDorsal(),
                runner3.getCountry(), runner3.getClub(), runner3.getCio(), runner3.getGapTime(),
                runner3.getSex(), runner3.getPosition(), runner3.getPuntDePas(), runner3.getGapDistance()));
    }

    /**
     * Get compere runners live trial list.
     *
     * @return the list
     */
    public List<Runner> getCompereRunnersLiveTrial(){
        return this.compereRunners;
    }
}