package com.example.javalearning;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        ResponseEntity<String> responseEntity = Main.getWeatherData();
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String weatherData = responseEntity.getBody();
            String prettyWeatherData = getPrettyPrintedJson(weatherData);
            model.addAttribute("weatherData", prettyWeatherData);
        } else {
            String errorMessage = "Failed to fetch weather data";
            model.addAttribute("errorMessage", errorMessage);
        }
        return "index";
    }

    @GetMapping("/last-thirty-days")
    public String lastThirtyDays(Model model) {
        ResponseEntity<String> responseEntity = Main.getLastThirtyDaysWeatherData();
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String weatherThirtyDaysData = responseEntity.getBody();
            String prettyWeatherThirtyDaysData = getPrettyPrintedJson(weatherThirtyDaysData);
            model.addAttribute("weatherThirtyDaysData", prettyWeatherThirtyDaysData);
        } else {
            String errorMessage = "Failed to fetch weather data";
            model.addAttribute("errorMessage", errorMessage);
        }
        return "last-thirty-days";
    }

    private String getPrettyPrintedJson(String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            return writer.writeValueAsString(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            return jsonData;
        }
    }
}

