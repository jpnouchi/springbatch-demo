package com.primeur.bcp.teletransfer.common.exception;

public class UserSessionExpiredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserSessionExpiredException(String message) {

		super(message);
	}
}
