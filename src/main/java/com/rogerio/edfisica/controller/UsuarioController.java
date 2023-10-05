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

import com.rogerio.edfisica.model.Usuario;
import com.rogerio.edfisica.service.UsuarioService;
@CrossOrigin("*")
@RestController
@RequestMapping(value ="/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = usuarioService.findById(id);
		return ResponseEntity.ok().body(obj);

	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List <Usuario> list = usuarioService.findAll();
		return ResponseEntity.ok().body(list);
	}
	@PostMapping
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario obj){
		Usuario ob = usuarioService.cadastrar(obj);
		URI uri = 	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ob.getId()).toUri();	
		
		return ResponseEntity.created(uri).body(ob);
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
		Usuario ob = usuarioService.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
