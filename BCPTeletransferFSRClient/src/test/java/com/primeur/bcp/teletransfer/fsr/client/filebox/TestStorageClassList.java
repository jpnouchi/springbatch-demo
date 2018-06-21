package com.primeur.bcp.teletransfer.fsr.client.filebox;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;
import com.primeur.spmfts.filebox.domain.StorageClass;
import com.primeur.spmfts.filebox.domain.StorageClassList;
import com.primeur.spmfts.filebox.exception.FileboxClientException;

public class TestStorageClassList extends AbstractTest {
	
private static final Logger logger = Logger.getLogger(TestStorageClassList.class);
	
	@Test
	@Ignore
	public void testListStorageClass() throws FileboxClientException{
		
		StorageClassList storageClassList = new StorageClassList();
		
		for (StorageClass storageClass : storageClassList) {
			logger.info("StorageClass: " + storageClass.getStorageClassCode());
			logger.info("                id: " + storageClass.getIdStorageClass());
			logger.info("       description: " + storageClass.getDescription());
		}
	}
}