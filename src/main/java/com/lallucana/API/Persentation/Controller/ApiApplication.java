package com.lallucana.API.Persentation.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class ApiApplication implements HttpObservable {

    @GetMapping("/top")
    public String hello(
            @RequestParam(value = "number", defaultValue = "10") Integer number,
            @RequestParam(value = "genre", defaultValue = "m") String genre) {

        new Thread(() -> updateRunners(genre.toUpperCase(), number)).start();

        return String.format("Updating %s %d!", genre, number);
    }

    @GetMapping("/compare")
    public String compare(
            @RequestParam(value = "doss1", defaultValue = "10") Integer doss1,
            @RequestParam(value = "doss2", defaultValue = "10") Integer doss2,
            @RequestParam(value = "doss3", defaultValue = "10") Integer doss3
    ) {
        new Thread(() -> updateHttpCompereRunners(doss1, doss2, doss3)).start();
        return "Runners get it";
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
