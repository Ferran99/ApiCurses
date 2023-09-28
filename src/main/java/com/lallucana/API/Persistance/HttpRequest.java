package com.lallucana.API.Persistance;


import com.lallucana.API.Persistance.Exceptions.ErrorRequest;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * HttpRequest class
 */
public  class HttpRequest {


    /**
     * Method to get content from a url
     * @param url the url
     * @return String with the content
     */
    public String getUrl(String url) throws ErrorRequest {
        HttpClient client = HttpClient.newHttpClient();
        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }catch (ConnectException e){
            System.out.println("Error connecting to the server");
            throw new ErrorRequest();
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
