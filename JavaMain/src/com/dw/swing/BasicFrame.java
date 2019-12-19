package com.dw.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BasicFrame {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		try {
			 //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// TODO Auto-generated method stub
		SwingUtilities.invokeAndWait(new Runnable() {

			public void run() {
				JFrame a = new JFrame();
				a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				a.setSize(500, 500);
				a.setTitle("Basic Framework");
				a.setVisible(true);
				
				a.setLayout(new BorderLayout());
				
				
			}
		});
	}
}
