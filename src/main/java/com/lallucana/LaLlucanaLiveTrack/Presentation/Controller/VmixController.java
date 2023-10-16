package com.lallucana.LaLlucanaLiveTrack.Presentation.Controller;

import com.lallucana.LaLlucanaLiveTrack.Business.GPS.RunnerGps;
import com.lallucana.LaLlucanaLiveTrack.Business.GPS.RunnerGpsManager;
import com.lallucana.LaLlucanaLiveTrack.Business.GPS.RunnerGpsObserver;
import com.lallucana.LaLlucanaLiveTrack.Business.LiveTrial.DocumentManager;
import com.lallucana.LaLlucanaLiveTrack.Business.LiveTrial.Runner.RunnerLiveTrailObserver;
import com.lallucana.LaLlucanaLiveTrack.Business.LiveTrial.Runner.RunnerLiveTrial;
import com.lallucana.LaLlucanaLiveTrack.Business.Race.RunnerManager;
import com.lallucana.LaLlucanaLiveTrack.LaLlucanaLiveTrackApplication;
import com.lallucana.LaLlucanaLiveTrack.Persistance.Exceptions.ErrorRequest;
import com.lallucana.LaLlucanaLiveTrack.Presentation.Controller.HTTP.HttpController;
import com.lallucana.LaLlucanaLiveTrack.Presentation.Controller.HTTP.HttpObserver;
import com.lallucana.LaLlucanaLiveTrack.Presentation.View.VmixIndividual;
import com.lallucana.LaLlucanaLiveTrack.Presentation.View.VmixTop10;
import com.lallucana.LaLlucanaLiveTrack.Presentation.View.VmixTop3;
import com.lallucana.LaLlucanaLiveTrack.Presentation.View.VmixTop5;

import java.util.List;

/**
 * The type Vmix controller.
 */
public class VmixController implements RunnerLiveTrailObserver, RunnerGpsObserver, HttpObserver {
    private Boolean isTop10Man = false;
    private Boolean isTop10Woman = false;
    private Boolean isTop5Man = false;
    private Boolean isTop5Woman = false;
    private final Boolean isTop3Man = true;

    private final Integer TOP_10 = 10;
    private final Integer TOP_5 = 5;
    private final Integer TOP_3 = 3;

    private final String MAN = "M";
    private final String WOMAN = "F";

    private final RunnerGpsManager runnerGpsManager;
    private final DocumentManager documentManager;
    private Boolean isLiveTrail = true;
    private VmixTop10 vmixTop10;
    private VmixTop5 vmixTop5;
    private VmixTop3 vmixTop3M;
    private  VmixTop3 vmixTopF;
    private VmixIndividual vmixIndividual;
    private RunnerManager runnerManager;
    private Thread threadRealTime = null;

    /**
     * Instantiates a new Vmix controller.
     *
     * @param runnerGpsManager the runner gps manager
     * @param documentManager  the document manager
     * @param apiApplication   the simple http server
     * @param isLiveTrail      the is live trail
     */

    public VmixController(RunnerGpsManager runnerGpsManager, DocumentManager documentManager,
                          HttpController apiApplication, Boolean isLiveTrail, VmixTop10 vmixTop10, VmixTop5 vmixTop5,
                          VmixTop3 vmixTop3M, VmixTop3 vmixTop3W, RunnerManager runnerManager, VmixIndividual vmixIndividual) {
        this.runnerGpsManager = runnerGpsManager;
        this.documentManager = documentManager;
        this.runnerGpsManager.addRunnerGpsObserver(this);
        this.documentManager.addRunnerLiveTrailObserver(this);
        apiApplication.addHttpObserver(this);
        this.isLiveTrail = isLiveTrail;
        this.vmixTop10 = vmixTop10;
        this.vmixTop5 = vmixTop5;
        this.vmixTop3M = vmixTop3M;
        this.vmixTopF = vmixTop3W;
        this.runnerManager = runnerManager;
        this.vmixIndividual = vmixIndividual;
    }


