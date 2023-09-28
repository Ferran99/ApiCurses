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


	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		this.updateHttp("/top/10/m");
		return String.format("Hello %s!", name);
	}



	/**
	 * Update http.
	 *
	 * @param http the http
	 */
	@Override
	public void updateHttp(String http) {
		for (HttpObserver httpObserver : this.httpObservers) {
			httpObserver.updateHttp(http);
		}
	}
}
