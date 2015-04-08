package com.example.test;

public class Floor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int someVal = 0; someVal < 10; someVal++) {
			System.out.println(someVal + " floor: " + (int) (Math.floor(someVal/8) + 1));
		}
	}

}
