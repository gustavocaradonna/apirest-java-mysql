package com.example.apirest.dto;



import java.util.List;
/**
 * Description of the class.
 *
 * @author Gustavo Caradonna
 * @since 09/02/2024
 */

public class UserListDTO {
    private List<UserDTO> users;

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> usersDTO) {
        this.users = usersDTO;
    }

}
