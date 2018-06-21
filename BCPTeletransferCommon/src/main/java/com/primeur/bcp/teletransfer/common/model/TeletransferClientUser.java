package com.primeur.bcp.teletransfer.common.model;


public class TeletransferClientUser extends User {
	
	public TeletransferClientUser() {
	}
	
	public TeletransferClientUser (User user) {
		
		setUserName(user.getUserName());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setCompanyCode(user.getCompanyCode());
		setUserMail(user.getUserMail());
		setLogonTries(user.getLogonTries());
		setCreateDate(user.getCreateDate());
		setUpdateDate(user.getUpdateDate());
		setGenerateMail(user.getGenerateMail());
		setGenerateReport(user.getGenerateReport());
		setStatus(user.getStatus());
		setUserType(user.getUserType());
		setMainUser(user.getMainUser());
	}
	

	/**
	 * passTicket
	 */
	private byte[] passTicket;

	/**
	 * teletransferClientUserType
	 */
	private String teletransferClientUserType;

	/**
	 * @return the passTicket
	 */
	public byte[] getPassTicket() {
		return passTicket;
	}

	/**
	 * @param passTicket
	 *            the passTicket to set
	 */
	public void setPassTicket(byte[] passTicket) {
		this.passTicket = passTicket;
	}

	/**
	 * @return the userType
	 */
	public String getTeletransferClientUserType() {
		return teletransferClientUserType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setTeletransferClientUserType(String teletransferClientUserType) {
		this.teletransferClientUserType = teletransferClientUserType;
	}
}
