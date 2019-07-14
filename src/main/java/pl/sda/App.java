package pl.sda;

import pl.sda.model.Current;
import pl.sda.model.Location;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "0a566d9f9235405fabb82135191307");



        Current current = weatherService.getJsonData("Torun").getCityWheather();

        System.out.println("Wilgotność: " + current.getHumidity());
        System.out.println("Predkosc wiatru: " + current.getWind_kph());
        System.out.println("Temperatura: " + current.getTemp_c());
        System.out.println("Temperatura odczuwalna: " + current.getFeelslike_c());

        Location location = weatherService.getJsonData("Torun").getLocation();
        System.out.println("Miasto: " + location.getName());
        System.out.println("Kraj: " + location.getCountry());
        System.out.println("Szerokosc geograficzna: " + location.getLat());
        System.out.println("Dlugosc geograficzna: " + location.getLon());




    }
}
