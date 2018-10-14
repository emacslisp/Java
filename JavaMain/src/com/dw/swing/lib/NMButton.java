package com.dw.swing.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class NMButton extends JButton {
	private class ButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("button");	
		}	
	}
	public NMButton(String text, ActionListener actionListener) {
		super(text);
		super.addActionListener(actionListener);
	}
	
	public NMButton(String text) {
		super(text);
		super.addActionListener(new ButtonActionListener());
	}
}


