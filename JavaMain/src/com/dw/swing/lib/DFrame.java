package com.dw.swing.lib;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NMJFrame extends JFrame {
	
	public NMJFrame(String title) {
		super();
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		//super.setVisible(true);
	}

	public NMJFrame(String title, int height, int width) {
		super();
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(height, width);
		//super.setVisible(true);
	}
	
	/**
	 * call visible true at the end of panel
	 * */
	public void setVisible(boolean isVisible)
	{
		super.setVisible(isVisible);
	}
	
	public void addPanel(JPanel panel) {
		this.getContentPane().add(panel);
	}
}
