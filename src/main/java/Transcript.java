/**
 * This class is used to hold data that is
 * parsed from Gson.
 */
public class Transcript {
    private String weather_url;
    private String lon;
    private String base;
    private Main main = new Main();

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getWeather_url() {
        return weather_url;
    }

    public void setWeather_url(String weather_url) {
        this.weather_url = weather_url;
    }
}
