package tech.rtsproduction.weather2go.Controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import tech.rtsproduction.weather2go.NetworkUtils.FlickrJsonUtils;
import tech.rtsproduction.weather2go.NetworkUtils.FlickrUtils;
import tech.rtsproduction.weather2go.R;

public class MainActivity extends AppCompatActivity {

    private TextView mLocation, mTemperature, mWeatherStatus;
    private ImageView mLocationImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocation = findViewById(R.id.tv_main_location);
        mTemperature = findViewById(R.id.tv_main_temprature);
        mWeatherStatus = findViewById(R.id.tv_main_weatherStatus);
        mLocationImage = findViewById(R.id.iv_main_backgroundImage);
        new FlickrTask().execute(FlickrUtils.buildURL("31.6340", "74.8723", null));

    }

    public void setLocationImage(String url) {
        Picasso.get().load(url).into(mLocationImage);
    }

    public class FlickrTask extends AsyncTask<URL, Void, String> {

        String photo_url = null;

        @Override
        protected String doInBackground(URL... urls) {
            String jsonData = null;
            URL pageURL;
            //First Call to get Page Number
            try {
                jsonData = FlickrUtils.getResponseFromHTTP(urls[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
            //Deserialize JSON Data to get Total Page Count
            if (jsonData != null) {
                JSONObject rawData = null;
                try {
                    rawData = new JSONObject(jsonData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //UPDATED CALL FOR SPECIFIC PAGE
                if (rawData != null) {

                    pageURL = FlickrUtils.buildURL("31.6340", "74.8723", FlickrUtils.getRandomPage(rawData));
                    try {
                        jsonData = FlickrUtils.getResponseFromHTTP(pageURL);
                        photo_url = FlickrJsonUtils.getPhotoURL(jsonData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return photo_url;
        }

        @Override
        protected void onPostExecute(String s) {
            setLocationImage(s);
        }

    }//FLICKR TASK


}
