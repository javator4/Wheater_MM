package pl.sda;

import lombok.Data;
import org.apache.commons.io.IOUtils;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

@Data
public abstract class AbstractJsonData {                //abstrakcyjna klasa (nie mozna z niej stworzyc obiektu)

    private String url;
    private String apiKey;
    private String finalURL;
    private String data = "";
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AbstractJsonData(){
        this.finalURL = this.url + "?key=" + this.apiKey + "&q=";
    }

    public void build(){
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

    abstract Weather getWeather();

}
