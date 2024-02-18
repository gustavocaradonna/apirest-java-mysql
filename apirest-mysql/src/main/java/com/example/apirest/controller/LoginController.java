package com.example.apirest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Aquí puedes realizar la lógica de autenticación

        // Por ejemplo, podrías verificar si el usuario y la contraseña son válidos
        if ("usuario".equals(username) && "contraseña".equals(password)) {
            // Si las credenciales son válidas, puedes redirigir al usuario a la página de éxito
            System.out.println("Datos correctos");
            return "success";
        } else {
            // Si las credenciales son inválidas, puedes devolver un mensaje de error
            System.out.println("Datos erroneos");
            return "error";
        }
    }
}