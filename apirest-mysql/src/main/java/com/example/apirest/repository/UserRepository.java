package com.example.apirest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.apirest.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	
	
	@Query("SELECT u FROM User u WHERE MOD(u.id, 2) <> 0")
    List<User> devolverImpares();
	
	@Query("SELECT u FROM User u WHERE MOD(u.id, 2) <> 1")
    List<User> devolverPares();
	
	@Query("SELECT u FROM User u WHERE u.name = :nombre")
	List<User> buscarPorNombre(@Param("nombre")String nombre);
	
	
	
}
