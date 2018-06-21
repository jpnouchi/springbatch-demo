package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.primeur.bcp.teletransfer.common.constant.ProductConstants;
import com.primeur.bcp.teletransfer.common.model.Product;
import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;


/**
 * FSR ProductDao test class
 * 
 * @author David Reyes
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends AbstractTest {
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertProductTest() throws Exception {

		Product product = new Product();
		
		product.setProductCode("X002");
		product.setDescription("Description");
		product.setDisplacement(5);
		product.setMondayStartDate(new Date());
		product.setMondayEndDate(new Date());
		product.setTuesdayStartDate(new Date());
		product.setTuesdayEndDate(new Date());
		product.setWednesdayStartDate(new Date());
		product.setWednesdayEndDate(new Date());
		product.setThursdayStartDate(new Date());
		product.setThursdayEndDate(new Date());
		product.setFridayStartDate(new Date());
		product.setFridayEndDate(new Date());
		product.setSaturdayStartDate(new Date());
		product.setSaturdayEndDate(new Date());
		product.setSundayStartDate(new Date());
		product.setSundayEndDate(new Date());	
		product.setValidator(true);
		product.setConsolidatorState(ProductConstants.ACTIVE_STATUS);
		product.setDistributorState(ProductConstants.ACTIVE_STATUS);
		product.setAppInterfaceType(ProductConstants.FILE_APP_INTERFACE_TYPE);
		product.setAppQueueIn("QAPP.X002.FTE");
		product.setAppFilePathIn("/home/bcp/Apps/TTRA/data/consolidator");
		product.setAppFilePathOut("/home/bcp/Apps/TTRA/data/distributor/proceso");
		product.setOutQueueName("QP.X002.OUT");
		product.setInQueueName("QP.X002.IN");
		product.setCreateDate(new Date());
		product.setUpdateDate(new Date());
		
		ProductDao.insertProduct(product);
		
		product = new Product();
		
		product.setProductCode("X001");
		product.setDescription("Description");
		product.setDisplacement(5);
		product.setMondayStartDate(new Date());
		product.setMondayEndDate(new Date());
		product.setTuesdayStartDate(new Date());
		product.setTuesdayEndDate(new Date());
		product.setWednesdayStartDate(new Date());
		product.setWednesdayEndDate(new Date());
		product.setThursdayStartDate(new Date());
		product.setThursdayEndDate(new Date());
		product.setFridayStartDate(new Date());
		product.setFridayEndDate(new Date());
		product.setSaturdayStartDate(new Date());
		product.setSaturdayEndDate(new Date());
		product.setSundayStartDate(new Date());
		product.setSundayEndDate(new Date());	
		product.setValidator(true);
		product.setConsolidatorState(ProductConstants.ACTIVE_STATUS);
		product.setDistributorState(ProductConstants.ACTIVE_STATUS);
		product.setAppInterfaceType(ProductConstants.QUEUE_APP_INTERFACE_TYPE);
		product.setAppQueueIn("QAPP.X001.FTE");
		product.setRemoteWMQFTEAgent("AGENTE02");
		product.setRemoteWMQFTEQueueManager("QMBCP.WMQFTE");
		product.setAppFilePathIn("/tmp/AGENTE02");
		product.setAppFilePathOut("/home/bcp/Apps/TTRA/data/distributor/proceso/X001");
		product.setOutQueueName("QP.X001.OUT");
		product.setInQueueName("QP.X001.IN");
		product.setCreateDate(new Date());
		product.setUpdateDate(new Date());
		
		ProductDao.insertProduct(product);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertProductsTest() throws Exception {

		for (int i = 10; i < 40; i++) {
	
			Product product = new Product();
			
			product.setProductCode("X0" + i);
			product.setDescription("Description");
			product.setDisplacement(123);
			product.setMondayStartDate(new Date());
			product.setMondayEndDate(new Date());
			product.setTuesdayStartDate(new Date());
			product.setTuesdayEndDate(new Date());
			product.setWednesdayStartDate(new Date());
			product.setWednesdayEndDate(new Date());
			product.setThursdayStartDate(new Date());
			product.setThursdayEndDate(new Date());
			product.setFridayStartDate(new Date());
			product.setFridayEndDate(new Date());
			product.setSaturdayStartDate(new Date());
			product.setSaturdayEndDate(new Date());
			product.setSundayStartDate(new Date());
			product.setSundayEndDate(new Date());	
			product.setValidator(true);
			product.setConsolidatorState(ProductConstants.ACTIVE_STATUS);
			product.setDistributorState(ProductConstants.ACTIVE_STATUS);
			product.setAppInterfaceType(ProductConstants.FILE_APP_INTERFACE_TYPE);
			product.setAppQueueIn("App Queue In");
			product.setAppFilePathIn("App File Path In");
			product.setAppFilePathOut("App File Path Out");
			product.setOutQueueName("Out queue name");
			product.setInQueueName("In queue name");
			product.setCreateDate(new Date());
			product.setUpdateDate(new Date());
			
			ProductDao.insertProduct(product);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test002_updateProductTest() throws Exception {

		Product product = new Product();
		
		product.setProductCode("CDPG");
		product.setDescription("Product description updated");
		product.setDisplacement(123);
		product.setMondayStartDate(new Date());
		product.setMondayEndDate(new Date());
		product.setTuesdayStartDate(new Date());
		product.setTuesdayEndDate(new Date());
		product.setWednesdayStartDate(new Date());
		product.setWednesdayEndDate(new Date());
		product.setThursdayStartDate(new Date());
		product.setThursdayEndDate(new Date());
		product.setFridayStartDate(new Date());
		product.setFridayEndDate(new Date());
		product.setSaturdayStartDate(new Date());
		product.setSaturdayEndDate(new Date());
		product.setSundayStartDate(new Date());
		product.setSundayEndDate(new Date());	
		product.setValidator(true);
		product.setConsolidatorState('C');
		product.setDistributorState('D');
		product.setAppInterfaceType('T');
		product.setAppQueueIn("App Queue In");
		product.setAppFilePathIn("App File Path In");
		product.setAppFilePathOut("App File Path Out");
		product.setOutQueueName("QP.CDPG.OUT");
		product.setInQueueName("QP.CDPG.IN");
		product.setCreateDate(new Date());
		product.setUpdateDate(new Date());
		
		ProductDao.updateProduct(product);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test003_getProductListTest() throws Exception {

		String productWhereClause = " PRODUCT_CODE = 'CDPG' ";
		ProductDao.getProductList(productWhereClause);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_deleteProductTest() throws Exception {

		ProductDao.deleteProduct("X001");
		ProductDao.deleteProduct("X002");
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_deleteProductsTest() throws Exception {

		for (int i = 10; i < 40; i++) {
			
			ProductDao.deleteProduct("X0" + i);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test005_getProductListCountTest() throws Exception {
		
		String whereClause = ProductDao.METADATANAME_APP_INTERFACE_TYPE + " = 'F'";

		ProductDao.getProductListCount(whereClause);
	}
}
