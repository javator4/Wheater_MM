package pl.sda;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import pl.sda.model.Current;
import pl.sda.model.Location;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String url;
    private String apiKey;
    private String finalURL;


    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
        this.finalURL = this.url + "?key=" + this.apiKey + "&q=";

    }

    public Current getCityWheather(String city) {
        this.finalURL = this.finalURL + city;
        System.out.println(finalURL);
        try {
            String data = IOUtils.toString(new URL(this.finalURL), Charset.forName("UTF-8"));
            JSONObject jsonObject = new JSONObject(data);
            String tempC = jsonObject.getJSONObject("current").get("temp_c").toString();
            String windKph = jsonObject.getJSONObject("current").get("wind_kph").toString();

            Current current = new Current();
            current.setWind_dir(jsonObject.getJSONObject("current").get("wind_dir").toString());
            current.setTemp_c(Float.parseFloat(tempC));
            current.setWind_kph(Double.parseDouble(windKph));
            return current;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }







}
