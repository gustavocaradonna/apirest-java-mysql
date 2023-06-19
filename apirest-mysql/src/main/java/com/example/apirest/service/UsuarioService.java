package com.example.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.entity.User;
import com.example.apirest.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<User> findAll() {

		return usuarioRepository.findAll();
	}

	public User save(User user) {
		return usuarioRepository.save(user);
	}

	public Optional<User> get(Integer id) {
		return usuarioRepository.findById(id);
	}
	

	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}

	// métodos nuevos

	public List<User> devolverImpares() {
		return usuarioRepository.devolverImpares();
	}
	
	public List<User> devolverPares() {
		return usuarioRepository.devolverPares();
	}
	
	public List<User> buscarPorNombre(String nombre) {
		return usuarioRepository.buscarPorNombre(nombre);
	}

//	public List<User> devolverSegunNumero(Integer id) {
//		return userRepository.devolverPares();
//
//	}

}
