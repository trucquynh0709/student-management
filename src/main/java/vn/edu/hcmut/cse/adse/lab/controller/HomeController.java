package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // Handle root URL and show welcome page
    @GetMapping("/")
    public String index() {
        return "index"; // corresponds to index.html template
    }
}
