package com.ehealth.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class ChefLaboratoire extends User{
	
	public ChefLaboratoire() {
		super();
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Patient> patient = new HashSet<>();

	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}
      

}
