package com.dw.lispmachine;

import java.util.List;

public class PrintOp implements IOp {
	public String op = "print";
	private LispMachine machine;
	public PrintOp(LispMachine machine) {
		this.machine = machine;
	}
	
	public String eval(List<SExp> SExps) throws Exception {
		
		for (SExp e: SExps) {
			String sValue = machine.eval(e);
			System.out.println(sValue);
		}
		
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
