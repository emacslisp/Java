package com.dw.lispmachine;

import java.util.ArrayList;
import java.util.HashMap;

public class LispMachine {
	HashMap<String, IOp> m = new HashMap<String, IOp>();
	public LispMachine() {
		AddOp addop = new AddOp(this);
		m.put(addop.op, addop);
	}
	
	public String eval(SExp exp) {
		if(exp.type != SType.SExp)
			return exp.Value;
		else {
			IOp op = m.get(exp.op);
			return op.eval(exp.variable);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SExp mainExp = new SExp("+", new ArrayList<SExp>());
		
		SExp exp1 = new SExp(SType.Float, "1.2");
		
		mainExp.variable.add(exp1);
		
		SExp exp2 = new SExp(SType.Float, "2.3");
		
		mainExp.variable.add(exp2);
		
		SExp mainExp2 = new SExp("+", new ArrayList<SExp>());
		mainExp2.variable.add(exp1);
		mainExp2.variable.add(exp2);
		
		SExp mainExp3 = new SExp("+", new ArrayList<SExp>());
		mainExp3.variable.add(exp1);
		mainExp3.variable.add(exp2);
		mainExp3.variable.add(exp2);
		
		mainExp2.variable.add(mainExp3);
		
		mainExp.variable.add(mainExp2);
		
		LispMachine machine = new LispMachine();
		System.out.println(machine.eval(mainExp));
		
	}

}
