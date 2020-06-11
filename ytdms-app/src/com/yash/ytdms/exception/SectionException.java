package com.yash.ytdms.exception;

public class SectionException extends Exception{
	/**
	 * This creates the SectionException object without error message
	 */
	public SectionException() {
		super();
	}
	/**
	 * This creates the SectionException object with error message
	 */
	public SectionException(String errMsg) {
		super(errMsg);
	}

}
