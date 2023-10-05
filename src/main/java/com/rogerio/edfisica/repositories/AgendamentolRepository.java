package com.rogerio.edfisica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogerio.edfisica.model.AgendamentoSala;
import com.rogerio.edfisica.model.RequisicaoMaterial;
@Repository
public interface AgendamentolRepository extends JpaRepository<AgendamentoSala, Long>{

}
