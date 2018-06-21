package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.model.Company;
import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.bcp.teletransfer.fsr.client.constant.FSRClientConstants;
import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.bcp.teletransfer.fsr.client.util.FSRClientUtil;
import com.primeur.spmfts.filebox.domain.Fileset;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.domain.MetadataSet;

/**
 * Class used to access SPFB_BCP_COMPANY_MD
 * 
 * @author David Reyes
 *
 */
public class CompanyDao {
	
	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(CompanyDao.class);

	///////////////////////////////////////////
	/// Definitions for SPFB_BCP_COMPANY_MD ///
	///////////////////////////////////////////
	
	// The METADATACLASS ...
	private static final String METADATACLASS_BCP_COMPANY = "SPFB_BCP_COMPANY_MD";
	
	// ... and its METADATANAMEs
	public static final String METADATANAME_COMPANY_CODE					= "COMPANY_CODE";					// VARCHAR(10)
	public static final String METADATANAME_COMPANY_NAME					= "COMPANY_NAME";					// VARCHAR(128)
	public static final String METADATANAME_DESCRIPTION						= "DESCRIPTION";					// VARCHAR(512)
	public static final String METADATANAME_COMPANY_ADDRESS          		= "COMPANY_ADDRESS";				// VARCHAR(512)
	public static final String METADATANAME_COUNTRY         				= "COUNTRY";						// VARCHAR(128)
	public static final String METADATANAME_OFFICE_HOURS         			= "OFFICE_HOURS";					// VARCHAR(256)
	public static final String METADATANAME_TELEPHONE          				= "TELEPHONE";						// VARCHAR(50)
	public static final String METADATANAME_FAX             				= "FAX";							// VARCHAR(50)
	public static final String METADATANAME_RESPONSIBLE    					= "RESPONSIBLE";					// VARCHAR(128)
	public static final String METADATANAME_RESPONSIBLE_EMAIL				= "RESPONSIBLE_EMAIL";				// VARCHAR(128)	
	public static final String METADATANAME_TECHNICAL_RESPONSIBLE    		= "TECHNICAL_RESPONSIBLE";			// VARCHAR(128)
	public static final String METADATANAME_TECHNICAL_RESPONSIBLE_EMAIL		= "TECHNICAL_RESPONSIBLE_EMAIL";	// VARCHAR(128)
	public static final String METADATANAME_DOC_TYPE             			= "DOC_TYPE";						// VARCHAR(10)
	public static final String METADATANAME_DOC_VALUE          				= "DOC_VALUE";						// VARCHAR(50)
	public static final String METADATANAME_PROVINCE             			= "PROVINCE";						// VARCHAR(50)
	public static final String METADATANAME_DISTRICT           				= "DISTRICT";						// VARCHAR(50)
	public static final String METADATANAME_DEPARTMENT             			= "DEPARTMENT";						// VARCHAR(50)
	public static final String METADATANAME_OUT_QUEUE_NAME             		= "OUT_QUEUE_NAME";					// VARCHAR(50)
	public static final String METADATANAME_IN_QUEUE_NAME             		= "IN_QUEUE_NAME";					// VARCHAR(50)
	public static final String METADATANAME_LAST_INSTALL_DATE             	= "LAST_INSTALL_DATE";				// TIMESTAMP
	public static final String METADATANAME_AFFILIATION_DATE             	= "AFFILIATION_DATE";				// TIMESTAMP
	public static final String METADATANAME_DISAFFILIATION_DATE             = "DISAFFILIATION_DATE";			// TIMESTAMP
	public static final String METADATANAME_USE_FREQUENCY             		= "USE_FREQUENCY";					// VARCHAR(128)
	public static final String METADATANAME_AVERAGE_SENT_VOL       			= "AVERAGE_SENT_VOL";				// VARCHAR(50)
	public static final String METADATANAME_STATUS             				= "STATUS";							// VARCHAR(1)
	public static final String METADATANAME_CREATE_DATE             		= "CREATE_DATE";					// TIMESTAMP
	public static final String METADATANAME_UPDATE_DATE             		= "UPDATE_DATE";					// TIMESTAMP
	public static final String METADATANAME_CONTINGENCY             		= "CONTINGENCY";					// SMALLINT
	public static final String METADATANAME_ACTIVATION_DATE             	= "ACTIVATION_DATE";				// TIMESTAMP
	public static final String METADATANAME_CLIENT_TYPE             		= "CLIENT_TYPE";					// VARCHAR(1)
	public static final String METADATANAME_MAIN_USER_CODE					= "MAIN_USER_CODE";                 // VARCHAR(8)
	
