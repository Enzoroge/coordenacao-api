package com.rogerio.edfisica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.edfisica.model.Material;
import com.rogerio.edfisica.model.RequisicaoMaterial;
import com.rogerio.edfisica.model.Usuario;
import com.rogerio.edfisica.repositories.MaterialRepository;
import com.rogerio.edfisica.repositories.RequisicaoMaterialRepository;
import com.rogerio.edfisica.repositories.UsuarioRepository;
import com.rogerio.edfisica.service.exceptions.ObjectNotFoundException;

@Service
public class RequisicaoService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private RequisicaoMaterialRepository requisicaoMaterialRepository;
	
	public RequisicaoMaterial findById(Long id) {
		Optional<RequisicaoMaterial> obj = requisicaoMaterialRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException
				("Objeto não encontrado! Id: " + id + ", Tipo: " + RequisicaoMaterial.class.getName()));
	}

	public List<RequisicaoMaterial> findAll() {
		return requisicaoMaterialRepository.findAll();
		
		
	}

	public RequisicaoMaterial create(RequisicaoMaterial obj) {
		return requisicaoMaterialRepository.save(obj);
	}

	public RequisicaoMaterial update(Long id, RequisicaoMaterial obj) {
		RequisicaoMaterial ob = findById(id);
		ob.setNome(ob.getNome());
		ob.setQuantidade(ob.getQuantidade());
		
		
		return requisicaoMaterialRepository.save(obj);
		
	}
	
	/*private RequisicaoMaterial from(RequisicaoMaterial obj) {
		RequisicaoMaterial ob = new RequisicaoMaterial();
		ob.setId(obj.getId());
		
		ob.setQuantidade(obj.getQuantidade());
		ob.setNome(obj.getNome());
		
		Usuario usuario = usuarioService.findById(obj.getUsuario());
		Material mat = materialService.findById (obj.getMaterial());
		
		ob.setMaterial(mat);
		ob.setUsuario(usuario);
		
		return requisicaoMaterialRepository.save(ob);
	}*/
	
	

}
