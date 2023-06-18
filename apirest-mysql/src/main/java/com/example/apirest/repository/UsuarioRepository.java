package com.example.apirest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.apirest.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	
	
	
	@Query("SELECT u FROM Usuario u WHERE MOD(u.id, 2) <> 0")
    List<Usuario> devolverImpares();
	
	@Query("SELECT u FROM Usuario u WHERE MOD(u.id, 2) <> 1")
    List<Usuario> devolverPares();
	
	@Query("SELECT u FROM Usuario u WHERE u.name = :nombre")
	List<Usuario> buscarPorNombre(@Param("nombre")String nombre);
	
	
	
}
