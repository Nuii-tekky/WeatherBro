package com.weatherbot;

public class ActivitySuggester {
    public String suggestActivity(WeatherData weather) {
        String condition = weather.getCondition().toLowerCase();
        double temp = weather.getTemperature();
        String suggestion;

        if (condition.contains("clear") || condition.contains("clouds")) {
            suggestion = "It’s a great day for a walk or picnic!";
        } else if (condition.contains("rain") || condition.contains("thunderstorm")) {
            suggestion = "Rainy day—try a movie or book indoors!";
        } else {
            suggestion = "Weather’s unusual—maybe try something new!";
        }

        if (temp < 10) {
            suggestion += " Wear a warm jacket!";
        } else if (temp > 25) {
            suggestion += " Stay hydrated and use sunscreen!";
        }

        return suggestion;
    }
}