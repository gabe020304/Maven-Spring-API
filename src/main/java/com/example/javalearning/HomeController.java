package com.example.javalearning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        ResponseEntity<String> responseEntity = Main.fetchWeatherData();
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String weatherData = responseEntity.getBody();
            model.addAttribute("weatherData", weatherData);
        } else {
            String errorMessage = "Failed to fetch weather data";
            model.addAttribute("errorMessage", errorMessage);
        }
        return "index";
    }
}
