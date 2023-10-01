package com.lallucana.API.Persentation.View;

import com.lallucana.API.Business.Race.Runner;
import com.lallucana.API.Persistance.Exceptions.ErrorRequest;

import java.util.List;

public class VmixTop10 extends Vmix {


    public VmixTop10(String server, Integer input) {
        super(server, input);
    }
    @Override
    public void updateInput(List<Runner> runners) throws ErrorRequest {

        this.updateTitle(runners.get(0).getSex(), runners.get(0).getPointOfPas());
        for (Runner runner : runners) {
            new Thread(()-> {
                try {
                    this.updateRunner(runner);
                } catch (ErrorRequest e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }

    /**
     * @param runner to be updated
     * @throws ErrorRequest connection error
     */
    @Override
    public void updateRunner(Runner runner) throws ErrorRequest {
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
        stringBuffer.append(runner.getName()+ " "+runner.getSurname());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Dors" + runner.getPosition() + ".Text&value=");
        stringBuffer.append(runner.getDorsal());
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
     * @param puntDePas last punt
     * @throws ErrorRequest connection error
     */
    @Override
    public void updateTitle(String sex, String puntDePas) throws ErrorRequest {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Title.Text&value=");
        stringBuffer.append("TOP ELITE ");
        stringBuffer.append((sex.equals("H") || sex.equals("M")) ? "MAN" : "WOMAN");
        //Preper string buffer for URL request
        String url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Cat.Text&value=");
        stringBuffer.append(puntDePas);
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
    }
}
