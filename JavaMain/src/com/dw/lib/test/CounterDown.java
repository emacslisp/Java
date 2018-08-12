package com.dw.lib.test;

public class CounterDown {
	public static void main(String[] args)
    {
        try
        {
            System.out.println("Counting down ...");
            System.out.print("5");
            Thread.currentThread();
			Thread.sleep(500);
            System.out.print("\b4");
            Thread.sleep(500);
            System.out.print("\b3");
            Thread.sleep(500);
            System.out.print("\b2");
            Thread.sleep(500);
            System.out.print("\b1");
            Thread.sleep(500);
            System.out.println("\bDone!");
            
            
            // eclipse console seems that it does not support any speical output
            System.out.println("Counting down ...");
            System.out.print("5");
            Thread.currentThread();
            Thread.sleep(500);
            System.out.print("\r 4");
            Thread.sleep(500);
            System.out.print("\r  3");
            Thread.sleep(500);
            System.out.print("\r   2");
            Thread.sleep(500);
            System.out.print("\r    1");            
            Thread.sleep(500);
            System.out.println("\rDone!");
        }
        catch (Exception ex)
        {
        }
    }
}
