package com.rnf.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rnf.core.modelentitymapper.annotations.ModelFieldMap;
import com.rnf.misc.EnumRole;

public class RoleModel {
	@JsonProperty("idRole")
	@ModelFieldMap(targetField="idRole")
	private Integer idRole;
	
	@JsonProperty("name")
	@ModelFieldMap(targetField="name")
	private EnumRole name;

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public EnumRole getName() {
		return name;
	}

	public void setName(EnumRole name) {
		this.name = name;
	}
 
}
