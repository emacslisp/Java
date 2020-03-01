package com.dw.swing.test;

import javax.swing.JFrame;
import com.dw.swing.lib.*;

public class LayoutTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFrame mainFrame = new DFrame("this is testing ",500,300);
		DPanel panel = new DPanel();
		DButton button = new DButton("text button");
		panel.add(button);
		mainFrame.addPanel(panel);
		
		//set visible should be called at the last moment;
		mainFrame.setVisible(true);
	}

}
