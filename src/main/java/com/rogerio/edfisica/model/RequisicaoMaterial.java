package com.rogerio.edfisica.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="requisicao")
public class RequisicaoMaterial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "usuario_nome")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "material_nome")
	private Material material;
	
	public RequisicaoMaterial() {
		super();
		
	}

	public RequisicaoMaterial(Long id, String nome, int quantidade, Usuario usuario, Material material) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.usuario = usuario;
		this.material = material;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequisicaoMaterial other = (RequisicaoMaterial) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
