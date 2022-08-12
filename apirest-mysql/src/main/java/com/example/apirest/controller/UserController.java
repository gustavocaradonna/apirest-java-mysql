package com.example.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.entity.User;
import com.example.apirest.service.UserService;

@RestController
@RequestMapping("/apirest")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody User user){
		
		userService.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Integer id){
		return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
