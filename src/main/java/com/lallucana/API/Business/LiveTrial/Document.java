package com.lallucana.API.Business.LiveTrial;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.lallucana.API.Business.LiveTrial.Runner.RunnerLiveTrial;

import java.util.List;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * Document Live Trail class
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Document {
    @JacksonXmlProperty(localName = "points")
    private List<Point> points;
    @JacksonXmlProperty(localName = "lst")
    private List<RunnerLiveTrial> runners;


    /**
     * Gets points.
     * @return the list of points
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * Gets runners.
     * @return the list of runners
     */
    public List<RunnerLiveTrial> getRunners() {
        return runners;
    }

    /**
     * Gets runners information.
     * @return
     */
    public List<RunnerLiveTrial> getRunnersInformation() {
        return !this.runners.toString().isEmpty() ? this.runners : null;
    }
}
