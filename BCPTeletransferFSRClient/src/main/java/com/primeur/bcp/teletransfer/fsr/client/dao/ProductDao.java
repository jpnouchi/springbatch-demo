package com.primeur.bcp.teletransfer.fsr.client.dao;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.model.Product;
import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.bcp.teletransfer.fsr.client.constant.FSRClientConstants;
import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.bcp.teletransfer.fsr.client.util.FSRClientUtil;
import com.primeur.spmfts.filebox.domain.Fileset;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.domain.MetadataSet;
import com.primeur.spmfts.filebox.exception.FileboxClientException;

/**
 * Class used to access SPFB_BCP_PRODUCTS_MD
 * 
 * @author David Reyes
 *
 */
public class ProductDao {
	
	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(ProductDao.class);
	
	////////////////////////////////////////////
	/// Definitions for SPFB_BCP_PRODUCTS_MD ///
	////////////////////////////////////////////
	
	// The METADATACLASS ...
	private static final String METADATACLASS_BCP_PRODUCTS    = "SPFB_BCP_PRODUCTS_MD";
	
	// ... and its METADATANAMEs
	public static final String METADATANAME_PRODUCT_CODE             = "PRODUCT_CODE";				// VARCHAR(4)
	public static final String METADATANAME_DESCRIPTION              = "DESCRIPTION";				// VARCHAR(50)
	public static final String METADATANAME_DISPLACEMENT             = "DISPLACEMENT";				// INTEGER
	public static final String METADATANAME_MONDAY_START             = "MONDAY_START";				// TIMESTAMP
	public static final String METADATANAME_MONDAY_END               = "MONDAY_END";				// TIMESTAMP
	public static final String METADATANAME_TUESDAY_START            = "TUESDAY_START";				// TIMESTAMP
	public static final String METADATANAME_TUESDAY_END              = "TUESDAY_END";				// TIMESTAMP
	public static final String METADATANAME_WEDNESDAY_START          = "WEDNESDAY_START";			// TIMESTAMP
	public static final String METADATANAME_WEDNESDAY_END            = "WEDNESDAY_END";				// TIMESTAMP
	public static final String METADATANAME_THURSDAY_START           = "THURSDAY_START";			// TIMESTAMP
	public static final String METADATANAME_THURSDAY_END             = "THURSDAY_END";				// TIMESTAMP
	public static final String METADATANAME_FRIDAY_START             = "FRIDAY_START";				// TIMESTAMP
	public static final String METADATANAME_FRIDAY_END               = "FRIDAY_END";				// TIMESTAMP
	public static final String METADATANAME_SATURDAY_START           = "SATURDAY_START";			// TIMESTAMP
	public static final String METADATANAME_SATURDAY_END             = "SATURDAY_END";				// TIMESTAMP
	public static final String METADATANAME_SUNDAY_START             = "SUNDAY_START";				// TIMESTAMP
	public static final String METADATANAME_SUNDAY_END               = "SUNDAY_END";				// TIMESTAMP
	public static final String METADATANAME_VALIDATOR                = "VALIDATOR";					// SMALLINT
	public static final String METADATANAME_CONSOLIDATION_STATE      = "CONSOLIDATION_STATE";		// VARCHAR(1)
	public static final String METADATANAME_DISTRIBUTOR_STATE        = "DISTRIBUTOR_STATE";			// VARCHAR(1)
	public static final String METADATANAME_APP_INTERFACE_TYPE       = "APP_INTERFACE_TYPE";		// VARCHAR(1)
	
	public static final String METADATANAME_APP_QUEUE_IN      		 = "APP_QUEUE_IN";				// VARCHAR(255)
	public static final String METADATANAME_APP_FILE_PATH_IN     	 = "APP_FILE_PATH_IN";			// VARCHAR(255)
	public static final String METADATANAME_APP_FILE_PATH_OUT      	 = "APP_FILE_PATH_OUT";			// VARCHAR(255)
	
	public static final String METADATANAME_OUT_QUEUE_NAME        	 = "OUT_QUEUE_NAME";			// VARCHAR(50)
	public static final String METADATANAME_IN_QUEUE_NAME       	 = "IN_QUEUE_NAME";				// VARCHAR(50)
	public static final String METADATANAME_CREATE_DATE              = "CREATE_DATE";				// TIMESTAMP
	public static final String METADATANAME_UPDATE_DATE              = "UPDATE_DATE";				// TIMESTAMP
	
	public static final String METADATANAME_REM_WMQFTE_QM			 = "REM_WMQFTE_QM";             // VARCHAR(48)
	public static final String METADATANAME_REM_WMQFTE_AGENT		 = "REM_WMQFTE_AGENT";          // VARCHAR(24)
	
