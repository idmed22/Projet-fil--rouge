package com.ehealth.entity;

import javax.persistence.Embeddable;

@Embeddable
public class AnalyseTypePartie {   //  remove this class
	private boolean ChimieCourante;
	private boolean Enzymologie;
	private boolean Hormonologie;
	
	public Boolean getChimieCourante() {
		return ChimieCourante;
	}
	public void setChimieCourante(Boolean chimieCourante) {
		ChimieCourante = chimieCourante;
	}
	public Boolean getEnzymologie() {
		return Enzymologie;
	}
	public void setEnzymologie(Boolean enzymologie) {
		Enzymologie = enzymologie;
	}
	public Boolean getHormonologie() {
		return Hormonologie;
	}
	public void setHormonologie(Boolean hormonologie) {
		Hormonologie = hormonologie;
	}

}
