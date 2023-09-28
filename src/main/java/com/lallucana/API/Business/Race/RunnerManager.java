package com.lallucana.API.Business.Race;

import com.lallucana.API.Business.LiveTrial.Runner.RunnerLiveTrial;

import java.util.ArrayList;
import java.util.List;

public class RunnerManager {
    private final List<Runner> runners = new ArrayList<>();

    public RunnerManager(){

    }


    public void updateRunnersLiveTrial(List<RunnerLiveTrial> runnerLiveTrial){
        this.runners.clear();
        int pos = 1;
        for (RunnerLiveTrial runner : runnerLiveTrial) {
            this.runners.add(new Runner(runner.getName() +runner.getSurname(), runner.getDorsal(), runner.getCountry(), runner.getClub(), runner.getCio(), runner.getTime(), runner.getSex(), pos));
            pos++;
        }
    }

    public List<Runner> getRunners(){
        return this.runners;
    }
}
