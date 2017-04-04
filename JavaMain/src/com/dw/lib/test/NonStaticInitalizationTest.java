package com.dw.lib.test;

import static com.dw.lib.test.Print.*;

class Mug {
	Mug(int marker) {
		print("Mug(" + marker + ")");
	}

	void f(int marker) {
		print("f(" + marker + ")");
	}
}

class Mugs {
	Mug mug1;
	Mug mug2;
	{
		mug1 = new Mug(1);
		mug2 = new Mug(2);
		print("mug1 & mug2 initialized");
	}

	Mugs() {
		print("Mugs()");
	}

	Mugs(int i) {
		print("Mugs(int)");
	}

	public static void main(String[] args) {
		print("Inside main()");
		new Mugs();
		print("new Mugs() completed");
		new Mugs(1);
		print("new Mugs(1) completed");
	}
}

public class NonStaticInitalizationTest {
	public static void main(String[] args) {
		Mugs.main(args);
	}
}
