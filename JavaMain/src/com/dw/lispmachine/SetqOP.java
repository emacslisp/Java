package com.dw.lispmachine;

import java.util.List;

public class SetqOP implements IOp {
	public String op = "setq";
	private LispMachine machine;
	
	public SetqOP(LispMachine machine) {
		this.machine = machine;
	}

	@Override
	public String eval(List<SExp> SExps) throws Exception {
		
		if(SExps.size() < 2) {
			throw new Exception("Setq require at lease variable name and variable value");
		}

		String[] setqExps = new String[2];
		for (int i=0;i<2;i++) {
			SExp e = SExps.get(i);
			setqExps[i] = machine.eval(e);
		}
		
		this.machine.getMemory().put(setqExps[0], setqExps[1]);
		
		return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
