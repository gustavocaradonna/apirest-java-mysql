package com.example.apirest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoggedInController {

    @GetMapping("/loggedin")
    public String showLoggedInPage() {
        return "loggedin"; // Esto retornará el archivo loggedin.html desde src/main/resources/static
    }

}
