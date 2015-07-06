package com.example.test;

import com.viacron.greenball.app.bbb.ABoolTestMessage;
import com.viacron.greenball.app.bbb.BoolSubType;
import com.viacron.greenball.app.bbb.MissingAttributeException;

public class TestRule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ABoolTestMessage aBoolTestMessage = new ABoolTestMessage();
		BoolSubType aBoolSubType = new BoolSubType();
		aBoolSubType.setABool(true);
		aBoolTestMessage.setABoolSubType(aBoolSubType);
		
		try {
			String msg = aBoolTestMessage.packStr();
			System.out.println("msg: " + msg);
		} catch (MissingAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
