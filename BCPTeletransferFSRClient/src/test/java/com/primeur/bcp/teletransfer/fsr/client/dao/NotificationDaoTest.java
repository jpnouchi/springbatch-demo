package com.primeur.bcp.teletransfer.fsr.client.dao;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;

/**
 * FSR NotificationDao test class
 * 
 * @author Francisco Briones
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotificationDaoTest extends AbstractTest {
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_getNotificationListTest() throws Exception {

		
		String whereClause = "TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') >= TO_DATE('16/04/2014','dd/MM/yyyy') AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') <= TO_DATE('16/04/2014','dd/MM/yyyy')";
		
//		String whereClause = NotificationDao.METADATANAME_CONTENT_ID + " IS NOT NULL";
		String orderByClause = NotificationDao.METADATANAME_ACTION_TS+" DESC";
		
		//NotificationDao.getNotificationList(whereClause);
		NotificationDao.getNotificationList(whereClause, orderByClause, 0, 10);
		//NotificationDao.getNotificationList(whereClause, null, 0, 10);
//		NotificationDao.getNotificationList();
	}

	@Test
	@Ignore
	public void test002_getDistinctNotificationListTest() throws Exception {
		
		String whereClause = "((ACTIVITY_NAME = 'consolidation' AND VERSUS = 'OUTPUT') OR (ACTIVITY_NAME = 'distribution' AND VERSUS = 'INPUT') OR (ACTIVITY_NAME like '%put' AND VERSUS = 'OUTPUT') OR (VERSUS = 'OUTPUT' AND FILE_NAME LIKE '%/C.%.OUT/%')) AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') >= TO_DATE('26/05/2014','dd/MM/yyyy') AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') <= TO_DATE('26/05/2014','dd/MM/yyyy')";
		
		String orderByClause = "CONTENT_ID DESC";
		
		NotificationDao.getDistinctNotificationList(whereClause, orderByClause, 0 ,10);
	}
}
