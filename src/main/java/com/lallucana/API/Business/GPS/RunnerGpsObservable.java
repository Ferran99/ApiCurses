package com.lallucana.API.Business.GPS;



public interface RunnerGpsObservable {
    /**
     * Add a runner to the list of runners
     * @param runnerObserver the runner observer
     */
    void addRunnerGpsObserver(RunnerGpsObserver runnerObserver);

    /**
     * Delete a runner from the list of runners
     * @param runnerObserver the runner observer
     */
    void deleteRunnerGpsObserver(RunnerGpsObserver runnerObserver);

    /**
     * Update the runners observers
     */

    void updateRunners();
}
