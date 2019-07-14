package pl.sda.model;

import lombok.Data;

@Data                   //lombok tworzy gettery i settery
public class Weather {

    private Location location;
    private  Current current;





}
