package com.rogerio.edfisica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogerio.edfisica.model.SalaAula;

@Repository
public interface SalaAulaRepository extends JpaRepository<SalaAula, Long>{
	
	List<SalaAula> findByNomeContainingIgnoreCase(String nome);

}
