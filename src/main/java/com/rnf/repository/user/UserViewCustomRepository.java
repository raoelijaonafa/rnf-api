package com.rnf.repository.user;

import java.util.List;

import com.rnf.entity.user.UserViewEntity;

public interface UserViewCustomRepository {
	public UserViewEntity findViewById(int id);
	
	public List<UserViewEntity> listViewDtUser(int index, int pageSize, String search, Integer etat, String departement);
	
	public int countViewDtUser(String search, Integer etat, String departement);
}
