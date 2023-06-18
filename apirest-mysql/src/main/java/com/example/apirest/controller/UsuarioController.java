package com.example.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.entity.Usuario;
import com.example.apirest.service.UsuarioService;

@RestController
@RequestMapping("/apirest/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService userService;

	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody Usuario user) {
		userService.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> findAll() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Usuario>> findById(@PathVariable Integer id) {
		return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
	}

//	@PutMapping("/modify/{id}")
//	public ResponseEntity<Optional<User>> findById1(@PathVariable Integer id){
//		return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
//	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// nuevos métodos

	// devuelve impares
	@GetMapping("/devolverImpares")
	public ResponseEntity<List<Usuario>> devolverImpares() {
		return new ResponseEntity<>(userService.devolverImpares(), HttpStatus.OK);
	}

	// devuelve pares
	@GetMapping("/devolverPares")
	public ResponseEntity<List<Usuario>> devolverPares() {
		return new ResponseEntity<>(userService.devolverPares(), HttpStatus.OK);
	}

	// si paso par devuelve lista de pares, si paso impares devuelve lista de
	// impares
	@GetMapping("/devolverSegunNumero/{id}")
	public ResponseEntity<List<Usuario>> devolverSegunNumero(@PathVariable Integer id) {

		return id % 2 == 0 ? new ResponseEntity<>(userService.devolverPares(), HttpStatus.OK)
				: new ResponseEntity<>(userService.devolverImpares(), HttpStatus.OK);
	}
	
	//buscar usuarios por nombre
	@GetMapping("/buscarPorNombre/{nombre}")
	public ResponseEntity<List<Usuario>> buscarPorNombre(@PathVariable String nombre) {

		return  new ResponseEntity<>(userService.buscarPorNombre(nombre), HttpStatus.OK);
	}
	
	
	
	

}
