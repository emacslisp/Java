package com.dw.lispmachine;

import java.util.List;

public class AddOp implements IOp {
	public String op = "+";
	private LispMachine machine;
	public AddOp(LispMachine machine) {
		this.machine = machine;
	}
	
	public String eval(List<SExp> SExps) {
		float result = 0;
		
		for (SExp e: SExps) {
			String sValue = machine.eval(e);
			result += Float.parseFloat(sValue);
		}
		
		return Float.toString(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
