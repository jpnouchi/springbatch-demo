package com.primeur.bcp.teletransfer.fsr.client.dao;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.primeur.bcp.teletransfer.common.constant.UserConstants;
import com.primeur.bcp.teletransfer.common.model.User;
import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;

/**
 * FSR UserDao test class
 * 
 * @author David Reyes
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest extends AbstractTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertUserTest() throws Exception {	
		
		User user = new User();
		
		user.setUserName("X0000001");
		user.setFirstName("David");
		user.setLastName("Reyes");
		user.setCompanyCode("X00001");
		user.setUserMail("david.reyes@primeur.com");
		user.setLogonTries(0);
		user.setUserType(UserConstants.TELETRANSFER_CLIENT_USER_TYPE);
		user.setStatus('A');
		user.setGenerateMail(false);
		user.setGenerateReport(false);
		user.setMainUser(false);
		
		UserDao.insertUser(user);
		
		user = new User();
		
		user.setUserName("X0000002");
		user.setFirstName("David");
		user.setLastName("Reyes");
		user.setCompanyCode("X00002");
		user.setUserMail("david.reyes@primeur.com");
		user.setLogonTries(0);
		user.setUserType(UserConstants.TTMATIC_USER_TYPE);
		user.setStatus('A');
		user.setGenerateMail(false);
		user.setGenerateReport(false);
		user.setMainUser(false);
		
		UserDao.insertUser(user);
		
		user = new User();
		
		user.setUserName("X0000003");
		user.setFirstName("David");
		user.setLastName("Reyes");
		user.setCompanyCode("X00003");
		user.setUserMail("david.reyes@primeur.com");
		user.setLogonTries(0);
		user.setUserType(UserConstants.SFTP_USER_TYPE);
		user.setStatus('A');
		user.setGenerateMail(false);
		user.setGenerateReport(false);
		user.setMainUser(false);
		
		UserDao.insertUser(user);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertUsersTest() throws Exception {	
		
		for (int i = 1000; i < 4000; i++) {
		
			User user = new User();
			
			user.setUserName("X000" + i);
			user.setFirstName("First name");
			user.setLastName("Last name");
			user.setCompanyCode("X0" + i);
			user.setUserMail("User mail");
	//		user.setUserFunction("User function");
			user.setLogonTries(0);
			user.setUserType('0');
			user.setStatus('A');
	//		user.setCreateDate(new Date());
	//		user.setUpdateDate(new Date());
			user.setGenerateMail(true);
			user.setGenerateReport(true);
			user.setMainUser(true);
			
			UserDao.insertUser(user);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test002_updateUserTest() throws Exception {

		User user = new User();
		
		user.setUserName("junittst");
		user.setFirstName("First name updated");
		user.setLastName("Last name");
		user.setCompanyCode("T33102");
		user.setUserMail("User mail");
//		user.setUserFunction("User function");
		user.setLogonTries(0);
		user.setUserType('0');
		user.setStatus('A');
//		user.setCreateDate(new Date());
//		user.setUpdateDate(new Date());
		user.setGenerateMail(true);
		user.setGenerateReport(true);
		user.setMainUser(false);
		
		UserDao.updateUser(user);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test003_getUserListTest() throws Exception {

		UserDao.getUserList(UserDao.METADATANAME_USER_NAME + "='junittst'");
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_deleteUserTest() throws Exception {

		UserDao.deleteUser("MAILTC04");
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_deleteUsersTest() throws Exception {
		
		for (int i = 1000; i < 4000; i++) {
			
			UserDao.deleteUser("X000" + i);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test005_getUserListCountTest() throws Exception {
		
		String whereClause = UserDao.METADATANAME_STATUS + " = 'A'";

		UserDao.getUserListCount(whereClause);
	}
}
