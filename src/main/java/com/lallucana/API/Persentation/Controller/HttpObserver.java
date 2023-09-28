package com.lallucana.API.Persentation.Controller;

public interface HttpObserver {

    /**
     * Update top 10 runners.
     *
     * @param genre the genre of the runners
     */
    void updateHttpTop10(String genre);

    /**
     * Update top 5 runners
     * @param genre of the runners
     */
    void updateHttpTop5(String genre);

    /**
     * Update top 3 runners
     * @param  genre of the runners
     */
    void updateHttpTop3(String genre);
}