package com.primeur.bcp.teletransfer.common.constant;

import java.text.SimpleDateFormat;

public class BCPTTCommonConstants {
	
	public static final String TT_VERSION = "v1.3.0";
	public static final String TT_VERSION_PREFIX = "v";
	public static final String TT_VERSION_NUMBER_SEPARATOR = "\\.";
	public static final String TT_VERSION_COMMENT_SEPARATOR = "-";
	
	public static final String UTF8_ENCODING = "UTF-8";
	
	public static final String LONG_TIMESTAMP_FORMAT_STRING = "ddMMyyyy_HHmmss";

	public static final String SHORT_DATE_FORMAT_STRING = "dd/MM/yyyy";
	
	public static final String LONG_DATE_FORMAT_STRING = "dd/MM/yyyy HH:mm:ss";
	
	public static final SimpleDateFormat LONG_TIMESTAMP_FORMAT= new SimpleDateFormat(LONG_TIMESTAMP_FORMAT_STRING);
	
	public static final SimpleDateFormat SHORT_DATE_FORMAT= new SimpleDateFormat(SHORT_DATE_FORMAT_STRING);
	
	public static final SimpleDateFormat LONG_DATE_FORMAT= new SimpleDateFormat(LONG_DATE_FORMAT_STRING);

	public static final String A3SP_CONFIG_PATH_PROPERTY_NAME = "SPAZIO";
	
	// Queue Name Conventions
	public static final String IN_QUEUE_NAME_SUFFIX = ".IN";
	public static final String OUT_QUEUE_NAME_SUFFIX = ".OUT";
	
	public static final String ENCODED_FIELD = "********";
}
