package com.lallucana.API.Persentation.View;

import com.lallucana.API.Business.Race.Runner;
import com.lallucana.API.Persistance.Exceptions.ErrorRequest;

import java.util.List;

public class VmixTop3 extends Vmix{
    public VmixTop3(String server, Integer input) {
        super(server, input);
    }

    /**
     * @param runners
     * @throws ErrorRequest
     */
    @Override
    public void updateInput(List<Runner> runners) throws ErrorRequest {
        this.updateTitle(runners.get(0).getSex());
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
        StringBuffer stringBuffer = new StringBuffer();
        String url = null;
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Pos" + runner.getPosition() + ".Text&value=");
        stringBuffer.append(runner.getPosition());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Nom" + runner.getPosition() + ".Text&value=");
        stringBuffer.append(runner.getName() + " "+runner.getSurname());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Time" + runner.getPosition() + ".Text&value=");
        stringBuffer.append(runner.getTime());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetImage&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Flag" + runner.getPosition() + ".Source&value=");
        stringBuffer.append(runner.getFlag());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);

    }

    /**
     * @param sex of runners to show
     * @throws ErrorRequest connection error
     */
    @Override
    protected void updateTitle(String sex) throws ErrorRequest {

    }


}
