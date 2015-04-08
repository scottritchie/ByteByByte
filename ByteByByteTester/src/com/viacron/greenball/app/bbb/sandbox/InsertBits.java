package com.viacron.greenball.app.bbb.sandbox;

import com.viacron.greenball.app.bbb.GreenballMessagesUtility;

public class InsertBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] ba = new byte[45];
		ba[0] = 0x00;
		ba[1] = 0x00;
		ba[2] = 0x00;
		ba[3] = 0x00;
		
		System.out.println(GreenballMessagesUtility.dumpHexData("ba", ba, ba.length));

		ba = GreenballMessagesUtility.insertBitfield(ba, 43, 8, (byte) 0xff);
		System.out.println(GreenballMessagesUtility.dumpHexData("ba", ba, ba.length));

	}

}
