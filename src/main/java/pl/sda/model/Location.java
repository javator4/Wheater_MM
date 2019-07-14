package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private double localtime_epoch;
    private String localtime;
}
