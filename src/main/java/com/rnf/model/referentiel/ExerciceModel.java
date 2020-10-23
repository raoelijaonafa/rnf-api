package com.rnf.model.referentiel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rnf.core.modelentitymapper.annotations.ModelFieldMap;


public class ExerciceModel  {

	@JsonProperty("idExercice")
	@ModelFieldMap(targetField="idExercice")
	private Integer idExercice;
	
	@JsonProperty("exercice")
	@ModelFieldMap(targetField="exercice")
	private String exercice;
	
	
	@JsonProperty("idLF")
	@ModelFieldMap(targetField="idLF")
    private Integer idLF;

	public Integer getIdExercice() {
		return idExercice;
	}

	public void setIdExercice(Integer idExercice) {
		this.idExercice = idExercice;
	}

	public String getExercice() {
		return exercice;
	}

	public void setExercice(String exercice) {
		this.exercice = exercice;
	}

	public Integer getIdLF() {
		return idLF;
	}

	public void setIdLF(Integer idLF) {
		this.idLF = idLF;
	}
	 
	 
 

	 
	
	
}
