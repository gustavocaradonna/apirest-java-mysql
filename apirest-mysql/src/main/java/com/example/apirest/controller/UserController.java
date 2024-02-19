package com.example.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.apirest.dto.UserDTO;
import com.example.apirest.dto.UserListDTO;
import com.example.apirest.service.interfaces.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.entity.User;

@RestController
@RequestMapping("/apirest/usuario")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

//	@PostMapping("/save")
//	public ResponseEntity<Void> save(@RequestBody User user) {
//		userService.save(user);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}

	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
		User user = mapToUser(userDTO); // Método para mapear el DTO a la entidad User
		userService.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	private User mapToUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setAge(userDTO.getAge());
		user.setSalary(userDTO.getSalary());
		user.setActive(userDTO.getActive());
		user.setUserName(userDTO.getUserName());
		user.setPass(userDTO.getPass());

		// Otros campos si es necesario
		return user;
	}
//	@GetMapping("/all")
//	public ResponseEntity<List<User>> findAll() {
//		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//	}

	/**
	 * mismo metodo /all pero con DTO
	 * @param
	 * @return
	 */
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserListDTO> findAll () {
		try {
			List<User> users = userService.findAll();
			List<UserDTO> usersDTO = mapTousersDTO(users); // Método para mapear la lista de usuarios a una lista de DTOs
			UserListDTO userListDTO = new UserListDTO();
			userListDTO.setUsers(usersDTO);
			return new ResponseEntity<>(userListDTO, HttpStatus.OK);
		} catch (DataAccessException e) {
			// Manejar la excepción
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	private List<UserDTO> mapTousersDTO(List<User> users) {
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			userDTO.setAge(user.getAge());
			userDTO.setSalary(user.getSalary());
			userDTO.setActive(user.getActive());
			userDTO.setUserName(user.getUserName());
			userDTO.setPass(user.getPass());
			// Otros campos si es necesario
			usersDTO.add(userDTO);
		}
		return usersDTO;
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Integer id) {
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
	public ResponseEntity<List<User>> devolverImpares() {
		return new ResponseEntity<>(userService.devolverImpares(), HttpStatus.OK);
	}

	// devuelve pares
	@GetMapping("/devolverPares")
	public ResponseEntity<List<User>> devolverPares() {
		return new ResponseEntity<>(userService.devolverPares(), HttpStatus.OK);
	}

	// si paso par devuelve lista de pares, si paso impares devuelve lista de
	// impares
	@GetMapping("/devolverSegunNumero/{id}")
	public ResponseEntity<List<User>> devolverSegunNumero(@PathVariable Integer id) {

		return id % 2 == 0 ? new ResponseEntity<>(userService.devolverPares(), HttpStatus.OK)
				: new ResponseEntity<>(userService.devolverImpares(), HttpStatus.OK);
	}
	
	//buscar usuarios por nombre
	@GetMapping("/buscarPorNombre/{nombre}")
	public ResponseEntity<List<User>> buscarPorNombre(@PathVariable String nombre) {

		return  new ResponseEntity<>(userService.buscarPorNombre(nombre), HttpStatus.OK);
	}
	
	
	
	

}
