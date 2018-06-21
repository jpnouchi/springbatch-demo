package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.model.AuditRecord;
import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.bcp.teletransfer.fsr.client.constant.FSRClientConstants;
import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.bcp.teletransfer.fsr.client.util.FSRClientUtil;
import com.primeur.spmfts.filebox.domain.Fileset;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.domain.MetadataSet;

/**
 * Class used to access SPFB_BCP_ADMINISTRATOR_AUDIT_MD
 * 
 * @author David Reyes
 *
 */
public class AuditDao {
	
	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(AuditDao.class);

	///////////////////////////////////////////////////////
	/// Definitions for SPFB_BCP_ADMINISTRATOR_AUDIT_MD ///
	///////////////////////////////////////////////////////
	
	// The METADATACLASS ...
	private static final String METADATACLASS_BCP_AUDIT    = "SPFB_BCP_ADMINISTRATOR_AUDIT_MD";
	
	// ... and its METADATANAMEs
	public static final String METADATANAME_OPERATION_CODE         	= "OPERATION_CODE";			// VARCHAR(4)
	public static final String METADATANAME_OPERATION_DESC         	= "OPERATION_DESC";			// VARCHAR(50)
	public static final String METADATANAME_OPERATION_RESULT       	= "OPERATION_RESULT";		// SMALLINT
	public static final String METADATANAME_USER_NAME             	= "USER_NAME";				// VARCHAR(10)
	public static final String METADATANAME_USER_FULL_NAME        	= "USER_FULL_NAME";			// VARCHAR(60)
	public static final String METADATANAME_DESCRIPTION            	= "DESCRIPTION";			// VARCHAR(100)
	public static final String METADATANAME_OPERATION_DATE        	= "OPERATION_DATE";			// TIMESTAMP
	public static final String METADATANAME_ERROR_DESCRIPTION 		= "ERROR_DESCRIPTION";		// VARCHAR(1024)

	// Logger dataType constant
	private static final String DATA_TYPE = FSRClientConstants.AUDIT_RECORD;
	
	/**
	 * Inserts an audit record into FSR database
	 * 
	 * @param auditRecord audit record to insert
	 * @throws Exception
	 */
	public synchronized static void insertAuditRecord(AuditRecord auditRecord) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_INSERT;
			
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		Fileset auditRecordFileset = new Fileset();

		auditRecordFileset.setIdUserClass(FSRClientConstants.BCPTTADMIN_AUDIT_USER_CLASS);
		MetadataSet auditRecordMetadataSet = new MetadataSet();
		auditRecordMetadataSet.setMetadataClass(METADATACLASS_BCP_AUDIT);
		
		auditRecordMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_OPERATION_CODE, auditRecord.getOperationCode()));
		auditRecordMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_OPERATION_DESC, auditRecord.getOperationDesc()));
		auditRecordMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_OPERATION_RESULT, ParseUtil.booleanToInteger(auditRecord.getOperationResult())));
		auditRecordMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USER_NAME, auditRecord.getUserName()));
		auditRecordMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USER_FULL_NAME, auditRecord.getUserFullName()));
		auditRecordMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DESCRIPTION, auditRecord.getDescription()));
		auditRecordMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_OPERATION_DATE, auditRecord.getOperationDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		auditRecordMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_ERROR_DESCRIPTION, auditRecord.getErrorDescription()));
		
		auditRecordFileset.addMetadataSet(auditRecordMetadataSet);
		
		// following instruction persists data into remote db
		auditRecordFileset.save();
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
	}
	
	/**
	 * Delete all audit records stored in FSR database
	 * 
	 * @throws Exception
	 */
	public synchronized static void deleteAllAuditRecords() throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_DELETE_ALL;
								
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_AUDIT);
		
		while(true) {
		
			FilesetList auditRecordFilesetList = new FilesetList(metadataClass, 0, 10);
			
			if (auditRecordFilesetList.size() == 0) break;
		
			for (Fileset auditRecordFileset : auditRecordFilesetList) {
				// following instruction removes data into remote db
				auditRecordFileset.delete();
			}
			
			logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
			logger.debug(String.format(LoggerMessages.ROWS_DELETED_FORMAT, auditRecordFilesetList.size()));
		}
	}
	
	/**
	 * Returns the list of all audit records.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @param orderByClause order by clause for retrieving information from database
	 * @param offset
	 * @param count number of records
	 * @return audit record list
	 * @throws Exception
	 */
	public synchronized static List<AuditRecord> getAuditRecordList(String whereClause, String orderByClause, int offset, int count) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
								
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
				
		List<AuditRecord> auditRecordList = new ArrayList<AuditRecord>();
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_AUDIT);
		
		FilesetList auditRecordFilesetList;
		
		if (whereClause != null && whereClause.length() > 0) {
			
			if (orderByClause != null && orderByClause.length() > 0) {
				
				auditRecordFilesetList = new FilesetList(metadataClass, whereClause, orderByClause, offset, count, false, true);
				
			} else {
				
				auditRecordFilesetList = new FilesetList(metadataClass, whereClause, offset, count, false, true);
			}
			
		} else {
			
			auditRecordFilesetList = new FilesetList(metadataClass);	
		}
			
		for (Fileset auditRecordFileset : auditRecordFilesetList) {
			
			MetadataSet auditRecordMetadataSet = auditRecordFileset.getMetadataSet(METADATACLASS_BCP_AUDIT);
			
			AuditRecord auditRecord = fillAuditRecordData(new AuditRecord(), auditRecordMetadataSet);
			
			auditRecordList.add(auditRecord);
			
			logger.debug("Audit Record: " + auditRecord.getOperationCode() + " - " + auditRecord.getOperationDesc() + " - " + auditRecord.getErrorDescription());
		}	
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return auditRecordList;
	}
	
	/**
	 * Returns the count of all audit records that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return audit record list count
	 * @throws Exception
	 */
	public synchronized static int getAuditRecordListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		logger.debug("auditRecordListCount whereClause: " + whereClause);
		
		int auditRecordListCount = FilesetList.countRecordByClass(METADATACLASS_BCP_AUDIT, whereClause);
		
		logger.debug("auditRecordListCount: " + auditRecordListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return auditRecordListCount;
	}
	
	/**
	 * Fills an audit record with the data retrieved from a FSR MetadataSet
	 * 
	 * @param auditRecord audit record to be filled
	 * @param auditRecordMetadataSet
	 * @return filled audit record
	 * @throws Exception
	 */
	private synchronized static AuditRecord fillAuditRecordData(AuditRecord auditRecord, MetadataSet auditRecordMetadataSet) throws Exception {
		
		auditRecord.setOperationCode(auditRecordMetadataSet.getMetadataValue(METADATANAME_OPERATION_CODE).getValue());
		auditRecord.setOperationDesc(auditRecordMetadataSet.getMetadataValue(METADATANAME_OPERATION_DESC).getValue());
		auditRecord.setOperationResult(ParseUtil.IntegerToBoolean(auditRecordMetadataSet.getMetadataValue(METADATANAME_OPERATION_RESULT).getValueAsInteger()));
		auditRecord.setUserName(auditRecordMetadataSet.getMetadataValue(METADATANAME_USER_NAME).getValue());
		auditRecord.setUserFullName(auditRecordMetadataSet.getMetadataValue(METADATANAME_USER_FULL_NAME).getValue());
		auditRecord.setDescription(auditRecordMetadataSet.getMetadataValue(METADATANAME_DESCRIPTION).getValue());
		auditRecord.setOperationDate(ParseUtil.stringToDate(auditRecordMetadataSet.getMetadataValue(METADATANAME_OPERATION_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		auditRecord.setErrorDescription(auditRecordMetadataSet.getMetadataValue(METADATANAME_ERROR_DESCRIPTION).getValue());
		
		return auditRecord;
	}
}
