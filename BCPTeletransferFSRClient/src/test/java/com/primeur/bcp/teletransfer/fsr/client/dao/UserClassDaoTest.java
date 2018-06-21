package com.primeur.bcp.teletransfer.fsr.client.dao;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;
import com.primeur.spmfts.filebox.domain.UserClass;
import com.primeur.spmfts.filebox.domain.UserClassList;

public class UserClassDaoTest extends AbstractTest {
	
	private static final Logger logger = Logger.getLogger(UserClassDaoTest.class);
	
	@Test
	@Ignore
	public void test001_userClassTest() throws Exception {

		UserClassList userClassList = new UserClassList();
		
		for (UserClass userClass : userClassList) {
			
			logger.info("IdUserClass:" + userClass.getIdUserClass());
	
			if (userClass.getIdUserClass() == 8) {
				
				//15120000
				logger.info("	getExpiryAfterPut Before:" + userClass.getExpiryAfterPut());
				userClass.setExpiryAfterPut(30);
				userClass.save();
				logger.info("	getExpiryAfterPut After:" + userClass.getExpiryAfterPut());	
			}
		}	
	}
}
