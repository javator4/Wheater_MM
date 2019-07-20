package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import pl.sda.model.Current;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {

    private static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("uruchomienie aplikacji");
        logger.warn("warning");
        logger.debug("debug");
        logger.error("error");

        String url = "http://api.apixu.com/v1/current.json?key=0a566d9f9235405fabb82135191307&q=Gdansk";

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "0a566d9f9235405fabb82135191307");


        //Current current = weatherService.getJsonData("Torun").getCityWheather();
/*
        weatherService.getJsonData("Drezno");

        Weather weather = weatherService.getWeather();






        System.out.println("Wilgotność: " + current.getHumidity());
        System.out.println("Predkosc wiatru: " + current.getWind_kph());
        System.out.println("Temperatura: " + current.getTemp_c());
        System.out.println("Temperatura odczuwalna: " + current.getFeelslike_c());


        Location location = weatherService.getJsonData("Torun").getLocation();
        System.out.println("Miasto: " + location.getName());
        System.out.println("Kraj: " + location.getCountry());
        System.out.println("Szerokosc geograficzna: " + location.getLat());
        System.out.println("Dlugosc geograficzna: " + location.getLon());


        ObjectMapper objectMapper = new ObjectMapper();
        try {
          Weather weather = objectMapper.readValue(new URL(url), Weather.class);           //odczytuje dane z URL

          objectMapper.writeValue(new File("data.json"), weather);              //zapisuje dane do pliku

            System.out.println("UV: " + weather.getCurrent().getUv());
        } catch (IOException e) {
            e.printStackTrace();
        }

 */

//WeatherForecast weatherForecast = new OrgImplementation(weatherService, "Athens");
//WeatherForecast weatherForecast1 = new FasterImplementation(weatherService, "Athens");
//
//        System.out.println(weatherForecast.getWeather());
//        System.out.println(weatherForecast1.getWeather());

        JsonDataFaster jsonDataFaster = new JsonDataFaster();
        jsonDataFaster.setUrl("http://api.apixu.com/v1/current.json");
        jsonDataFaster.setApiKey("0a566d9f9235405fabb82135191307");
        jsonDataFaster.setCity("London");
        jsonDataFaster.build();
        System.out.println(jsonDataFaster.getWeather());

        JsonDataOrg jsonDataOrg = new JsonDataOrg();
        jsonDataOrg.setUrl("http://api.apixu.com/v1/current.json");
        jsonDataOrg.setApiKey("0a566d9f9235405fabb82135191307");
        jsonDataOrg.setCity("Paris");
        jsonDataOrg.build();
        System.out.println(jsonDataOrg.getWeather());







    }
}
