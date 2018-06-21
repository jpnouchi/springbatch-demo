package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.primeur.bcp.teletransfer.common.model.AuditRecord;
import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;

/**
 * FSR AuditDao test class
 * 
 * @author David Reyes
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditDaoTest extends AbstractTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertAuditRecordTest() throws Exception {	
		
		AuditRecord auditRecord = new AuditRecord();
		
		auditRecord.setOperationCode("TST1");
		auditRecord.setOperationDesc("Operation desc");
		auditRecord.setOperationResult(true);
		auditRecord.setUserName("TEST0001");
		auditRecord.setUserFullName("User full name");
		auditRecord.setDescription("Desc");
		auditRecord.setOperationDate(new Date());
		
		AuditDao.insertAuditRecord(auditRecord);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test002_getAuditRecordListTest() throws Exception {
		
//		String whereClause = "TO_DATE(VARCHAR_FORMAT(OPERATION_DATE,'dd/MM/yyyy'), 'dd/MM/yyyy') >= TO_DATE('20/02/2014','dd/MM/yyyy') AND TO_DATE(VARCHAR_FORMAT(OPERATION_DATE,'dd/MM/yyyy'), 'dd/MM/yyyy') <= TO_DATE('20/02/2014','dd/MM/yyyy')";
//		String orderByClause = "OPERATION_DATE DESC";
		
		String whereClause = "OPERATION_DATE IS NOT NULL";
		String orderByClause = "OPERATION_DATE DESC";

		AuditDao.getAuditRecordList(whereClause, orderByClause, 0, 10);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test003_deleteAllAuditRecordsTest() throws Exception {

		AuditDao.deleteAllAuditRecords();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_getAuditRecordListCountTest() throws Exception {
		
		String whereClause = "TO_DATE(VARCHAR_FORMAT(OPERATION_DATE,'dd/MM/yyyy'), 'dd/MM/yyyy') >= TO_DATE('20/02/2014','dd/MM/yyyy') AND TO_DATE(VARCHAR_FORMAT(OPERATION_DATE,'dd/MM/yyyy'), 'dd/MM/yyyy') <= TO_DATE('20/02/2014','dd/MM/yyyy')";
		
//		String whereClause = AuditDao.METADATANAME_OPERATION_RESULT + " = '1'";

		AuditDao.getAuditRecordListCount(whereClause);
	}
}
