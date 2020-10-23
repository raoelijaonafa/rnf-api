package com.rnf.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rnf.core.modelentitymapper.annotations.ModelEntityMap;
import com.rnf.core.modelentitymapper.annotations.ModelFieldMap;

@ModelEntityMap(targetEntity="UserViewEntity")
public class UserViewModel {
	@JsonProperty("idUser")
	@ModelFieldMap(targetField="idUser")
	protected int idUser;
	
	@JsonProperty("username")
	@ModelFieldMap(targetField="username")
	protected String username;
	
	@JsonProperty("email")
	@ModelFieldMap(targetField="email")
	protected String email;
	
	@JsonProperty("nom")
	@ModelFieldMap(targetField="nom")
	protected String nom;
	
	@JsonProperty("prenom")
	@ModelFieldMap(targetField="prenom")
	protected String prenom;
	 
	
	@JsonProperty("ministere")
	@ModelFieldMap(targetField="ministere")
	protected String ministere;
	
	@JsonProperty("idMinistere")
	@ModelFieldMap(targetField="idMinistere")
	protected int idMinistere;
	
	@JsonProperty("etat")
	@ModelFieldMap(targetField="etat")
	protected int etat;
	
	@JsonProperty("resetPassword")
	@ModelFieldMap(targetField="resetPassword")
	protected int resetPassword;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMinistere() {
		return ministere;
	}

	public void setMinistere(String ministere) {
		this.ministere = ministere;
	}

	public int getIdMinistere() {
		return idMinistere;
	}

	public void setIdMinistere(int idMinistere) {
		this.idMinistere = idMinistere;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public int getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(int resetPassword) {
		this.resetPassword = resetPassword;
	}
 
	
}
