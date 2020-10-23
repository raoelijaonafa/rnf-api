package com.rnf.service.referentiel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnf.core.modelentitymapper.reflection.ModelEntityMapper;
import com.rnf.entity.referentiel.MinistereEntity;
import com.rnf.model.referentiel.MinistereModel;
import com.rnf.repository.referentiel.MinistereEntityRepository;
@Service
public class MinistereService {
	
	
	
	@Autowired
	private MinistereEntityRepository ministereEntityRepository;
	
	private ModelEntityMapper<MinistereEntity, MinistereModel> ministereModelFactory;
	
	public MinistereService() {
		this.ministereModelFactory = new ModelEntityMapper<>(MinistereEntity.class, MinistereModel.class);
	}
	
	 
	public List<MinistereModel> findAllMinistere() {
		List<MinistereEntity> entities = this.ministereEntityRepository.findAll();
		List<MinistereModel> models = this.ministereModelFactory.createModelsFromEntities(entities);
		
		return models;
	}
	 

}
