package com.example.apirest.controller;

import com.example.apirest.entity.User;
import com.example.apirest.service.interfaces.UserService;
import com.example.apirest.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/apirest/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/test")
    @ResponseBody
    public String login(@RequestBody Map<String, String> credentials) {
        // Obtener el usuario y la contraseña de los datos enviados en el cuerpo de la solicitud
        String userNameForm = credentials.get("username");
        String passwordForm = credentials.get("password");

        String respuesta = null;
        User usuario = userService.buscarPorUserName(userNameForm);
        if (Objects.nonNull(usuario)) {
            boolean claveVerificada = false;
            claveVerificada = verificarClave(usuario, passwordForm);
            if (claveVerificada) {
                respuesta = Utils.SUCCESS;
                enviarMensaje(Utils.MENSAJE_EXITOSO);
            }
        } else {
            respuesta = Utils.ERROR;
            enviarMensaje(Utils.MENSAJE_FALLIDO);
        }
        return respuesta;
    }

    private boolean verificarClave(User usuarioBd, String passwordForm) {
        boolean respuesta = false;
        if(usuarioBd.getPass().equals(passwordForm)){
        respuesta = true;
        }
        return respuesta;
    }

    private void enviarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @GetMapping("/loggedin")
    public String redirectToLoggedInPage() {
        return "redirect:/loggedin.html";
    }

}