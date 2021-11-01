package com.dw.lib.test;

class BasicBlob { // (1)
	private static int idCounter;
	private static int population;
	protected int blobId;

	BasicBlob() {
		blobId = idCounter++;
		++population;
	}

	@Override
	protected void finalize() throws Throwable { // (2)
		super.finalize();
	}

	public static int getPopulation() {
		return population;
	}
}
