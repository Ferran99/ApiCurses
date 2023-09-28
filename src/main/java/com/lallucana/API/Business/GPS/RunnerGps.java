package com.lallucana.API.Business.GPS;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Runner GPS class
 */
public class RunnerGps {
    @JsonProperty("order")
    Integer order;
    @JsonProperty("name")
    String  name;

    @JsonProperty("dist")
    String dist;

    @JsonProperty("speed")
    String speed;
    @JsonProperty("gap_time")
    String gapTime;
    @JsonProperty("gap_dist")
    String gapDistance;

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
        return this.gapTime;
    }

    public String getGapDistance(){
        return this.gapDistance;
    }

    @Override
    public String toString(){
        return "RunnerGps{" +
                "order=" + order +
                ", name=" + name +
                ", distance=" + dist +
                ", speed=" + speed +
                ", gapTime=" + gapTime +
                ", gapDistance=" + gapDistance +
                '}';
    }
}
