package com.lallucana.LaLlucanaLiveTrack.Persistance.Runner;

import com.lallucana.LaLlucanaLiveTrack.Persistance.Exceptions.ErrorRequest;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Interface for the RunnerDAO
 *
 */
public interface RunnerDAO {
    /**
     * getRunners method for the RunnerDAO
     * @param raceUrl the race
     * @return ArrayList of Runners
     */

    Object getRunners(String raceUrl) throws ErrorRequest;
}
