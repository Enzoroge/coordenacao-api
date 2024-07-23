package com.rogerio.edfisica.model;

public enum Status {
	
	AGUARDANDO(0,"aguardando"),
	RECEBIDO(1, "separado"),
	ATENDIDO(2, "atendido");
	
	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
				
	}
	
	private Integer cod;
	private String descricao;
	public Integer getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for (Status x : Status.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status invalido" + cod);
	}
	
	

}

