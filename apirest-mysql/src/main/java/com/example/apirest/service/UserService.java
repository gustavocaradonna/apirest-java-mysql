package com.example.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.entity.User;
import com.example.apirest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public Optional<User> get(Integer id) {
		return userRepository.findById(id);
	}
	

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	// métodos nuevos

	public List<User> devolverImpares() {
		return userRepository.devolverImpares();
	}
	
	public List<User> devolverPares() {
		return userRepository.devolverPares();
	}
	
	public List<User> buscarPorNombre(String nombre) {
		return userRepository.buscarPorNombre(nombre);
	}

//	public List<User> devolverSegunNumero(Integer id) {
//		return userRepository.devolverPares();
//
//	}

}
