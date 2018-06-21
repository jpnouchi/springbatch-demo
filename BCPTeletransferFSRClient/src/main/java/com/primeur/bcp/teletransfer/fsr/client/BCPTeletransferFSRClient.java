package com.primeur.bcp.teletransfer.fsr.client;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.spmfts.filebox.FileboxClient;

/**
 * BCPTeletransferFSRClient Class
 * 
 * @author David Reyes
 *
 */
public class BCPTeletransferFSRClient {
	
	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(BCPTeletransferFSRClient.class);
	
	/**
	 * Initializes FSR FileboxClient and sets the connection
	 * to the specified url
	 * 
	 * @param endpoint FSR url to connect
	 */
	public static void setEndPoint(String endpoint) {
		FileboxClient.setEndpoint(endpoint);
		logger.info(String.format(LoggerMessages.FSR_CONNECTION_FORMAT, endpoint));
	}
}
