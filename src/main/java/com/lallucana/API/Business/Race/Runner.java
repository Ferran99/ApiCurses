package com.lallucana.API.Business.Race;

/**
 * The type Runner.
 */
public class Runner {
    private final Integer position;

    private final String name;
    private final String surname;
    private final Integer dorsal;
    private final String country;
    private final String club;
    private final String flag;
    private final String time;
    private final String sex;
    private final String pointOfPas;
    private String gapDist;


    /**
     * Instantiates a new Runner.
     *
     * @param name      the name
     * @param surname   the surname
     * @param dorsal    the dorsal
     * @param country   the country
     * @param club      the club
     * @param flag      the flag
     * @param time      the time
     * @param sex       the sex
     * @param position  the position
     * @param puntDePas the punt de pas
     */
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
        this.pointOfPas = puntDePas;
    }

    /**
     * Instantiates a new Runner.
     *
     * @param name      the name
     * @param surname   the surname
     * @param dorsal    the dorsal
     * @param country   the country
     * @param club      the club
     * @param flag      the flag
     * @param time      the time
     * @param sex       the sex
     * @param position  the position
     * @param puntDePas the punt de pas
     * @param gapDist   the gap dist
     */
    public Runner(String name, String surname, Integer dorsal, String country,
                  String club, String flag, String time, String sex,
                  Integer position, String puntDePas, String gapDist){
        this.name = name;
        this.surname = surname;
        this.dorsal = dorsal;
        this.country =  dorsal.equals(1) ? "ESP" : country;
        this.club = club;
        this.flag = dorsal.equals(1) ? "ESP":  flag;
        this.time = time;
        this.sex = sex;
        this.position = position;
        this.pointOfPas = puntDePas;
        this.gapDist = gapDist;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name.toUpperCase();
    }

    /**
     * Get surname string.
     *
     * @return the string
     */
    public String getSurname(){return this.surname.toUpperCase();}

    /**
     * Gets dorsal.
     *
     * @return the dorsal
     */
    public Integer getDorsal() {
        return dorsal;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets club.
     *
     * @return the club
     */
    public String getClub() {
        return club;
    }

    /**
     * Gets flag.
     *
     * @return the flag
     */
    public String getFlag() {
        String disc = "E:/Grafismes/2024_Grafismes/07.Flags Square/";
        return disc+flag+".png";
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Get sex string.
     *
     * @return the string
     */
    public String getSex(){
        return this.sex;
    }

    /**
     * Get position integer.
     *
     * @return the integer
     */
    public Integer getPosition(){
        return this.position;
    }

    /**
     * Gets cio.
     *
     * @return the cio
     */
    public String getCio() {
        return this.flag;
    }

    /**
     * Get point of pas string.
     *
     * @return the string
     */
    public String getPointOfPas(){return this.pointOfPas;}

    /**
     * Get gap dist string.
     *
     * @return the string
     */
    public String getGapDist(){return  this.getGapDist();};
}
