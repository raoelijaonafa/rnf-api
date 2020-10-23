package com.rnf.repository.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rnf.entity.user.UserViewEntity;

@Repository
public class UserViewCustomRepositoryImpl implements UserViewCustomRepository {

	@Autowired
	private EntityManager em;

	@Override
	public UserViewEntity findViewById(int id) {
		return this.em.find(UserViewEntity.class, id);
	}
	
	@Override
	public List<UserViewEntity> listViewDtUser(int index, int pageSize, String search, Integer etat, String departement) {
		
		String strQuery = "select u from UserViewEntity u";
		String strCriteria = "";
		
		Map<String, Object> mapParameters = new HashMap<String, Object>();
		strCriteria = this.constructQueryAndParameters("u", mapParameters, search, etat, departement);
		if(!strCriteria.equals("")) strCriteria = " where " + strCriteria;
		strQuery = strQuery + strCriteria;
		
		Query query = em.createQuery(strQuery);
		
		for(Map.Entry<String, Object> entry : mapParameters.entrySet())
			query.setParameter(entry.getKey(), entry.getValue());
		
		query.setFirstResult(index * pageSize); 
		query.setMaxResults(pageSize);
		
		return query.getResultList();
	}

	@Override
	public int countViewDtUser(String search, Integer etat, String departement) {
		
		String strQuery = "select count(u) from UserViewEntity u";
		String strCriteria = "";
		
		Map<String, Object> mapParameters = new HashMap<String, Object>();
		strCriteria = this.constructQueryAndParameters("u", mapParameters, search, etat, departement);
		if(!strCriteria.equals("")) strCriteria = " where " + strCriteria;
		strQuery = strQuery + strCriteria;
		
		Query query = em.createQuery(strQuery);
		
		for(Map.Entry<String, Object> entry : mapParameters.entrySet())
			query.setParameter(entry.getKey(), entry.getValue());

		return Integer.parseInt(query.getSingleResult().toString());
	}
	
	private String constructQueryAndParameters(String entityAlias, Map<String, Object> parameterMap,
			String search, Integer etat, String departement) {
		
		String strCriteria = "";
		
		//Constructing string query
		if(!this.isNullOrEmpty(search)) {
			strCriteria += String.format("(upper(%s.username) like upper(:search) or upper(%s.noms) like upper(:search) or upper(%s.prenoms) like upper(:search))", entityAlias, entityAlias, entityAlias);
		}
		
		if(etat != null) {
			if(etat >= 0) {
				if(!strCriteria.equals("")) strCriteria += " and ";
				strCriteria += String.format("%s.etat like :etat", entityAlias);
			}
		}
		
		if(!this.isNullOrEmpty(departement)) {
			if(!strCriteria.equals("")) strCriteria += " and ";
			strCriteria += String.format("upper(%s.departement) like upper(:departement)", entityAlias);
		}
		
		//Constructing parameters
		if(!this.isNullOrEmpty(search)) parameterMap.put("search", "%" + search + "%");
		
		if(etat != null)
			if(etat >= 0) parameterMap.put("etat", etat);
		
		if(!this.isNullOrEmpty(departement)) parameterMap.put("departement", "%" + departement + "%");
		
		return strCriteria;
	}
	
	private boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
}
