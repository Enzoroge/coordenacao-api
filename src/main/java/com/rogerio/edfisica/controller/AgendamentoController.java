package com.rogerio.edfisica.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rogerio.edfisica.model.AgendamentoSala;
import com.rogerio.edfisica.service.AgendamentoService;


@RestController
@RequestMapping(value="/agendamentos")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@GetMapping(value="/{id}")
		public ResponseEntity<AgendamentoSala> findById(@PathVariable Long id){
		AgendamentoSala obj = agendamentoService.findById(id);
			return ResponseEntity.ok().body(obj);
		}
	@GetMapping
	public ResponseEntity<List<AgendamentoSala>> findAll(){
		List <AgendamentoSala> list = agendamentoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<AgendamentoSala> create(@RequestBody AgendamentoSala agendamento){
		agendamento = agendamentoService.create(agendamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(agendamento.getId()).toUri();
		return ResponseEntity.created(uri).body(agendamento);
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<AgendamentoSala> update(@PathVariable Long id, @RequestBody AgendamentoSala obj){
		AgendamentoSala ob = agendamentoService.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<AgendamentoSala> delete(@PathVariable Long id){
		agendamentoService.delete(id);
		return ResponseEntity.noContent().build();	}
	

}
