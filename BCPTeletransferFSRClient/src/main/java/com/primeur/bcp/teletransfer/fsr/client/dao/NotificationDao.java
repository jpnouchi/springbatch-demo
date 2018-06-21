package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.constant.TTTrackingConstants;
import com.primeur.bcp.teletransfer.common.model.Notification;
import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.bcp.teletransfer.fsr.client.constant.FSRClientConstants;
import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.bcp.teletransfer.fsr.client.util.FSRClientUtil;
import com.primeur.spmfts.filebox.domain.DistinctMetadataSetList;
import com.primeur.spmfts.filebox.domain.Fileset;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.domain.MetadataSet;

/**
 * Class used to access SPFB_BCP_COMPANY_MD
 * 
 * @author Francisco Briones
 *
 */
public class NotificationDao {
	
	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(NotificationDao.class);

	
	// The METADATACLASS ...
	private static final String METADATACLASS_BCP_NOTIFICATION = "FTEE_FILE_ACTIVITIES_VIEW";
	
	// ... and its METADATANAMEs
	public static final String METADATANAME_CONTENT_ID						= "CONTENT_ID";						// VARCHAR()
	//public static final String METADATANAME_ID_FILESET					= "ID_FILESET";						// VARCHAR()
	public static final String METADATANAME_FILE_NAME						= "FILE_NAME";						// VARCHAR()
	public static final String METADATANAME_ACTION_TS          				= "ACTION_TS";						// TIMESTAMP()
	public static final String METADATANAME_ACTIVITY_ID		          		= "ID_FILE_ACTIVITY";				// VARCHAR()
	public static final String METADATANAME_ACTIVITY_NAME          			= "ACTIVITY_NAME";					// VARCHAR()
	public static final String METADATANAME_ACTIVITY_STATUS          		= "ACTIVITY_STATUS";				// VARCHAR()
	public static final String METADATANAME_VERSUS          				= "VERSUS";							// VARCHAR()
	public static final String METADATANAME_USERNAME          				= "USERNAME";						// VARCHAR()
	
	// Logger dataType constant
	private static final String DATA_TYPE = FSRClientConstants.NOTIFICATION;
		
	/**
	 * Inserts a notification record into FSR database
	 * 
	 * @param notification notification to insert
	 * @throws Exception
	 */
	public synchronized static Notification insertNotification (Notification notification) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_INSERT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, notification.getActivityID()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		SimpleDateFormat dt = new SimpleDateFormat(TTTrackingConstants.DATE_FORMAT_TABLE);
		
		Fileset notificationFileset = new Fileset();
		notificationFileset.setIdUserClass(FSRClientConstants.FSR_REMOTE_DB_BCP_ID_USER_CLASS);
		MetadataSet notificationMetadataSet = new MetadataSet();
		notificationMetadataSet.setMetadataClass(METADATACLASS_BCP_NOTIFICATION);
		
		notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CONTENT_ID, notification.getContentID()));
		//notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_ID_FILESET, notification.getFileSetID()));
		notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_FILE_NAME, notification.getFileName()));
		notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_ACTION_TS, notification.getActionTimeStamp(),dt));
		notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_ACTIVITY_ID, notification.getActivityID()));
		notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_ACTIVITY_NAME, notification.getActivityName()));
		notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_ACTIVITY_STATUS, notification.getActivityStatus()));
		notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_VERSUS, notification.getVersus()));
		notificationMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USERNAME, notification.getUserName()));
		
		notificationFileset.addMetadataSet(notificationMetadataSet);
		
		// following instruction persists data into remote db
		notificationFileset.save();
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, notification.getActivityID()));
		
		return notification;
	}		
	
	/**
	 * Returns a notification list. All listed notifications match the whereClause.
	 * 
	 * @return notification list
	 * @throws Exception
	 */
	public synchronized static List<Notification> getNotificationList () throws Exception {
		return getNotificationList(null, null, 0, 10);
	}
	
	/**
	 * Returns a notification list. All listed notifications match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return notification list
	 * @throws Exception
	 */
	public synchronized static List<Notification> getNotificationList (String whereClause) throws Exception {
		return getNotificationList(whereClause, null, 0, 0);
	}
	
	/**
	 * Returns a notification list. All listed notifications match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @param orderByClause order by clause for retrieving information from database
	 * @param offset
	 * @param count number of records
	 * @return notification list
	 * @throws Exception
	 */
	public synchronized static List<Notification> getNotificationList (String whereClause, String orderByClause, int offset, int count) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
						
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
				
		List<Notification> notificationList = new ArrayList<Notification>();
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_NOTIFICATION);
		FilesetList notificationFilesetList;
		
		if (whereClause != null && whereClause.length() > 0) {
			if (orderByClause != null && orderByClause.length() > 0) {
				notificationFilesetList = new FilesetList(metadataClass, whereClause, orderByClause, offset, count, false, true);
			} else {
				notificationFilesetList = new FilesetList(metadataClass, whereClause, offset, count, false, true);
			}
		} else {
			notificationFilesetList = new FilesetList(metadataClass, offset, count);
		}
		
		for (Fileset notificationFileset : notificationFilesetList) {
		  
			for (MetadataSet notificationMetadataSet : notificationFileset.getMetadataSetList()) {

		    	Notification notification = fillNotificationData(new Notification(), notificationMetadataSet);
				notificationList.add(notification);
				logger.debug("Notification:");
				logger.debug(" - Content ID:\t" + notification.getContentID());
				//logger.debug(" - " + notification.getFileSetID());
				logger.debug(" - File Name:\t\t" + notification.getFileName());
				logger.debug(" - Action TimeStamp:\t" + notification.getActionTimeStamp());	
				logger.debug(" - Activity ID:\t" + notification.getActivityID());
				logger.debug(" - Activity Name:\t" + notification.getActivityName());
				logger.debug(" - Activity Status:\t" + notification.getActivityStatus());
				logger.debug(" - ContentID:\t\t" + notification.getContentID());
				logger.debug(" - Versus:\t\t" + notification.getVersus());
				logger.debug(" - User Name:\t\t" + notification.getUserName());
				logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		    }
		}
		
		if (orderByClause != null && orderByClause.length() > 0) {
			
			if (orderByClause.contains(METADATANAME_ACTION_TS + " ASC")) {
				
				Collections.sort(notificationList, new Comparator<Notification>() {	
					public int compare(Notification n1, Notification n2) {
						return n1.getActionTimeStamp().compareTo(n2.getActionTimeStamp());
					}
				});
				
			} else if (orderByClause.contains(METADATANAME_ACTION_TS + " DESC")) {
				
				Collections.sort(notificationList, new Comparator<Notification>() {	
					public int compare(Notification n1, Notification n2) {				
						return n2.getActionTimeStamp().compareTo(n1.getActionTimeStamp());
					}
				});
			}
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		return notificationList;
	}
	
	/**
	 * Returns the count of all notifications that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return notification list count
	 * @throws Exception
	 */
	public synchronized static int getNotificationListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug("notificationListCount whereClause: " + whereClause);
		
		int notificationListCount = FilesetList.countRecordByClass(METADATACLASS_BCP_NOTIFICATION, whereClause);
		
		logger.debug("notificationListCount: " + notificationListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return notificationListCount;
	}
	
	/**
	 * Fills a notification with the data retrieved from a FSR MetadataSet.
	 * 
	 * @param notification notification to be filled
	 * @param companyMetadataSet
	 * @return filled notification
	 * @throws Exception
	 */
	private synchronized static Notification fillNotificationData(Notification notification, MetadataSet notificationMetadataSet) throws Exception {
		
		SimpleDateFormat dt = new SimpleDateFormat(TTTrackingConstants.DATE_FORMAT_TABLE);
		
		notification.setContentID(notificationMetadataSet.getMetadataValue(METADATANAME_CONTENT_ID).getValue());
		//notification.setFileSetID(notificationMetadataSet.getMetadataValue(METADATANAME_ID_FILESET).getValue());
		notification.setFileName(notificationMetadataSet.getMetadataValue(METADATANAME_FILE_NAME).getValue());
		notification.setActionTimeStamp(ParseUtil.stringToDate(notificationMetadataSet.getMetadataValue(METADATANAME_ACTION_TS).getValue(),dt));
		notification.setActivityID(notificationMetadataSet.getMetadataValue(METADATANAME_ACTIVITY_ID).getValue());
		notification.setActivityName(notificationMetadataSet.getMetadataValue(METADATANAME_ACTIVITY_NAME).getValue());
		notification.setActivityStatus(notificationMetadataSet.getMetadataValue(METADATANAME_ACTIVITY_STATUS).getValue());
		notification.setVersus(notificationMetadataSet.getMetadataValue(METADATANAME_VERSUS).getValue());
		notification.setUserName(notificationMetadataSet.getMetadataValue(METADATANAME_USERNAME).getValue());
		
		return notification;
	}
	
	public synchronized static List<Notification> getDistinctNotificationList(String whereClause, String orderByClause, int offset, int count) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
						
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
				
		List<Notification> notificationList = new ArrayList<Notification>();
		
		String[] fields = {METADATANAME_CONTENT_ID, METADATANAME_ACTIVITY_ID, METADATANAME_FILE_NAME};
		
		DistinctMetadataSetList notificationDistinctMetadataSetList = new DistinctMetadataSetList(METADATACLASS_BCP_NOTIFICATION, fields, whereClause, orderByClause, offset, count);
		  
		for (MetadataSet notificationMetadataSet : notificationDistinctMetadataSetList) {

			Notification notification = new Notification();
			notification.setContentID(notificationMetadataSet.getMetadataValue(METADATANAME_CONTENT_ID).getValue());
			notification.setActivityID(notificationMetadataSet.getMetadataValue(METADATANAME_ACTIVITY_ID).getValue());
			notification.setFileName(notificationMetadataSet.getMetadataValue(METADATANAME_FILE_NAME).getValue());
			notificationList.add(notification);	
			
			logger.debug("Notification:");
			logger.debug(" - Content ID:\t" + notification.getContentID());
			logger.debug(" - Activity ID:\t" + notification.getActivityID());
			logger.debug(" - File Name:\t\t" + notification.getFileName());
			logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
	    }
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		return notificationList;
	}
	
	/**
	 * Returns the count of all notifications that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return notification list count
	 * @throws Exception
	 */
	public synchronized static int getDistinctNotificationListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug("notificationListCount whereClause: " + whereClause);
		
		String[] fields = {METADATANAME_CONTENT_ID, METADATANAME_ACTIVITY_ID, METADATANAME_FILE_NAME};
		
		int notificationListCount = DistinctMetadataSetList.countRecordBcountDistinctRecordByClass(METADATACLASS_BCP_NOTIFICATION, fields, whereClause);
		
		logger.debug("notificationListCount: " + notificationListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return notificationListCount;
	}
}