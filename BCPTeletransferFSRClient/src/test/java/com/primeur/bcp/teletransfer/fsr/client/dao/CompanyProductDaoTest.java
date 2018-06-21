package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.primeur.bcp.teletransfer.common.model.CompanyProduct;
import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;

/**
 * FSR CompanyProductDao test class
 * 
 * @author David Reyes
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyProductDaoTest extends AbstractTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertCompanyProductTest() throws Exception {

		CompanyProduct companyProduct = new CompanyProduct();
		
		companyProduct.setCompanyCode("TEST0002");
		companyProduct.setProductCode("VERF");
		companyProduct.setUsuProdCode("USPRD");
		companyProduct.setCreateDate(new Date());
		
		CompanyProductDao.insertCompanyProduct(companyProduct);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertCompanyProductsTest() throws Exception {
		
		int firstUsuProd = 1000;
		
		for (int i = 1000; i < 4000; i++) {
			
			for (int j = 10; j < 40; j++) {

				CompanyProduct companyProduct = new CompanyProduct();
				
				companyProduct.setCompanyCode("X0" + i);
				companyProduct.setProductCode("X0" + j);
				companyProduct.setUsuProdCode("0" + firstUsuProd++);
				companyProduct.setCreateDate(new Date());
				
				CompanyProductDao.insertCompanyProduct(companyProduct);
			}
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test002_updateCompanyProductTest() throws Exception {

		CompanyProduct companyProduct = new CompanyProduct();
		
		companyProduct.setCompanyCode("TEST0002");
		companyProduct.setProductCode("TST2");
		companyProduct.setUsuProdCode("USPRD");
		companyProduct.setCreateDate(new Date());
		
		CompanyProductDao.updateCompanyProduct(companyProduct);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test003_getCompanyProductListTest() throws Exception {

		CompanyProductDao.getCompanyProductList();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_getCompanyProductListTest() throws Exception {

		String whereClause = CompanyProductDao.METADATANAME_COMPANY_CODE + "='TEST0001'";
		
		CompanyProductDao.getCompanyProductList(whereClause);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test005_deleteCompanyProductTest() throws Exception {

		CompanyProductDao.deleteCompanyProduct("TEST0002","VERF");
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test005_deleteCompanyProductsTest() throws Exception {
		
		for (int i = 1000; i < 4000; i++) {
			
			for (int j = 10; j < 40; j++) {
				
				CompanyProductDao.deleteCompanyProduct("X0" + i, "X0" + j);
			}
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test006_getCompanyProductListCountTest() throws Exception {
		
		String whereClause = CompanyProductDao.METADATANAME_USU_PROD_CODE + " IS NOT NULL";

		CompanyProductDao.getCompanyProductListCount(whereClause);
	}
}
