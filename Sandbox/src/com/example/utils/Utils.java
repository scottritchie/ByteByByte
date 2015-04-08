package com.example.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Utils {

	/**
	 * The exceptionToString method converts a stack trace to a String.
	 * 
	 * @param ex
	 *            The exception.
	 * @return The stack trace as a String.
	 */
	public static String stackTraceToString(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
}