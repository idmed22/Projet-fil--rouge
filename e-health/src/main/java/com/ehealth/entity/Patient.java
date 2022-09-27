package com.ehealth.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="patients")
public class Patient extends User {
	             
	            @JsonFormat(pattern="yyyy-MM-dd")
				private Date dateNaissance;
				private String gender;
				private String adresse;
				private String tel;
				private String ville;
		
				public Patient() {
		           super();
	            }

					@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
					@JoinColumn(name = "users_id", insertable = false, updatable = false)
					@JsonIgnore			
			        private User users;

					//@Column(name = "users_Id")
					//private Integer usersId;
			    
			    
			    @ManyToMany(fetch = FetchType.LAZY)
			    @JoinTable(name = "patients_analyses",
		    	        joinColumns = { @JoinColumn(name = "patients_id") },
			    	    inverseJoinColumns = { @JoinColumn(name = "analyses_id") })
			    	    private Set<Analyse> analyses = new HashSet<>();
			    
//			    @OneToMany(mappedBy = "patients", cascade = CascadeType.ALL)
//			    private Set<AnalyseResults> analyseResults = new HashSet<>();
			    
			   
			 
	            
			    public Patient(String nom, String prenom, String username, String email, String password) {
					super(nom, prenom, username, email, password);
					//TODO Auto-generated constructor stub
				}

				
				

				public Patient(String nom, String prenom, String username, String email, String adresse, Date dateNaissance, String gender,
						String tel, String ville,String password
						) {
					super(nom, prenom, username, email, password);
					this.adresse = adresse;
					this.dateNaissance = dateNaissance;
					this.gender = gender;
					this.tel = tel;
					this.ville = ville;
					
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

				public Set<Analyse> getAnalyses() {
					return analyses;
				}

				public void setAnalyses(Set<Analyse> analyses) {
					this.analyses = analyses;
				}
				
				
				
				
			    
	
	
	

}
