package com.primeur.bcp.teletransfer.common.model;

import java.util.Date;


/**
 * This class is a POJO that contains file data
 * 
 * @author David Reyes
 *
 */
public class File {
	
	private String nodeName;
	
	private String queueManagerName;
	
	private String queueName;
	
	private int addressType;
	
	private String internalNumber;
	
	private String messageFileId;
	
	private String correlationId;
	
	private String sender;
	
	private String userClass;

	private String destinationFileName;
	
	private String description;
	
	private Date startPutDate;
	
	private Date expiryDate;
	
	private String destinationPathName;
	
	private String originalFileName;
	
	private Integer codePage;
	
	private Integer eorEof;
	
	private Integer priority;
	
	private Integer fileLength;
	
	private String userId;
	
	private String sessionId;
	
	private Date firstReadDate;
	
	private Date lastReadDate;
	
	private Date arrivalDate;
	
	private int binaryFile;
	
	private Integer zCompress;
	
	private Integer dstk;
	
	private Integer locallyExternal;
	
	private Integer destinationExternal;
	
	private String originQueueManager;
	
	private String originQueue;
	
	private String productCode;
	
	private String fileUrl;
	
	private char fileStatus;
	
	private Integer validatorRecordCount;
	
	private String companyCode;

	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	/**
	 * @return the queueManagerName
	 */
	public String getQueueManagerName() {
		return queueManagerName;
	}

	/**
	 * @param queueManagerName the queueManagerName to set
	 */
	public void setQueueManagerName(String queueManagerName) {
		this.queueManagerName = queueManagerName;
	}

	/**
	 * @return the queueName
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * @param queueName the queueName to set
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	/**
	 * @return the addressType
	 */
	public int getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(int addressType) {
		this.addressType = addressType;
	}

	/**
	 * @return the internalNumber
	 */
	public String getInternalNumber() {
		return internalNumber;
	}

	/**
	 * @param internalNumber the internalNumber to set
	 */
	public void setInternalNumber(String internalNumber) {
		this.internalNumber = internalNumber;
	}

	/**
	 * @return the messageFileId
	 */
	public String getMessageFileId() {
		return messageFileId;
	}

	/**
	 * @param messageFileId the messageFileId to set
	 */
	public void setMessageFileId(String messageFileId) {
		this.messageFileId = messageFileId;
	}

	/**
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the userClass
	 */
	public String getUserClass() {
		return userClass;
	}

	/**
	 * @param userClass the userClass to set
	 */
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	/**
	 * @return the destinationFileName
	 */
	public String getDestinationFileName() {
		return destinationFileName;
	}

