package com.diwu.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		Person person = (Person)context.getBean("person");
		
		
		person.speak();
		((FileSystemXmlApplicationContext)context).close();*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/diwu/spring/test/beans/beans.xml");
		Person person2 = (Person)context.getBean("person");
		
		Person person3 = (Person)context.getBean("person");

		
		//Address address = (Address)context.getBean("address");
		//person2.speak();
		person3.setTaxId(777);
		System.out.println(person2);
		
		System.out.println(person3);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
