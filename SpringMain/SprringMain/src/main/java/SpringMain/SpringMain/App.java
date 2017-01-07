package SpringMain.SpringMain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
                new ClassPathXmlApplicationContext("SpringMain/SpringMain/Beans.xml");

         HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
         obj.setMessage("this is a test message");
         obj.getMessage();
         
         HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
         
         objB.getMessage();
    }
}
