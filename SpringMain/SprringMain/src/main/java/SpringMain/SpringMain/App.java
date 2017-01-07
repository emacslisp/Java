package SpringMain.SpringMain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;

public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("SpringMain/SpringMain/Beans.xml");

    	Logger log = Logger.getLogger("test");
         HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
         obj.setMessage("this is a test message");
         obj.getMessage();
         
         System.out.println(obj.getId());
         
         log.info("Hello Spring");
         
         HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
         
         objB.getMessage();
         
         
         Address address = (Address) context.getBean("address");
         
         System.out.println(address);
         
         context.close();
    }
}
