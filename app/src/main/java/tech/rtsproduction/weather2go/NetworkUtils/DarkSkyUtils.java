package tech.rtsproduction.weather2go.NetworkUtils;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import tech.rtsproduction.weather2go.BuildConfig;

public class DarkSkyUtils {

    private static final String API_KEY = BuildConfig.DarkSkyAPI;
    private static final String BASE_URL = "https://api.darksky.net/forecast";

    public static URL buildURL(String lat,String lon){
        String builderURL = BASE_URL+"/"+API_KEY+"/"+lat+","+lon;
        Log.e("URL",builderURL);
        URL url = null;
        try{
            url = new URL(builderURL);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponsefromHTTP(URL url) throws IOException{
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
}
