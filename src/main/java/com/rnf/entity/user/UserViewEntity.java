package com.rnf.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name="v_user")
@Immutable
public class UserViewEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idUser")
	protected int idUser;
	
	@Column(name="username")
	protected String username;
	
	
	@Column(name="nom")
	protected String nom;
	
	@Column(name="prenom")
	protected String prenom;
	
	
	@Column(name="minsitere")
	protected String ministere;
	
	@Column(name="idMinistere")
	protected int idMinistere;
	
	@Column(name="etat")
	protected int etat;

	@Column(name="reset_password")
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
