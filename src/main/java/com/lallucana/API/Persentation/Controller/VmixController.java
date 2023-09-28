package com.lallucana.API.Persentation.Controller;


import com.lallucana.API.Business.GPS.RunnerGps;
import com.lallucana.API.Business.GPS.RunnerGpsManager;
import com.lallucana.API.Business.GPS.RunnerGpsObserver;
import com.lallucana.API.Business.LiveTrial.DocumentManager;
import com.lallucana.API.Business.LiveTrial.Runner.RunnerLiveTrailObserver;
import com.lallucana.API.Business.LiveTrial.Runner.RunnerLiveTrial;
import com.lallucana.API.Business.Race.RunnerManager;
import com.lallucana.API.Persentation.View.Vmix;
import com.lallucana.API.Persentation.View.VmixTop10;
import com.lallucana.API.Persistance.Exceptions.ErrorRequest;

import java.util.List;

/**
 * The type Vmix controller.
 */
public class VmixController implements RunnerLiveTrailObserver, RunnerGpsObserver, HttpObserver {
    private Boolean isTop10Man = false;
    private Boolean isTop10Woman = false;
    private Boolean isTop5Man = false;
    private Boolean isTop5Woman = false;
    private Boolean isTop3Man = false;
    private Boolean isTop3Woman = false;

    private final Integer TOP_10 = 10;
    private final Integer TOP_5 = 5;
    private final Integer TOP_3 = 3;

    private final RunnerGpsManager runnerGpsManager;
    private final DocumentManager documentManager;
    private Boolean isLiveTrail = true;
    private VmixTop10 vmixTop10;
    private RunnerManager runnerManager;

    /**
     * Instantiates a new Vmix controller.
     *
     * @param runnerGpsManager the runner gps manager
     * @param documentManager  the document manager
     * @param apiApplication   the simple http server
     * @param isLiveTrail      the is live trail
     */

    public VmixController(RunnerGpsManager runnerGpsManager, DocumentManager documentManager, ApiApplication apiApplication, Boolean isLiveTrail, Vmix vmix, RunnerManager runnerManager) {
        this.runnerGpsManager = runnerGpsManager;
        this.documentManager = documentManager;
        this.runnerGpsManager.addRunnerGpsObserver(this);
        this.documentManager.addRunnerLiveTrailObserver(this);
        apiApplication.addHttpObserver(this);
        this.isLiveTrail = isLiveTrail;
        this.vmixTop10 = (VmixTop10) vmix;
        this.runnerManager = runnerManager;
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
        } else if (isTop3Man || isTop3Woman) {
            //System.out.println(this.documentManager.getRunners(isTop3Man, TOP_3).toString());
        }
    }

    /**
     * Update live trial real time.
     */
    @Override
    public void updateLiveTrialRealTime() {
        List<RunnerLiveTrial> manTop5 = this.documentManager.getRunners(isTop5Man, TOP_5);
        List<RunnerLiveTrial> womanTop5 = this.documentManager.getRunners(isTop5Woman, TOP_5);
        List<RunnerLiveTrial> manTop3 = this.documentManager.getRunners(isTop3Man, TOP_3);
        List<RunnerLiveTrial> womanTop3 = this.documentManager.getRunners(isTop3Woman, TOP_3);
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
     * Update http.
     *
     * @param http the http
     */
    @Override
    public void updateHttp(String http) {
        System.out.println("HTTP request");
        System.out.println(http);
        switch (http) {
            case "/top/10/m":
                isTop10Man = true;
                isTop10Woman = false;
                if (this.isLiveTrail) {
                    this.runnerManager.updateRunnersLiveTrial(this.documentManager.getRunners(isTop10Man, TOP_10));
                    try {
                        this.vmixTop10.updateInput(this.runnerManager.getRunners());
                    } catch (ErrorRequest e) {
                        throw new RuntimeException(e);
                    }
                }

                break;
            case "/top/10/f":
                isTop10Man = false;
                isTop10Woman = true;
                if (this.isLiveTrail) System.out.println(this.documentManager.getRunners(isTop10Man, TOP_10));
                break;
            case "/top/5/m":
                isTop5Man = true;
                isTop5Woman = false;
                if (this.isLiveTrail) System.out.println(this.documentManager.getRunners(isTop10Man, TOP_10));

                break;
            case "/top/5/f":
                isTop5Man = false;
                isTop5Woman = true;
                if (this.isLiveTrail) System.out.println(this.documentManager.getRunners(isTop10Man, TOP_10));

                break;
            case "/top/3/m":
                isTop3Man = true;
                isTop3Woman = false;
                if (this.isLiveTrail) System.out.println(this.documentManager.getRunners(isTop10Man, TOP_10));

                break;
            case "/top/3/f":
                isTop3Man = false;
                isTop3Woman = true;
                if (this.isLiveTrail) System.out.println(this.documentManager.getRunners(isTop10Man, TOP_10));
                break;
        }
    }
}
