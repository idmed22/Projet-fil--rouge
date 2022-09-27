package com.ehealth.payload.request;

import java.util.Date;
import java.util.Set;

public class SignupRequest {
	
	  private String nom;
	  private String prenom;
	
//	  @NotBlank
//	  @Size(min = 3, max = 20)
	  private String username;
	  
//	  @NotBlank
//	  @Size(max = 50)
//	  @Email
	  private String email;
	
	  
//	  @NotBlank
//	  @Size(min = 6, max = 40)
	  private String password;
	  
	  
	  
	  
	  private Set<String> role;
	  
	  private String adresse;
	  private Date dateNaissance;
	  private String gender;
	  private String tel;
	  private String ville;
	  
	  
	  
	  

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

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

	
	  
	  

}
