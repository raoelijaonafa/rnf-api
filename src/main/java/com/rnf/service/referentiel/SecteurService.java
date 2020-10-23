package com.rnf.service.referentiel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnf.core.modelentitymapper.reflection.ModelEntityMapper;
import com.rnf.entity.referentiel.SecteurEntity;
import com.rnf.model.referentiel.SecteurModel;
import com.rnf.repository.referentiel.SecteurEntityRepository;
@Service
public class SecteurService {


	@Autowired
	private SecteurEntityRepository secteurEntityRepository;
	
	private ModelEntityMapper<SecteurEntity, SecteurModel> secteurModelFactory;
	
	public SecteurService() {
		this.secteurModelFactory = new ModelEntityMapper<>(SecteurEntity.class, SecteurModel.class);
	}
	
	 
	public List<SecteurModel> findAllsecteur() {
		List<SecteurEntity> entities = this.secteurEntityRepository.findAll();
		List<SecteurModel> models = this.secteurModelFactory.createModelsFromEntities(entities);
		
		return models;
	}
}
