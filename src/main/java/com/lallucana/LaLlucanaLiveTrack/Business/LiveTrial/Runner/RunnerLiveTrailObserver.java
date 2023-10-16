package com.lallucana.LaLlucanaLiveTrack.Business.LiveTrial.Runner;

/**
 * created by Ferran Castañé on 23/09/2023
 * This interface implements the methods for the observer of a runner.
 */
public interface RunnerLiveTrailObserver {

    /**
     *Update.
     */
    void updateLiveTrail();

    /**
     *Update real time.
     */
    void updateLiveTrialRealTime();
}
