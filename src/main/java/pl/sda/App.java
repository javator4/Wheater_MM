package pl.sda;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json",
                "0a566d9f9235405fabb82135191307");

        System.out.println( weatherService.getCityWheather("Torun"));


    }
}
