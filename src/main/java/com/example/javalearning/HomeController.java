package com.example.javalearning;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        ResponseEntity<String> responseEntity = Main.fetchWeatherData();
        model.addAttribute("weatherData", responseEntity.getBody());
        return "home";
    }
}
