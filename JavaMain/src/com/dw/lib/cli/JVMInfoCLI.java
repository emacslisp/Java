package com.dw.lib.cli;

import com.dw.lib.JVMInfo;

public class JVMInfoCLI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String result = JVMInfo.getVMInfo();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
