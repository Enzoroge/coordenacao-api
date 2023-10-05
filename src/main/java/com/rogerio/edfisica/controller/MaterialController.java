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

import com.rogerio.edfisica.model.Material;
import com.rogerio.edfisica.service.MaterialService;
@CrossOrigin("*")
@RestController
@RequestMapping(value ="/materiais")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Material> findById(@PathVariable Long id){
		Material obj = materialService.findById(id);
		return ResponseEntity.ok().body(obj);

	}
	
	@GetMapping
	public ResponseEntity<List<Material>> findAll(){
		List <Material> list = materialService.findAll();
		return ResponseEntity.ok().body(list);
	}
	@PostMapping
	public ResponseEntity<Material> cadastrar(@RequestBody Material obj){
		Material ob = materialService.cadastrar(obj);
		URI uri = 	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ob.getId()).toUri();	
		
		return ResponseEntity.created(uri).body(ob);
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<Material> update(@PathVariable Long id, @RequestBody Material obj){
		Material ob = materialService.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		materialService.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