	/**
	 * @param destinationFileName the destinationFileName to set
	 */
	public void setDestinationFileName(String destinationFileName) {
		this.destinationFileName = destinationFileName;
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
	 * @return the startPutDate
	 */
	public Date getStartPutDate() {
		return startPutDate;
	}

	/**
	 * @param startPutDate the startPutDate to set
	 */
	public void setStartPutDate(Date startPutDate) {
		this.startPutDate = startPutDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the destinationPathName
	 */
	public String getDestinationPathName() {
		return destinationPathName;
	}

	/**
	 * @param destinationPathName the destinationPathName to set
	 */
	public void setDestinationPathName(String destinationPathName) {
		this.destinationPathName = destinationPathName;
	}

	/**
	 * @return the originalFileName
	 */
	public String getOriginalFileName() {
		return originalFileName;
	}

	/**
	 * @param originalFileName the originalFileName to set
	 */
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	/**
	 * @return the codePage
	 */
	public Integer getCodePage() {
		return codePage;
	}

	/**
	 * @param codePage the codePage to set
	 */
	public void setCodePage(Integer codePage) {
		this.codePage = codePage;
	}

	/**
	 * @return the eorEof
	 */
	public Integer getEorEof() {
		return eorEof;
	}

	/**
	 * @param eorEof the eorEof to set
	 */
	public void setEorEof(Integer eorEof) {
		this.eorEof = eorEof;
	}

	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return the fileLength
	 */
	public Integer getFileLength() {
		return fileLength;
	}

	/**
	 * @param fileLength the fileLength to set
	 */
	public void setFileLength(Integer fileLength) {
		this.fileLength = fileLength;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the firstReadDate
	 */
	public Date getFirstReadDate() {
		return firstReadDate;
	}

	/**
	 * @param firstReadDate the firstReadDate to set
	 */
	public void setFirstReadDate(Date firstReadDate) {
		this.firstReadDate = firstReadDate;
	}

	/**
	 * @return the lastReadDate
	 */
	public Date getLastReadDate() {
		return lastReadDate;
	}

	/**
	 * @param lastReadDate the lastReadDate to set
	 */
	public void setLastReadDate(Date lastReadDate) {
		this.lastReadDate = lastReadDate;
	}

	/**
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the binaryFile
	 */
	public int getBinaryFile() {
		return binaryFile;
	}

	/**
	 * @param binaryFile the binaryFile to set
	 */
	public void setBinaryFile(int binaryFile) {
		this.binaryFile = binaryFile;
	}

	/**
	 * @return the zCompress
	 */
	public Integer getZCompress() {
		return zCompress;
	}

	/**
	 * @param zCompress the zCompress to set
	 */
	public void setZCompress(Integer zCompress) {
		this.zCompress = zCompress;
	}

	/**
	 * @return the dstk
	 */
	public Integer getDstk() {
		return dstk;
	}

	/**
	 * @param dstk the dstk to set
	 */
	public void setDstk(Integer dstk) {
		this.dstk = dstk;
	}

	/**
	 * @return the locallyExternal
	 */
	public Integer getLocallyExternal() {
		return locallyExternal;
	}

	/**
	 * @param locallyExternal the locallyExternal to set
	 */
	public void setLocallyExternal(Integer locallyExternal) {
		this.locallyExternal = locallyExternal;
	}

	/**
	 * @return the destinationExternal
	 */
	public Integer getDestinationExternal() {
		return destinationExternal;
	}

	/**
	 * @param destinationExternal the destinationExternal to set
	 */
	public void setDestinationExternal(Integer destinationExternal) {
		this.destinationExternal = destinationExternal;
	}

	/**
	 * @return the originQueueManager
	 */
	public String getOriginQueueManager() {
		return originQueueManager;
	}

	/**
	 * @param originQueueManager the originQueueManager to set
	 */
	public void setOriginQueueManager(String originQueueManager) {
		this.originQueueManager = originQueueManager;
	}

	/**
	 * @return the originQueue
	 */
	public String getOriginQueue() {
		return originQueue;
	}

	/**
	 * @param originQueue the originQueue to set
	 */
	public void setOriginQueue(String originQueue) {
		this.originQueue = originQueue;
	}

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
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}

	/**
	 * @param fileUrl the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	/**
	 * @return the fileStatus
	 */
	public char getFileStatus() {
		return fileStatus;
	}

	/**
	 * @param fileStatus the fileStatus to set
	 */
	public void setFileStatus(char fileStatus) {
		this.fileStatus = fileStatus;
	}

	/**
	 * @return the validatorRecordCount
	 */
	public Integer getValidatorRecordCount() {
		return validatorRecordCount;
	}

	/**
	 * @param validatorRecordCount the validatorRecordCount to set
	 */
	public void setValidatorRecordCount(Integer validatorRecordCount) {
		this.validatorRecordCount = validatorRecordCount;
	}

	/**
	 * @return the companyCode
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * @param companyCode the companyCode to set
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Override
	public String toString() {
		
		String toString = "\n";
		toString += "######################################################################\n";
		toString += "File: " + getInternalNumber() + " - " + getOriginalFileName()+ "\n";
		toString += "######################################################################\n";
		toString += "\tAddressType: " + getAddressType() + "\n";
		toString += "\tBinaryFile: " + getBinaryFile() + "\n";
		toString += "\tCompanyCode: " + getCompanyCode() + "\n";
		toString += "\tCorrelationId: " + getCorrelationId() + "\n";
		toString += "\tDescription: " + getDescription() + "\n";
		toString += "\tDestinationFileName: " + getDestinationFileName() + "\n";
		toString += "\tDestinationPathName: " + getDestinationPathName() + "\n";
		toString += "\tFileStatus: " + getFileStatus() + "\n";
		toString += "\tFileUrl: " + getFileUrl() + "\n";
		toString += "\tInternalNumber: " + getInternalNumber() + "\n";
		toString += "\tMessageFileId: " + getMessageFileId() + "\n";
		toString += "\tNodeName: " + getNodeName() + "\n";
		toString += "\tOriginalFileName: " + getOriginalFileName() + "\n";
		toString += "\tOriginQueue: " + getOriginQueue() + "\n";
		toString += "\tOriginQueueManager: " + getOriginQueueManager() + "\n";
		toString += "\tProductCode: " + getProductCode() + "\n";
		toString += "\tQueueManagerName: " + getQueueManagerName() + "\n";
		toString += "\tQueueName: " + getQueueName() + "\n";
		toString += "\tSender: " + getSender() + "\n";
		toString += "\tSessionId: " + getSessionId() + "\n";
		toString += "\tUserClass: " + getUserClass() + "\n";
		toString += "\tUserId: " + getUserId() + "\n";
		toString += "\tCodePage: " + getCodePage() + "\n";
		toString += "\tDestinationExternal: " + getDestinationExternal() + "\n";
		toString += "\tDstk: " + getDstk() + "\n";
		toString += "\tEorEof: " + getEorEof() + "\n";
		toString += "\tFileLength: " + getFileLength() + "\n";
		toString += "\tLocallyExternal: " + getLocallyExternal() + "\n";
		toString += "\tPriority: " + getPriority() + "\n";
		toString += "\tValidatorRecordCount: " + getValidatorRecordCount() + "\n";
		toString += "\tZCompress: " + getZCompress() + "\n";
		toString += "\tArrivalDate: " + getArrivalDate() + "\n";
		toString += "\tExpiryDate: " + getExpiryDate() + "\n";
		toString += "\tFirstReadDate: " + getFirstReadDate() + "\n";
		toString += "\tLastReadDate: " + getLastReadDate() + "\n";
		toString += "\tStartPutDate: " + getStartPutDate() + "\n";
		toString += "\tArrivalDate: " + getArrivalDate() + "\n";
		toString += "######################################################################";

		return toString;
	}
}
