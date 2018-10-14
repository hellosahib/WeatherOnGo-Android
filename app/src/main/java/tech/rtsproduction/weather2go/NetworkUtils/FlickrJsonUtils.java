package tech.rtsproduction.weather2go.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class FlickrJsonUtils {

    public static String getPhotoURL(String rawData){
        String url_m = null;
        try{
            JSONObject rawObject = new JSONObject(rawData);
            JSONObject photosObject = rawObject.getJSONObject("photos");
            Integer totalPhotos = photosObject.getInt("perpage");
            Random random = new Random();
            Integer photoNumber = random.nextInt(totalPhotos);
            JSONArray photoArray = photosObject.getJSONArray("photo");
            JSONObject photoObject = photoArray.getJSONObject(photoNumber);
            url_m = photoObject.optString("url_m");
        }catch (JSONException e){
            e.printStackTrace();
        }
        return url_m;
    }
}
