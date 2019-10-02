package com.dw.lispmachine;

import java.util.ArrayList;
import java.util.List;

public class SExp {
	private SType type;
	private String Value;
	private String op;
	private List<SExp> variable;
	public SExp(SType type, String Value) {
		this.type = type;
		this.Value = Value;
	}
	
	public SExp(String op) {
		this.type = SType.SExp;
		this.op = op;
		this.variable = new ArrayList<SExp>();
	}

	public void add(SExp buildExp) {
		// TODO Auto-generated method stub
		variable.add(buildExp);
	}
	
	public SType getType() {
		return type;
	}

	public void setType(SType type) {
		this.type = type;
	}

	public String getValue() {
		return Value;
	}

	public String getOp() {
		return op;
	}

	public List<SExp> getVariable() {
		return variable;
	}
}
