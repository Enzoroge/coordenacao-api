package com.rogerio.edfisica.model;

public record RegisterDTO(String email, String senha, UserRole role, String nome, String matricula) {
}
