#!/bin/bash

echo "Creating .env file from injected secrets..."

# Convert secrets injected as env vars into a real .env file
echo "BOT_TOKEN=$BOT_TOKEN" > .env
echo "WEATHER_API_KEY=$WEATHERSERVICE_API_KEY" >> .env

echo "Starting your Java app..."
exec java -jar app.jar
