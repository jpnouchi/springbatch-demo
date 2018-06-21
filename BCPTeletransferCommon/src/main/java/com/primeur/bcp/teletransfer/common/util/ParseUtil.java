package com.primeur.bcp.teletransfer.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;

public class ParseUtil {

	private static final Logger logger = Logger.getLogger(ParseUtil.class);

	public synchronized static Date stringToDate (String string, DateFormat dateFormat) {
		
		Date response = null;
		
		try {
			
			response = string != null ? dateFormat.parse(string) : null;
			
		} catch (ParseException e){
			
			logger.error("ERROR PARSING STRING '" + string + "' TO DATE.");
		}
		
		return response;
	}
	
	public synchronized static String dateToString (Date date, DateFormat dateFormat) {
		
		String response = null;
		
		try {
			
			response = date != null ? dateFormat.format(date) : null;
			
		} catch (Exception e){
			
			logger.error("ERROR PARSING DATE '" + date + "' TO STRING.");
		}
		
		return response;
	}
	
	public static Integer booleanToInteger (Boolean bool) {
		
		Integer response = null;
		
		try {
			
			response = bool != null ? (bool ? 1 : 0) : null;
			
		} catch (Exception e){
			
			logger.error("ERROR PARSING BOOLEAN '" + bool + "' TO INTEGER.");
		}
		
		return response;
	}
	
	public static Boolean IntegerToBoolean (Integer integer) {
		
		Boolean response = null;
		
		try {
			
			response = integer != null ? ((integer.intValue() == 1) ? new Boolean(true): new Boolean(false)) : null;
			
		} catch (Exception e){
			
			logger.error("ERROR PARSING INTEGER '" + integer + "' TO BOOLEAN.");
		}
		
		return response;
	}
}
