package com.lallucana.API.Business.Race;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Race class
 */
public class Race {
    private String startUrl;
    private String pointsUrl;
    private String name;

    public Race(String startUrl, String pointsUrl,String name){
        this.startUrl = startUrl;
        this.pointsUrl = pointsUrl;
        this.name = name;
    }

    /**
     * Gets start url.
     * @return the start url
     */
    public String getStartUrl(){
        return this.startUrl;
    }

    /**
     * Gets points url.
     * @return the points url
     */
    public String getPointsUrl(){
        return this.pointsUrl;
    }

    /**
     * Gets name.
     * @return the name of the race
     */

    public String getName(){
        return this.name;
    }
}
