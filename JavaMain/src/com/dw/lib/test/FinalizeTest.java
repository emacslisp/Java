package com.dw.lib.test;

class Book {
	boolean checkedOut = false;

	Book(boolean checkOut) {
		checkedOut = checkOut;
	}

	void checkIn() {
		checkedOut = false;
	}

	protected void finalize() {
		System.out.println("xxxxx");
		if (checkedOut)
			System.out.println("Error: checked out");
		// Normally, you’ll also do this:
		// super.finalize(); // Call the base-class version
	}
}

public class FinalizeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book novel = new Book(true);
		// Proper cleanup:
		novel.checkIn();
		// Drop the reference, forget to clean up:
		new Book(true);

		// Force garbage collection & finalization:
		System.gc();
	}

}
