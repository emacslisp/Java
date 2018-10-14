package com.dw.swing.test;

import javax.swing.JFrame;
import com.dw.swing.lib.*;

public class LayoutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NMJFrame mainFrame = new NMJFrame("this is fucking ",500,300);
		NMPanel panel = new NMPanel();
		NMButton button = new NMButton("text button");
		panel.add(button);
		mainFrame.addPanel(panel);
		
		//set visible should be called at the last moment;
		mainFrame.setVisible(true);
	}

}
