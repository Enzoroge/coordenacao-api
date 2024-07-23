package com.rogerio.edfisica.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogerio.edfisica.model.AgendamentoSala;
import com.rogerio.edfisica.model.SalaAula;
@Repository
public interface AgendamentolRepository extends JpaRepository<AgendamentoSala, Long>{

	boolean existsBySalaAndHoraInicioBetween(SalaAula sala, LocalDateTime horaInicio, LocalDateTime horaFim);

}