	// Logger dataType constant
	private static final String DATA_TYPE = FSRClientConstants.COMPANY;
		
	/**
	 * Inserts a company record into FSR database
	 * 
	 * @param company company to insert
	 * @throws Exception
	 */
	public synchronized static Company insertCompany(Company company) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_INSERT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, company.getCompanyCode()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		Date actualDate = new Date();
		company.setCreateDate(actualDate);
		company.setUpdateDate(actualDate);
		
		Fileset companyFileset = new Fileset();
		companyFileset.setIdUserClass(FSRClientConstants.FSR_REMOTE_DB_BCP_ID_USER_CLASS);
		MetadataSet companyMetadataSet = new MetadataSet();
		companyMetadataSet.setMetadataClass(METADATACLASS_BCP_COMPANY);
		
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_COMPANY_CODE, company.getCompanyCode()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_COMPANY_NAME, company.getCompanyName()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DESCRIPTION, company.getDescription()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_COMPANY_ADDRESS, company.getCompanyAddress()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_COUNTRY, company.getCountry()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_OFFICE_HOURS, company.getOfficeHours()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_TELEPHONE, company.getTelephone()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_FAX, company.getFax()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_RESPONSIBLE, company.getResponsible()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_RESPONSIBLE_EMAIL, company.getResponsibleEmail()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_TECHNICAL_RESPONSIBLE, company.getTechnicalResponsible()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_TECHNICAL_RESPONSIBLE_EMAIL, company.getTechnicalResponsibleEmail()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DOC_TYPE, company.getDocType()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DOC_VALUE, company.getDocValue()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_PROVINCE, company.getProvince()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DISTRICT, company.getDistrict()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DEPARTMENT, company.getDepartment()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_OUT_QUEUE_NAME, company.getOutQueueName()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_IN_QUEUE_NAME, company.getInQueueName()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_LAST_INSTALL_DATE, company.getLastInstallDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_AFFILIATION_DATE, company.getAffiliationDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DISAFFILIATION_DATE, company.getDisaffiliationDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USE_FREQUENCY, company.getUseFrequency()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_AVERAGE_SENT_VOL, company.getAverageSentVol()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_STATUS, company.getStatus()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CREATE_DATE, company.getCreateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_UPDATE_DATE, company.getUpdateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CONTINGENCY, ParseUtil.booleanToInteger(company.getContingency())));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_ACTIVATION_DATE, company.getActivationDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CLIENT_TYPE, company.getClientType()));
		companyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_MAIN_USER_CODE, company.getMainUserCode()));
		
		companyFileset.addMetadataSet(companyMetadataSet);
		
		// following instruction persists data into remote db
		companyFileset.save();
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, company.getCompanyCode()));
		
		return company;
	}
	
	/**
	 * Updates a company record stored in FSR database
	 * 
	 * @param company company to update
	 * @throws Exception
	 */
	public synchronized static Company updateCompany(Company company) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_UPDATE;
						
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, company.getCompanyCode()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		company.setUpdateDate(new Date());
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_COMPANY);
		
		FilesetList companyFilesetList = new FilesetList(metadataClass, " " + METADATANAME_COMPANY_CODE + "='" + company.getCompanyCode() + "'", 0, 0, false, true);
		
		for (Fileset companyFileset : companyFilesetList) {
			
			MetadataSet companyMetadataSet = companyFileset.getMetadataSet(METADATACLASS_BCP_COMPANY);
			
			companyMetadataSet.getMetadataValue(METADATANAME_COMPANY_NAME).setValue(company.getCompanyName());
			companyMetadataSet.getMetadataValue(METADATANAME_DESCRIPTION).setValue(company.getDescription());
			companyMetadataSet.getMetadataValue(METADATANAME_COMPANY_ADDRESS).setValue(company.getCompanyAddress());
			companyMetadataSet.getMetadataValue(METADATANAME_COUNTRY).setValue(company.getCountry());
			companyMetadataSet.getMetadataValue(METADATANAME_OFFICE_HOURS).setValue(company.getOfficeHours());
			companyMetadataSet.getMetadataValue(METADATANAME_TELEPHONE).setValue(company.getTelephone());
			companyMetadataSet.getMetadataValue(METADATANAME_FAX).setValue(company.getFax());
			companyMetadataSet.getMetadataValue(METADATANAME_RESPONSIBLE).setValue(company.getResponsible());
			companyMetadataSet.getMetadataValue(METADATANAME_RESPONSIBLE_EMAIL).setValue(company.getResponsibleEmail());
			companyMetadataSet.getMetadataValue(METADATANAME_TECHNICAL_RESPONSIBLE).setValue(company.getTechnicalResponsible());
			companyMetadataSet.getMetadataValue(METADATANAME_TECHNICAL_RESPONSIBLE_EMAIL).setValue(company.getTechnicalResponsibleEmail());
			companyMetadataSet.getMetadataValue(METADATANAME_DOC_TYPE).setValue(company.getDocType());
			companyMetadataSet.getMetadataValue(METADATANAME_DOC_VALUE).setValue(company.getDocValue());
			companyMetadataSet.getMetadataValue(METADATANAME_PROVINCE).setValue(company.getProvince());
			companyMetadataSet.getMetadataValue(METADATANAME_DISTRICT).setValue(company.getDistrict());
			companyMetadataSet.getMetadataValue(METADATANAME_DEPARTMENT).setValue(company.getDepartment());
			companyMetadataSet.getMetadataValue(METADATANAME_OUT_QUEUE_NAME).setValue(company.getOutQueueName());
			companyMetadataSet.getMetadataValue(METADATANAME_IN_QUEUE_NAME).setValue(company.getInQueueName());	
			companyMetadataSet.getMetadataValue(METADATANAME_LAST_INSTALL_DATE).setValue(ParseUtil.dateToString(company.getLastInstallDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			companyMetadataSet.getMetadataValue(METADATANAME_AFFILIATION_DATE).setValue(ParseUtil.dateToString(company.getAffiliationDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			companyMetadataSet.getMetadataValue(METADATANAME_DISAFFILIATION_DATE).setValue(ParseUtil.dateToString(company.getDisaffiliationDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));			
			companyMetadataSet.getMetadataValue(METADATANAME_USE_FREQUENCY).setValue(company.getUseFrequency());
			companyMetadataSet.getMetadataValue(METADATANAME_AVERAGE_SENT_VOL).setValue(company.getAverageSentVol());
			companyMetadataSet.getMetadataValue(METADATANAME_STATUS).setValue(company.getStatus());		
			companyMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).setValue(ParseUtil.dateToString(company.getCreateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			companyMetadataSet.getMetadataValue(METADATANAME_UPDATE_DATE).setValue(ParseUtil.dateToString(company.getUpdateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			companyMetadataSet.getMetadataValue(METADATANAME_CONTINGENCY).setValue(ParseUtil.booleanToInteger(company.getContingency()));
			companyMetadataSet.getMetadataValue(METADATANAME_ACTIVATION_DATE).setValue(ParseUtil.dateToString(company.getActivationDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			companyMetadataSet.getMetadataValue(METADATANAME_CLIENT_TYPE).setValue(company.getClientType());	
			companyMetadataSet.getMetadataValue(METADATANAME_MAIN_USER_CODE).setValue(company.getMainUserCode());
			
			// following instruction persists data into remote db
			companyFileset.save();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, company.getCompanyCode()));
		logger.debug(String.format(LoggerMessages.ROWS_UPDATED_FORMAT, companyFilesetList.size()));
		
		return company;
	}
	
	/**
	 * Deletes a company record stored in FSR database
	 * 
	 * @param companyCode code of the company to delete
	 * @throws Exception
	 */
	public synchronized static void deleteCompany(String companyCode) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_DELETE;
						
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, companyCode));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_COMPANY);
		
		FilesetList companyFilesetList = new FilesetList(metadataClass,  " " + METADATANAME_COMPANY_CODE + "='" + companyCode + "'", 0, 0, false, true);
		
		String presenceString;
		
		switch (companyFilesetList.size()) {
		
			case 0:
				presenceString = LoggerMessages.NOT_FOUND;
				break;
			case 1:
				presenceString = LoggerMessages.FOUND;
				break;
			default:
				presenceString = String.format(LoggerMessages.ROWS_FOUND_FORMAT, companyFilesetList.size());
		}
		
		logger.debug(String.format(LoggerMessages.PRESENCE_PARAM_FORMAT, DATA_TYPE, companyCode, presenceString));
		
		for (Fileset companyFileset : companyFilesetList) {
			// following instruction removes data into remote db
			companyFileset.delete();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, companyCode));
		logger.debug(String.format(LoggerMessages.ROWS_DELETED_FORMAT, companyFilesetList.size()));
	}
	
	/**
	 * Returns a list with all companies.
	 * 
	 * @return company list
	 * @throws Exception
	 */
	@Deprecated
	public synchronized static List<Company> getCompanyList () throws Exception {
		return getCompanyList(null, null, 0, 0);
	}
	
	/**
	 * Returns a company list. All listed companies match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return company list
	 * @throws Exception
	 */
	public synchronized static List<Company> getCompanyList (String whereClause) throws Exception {
		return getCompanyList(whereClause, null, 0, 0);
	}
	
	/**
	 * Returns a company list. All listed companies match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @param orderByClause order by clause for retrieving information from database
	 * @param offset
	 * @param count number of records
	 * @return company list
	 * @throws Exception
	 */
	public synchronized static List<Company> getCompanyList (String whereClause, String orderByClause, int offset, int count) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
						
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
				
		List<Company> companyList = new ArrayList<Company>();
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_COMPANY);
		
		FilesetList companyFilesetList;
		
		if (whereClause != null && whereClause.length() > 0) {
			
			if (orderByClause != null && orderByClause.length() > 0) {
				
				companyFilesetList = new FilesetList(metadataClass, whereClause, orderByClause, offset, count, false, true);
				
			} else {
				
				companyFilesetList = new FilesetList(metadataClass, whereClause, offset, count, false, true);
			}
			
		} else {
			
			companyFilesetList = new FilesetList(metadataClass, offset, count);
		}
		
		for (Fileset companyFileset : companyFilesetList) {
			
			MetadataSet companyMetadataSet = companyFileset.getMetadataSet(METADATACLASS_BCP_COMPANY);
			
			Company company = fillCompanyData(new Company(), companyMetadataSet);
			
			companyList.add(company);
			
			logger.debug("Company: " + company.getCompanyCode() + " - " + company.getCompanyName());
		}	
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return companyList;
	}
	
	/**
	 * Returns the count of all companies that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return company list count
	 * @throws Exception
	 */
	public synchronized static int getCompanyListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		logger.debug("companyListCount whereClause: " + whereClause);
		
		int companyListCount = FilesetList.countRecordByClass(METADATACLASS_BCP_COMPANY, whereClause);
		
		logger.debug("companyListCount: " + companyListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return companyListCount;
	}
	
	/**
	 * Fills a company with the data retrieved from a FSR MetadataSet.
	 * 
	 * @param company company to be filled
	 * @param companyMetadataSet
	 * @return filled company
	 * @throws Exception
	 */
	private synchronized static Company fillCompanyData(Company company, MetadataSet companyMetadataSet) throws Exception {
		
		company.setCompanyCode(companyMetadataSet.getMetadataValue(METADATANAME_COMPANY_CODE).getValue());
		company.setCompanyName(companyMetadataSet.getMetadataValue(METADATANAME_COMPANY_NAME).getValue());
		company.setDescription(companyMetadataSet.getMetadataValue(METADATANAME_DESCRIPTION).getValue());
		company.setCompanyAddress(companyMetadataSet.getMetadataValue(METADATANAME_COMPANY_ADDRESS).getValue());
		company.setCountry(companyMetadataSet.getMetadataValue(METADATANAME_COUNTRY).getValue());
		company.setOfficeHours(companyMetadataSet.getMetadataValue(METADATANAME_OFFICE_HOURS).getValue());
		company.setTelephone(companyMetadataSet.getMetadataValue(METADATANAME_TELEPHONE).getValue());
		company.setFax(companyMetadataSet.getMetadataValue(METADATANAME_FAX).getValue());
		company.setResponsible(companyMetadataSet.getMetadataValue(METADATANAME_RESPONSIBLE).getValue());
		company.setResponsibleEmail(companyMetadataSet.getMetadataValue(METADATANAME_RESPONSIBLE_EMAIL).getValue());
		company.setTechnicalResponsible(companyMetadataSet.getMetadataValue(METADATANAME_TECHNICAL_RESPONSIBLE).getValue());
		company.setTechnicalResponsibleEmail(companyMetadataSet.getMetadataValue(METADATANAME_TECHNICAL_RESPONSIBLE_EMAIL).getValue());	
		company.setDocType(companyMetadataSet.getMetadataValue(METADATANAME_DOC_TYPE).getValue());
		company.setDocValue(companyMetadataSet.getMetadataValue(METADATANAME_DOC_VALUE).getValue());
		company.setProvince(companyMetadataSet.getMetadataValue(METADATANAME_PROVINCE).getValue());
		company.setDistrict(companyMetadataSet.getMetadataValue(METADATANAME_DISTRICT).getValue());
		company.setDepartment(companyMetadataSet.getMetadataValue(METADATANAME_DEPARTMENT).getValue());
		company.setOutQueueName(companyMetadataSet.getMetadataValue(METADATANAME_OUT_QUEUE_NAME).getValue());
		company.setInQueueName(companyMetadataSet.getMetadataValue(METADATANAME_IN_QUEUE_NAME).getValue());	
		company.setLastInstallDate(ParseUtil.stringToDate(companyMetadataSet.getMetadataValue(METADATANAME_LAST_INSTALL_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		company.setAffiliationDate(ParseUtil.stringToDate(companyMetadataSet.getMetadataValue(METADATANAME_AFFILIATION_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		company.setDisaffiliationDate(ParseUtil.stringToDate(companyMetadataSet.getMetadataValue(METADATANAME_DISAFFILIATION_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		company.setUseFrequency(companyMetadataSet.getMetadataValue(METADATANAME_USE_FREQUENCY).getValue());	
		company.setAverageSentVol(companyMetadataSet.getMetadataValue(METADATANAME_AVERAGE_SENT_VOL).getValue());	
		company.setStatus(companyMetadataSet.getMetadataValue(METADATANAME_STATUS).getValueAsChar());	
		company.setCreateDate(ParseUtil.stringToDate(companyMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		company.setUpdateDate(ParseUtil.stringToDate(companyMetadataSet.getMetadataValue(METADATANAME_UPDATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		company.setContingency(ParseUtil.IntegerToBoolean(companyMetadataSet.getMetadataValue(METADATANAME_CONTINGENCY).getValueAsInteger()));
		company.setActivationDate(ParseUtil.stringToDate(companyMetadataSet.getMetadataValue(METADATANAME_ACTIVATION_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		company.setClientType(companyMetadataSet.getMetadataValue(METADATANAME_CLIENT_TYPE).getValueAsChar());	
		company.setMainUserCode(companyMetadataSet.getMetadataValue(METADATANAME_MAIN_USER_CODE).getValue());
		
		return company;
	}
}
