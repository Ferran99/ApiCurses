package com.lallucana.LaLlucanaLiveTrack.Business.Race;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Race class
 */
public class Race {
    private String startUrl;
    private String pointsUrl;
    private String name;

    /**
     * Instantiates a new Race.
     *
     * @param startUrl  the start url
     * @param pointsUrl the points url
     * @param name      the name
     */
    public Race(String startUrl, String pointsUrl,String name){
        this.startUrl = startUrl;
        this.pointsUrl = pointsUrl;
        this.name = name;
    }

    /**
     * Gets start url.
     *
     * @return the start url
     */
    public String getStartUrl(){
        return this.startUrl;
    }

    /**
     * Gets points url.
     *
     * @return the points url
     */
    public String getPointsUrl(){
        return this.pointsUrl;
    }

    /**
     * Gets name.
     *
     * @return the name of the race
     */
    public String getName(){
        return this.name;
    }
}