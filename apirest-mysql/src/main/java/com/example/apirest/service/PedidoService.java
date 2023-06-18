package com.example.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.entity.Pedido;
import com.example.apirest.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> findAll() {

		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> get(Integer id) {
		return pedidoRepository.findById(id);
	}
	
}
