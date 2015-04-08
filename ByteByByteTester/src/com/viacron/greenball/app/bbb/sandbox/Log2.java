package com.viacron.greenball.app.bbb.sandbox;

public class Log2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int value = 0; value < 32; value++) {
			System.out
					.println("value: "
							+ value
							+ ", log2: "
							+ (Integer.SIZE - Integer
									.numberOfLeadingZeros(value > 0 ? value - 1
											: value)));
		}
	}

}
