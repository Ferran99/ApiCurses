package com.lallucana.LaLlucanaLiveTrack.Presentation.Controller.HTTP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

@Controller
public class HttpController implements HttpObservable {

    @GetMapping("/top")
    public String updateTop(
            @RequestParam(value = "number", defaultValue = "10") Integer number,
            @RequestParam(value = "genre", defaultValue = "m") String genre) {

        new Thread(() -> updateRunners(genre.toUpperCase(), number)).start();

        return String.format("Updating %s %d!", genre, number);
    }
    @PostMapping("/compare-runners")
    public ResponseEntity<Map<String, String>> compareRunners(@RequestBody Map<String, Object> requestBody) {
        Integer doss1 = (Integer) requestBody.get("runner1");
        Integer doss2 = (Integer) requestBody.get("runner2");
        Integer doss3 = (Integer) requestBody.get("runner3");
        System.out.println(doss1 + " " + doss2 + " " + doss3);
        new Thread(() -> updateHttpCompereRunners(doss1, doss2, doss3)).start();
        Map<String, String> response = Collections.singletonMap("message", "Runners get it");
        return ResponseEntity.ok(response);
    }

    private void updateRunners(String genre, Integer number) {

        this.updateHttp(genre, number);

    }

    /**
     * Update http.
     *
     * @param genre  the genre of the runners
     * @param number the number of runners
     */
    @Override
    public void updateHttp(String genre, Integer number) {
        for (HttpObserver httpObserver : this.httpObservers) {
            switch (number) {
                case 10:
                    httpObserver.updateHttpTop10(genre);
                    break;
                case 5:
                    httpObserver.updateHttpTop5(genre);
                    break;
                case 3:
                    httpObserver.updateHttpTop3(genre);
                    break;
            }

        }
    }

    /**
     * Update compare runners
     *
     * @param doss1 the dorsal of runner1
     * @param doss2 the dorsal of runner2
     * @param doss3 the dorsal
     */
    @Override
    public void updateHttpCompereRunners(Integer doss1, Integer doss2, Integer doss3) {


        for (HttpObserver httpObserver : this.httpObservers) {
            httpObserver.updateCompareRunners(doss1, doss2, doss3);
        }
    }

}
