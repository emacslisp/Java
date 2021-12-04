package com.dw.lib.test;

import static com.dw.lib.Print.*;

enum Note {
	MIDDLE_C, C_SHARP, B_FLAT; // Etc.
} ///:~

class Instrument {
	void play(Note n) {
		print("Instrument.play() " + n);
	}

	String what() {
		return "Instrument";
	}

	void adjust() {
		print("Adjusting Instrument");
	}
}

class Wind extends Instrument {
	void play(Note n) {
		print("Wind.play() " + n);
	}

	String what() {
		return "Wind";
	}

	void adjust() {
		print("Adjusting Wind");
	}
}


public class PolymorphismTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
