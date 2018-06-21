package com.primeur.bcp.teletransfer.fsr.client.dao;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.primeur.bcp.teletransfer.common.model.File;
import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;

/**
 * FSR FileDao test class
 * 
 * @author David Reyes
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileDaoTest extends AbstractTest {
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_updateFileTest() throws Exception {

		File file = new File();
		file.setInternalNumber("0005000000014157");
		file.setFileStatus('1');
		file.setValidatorRecordCount(111);
		
		FileDao.updateFile(file);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test002_getFileListTest() throws Exception {

		FileDao.getFileList();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test003_getFileListTest() throws Exception {
		
//		String whereClause = FileDao.METADATANAME_INTERNAL_NUMBER + " = '0005000000014157'";
//		String whereClause = FileDao.METADATANAME_QUEUE_NAME + " = 'SYSTEM.LOGS'";
//		String whereClause = 	FileDao.METADATANAME_SENDER + " = '" + FileConstants.VALIDATOR_SENDER + "' AND " +
//								FileDao.METADATANAME_QUEUE_NAME + " = 'C.TSQQ02.OUT'";// AND " + 
//		String whereClause =	FileDao.METADATANAME_QUEUE_NAME + " = 'C.TSQQ02.IN'";// AND " + 
		String whereClause =	FileDao.METADATANAME_QUEUE_NAME + " = 'C.TC6502.IN'";// AND " + 
//								FileDao.METADATANAME_DESTINATION_FILENAME + " = 'splnode.ini'";
		FileDao.getFileList(whereClause);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_getFileListCountTest() throws Exception {
		
		String whereClause = FileDao.METADATANAME_QUEUE_NAME + " = 'SYSTEM.LOGS'";
		
//		String whereClause = FileDao.METADATANAME_QUEUE_NAME + " = 'C.TC6502.IN'";// AND " + 

		FileDao.getFileListCount(whereClause);
	}
}
