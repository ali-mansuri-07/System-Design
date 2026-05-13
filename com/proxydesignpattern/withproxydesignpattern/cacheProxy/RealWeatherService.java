package com.proxydesignpattern.withproxydesignpattern.cacheProxy;

class RealWeatherService implements WeatherService {
    @Override
    public String getWeather(String city) {
        System.out.println("Fetching weather from API for: " + city);
        return "Sunny, 25°C"; // simulate API call
    }
}
