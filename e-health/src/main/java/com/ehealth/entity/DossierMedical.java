package com.ehealth.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DossierMedical {
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "id", columnDefinition = "serial")
			private Long id;
			private String etat;   // archivé or ...
			
			@JsonFormat(pattern="yyyy-MM-dd")
		    private Date dateCreation;
			
			private String codeAccess;
			
			
			
			@OneToOne
			@JoinColumn(name="patients_id")
			private Patient patients;
			
			
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getEtat() {
				return etat;
			}
			public void setEtat(String etat) {
				this.etat = etat;
			}
			
			public String getCodeAccess() {
				return codeAccess;
			}
			public void setCodeAccess(String codeAccess) {
				this.codeAccess = codeAccess;
			}
			public Date getDateCreation() {
				return dateCreation;
			}
			public void setDateCreation(Date dateCreation) {
				this.dateCreation = dateCreation;
			}
			public Patient getPatients() {
				return patients;
			}
			public void setPatients(Patient patients) {
				this.patients = patients;
			}
			
			
			
			
			
    
}
