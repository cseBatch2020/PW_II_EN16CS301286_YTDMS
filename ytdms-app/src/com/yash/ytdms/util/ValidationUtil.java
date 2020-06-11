package com.yash.ytdms.util;

/**
 * This class is used to perform various kind of validation.
 * 
 * @author samay.jain
 *
 */
public class ValidationUtil {

	/**
	 * This method is used to check the length of the provided String
	 * @param value to be checked ( need to check the length )
	 * @param upperLimit is the upper limit to check
	 * @return true if length is grater than the provided upperLimit otherwise false
	 */
	public static boolean validateLength(String value, int upperLimit) {
		if (value.length() > upperLimit) {
			return true;
		} else {
			return false;	
		}
	}
	/**
	 * This method is used to check the length of the provided String
	 * @param documentContent  value to be check
	 * @param lowerLimit is the lower limit to check
	 * @return
	 */
	public static boolean validateContent(String documentContent , int lowerLimit) {
		if (documentContent.length() > lowerLimit) {
			return true;
		} else {
			return false;
		}
		
	}
	public static boolean validateSection(String value,int upperLimit) {
		if (value.length() > upperLimit || value.length() < 2 ) {
			return true;
		} else {
			return false;
		}
	}

}
