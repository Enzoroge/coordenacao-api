package com.rogerio.edfisica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.edfisica.model.Material;
import com.rogerio.edfisica.repositories.MaterialRepository;
import com.rogerio.edfisica.service.exceptions.ObjectNotFoundException;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	public Material findById(Long id) {
		Optional<Material> obj = materialRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
"Objeto não encontrado! Id: " + id + ", Tipo: " + Material.class.getName()));
	}

	public List<Material> findAll() {
		return materialRepository.findAll();
		
	}
	
	public Material cadastrar(Material obj) {
		return materialRepository.save(new Material(null, obj.getNome(), obj.getQuantidade()));
		
	}

	public Material update(Long id, Material obj) {
		Material ob = findById(id);
		obj.setNome(obj.getNome());
		obj.setQuantidade(obj.getQuantidade());
		return materialRepository.save(obj);
		
	}

	public void delete(Long id) {
		findById(id);
		materialRepository.deleteById(id);
		
	}

	public Material findById(Material material) {
		
		return null;
	}

	public List<Material> findByNomeIgnoreCase(String nome) {
		return materialRepository.findByNomeContainingIgnoreCase(nome);
	}

//	public List<Material> findByNome(String nome) {
//		return materialRepository.findByNome(nome);
//	}

//	public Material findByNome(Material obj) {
//		return materialRepository.findByNome(obj);
//	}

//	public Material findByNome(String nome) {
//		return materialRepository.findByNome(nome);
//	}

//	public Material findByNome(Material nome) {
//		return materialRepository.findByNome(nome);
//	}
//	
//	public List<Material> findByNome(String nome) {
//		return materialRepository.findByNomeContainingIgnoreCase(nome);
//	}

//	public List<Material> findByNomeIgnoreCase(String nome) {
//		return materialRepository.findByNomeContainingIgnoreCase(nome);
//	}
//	

}
