package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.model.File;
import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.bcp.teletransfer.fsr.client.constant.FSRClientConstants;
import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.bcp.teletransfer.fsr.client.exception.NoRowsUpdatedException;
import com.primeur.spmfts.filebox.domain.Fileset;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.domain.MetadataSet;

/**
 * Class used to access SPFB_BCP_SP2_FILE_SYS_MD and SPFB_BCP_SP2_FILE_SYS_PRODUCTS_MD
 * 
 * @author David Reyes
 *
 */
public class FileDao {
	
	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(FileDao.class);

	////////////////////////////////////////////////
	/// Definitions for SPFB_BCP_SP2_FILE_SYS_MD ///
	////////////////////////////////////////////////
	
	// The METADATACLASS ...
	private static final String METADATACLASS_BCP_FILE   = "SPFB_BCP_SP2_FILE_SYS_MD";
	
	private static final String METADATACLASS_BCP_FILE_EXTENDED   = "SPFB_BCP_SP2_FILE_SYS_PRODUCTS_MD";
	
	// ... and its METADATANAMEs
	public static final String METADATANAME_NODE_NAME				= "NODE_NAME";				// VARCHAR(50)
	public static final String METADATANAME_QUEUE_MANAGER_NAME		= "QUEUE_MANAGER_NAME";		// VARCHAR(50)
	public static final String METADATANAME_QUEUE_NAME				= "QUEUE_NAME";				// VARCHAR(50)
	public static final String METADATANAME_ADDRESS_TYPE           	= "ADDRESS_TYPE";			// INTEGER
	public static final String METADATANAME_INTERNAL_NUMBER        	= "INTERNAL_NUMBER";		// VARCHAR(18)
	public static final String METADATANAME_MESSAGE_FILE_ID        	= "MESSAGE_FILE_ID";		// VARCHAR(50)
	public static final String METADATANAME_CORRELATION_ID         	= "CORRELATION_ID";			// VARCHAR(50)
	public static final String METADATANAME_SENDER             		= "SENDER";					// VARCHAR(10)
	public static final String METADATANAME_USER_CLASS          	= "USER_CLASS";				// VARCHAR(6)
	public static final String METADATANAME_DESTINATION_FILENAME   	= "DESTINATION_FILENAME";	// VARCHAR(258)
	public static final String METADATANAME_DESCRIPTION          	= "DESCRIPTION";			// VARCHAR(66)
	public static final String METADATANAME_START_PUT_DATE        	= "START_PUT_DATE";			// TIMESTAMP
	public static final String METADATANAME_EXPIRY_DATE           	= "EXPIRY_DATE";			// TIMESTAMP
	public static final String METADATANAME_DESTINATION_PATHNAME   	= "DESTINATION_PATHNAME";	// VARCHAR(258)
	public static final String METADATANAME_ORIGINAL_FILENAME      	= "ORIGINAL_FILENAME";		// VARCHAR(258)
	public static final String METADATANAME_CODEPAGE            	= "CODEPAGE";				// INTEGER
	public static final String METADATANAME_EOR_EOF            		= "EOR_EOF";				// INTEGER
	public static final String METADATANAME_PRIORITY              	= "PRIORITY";				// INTEGER
	public static final String METADATANAME_FILE_LENGTH     		= "FILE_LENGTH";			// BIGINT
	public static final String METADATANAME_USER_ID       			= "USER_ID";				// VARCHAR(18)
	public static final String METADATANAME_SESSION_ID            	= "SESSION_ID";				// VARCHAR(10)
	public static final String METADATANAME_FIRST_READ_DATE        	= "FIRST_READ_DATE";		// TIMESTAMP
	public static final String METADATANAME_LAST_READ_DATE         	= "LAST_READ_DATE";			// TIMESTAMP
	public static final String METADATANAME_ARRIVAL_DATE          	= "ARRIVAL_DATE";			// TIMESTAMP
	public static final String METADATANAME_BINARY_FILE           	= "BINARY_FILE";			// INTEGER
	public static final String METADATANAME_Z_COMPRESS            	= "Z_COMPRESS";				// INTEGER
	public static final String METADATANAME_DSTK            		= "DSTK";					// INTEGER
	public static final String METADATANAME_LOCALLY_EXTERNAL       	= "LOCALLY_EXTERNAL";		// INTEGER
	public static final String METADATANAME_DESTINATION_EXTERNAL   	= "DESTINATION_EXTERNAL";	// INTEGER
	public static final String METADATANAME_ORIGIN_QUEUE_MANAGER   	= "ORIGIN_QUEUE_MANAGER";	// VARCHAR(50)
	public static final String METADATANAME_ORIGIN_QUEUE           	= "ORIGIN_QUEUE";			// VARCHAR(50)
	public static final String METADATANAME_PRODUCT_CODE           	= "PRODUCT_CODE";			// VARCHAR(4)
	public static final String METADATANAME_FILE_URL            	= "FILE_URL";				// VARCHAR(512)
	public static final String METADATANAME_FILE_STATUS            	= "FILE_STATUS";			// VARCHAR(1)
	public static final String METADATANAME_VALIDATOR_RECORD_COUNT  = "VALIDATOR_RECORD_COUNT";	// INTEGER
	public static final String METADATANAME_COMPANY_CODE            = "COMPANY_CODE";			// VARCHAR(10)
	
