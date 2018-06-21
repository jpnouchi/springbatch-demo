package com.primeur.bcp.teletransfer.common.model;

import java.util.Date;

/**
 * This class is a POJO that contains audit record data
 * 
 * @author David Reyes
 *
 */
public class AuditRecord {

	private String operationCode;
	
	private String operationDesc;
	
	private Boolean operationResult;
	
	private String userName;
	
	private String userFullName;
	
	private String description;
	
	private String errorDescription;
	
	private Date operationDate;

	/**
	 * @return the operationCode
	 */
	public String getOperationCode() {
		return operationCode;
	}

	/**
	 * @param operationCode the operationCode to set
	 */
	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	/**
	 * @return the operationDesc
	 */
	public String getOperationDesc() {
		return operationDesc;
	}

	/**
	 * @param operationDesc the operationDesc to set
	 */
	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}

	/**
	 * @return the operationResult
	 */
	public Boolean getOperationResult() {
		return operationResult;
	}

	/**
	 * @param operationResult the operationResult to set
	 */
	public void setOperationResult(Boolean operationResult) {
		this.operationResult = operationResult;
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

	/**
	 * @return the userFullName
	 */
	public String getUserFullName() {
		return userFullName;
	}

	/**
	 * @param userFullName the userFullName to set
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
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
	 * @return the operationDate
	 */
	public Date getOperationDate() {
		return operationDate;
	}

	/**
	 * @param operationDate the operationDate to set
	 */
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
