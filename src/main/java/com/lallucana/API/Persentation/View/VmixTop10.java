package com.lallucana.API.Persentation.View;

import com.lallucana.API.Business.LiveTrial.Runner.RunnerLiveTrial;
import com.lallucana.API.Business.Race.Runner;
import com.lallucana.API.Persistance.Exceptions.ErrorRequest;
import com.lallucana.API.Persistance.HttpRequest;

import java.util.List;

public class VmixTop10 extends Vmix {


    public VmixTop10(String server, Integer input) {
        super(server, input);
    }
    @Override
    public void updateInput(List<Runner> runners) throws ErrorRequest {

        this.updateTitle(runners.get(0).getSex());
        for (Runner runner : runners) {
            this.updateRunner(runner);
        }

    }

    private void updateRunner(Runner runner) throws ErrorRequest {
        StringBuffer stringBuffer = new StringBuffer();
        String url = null;
        stringBuffer.append(this.getServer());
        stringBuffer.append("/api/?function=SetText&input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&selectedName=Pos" + runner.getPosition() + ".text&selectedValue=");
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/api/?function=SetText&input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append(runner.getPosition());
        stringBuffer.append("&selectedName=Nom" + runner.getPosition() + ".text&selectedValue=");
        stringBuffer.append(runner.getName());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/api/?function=SetText&input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&selectedName=Dors" + runner.getPosition() + ".text&selectedValue=");
        stringBuffer.append(runner.getDorsal());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/api/?function=SetText&input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&selectedName=Time" + runner.getPosition() + ".text&selectedValue=");
        stringBuffer.append(runner.getTime());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/api/?function=SetText&input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&selectedName=Flag" + runner.getPosition() + ".text&selectedValue=");
        stringBuffer.append(runner.getFlag());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
    }

    private void updateTitle(String sex) throws ErrorRequest {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/api/?function=SetText&input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&selectedName=Cat.text&selectedValue=");
        stringBuffer.append("Top 10");
        stringBuffer.append(sex.equals("H") || sex.equals("M") ? "MAN" : "WOMAN");
        //Preper string buffer for URL request
        String url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
    }
}