	// Logger dataType constant
	private static final String DATA_TYPE = FSRClientConstants.FILE;
	
	/**
	 * Updates a file record stored in FSR database.
	 * 
	 * @param file file to update
	 * @throws Exception
	 */
	public synchronized static void updateFile(File file) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_UPDATE;
		
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, file.getInternalNumber()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_FILE);
		
		boolean updateOk = false;
		
		for (int i = 0; (i <= FSRClientConstants.FSR_UPDATE_EXTENDED_MD_MAXIMUM_RETRIES) && (!updateOk); i++) {
			
			try {
				
				if (i > 0) {
					
					logger.debug(String.format(LoggerMessages.WAITING_BEFORE_RETRY_FORMAT, FSRClientConstants.FSR_UPDATE_EXTENDED_MD_RETRY_DELAY_MILLIS));
					
					Thread.sleep(FSRClientConstants.FSR_UPDATE_EXTENDED_MD_RETRY_DELAY_MILLIS);
					
					logger.debug(String.format(LoggerMessages.UPDATE_RETRY_FORMAT, i, + FSRClientConstants.FSR_UPDATE_EXTENDED_MD_MAXIMUM_RETRIES));
				}
				
				FilesetList fileFilesetList = new FilesetList(metadataClass, " " + METADATANAME_INTERNAL_NUMBER + "='" + file.getInternalNumber() + "'", 0, 0, false, true);
				
				for (Fileset fileFileset : fileFilesetList) {
		
					long idFileSet = fileFileset.getIdFileset();
					
					Fileset fileset = new Fileset(idFileSet);
					fileset.getMetadataSet(METADATACLASS_BCP_FILE_EXTENDED).getMetadataValue(METADATANAME_FILE_STATUS).setValue(file.getFileStatus());
					fileset.getMetadataSet(METADATACLASS_BCP_FILE_EXTENDED).getMetadataValue(METADATANAME_VALIDATOR_RECORD_COUNT).setValue(file.getValidatorRecordCount());
					fileset.update(); 
				}
				
				if (fileFilesetList.size() > 0) {
					
					updateOk = true;
					
					logger.debug(String.format(LoggerMessages.ROWS_UPDATED_FORMAT, fileFilesetList.size()));	
				}			
				
			} catch (Exception e) {
				
				if (i >= FSRClientConstants.FSR_UPDATE_EXTENDED_MD_MAXIMUM_RETRIES) {
					
					logger.error(String.format(LoggerMessages.OPERATION_ERROR_PARAM_FORMAT, operation, DATA_TYPE, file.getInternalNumber()), e);
					
					throw e;
				
				} else {
					
					logger.warn(String.format(LoggerMessages.OPERATION_ERROR_PARAM_FORMAT, operation, DATA_TYPE, file.getInternalNumber()), e);
				}
			}	
		}	
		
		if (updateOk) {
			
			logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, file.getInternalNumber()));
			
		} else {
			
			String errorMessage = LoggerMessages.NO_ROWS_UPDATED;
			
			logger.error(errorMessage);
			
			throw new NoRowsUpdatedException(errorMessage);
		}
	}
	
	/**
	 * Returns a list with all files.
	 * 
	 * @return company list
	 * @throws Exception
	 */
	@Deprecated
	public synchronized static List<File> getFileList () throws Exception {
		return getFileList(null, null, 0, 0);
	}
	
	/**
	 * Returns a file list. All listed files match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return file list
	 * @throws Exception
	 */
	public synchronized static List<File> getFileList (String whereClause) throws Exception {
		return getFileList(whereClause, null, 0, 0);
	}
	
	/**
	 * Returns a file list. All listed files match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @param orderByClause order by clause for retrieving information from database
	 * @param offset
	 * @param count number of records
	 * @return file list
	 * @throws Exception
	 */
	public synchronized static List<File> getFileList(String whereClause, String orderByClause, int offset, int count) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
				
		List<File> fileList = new ArrayList<File>();
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_FILE);
		
		FilesetList fileFilesetList;
		
		if (whereClause != null && whereClause.length() > 0) {
			
			if (orderByClause != null && orderByClause.length() > 0) {
				
				fileFilesetList = new FilesetList(metadataClass, whereClause, orderByClause, offset, count, false, true);
				
			} else {
				
				fileFilesetList = new FilesetList(metadataClass, whereClause, offset, count, false, true);
			}
			
		} else {
			
			fileFilesetList = new FilesetList(metadataClass, offset, count);
		}
		
		for (Fileset fileFileset : fileFilesetList) {
			
			MetadataSet fileMetadataSet = fileFileset.getMetadataSet(METADATACLASS_BCP_FILE);
			
			File file = fillFileData(new File(), fileMetadataSet);
			
			fileList.add(file);
			
			logger.debug("File: " + file.getInternalNumber() + " - " + file.getOriginalFileName());
			
			logger.debug(file.toString());	
		}	
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return fileList;
	}
	
	/**
	 * Returns the count of all files that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return file list count
	 * @throws Exception
	 */
	public synchronized static int getFileListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		logger.debug("fileListCount whereClause: " + whereClause);
		
		int fileListCount = FilesetList.countRecordByClass(METADATACLASS_BCP_FILE, whereClause);
		
		logger.debug("fileListCount: " + fileListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return fileListCount;
	}
	
	/**
	 * Fills a file with the data retrieved from a FSR MetadataSet.
	 * 
	 * @param file file to be filled
	 * @param fileMetadataSet
	 * @return filled file
	 * @throws Exception
	 */
	private synchronized static File fillFileData(File file, MetadataSet fileMetadataSet) throws Exception {
		
		file.setNodeName(fileMetadataSet.getMetadataValue(METADATANAME_NODE_NAME).getValue());
		file.setQueueManagerName(fileMetadataSet.getMetadataValue(METADATANAME_QUEUE_MANAGER_NAME).getValue());
		file.setQueueName(fileMetadataSet.getMetadataValue(METADATANAME_QUEUE_NAME).getValue());
		file.setAddressType(fileMetadataSet.getMetadataValue(METADATANAME_ADDRESS_TYPE).getValueAsInteger());
		file.setInternalNumber(fileMetadataSet.getMetadataValue(METADATANAME_INTERNAL_NUMBER).getValue());
		file.setMessageFileId(fileMetadataSet.getMetadataValue(METADATANAME_MESSAGE_FILE_ID).getValue());
		file.setCorrelationId(fileMetadataSet.getMetadataValue(METADATANAME_CORRELATION_ID).getValue());
		file.setSender(fileMetadataSet.getMetadataValue(METADATANAME_SENDER).getValue());
		file.setUserClass(fileMetadataSet.getMetadataValue(METADATANAME_USER_CLASS).getValue());
		file.setDestinationFileName(fileMetadataSet.getMetadataValue(METADATANAME_DESTINATION_FILENAME).getValue());
		file.setDescription(fileMetadataSet.getMetadataValue(METADATANAME_DESCRIPTION).getValue());
		file.setStartPutDate(ParseUtil.stringToDate(fileMetadataSet.getMetadataValue(METADATANAME_START_PUT_DATE).getValue(), FSRClientConstants.FSR_DB_FILE_DATE_FORMAT));
		file.setExpiryDate(ParseUtil.stringToDate(fileMetadataSet.getMetadataValue(METADATANAME_EXPIRY_DATE).getValue(), FSRClientConstants.FSR_DB_FILE_DATE_FORMAT));
		file.setDestinationPathName(fileMetadataSet.getMetadataValue(METADATANAME_DESTINATION_PATHNAME).getValue());
		file.setOriginalFileName(fileMetadataSet.getMetadataValue(METADATANAME_ORIGINAL_FILENAME).getValue());
		file.setCodePage(fileMetadataSet.getMetadataValue(METADATANAME_CODEPAGE).getValueAsInteger());
		file.setEorEof(fileMetadataSet.getMetadataValue(METADATANAME_EOR_EOF).getValueAsInteger());			
		file.setPriority(fileMetadataSet.getMetadataValue(METADATANAME_PRIORITY).getValueAsInteger());
		file.setFileLength(fileMetadataSet.getMetadataValue(METADATANAME_FILE_LENGTH).getValueAsInteger());
		file.setUserId(fileMetadataSet.getMetadataValue(METADATANAME_USER_ID).getValue());
		file.setSessionId(fileMetadataSet.getMetadataValue(METADATANAME_SESSION_ID).getValue());
		file.setFirstReadDate(ParseUtil.stringToDate(fileMetadataSet.getMetadataValue(METADATANAME_FIRST_READ_DATE).getValue(), FSRClientConstants.FSR_DB_FILE_DATE_FORMAT));
		file.setLastReadDate(ParseUtil.stringToDate(fileMetadataSet.getMetadataValue(METADATANAME_LAST_READ_DATE).getValue(), FSRClientConstants.FSR_DB_FILE_DATE_FORMAT));
		file.setArrivalDate(ParseUtil.stringToDate(fileMetadataSet.getMetadataValue(METADATANAME_ARRIVAL_DATE).getValue(), FSRClientConstants.FSR_DB_FILE_DATE_FORMAT));
		file.setBinaryFile(fileMetadataSet.getMetadataValue(METADATANAME_BINARY_FILE).getValueAsInteger());
		file.setZCompress(fileMetadataSet.getMetadataValue(METADATANAME_Z_COMPRESS).getValueAsInteger());
		file.setDstk(fileMetadataSet.getMetadataValue(METADATANAME_DSTK).getValueAsInteger());
		file.setLocallyExternal(fileMetadataSet.getMetadataValue(METADATANAME_LOCALLY_EXTERNAL).getValueAsInteger());
		file.setDestinationExternal(fileMetadataSet.getMetadataValue(METADATANAME_DESTINATION_EXTERNAL).getValueAsInteger());
		file.setOriginQueueManager(fileMetadataSet.getMetadataValue(METADATANAME_ORIGIN_QUEUE_MANAGER).getValue());
		file.setOriginQueue(fileMetadataSet.getMetadataValue(METADATANAME_ORIGIN_QUEUE).getValue());
		file.setProductCode(fileMetadataSet.getMetadataValue(METADATANAME_PRODUCT_CODE).getValue());
		file.setFileUrl(fileMetadataSet.getMetadataValue(METADATANAME_FILE_URL).getValue());
		
		if (fileMetadataSet.getMetadataValue(METADATANAME_FILE_STATUS).getValue() != null)
			file.setFileStatus(fileMetadataSet.getMetadataValue(METADATANAME_FILE_STATUS).getValueAsChar());
		
		if (fileMetadataSet.getMetadataValue(METADATANAME_VALIDATOR_RECORD_COUNT).getValue() != null)
			file.setValidatorRecordCount(fileMetadataSet.getMetadataValue(METADATANAME_VALIDATOR_RECORD_COUNT).getValueAsInteger());
			
		file.setCompanyCode(fileMetadataSet.getMetadataValue(METADATANAME_COMPANY_CODE).getValue());
		
		return file;
	}
}
