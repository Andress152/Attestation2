import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class WeatherTest extends TestBase {
    @BeforeAll
    public static void setUp() {
        Specific.installRequestSpecification
                (Specific.requestSpec(URL));
    }

    protected final String validQuery = "Moscow";
    protected final String validId = "524901";
    protected final String validLat = "37";
    protected final String validLon = "55";
    protected final String validZip = "90370";
    protected final String validUnits = "standard";
    protected final String validLang = "RU";
    protected final String validMode = "json";


    @Test
    void weatherValId() {
        Specific.installResponseSpecification(Specific.responseSpec());
        Map<String, String> data = new HashMap<>();
        data.put("q", validQuery);
        data.put("Lat", validLat);
        data.put("Lon", validLon);
        data.put("zip", validZip);
        data.put("units", validUnits);
        data.put("lang", validLang);
        data.put("mode", validMode);

        WeatherResponse Response = given()
                .queryParams(data)
                .when()
                .get("/weather")
                .then()
                .statusCode(200)
                .extract()
                .as(WeatherResponse.class);
    }

    @Test
    void Veathervalid() {
        Specific.installResponseSpecification(Specific.responseSpec());
        Map<String, String> data = new HashMap<>();
        data.put("q", validQuery);
        data.put("Id", validId);
        data.put("Lat", validLat);
        data.put("Lon", validLon);
        data.put("zip", validZip);
        data.put("units", validUnits);
        data.put("lang", validLang);
        data.put("mode", validMode);

        given()
                .queryParams(data)
                .when()
                .get("/weather")
                .then()
                .statusCode(200)
                .extract()
                .as(WeatherResponse.class);
    }


    @Test
    void weatherWithoutZip() {
        Specific.installResponseSpecification(Specific.responseSpec());
        Map<String, String> data = new HashMap<>();
        data.put("q", validQuery);
        data.put("Id", validId);
        data.put("Lat", validLat);
        data.put("Lon", validLon);
        data.put("units", validUnits);
        data.put("lang", validLang);
        data.put("mode", validMode);
        WeatherResponse weatherResponse = given()
                .queryParams(data)
                .when()
                .get("/weather")
                .then()
                .statusCode(200)
                .extract()
                .as(WeatherResponse.class);
    }
    @Test
    void WeatherUnits() {
        Specific.installResponseSpecification(Specific.responseSpec());
        Map<String, String> data = new HashMap<>();
        data.put("q", validQuery);
        data.put("Id", validId);
        data.put("Lat", validLat);
        data.put("Lon", validLon);
        data.put("zip", validZip);
        data.put("lang", validLang);
        data.put("mode", validMode);

        given()
                .queryParams(data)
                .when()
                .get("/weather")
                .then()
                .statusCode(200)
                .extract()
                .as(WeatherResponse.class);
    }

    @Test
    void WeatherLat() {
        Specific.installResponseSpecification(Specific.responseSpec());
        Map<String, String> data = new HashMap<>();
        data.put("q", validQuery);
        data.put("Id", validId);
        data.put("Lon", validLon);
        data.put("zip", validZip);
        data.put("units", validUnits);
        data.put("lang", validLang);
        data.put("mode", validMode);
        WeatherResponse weatherResponse = given()
                .queryParams(data)
                .when()
                .get("/weather")
                .then()
                .statusCode(200)
                .extract()
                .as(WeatherResponse.class);
    }

    @Test
    void InvalidJson() {
        Specific.installResponseSpecification(Specific.responseSpecBad());

        given()
                .when()
                .get("/weather")
                .then()
                .statusCode(400);
    }
    @Test
    void WeatherNotfoundInvalidCityname() {
        Specific.installResponseSpecification(Specific.responseSpecNotFound());
        Map<String, String> data = new HashMap<>();

        data.put("q", validQuery);

        RequestGet.ResponseError weatherResponse = given()
                .queryParams(data)
                .when()
                .get("/weather")
                .then()
                .statusCode(404)
                .extract()
                .as(RequestGet.ResponseError.class);
    }
    @Test
    void WeatherNotfoundInvalidCitynameandCityId() {
        Specific.installResponseSpecification(Specific.responseSpecNotFound());
        Map<String, String> data = new HashMap<>();

        data.put("q", validQuery);
        data.put("Id", validId);

        RequestGet.ResponseError
                weatherResponse = given()
                .queryParams(data)
                .when()
                .get("/weather")
                .then()
                .statusCode(404)
                .extract()
                .as(RequestGet.ResponseError.class);
    }
}