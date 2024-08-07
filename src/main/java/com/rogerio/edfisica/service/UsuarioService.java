	package com.rogerio.edfisica.service;
	
	import java.util.List;
	import java.util.Optional;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;
	
	
	
	import com.rogerio.edfisica.model.Usuario;
	import com.rogerio.edfisica.repositories.UsuarioRepository;
	import com.rogerio.edfisica.service.exceptions.ObjectNotFoundException;
	
	@Service
	public class UsuarioService {
		
		@Autowired
		private UsuarioRepository usuarioRepository;
		
		private final PasswordEncoder passwordEncoder;

	    @Autowired
	    public UsuarioService(PasswordEncoder passwordEncoder) {
	        this.passwordEncoder = passwordEncoder;
	    }
		
		public Usuario findById(Long id) {
			Optional<Usuario> obj = usuarioRepository.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
	 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
		}
	
		public List<Usuario> findAll() {
			return usuarioRepository.findAll();
			
		}
		
		public Usuario cadastrar(Usuario obj) {
			//Aqui estou codificando a senha para não ficar publica, gerando um hash
			String senha = passwordEncoder.encode(obj.getSenha());
			
			obj.setSenha(senha);
			
			return usuarioRepository.save(new Usuario(null, obj.getNome(), obj.getEmail(), obj.getMatricula()));
			
		}
	
		public Usuario update(Long id, Usuario obj) {
			Usuario ob = findById(id);
			obj.setNome(obj.getNome());
			obj.setEmail(obj.getEmail());
			
			return usuarioRepository.save(obj);
			
		}
	
		public void delete(Long id) {
			findById(id);
			usuarioRepository.deleteById(id);
			
		}
	
		public Usuario findById(Usuario usuario) {
			// TODO Auto-generated method stub
			return null;
		}
	
		public List<Usuario> findByNomeIgnoreCase(String nome) {
			return usuarioRepository.findByNomeContainingIgnoreCase(nome);
		}
		
		
	
	}
