package com.lallucana.LaLlucanaLiveTrack.Business.LiveTrial.Runner;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Runner live trail observable interface
 */
public interface RunnerLiveTrailObservable {
    /**
     * Add a runner observer to the list of observers
     * @param runnerObserver the runner observer
     */

    void addRunnerLiveTrailObserver(RunnerLiveTrailObserver runnerObserver);

    /**
     * Delete a runner observer from the list of observers
     * @param runnerObserver the runner observer
     */
    void deleteRunnerLiveTrailObserver(RunnerLiveTrailObserver runnerObserver);

    /**
     * Update the runners observers
     */
    void updateRunners();

    /**
     * Update the runners real time observers
     */
    void updateRunnersRealTime();
}