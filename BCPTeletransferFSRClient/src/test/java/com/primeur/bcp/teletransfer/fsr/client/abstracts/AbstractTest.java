package com.primeur.bcp.teletransfer.fsr.client.abstracts;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.BeforeClass;

import com.primeur.bcp.teletransfer.fsr.client.BCPTeletransferFSRClient;

public class AbstractTest {
	
	private static final Logger logger = Logger.getLogger(AbstractTest.class);

	private static final String LOG4J_BCP = "log4jBCP.xml";
	
	// Development Environment Narsil
	private static final String FSR_WS_ENDPOINT = "http://192.168.170.202:8080/FileboxWEB/FileboxService";
	
	// Development Environment Narsil 2
//	private static final String FSR_WS_ENDPOINT = "http://192.168.170.202:8080/FileboxWEB-1.7.0-0004-SNAPSHOT/FileboxService";
	
	// Development Environment Saturno
//	private static final String FSR_WS_ENDPOINT = "http://192.168.2.147:8080/FileboxWEB-1.7.0-0004-SNAPSHOT/FileboxService";
	
	// Preproduction Environment AIX
//	private static final String FSR_WS_ENDPOINT = "http://192.168.3.210:8080/FileboxWEB/FileboxService";
	
	@BeforeClass
	public static void initFSRConnection()
	{
		// Initializing Log4j
		DOMConfigurator.configure(AbstractTest.class.getClassLoader().getResource(LOG4J_BCP));
		
		//
		BCPTeletransferFSRClient.setEndPoint(FSR_WS_ENDPOINT);
		logger.info("Connection to endpoint: " + FSR_WS_ENDPOINT );
	}
}
