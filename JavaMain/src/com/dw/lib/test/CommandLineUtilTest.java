package com.dw.lib.test;

import java.io.File;

import com.dw.lib.CommandLineUtil;
import com.dw.lib.CommandLineUtil.Report;

public class CommandLineUtilTest {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		String cmd = "/bin/sh -c \"cd /tmp/1/1; ./ABProblem_zoj.run < q1u1.in > q1u1.out\"";
		String[] cmds = new String[] {
				"/bin/sh",
				"-c",
				"cd /tmp/1/1; ./ABProblem_zoj.run < q1u1.in > q1u1.out"
		};
		CommandLineUtil u = new CommandLineUtil();
		Report report = (u.runCommand(cmds, 10, new File("/tmp")));
		
		System.out.print(report.output);
	}

}
