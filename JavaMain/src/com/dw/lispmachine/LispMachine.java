package com.dw.lispmachine;

import java.util.ArrayList;
import java.util.HashMap;

public class LispMachine {
	HashMap<String, IOp> m = new HashMap<String, IOp>();
	public LispMachine() {
		// TODO: add those into list
		AddOp addop = new AddOp(this);
		m.put(addop.op, addop);
		
		SubOp subop = new SubOp(this);
		m.put(subop.op, subop);
		
		PrintOp printOp = new PrintOp(this);
		m.put(printOp.op, printOp);
	}
	
	public String eval(SExp exp) throws Exception {
		if(exp.getType() != SType.SExp)
			return exp.getValue();
		else {
			IOp op = m.get(exp.getOp());
			return op.eval(exp.getVariable());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SExp mainExp = new SExp("+");
		
		SExp exp1 = new SExp(SType.Float, "1.2");
		
		mainExp.add(exp1);
		
		SExp exp2 = new SExp(SType.Float, "2.3");
		
		mainExp.add(exp2);
		
		SExp mainExp2 = new SExp("+");
		mainExp2.add(exp1);
		mainExp2.add(exp2);
		
		SExp mainExp3 = new SExp("+");
		mainExp3.add(exp1);
		mainExp3.add(exp2);
		mainExp3.add(exp2);
		
		mainExp2.add(mainExp3);
		
		mainExp.add(mainExp2);
		
		LispMachine machine = new LispMachine();
		
		try {
			System.out.println(machine.eval(mainExp));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
