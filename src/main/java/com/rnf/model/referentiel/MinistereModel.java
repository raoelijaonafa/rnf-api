package com.rnf.model.referentiel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rnf.core.modelentitymapper.annotations.ModelFieldMap;

public class MinistereModel {

	@JsonProperty("idMinistere")
	@ModelFieldMap(targetField="idMinistere")
	private Integer idMinistere;

	@JsonProperty("code")
	@ModelFieldMap(targetField="code")
	private String code;

	@JsonProperty("libelle")
	@ModelFieldMap(targetField="libelle")
	private String libelle;

	@JsonProperty("abreviation")
	@ModelFieldMap(targetField="abreviation")
	private String abreviation; 
	
	@JsonProperty("id_secteur")
	@ModelFieldMap(targetField="idSecteur")
	private Integer idSecteur;

	@JsonProperty("id_exercice")
	@ModelFieldMap(targetField="idExercice")
     private Integer idExercice;
	
	@JsonIgnore
	private Integer status;

	public Integer getIdMinistere() {
		return idMinistere;
	}

	public void setIdMinistere(Integer idMinistere) {
		this.idMinistere = idMinistere;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
 
	public Integer getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(Integer idSecteur) {
		this.idSecteur = idSecteur;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIdExercice() {
		return idExercice;
	}

	public void setIdExercice(Integer idExercice) {
		this.idExercice = idExercice;
	}

	 
 

}
