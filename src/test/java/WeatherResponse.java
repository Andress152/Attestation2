import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Coordenad coord;
    private Integer visibility;
    private ArrayList<Weather> weather;
    private String base;
    private Integer dt;
    private Sys sys;
    private Integer timezone;
    private Integer Id;
    private String name;
    private Integer cod;


    @Data
    public static class Coordenad {
        private Double Lon;
        private Double Lat;
    }

    @Data
    public static class Weather {
        private Integer Id;
        private String main;
    }


    @Data
    public static class Sys {
        private Integer type;
        private Integer Id;
        private String country;
    }

}
