package com.primeur.bcp.teletransfer.common.constant;

import com.primeur.bcp.teletransfer.common.util.TTTrackingUtil;

/**
 * Constants for communication with the Event Collector
 * @author PRIMEUR
 *
 */
public class TTTrackingConstants {
	
	/**
	 * URI prefixes for spazio and file system
	 * 
	 * URI example for SPAZIO:
	 * Sp2file://qmgr1/queue1/fileName1
	 * 
	 * URI example for File System
	 * file://path1/fileName1
	 */
	
	public static final String TRACK_PREF_FILE = "file://";
	
	public static final String TRACK_PREF_SPAZIO = "sp2file://";
	
	/**
	 * Action values for FSR
	 */
	
	public static final String TRACK_ACT_FILETACQ = "filetacq";
	
	public static final String TRACK_ACT_FILETDSP = "filetdsp";
	
	public static final String TRACK_ACT_MCPY = "mcpy";
	
	public static final String TRACK_ACT_MOVE = "move";
	
	public static final String TRACK_ACT_VALIDATION = "validation";
	
	public static final String TRACK_ACT_CONSOLIDATION = "consolidation";
	
	public static final String TRACK_ACT_DISTRIBUTION = "distribution";
	
	public static final String TRACK_ACT_FILEREMOVE = "fileremove";
	
	public static final String TRACK_ACT_UNZIP = "unzip";
	
	public static final String TRACK_ACT_SEND = "put";
	
	public static final String TRACK_ACT_RECEIVE = "get";
	
	/**
	 * Execution values
	 */
	
	public static final String ALIAS_VAL = "validator";
	
	public static final String ALIAS_DIS = "distributor";
	
	public static final String ALIAS_CON = "consolidator";
	
	public static final String ALIAS_EXT = "extractor";
	
	public static final String HOST_NAME = TTTrackingUtil.getHostName();
	
	/**
	 * Format values
	 */
	
	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	
	public static final String DATE_FORMAT_TABLE = "yyyy-MM-dd HH:mm:ss.SSS";
	
	public static final String DATE_FORMAT_REQUEST = "yyyy-MM-dd";
	
	/**
	 * Administrator type view
	 */
	public static final String VISUAL_ALL= "Todos";
	public static final String VISUAL_SENT_BY_CLIENT = "Enviado por cliente";
	public static final String VISUAL_CONSOLIDATOR = "Consolidación";
	public static final String VISUAL_DISTRIBUTOR = "Distribución";
	public static final String VISUAL_SENT_TO_CLIENT = "Enviado al cliente";
}

