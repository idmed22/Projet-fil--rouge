package com.ehealth.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="factures")
public class Facture {

			 @Id
			 @Column(name = "id", columnDefinition = "serial")
			 @GeneratedValue(strategy = GenerationType.IDENTITY)
			 private Long id;
			 
			 @JsonFormat(pattern="yyyy-MM-dd")
			 private Date FactureDate;
			 
			 private Double montant;
			 private boolean payer;
			 
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
			public Date getFactureDate() {
				return FactureDate;
			}
			public void setFactureDate(Date factureDate) {
				FactureDate = factureDate;
			}
			public Double getMontant() {
				return montant;
			}
			public void setMontant(Double montant) {
				this.montant = montant;
			}
			public boolean isPayer() {
				return payer;
			}
			public void setPayer(boolean payer) {
				this.payer = payer;
			}
			public Patient getPatients() {
				return patients;
			}
			public void setPatients(Patient patients) {
				this.patients = patients;
			}
			
			
            
			 
			 
			 
	 
	
	 


	



}
