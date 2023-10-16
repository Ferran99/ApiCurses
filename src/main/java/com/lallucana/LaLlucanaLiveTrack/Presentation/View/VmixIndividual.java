package com.lallucana.LaLlucanaLiveTrack.Presentation.View;

import com.lallucana.LaLlucanaLiveTrack.Business.Race.Runner;
import com.lallucana.LaLlucanaLiveTrack.Persistance.Exceptions.ErrorRequest;

import java.util.List;

/**
 * The type Vmix individual.
 */
public class VmixIndividual  extends Vmix{

    private Integer input2;
    private Integer input3;
    private  Integer input4;

    /**
     * Instantiates a new Vmix individual.
     *
     * @param server the server
     * @param input  the input
     * @param input2 the input 2
     * @param input3 the input 3
     * @param input4 the input 4
     */
    public VmixIndividual(String server, Integer input, Integer input2, Integer input3, Integer input4) {
        super(server, input);
        this.input2 = input2;
        this.input3 = input3;
        this.input4 = input4;
    }


    //TODO: Mirar si l'actualització funciona correctament
    public void updateInput(List<Runner> runners) throws ErrorRequest {
        setRunnerDetails(runners.get(0), this.getInput());
        setRunnerDetails(runners.get(1), this.input2);
        setRunnerDetails2(runners.get(1), this.input3);
        setRunnerDetails2(runners.get(2), this.input4);
    }

    private void setRunnerDetails(Runner runner, Integer input) throws ErrorRequest {
        sendRequest(input, "Dors.Text", runner.getDorsal().toString());
        sendRequest(input, "Pais.Text", runner.getCio());
        sendRequest(input, "Nom.Text", runner.getName() + " " + runner.getSurname());
        sendRequest(input, "Club.Text", runner.getClub());
        sendRequestForImage(input, "Flag.Source", runner.getFlag());
        sendRequest(input, "Pos.Text", runner.getPosition().toString());
    }

    private void setRunnerDetails2(Runner runner, Integer input) throws ErrorRequest {
        sendRequest(input, "Dors2.Text", runner.getDorsal().toString());
        sendRequest(input, "Pais2.Text", runner.getCio());
        sendRequest(input, "Nom2.Text", runner.getName() + " " + runner.getSurname());
        sendRequestForImage(input, "Flag2.Source", runner.getFlag());
        sendRequest(input, "Club2.Text", runner.getClub());
        sendRequest(input, "BattleTime.Text", runner.getTime());
        sendRequest(input, "Battle.Text", "BATTLE for " + (runner.getPosition() - 1));
    }

    private void sendRequest(Integer input, String fieldName, String value) throws ErrorRequest {
        String url = String.format("%s/API/?Function=SetText&Input=%d&SelectedName=%s&value=%s",
                this.getServer(), input, fieldName, value).replace(" ", "%20");
        this.getUrl(url);
    }

    private void sendRequestForImage(Integer input, String fieldName, String image) throws ErrorRequest {
        String url = String.format("%s/API/?Function=SetImage&Input=%d&SelectedName=%s&value=%s",
                this.getServer(), input, fieldName, image).replace(" ", "%20");
        this.getUrl(url);
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
