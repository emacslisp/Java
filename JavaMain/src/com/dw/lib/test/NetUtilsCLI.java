package com.dw.lib.test;
import com.dw.lib.NetUtils;

public class NetUtilsCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0) {
			System.out.println("get <ULR>");
			System.out.println("get <URL> <output file> ");
			return;
		}
		
		try {
			if(args.length == 1) 
				NetUtils.HttpDownload(args[0],null);
			else
				NetUtils.HttpDownload(args[0], args[1]);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
