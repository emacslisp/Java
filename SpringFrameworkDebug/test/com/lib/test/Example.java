package com.lib.test;

import static org.junit.Assert.assertEquals;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Example {
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        
        //Method annotated with `@AfterClass` will execute once after all of the test methods are executed in this class.

        //If you allocate expensive external resources in a BeforeClass method you need to release them after all the tests in the class have run. Annotating a public static void method with @AfterClass causes that method to be run after all the tests in the class have been run. All @AfterClass methods are guaranteed to run even if a BeforeClass method throws an exception. From http://junit.sourceforge.net/javadoc/org/junit/AfterClass.html
    }

    @Before
    public void setUp() throws Exception {
         //Method annotated with `@Before` will execute before each test method in this class is executed.

         //If you find that several tests need similar objects created before they can run this method could be used to do set up those objects (aka test-fixtures).
    }
    
    @After
    public void tearDown() throws Exception {
         
         //Method annotated with `@After` will execute after each test method in this class is executed.

         //If you allocate external resources in a Before method you must release them in this method.
    }

    @Test
    public void test1() {
       
       //A public void method annotated with @Test will be executed as a test case.
    	// 'theString' should contain 'S' and 'r'
    	assertEquals("theString", "thisString");

    }

    @Test
    public void test2() {

        //Another test cases
    }
}
