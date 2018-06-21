package com.primeur.bcp.teletransfer.common.model;

import java.util.Date;

/**
 * This class is a POJO that contains notification data
 * 
 * @author Francisco Briones
 *
 */

public class Notification {
	
	private String contentID;
	
	//private String fileSetID;
	
	private String fileName;
	
	private Date actionTimeStamp;
	
	private String activityID;
	
	private String activityName;
	
	private String activityStatus;
	
	private String versus;
	
	private String userName;
	

	/**
	 * @return the contentID
	 */
	public String getContentID() {
		return contentID;
	}
	/**
	 * @param contentID the contentID to set
	 */
	public void setContentID(String contentID) {
		this.contentID = contentID;
	}

	
//		/**
//		 * @return the fileSetID
//		 */
//		public String getFileSetID() {
//			return fileSetID;
//		}
//		/**
//		 * @param fileSetID the fileSetID to set
//		 */
//		public void setFileSetID(String fileSetID) {
//			this.fileSetID = fileSetID;
//		}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param description the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the actionTimeStamp
	 */
	public Date getActionTimeStamp() {
		return actionTimeStamp;
	}
	/**
	 * @param actionTimeStamp the actionTimeStamp to set
	 */
	public void setActionTimeStamp(Date actionTimeStamp) {
		this.actionTimeStamp = actionTimeStamp;
	}

	/**
	 * @return the activityID
	 */
	public String getActivityID() {
		return activityID;
	}
	/**
	 * @param activityID the activityID to set
	 */
	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}

	/**
	 * @return the activityName
	 */
	public String getActivityName() {
		return activityName;
	}
	/**
	 * @param activityName the activityName to set
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	/**
	 * @return the activityStatus
	 */
	public String getActivityStatus() {
		return activityStatus;
	}
	/**
	 * @param activityStatus the activityStatus to set
	 */
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	/**
	 * @return the versus
	 */
	public String getVersus() {
		return versus;
	}
	/**
	 * @param versus the versus to set
	 */
	public void setVersus(String versus) {
		this.versus = versus;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
