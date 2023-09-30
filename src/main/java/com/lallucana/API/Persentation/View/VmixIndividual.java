package com.lallucana.API.Persentation.View;

import com.lallucana.API.Business.Race.Runner;
import com.lallucana.API.Persistance.Exceptions.ErrorRequest;

import java.util.List;

public class VmixIndividual  extends Vmix{

    private Integer input2;
    private Integer input3;
    private  Integer input4;

    public VmixIndividual(String server, Integer input, Integer input2, Integer input3, Integer input4) {
        super(server, input);
        this.input2 = input2;
        this.input3 = input3;
        this.input4 = input4;
    }




    /**
     * @param runners
     * @throws ErrorRequest
     */
    @Override
    public void updateInput(List<Runner> runners) throws ErrorRequest {
        Runner runner = runners.get(0);
        StringBuffer stringBuffer = new StringBuffer();
        String url = null;
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Dors.Text&value=");
        stringBuffer.append(runner.getDorsal());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());

        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Pais.Text&value=");
        stringBuffer.append(runner.getCio());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());

        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Nom.Text&value=");
        stringBuffer.append(runner.getName()+ " "+runner.getSurname());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);

        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Club.Text&value=");
        stringBuffer.append(runner.getClub());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetImage&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Flag.Source&value=");
        stringBuffer.append(runner.getFlag());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());

        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.getInput());
        stringBuffer.append("&SelectedName=Pos.Text&value=");
        stringBuffer.append(runner.getPosition());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());

        updateInput2(runners.get(1));
        updateInput3(runners.get(1));
        updateInput4(runners.get(2));
    }

    private void updateInput2(Runner runner) throws ErrorRequest {
        StringBuffer stringBuffer = new StringBuffer();
        String url = null;
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input2);
        stringBuffer.append("&SelectedName=Dors.Text&value=");
        stringBuffer.append(runner.getDorsal());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input2);
        stringBuffer.append("&SelectedName=Pais.Text&value=");
        stringBuffer.append(runner.getCio());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input2);
        stringBuffer.append("&SelectedName=Club.Text&value=");
        stringBuffer.append(runner.getClub());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input2);
        stringBuffer.append("&SelectedName=Nom.Text&value=");
        stringBuffer.append(runner.getName()+ " "+runner.getSurname());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());

        stringBuffer.append("/API/?Function=SetImage&Input=");
        stringBuffer.append(this.input2);
        stringBuffer.append("&SelectedName=Flag.Source&value=");
        stringBuffer.append(runner.getFlag());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());

        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input2);
        stringBuffer.append("&SelectedName=Pos.Text&value=");
        stringBuffer.append(runner.getPosition());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
    }

    private void updateInput3(Runner runner) throws ErrorRequest {
        StringBuffer stringBuffer = new StringBuffer();
        String url = null;

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input3);
        stringBuffer.append("&SelectedName=Dors2.Text&value=");
        stringBuffer.append(runner.getDorsal());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input3);
        stringBuffer.append("&SelectedName=Pais2.Text&value=");
        stringBuffer.append(runner.getCio());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input3);
        stringBuffer.append("&SelectedName=Nom2.Text&value=");
        stringBuffer.append(runner.getName()+ " "+runner.getSurname());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetImage&Input=");
        stringBuffer.append(this.input3);
        stringBuffer.append("&SelectedName=Flag2.Source&value=");
        stringBuffer.append(runner.getFlag());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();


        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input3);
        stringBuffer.append("&SelectedName=Club2.Text&value=");
        stringBuffer.append(runner.getClub());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);

        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input3);
        stringBuffer.append("&SelectedName=BattleTime.Text&value=");
        stringBuffer.append(runner.getTime());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);

        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input3);
        stringBuffer.append("&SelectedName=Battle.Text&value=");
        stringBuffer.append("BATTLE for "+(runner.getPosition() -1));
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
    }

    private void updateInput4(Runner runner) throws ErrorRequest {
        StringBuffer stringBuffer = new StringBuffer();
        String url = null;

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input4);
        stringBuffer.append("&SelectedName=Dors2.Text&value=");
        stringBuffer.append(runner.getDorsal());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input4);
        stringBuffer.append("&SelectedName=Pais2.Text&value=");
        stringBuffer.append(runner.getCio());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input4);
        stringBuffer.append("&SelectedName=Club2.Text&value=");
        stringBuffer.append(runner.getClub());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);

        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input4);
        stringBuffer.append("&SelectedName=Nom2.Text&value=");
        stringBuffer.append(runner.getName()+" "+runner.getSurname());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetImage&Input=");
        stringBuffer.append(this.input4);
        stringBuffer.append("&SelectedName=Flag2.Source&value=");
        stringBuffer.append(runner.getFlag());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input4);
        stringBuffer.append("&SelectedName=BattleTime.Text&value=");
        stringBuffer.append(runner.getTime());
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();

        stringBuffer.append(this.getServer());
        stringBuffer.append("/API/?Function=SetText&Input=");
        stringBuffer.append(this.input4);
        stringBuffer.append("&SelectedName=Battle.Text&value=");
        stringBuffer.append("BATTLE for "+(runner.getPosition()));
        url = stringBuffer.toString().replace(" ", "%20");
        this.getUrl(url);
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.getServer());
    }

    /**
     * @param runner
     * @throws ErrorRequest
     */
    @Override
    protected void updateRunner(Runner runner) throws ErrorRequest {

    }

    /**
     * @param sex
     * @param puntDePas
     * @throws ErrorRequest
     */
    @Override
    protected void updateTitle(String sex, String puntDePas) throws ErrorRequest {

    }
}
