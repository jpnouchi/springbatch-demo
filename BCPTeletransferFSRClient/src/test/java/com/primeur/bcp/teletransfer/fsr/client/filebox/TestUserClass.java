package com.primeur.bcp.teletransfer.fsr.client.filebox;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;
import com.primeur.spmfts.filebox.domain.UserClass;
import com.primeur.spmfts.filebox.domain.UserClassList;
import com.primeur.spmfts.filebox.exception.FileboxClientException;

public class TestUserClass extends AbstractTest {
	
	private static final Logger logger = Logger.getLogger(TestUserClass.class);
	
	@Test
	@Ignore
	public void testCreateUserClass() throws FileboxClientException{
		
//		UserClass newUserClass = new UserClass();
//		newUserClass.setIdUserClass(idUserClass);
//		newUserClass.setDescription("Test David");
//		newUserClass.setExpiryAfterPut(FSRClientConstants.FSR_AUDIT_USER_CLASS_EXPIRY_SECONDS);
//		newUserClass.save();
		
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
	
	@Test
	@Ignore
	public void testGetUserClass() throws FileboxClientException{
		
		UserClass userClass = UserClass.getUserClass(1);
		
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