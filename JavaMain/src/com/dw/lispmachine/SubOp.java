package com.dw.lispmachine;

import java.util.List;

public class SubOp implements IOp {
	public String op = "-";
	private LispMachine machine;
	public SubOp(LispMachine machine) {
		this.machine = machine;
	}
	@Override
	public String eval(List<SExp> SExps) throws Exception {
		float result = 0;
		String firstValue = SExps.get(0).getValue();
		
		for (SExp e: SExps) {
			if(e.getType() == SType.String) throw new Exception("can not add string type");
			String sValue = machine.eval(e);
			result += Float.parseFloat(sValue);
		}
		
		result = 2 * Float.parseFloat(firstValue) - result;
		
		return Float.toString(result);
	}

}
