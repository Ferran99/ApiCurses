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
			@RequestParam(value = "genre", defaultValue = "m") String genre)	{
		updateRunners(genre.toUpperCase(),  number);
		return String.format("Updating %s %d!", genre, number);
	}

	private void updateRunners(String genre, Integer number){
		this.updateHttp(genre, number);
	}

	/**
	 * Update http.
	 *
	 * @param genre the genre of the runners
	 * @param number the number of runners
	 */
	@Override
	public void updateHttp(String genre, Integer number) {
		for (HttpObserver httpObserver : this.httpObservers) {
			switch (number){
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
}
