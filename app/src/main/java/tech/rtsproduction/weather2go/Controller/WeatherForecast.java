package tech.rtsproduction.weather2go.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import tech.rtsproduction.weather2go.R;

public class WeatherForecast extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);

        recyclerView = findViewById(R.id.rv_forecast_recyclerview);
    }
}
