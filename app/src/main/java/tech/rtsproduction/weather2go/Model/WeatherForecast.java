package tech.rtsproduction.weather2go.Model;
import java.util.ArrayList;

public class WeatherForecast {

    private String currentWeather;

    private ArrayList<WeatherInfo> dailyWeather;

    WeatherForecast(){
        dailyWeather = new ArrayList<>();
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public void addDailyWeather(WeatherInfo s){
        dailyWeather.add(s);
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public ArrayList<WeatherInfo> getDailyWeather() {
        return dailyWeather;
    }
}

