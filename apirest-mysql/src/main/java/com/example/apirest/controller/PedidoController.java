package com.example.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.entity.Pedido;
import com.example.apirest.service.PedidoService;

@RestController
@RequestMapping("/apirest/pedido")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody Pedido pedido) {
		pedidoService.save(pedido);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Pedido>> findAll() {
		return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Pedido>> findById(@PathVariable Integer id) {
		return new ResponseEntity<>(pedidoService.get(id), HttpStatus.OK);
	}
	

}
