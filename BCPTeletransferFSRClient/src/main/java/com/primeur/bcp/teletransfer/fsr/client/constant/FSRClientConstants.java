package com.primeur.bcp.teletransfer.fsr.client.constant;

import java.text.SimpleDateFormat;

/**
* General FSR Client constants
* 
* @author David Reyes
*
*/
public class FSRClientConstants {
	
	public static final int FSR_UPDATE_EXTENDED_MD_MAXIMUM_RETRIES = 3;
	public static final int FSR_UPDATE_EXTENDED_MD_RETRY_DELAY_MILLIS = 3000;
	
	public static final int FSR_REMOTE_DB_BCP_ID_USER_CLASS = 4;	// should be known id advance.
	public static final int BCPTTADMIN_AUDIT_USER_CLASS = 8;		// should be known id advance.
	
	public static final String BCPTTADMIN_AUDIT_USER_CLASS_CODE = "BCPTTADMIN_AUDIT";
	
	public static final String FSR_DB_DATE_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss.SSS";
	
	public static final String FSR_DB_FILE_DATE_FORMAT_STRING = "yyyyMMddHHmmss.S";
	
	public static final SimpleDateFormat FSR_DB_DATE_FORMAT = new SimpleDateFormat(FSR_DB_DATE_FORMAT_STRING);
	
	public static final SimpleDateFormat FSR_DB_FILE_DATE_FORMAT = new SimpleDateFormat(FSR_DB_FILE_DATE_FORMAT_STRING);
	
	// Data Types
	public static final String AUDIT_RECORD 		= "AUDIT RECORD";
	public static final String COMPANY 				= "COMPANY";
	public static final String COMPANY_PRODUCT 		= "COMPANY PRODUCT";
	public static final String DEPARTMENT 			= "DEPARTMENT";
	public static final String DISTRICT 			= "DISTRICT";
	public static final String FILE 				= "FILE";
	public static final String NOTIFICATION 		= "NOTIFICATION";
	public static final String PRODUCT 				= "PRODUCT";
	public static final String PROVINCE				= "PROVINCE";
	public static final String USER 				= "USER";
	public static final String SYSTEM_PROPERTY		= "SYSTEM PROPERTY";
	//TODO Verify this value
	public static final String E2E_RECORD 			= "E2E RECORD";
		
	// Operations
	public static final String OPERATION_INSERT		= "INSERT";
	public static final String OPERATION_UPDATE 	= "UPDATE";
	public static final String OPERATION_DELETE 	= "DELETE";
	public static final String OPERATION_DELETE_ALL = "DELETE ALL";
	public static final String OPERATION_LIST 		= "LIST";
	public static final String OPERATION_LIST_COUNT = "LIST COUNT";
	public static final String OPERATION_GET 		= "GET";
}
