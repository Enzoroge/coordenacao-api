package com.rogerio.edfisica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogerio.edfisica.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{

//	List<Material> findByNome(String nome);

//	Material findByNome(Material obj);

//	Material findByNome(String nome);

	Material findByNome(Material nome);

	List<Material> findByNomeContainingIgnoreCase(String nome);

}
