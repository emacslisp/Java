package com.dw.lib.test;

public class AddShutdownHookTest {

	static class Message extends Thread {

		public void run() {
			System.out.println("Bye.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			// register Message as shutdown hook
			Runtime.getRuntime().addShutdownHook(new Message());

			// print the state of the program
			System.out.println("Program is starting...");

			// cause thread to sleep for 3 seconds
			System.out.println("Waiting for 3 seconds...");
			Thread.sleep(3000);

			// print that the program is closing
			System.out.println("Program is closing...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
