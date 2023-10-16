package com.lallucana.LaLlucanaLiveTrack.Persistance.Runner;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lallucana.LaLlucanaLiveTrack.Business.GPS.RunnerGps;
import com.lallucana.LaLlucanaLiveTrack.Persistance.Exceptions.ErrorRequest;
import com.lallucana.LaLlucanaLiveTrack.Persistance.HttpRequest;

import java.lang.reflect.Type;
import java.util.List;

public class RunnerGpsDAO extends HttpRequest implements RunnerDAO  {
    /**
     * getRunners method for the RunnerDAO
     *
     * @param raceUrl the race
     * @return ArrayList of Runners
     */
    @Override
    public List<Object> getRunners(String raceUrl) throws ErrorRequest {
        try {
            return readJsonData(this.getUrl(raceUrl));
        }catch (Exception e){
            throw new ErrorRequest();
        }
    }

    /**
     * Read json data list.
     * @param content the content of the json
     * @return the list of objects runner
     */
    private List<Object> readJsonData(String content) throws Exception{

        Gson gson = new Gson();
        try {
            Type type = new TypeToken<List<RunnerGps>>(){}.getType();
            return gson.fromJson(content, type);
        }catch (Exception e){
            throw new ErrorRequest();
        }
    }
}
