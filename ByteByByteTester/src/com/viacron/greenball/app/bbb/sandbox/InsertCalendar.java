package com.viacron.greenball.app.bbb.sandbox;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.viacron.greenball.app.bbb.GreenballMessagesUtility;

public class InsertCalendar {

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
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date date = new Date();
		System.out.println("date1: " + dt.format(date));
		long lng = date.getTime();
		System.out.println("lng: " + lng);
		ba = GreenballMessagesUtility.insertLong(ba, 0, lng);
		System.out.println(GreenballMessagesUtility.dumpHexData("ba", ba, ba.length));
		long lng2 = GreenballMessagesUtility.getLong(ba, 0);
		System.out.println("lng2: " + lng2);
		Date date2 = new Date(lng2);
		System.out.println("date2: " + dt.format(date2));
	}

}
