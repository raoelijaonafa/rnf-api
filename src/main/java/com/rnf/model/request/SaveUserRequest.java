package com.rnf.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveUserRequest {
	@NotBlank
	@JsonProperty("username")
    @Size(min = 10, max = 20)
	private String username;
	
	@NotBlank
	@JsonProperty("nom")
	private String nom;
	
	@JsonProperty("prenom")
	private String prenom;
	
	@NotBlank
	@JsonProperty("password")
	@Size(min = 6, max = 20)
	private String password;
	 
	
	@NotBlank
	@JsonProperty("idMinistere")
	private Integer idMinistere;
	
	@NotBlank
	@JsonProperty("idRole")
	private Integer idRole;
	
	@NotBlank
	@JsonProperty("etat")
	private Integer etat;
	
	@JsonProperty("picture")
	private String picture;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getIdMinistere() {
		return idMinistere;
	}

	public void setIdMinistere(Integer idMinistere) {
		this.idMinistere = idMinistere;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
