package com.primeur.bcp.teletransfer.common.model;

import java.util.Date;

/**
 * This class is a POJO that contains product data
 * 
 * @author David Reyes
 *
 */
public class Product {

	private String productCode;
	
	private String description;
	
	private Integer displacement;
	
	private Date mondayStartDate;
	private Date mondayEndDate;
	private Date tuesdayStartDate;
	private Date tuesdayEndDate;
	private Date wednesdayStartDate;
	private Date wednesdayEndDate;
	private Date thursdayStartDate;
	private Date thursdayEndDate;
	private Date fridayStartDate;
	private Date fridayEndDate;
	private Date saturdayStartDate;
	private Date saturdayEndDate;
	private Date sundayStartDate;
	private Date sundayEndDate;
	
	private Boolean validator;
	
	private char consolidatorState;
	
	private char distributorState;
	
	private char appInterfaceType;
	
	private String appQueueIn;
	
	private String remoteWMQFTEQueueManager;
	
	private String remoteWMQFTEAgent;
	
	private String appFilePathIn;
	
	private String appFilePathOut;
	
	private String outQueueName;
	
	private String inQueueName;
	
	private Date createDate;
	
	private Date updateDate;

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the displacement
	 */
	public Integer getDisplacement() {
		return displacement;
	}

	/**
	 * @param displacement the displacement to set
	 */
	public void setDisplacement(Integer displacement) {
		this.displacement = displacement;
	}

	/**
	 * @return the mondayStartDate
	 */
	public Date getMondayStartDate() {
		return mondayStartDate;
	}

	/**
	 * @param mondayStartDate the mondayStartDate to set
	 */
	public void setMondayStartDate(Date mondayStartDate) {
		this.mondayStartDate = mondayStartDate;
	}

	/**
	 * @return the mondayEndDate
	 */
	public Date getMondayEndDate() {
		return mondayEndDate;
	}

	/**
	 * @param mondayEndDate the mondayEndDate to set
	 */
	public void setMondayEndDate(Date mondayEndDate) {
		this.mondayEndDate = mondayEndDate;
	}

	/**
	 * @return the tuesdayStartDate
	 */
	public Date getTuesdayStartDate() {
		return tuesdayStartDate;
	}

	/**
	 * @param tuesdayStartDate the tuesdayStartDate to set
	 */
	public void setTuesdayStartDate(Date tuesdayStartDate) {
		this.tuesdayStartDate = tuesdayStartDate;
	}

	/**
	 * @return the tuesdayEndDate
	 */
	public Date getTuesdayEndDate() {
		return tuesdayEndDate;
	}

	/**
	 * @param tuesdayEndDate the tuesdayEndDate to set
	 */
	public void setTuesdayEndDate(Date tuesdayEndDate) {
		this.tuesdayEndDate = tuesdayEndDate;
	}

	/**
	 * @return the wednesdayStartDate
	 */
	public Date getWednesdayStartDate() {
		return wednesdayStartDate;
	}

	/**
	 * @param wednesdayStartDate the wednesdayStartDate to set
	 */
	public void setWednesdayStartDate(Date wednesdayStartDate) {
		this.wednesdayStartDate = wednesdayStartDate;
	}

	/**
	 * @return the wednesdayEndDate
	 */
	public Date getWednesdayEndDate() {
		return wednesdayEndDate;
	}

	/**
	 * @param wednesdayEndDate the wednesdayEndDate to set
	 */
	public void setWednesdayEndDate(Date wednesdayEndDate) {
		this.wednesdayEndDate = wednesdayEndDate;
	}

	/**
	 * @return the thursdayStartDate
	 */
	public Date getThursdayStartDate() {
		return thursdayStartDate;
	}

	/**
	 * @param thursdayStartDate the thursdayStartDate to set
	 */
	public void setThursdayStartDate(Date thursdayStartDate) {
		this.thursdayStartDate = thursdayStartDate;
	}

	/**
	 * @return the thursdayEndDate
	 */
	public Date getThursdayEndDate() {
		return thursdayEndDate;
	}

	/**
	 * @param thursdayEndDate the thursdayEndDate to set
	 */
	public void setThursdayEndDate(Date thursdayEndDate) {
		this.thursdayEndDate = thursdayEndDate;
	}

	/**
	 * @return the fridayStartDate
	 */
	public Date getFridayStartDate() {
		return fridayStartDate;
	}

	/**
	 * @param fridayStartDate the fridayStartDate to set
	 */
	public void setFridayStartDate(Date fridayStartDate) {
		this.fridayStartDate = fridayStartDate;
	}

	/**
	 * @return the fridayEndDate
	 */
	public Date getFridayEndDate() {
		return fridayEndDate;
	}

	/**
	 * @param fridayEndDate the fridayEndDate to set
	 */
	public void setFridayEndDate(Date fridayEndDate) {
		this.fridayEndDate = fridayEndDate;
	}

