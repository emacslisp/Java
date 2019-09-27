package com.dw.lispmachine;

import java.util.List;

public class SExp {
	public SType type;
	public String Value;
	public String op;
	public List<SExp> variable;
	public SExp(SType type, String Value) {
		this.type = type;
		this.Value = Value;
	}
	
	public SExp(String op, List<SExp> variable) {
		this.type = SType.SExp;
		this.op = op;
		this.variable = variable;
	}
}
