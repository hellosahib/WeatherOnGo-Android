package tech.rtsproduction.weather2go.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import tech.rtsproduction.weather2go.Model.WeatherInfo;

public class DarkSJsonUtils {

    private String rawData;

    public DarkSJsonUtils(String rawData){
        this.rawData = rawData;
    }

    public String getCurrentWeather() throws JSONException{
        JSONObject rawObject = new JSONObject(rawData);
        JSONObject currentObject = rawObject.getJSONObject("currently");
        return currentObject.optString("temperature");
    }

    public ArrayList<WeatherInfo> getDailyWeather() throws JSONException{
        ArrayList<WeatherInfo> data = new ArrayList<>();
        JSONObject rawObject = new JSONObject(rawData);
        JSONObject dailyObject = rawObject.getJSONObject("daily");
        JSONArray dataArray = dailyObject.optJSONArray("daily");
        if(dataArray != null){
            for (int i = 0; i < dataArray.length(); i++) {
                String icon = dataArray.getJSONObject(i).optString("icon");
                String high = dataArray.getJSONObject(i).optString("temperatureHigh");
                String low = dataArray.getJSONObject(i).optString("temperatureLow");
                data.add(new WeatherInfo(icon,high,low));
            }
        }
        return data;
    }
}
