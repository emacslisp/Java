package com.dw.hibernate;

import javax.persistence.*;



/*
 * create table EMPLOYEE (
   id INT NOT NULL auto_increment,
   first_name VARCHAR(20) default NULL,
   last_name  VARCHAR(20) default NULL,
   salary     INT  default NULL,
   PRIMARY KEY (id)
);
 */

/*
 * Key point is at @GeneratedValue, strategy is auto 
 * in hibernate properties
 * hibernate.id.new_generator_mappings = false
 * */
@Entity(name = "EMPLOYEEANNOTATION")
public class EmployeeAnnotation {
	   @Id 
	   @GeneratedValue
	   @Column(name = "id")
	   private int id;

	   @Column(name = "first_name")
	   private String firstName;

	   @Column(name = "last_name")
	   private String lastName;

	   @Column(name = "salary")
	   private int salary;  

	   public EmployeeAnnotation() {}
	   
	   public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	   public String getFirstName() {
	      return firstName;
	   }
	   
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   
	   public String getLastName() {
	      return lastName;
	   }
	   
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   
	   public int getSalary() {
	      return salary;
	   }
	   
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }
}
