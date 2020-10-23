package com.rnf.entity.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.rnf.misc.EnumRole;

@Entity
@Table(name="roles")
public class RoleEntity {
	
	@Id
	@GeneratedValue(generator = "triggerAssigned")
	@GenericGenerator(name = "triggerAssigned", strategy = "jpl.hibernate.util.TriggerAssignedIdentityGenerator")
	@Column(name="roles_idrole", nullable=false)
	private Integer idRole;
	
	@Enumerated(EnumType.STRING)
	@Column(name="name", length = 20)
	private EnumRole name;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<UserEntity> users = new ArrayList<>();

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

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	 
	 
	

}
