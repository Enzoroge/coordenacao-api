package com.rogerio.edfisica.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="agendamento")
public class AgendamentoSala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime horaInicio;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime horaFim;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "sala_id")
	private SalaAula sala;
	
	public AgendamentoSala() {
		super();
		
	}

	public AgendamentoSala(Long id, String nome, LocalDateTime horaInicio, LocalDateTime horaFim, Usuario usuario,
			SalaAula sala) {
		super();
		this.id = id;
		this.nome = nome;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.usuario = usuario;
		this.sala = sala;
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

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalDateTime horaFim) {
		this.horaFim = horaFim;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public SalaAula getSala() {
		return sala;
	}

	public void setSala(SalaAula sala) {
		this.sala = sala;
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
		AgendamentoSala other = (AgendamentoSala) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
