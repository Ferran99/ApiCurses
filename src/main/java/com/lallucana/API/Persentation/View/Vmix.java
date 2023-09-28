package com.lallucana.API.Persentation.View;

import com.lallucana.API.Business.Race.Runner;
import com.lallucana.API.Persistance.Exceptions.ErrorRequest;
import com.lallucana.API.Persistance.HttpRequest;

import java.util.List;

public abstract class Vmix extends HttpRequest  {
    private Integer input;
    private String server;

    public Vmix(String server, Integer input) {
        super();
        this.input = input;
        this.server = server;
    }


    public String getServer() {
        return server;
    }
    public String getInput() {
        return input.toString();
    }

    public  abstract  void updateInput(List<Runner> runners) throws ErrorRequest;
}
