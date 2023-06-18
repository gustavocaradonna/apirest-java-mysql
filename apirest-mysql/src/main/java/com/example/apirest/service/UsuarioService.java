package com.example.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.entity.Usuario;
import com.example.apirest.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {

		return usuarioRepository.findAll();
	}

	public Usuario save(Usuario user) {
		return usuarioRepository.save(user);
	}

	public Optional<Usuario> get(Integer id) {
		return usuarioRepository.findById(id);
	}
	

	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}

	// métodos nuevos

	public List<Usuario> devolverImpares() {
		return usuarioRepository.devolverImpares();
	}
	
	public List<Usuario> devolverPares() {
		return usuarioRepository.devolverPares();
	}
	
	public List<Usuario> buscarPorNombre(String nombre) {
		return usuarioRepository.buscarPorNombre(nombre);
	}

//	public List<User> devolverSegunNumero(Integer id) {
//		return userRepository.devolverPares();
//
//	}

}
