package com.primeur.bcp.teletransfer.common.model;

import java.util.Date;


/**
 * This class is a POJO that contains company data
 * 
 * @author David Reyes
 *
 */
public class Company {

	private String companyCode;
	
	private String companyName;
	
	private String description;
	
	private String companyAddress;
	
	private String country;
	
	private String officeHours;
	
	private String telephone;
	
	private String fax;
	
	private String responsible;
	
	private String responsibleEmail;
	
	private String technicalResponsible;
	
	private String technicalResponsibleEmail;
	
	private String docType;
	
	private String docValue;
	
	private String province;
	
	private String district;
	
	private String department;
	
	private String outQueueName;
	
	private String inQueueName;
	
	private Date lastInstallDate;
	
	private Date affiliationDate;
	
	private Date disaffiliationDate;
	
	private String useFrequency;
	
	private String averageSentVol;
	
	private char status;
	
	private Date createDate;
	
	private Date updateDate;
	
	private Boolean contingency;
	
	private Date activationDate;
	
	private char clientType;
	
	private String mainUserCode;

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

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the officeHours
	 */
	public String getOfficeHours() {
		return officeHours;
	}

	/**
	 * @param officeHours the officeHours to set
	 */
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the responsible
	 */
	public String getResponsible() {
		return responsible;
	}

	/**
	 * @param responsible the responsible to set
	 */
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	/**
	 * @return the responsibleEmail
	 */
	public String getResponsibleEmail() {
		return responsibleEmail;
	}

	/**
	 * @param responsibleEmail the responsibleEmail to set
	 */
	public void setResponsibleEmail(String responsibleEmail) {
		this.responsibleEmail = responsibleEmail;
	}

	/**
	 * @return the technicalResponsible
	 */
	public String getTechnicalResponsible() {
		return technicalResponsible;
	}

	/**
	 * @param technicalResponsible the technicalResponsible to set
	 */
	public void setTechnicalResponsible(String technicalResponsible) {
		this.technicalResponsible = technicalResponsible;
	}

	/**
	 * @return the technicalResponsibleEmail
	 */
	public String getTechnicalResponsibleEmail() {
		return technicalResponsibleEmail;
	}

	/**
	 * @param technicalResponsibleEmail the technicalResponsibleEmail to set
	 */
	public void setTechnicalResponsibleEmail(String technicalResponsibleEmail) {
		this.technicalResponsibleEmail = technicalResponsibleEmail;
	}

	/**
	 * @return the docType
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * @param docType the docType to set
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/**
	 * @return the docValue
	 */
	public String getDocValue() {
		return docValue;
	}

	/**
	 * @param docValue the docValue to set
	 */
	public void setDocValue(String docValue) {
		this.docValue = docValue;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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
	 * @return the lastInstallDate
	 */
	public Date getLastInstallDate() {
		return lastInstallDate;
	}

	/**
	 * @param lastInstallDate the lastInstallDate to set
	 */
	public void setLastInstallDate(Date lastInstallDate) {
		this.lastInstallDate = lastInstallDate;
	}

	/**
	 * @return the affiliationDate
	 */
	public Date getAffiliationDate() {
		return affiliationDate;
	}

	/**
	 * @param affiliationDate the affiliationDate to set
	 */
	public void setAffiliationDate(Date affiliationDate) {
		this.affiliationDate = affiliationDate;
	}

	/**
	 * @return the disaffiliationDate
	 */
	public Date getDisaffiliationDate() {
		return disaffiliationDate;
	}

	/**
	 * @param disaffiliationDate the disaffiliationDate to set
	 */
	public void setDisaffiliationDate(Date disaffiliationDate) {
		this.disaffiliationDate = disaffiliationDate;
	}

	/**
	 * @return the useFrequency
	 */
	public String getUseFrequency() {
		return useFrequency;
	}

	/**
	 * @param useFrequency the useFrequency to set
	 */
	public void setUseFrequency(String useFrequency) {
		this.useFrequency = useFrequency;
	}

	/**
	 * @return the averageSentVol
	 */
	public String getAverageSentVol() {
		return averageSentVol;
	}

	/**
	 * @param averageSentVol the averageSentVol to set
	 */
	public void setAverageSentVol(String averageSentVol) {
		this.averageSentVol = averageSentVol;
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
	 * @return the contingency
	 */
	public Boolean getContingency() {
		return contingency;
	}

	/**
	 * @param contingency the contingency to set
	 */
	public void setContingency(Boolean contingency) {
		this.contingency = contingency;
	}

	/**
	 * @return the activationDate
	 */
	public Date getActivationDate() {
		return activationDate;
	}

	/**
	 * @param activationDate the activationDate to set
	 */
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	/**
	 * @return the clientType
	 */
	public char getClientType() {
		return clientType;
	}

	/**
	 * @param clientType the clientType to set
	 */
	public void setClientType(char clientType) {
		this.clientType = clientType;
	}

	/**
	 * @return the mainUserCode
	 */
	public String getMainUserCode() {
		return mainUserCode;
	}

	/**
	 * @param mainUserCode the mainUserCode to set
	 */
	public void setMainUserCode(String mainUserCode) {
		this.mainUserCode = mainUserCode;
	}
}
