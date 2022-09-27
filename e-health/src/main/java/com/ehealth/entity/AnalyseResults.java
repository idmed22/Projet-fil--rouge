package com.ehealth.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AnalyseResults {
	
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name = "id", columnDefinition = "serial")
			private Long id; 
	
			@JsonFormat(pattern="yyyy-MM-dd")
			private Date dateResultat;
			
			private Boolean valeurNormale;
			
			
			public AnalyseResults() {
				super();
			}
		
		
			public Date getDateResultat() {
				return dateResultat;
			}



			public void setDateResultat(Date dateResultat) {
				this.dateResultat = dateResultat;
			}
		
		
			public Boolean getValeurNormale() {
				return valeurNormale;
			}
		
		
		
			public void setValeurNormale(Boolean valeurNormale) {
				this.valeurNormale = valeurNormale;
			}
			
	
	
	
}
