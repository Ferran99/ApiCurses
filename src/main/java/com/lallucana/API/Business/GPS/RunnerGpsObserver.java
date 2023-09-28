package com.lallucana.API.Business.GPS;

import java.util.List;

public interface RunnerGpsObserver {
    /**
     * Update.
     *
     * @param runners the runner
     */
    void updateGpsRunners(List<RunnerGps> runners);
}
