package com.primeur.bcp.teletransfer.common.constant;

public class ProductConstants {
	
	// Queue Name Conventions
	public static final String APP_QUEUE_NAME_PREFIX = "QAPP.";
	public static final String WMQFTE_QUEUE_NAME_SUFFIX = ".FTE";
	public static final String PRODUCT_QUEUE_NAME_PREFIX = "QP.";
	
	public static final String APP_QUEUE_NAME_FORMAT = APP_QUEUE_NAME_PREFIX + "%s" + WMQFTE_QUEUE_NAME_SUFFIX;
	public static final String PRODUCT_IN_QUEUE_NAME_FORMAT = PRODUCT_QUEUE_NAME_PREFIX + "%s" + BCPTTCommonConstants.IN_QUEUE_NAME_SUFFIX;
	public static final String PRODUCT_OUT_QUEUE_NAME_FORMAT = PRODUCT_QUEUE_NAME_PREFIX + "%s" + BCPTTCommonConstants.OUT_QUEUE_NAME_SUFFIX;
	
	// Consolidator and Distributor Status
	public static final char NOT_HAS_STATUS = '0';
	public static final char ACTIVE_STATUS = '1';
	public static final char UNACTIVE_STATUS = '2';
	
	// App Interface Types
	public static final char QUEUE_APP_INTERFACE_TYPE = 'Q';
	public static final char FILE_APP_INTERFACE_TYPE = 'F';
}
