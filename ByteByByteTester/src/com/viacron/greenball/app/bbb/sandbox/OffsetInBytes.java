package com.viacron.greenball.app.bbb.sandbox;

public class OffsetInBytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int offsetInBits = 0; offsetInBits < 32; offsetInBits++) {
			System.out.println(String.format("# of bits: %d, # of bytes: %d",
					offsetInBits, Math.round(offsetInBits / 8)
							+ (offsetInBits % 8 == 0 ? 0 : 1)));
		}
	}

}
