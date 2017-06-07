package com.dw.notepad2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.*;
import java.util.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Notepad2 extends JPanel {
	
	protected static Properties properties;
	private static ResourceBundle resources;
	private final static String EXIT_AFTER_PAINT = "-exit";
	private static boolean exitAfterFirstPaint;

	static {
		try {
			properties = new Properties();
			properties.load(Notepad2.class.getClassLoader().getResourceAsStream("resources/Notepad.properties"));
			resources = ResourceBundle.getBundle("resources.Notepad", Locale.getDefault());
		} catch (MissingResourceException | IOException e) {
			System.err.println("resources/Notepad.properties " + "or resources/NotepadSystem.properties not found");
			System.exit(1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		if (args.length > 0 && args[0].equals(EXIT_AFTER_PAINT)) {
			exitAfterFirstPaint = true;
		}
		SwingUtilities.invokeAndWait(new Runnable() {

			public void run()
			{
				JFrame frame = new JFrame();
				frame.setTitle(resources.getString("Title"));
				frame.setBackground(Color.lightGray);
				frame.getContentPane().setLayout(new BorderLayout());
				Notepad2 notepad = new Notepad2();
				frame.getContentPane().add("Center", notepad);
				/*frame.setJMenuBar(notepad.createMenubar());
				frame.addWindowListener(new AppCloser());*/
				frame.pack();
				frame.setSize(500, 600);
				frame.setVisible(true);
			}
		});
	}
}
