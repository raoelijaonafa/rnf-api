package com.rnf.entity.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.rnf.entity.referentiel.MinistereEntity;
 

@Entity
@Table(name="users")
public class UserEntity {
	
	@Id			
	@GeneratedValue(generator = "triggerAssigned")
	@GenericGenerator(name = "triggerAssigned", strategy = "jpl.hibernate.util.TriggerAssignedIdentityGenerator")
	@Column(name="users_idusers", nullable=false)
	private Integer idUsers;
	
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="etat")
	private Integer etat;
	 
	 

	@Column(name="reset_password")
	protected int resetPassword;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="userrole", 
		joinColumns = {@JoinColumn(name="users_idusers")},
		inverseJoinColumns = {@JoinColumn(name="roles_idrole")}
	)
	List<RoleEntity> roles = new ArrayList<>();

  
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="user_ministere", 
		joinColumns = {@JoinColumn(name="users_idusers")},
		inverseJoinColumns = {@JoinColumn(name="ministere_id_ministere")}
	)
	private List<MinistereEntity> consuMinisteres = new ArrayList<>();


	public Integer getIdUsers() {
		return idUsers;
	}


	public void setIdUsers(Integer idUsers) {
		this.idUsers = idUsers;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public Integer getEtat() {
		return etat;
	}


	public void setEtat(Integer etat) {
		this.etat = etat;
	}


	public int getResetPassword() {
		return resetPassword;
	}


	public void setResetPassword(int resetPassword) {
		this.resetPassword = resetPassword;
	}


	public List<RoleEntity> getRoles() {
		return roles;
	}


	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}


	public List<MinistereEntity> getConsuMinisteres() {
		return consuMinisteres;
	}


	public void setConsuMinisteres(List<MinistereEntity> consuMinisteres) {
		this.consuMinisteres = consuMinisteres;
	}

 
	 
	
	

}
