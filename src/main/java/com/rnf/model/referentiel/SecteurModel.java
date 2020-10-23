package com.rnf.model.referentiel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rnf.core.modelentitymapper.annotations.ModelFieldMap;


public class SecteurModel  {

	@JsonProperty("idSecteur")
	@ModelFieldMap(targetField="idSecteur")
	private Integer idSecteur;
	
	@JsonProperty("secteurName")
	@ModelFieldMap(targetField="secteurName")
	private String secteurName;
	
	@JsonProperty("secteurabreviation")
	@ModelFieldMap(targetField="secteurabreviation")
	private String secteurabreviation;
	 

	public Integer getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(Integer idSecteur) {
		this.idSecteur = idSecteur;
	}

	public String getSecteurName() {
		return secteurName;
	}

	public void setSecteurName(String secteurName) {
		this.secteurName = secteurName;
	}

	public String getSecteurabreviation() {
		return secteurabreviation;
	}

	public void setSecteurabreviation(String secteurabreviation) {
		this.secteurabreviation = secteurabreviation;
	}

	 
	
	
}
