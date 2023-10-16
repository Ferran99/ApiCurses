package com.lallucana.LaLlucanaLiveTrack.Presentation.View;

import com.lallucana.LaLlucanaLiveTrack.Business.Race.Runner;
import com.lallucana.LaLlucanaLiveTrack.Persistance.Exceptions.ErrorRequest;
import com.lallucana.LaLlucanaLiveTrack.Persistance.HttpRequest;

import java.util.List;

/**
 * The type Vmix.
 */
public abstract class Vmix extends HttpRequest {
    private Integer input;
    private String server;

    /**
     * Instantiates a new Vmix.
     *
     * @param server the server
     * @param input  the input
     */
    public Vmix(String server, Integer input) {
        super();
        this.input = input;
        this.server = server;
    }


    /**
     * Gets server.
     *
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * Gets input.
     *
     * @return the input
     */
    public Integer getInput() {
        return input;
    }

    /**
     * Update input.
     *
     * @param runners the runners
     * @throws ErrorRequest the error request
     */
    public abstract void updateInput(List<Runner> runners) throws ErrorRequest;

    /**
     * Update runner.
     *
     * @param runner the runner
     * @throws ErrorRequest the error request
     */
    protected abstract void updateRunner(Runner runner) throws ErrorRequest;

    /**
     * Update title.
     *
     * @param sex       the sex
     * @param puntDePas the punt de pas
     * @throws ErrorRequest the error request
     */
    protected abstract void updateTitle(String sex, String puntDePas) throws ErrorRequest;
}
