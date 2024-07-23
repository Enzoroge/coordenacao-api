	package com.rogerio.edfisica.model;
	
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.List;
	import java.util.Objects;
	
	import org.springframework.security.core.GrantedAuthority;
	import org.springframework.security.core.authority.SimpleGrantedAuthority;
	import org.springframework.security.core.userdetails.UserDetails;
	
	import com.fasterxml.jackson.annotation.JsonIgnore;
	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.OneToMany;
	
	
	@Entity
	public class Usuario implements UserDetails{
	
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false)
		private String nome;
		
		@Column(nullable = false, unique = true)
		private String email;
		
	//	@Column(nullable = false, unique = true)
		private String matricula;
		
		@Column(nullable = false, unique = true)
		private String senha;
		
		private UserRole role;
		
		
		
		
		@JsonIgnore
		@OneToMany(mappedBy = "usuario")
		private List<AgendamentoSala> list = new ArrayList<>();
	
	
		
		
		
		  public Usuario(String email, String senha, UserRole role){
		        this.email = email;
		        this.senha = senha;
		        this.role = role.USER;
		    }
		
		  
		  @JsonIgnore
		  @Override
		  public Collection<? extends GrantedAuthority> getAuthorities() {
		      List<GrantedAuthority> authorities = new ArrayList<>();
		      if (this.role == UserRole.ADMIN) {
		          authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		      }
		      authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		      return authorities;
		  }
		
		
		public Usuario() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		 
	
	
	
		public Usuario(String id) {
			if (id != null && !id.isEmpty()) {
		       
			 this.id = Long.parseLong(id);
			}
			
		}
	
	
	
		public Usuario(String nome, String email, String matricula, String senha) {
			super();
			this.nome = nome;
			this.email = email;
			this.matricula = matricula;
			this.senha = senha;
		}
	
	
	
		public Usuario(Long id, String nome, String email, String matricula, String senha) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.matricula = matricula;
			this.senha = senha;
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
	
	
	
		public String getEmail() {
			return email;
		}
	
	
	
		public void setEmail(String email) {
			this.email = email;
		}
	
	
	
		public String getMatricula() {
			return matricula;
		}
	
	
	
		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}
	
	
	
		public String getSenha() {
			return senha;
		}
	
	
	
		public void setSenha(String senha) {
			this.senha = senha;
		}
	
	
	
		public List<AgendamentoSala> getList() {
			return list;
		}
	
	
	
		public void setList(List<AgendamentoSala> list) {
			this.list = list;
		}
	
	
	
		public static long getSerialversionuid() {
			return serialVersionUID;
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
			Usuario other = (Usuario) obj;
			return Objects.equals(id, other.id);
		}
	
	
	
		
	
	
		@Override
		public String getPassword() {
			return senha;
		}
	
	
	
		@Override
		public String getUsername() {
			return email;
		}
	
	
	
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
	
	
	
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
	
	
	
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
	
	
	
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
		
	
	
	
		
	}
