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
	private int quantidade;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "usuario_nome")
	private Usuario usuario;
	
	
	@ManyToOne
	@JoinColumn(name = "material_nome")
	private Material material;
	
	public RequisicaoMaterial() {
		super();
		this.setStatus(Status.AGUARDANDO);
		
	}
	
	public RequisicaoMaterial(String id) {
		this.id = Long.parseLong(id);
		
	}

	public RequisicaoMaterial(Long id,  int quantidade, Usuario usuario, Material material, Status status) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.usuario = usuario;
		this.material = material;
		this.status = (status == null) ? 0 : status.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}
	
	

}
