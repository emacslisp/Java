package com.diwu.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		Person person = (Person)context.getBean("person");
		
		
		person.speak();
		((FileSystemXmlApplicationContext)context).close();
		context = new ClassPathXmlApplicationContext("com/diwu/spring/test/beans/beans.xml");
		Person person2 = (Person)context.getBean("person");
		person2.speak();
		((ClassPathXmlApplicationContext)context).close();
	}

}
