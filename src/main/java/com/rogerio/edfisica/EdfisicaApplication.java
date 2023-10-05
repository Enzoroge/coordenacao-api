package com.rogerio.edfisica;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rogerio.edfisica.model.Material;
import com.rogerio.edfisica.model.RequisicaoMaterial;
import com.rogerio.edfisica.model.Usuario;
import com.rogerio.edfisica.repositories.MaterialRepository;
import com.rogerio.edfisica.repositories.RequisicaoMaterialRepository;
import com.rogerio.edfisica.repositories.UsuarioRepository;

@SpringBootApplication
public class EdfisicaApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(EdfisicaApplication.class, args);
	}

	
}
