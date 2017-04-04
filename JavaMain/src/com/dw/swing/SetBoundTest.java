package com.dw.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SetBoundTest {

	
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		
		 SwingUtilities.invokeAndWait(new Runnable() {

	            public void run() {
	            	JFrame a = new JFrame();
	        		a.setSize(100,100);
	        		JPanel b = new JPanel();
	        		JPanel c = new JPanel();
	        		b.setBounds(0,0,50,100);
	        		c.setBounds(50,0,50,100);
	        		a.add(b);
	        		b.add(c);
	        		a.setVisible(true);
	            }
	        });
		// TODO Auto-generated method stub
	
	}

}
