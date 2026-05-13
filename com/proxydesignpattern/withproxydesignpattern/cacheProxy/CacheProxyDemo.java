package com.proxydesignpattern.withproxydesignpattern.cacheProxy;

// Main class for demonstrating the cache proxy design pattern
public class CacheProxyDemo {
    public static void main(String[] args) {
        WeatherService weather = new CachedWeatherProxy();

        System.out.println(weather.getWeather("London")); // API call
        System.out.println(weather.getWeather("London")); // cached
        System.out.println(weather.getWeather("Paris"));  // API call
        System.out.println(weather.getWeather("Paris"));  // cached
    }
}
