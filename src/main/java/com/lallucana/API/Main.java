package com.lallucana.API;

import com.lallucana.API.Business.Race.RunnerManager;
import com.lallucana.API.Persentation.Controller.ApiApplication;
import com.lallucana.API.Persentation.View.*;
import org.springframework.boot.SpringApplication;
import com.lallucana.API.Business.Race.Race;
import com.lallucana.API.Business.LiveTrial.DocumentManager;
import com.lallucana.API.Business.GPS.RunnerGpsManager;
import com.lallucana.API.Persentation.Controller.VmixController;

public class Main {
    public static void main(String[] args) {
        String pointUrlUltra = "https://ultrapirineu.livetrail.net/teteCourse.php?course=ultra&cat=scratch&mode=full";
        String startUrlUltra = "https://penyagolosa.livetrail.net/lstCoureurs.php?course=mim&cat=all&mode=full";
        String gpsUrl = "http://192.168.100.100:8000/gps.json";
        String VMIX_SERVER = "http://192.168.100.100:8088";
        String pointUrlMarathon = "https://ultrapirineu.livetrail.net/teteCourse.php?course=ultra&cat=scratch&mode=full";


        ApiApplication apiApplication = new ApiApplication();
        VmixTop10 vmixTop10 = new VmixTop10(VMIX_SERVER, 8);
        VmixTop5 vmixTop5 = new VmixTop5(VMIX_SERVER, 11);
        VmixTop3 vmixTop3M = new VmixTop3(VMIX_SERVER, 12);
        VmixTop3 vmixTop3W = new VmixTop3(VMIX_SERVER, 13);
        VmixIndividual vmixIndividual = new VmixIndividual(VMIX_SERVER, 4, 5, 9, 10);


        //Create All the Races
        Race ultra = new Race(startUrlUltra,pointUrlUltra, "ULTRA");
        Race marathon = new Race(startUrlUltra, pointUrlMarathon, "MARATHON");
        //Create All the Managers
        DocumentManager documentManager = new DocumentManager(ultra);
        DocumentManager documentManagerMarathon = new DocumentManager(marathon);

        RunnerGpsManager runnerGpsManager = new RunnerGpsManager(gpsUrl);
        RunnerManager runnerManager = new RunnerManager();

        //Create All the Controllers
        VmixController vmixControllerUltra = new VmixController(runnerGpsManager, documentManager, apiApplication, true,vmixTop10, vmixTop5, vmixTop3M,vmixTop3W, runnerManager, vmixIndividual);
        //VmixController vmixControllerMarathon = new VmixController(runnerGpsManager, documentManagerMarathon, apiApplication, true,vmixTop10, vmixTop5, vmixTop3M,vmixTop3W, runnerManager, vmixIndividual);

        SpringApplication.run(ApiApplication.class, args);
    }
}
