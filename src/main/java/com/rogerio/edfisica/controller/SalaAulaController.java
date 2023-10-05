package com.rogerio.edfisica.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rogerio.edfisica.model.SalaAula;
import com.rogerio.edfisica.service.SalaAulaService;
@CrossOrigin("*")
@RestController
@RequestMapping(value ="/salas")
public class SalaAulaController {
	
	@Autowired
	private SalaAulaService salaAulaService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<SalaAula> findById(@PathVariable Long id){
		SalaAula obj = salaAulaService.findById(id);
		return ResponseEntity.ok().body(obj);

	}
	
	@GetMapping
	public ResponseEntity<List<SalaAula>> findAll(){
		List <SalaAula> list = salaAulaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	@PostMapping
	public ResponseEntity<SalaAula> cadastrar(@RequestBody SalaAula obj){
		SalaAula ob = salaAulaService.cadastrar(obj);
		URI uri = 	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ob.getId()).toUri();	
		
		return ResponseEntity.created(uri).body(ob);
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<SalaAula> update(@PathVariable Long id, @RequestBody SalaAula obj){
		SalaAula ob = salaAulaService.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		salaAulaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
