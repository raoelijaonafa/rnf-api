package com.rnf.model.referentiel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rnf.core.modelentitymapper.annotations.ModelFieldMap;
 
public class LoiFinanceModel  {

	@JsonProperty("idLF")
	@ModelFieldMap(targetField="idLF")
	private Integer idLF;
	
	@JsonProperty("lf")
	@ModelFieldMap(targetField="lf")
	private String lf;

	public Integer getIdLF() {
		return idLF;
	}

	public void setIdLF(Integer idLF) {
		this.idLF = idLF;
	}

	public String getLf() {
		return lf;
	}

	public void setLf(String lf) {
		this.lf = lf;
	}
	 
	  
	
	
}
