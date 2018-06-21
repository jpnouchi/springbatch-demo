package com.primeur.bcp.teletransfer.common.constant;

public class CompanyConstants {
	
	// Queue Name Conventions
	public static final String COMPANY_QUEUE_NAME_PREFIX = "C.";
	
	public static final String COMPANY_IN_QUEUE_NAME_FORMAT = COMPANY_QUEUE_NAME_PREFIX + "%s" + BCPTTCommonConstants.IN_QUEUE_NAME_SUFFIX;
	public static final String COMPANY_OUT_QUEUE_NAME_FORMAT = COMPANY_QUEUE_NAME_PREFIX + "%s" + BCPTTCommonConstants.OUT_QUEUE_NAME_SUFFIX;

	// Client Types
	public static final char TELETRANSFER_CLIENT_CLIENT_TYPE = '0';
	public static final char TTMATIC_CLIENT_TYPE = '1';
	public static final char SFTP_CLIENT_TYPE = '2';
	
	public static final String TELETRANSFER_CLIENT_CLIENT_TYPE_TEXT = "Cliente Teletransfer";
	public static final String TTMATIC_CLIENT_TYPE_TEXT = "TTMatic";
	public static final String SFTP_CLIENT_TYPE_TEXT = "SFTP";
	
	// Company Status
	public static final char ACTIVE_STATUS = 'A';
	public static final char UNACTIVE_STATUS = 'U';
	public static final char DELETED_STATUS = 'D';
}
