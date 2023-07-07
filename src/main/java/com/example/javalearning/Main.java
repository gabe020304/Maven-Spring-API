package com.example.javalearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    static ResponseEntity<String> getWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "API Key";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?zip=84107,us&appid=" + apiKey;
        return restTemplate.getForEntity(apiUrl, String.class);
    }

    static ResponseEntity<String> getLastThirtyDaysWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "API Key";
        String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?zip=84107,us&appid=" + apiKey;
        return restTemplate.getForEntity(apiUrl, String.class);
    }

    private static void displayWeatherInfo(String weatherJson) {
        System.out.println("Weather Data:");
        System.out.println(weatherJson);
    }
}
