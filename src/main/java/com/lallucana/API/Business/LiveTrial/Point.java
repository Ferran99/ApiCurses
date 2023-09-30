package com.lallucana.API.Business.LiveTrial;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Point class
 */
public class Point {

    @JacksonXmlProperty(localName = "idpt")
    private Integer id;
    @JacksonXmlProperty(localName = "n")
    private String name;
    @JacksonXmlProperty(localName = "nc")
    private String alternativeName;

    public Object getId() {
        return this.id;
    }

    public String getName() {
        return this.name.toUpperCase();
    }
}
