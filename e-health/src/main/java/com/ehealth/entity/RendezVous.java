package com.ehealth.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RendezVous {
	
				@Id
				@Column(name = "id", columnDefinition = "serial")
				@GeneratedValue(strategy = GenerationType.IDENTITY)
				private Long id;
				
				@JsonFormat(pattern="yyyy-MM-dd")
			    private Date rendezVousDate;
				private boolean valider;
				
				//(fetch = FetchType.LAZY, optional = false)
				@ManyToOne
				@JoinColumn(name="patients_id", nullable = false )
//				@JsonIgnore
				private Patient patients;
				
				
				public Long getId() {
					return id;
				}
				public void setId(Long id) {
					this.id = id;
				}
				public Date getRendezVousDate() {
					return rendezVousDate;
				}
				public void setRendezVousDate(Date rendezVousDate) {
					this.rendezVousDate = rendezVousDate;
				}
				public boolean isValider() {
					return valider;
				}
				public void setValider(boolean valider) {
					this.valider = valider;
				}
				public Patient getPatients() {
					return patients;
				}
				public void setPatients(Patient patients) {
					this.patients = patients;
				}
				
				
				

	
			
	         
				
			  
				
	
	
	
}
