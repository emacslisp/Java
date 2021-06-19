package com.dw.lib;

import java.lang.reflect.*;

public class ReflectionHelper {

	public ReflectionHelper() {
		
	}
	
	public <T> String getName(Class<T> c) {
		return c.getName();
	}
	
	public <T> Field[] getFields(Class<T> c) {
		Field[] fields = c.getFields();
		return fields;
	}
	
	public <T> Method[] getMethods(Class<T> c) {
		Method[] methods = c.getMethods();
		return methods;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReflectionHelper r = new ReflectionHelper();
		String className = r.getName(ReflectionHelper.class);
		System.out.println(className);
	}

}
