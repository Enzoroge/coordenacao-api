package com.rogerio.edfisica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerio.edfisica.model.AgendamentoSala;
import com.rogerio.edfisica.model.RequisicaoMaterial;
import com.rogerio.edfisica.repositories.AgendamentolRepository;
import com.rogerio.edfisica.service.exceptions.ObjectNotFoundException;

@Service
public class AgendamentoService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private SalaAulaService salaAulaService;
	
	@Autowired
	private AgendamentolRepository agendamentoRepository;
	
	
	
	public AgendamentoSala findById(Long id) {
		Optional<AgendamentoSala> obj = agendamentoRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException
				("Objeto não encontrado! Id: " + id + ", Tipo: " + AgendamentoSala.class.getName()));
	}

	public List<AgendamentoSala> findAll() {
		return agendamentoRepository.findAll();
		
		
	}

	public AgendamentoSala create(AgendamentoSala obj) {
		return agendamentoRepository.save(obj);
	}
	
	public AgendamentoSala update(Long id, AgendamentoSala obj) {
	AgendamentoSala ob = findById(id);
		ob.setNome(ob.getNome());
		ob.setHoraInicio(ob.getHoraInicio());
		ob.setHoraFim(ob.getHoraFim());
		
		
		return agendamentoRepository.save(obj);
		
	}
	
	/*private AgendamentoSala from(AgendamentoSala obj) {
		AgendamentoSala ob = new AgendamentoSala();
		ob.setId(obj.getId());
		
		ob.setHoraInicio(ob.getHoraInicio());
		ob.getNome(ob.getNome());
		
		Usuario usuario = usuarioService.findById(obj.getUsuario());
		Material mat = salaAulaService.findById (obj.getMaterial());
		
		ob.(mat);
		ob.setUsuario(usuario);
		
		return agendamentoRepository.save(ob);
	}*/
	
	

}
