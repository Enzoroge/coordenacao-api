package com.rogerio.edfisica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogerio.edfisica.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{

}
