package com.dw.lib.test;

import com.dw.lib.EnvironmentHelper;
import com.dw.lib.FileUtils;
import com.dw.lib.NetUtils;
import com.dw.lib.SimpleAudioPlayer;

public class DictAudioCLI {

	public static void main(String[] args) {

		try {
			/*if (args.length != 1){
				System.out.println("JDict associated tools to pronanuce a word");
				System.out.println("jAudio <execute file>");
				return;
			}*/
			
			String word = "paradox";
			String targetUrl = "http://dict.youdao.com/dictvoice?type=2&audio=" + word;
			String tempPath = "/tmp";
			String pathSpliter = "/";
			
			
			if (EnvironmentHelper.getOSType() == EnvironmentHelper.OSType.WIN) {
				tempPath = EnvironmentHelper.getEnv("TEMP");
				pathSpliter = "\\";
			}
			
			String targetPath = tempPath + pathSpliter + word + ".mp3";
			
			FileUtils utils = new FileUtils();
			if(!utils.isExisted(targetPath)) {
				NetUtils.HttpDownload(targetUrl, targetPath);
			}
			
			SimpleAudioPlayer.PlayMp3File(targetPath);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
