package com.lallucana.API.Persentation.View;

import com.lallucana.API.Business.Race.Runner;
import com.lallucana.API.Persistance.Exceptions.ErrorRequest;

import java.util.List;

public class VmixTop3 extends Vmix{
    public VmixTop3(String server, Integer input) {
        super(server, input);
    }

    //TODO: Mirar si l'actualització funciona correctament
    /**
     * @param runners
     * @throws ErrorRequest
     */
    @Override
    public void updateInput(List<Runner> runners) throws ErrorRequest {
        this.updateTitle(runners.get(0).getSex(), runners.get(0).getPointOfPas());
        for (Runner runner : runners) {
            this.updateRunner(runner);
        }
    }

    /**
     * @param runner to be updated
     * @throws ErrorRequest connection error
     */
    @Override
    protected void updateRunner(Runner runner) throws ErrorRequest {
        updateRunnerData(runner, "Pos", String.valueOf(runner.getPosition()));
        updateRunnerData(runner, "Nom", runner.getName() + " " + runner.getSurname());
        updateRunnerData(runner, "Time", runner.getTime());
        updateImageForRunner(runner, "Flag", runner.getFlag());
    }

    private void updateRunnerData(Runner runner, String key, String value) throws ErrorRequest {
        String urlTemplate = "%s/API/?Function=SetText&Input=%s&SelectedName=%s%s.Text&value=%s";
        String url = String.format(urlTemplate, this.getServer(), this.getInput(), key, runner.getPosition(), value).replace(" ", "%20");
        this.getUrl(url);
    }

    private void updateImageForRunner(Runner runner, String key, String value) throws ErrorRequest {
        String urlTemplate = "%s/API/?Function=SetImage&Input=%s&SelectedName=%s%s.Source&value=%s";
        String url = String.format(urlTemplate, this.getServer(), this.getInput(), key, runner.getPosition(), value).replace(" ", "%20");
        this.getUrl(url);
    }

    /**
     * @param sex of runners to show
     * @param pointOfPass last point
     * @throws ErrorRequest connection error
     */
    @Override
    protected void updateTitle(String sex, String pointOfPass) throws ErrorRequest {
        // Implementation of this method...
    }

}
