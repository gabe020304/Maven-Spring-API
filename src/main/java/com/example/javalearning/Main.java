package com.example.javalearning;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        ResponseEntity<String> responseEntity = fetchWeatherData();
        displayWeatherInfo(responseEntity.getBody());
    }

    public static ResponseEntity<String> fetchWeatherData() {
        return getWeatherData();
    }

    private static ResponseEntity<String> getWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "Your API Key Goes Here";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?zip=84107,us&appid=" + apiKey;
        return restTemplate.getForEntity(apiUrl, String.class);
    }

    private static void displayWeatherInfo(String weatherJson) {
        System.out.println("Weather Data:");
        System.out.println(weatherJson);
    }
}
