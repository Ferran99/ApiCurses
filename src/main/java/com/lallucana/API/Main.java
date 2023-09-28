package com.lallucana.API;

import com.lallucana.API.Business.Race.RunnerManager;
import com.lallucana.API.Persentation.Controller.ApiApplication;
import com.lallucana.API.Persentation.View.Vmix;
import com.lallucana.API.Persentation.View.VmixTop10;
import org.springframework.boot.SpringApplication;
import com.lallucana.API.Business.Race.Race;
import com.lallucana.API.Business.LiveTrial.DocumentManager;
import com.lallucana.API.Business.GPS.RunnerGpsManager;
import com.lallucana.API.Persentation.Controller.VmixController;

public class Main {
    public static void main(String[] args) {
        String pointUrlMarathon = "https://penyagolosa.livetrail.net/teteCourse.php?course=mim&cat=scratch&mode=full";
        String startUrlMarathon = "https://penyagolosa.livetrail.net/lstCoureurs.php?course=mim&cat=all&mode=full";
        String gpsUrl = "http://127.0.0.1:8000/TRANSGRANCANARIA.json";
        String VMIX_SERVER = "http://192.168.100.100:8088";

        ApiApplication apiApplication = new ApiApplication();
        VmixTop10 vmixTop10 = new VmixTop10(VMIX_SERVER, 10);

        //Create All the Races
        Race marathon = new Race(startUrlMarathon,pointUrlMarathon, "MIM");
        //Create All the Managers
        DocumentManager documentManager = new DocumentManager(marathon);

        RunnerGpsManager runnerGpsManager = new RunnerGpsManager(gpsUrl);
        RunnerManager runnerManager = new RunnerManager();

        //Create All the Controllers
        VmixController vmixController = new VmixController(runnerGpsManager, documentManager, apiApplication, true,vmixTop10, runnerManager);
        SpringApplication.run(ApiApplication.class, args);
    }
}
