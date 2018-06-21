package com.primeur.bcp.teletransfer.common.model;

import java.util.Date;

/**
 * This class is a POJO that contains user data
 * 
 * @author David Reyes
 * 
 */
public class User {

	/**
	 * userName
	 */
	private String userName;

	/**
	 * firstName
	 */
	private String firstName;

	/**
	 * lastName
	 */
	private String lastName;

	/**
	 * companyCode
	 */
	private String companyCode;
	
	/**
	 * mainUser
	 */
	private Boolean mainUser;

	/**
	 * userMail
	 */
	private String userMail;

//	/**
//	 * userFunction
//	 */
//	private String userFunction;

	/**
	 * logonTries
	 */
	private Integer logonTries;

	/**
	 * createDate
	 */
	private Date createDate;

	/**
	 * updateDate
	 */
	private Date updateDate;

	/**
	 * generateMail
	 */
	private Boolean generateMail;

	/**
	 * generateReport
	 */
	private Boolean generateReport;
	
	/**
	 * status
	 */
	private char status;
	
	/**
	 * userType
	 */
	private char userType;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the companyCode
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * @param companyCode
	 *            the companyCode to set
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * @return the userMail
	 */
	public String getUserMail() {
		return userMail;
	}

	/**
	 * @param userMail
	 *            the userMail to set
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

//	/**
//	 * @return the userFunction
//	 */
//	public String getUserFunction() {
//		return userFunction;
//	}
//
//	/**
//	 * @param userFunction
//	 *            the userFunction to set
//	 */
//	public void setUserFunction(String userFunction) {
//		this.userFunction = userFunction;
//	}

	/**
	 * @return the logonTries
	 */
	public Integer getLogonTries() {
		return logonTries;
	}

	/**
	 * @param logonTries
	 *            the logonTries to set
	 */
	public void setLogonTries(Integer logonTries) {
		this.logonTries = logonTries;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
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
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the generateMail
	 */
	public Boolean getGenerateMail() {
		return generateMail;
	}

	/**
	 * @param generateMail
	 *            the generateMail to set
	 */
	public void setGenerateMail(Boolean generateMail) {
		this.generateMail = generateMail;
	}

	/**
	 * @return the generateReport
	 */
	public Boolean getGenerateReport() {
		return generateReport;
	}

	/**
	 * @param generateReport
	 *            the generateReport to set
	 */
	public void setGenerateReport(Boolean generateReport) {
		this.generateReport = generateReport;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * @return the userType
	 */
	public char getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(char userType) {
		this.userType = userType;
	}

	/**
	 * @return the mainUser
	 */
	public Boolean getMainUser() {
		return mainUser;
	}

	/**
	 * @param mainUser the mainUser to set
	 */
	public void setMainUser(Boolean mainUser) {
		this.mainUser = mainUser;
	}
}
