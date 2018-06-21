package com.primeur.bcp.teletransfer.common.model;

import java.util.Date;

/**
 * This class is a POJO that contains data of the 
 * company/product relationship
 * 
 * @author David Reyes
 *
 */
public class CompanyProduct {

	private String companyCode;
	
	private String productCode;
	
	private String usuProdCode;
	
	private Date createDate;

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
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the usuProdCode
	 */
	public String getUsuProdCode() {
		return usuProdCode;
	}

	/**
	 * @param usuProdCode the usuProdCode to set
	 */
	public void setUsuProdCode(String usuProdCode) {
		this.usuProdCode = usuProdCode;
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
}
