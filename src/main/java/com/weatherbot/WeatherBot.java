package com.weatherbot;

import io.github.cdimascio.dotenv.Dotenv;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class WeatherBot extends TelegramLongPollingBot {
    private final String botUsername = "@WeatherWatchBroBot"; 
    private final WeatherService weatherService;
    private final ActivitySuggester activitySuggester;

    public WeatherBot() {
        super(Dotenv.load().get("BOT_TOKEN"));
        this.weatherService = new WeatherService();
        this.activitySuggester = new ActivitySuggester();
    }
    

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            String response = processMessage(messageText);

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText(response);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private String processMessage(String message) {
        String returntext ;
        if (message.toLowerCase().startsWith("weather in ")) {
            String city = message.substring("weather in ".length()).trim();
            try {
                WeatherData weather = weatherService.getWeather(city);
                String suggestion = activitySuggester.suggestActivity(weather);
                return String.format("Weather in %s: %s, %.1f°C\n%s",
                        city, weather.getCondition(), weather.getTemperature(), suggestion);
            } catch (Exception e) {
                returntext = "Sorry, I couldn’t fetch the weather for " + city + ". Try another city!";
                System.err.println("Error fetching weather: " + e.getMessage());
            }
        }
        else { returntext = "Send 'weather in [city]' to get the weather and activity suggestions." ;}
        return returntext;
    }
}