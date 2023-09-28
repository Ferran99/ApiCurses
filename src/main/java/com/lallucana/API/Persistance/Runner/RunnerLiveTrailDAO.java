package com.lallucana.API.Persistance.Runner;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lallucana.API.Business.LiveTrial.Document;
import com.lallucana.API.Persistance.HttpRequest;

import java.io.IOException;

/**
 * Created by Ferran Castañé on 23/09/2023.
 * RunnerLiveTrail class
 */
public class RunnerLiveTrailDAO extends HttpRequest implements RunnerDAO {


    /**
     * getRunners method for the RunnerDAO
     *
     * @param raceUrl the race
     * @return LiveTrail Document
     */
    @Override
    public Object getRunners(String raceUrl) {
        try {
            return parseXML(this.getUrl(raceUrl));
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Parse xml document.
     * @param xmlContent the xml content
     * @return the document object (runners and points)
     */
    private Document parseXML(String xmlContent) {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            return xmlMapper.readValue(xmlContent, Document.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
