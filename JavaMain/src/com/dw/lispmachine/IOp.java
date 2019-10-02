package com.dw.lispmachine;

import java.util.List;

public interface IOp {
	public String op= "";
	public String eval(List<SExp> SExps) throws Exception;
}
