package com.dw.algorithmlib;

public class Pair {
	public int first;
	public int second;
	
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public int hashCode() {
	    return (new Integer(first)).hashCode() + 31*(new Integer(second)).hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair o1 = (Pair)o;
	   return (this.first == o1.first && this.second == o1.second) || (this.first == o1.second && this.second == o1.first);
	}
}
