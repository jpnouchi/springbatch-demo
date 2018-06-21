package com.primeur.bcp.teletransfer.common.util;

import java.text.SimpleDateFormat;
import java.util.UUID;

import com.primeur.bcp.teletransfer.common.constant.TTTrackingConstants;

public class TTTrackingUtil {

	/**
	 * Function that returns a String with the long passed as parameter
	 * @param milliseconds
	 * @return 
	 */
	public static final String convertToDate (long milliseconds){
		SimpleDateFormat df = new SimpleDateFormat(TTTrackingConstants.DATE_FORMAT);
		return df.format(milliseconds);
	}
	
	/**
	 * Function that returns the hostname of the local machine. In case it does not exist, it returns "unknow"
	 * @return host name
	 */
	public static final String getHostName(){
		try{
			return java.net.InetAddress.getLocalHost().getHostName();
		}catch (Exception e){
			return "unknow";
		}
	}
	
	/**
	 * Function that generate an UUID to identify the actions in notification
	 * @return
	 */
	public static final String getActionID(){
		String result = UUID.randomUUID().toString();
		return result;
	}
}
