package vn.edu.hcmut.cse.adse.lab.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @PostConstruct
    public void init() {
        System.out.println(">>> HomeController loaded <<<");
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}