package com.dw.swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListDialogTest {
	
    public static void main(String[] args) {
    	
    	JFrame frame = new JFrame("Java JFrame");
    	frame.setSize(600,600);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	final JButton button = new JButton("Pick a new name...");
    	 String[] choices = {"A", "long", "array", "of", "strings"};
    	    String selectedName = ListDialog.showDialog(
    	    		frame,
    	                                locatorComponent,
    	                                "A description of the list:",
    	                                "Dialog Title",
    	                                choices,
    	                                choices[0]);
    }


}
