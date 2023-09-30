package com.lallucana.API.Business.Race;

public class Runner {
    private Integer position;

    private String name;
    private String surname;
    private Integer dorsal;
    private String country;
    private String club;
    private String flag;
    private String time;
    private String sex;
    private String puntDePas;



    public Runner(String name, String surname, Integer dorsal, String country,
                  String club, String flag, String time, String sex,
                  Integer position, String puntDePas){
        this.name = name;
        this.surname = surname;
        this.dorsal = dorsal;
        this.country =  dorsal.equals(1) ? "ESP" : country;
        this.club = club;
        this.flag = dorsal.equals(1) ? "ESP":  flag;
        this.time = time;
        this.sex = sex;
        this.position = position;
        this.puntDePas = puntDePas;
    }

    public String getName() {
        return name.toUpperCase();
    }
    public String getSurname(){return this.surname.toUpperCase();}
    public Integer getDorsal() {
        return dorsal;
    }
    public String getCountry() {
        return country;
    }
    public String getClub() {
        return club;
    }
    public String getFlag() {
        String disc = "E:/Grafismes/2024_Grafismes/07.Flags Square/";
        return disc+flag+".png";
    }

    public String getTime() {
        return time;
    }

    public String getSex(){
        return this.sex;
    }

    public Integer getPosition(){
        return this.position;
    }

    public String getCio() {
        return this.flag;
    }

    public String getPuntDePas(){return this.puntDePas;}
}
