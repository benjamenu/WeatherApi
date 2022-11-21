/**
 * This is our main class that will call the openweather api
 * and then send that information to our database class to be stored.
 */

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class WeatherAPI {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, SQLException {
        GetWeatherData currentWeather = new GetWeatherData();
        Database db = new Database();
        String dateTime = String.valueOf(java.time.LocalDateTime.now());
        double value = currentWeather.getCurrentTemperature();
        db.addToDB(value, dateTime);
    }
}
