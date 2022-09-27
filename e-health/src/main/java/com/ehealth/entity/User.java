package com.ehealth.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="users", uniqueConstraints = { 
	      @UniqueConstraint(columnNames = "username"),
	      @UniqueConstraint(columnNames = "email") 
	    })
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
			@Id
			@Column(name = "id", columnDefinition = "serial")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			
			private String nom;
			private String prenom;
			private String username;
			private String email;
			private String password;
			
			
			
			
			
		    @ManyToMany(fetch = FetchType.EAGER)
			  @JoinTable(
			          name = "user_roles",
			          joinColumns = @JoinColumn(name = "users_id"),   
			          inverseJoinColumns = @JoinColumn(name = "roles_id"))
			 private Set<Role> roles = new HashSet<>();
		    
		    
		    
			
			
			public User() {
				super();
			}
			
			
			
			
			
			public User(String nom, String prenom, 
					 String username, String email ,String password)
					 {
				
				this.nom = nom;
				this.prenom = prenom;
				this.username = username;
				this.email = email;
				this.password = password;
				
				
							}





			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getNom() {
				return nom;
			}

			public void setNom(String nom) {
				this.nom = nom;
			}


			public String getPrenom() {
				return prenom;
			}

			public void setPrenom(String prenom) {
				this.prenom = prenom;
			}


			


			public String getUsername() {
				return username;
			}

			
			public void setUsername(String username) {
				this.username = username;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public Set<Role> getRole() {
				return roles;
			}

			public void setRole(Set<Role> roles) {
				this.roles = roles;
			}

			

			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
//				this.password = new BCryptPasswordEncoder().encode(password);
				this.password = password;
			}
			
			
		
   
}
