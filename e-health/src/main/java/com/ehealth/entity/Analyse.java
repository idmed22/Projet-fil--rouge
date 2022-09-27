package com.ehealth.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="analyses")
public class Analyse {
	
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name = "id", columnDefinition = "serial")
			private Long id; 
			
			private String description;
			
			
			@JsonFormat(pattern="yyyy-MM-dd")
			private Date  datePrelevement; 
			
			private String nomPreleveur;
			private  AnalyseTypePartie analyseTypePartie; //@Embed
			
			@Enumerated(EnumType.STRING)
			private AnalyseType analyseType; // enum  type analyse
			
			@Enumerated(EnumType.STRING)
			private SangTypes sangTypes;  // enum type sang
			
			
			
			@ManyToMany(cascade = CascadeType.ALL)
		    @JsonIgnore
		    private Set<Patient> patient = new HashSet<>();
			
			
			
//			@OneToMany(cascade = CascadeType.ALL)
//			@JsonIgnore
//			private Set<AnalyseResults> analyseResults = new HashSet<>();
	
	
			
			
	
	public Analyse() {
		super();
	}
	
	public Analyse(String description, Date datePrelevement, String nomPreleveur, AnalyseTypePartie analyseTypePartie,
			AnalyseType analyseType, SangTypes sangTypes) {
		this.description = description;
		this.datePrelevement = datePrelevement;
		this.nomPreleveur = nomPreleveur;
		this.analyseTypePartie = analyseTypePartie;
		this.analyseType = analyseType;
		this.sangTypes = sangTypes;
	}




	public Long getId() {
		return id;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePrelevement() {
		return datePrelevement;
	}

	public void setDatePrelevement(Date datePrelevement) {
		this.datePrelevement = datePrelevement;
	}

	public String getNomPreleveur() {
		return nomPreleveur;
	}

	public void setNomPreleveur(String nomPreleveur) {
		this.nomPreleveur = nomPreleveur;
	}

	public AnalyseTypePartie getAnalyseTypePartie() {
		return analyseTypePartie;
	}

	public void setAnalyseTypePartie(AnalyseTypePartie analyseTypePartie) {
		this.analyseTypePartie = analyseTypePartie;
	}

	public AnalyseType getAnalyseType() {
		return analyseType;
	}

	public void setAnalyseType(AnalyseType analyseType) {
		this.analyseType = analyseType;
	}

	public SangTypes getSangTypes() {
		return sangTypes;
	}

	public void setSangTypes(SangTypes sangTypes) {
		this.sangTypes = sangTypes;
	}

	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}

	
	
	
	
	
	
	

}
