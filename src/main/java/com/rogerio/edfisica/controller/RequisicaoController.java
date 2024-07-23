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

import com.rogerio.edfisica.model.RequisicaoMaterial;
import com.rogerio.edfisica.service.RequisicaoService;

@RestController
@RequestMapping(value="/requisicoes")
public class RequisicaoController {
	
	@Autowired
	private RequisicaoService requisicaoService;
	
	@GetMapping(value="/{id}")
		public ResponseEntity<RequisicaoMaterial> findById(@PathVariable Long id){
		RequisicaoMaterial obj = requisicaoService.findById(id);
			return ResponseEntity.ok().body(obj);
		}
	@GetMapping
	public ResponseEntity<List<RequisicaoMaterial>> findAll(){
		List <RequisicaoMaterial> list = requisicaoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<RequisicaoMaterial> create(@RequestBody RequisicaoMaterial obj){
		obj = requisicaoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<RequisicaoMaterial> update(@PathVariable Long id, @RequestBody RequisicaoMaterial obj){
		RequisicaoMaterial ob = requisicaoService.update(id, obj);
		return ResponseEntity.ok().body(ob);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		requisicaoService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	

}
