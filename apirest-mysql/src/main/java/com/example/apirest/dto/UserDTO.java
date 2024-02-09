package com.example.apirest.dto;


/**
 * Description of the class.
 *
 * @author Gustavo Caradonna
 * @since 09/02/2024
 */
public class UserDTO  {
    //atributos que quiero mostrar en mi dto
    private String username;
    private String email;

    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
