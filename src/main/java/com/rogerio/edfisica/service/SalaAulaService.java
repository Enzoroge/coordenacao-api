package com.rogerio.edfisica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.edfisica.model.SalaAula;
import com.rogerio.edfisica.repositories.SalaAulaRepository;
import com.rogerio.edfisica.service.exceptions.ObjectNotFoundException;

@Service
public class SalaAulaService {
	
	@Autowired
	private SalaAulaRepository salaAulaRepository;
	
	public SalaAula findById(Long id) {
		Optional<SalaAula> obj = salaAulaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
"Objeto não encontrado! Id: " + id + ", Tipo: " + SalaAula.class.getName()));
	}

	public List<SalaAula> findAll() {
		return salaAulaRepository.findAll();
		
	}
	
	public SalaAula cadastrar(SalaAula obj) {
		return salaAulaRepository.save(new SalaAula(null, obj.getNome()));
		
	}

	public SalaAula update(Long id, SalaAula obj) {
		SalaAula ob = findById(id);
		obj.setNome(obj.getNome());
		return salaAulaRepository.save(obj);
		
	}

	public void delete(Long id) {
		findById(id);
		salaAulaRepository.deleteById(id);
		
	}

	public List<SalaAula> findByNomeContainingIgnoreCase(String nome) {
		// TODO Auto-generated method stub
		return salaAulaRepository.findByNomeContainingIgnoreCase(nome);
	}

	
	}
	
	


