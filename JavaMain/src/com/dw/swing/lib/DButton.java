package com.dw.swing.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import com.dw.swing.ListDialog;

public class NMButton extends JButton implements ActionListener{
	public NMButton(String text, ActionListener actionListener) {
		super(text);
		super.addActionListener(actionListener);
	}
	
	public NMButton(String text) {
		super(text);
		super.addActionListener(this);
	}
	
    public void actionPerformed(ActionEvent e) {
    	System.out.println("button");
    	MessageBox.show("this is infoMessage", "this is title");
    }
}


