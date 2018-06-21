package com.primeur.bcp.teletransfer.common.exception;

public class ClientVersionOutdatedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClientVersionOutdatedException(String message) {

		super(message);
	}
}
