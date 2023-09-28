package com.lallucana.API.Business.LiveTrial.Runner;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Runner Live Trail class
 */
@JsonIgnoreProperties({"pass", "c", "nat"})

public class RunnerLiveTrial {

    @JacksonXmlProperty(localName = "doss")
    private Integer dorsal;
    @JacksonXmlProperty(localName = "prenom")
    private String name;
    @JacksonXmlProperty(localName = "nom")
    private String surname;
    @JacksonXmlProperty(localName = "sx")

    private String sex;
    @JacksonXmlProperty(localName = "club")
    private String club;

    @JacksonXmlProperty(localName = "pays")
    private String country;
    @JacksonXmlProperty(localName = "cio")
    private String cio;
    @JacksonXmlProperty(localName = "cat")
    private String category;
    @JacksonXmlProperty(localName = "ph")
    private String ph;

    @JacksonXmlProperty(localName = "lastpt")
    private Integer lastPoint;
    @JacksonXmlProperty(localName = "lasth")
    private String lastHour;
    @JacksonXmlProperty(localName = "lastj")
    private Integer lastJ;
    @JacksonXmlProperty(localName = "tps")
    private String time;
    @JacksonXmlProperty(localName = "idpt")
    private Integer idPoint;
    @JacksonXmlProperty(localName = "nextpt")
    private Integer nextPoint;
    @JacksonXmlProperty(localName = "nexth")
    private Integer nextHour;
    @JacksonXmlProperty(localName = "nextj")
    private Integer nextJ;
    @JacksonXmlProperty(localName = "finish")
    private Integer finish;
    @JacksonXmlProperty(localName = "index")
    private Integer index;

    private String speed;
    private String distance;
    private String gapTime;
    private String gapDistance;


    public Integer getDorsal(){
        return this.dorsal;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getSex(){
        return this.sex;
    }
    public String getDistance(){
        return this.distance;
    }
    public String getSpeed(){
        return this.speed;
    }
    public String getGapTime(){
        return this.gapTime;
    }
    public String getGapDistance(){
        return this.gapDistance;
    }

    public String getClub(){
        return this.club;
    }
    public String getCountry(){
        return this.country;
    }
    public String getCio(){
        return this.cio;
    }

    public String getTime(){
        return this.time;
    }
    public void  setSpeed(String speed){
        this.speed = speed;
    }
    public void setDistance(String distance){
        this.distance = distance;
    }
    public void setGapTime(String gapTime){
        this.gapTime = gapTime;
    }
    public void setGapDistance(String gapDistance){
        this.gapDistance = gapDistance;
    }


    @Override
    public String toString(){
        return "Runner: \n" + "Dorsal: " + this.dorsal + "\n" + "Name: " + this.name + "\n" + "Surname: " + this.surname + "\n" + "Sex: " + this.sex + "\n" + "Club: " + this.club + "\n" + "Country: " + this.country + "\n" + "CIO: " + this.cio + "\n" + "Category: " + this.category + "\n" + "PH: " + this.ph + "\n" + "Last Point: " + this.lastPoint + "\n" + "Last Hour: " + this.lastHour + "\n" + "Last J: " + this.lastJ + "\n" + "Time: " + this.time + "\n" + "ID Point: " + this.idPoint + "\n" + "Next Point: " + this.nextPoint + "\n" + "Next Hour: " + this.nextHour + "\n" + "Next J: " + this.nextJ + "\n" + "Finish: " + this.finish + "\n" +this.speed + "\n" + this.distance + "\n" + this.gapTime + "\n" + this.gapDistance + "\n";
    }
}
