package com.rnf.core.modelentitymapper.reflection;

/**
 * Permet d'instancier une classe générique
 * Utilisé notamment par le ModelEntityMapper
 * Code générique
 * @author SADSB-Mitanjo
 *
 * @param <E>
 */
public class GenericModelEntityClass<E> {
	private final Class<E> clazz;
	  
    public GenericModelEntityClass(Class<E> clazz) {
        this.clazz = clazz; 
    }
  
    public E createInstance() throws Exception {
        return (E) clazz.newInstance();
    }
}
