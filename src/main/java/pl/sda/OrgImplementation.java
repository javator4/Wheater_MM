package pl.sda;

import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

public class OrgImplementation implements WeatherForecast{

    private WeatherService weatherService;
    private String city;

    public OrgImplementation (WeatherService weatherService, String city){
        this.weatherService = weatherService;
        this.city = city;

    }


    @Override
    public Weather getWeather() {

        JSONObject jsonObject = new JSONObject(this.weatherService.getJsonData(this.city));
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
}
