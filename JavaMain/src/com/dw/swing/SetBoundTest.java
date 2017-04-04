package com.dw.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SetBoundTest {

	
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		
		 SwingUtilities.invokeAndWait(new Runnable() {

	            public void run() {
	            	JFrame a = new JFrame();
	            	a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        		a.setSize(500,500);
	        		JPanel b = new JPanel();
	        		JPanel c = new JPanel();
	        		
	        		b.setBounds(0,0,50,100);
	        		b.setBackground(Color.red);
	        		c.setBounds(50,0,50,100);
	        		c.setBackground(Color.GREEN);
	        		a.add(b);
	        		b.add(c);
	        		JButton button = new JButton("Test");
	        		button.addActionListener(new ActionListener() {
	        			 
	                    public void actionPerformed(ActionEvent e)
	                    {
	                        //Execute when button is pressed
	                    	//JOptionPane.showMessageDialog(null, "Thank you for using Java", "Yay, java", JOptionPane.PLAIN_MESSAGE);
	                    	JOptionPane.showMessageDialog(a, "thank you for using java");
	                    }
	                });  
	        		c.add(button);
	        		
	        		
	        		a.setVisible(true);
	            }
	        });
		// TODO Auto-generated method stub
	
	}

}
