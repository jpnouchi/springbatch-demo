package com.primeur.bcp.teletransfer.common.exception;

public class UserNotAuthorizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotAuthorizedException(String message) {

		super(message);
	}
}
