package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.model.CompanyProduct;
import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.bcp.teletransfer.fsr.client.constant.FSRClientConstants;
import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.bcp.teletransfer.fsr.client.util.FSRClientUtil;
import com.primeur.spmfts.filebox.domain.Fileset;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.domain.MetadataSet;

/**
 * Class used to access SPFB_BCP_COMPANY_PRODUCT_MD
 * 
 * @author David Reyes
 *
 */
public class CompanyProductDao {

	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(CompanyProductDao.class);

	///////////////////////////////////////////////////
	/// Definitions for SPFB_BCP_COMPANY_PRODUCT_MD ///
	///////////////////////////////////////////////////
	
	// The METADATACLASS ...
	private static final String METADATACLASS_BCP_COMPANY_PRODUCT = "SPFB_BCP_COMPANY_PRODUCT_MD";
	
	// ... and its METADATANAMEs
	public static final String METADATANAME_COMPANY_CODE		= "COMPANY_CODE";		// VARCHAR(10)
	public static final String METADATANAME_PRODUCT_CODE		= "PRODUCT_CODE";		// VARCHAR(4)
	public static final String METADATANAME_USU_PROD_CODE		= "USU_PROD_CODE";		// VARCHAR(5)
	public static final String METADATANAME_CREATE_DATE     	= "CREATE_DATE";		// TIMESTAMP
		
	// Logger dataType constant
	private static final String DATA_TYPE = FSRClientConstants.COMPANY_PRODUCT;
	
	/**
	 * Inserts a company/product relationship into FSR database
	 * 
	 * @param companyProduct company/product relationship to insert
	 * @throws Exception
	 */
	public synchronized static void insertCompanyProduct(CompanyProduct companyProduct) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_INSERT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, companyProduct.getCompanyCode()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		Fileset companyProductFileset = new Fileset();
		companyProductFileset.setIdUserClass(FSRClientConstants.FSR_REMOTE_DB_BCP_ID_USER_CLASS);
		MetadataSet companyProductMetadataSet = new MetadataSet();
		companyProductMetadataSet.setMetadataClass(METADATACLASS_BCP_COMPANY_PRODUCT);
		
		companyProductMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_COMPANY_CODE, companyProduct.getCompanyCode()));
		companyProductMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_PRODUCT_CODE, companyProduct.getProductCode()));
		companyProductMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USU_PROD_CODE, companyProduct.getUsuProdCode()));
		companyProductMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CREATE_DATE, companyProduct.getCreateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		
		companyProductFileset.addMetadataSet(companyProductMetadataSet);
		
		// following instruction persists data into remote db
		companyProductFileset.save();
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, companyProduct.getCompanyCode()));
	}
	
	/**
	 * Updates a company/product relationship record stored in FSR database
	 * 
	 * @param companyProduct company/product relationship to update
	 * @throws Exception
	 */
	public synchronized static void updateCompanyProduct(CompanyProduct companyProduct) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_UPDATE;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, companyProduct.getCompanyCode()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
				
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_COMPANY_PRODUCT);
		
		String whereClause = METADATANAME_COMPANY_CODE + "='" + companyProduct.getCompanyCode() + "' AND " + METADATANAME_PRODUCT_CODE + "='" + companyProduct.getProductCode() + "'";
		
		FilesetList companyProductFilesetList = new FilesetList(metadataClass, whereClause, 0, 0, false, true);
		
		for (Fileset companyProductFileset : companyProductFilesetList) {
			
			MetadataSet companyProductMetadataSet = companyProductFileset.getMetadataSet(METADATACLASS_BCP_COMPANY_PRODUCT);
			
			companyProductMetadataSet.getMetadataValue(METADATANAME_PRODUCT_CODE).setValue(companyProduct.getProductCode());
			companyProductMetadataSet.getMetadataValue(METADATANAME_USU_PROD_CODE).setValue(companyProduct.getUsuProdCode());
			companyProductMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).setValue(ParseUtil.dateToString(companyProduct.getCreateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		
			// following instruction persists data into remote db
			companyProductFileset.save();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, companyProduct.getCompanyCode()));
		logger.debug(String.format(LoggerMessages.ROWS_UPDATED_FORMAT, companyProductFilesetList.size()));
	}
	
	/**
	 * Deletes a company/product relationship record stored in FSR database
	 * 
	 * @param companyCode of the company/product relationship to delete
	 * @param productCode of the company/product relationship to delete
	 * @throws Exception
	 */
	public synchronized static void deleteCompanyProduct(String companyCode, String productCode) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_DELETE;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, companyCode));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_COMPANY_PRODUCT);
		
		String whereClause = METADATANAME_COMPANY_CODE + "='" + companyCode + "' AND " + METADATANAME_PRODUCT_CODE + "='" + productCode + "'";
		
		FilesetList companyProductFilesetList = new FilesetList(metadataClass, whereClause, 0, 0, false, true);
		
		String presenceString;
		
		switch (companyProductFilesetList.size()) {
			
			case 0:
				presenceString = LoggerMessages.NOT_FOUND;
				break;
			case 1:
				presenceString = LoggerMessages.FOUND;
				break;
			default:
				presenceString = String.format(LoggerMessages.ROWS_FOUND_FORMAT, companyProductFilesetList.size());
		}
		
		logger.debug(String.format(LoggerMessages.PRESENCE_PARAM_FORMAT, DATA_TYPE, companyCode, presenceString));
		
		for (Fileset companyProductFileset : companyProductFilesetList) {
			// following instruction removes data into remote db
			companyProductFileset.delete();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, companyCode));
		logger.debug(String.format(LoggerMessages.ROWS_DELETED_FORMAT, companyProductFilesetList.size()));
	}
	
	/**
	 * Deletes company/product relationship records stored in FSR database by companyCode
	 * 
	 * @param companyCode of the company/product relationship to delete
	 * @throws Exception
	 */
	public synchronized static void deleteCompanyProductByCompanyCode(String companyCode) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_DELETE;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, companyCode));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_COMPANY_PRODUCT);
		
		String whereClause = METADATANAME_COMPANY_CODE + "='" + companyCode + "'";
		
		FilesetList companyProductFilesetList = new FilesetList(metadataClass, whereClause, 0, 0, false, true);
		
		String presenceString;
		
		switch (companyProductFilesetList.size()) {
			
			case 0:
				presenceString = LoggerMessages.NOT_FOUND;
				break;
			case 1:
				presenceString = LoggerMessages.FOUND;
				break;
			default:
				presenceString = String.format(LoggerMessages.ROWS_FOUND_FORMAT, companyProductFilesetList.size());
		}
		
		logger.debug(String.format(LoggerMessages.PRESENCE_PARAM_FORMAT, DATA_TYPE, companyCode, presenceString));
		
		for (Fileset companyProductFileset : companyProductFilesetList) {
			// following instruction removes data into remote db
			companyProductFileset.delete();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, companyCode));
		logger.debug(String.format(LoggerMessages.ROWS_DELETED_FORMAT, companyProductFilesetList.size()));
	}
	
	/**
	 * Deletes a company/product relationship record stored in FSR database by productCode
	 * 
	 * @param productCode of the company/product relationship to delete
	 * @throws Exception
	 */
	public synchronized static void deleteCompanyProductByProductCode(String productCode) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_DELETE;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, productCode));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_COMPANY_PRODUCT);
		
		String whereClause = METADATANAME_PRODUCT_CODE + "='" + productCode + "'";
		
		FilesetList companyProductFilesetList = new FilesetList(metadataClass, whereClause, 0, 0, false, true);
		
		String presenceString;
		
		switch (companyProductFilesetList.size()) {
			
			case 0:
				presenceString = LoggerMessages.NOT_FOUND;
				break;
			case 1:
				presenceString = LoggerMessages.FOUND;
				break;
			default:
				presenceString = String.format(LoggerMessages.ROWS_FOUND_FORMAT, companyProductFilesetList.size());
		}
		
		logger.debug(String.format(LoggerMessages.PRESENCE_PARAM_FORMAT, DATA_TYPE, productCode, presenceString));
		
		for (Fileset companyProductFileset : companyProductFilesetList) {
			// following instruction removes data into remote db
			companyProductFileset.delete();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, productCode));
		logger.debug(String.format(LoggerMessages.ROWS_DELETED_FORMAT, companyProductFilesetList.size()));
	}
	
	/**
	 * Returns a list with all company/product relations
	 * 
	 * @return company/product relationship list
	 * @throws Exception
	 */
	@Deprecated
	public synchronized static List<CompanyProduct> getCompanyProductList () throws Exception {
		return getCompanyProductList(null, null, 0, 0);
	}
	
	/**
	 * Returns a company/product relationship list. All listed company/product relations match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return company/product relationship list
	 * @throws Exception
	 */
	public synchronized static List<CompanyProduct> getCompanyProductList (String whereClause) throws Exception {
		return getCompanyProductList(whereClause, null, 0, 0);
	}
	
	/**
	 * Returns a company/product relationship list. All listed company/product relations match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @param orderByClause order by clause for retrieving information from database
	 * @param offset
	 * @param count number of records
	 * @return company list
	 * @throws Exception
	 */
	public synchronized static List<CompanyProduct> getCompanyProductList(String whereClause, String orderByClause, int offset, int count) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
						
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		List<CompanyProduct> companyProductList = new ArrayList<CompanyProduct>();
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_COMPANY_PRODUCT);
		
		FilesetList companyProductFilesetList;
		
		if (whereClause != null && whereClause.length() > 0) {
			
			if (orderByClause != null && orderByClause.length() > 0) {
				
				companyProductFilesetList = new FilesetList(metadataClass, whereClause, orderByClause, offset, count, false, true);
				
			} else {
				
				companyProductFilesetList = new FilesetList(metadataClass, whereClause, offset, count, false, true);
			}
			
		} else {
			
			companyProductFilesetList = new FilesetList(metadataClass, offset, count);
		}	
		
		for (Fileset companyProductFileset : companyProductFilesetList) {
			
			MetadataSet companyMetadataSet = companyProductFileset.getMetadataSet(METADATACLASS_BCP_COMPANY_PRODUCT);
			
			CompanyProduct companyProduct = fillCompanyProductData(new CompanyProduct(), companyMetadataSet);
			
			companyProductList.add(companyProduct);
			
			logger.debug("CompanyProduct: " + companyProduct.getCompanyCode() + " - " + companyProduct.getProductCode() + " - " + companyProduct.getUsuProdCode());
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return companyProductList;
	}
	
	/**
	 * Returns the count of all company/product relationships that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return company/product relationship list count
	 * @throws Exception
	 */
	public synchronized static int getCompanyProductListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		logger.debug("companyProductListCount whereClause: " + whereClause);
		
		int companyProductListCount = FilesetList.countRecordByClass(METADATACLASS_BCP_COMPANY_PRODUCT, whereClause);
		
		logger.debug("companyProductListCount: " + companyProductListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return companyProductListCount;
	}
	
	/**
	 * Fills a company/product relation with the data retrieved from a FSR MetadataSet
	 * 
	 * @param companyProduct company/product relation to be filled
	 * @param companyProductMetadataSet
	 * @return filled company/product relation
	 * @throws Exception
	 */
	private synchronized static CompanyProduct fillCompanyProductData(CompanyProduct companyProduct, MetadataSet companyProductMetadataSet) throws Exception {
		
		companyProduct.setCompanyCode(companyProductMetadataSet.getMetadataValue(METADATANAME_COMPANY_CODE).getValue());
		companyProduct.setProductCode(companyProductMetadataSet.getMetadataValue(METADATANAME_PRODUCT_CODE).getValue());
		companyProduct.setUsuProdCode(companyProductMetadataSet.getMetadataValue(METADATANAME_USU_PROD_CODE).getValue());
		companyProduct.setCreateDate(ParseUtil.stringToDate(companyProductMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		
		return companyProduct;
	}
}
