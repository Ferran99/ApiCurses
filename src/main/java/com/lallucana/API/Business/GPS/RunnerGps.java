package com.lallucana.API.Business.GPS;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Runner GPS class
 */
public class    RunnerGps {
    @JsonProperty("order")
    Integer order;
    @JsonProperty("name")
    String  name;

    @JsonProperty("dist")
    String dist;

    @JsonProperty("speed")
    String speed;
    @JsonProperty("gap_time")
    String gap_time;
    @JsonProperty("gap_dist")
    String gap_dist;

    public Integer getOrder(){
        return this.order;
    }

    public String getName(){
        return this.name;
    }

    public Integer getDorsal(){
        return Integer.valueOf(this.name);
    }

    public String getSpeed(){
        return this.speed;
    }

    public String getDist(){
        return this.dist;
    }

    public String getGapTime(){
        return this.gap_time;
    }

    public String getGapDistance(){
        return this.gap_dist;
    }

    @Override
    public String toString(){
        return "RunnerGps{" +
                "order=" + order +
                ", name=" + name +
                ", distance=" + dist +
                ", speed=" + speed +
                ", gapTime=" + gap_time +
                ", gapDistance=" + gap_dist +
                '}';
    }
}
