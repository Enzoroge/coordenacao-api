package com.rogerio.edfisica.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.edfisica.model.Material;
import com.rogerio.edfisica.model.RequisicaoMaterial;
import com.rogerio.edfisica.model.Usuario;
import com.rogerio.edfisica.repositories.MaterialRepository;
import com.rogerio.edfisica.repositories.RequisicaoMaterialRepository;
import com.rogerio.edfisica.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private RequisicaoMaterialRepository requisicaoMaterialRepository;
	
	
	public void instaciaDB() {
		
		
		
	
			
			Usuario u1 = new Usuario(null, "Rogerio Pereira de Lima", "rogerio@yahoo", "1933190");
			Material m1 = new Material(null, "Bola de futsal", 20);
			RequisicaoMaterial r1 = new RequisicaoMaterial(null, "bola", 10, u1, m1);
			
//				u1.getList1().add(r1);
//				m1.getList1().add(r1);
				
				usuarioRepository.saveAll(Arrays.asList(u1));
				materialRepository.saveAll(Arrays.asList(m1));
				requisicaoMaterialRepository.saveAll(Arrays.asList(r1));
		
		
	

		
	}

}
