package com.primeur.bcp.teletransfer.fsr.client.filebox;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;
import com.primeur.spmfts.filebox.domain.UserClass;
import com.primeur.spmfts.filebox.domain.UserClassList;
import com.primeur.spmfts.filebox.exception.FileboxClientException;

public class TestUserClassList extends AbstractTest {
	
	private static final Logger logger = Logger.getLogger(TestUserClassList.class);
	
	@Test
	@Ignore
	public void testListUserClass() throws FileboxClientException{
		
		UserClassList userClassList = new UserClassList();
		
		for (UserClass userClass : userClassList) {
			logger.info("UserClass: " + userClass.getUserClassCode());
			logger.info("                id: " + userClass.getIdUserClass());
			logger.info("       description: " + userClass.getDescription());
			logger.info("           storage: " + userClass.getStorageClass().getIdStorageClass());
			logger.info("");
			logger.info("      archivingOpt: " + userClass.getArchivingOpt());
			logger.info("         classType: " + userClass.getClassType());
			logger.info("      creationDate: " + userClass.getCreationDate());
			logger.info("        deleteMode: " + userClass.getDeleteMode());
			logger.info("       description: " + userClass.getDescription());
			logger.info("    expiryAfterPut: " + userClass.getExpiryAfterPut());
			logger.info("   expiryAfterRead: " + userClass.getExpiryAfterRead());
			logger.info("    idStorageClass: " + userClass.getIdStorageClass());
			logger.info("       idUserClass: " + userClass.getIdUserClass());
			logger.info("        updateDate: " + userClass.getUpdateDate());
			logger.info("     userClassCode: " + userClass.getUserClassCode());
		}
	}
}