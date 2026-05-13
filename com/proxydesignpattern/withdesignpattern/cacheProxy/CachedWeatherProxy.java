package com.proxydesignpattern.withdesignpattern.cacheProxy;

// Cache Proxy — avoids repeated API calls
class CachedWeatherProxy implements WeatherService {
    private RealWeatherService          service;
    private java.util.Map<String, String> cache;

    public CachedWeatherProxy() {
        this.service = new RealWeatherService();
        this.cache   = new java.util.HashMap<>();
    }

    @Override
    public String getWeather(String city) {
        if (cache.containsKey(city)) {
            System.out.println("Returning CACHED result for: " + city);
            return cache.get(city);
        }
        String result = service.getWeather(city);
        cache.put(city, result);
        return result;
    }
}
