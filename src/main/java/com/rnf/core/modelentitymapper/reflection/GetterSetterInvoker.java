package com.rnf.core.modelentitymapper.reflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class GetterSetterInvoker {
	private static GetterSetterInvoker instance = new GetterSetterInvoker();
	
	private GetterSetterInvoker() {}
	
	public static final GetterSetterInvoker getInstance() {
		return instance;
	}
	
	public void invokeSetter(Object obj, String variableName, Object variableValue) {
		/*
		 * variableValue is Object because value can be an Object, Integer, String,
		 * etc...
		 */
		try {
			/**
			 * Get object of PropertyDescriptor using variable name and class Note: To use
			 * PropertyDescriptor on any field/variable, the field must have both `Setter`
			 * and `Getter` method.
			 */
			PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(variableName, obj.getClass());
			/* Set field/variable value using getWriteMethod() */
			objPropertyDescriptor.getWriteMethod().invoke(obj, variableValue);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object invokeGetter(Object obj, String variableName) {
		try {
			/**
			 * Get object of PropertyDescriptor using variable name and class Note: To use
			 * PropertyDescriptor on any field/variable, the field must have both `Setter`
			 * and `Getter` method.
			 */
			PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(variableName, obj.getClass());
			/**
			 * Get field/variable value using getReadMethod() variableValue is Object
			 * because value can be an Object, Integer, String, etc...
			 */
			Object variableValue = objPropertyDescriptor.getReadMethod().invoke(obj);
			/* Print value of variable */
			//System.out.println(variableValue);
			return variableValue;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