	/**
	 * @return the saturdayStartDate
	 */
	public Date getSaturdayStartDate() {
		return saturdayStartDate;
	}

	/**
	 * @param saturdayStartDate the saturdayStartDate to set
	 */
	public void setSaturdayStartDate(Date saturdayStartDate) {
		this.saturdayStartDate = saturdayStartDate;
	}

	/**
	 * @return the saturdayEndDate
	 */
	public Date getSaturdayEndDate() {
		return saturdayEndDate;
	}

	/**
	 * @param saturdayEndDate the saturdayEndDate to set
	 */
	public void setSaturdayEndDate(Date saturdayEndDate) {
		this.saturdayEndDate = saturdayEndDate;
	}

	/**
	 * @return the sundayStartDate
	 */
	public Date getSundayStartDate() {
		return sundayStartDate;
	}

	/**
	 * @param sundayStartDate the sundayStartDate to set
	 */
	public void setSundayStartDate(Date sundayStartDate) {
		this.sundayStartDate = sundayStartDate;
	}

	/**
	 * @return the sundayEndDate
	 */
	public Date getSundayEndDate() {
		return sundayEndDate;
	}

	/**
	 * @param sundayEndDate the sundayEndDate to set
	 */
	public void setSundayEndDate(Date sundayEndDate) {
		this.sundayEndDate = sundayEndDate;
	}

	/**
	 * @return the validator
	 */
	public Boolean getValidator() {
		return validator;
	}

	/**
	 * @param validator the validator to set
	 */
	public void setValidator(Boolean validator) {
		this.validator = validator;
	}

	/**
	 * @return the consolidatorState
	 */
	public char getConsolidatorState() {
		return consolidatorState;
	}

	/**
	 * @param consolidatorState the consolidatorState to set
	 */
	public void setConsolidatorState(char consolidatorState) {
		this.consolidatorState = consolidatorState;
	}

	/**
	 * @return the distributorState
	 */
	public char getDistributorState() {
		return distributorState;
	}

	/**
	 * @param distributorState the distributorState to set
	 */
	public void setDistributorState(char distributorState) {
		this.distributorState = distributorState;
	}

	/**
	 * @return the appInterfaceType
	 */
	public char getAppInterfaceType() {
		return appInterfaceType;
	}

	/**
	 * @param appInterfaceType the appInterfaceType to set
	 */
	public void setAppInterfaceType(char appInterfaceType) {
		this.appInterfaceType = appInterfaceType;
	}

	/**
	 * @return the outQueueName
	 */
	public String getOutQueueName() {
		return outQueueName;
	}

	/**
	 * @param outQueueName the outQueueName to set
	 */
	public void setOutQueueName(String outQueueName) {
		this.outQueueName = outQueueName;
	}

	/**
	 * @return the inQueueName
	 */
	public String getInQueueName() {
		return inQueueName;
	}

	/**
	 * @param inQueueName the inQueueName to set
	 */
	public void setInQueueName(String inQueueName) {
		this.inQueueName = inQueueName;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the appQueueIn
	 */
	public String getAppQueueIn() {
		return appQueueIn;
	}

	/**
	 * @param appQueueIn the appQueueIn to set
	 */
	public void setAppQueueIn(String appQueueIn) {
		this.appQueueIn = appQueueIn;
	}

	/**
	 * @return the appFilePathIn
	 */
	public String getAppFilePathIn() {
		return appFilePathIn;
	}

	/**
	 * @param appFilePathIn the appFilePathIn to set
	 */
	public void setAppFilePathIn(String appFilePathIn) {
		this.appFilePathIn = appFilePathIn;
	}

	/**
	 * @return the appFilePathOut
	 */
	public String getAppFilePathOut() {
		return appFilePathOut;
	}

	/**
	 * @param appFilePathOut the appFilePathOut to set
	 */
	public void setAppFilePathOut(String appFilePathOut) {
		this.appFilePathOut = appFilePathOut;
	}

	/**
	 * @return the remoteWMQFTEQueueManager
	 */
	public String getRemoteWMQFTEQueueManager() {
		return remoteWMQFTEQueueManager;
	}

	/**
	 * @param remoteWMQFTEQueueManager the remoteWMQFTEQueueManager to set
	 */
	public void setRemoteWMQFTEQueueManager(String remoteWMQFTEQueueManager) {
		this.remoteWMQFTEQueueManager = remoteWMQFTEQueueManager;
	}

	/**
	 * @return the remoteWMQFTEAgent
	 */
	public String getRemoteWMQFTEAgent() {
		return remoteWMQFTEAgent;
	}

	/**
	 * @param remoteWMQFTEAgent the remoteWMQFTEAgent to set
	 */
	public void setRemoteWMQFTEAgent(String remoteWMQFTEAgent) {
		this.remoteWMQFTEAgent = remoteWMQFTEAgent;
	}
}
