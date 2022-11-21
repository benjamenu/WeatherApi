/**
 * This class is used to connect to the openweather API.
 * The data will then be parsed by Gson and stored in those
 * corresponding classes.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetWeatherData {
    private Transcript transcript;
    private Gson gson;
    private HttpClient httpClient;

    public GetWeatherData() {
        transcript = new Transcript();
        gson = new Gson();
        httpClient = HttpClient.newHttpClient();
    }

    /**
     * This method will call a GET request on the OpenWeather API.
     * Gson is then used to parse the json data and stored the values in the
     * Transcript class and Main class. That data is then called.
     *
     * @return Returns the current temperature from the API.
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public double getCurrentTemperature() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.openweathermap.org/data/2.5/weather?lat=35.3837337&lon=-81.3753087&units=imperial&appid=f2fe988eb16f02f9596f6c98fe963ac2"))
                .GET()
                .build();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        transcript = gson.fromJson(getResponse.body(), Transcript.class);
        return transcript.getMain().getTemp();
    }
}
