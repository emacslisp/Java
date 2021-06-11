package org.spring.main;

import org.spring.main.models.Apple;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;


public class MutablePropertyValuesEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] properties = new String[]{"id", "name"};
        MutablePropertyValues pvs = new MutablePropertyValues();

        for(int i=0; i<properties.length; i++){
            String property = properties[i];
            String value = "test" + i;
            pvs.add(property, value);
        }

        Apple p = new Apple();
        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(p);
        wrapper.setPropertyValues(pvs);
        System.out.println(p);

	}

}
