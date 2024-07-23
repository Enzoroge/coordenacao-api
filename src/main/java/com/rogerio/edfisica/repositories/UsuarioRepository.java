package com.rogerio.edfisica.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.rogerio.edfisica.model.Usuario;

@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByNomeContainingIgnoreCase(String nome);
	
	UserDetails findByEmail(String email);

}
