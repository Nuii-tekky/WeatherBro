Weather Telegram Bot
   A Java-based Telegram bot that fetches real-time weather data from OpenWeatherMap and suggests activities based on the weather.
Features

Responds to weather in [city] with current weather (temperature and condition).
Suggests activities (e.g., "Great day for a walk!" or "Stay indoors with a movie").
Uses OpenWeatherMap’s free API.

Setup Locally

Install JDK 17 and Maven.
Clone this repository:git clone https://github.com/Nuii-tekky/WeatherBro.git
cd weather-bot


Create a .env file in the project root:BOT_TOKEN=your_telegram_bot_token
API_KEY=your_openweathermap_api_key


Run:mvn clean package
java -jar target/weather-bot-1.0.0-shaded.jar



Usage

In Telegram, send /start to your bot.
Send weather in [city] (e.g., weather in London).

Dependencies

TelegramBots 6.8.0
org.json 20231013
java-dotenv 5.2.2
logback-classic 1.4.11
maven-shade-plugin 3.4.1

Upcoming: Deployment on Render
   Instructions for deploying to Render’s free tier will be added soon.
