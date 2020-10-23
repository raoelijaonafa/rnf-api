package com.rnf.core.modelentitymapper.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.rnf.core.modelentitymapper.annotations.IgnoreFieldMap;
import com.rnf.core.modelentitymapper.annotations.ModelFieldMap;
 public class ModelEntityMapper<E, M> {
	private Class<E> entityClass;
	private Class<M> modelClass;
	
	
	public ModelEntityMapper(Class<E> e, Class<M> m) {
		this.entityClass = e;
		this.modelClass = m;
	}
	
	public List<M> createModelsFromEntities(List<E> entities) {
		List<M> res = new ArrayList<>();
		
		for(E entity : entities) res.add(this.createModelFromEntity(entity));
		
		return res;
	}
	
	public List<E> createEntitiesFromModels(List<M> models) {
		List<E> res = new ArrayList<>();
		
		for(M model : models) res.add(this.createEntityFromModel(model));
		
		return res;
	}
	
	public M createModelFromEntity(E entity) {
		GenericModelEntityClass<M> modelFactory = new GenericModelEntityClass<M>(this.modelClass);
		
		M model = null;
		
		try {
			model = modelFactory.createInstance();
			
			ModelFieldMap modelFieldAnnotation;
			IgnoreFieldMap ignoreFieldAnnotation;
			
			Field[] childFields = model.getClass().getDeclaredFields();
			Field[] parentFields  = model.getClass().getSuperclass().getDeclaredFields();
			Field[] fields = this.mergeFields(childFields, parentFields);
			
			for(Field field : fields) {
				String sourceField = "";
				String targetField = "";
				
				modelFieldAnnotation = field.getAnnotation(ModelFieldMap.class);
				ignoreFieldAnnotation = field.getAnnotation(IgnoreFieldMap.class);
				
				if(ignoreFieldAnnotation != null) {
					//if tagged ignore
					continue;
				} else if(modelFieldAnnotation != null) {
					//if tagged model field annotation
					sourceField = field.getName();
					targetField = modelFieldAnnotation.targetField();
				} else {
					//if no tag, copy the field with the same name
					sourceField = field.getName();
					targetField = field.getName();
				}
				
				//Copying values
				if(sourceField != "" && targetField != "") {
					//transfer entity value to model
					Object entityFieldValue = GetterSetterInvoker.getInstance().invokeGetter(entity, sourceField);
					GetterSetterInvoker.getInstance().invokeSetter(model, targetField, entityFieldValue);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	public E createEntityFromModel(M model) {
		GenericModelEntityClass<E> entityFactory = new GenericModelEntityClass<E>(this.entityClass);
		
		E entity = null;
		
		try {
			entity = entityFactory.createInstance();
			
			//Read annotations from attributes
			ModelFieldMap modelFieldAnnotation;
			IgnoreFieldMap ignoreFieldAnnotation;
			
			Field[] childFields = model.getClass().getDeclaredFields();
			Field[] parentFields  = model.getClass().getSuperclass().getDeclaredFields();
			Field[] fields = this.mergeFields(childFields, parentFields);
			
			for(Field field : fields) {
				String sourceField = "";
				String targetField = "";
				
				modelFieldAnnotation = field.getAnnotation(ModelFieldMap.class);
				ignoreFieldAnnotation = field.getAnnotation(IgnoreFieldMap.class);
				
				if(ignoreFieldAnnotation != null) {
					//if tagged ignore
					continue;
				} else if(modelFieldAnnotation != null) {
					sourceField = field.getName();
					targetField = modelFieldAnnotation.targetField();
					//String setterMethod = String.format("set%s", targetField.substring(0, 1).toUpperCase() + targetField.substring(1));
				} else {
					//if no tag, copy the field with the same name
					sourceField = field.getName();
					targetField = field.getName();
				}
				
				//transfer model value to entity
				if(sourceField != "" && targetField != "") {
					Object modelFieldValue = GetterSetterInvoker.getInstance().invokeGetter(model, sourceField);
					GetterSetterInvoker.getInstance().invokeSetter(entity, targetField, modelFieldValue);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entity;
	}
	
	private Field[] mergeFields(Field[] fields1, Field[] fields2) {
		Field[] res = new Field[fields1.length + fields2.length];
		
		int i = 0;
		for(Field f : fields1) res[i++] = f;
		for(Field f : fields2) res[i++] = f;
		
		return res;
	}
}
