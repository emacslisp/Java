package com.dw.lib.test;

import java.lang.reflect.Field;

public class StaticClassInterfaceTest {
	public static interface SupportEmailType {
		String general = "general";
    	String commissions = "commissions";
    	String systemEmail = "noreply";
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String emailType = "commissions";
		boolean result = false;
		Field[] flist = SupportEmailType.class.getDeclaredFields();
    	for (Field f : flist )
            if( f.getType() == String.class && f.getName().equals(emailType))  {
            	System.out.println("matched");
            	result = true;
            	break;
            }
	}

}
