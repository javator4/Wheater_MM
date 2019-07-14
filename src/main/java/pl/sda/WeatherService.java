package pl.sda;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String url;
    private String apiKey;
    private String finalURL;
    private String data = "";

    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        this.finalURL = this.url + "?key=" + this.apiKey + "&q=";

    }

    public String getJsonData(String city){
        if (data.isEmpty()) {                                      //sprawdza czy metoda juz nie pobrala data(zapobiega kolejnym odpytywaniom tego samego)
            this.finalURL = this.finalURL + city;
            try {
                this.data = IOUtils.toString(new URL(this.finalURL), Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
/*
    public WeatherService getJsonData(String city){
        if (data.isEmpty()) {                                      //sprawdza czy metoda juz nie pobrala data(zapobiega kolejnym odpytywaniom tego samego)
            this.finalURL = this.finalURL + city;
            try {
                this.data = IOUtils.toString(new URL(this.finalURL), Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public Current getCityWheather() {

            JSONObject jsonObject = new JSONObject(data);
            String tempC = jsonObject.getJSONObject("current").get("temp_c").toString();
            String windKph = jsonObject.getJSONObject("current").get("wind_kph").toString();
            String humidity = jsonObject.getJSONObject("current").get("humidity").toString();
            String feelslike = jsonObject.getJSONObject("current").get("feelslike_c").toString();


            Current current = Current.builder()
                    .temp_c(Float.parseFloat(tempC))
                    .wind_kph(Double.parseDouble(windKph))
                    .humidity(Integer.parseInt(humidity))
                    .feelslike_c(Float.parseFloat(feelslike))
                    .build();

//            Current current = new Current();
//            current.setWind_dir(jsonObject.getJSONObject("current").get("wind_dir").toString());
//            current.setTemp_c(Float.parseFloat(tempC));
//            current.setWind_kph(Double.parseDouble(windKph));
            return current;
    }

    public Location getLocation(){

        JSONObject jsonObject = new JSONObject(data);
        String lon = jsonObject.getJSONObject("location").get("lon").toString();
        String lat = jsonObject.getJSONObject("location").get("lat").toString();
        String name = jsonObject.getJSONObject("location").get("name").toString();
        String country = jsonObject.getJSONObject("location").get("country").toString();

        Location location = Location.builder()
                .lon(Double.parseDouble(lon))
                .lat(Double.parseDouble(lat))
                .name(name)
                .country(country)
                .build();
        return location;
    }



    public Weather getWeather(){

        JSONObject jsonObject = new JSONObject(data);
        String lon = jsonObject.getJSONObject("location").get("lon").toString();
        String lat = jsonObject.getJSONObject("location").get("lat").toString();
        String name = jsonObject.getJSONObject("location").get("name").toString();
        String country = jsonObject.getJSONObject("location").get("country").toString();

        String tempC = jsonObject.getJSONObject("current").get("temp_c").toString();
        String windKph = jsonObject.getJSONObject("current").get("wind_kph").toString();
        String humidity = jsonObject.getJSONObject("current").get("humidity").toString();
        String feelslike = jsonObject.getJSONObject("current").get("feelslike_c").toString();

        Location location = Location.builder()
                .lon(Double.parseDouble(lon))
                .lat(Double.parseDouble(lat))
                .name(name)
                .country(country)
                .build();

        Current current = Current.builder()
                .temp_c(Float.parseFloat(tempC))
                .wind_kph(Double.parseDouble(windKph))
                .humidity(Integer.parseInt(humidity))
                .feelslike_c(Float.parseFloat(feelslike))
                .build();

        Weather weather = new Weather();
        weather.setCurrent(current);
        weather.setLocation(location);

        return weather;
    }

 */









}
