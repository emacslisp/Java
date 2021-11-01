package com.dw.lib.test;

public class Finalizers {
	public static void main(String[] args) { // (6)
		int blobsRequired, blobSize;
		try {
			blobsRequired = Integer.parseInt(args[0]);
			blobSize = Integer.parseInt(args[1]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Too few program arguments.");
			System.out.println("Usage: Finalizers <number of blobs> <blob size>");
			return;
		} catch (NumberFormatException e) {
			System.out.println("Illegal program argument.");
			System.out.println("Usage: Finalizers <number of blobs> <blob size>");
			return;
		}
		for (int i = 0; i < blobsRequired; ++i) { // (7)
			new Blob(blobSize);
		}
		System.out.println(BasicBlob.getPopulation() + " blobs alive"); // (8)
	}
}