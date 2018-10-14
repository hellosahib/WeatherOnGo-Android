package tech.rtsproduction.weather2go.NetworkUtils;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class FlickrUtils {

    private static final String BASE_URL = "https://api.flickr.com/services/rest";
    private static final String RESULT_METHOD = "flickr.photos.search";
    private static final String RESULT_FORMAT = "json";
    private static final String RESULT_JSONCALLBACK = "1";
    private static final String RESULT_APIKEY = "cffaac4fa3f2917888d18f7a2e009e14";
    private static final String RESULT_URLEXTRAS = "url_m";

    private static final String PARAMS_METHOD = "method";
    private static final String PARAMS_APIKEY = "api_key";
    private static final String PARAMS_LAT = "lat";
    private static final String PARAMS_LONG = "lon";
    private static final String PARAMS_FORMAT = "format";
    private static final String PARAMS_JSONCALLBACK = "nojsoncallback";
    private static final String PARAMS_EXTRAS = "extras";
    private static final String PARAMS_PAGENUM = "page";

    public static URL buildURL(String latitude,String longitude,@Nullable Integer pageNumber){
        String builderString = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAMS_METHOD,RESULT_METHOD)
                .appendQueryParameter(PARAMS_APIKEY,RESULT_APIKEY)
                .appendQueryParameter(PARAMS_LAT,latitude)
                .appendQueryParameter(PARAMS_LONG,longitude)
                .appendQueryParameter(PARAMS_FORMAT,RESULT_FORMAT)
                .appendQueryParameter(PARAMS_JSONCALLBACK,RESULT_JSONCALLBACK)
                .appendQueryParameter(PARAMS_EXTRAS,RESULT_URLEXTRAS).toString();
        Uri uri = null;
        if(pageNumber != null){
            uri = Uri.parse(builderString).buildUpon()
                    .appendQueryParameter(PARAMS_PAGENUM,pageNumber.toString()).build();
        }else{
            uri = Uri.parse(builderString).buildUpon().build();
        }
        URL url = null;
        try{
            url = new URL(uri.toString());
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Log.e("URL",uri.toString());
        return url;
    }

    public static String getResponseFromHTTP(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream ipStream = urlConnection.getInputStream();
            Scanner sc = new Scanner(ipStream);
            sc.useDelimiter("\\A");
            if (sc.hasNext()) {
                return sc.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    public static Integer getRandomPage(JSONObject rawData){
        JSONObject photosData = rawData.optJSONObject("photos");
        Integer totalPages = photosData.optInt("pages");
        Random random = new Random();
        return random.nextInt(totalPages)+1;
    }






}
