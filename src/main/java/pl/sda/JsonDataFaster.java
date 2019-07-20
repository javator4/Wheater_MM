package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.model.Weather;

import java.io.IOException;

public class JsonDataFaster extends AbstractJsonData {


    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    Weather getWeather() {
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = null;

        try {

            weather = objectMapper.readValue(this.getJsonData(this.city) , Weather.class);

            //objectMapper.writeValue(new File("data.json"), weather);              //zapisuje dane do pliku

            System.out.println("UV: " + weather.getCurrent().getUv());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;

    }
}
