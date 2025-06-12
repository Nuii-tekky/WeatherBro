package com.weatherbot;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    private static final String API_KEY;
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    static {
        Dotenv dotenv = Dotenv.load();
        API_KEY = dotenv.get("API_KEY");
    }

    public WeatherData getWeather(String city) throws Exception {
        String urlString = String.format(API_URL, city, API_KEY);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("API error: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject json = new JSONObject(response.toString());
        String condition = json.getJSONArray("weather").getJSONObject(0).getString("main");
        double temperature = json.getJSONObject("main").getDouble("temp");

        return new WeatherData(condition, temperature);
    }
}