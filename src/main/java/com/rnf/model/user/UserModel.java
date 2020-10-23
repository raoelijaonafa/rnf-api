package com.rnf.model.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rnf.core.modelentitymapper.annotations.IgnoreFieldMap;
import com.rnf.core.modelentitymapper.annotations.ModelEntityMap;
import com.rnf.core.modelentitymapper.annotations.ModelFieldMap;

@ModelEntityMap(targetEntity="UserEntity")
public class UserModel implements UserDetails {

	/**
	 * 
	 */
	@IgnoreFieldMap
	private static final long serialVersionUID = 1L;

	@JsonProperty("idUsers")
	@ModelFieldMap(targetField="idUsers")
	protected int idUsers;

	@JsonProperty("username")
	@ModelFieldMap(targetField="username")
	protected String username;
 

	@JsonIgnore
	@ModelFieldMap(targetField="password")
	protected String password;
	
	@ModelFieldMap(targetField="nom")
	protected String nom;

	@ModelFieldMap(targetField="prenom")
	protected String prenom;
	
	@ModelFieldMap(targetField="etat")
	protected Integer etat;
	 
	
	@ModelFieldMap(targetField="resetPassword")
	protected int resetPassword;
	
	@IgnoreFieldMap
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserModel() {
		this.authorities = new ArrayList<>();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	 
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	 

	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
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
 

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	@Override
	public boolean isEnabled() {
		return this.etat == 0;
	}
	
	public int getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(int resetPassword) {
		this.resetPassword = resetPassword;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserModel user = (UserModel) o;
		return Objects.equals(idUsers, user.idUsers);
	}
}
