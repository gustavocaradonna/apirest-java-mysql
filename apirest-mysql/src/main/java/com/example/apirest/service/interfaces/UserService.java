package com.example.apirest.service.interfaces;

import com.example.apirest.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    User save(User user);
    Optional<User> get(Integer id);
    void delete(Integer id);
    List<User> devolverImpares();
    List<User> devolverPares();
    List<User> buscarPorNombre(String nombre);
    User buscarPorUserName(String nombre);

}
