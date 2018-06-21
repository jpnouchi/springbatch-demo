package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.model.SystemProperty;
import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.bcp.teletransfer.fsr.client.constant.FSRClientConstants;
import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.bcp.teletransfer.fsr.client.util.FSRClientUtil;
import com.primeur.spmfts.filebox.domain.Fileset;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.domain.MetadataSet;

/**
 * Class used to access SPFB_BCP_SYSTEM_PROPERTIES_MD
 * 
 * @author David Reyes
 *
 */
public class SystemPropertyDao {

	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(SystemPropertyDao.class);
	
	/////////////////////////////////////////////////////
	/// Definitions for SPFB_BCP_SYSTEM_PROPERTIES_MD ///
	/////////////////////////////////////////////////////
	
	// The METADATACLASS ...
	private static final String METADATACLASS_SYSTEM_PROPERTIES   = "SPFB_BCP_SYSTEM_PROPERTIES_MD";
	
	// ... and its METADATANAMEs
	
	private static final String METADATANAME_PARAMETER			= "PARAMETER";			// VARCHAR(100)
	private static final String METADATANAME_VALUE				= "VALUE";				// VARCHAR(255)
	private static final String METADATANAME_DESCRIPTION		= "DESCRIPTION";		// VARCHAR(512)
	private static final String METADATANAME_APPLICATION		= "APPLICATION";		// VARCHAR(1)
	private static final String METADATANAME_STATUS             = "STATUS";				// VARCHAR(1)
	private static final String METADATANAME_CREATE_DATE		= "CREATE_DATE";		// TIMESTAMP
	private static final String METADATANAME_UPDATE_DATE		= "UPDATE_DATE";		// TIMESTAMP
	
	// Logger dataType constant
	private static final String DATA_TYPE = FSRClientConstants.SYSTEM_PROPERTY;
	
	/**
	 * Inserts a system property record into FSR database
	 * 
	 * @param system property system property to insert
	 * @throws Exception
	 */
	public synchronized static void insertSystemProperty(SystemProperty systemProperty) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_INSERT;
		
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, systemProperty.getParameter()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		Fileset systemPropertyFileset = new Fileset();
		systemPropertyFileset.setIdUserClass(FSRClientConstants.FSR_REMOTE_DB_BCP_ID_USER_CLASS);
		MetadataSet systemPropertyMetadataSet = new MetadataSet();
		systemPropertyMetadataSet.setMetadataClass(METADATACLASS_SYSTEM_PROPERTIES);
		
		systemPropertyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_PARAMETER, systemProperty.getParameter()));
		systemPropertyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_VALUE, systemProperty.getValue()));
		systemPropertyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DESCRIPTION, systemProperty.getDescription()));
		systemPropertyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_APPLICATION, systemProperty.getApplication()));
		systemPropertyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_STATUS, systemProperty.getStatus()));
		systemPropertyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CREATE_DATE, systemProperty.getCreateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		systemPropertyMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_UPDATE_DATE, systemProperty.getUpdateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		
		systemPropertyFileset.addMetadataSet(systemPropertyMetadataSet);
		
		// following instruction persists data into remote db
		systemPropertyFileset.save();
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, systemProperty.getParameter()));
	}
	
	/**
	 * Updates a system property record stored in FSR database
	 * 
	 * @param system property system property to update
	 * @throws Exception
	 */
	public synchronized static void updateSystemProperty(SystemProperty systemProperty) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_UPDATE;
		
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, systemProperty.getParameter()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_SYSTEM_PROPERTIES);
		
		FilesetList systemPropertyFilesetList = new FilesetList(metadataClass, " " + METADATANAME_PARAMETER + "='" + systemProperty.getParameter() + "'", 0, 0, false, true);
		
		for (Fileset systemPropertyFileset : systemPropertyFilesetList) {
			
			MetadataSet systemPropertyMetadataSet = systemPropertyFileset.getMetadataSet(METADATACLASS_SYSTEM_PROPERTIES);
			
			systemPropertyMetadataSet.getMetadataValue(METADATANAME_PARAMETER).setValue(systemProperty.getParameter());
			systemPropertyMetadataSet.getMetadataValue(METADATANAME_VALUE).setValue(systemProperty.getValue());
			systemPropertyMetadataSet.getMetadataValue(METADATANAME_DESCRIPTION).setValue(systemProperty.getDescription());
			systemPropertyMetadataSet.getMetadataValue(METADATANAME_APPLICATION).setValue(systemProperty.getApplication());
			systemPropertyMetadataSet.getMetadataValue(METADATANAME_STATUS).setValue(systemProperty.getStatus());	
			systemPropertyMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).setValue(ParseUtil.dateToString(systemProperty.getCreateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			systemPropertyMetadataSet.getMetadataValue(METADATANAME_UPDATE_DATE).setValue(ParseUtil.dateToString(systemProperty.getUpdateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			
			// following instruction persists data into remote db
			systemPropertyFileset.save();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, systemProperty.getParameter()));
		logger.debug(String.format(LoggerMessages.ROWS_UPDATED_FORMAT, systemPropertyFilesetList.size()));
	}
	
	/**
	 * Deletes a system property record stored in FSR database
	 * 
	 * @param parameter parameter name of the system property to delete
	 * @throws Exception
	 */
	public synchronized static void deleteSystemProperty(String parameter) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_DELETE;
		
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, parameter));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_SYSTEM_PROPERTIES);
		
		FilesetList systemPropertyFilesetList = new FilesetList(metadataClass, " " + METADATANAME_PARAMETER + "='" + parameter + "'", 0, 0, false, true);
		
		String presenceString;
		
		switch (systemPropertyFilesetList.size()) {
		
			case 0:
				presenceString = LoggerMessages.NOT_FOUND;
				break;
			case 1:
				presenceString = LoggerMessages.FOUND;
				break;
			default:
				presenceString = String.format(LoggerMessages.ROWS_FOUND_FORMAT, systemPropertyFilesetList.size());
		}
		
		logger.debug(String.format(LoggerMessages.PRESENCE_PARAM_FORMAT, DATA_TYPE, parameter, presenceString));
		
		for (Fileset systemPropertyFileset : systemPropertyFilesetList) {
			// following instruction removes data into remote db
			systemPropertyFileset.delete();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, parameter));
		logger.debug(String.format(LoggerMessages.ROWS_DELETED_FORMAT, systemPropertyFilesetList.size()));
	}
	
	/**
	 * Returns a list with all system properties.
	 * 
	 * @return system property list
	 * @throws Exception
	 */
	@Deprecated
	public synchronized static List<SystemProperty> getSystemPropertyList() throws Exception {
		return getSystemPropertyList(null);
	}
	
	/**
	 * Returns a system property list. All listed system properties match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return system property list
	 * @throws Exception
	 */
	public synchronized static List<SystemProperty> getSystemPropertyList(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		List<SystemProperty> systemPropertyList = new ArrayList<SystemProperty>();
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_SYSTEM_PROPERTIES);
		
		FilesetList systemPropertyFilesetList;
		
		if (whereClause != null && whereClause.length() > 0)
			systemPropertyFilesetList = new FilesetList(metadataClass, whereClause, 0, 0, false, true);
		else
			systemPropertyFilesetList = new FilesetList(metadataClass);
		
		for (Fileset systemPropertyFileset : systemPropertyFilesetList) {
			
			MetadataSet systemPropertyMetadataSet = systemPropertyFileset.getMetadataSet(METADATACLASS_SYSTEM_PROPERTIES);
			
			SystemProperty systemProperty = new SystemProperty();
			
			systemProperty = fillSystemPropertyData(systemProperty, systemPropertyMetadataSet);
			
			systemPropertyList.add(systemProperty);
			
			logger.debug("System Property: " + systemProperty.getParameter() + " - " + systemProperty.getValue());
		}	
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return systemPropertyList;
	}
	
	/**
	 * Returns a system property.
	 * 
	 * @param parameter parameter name of the system property
	 * @return system property
	 * @throws Exception
	 */
	public synchronized static SystemProperty getSystemProperty(String parameter) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_GET;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, parameter));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		SystemProperty systemProperty = null;
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_SYSTEM_PROPERTIES);
		
		FilesetList systemPropertyFilesetList = new FilesetList(metadataClass, " " + METADATANAME_PARAMETER + "='" + parameter + "'", 0, 0, false, true);
		
		for (Fileset systemPropertyFileset : systemPropertyFilesetList) {
			
			systemProperty = new SystemProperty();
			
			MetadataSet userMetadataSet = systemPropertyFileset.getMetadataSet(METADATACLASS_SYSTEM_PROPERTIES);

			systemProperty = fillSystemPropertyData(systemProperty, userMetadataSet);
			
			logger.debug("System Property: " + systemProperty.getParameter() + " - " + systemProperty.getValue());
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return systemProperty;
	}
	
	/**
	 * Returns the count of all system properties that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return company list count
	 * @throws Exception
	 */
	public synchronized static int getSystemPropertyListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		logger.debug("systemPropertyListCount whereClause: " + whereClause);
		
		int systemPropertyListCount = FilesetList.countRecordByClass(METADATACLASS_SYSTEM_PROPERTIES, whereClause);
		
		logger.debug("systemPropertyListCount: " + systemPropertyListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return systemPropertyListCount;
	}
	
	/**
	 * Fills a system property with the data retrieved from a FSR MetadataSet
	 * 
	 * @param system property system property to be filled
	 * @param systemPropertyMetadataSet
	 * @return filled system property
	 * @throws Exception
	 */
	private synchronized static SystemProperty fillSystemPropertyData(SystemProperty systemProperty, MetadataSet systemPropertyMetadataSet) throws Exception {
		
		systemProperty.setParameter(systemPropertyMetadataSet.getMetadataValue(METADATANAME_PARAMETER).getValue());	
		systemProperty.setValue(systemPropertyMetadataSet.getMetadataValue(METADATANAME_VALUE).getValue());	
		systemProperty.setDescription(systemPropertyMetadataSet.getMetadataValue(METADATANAME_DESCRIPTION).getValue());	
		systemProperty.setApplication(systemPropertyMetadataSet.getMetadataValue(METADATANAME_APPLICATION).getValueAsChar());		
		systemProperty.setStatus(systemPropertyMetadataSet.getMetadataValue(METADATANAME_STATUS).getValueAsChar());	
		systemProperty.setCreateDate(ParseUtil.stringToDate(systemPropertyMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		systemProperty.setUpdateDate(ParseUtil.stringToDate(systemPropertyMetadataSet.getMetadataValue(METADATANAME_UPDATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		
		return systemProperty;
	}
}
