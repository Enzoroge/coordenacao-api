package com.rogerio.edfisica.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="nome")
public class Usuario extends Pessoa{

	@OneToMany(mappedBy = "usuario")
	private List<AgendamentoSala> list = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<RequisicaoMaterial> list1 = new ArrayList<>();
	
	public Usuario() {
		super();
		
	}

	public Usuario(Long id, String nome, String email, String matricula) {
		super(id, nome, email, matricula);
		
	}

	public List<AgendamentoSala> getList() {
		return list;
	}

	public void setList(List<AgendamentoSala> list) {
		this.list = list;
	}

	public List<RequisicaoMaterial> getList1() {
		return list1;
	}
	
	
	

}
