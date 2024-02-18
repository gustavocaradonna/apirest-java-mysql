package com.example.apirest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/apirest/login")
public class LoginController {

    @PostMapping("/test")
    @ResponseBody
    public String login(@RequestBody Map<String, String> credentials) {
        // Obtener el usuario y la contraseña de los datos enviados en el cuerpo de la solicitud
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Aquí puedes realizar la lógica de autenticación
        // Por ejemplo, verificar si el usuario y la contraseña son válidos
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