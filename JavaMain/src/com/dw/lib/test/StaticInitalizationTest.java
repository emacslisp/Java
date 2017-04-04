package com.dw.lib.test;

//: initialization/Spoon.java
class Spoon {
	static int i;
	static {
		i = 47;
	}
} /// :~

class Cup {
	Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
	}

	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}

	Cups() {
		//@important: this is not called at all
		System.out.println("Cups()");
	}
}

public class StaticInitalizationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside main()");
		 Cups.cup1.f(99); // (1) 
	}

}
