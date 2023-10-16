package com.lallucana.LaLlucanaLiveTrack;

import com.lallucana.LaLlucanaLiveTrack.Business.GPS.RunnerGpsManager;
import com.lallucana.LaLlucanaLiveTrack.Business.LiveTrial.DocumentManager;
import com.lallucana.LaLlucanaLiveTrack.Business.Race.Race;
import com.lallucana.LaLlucanaLiveTrack.Business.Race.RunnerManager;
import com.lallucana.LaLlucanaLiveTrack.Presentation.Controller.HTTP.HttpController;
import com.lallucana.LaLlucanaLiveTrack.Presentation.Controller.VmixController;
import com.lallucana.LaLlucanaLiveTrack.Presentation.View.VmixIndividual;
import com.lallucana.LaLlucanaLiveTrack.Presentation.View.VmixTop10;
import com.lallucana.LaLlucanaLiveTrack.Presentation.View.VmixTop3;
import com.lallucana.LaLlucanaLiveTrack.Presentation.View.VmixTop5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaLlucanaLiveTrackApplication {

	public static void main(String[] args) {
		String pointUrlUltra = "https://ultrapirineu.livetrail.net/teteCourse.php?course=ultra&cat=scratch&mode=full";
		String startUrlUltra = "https://ultrapirineu.livetrail.net/lstPartants.php?course=ultra&cat=all&mode=full";
		String gpsUrl = "http://192.168.100.100:8000/gps.json";
		String VMIX_SERVER = "http://192.168.100.100:8088";
		String pointUrlMarathon = "https://ultrapirineu.livetrail.net/teteCourse.php?course=ultra&cat=scratch&mode=full";
		HttpController httpController = new HttpController();
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
		VmixController vmixControllerUltra = new VmixController(runnerGpsManager, documentManager, httpController, true,vmixTop10, vmixTop5, vmixTop3M,vmixTop3W, runnerManager, vmixIndividual);

		SpringApplication.run(LaLlucanaLiveTrackApplication.class, args);
	}
}
