package com.dw.lib;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;


public class SimpleAudioPlayer {
	
	public static void PlayMp3File(String path) {
		try {
        	FileUtils utils = new FileUtils();
        	if (utils.isExisted(path)) {
	        	FileInputStream fis = new FileInputStream(path);
	            Player playMP3 = new Player(fis);
	            playMP3.play();
        	}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	 
    public static void main(String[] args) {
    	String bip = "/Users/ewu/test/hello.mp3";
    	SimpleAudioPlayer.PlayMp3File(bip);
    }
 
}