	// Logger dataType constant
	private static final String DATA_TYPE = FSRClientConstants.PRODUCT;
		
	/**
	 * Inserts a product record into FSR database
	 * 
	 * @param product product to insert
	 * @throws Exception
	 */
	public synchronized static Product insertProduct(Product product) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_INSERT;
		
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, product.getProductCode()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		Date actualDate = new Date();
		product.setCreateDate(actualDate);
		product.setUpdateDate(actualDate);
		
		Fileset productFileset = new Fileset();
		productFileset.setIdUserClass(FSRClientConstants.FSR_REMOTE_DB_BCP_ID_USER_CLASS);
		MetadataSet productMetadataSet = new MetadataSet();
		productMetadataSet.setMetadataClass(METADATACLASS_BCP_PRODUCTS);

		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_PRODUCT_CODE, product.getProductCode()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DESCRIPTION, product.getDescription()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DISPLACEMENT, product.getDisplacement()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_MONDAY_START, product.getMondayStartDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_MONDAY_END, product.getMondayEndDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_TUESDAY_START, product.getTuesdayStartDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_TUESDAY_END, product.getTuesdayEndDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_WEDNESDAY_START, product.getWednesdayStartDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_WEDNESDAY_END, product.getWednesdayEndDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_THURSDAY_START, product.getThursdayStartDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_THURSDAY_END, product.getThursdayEndDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_FRIDAY_START, product.getFridayStartDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_FRIDAY_END, product.getFridayEndDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_SATURDAY_START, product.getSaturdayStartDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_SATURDAY_END, product.getSaturdayEndDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_SUNDAY_START, product.getSundayStartDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_SUNDAY_END, product.getSundayEndDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_VALIDATOR, ParseUtil.booleanToInteger(product.getValidator())));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CONSOLIDATION_STATE, product.getConsolidatorState()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_DISTRIBUTOR_STATE, product.getDistributorState()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_APP_INTERFACE_TYPE, product.getAppInterfaceType()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_APP_QUEUE_IN, product.getAppQueueIn()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_APP_FILE_PATH_IN, product.getAppFilePathIn()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_APP_FILE_PATH_OUT, product.getAppFilePathOut()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_OUT_QUEUE_NAME, product.getOutQueueName()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_IN_QUEUE_NAME, product.getInQueueName()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CREATE_DATE, product.getCreateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_UPDATE_DATE, product.getUpdateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_REM_WMQFTE_AGENT, product.getRemoteWMQFTEAgent()));
		productMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_REM_WMQFTE_QM, product.getRemoteWMQFTEQueueManager()));
		
		productFileset.addMetadataSet(productMetadataSet);
		
		// following instruction persists data into remote db
		productFileset.save();
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, product.getProductCode()));
	
		return product;
	}
	
	/**
	 * Updates a product record stored in FSR database
	 * 
	 * @param product product to update
	 * @throws Exception
	 */
	public synchronized static Product updateProduct(Product product) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_UPDATE;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, product.getProductCode()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		product.setUpdateDate(new Date());
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_PRODUCTS);
		
		FilesetList productFilesetList = new FilesetList(metadataClass, " " + METADATANAME_PRODUCT_CODE + "='" + product.getProductCode() + "'", 0, 0, false, true);
		
		for (Fileset productFileset : productFilesetList) {
			
			MetadataSet productMetadataSet = productFileset.getMetadataSet(METADATACLASS_BCP_PRODUCTS);
			
			productMetadataSet.getMetadataValue(METADATANAME_DESCRIPTION).setValue(product.getDescription());
			productMetadataSet.getMetadataValue(METADATANAME_DISPLACEMENT).setValue(product.getDisplacement());		
			productMetadataSet.getMetadataValue(METADATANAME_MONDAY_START).setValue(ParseUtil.dateToString(product.getMondayStartDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_MONDAY_END).setValue(ParseUtil.dateToString(product.getMondayEndDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_TUESDAY_START).setValue(ParseUtil.dateToString(product.getTuesdayStartDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_TUESDAY_END).setValue(ParseUtil.dateToString(product.getTuesdayEndDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_WEDNESDAY_START).setValue(ParseUtil.dateToString(product.getWednesdayStartDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_WEDNESDAY_END).setValue(ParseUtil.dateToString(product.getWednesdayEndDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_THURSDAY_START).setValue(ParseUtil.dateToString(product.getThursdayStartDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_THURSDAY_END).setValue(ParseUtil.dateToString(product.getThursdayEndDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_FRIDAY_START).setValue(ParseUtil.dateToString(product.getFridayStartDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_FRIDAY_END).setValue(ParseUtil.dateToString(product.getFridayEndDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_SATURDAY_START).setValue(ParseUtil.dateToString(product.getSaturdayStartDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_SATURDAY_END).setValue(ParseUtil.dateToString(product.getSaturdayEndDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_SUNDAY_START).setValue(ParseUtil.dateToString(product.getSundayStartDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_SUNDAY_END).setValue(ParseUtil.dateToString(product.getSundayEndDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));	
			productMetadataSet.getMetadataValue(METADATANAME_VALIDATOR).setValue(ParseUtil.booleanToInteger(product.getValidator()));
			productMetadataSet.getMetadataValue(METADATANAME_CONSOLIDATION_STATE).setValue(product.getConsolidatorState());
			productMetadataSet.getMetadataValue(METADATANAME_DISTRIBUTOR_STATE).setValue(product.getDistributorState());
			productMetadataSet.getMetadataValue(METADATANAME_APP_INTERFACE_TYPE).setValue(product.getAppInterfaceType());
			productMetadataSet.getMetadataValue(METADATANAME_APP_QUEUE_IN).setValue(product.getAppQueueIn());
			productMetadataSet.getMetadataValue(METADATANAME_APP_FILE_PATH_IN).setValue(product.getAppFilePathIn());
			productMetadataSet.getMetadataValue(METADATANAME_APP_FILE_PATH_OUT).setValue(product.getAppFilePathOut());
			productMetadataSet.getMetadataValue(METADATANAME_OUT_QUEUE_NAME).setValue(product.getOutQueueName());
			productMetadataSet.getMetadataValue(METADATANAME_IN_QUEUE_NAME).setValue(product.getInQueueName());	
//			productMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).setValue(ParseUtil.dateToString(product.getCreateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_UPDATE_DATE).setValue(ParseUtil.dateToString(product.getUpdateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			productMetadataSet.getMetadataValue(METADATANAME_REM_WMQFTE_AGENT).setValue(product.getRemoteWMQFTEAgent());
			productMetadataSet.getMetadataValue(METADATANAME_REM_WMQFTE_QM).setValue(product.getRemoteWMQFTEQueueManager());
			
			// following instruction persists data into remote db
			productFileset.save();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, product.getProductCode()));
		logger.debug(String.format(LoggerMessages.ROWS_UPDATED_FORMAT, productFilesetList.size()));
	
		return product;
	}
	
	/**
	 * Deletes a product record stored in FSR database
	 * 
	 * @param productCode code of the product to delete
	 * @throws Exception
	 */
	public synchronized static void deleteProduct(String productCode) throws FileboxClientException {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_DELETE;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, productCode));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_PRODUCTS);
		
		FilesetList productFilesetList = new FilesetList(metadataClass, " " + METADATANAME_PRODUCT_CODE + "='" + productCode + "'", 0, 0, false, true);
		
		String presenceString;
		
		switch (productFilesetList.size()) {
		
			case 0:
				presenceString = LoggerMessages.NOT_FOUND;
				break;
			case 1:
				presenceString = LoggerMessages.FOUND;
				break;
			default:
				presenceString = String.format(LoggerMessages.ROWS_FOUND_FORMAT, productFilesetList.size());
		}
		
		logger.debug(String.format(LoggerMessages.PRESENCE_PARAM_FORMAT, DATA_TYPE, productCode, presenceString));
		
		for (Fileset productFileset : productFilesetList) {
			// following instruction removes data into remote db
			productFileset.delete();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, productCode));
		logger.debug(String.format(LoggerMessages.ROWS_DELETED_FORMAT, productFilesetList.size()));
	}
	
	/**
	 * Returns a list with all products.
	 * 
	 * @return product list
	 * @throws Exception
	 */
	@Deprecated
	public synchronized static List<Product> getProductList () throws Exception {
		return getProductList(null, null, 0, 0);
	}
	
	/**
	 * Returns a list with all products.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return product list
	 * @throws Exception
	 */
	public synchronized static List<Product> getProductList (String whereClause) throws Exception {
		return getProductList(whereClause, null, 0, 0);
	}
	
	/**
	 * Returns a product list. All listed products match
	 * the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @param orderByClause order by clause for retrieving information from database
	 * @param offset
	 * @param count number of records
	 * @return product list
	 * @throws Exception
	 */
	public synchronized static List<Product> getProductList (String whereClause, String orderByClause, int offset, int count) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
				
		List<Product> productList = new ArrayList<Product>();
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_PRODUCTS);
		
		FilesetList productFilesetList;
		
		if (whereClause != null && whereClause.length() > 0) {
			
			if (orderByClause != null && orderByClause.length() > 0) {
				
				productFilesetList = new FilesetList(metadataClass, whereClause, orderByClause, offset, count, false, true);
				
			} else {
				
				productFilesetList = new FilesetList(metadataClass, whereClause, offset, count, false, true);
			}
			
		} else
			productFilesetList = new FilesetList(metadataClass);
		
		for (Fileset productFileset : productFilesetList) {
			
			MetadataSet productMetadataSet = productFileset.getMetadataSet(METADATACLASS_BCP_PRODUCTS);
			
			Product product = fillProductData(new Product(), productMetadataSet);
			
			productList.add(product);
			
			logger.debug("Product: " + product.getProductCode() + " - " + product.getDescription());
		}	
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return productList;
	}
	
	/**
	 * Returns the count of all products that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return company list count
	 * @throws Exception
	 */
	public synchronized static int getProductListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		logger.debug("productListCount whereClause: " + whereClause);
		
		int productListCount = FilesetList.countRecordByClass(METADATACLASS_BCP_PRODUCTS, whereClause);
		
		logger.debug("productListCount: " + productListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return productListCount;
	}
	
	/**
	 * Fills a product with the data retrieved from a FSR MetadataSet
	 * 
	 * @param product product to be filled
	 * @param productMetadataSet
	 * @return filled product
	 * @throws Exception
	 */
	private synchronized static Product fillProductData(Product product, MetadataSet productMetadataSet) throws Exception {
		
//		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
//		MetadataValue[] metadataValueList = productMetadataSet.getMetadataValueList();
//		for (MetadataValue metadataValue : metadataValueList) {
//			logger.debug(metadataValue.getMetadataName() + ": " + metadataValue.getValue());
//		}
//		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		product.setProductCode(productMetadataSet.getMetadataValue(METADATANAME_PRODUCT_CODE).getValue());
		product.setDescription(productMetadataSet.getMetadataValue(METADATANAME_DESCRIPTION).getValue());
		product.setDisplacement(productMetadataSet.getMetadataValue(METADATANAME_DISPLACEMENT).getValueAsInteger());
		product.setMondayStartDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_MONDAY_START).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setMondayEndDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_MONDAY_END).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setTuesdayStartDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_TUESDAY_START).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setTuesdayEndDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_TUESDAY_END).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setWednesdayStartDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_WEDNESDAY_START).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setWednesdayEndDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_WEDNESDAY_END).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setThursdayStartDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_THURSDAY_START).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setThursdayEndDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_THURSDAY_END).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setFridayStartDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_FRIDAY_START).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setFridayEndDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_FRIDAY_END).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setSaturdayStartDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_SATURDAY_START).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setSaturdayEndDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_SATURDAY_END).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setSundayStartDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_SUNDAY_START).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setSundayEndDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_SUNDAY_END).getValue(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setValidator(ParseUtil.IntegerToBoolean(productMetadataSet.getMetadataValue(METADATANAME_VALIDATOR).getValueAsInteger()));
		product.setConsolidatorState(productMetadataSet.getMetadataValue(METADATANAME_CONSOLIDATION_STATE).getValueAsChar());
		product.setDistributorState(productMetadataSet.getMetadataValue(METADATANAME_DISTRIBUTOR_STATE).getValueAsChar());
		product.setAppInterfaceType(productMetadataSet.getMetadataValue(METADATANAME_APP_INTERFACE_TYPE).getValueAsChar());
		product.setAppQueueIn(productMetadataSet.getMetadataValue(METADATANAME_APP_QUEUE_IN).getValue());
		product.setAppFilePathIn(productMetadataSet.getMetadataValue(METADATANAME_APP_FILE_PATH_IN).getValue());
		product.setAppFilePathOut(productMetadataSet.getMetadataValue(METADATANAME_APP_FILE_PATH_OUT).getValue());
		product.setOutQueueName(productMetadataSet.getMetadataValue(METADATANAME_OUT_QUEUE_NAME).getValue());
		product.setInQueueName(productMetadataSet.getMetadataValue(METADATANAME_IN_QUEUE_NAME).getValue());
		product.setCreateDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setUpdateDate(ParseUtil.stringToDate(productMetadataSet.getMetadataValue(METADATANAME_UPDATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		product.setRemoteWMQFTEAgent(productMetadataSet.getMetadataValue(METADATANAME_REM_WMQFTE_AGENT).getValue());
		product.setRemoteWMQFTEQueueManager(productMetadataSet.getMetadataValue(METADATANAME_REM_WMQFTE_QM).getValue());
		
		return product;
	}
}