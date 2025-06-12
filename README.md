Weather Telegram Bot
   A Java-based Telegram bot that fetches real-time weather data from OpenWeatherMap and suggests activities based on the weather.
Features

Responds to weather in [city] with current weather (temperature and condition).
Suggests activities (e.g., "Great day for a walk!" or "Stay indoors with a movie").
Uses OpenWeatherMap’s free API.

Setup Locally

Install JDK 17 and Maven Daemon (mvnd) from mvnd.io.
Clone this repository:git clone https://github.com/Nuii-tekky/WeatherBot.git
cd weather-bot


Create a .env file in the project root:BOT_TOKEN=your_telegram_bot_token
API_KEY=your_openweathermap_api_key


Run:mvnd clean package
java -jar target/weather-bot-1.0.0-shaded.jar



Deployment on Render (Free Tier)

Sign up at Render and connect your GitHub account.
Create a Web Service:
Select your weather-bot repository.
Set Runtime to Java.
Build Command: mvnd clean package.
Start Command: java -jar target/weather-bot-1.0.0-shaded.jar.
Instance Type: Free.


Add environment variables in Render’s dashboard:
BOT_TOKEN: Your Telegram bot token.
API_KEY: Your OpenWeatherMap API key.


Deploy and test your bot in Telegram.

Usage

In Telegram, send /start to your bot.
Send weather in [city] (e.g., weather in London).

Dependencies

TelegramBots 6.8.0
org.json 20231013
java-dotenv 5.2.2
logback-classic 1.4.11
maven-shade-plugin 3.4.1

