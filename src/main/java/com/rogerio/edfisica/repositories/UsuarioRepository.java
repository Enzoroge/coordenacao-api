package com.rogerio.edfisica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogerio.edfisica.model.Usuario;

@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
