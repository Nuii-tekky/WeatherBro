package com.weatherbot;

public class WeatherData {
    private final String condition;
    private final double temperature;

    public WeatherData(String condition, double temperature) {
        this.condition = condition;
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public double getTemperature() {
        return temperature;
    }
}