    /**
     * Update.
     */
    @Override
    public void updateLiveTrail() {
        if (isTop10Man || isTop10Woman) {
            //System.out.println(this.documentManager.getRunners(isTop10Man, TOP_10).toString());
        } else if (isTop5Man || isTop5Woman) {
            //System.out.println(this.documentManager.getRunners(isTop5Man, TOP_5).toString());
        }
    }

    /**
     * Update live trial real time.
     */
    @Override
    public void updateLiveTrialRealTime() {
        List<RunnerLiveTrial> manTop5 = this.documentManager.getRunners(isTop5Man, TOP_5);
        List<RunnerLiveTrial> womanTop5 = this.documentManager.getRunners(isTop5Woman, TOP_5);
        //TODO: Update Vmix view
        System.out.println("Updating Vmix view");
    }

    /**
     * Update.
     *
     * @param runners the runner
     */
    @Override
    public void updateGpsRunners(List<RunnerGps> runners) {
        this.documentManager.combineRunners(runners);
    }


    /**
     * Update top 10 runners.
     *
     * @param genre the genre of the runners
     */
    @Override
    public void updateHttpTop10(String genre) {
        switch (genre){
            case MAN:
                isTop10Man = true;
                isTop10Woman = false;
                break;
            case WOMAN:
                isTop10Man = false;
                isTop10Woman = true;
                break;
        }
        if (this.isLiveTrail) {
            this.runnerManager.updateRunnersLiveTrial(this.documentManager.getRunners(isTop10Man, TOP_10));
            try {
                this.vmixTop10.updateInput(this.runnerManager.getRunners());
                System.out.println("Vimix updated top 10");
            } catch (ErrorRequest e) {
                System.out.println("Error updating top 10");
            }
        }
    }

    /**
     * Update top 5 runners
     *
     * @param genre of the runners
     */
    @Override
    public void updateHttpTop5(String genre) {
        switch (genre){
            case MAN:
                isTop5Man = true;
                isTop5Woman = false;
                break;
            case WOMAN:
                isTop5Man = false;
                isTop5Woman = true;
                break;
        }
        if (this.isLiveTrail) {
            this.runnerManager.updateRunnersLiveTrial(this.documentManager.getRunners(isTop5Man, TOP_5));
            try {
                this.vmixTop5.updateInput(this.runnerManager.getRunners());
                System.out.println("Vimix updated top 5");
            } catch (ErrorRequest e) {
                System.out.println("Error updating top 5");
            }
        }
    }

    /**
     * Update top 3 runners
     *
     * @param genre of the runners
     */
    @Override
    public void updateHttpTop3(String genre) {
        if (this.isLiveTrail) {
            this.runnerManager.updateRunnersLiveTrial(this.documentManager.getRunners(isTop3Man, TOP_3));
            try {
                this.vmixTop3M.updateInput(this.runnerManager.getRunners());
                System.out.println("Vimix updated top 3");
            } catch (ErrorRequest e) {
                System.out.println("Error updating top 3 M");
            }
            this.runnerManager.updateRunnersLiveTrial(this.documentManager.getRunners(!isTop3Man, TOP_3));
            try {
                this.vmixTopF.updateInput(this.runnerManager.getRunners());
                System.out.println("Vimix updated");
            } catch (ErrorRequest e) {
                System.out.println("Error updating top 3 F");
            }
        }
    }

    /**
     * Update Compere runners
     *
     * @param doss1
     * @param doss2
     * @param doss3
     */
    @Override
    public void updateCompareRunners(Integer doss1, Integer doss2, Integer doss3) {
        if(this.isLiveTrail){
            RunnerLiveTrial runner1 = this.documentManager.findRunner(doss1);
            RunnerLiveTrial runner2 = this.documentManager.findRunner(doss2);
            RunnerLiveTrial runner3 = this.documentManager.findRunner(doss3);
            try {
                this.runnerManager.updateCompereRunnersLiveTrial(runner1, runner2, runner3);
                this.vmixIndividual.updateInput(this.runnerManager.getCompereRunnersLiveTrial());
            } catch (ErrorRequest e) {
                System.out.println("Error connecting to Vmix! Data not updated");
            }catch (NullPointerException e) {
                System.out.println("Error updating individual, Runner not found");
            }

        }
    }
}
