package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.model.User;
import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.bcp.teletransfer.fsr.client.constant.FSRClientConstants;
import com.primeur.bcp.teletransfer.fsr.client.constant.LoggerMessages;
import com.primeur.bcp.teletransfer.fsr.client.util.FSRClientUtil;
import com.primeur.spmfts.filebox.domain.Fileset;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.domain.MetadataSet;

/**
 * Class used to access SPFB_BCP_USERS_MD
 * 
 * @author David Reyes
 *
 */
public class UserDao {

	/**
	 * Class logger
	 */
	private static final Logger logger = Logger.getLogger(UserDao.class);
	
	/////////////////////////////////////////
	/// Definitions for SPFB_BCP_USERS_MD ///
	/////////////////////////////////////////
	
	// The METADATACLASS ...
	private static final String METADATACLASS_BCP_USERS   = "SPFB_BCP_USERS_MD";
	
	// ... and its METADATANAMEs
	public static final String METADATANAME_USER_NAME			= "USER_NAME";			// VARCHAR(10)
	public static final String METADATANAME_FIRST_NAME			= "FIRST_NAME";			// VARCHAR(50)
	public static final String METADATANAME_LAST_NAME			= "LAST_NAME";			// VARCHAR(50)
	public static final String METADATANAME_COMPANY_CODE		= "COMPANY_CODE";		// VARCHAR(10)
	public static final String METADATANAME_USER_EMAIL			= "USER_EMAIL";			// VARCHAR(128)
//	public static final String METADATANAME_USER_FUNCTION		= "USER_FUNCTION";		// VARCHAR(256)
	public static final String METADATANAME_LOGON_TRIES			= "LOGON_TRIES";		// INTEGER
	public static final String METADATANAME_USER_TYPE          	= "USER_TYPE";			// VARCHAR(1)
	public static final String METADATANAME_STATUS             	= "STATUS";				// VARCHAR(1)
	public static final String METADATANAME_CREATE_DATE			= "CREATE_DATE";		// TIMESTAMP
	public static final String METADATANAME_UPDATE_DATE			= "UPDATE_DATE";		// TIMESTAMP
	public static final String METADATANAME_GENERATE_MAIL		= "GENERATE_MAIL";		// SMALLINT
	public static final String METADATANAME_GENERATE_REPORT		= "GENERATE_REPORT";	// SMALLINT
	public static final String METADATANAME_MAIN_USER			= "MAIN_USER";			// SMALLINT
	
	// Logger dataType constant
	private static final String DATA_TYPE = FSRClientConstants.USER;
	
	/**
	 * Inserts an user record into FSR database
	 * 
	 * @param user user to insert
	 * @throws Exception
	 */
	public synchronized static User insertUser(User user) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_INSERT;
		
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, user.getUserName()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		Date actualDate = new Date();
		user.setCreateDate(actualDate);
		user.setUpdateDate(actualDate);
		
		Fileset userFileset = new Fileset();
		userFileset.setIdUserClass(FSRClientConstants.FSR_REMOTE_DB_BCP_ID_USER_CLASS);
		MetadataSet userMetadataSet = new MetadataSet();
		userMetadataSet.setMetadataClass(METADATACLASS_BCP_USERS);
		
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USER_NAME, user.getUserName()));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_FIRST_NAME, user.getFirstName()));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_LAST_NAME, user.getLastName()));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_COMPANY_CODE, user.getCompanyCode()));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USER_EMAIL, user.getUserMail()));
//		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USER_FUNCTION, user.getUserFunction()));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_LOGON_TRIES, user.getLogonTries()));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_USER_TYPE, user.getUserType()));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_STATUS, user.getStatus()));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_CREATE_DATE, user.getCreateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_UPDATE_DATE, user.getUpdateDate(), FSRClientConstants.FSR_DB_DATE_FORMAT));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_GENERATE_MAIL, ParseUtil.booleanToInteger(user.getGenerateMail())));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_GENERATE_REPORT, ParseUtil.booleanToInteger(user.getGenerateReport())));
		userMetadataSet.addMetadataValue(FSRClientUtil.createMetadataValue(METADATANAME_MAIN_USER, ParseUtil.booleanToInteger(user.getMainUser())));
		
		userFileset.addMetadataSet(userMetadataSet);
		
		// following instruction persists data into remote db
		userFileset.save();
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, user.getUserName()));
	
		return user;
	}
	
	/**
	 * Updates an user record stored in FSR database
	 * 
	 * @param user user to update
	 * @throws Exception
	 */
	public synchronized static User updateUser(User user) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_UPDATE;
		
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, user.getUserName()));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		user.setUpdateDate(new Date());
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_USERS);
		
		FilesetList userFilesetList = new FilesetList(metadataClass, " " + METADATANAME_USER_NAME + "='" + user.getUserName() + "'", 0, 0, false, true);
		
		for (Fileset userFileset : userFilesetList) {
			
			MetadataSet userMetadataSet = userFileset.getMetadataSet(METADATACLASS_BCP_USERS);
			
			userMetadataSet.getMetadataValue(METADATANAME_FIRST_NAME).setValue(user.getFirstName());
			userMetadataSet.getMetadataValue(METADATANAME_LAST_NAME).setValue(user.getLastName());
			userMetadataSet.getMetadataValue(METADATANAME_COMPANY_CODE).setValue(user.getCompanyCode());
			userMetadataSet.getMetadataValue(METADATANAME_USER_EMAIL).setValue(user.getUserMail());
//			userMetadataSet.getMetadataValue(METADATANAME_USER_FUNCTION).setValue(user.getUserFunction());		
			userMetadataSet.getMetadataValue(METADATANAME_LOGON_TRIES).setValue(user.getLogonTries());
			userMetadataSet.getMetadataValue(METADATANAME_USER_TYPE).setValue(user.getUserType());
			userMetadataSet.getMetadataValue(METADATANAME_STATUS).setValue(user.getStatus());	
//			userMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).setValue(ParseUtil.dateToString(user.getCreateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			userMetadataSet.getMetadataValue(METADATANAME_UPDATE_DATE).setValue(ParseUtil.dateToString(user.getUpdateDate(),FSRClientConstants.FSR_DB_DATE_FORMAT));
			userMetadataSet.getMetadataValue(METADATANAME_GENERATE_MAIL).setValue(ParseUtil.booleanToInteger(user.getGenerateMail()));
			userMetadataSet.getMetadataValue(METADATANAME_GENERATE_REPORT).setValue(ParseUtil.booleanToInteger(user.getGenerateReport()));
			userMetadataSet.getMetadataValue(METADATANAME_MAIN_USER).setValue(ParseUtil.booleanToInteger(user.getMainUser()));
			
			// following instruction persists data into remote db
			userFileset.save();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, user.getUserName()));
		logger.debug(String.format(LoggerMessages.ROWS_UPDATED_FORMAT, userFilesetList.size()));
	
		return user;
	}
	
	/**
	 * Deletes an user record stored in FSR database
	 * 
	 * @param userName userName of the user to delete
	 * @throws Exception
	 */
	public synchronized static void deleteUser(String userName) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_DELETE;
		
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, userName));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_USERS);
		
		FilesetList userFilesetList = new FilesetList(metadataClass, " " + METADATANAME_USER_NAME + "='" + userName + "'", 0, 0, false, true);
		
		String presenceString;
		
		switch (userFilesetList.size()) {
		
			case 0:
				presenceString = LoggerMessages.NOT_FOUND;
				break;
			case 1:
				presenceString = LoggerMessages.FOUND;
				break;
			default:
				presenceString = String.format(LoggerMessages.ROWS_FOUND_FORMAT, userFilesetList.size());
		}
		
		logger.debug(String.format(LoggerMessages.PRESENCE_PARAM_FORMAT, DATA_TYPE, userName, presenceString));
		
		for (Fileset userFileset : userFilesetList) {
			// following instruction removes data into remote db
			userFileset.delete();
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_PARAM_FORMAT, operation, DATA_TYPE, userName));
		logger.debug(String.format(LoggerMessages.ROWS_DELETED_FORMAT, userFilesetList.size()));
	}
	
	/**
	 * Returns a list with all users.
	 * 
	 * @return user list
	 * @throws Exception
	 */
	@Deprecated
	public synchronized static List<User> getUserList() throws Exception {
		return getUserList(null, null, 0, 0);
	}
	
	/**
	 * Returns a list with all users.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return user list
	 * @throws Exception
	 */
	public synchronized static List<User> getUserList(String whereClause) throws Exception {
		return getUserList(whereClause, null, 0, 0);
	}
	
	/**
	 * Returns an user list. All listed users match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @param orderByClause order by clause for retrieving information from database
	 * @param offset
	 * @param count number of records
	 * @return user list
	 * @throws Exception
	 */
	public synchronized static List<User> getUserList(String whereClause, String orderByClause, int offset, int count) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		List<User> userList = new ArrayList<User>();
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_USERS);
		
		FilesetList userFilesetList;
		
		if (whereClause != null && whereClause.length() > 0) {
			
			if (orderByClause != null && orderByClause.length() > 0) {
				
				userFilesetList = new FilesetList(metadataClass, whereClause, orderByClause, offset, count, false, true);
				
			} else {
				
				userFilesetList = new FilesetList(metadataClass, whereClause, offset, count, false, true);
			}
		
		} else
			userFilesetList = new FilesetList(metadataClass);
		
		for (Fileset userFileset : userFilesetList) {
			
			MetadataSet userMetadataSet = userFileset.getMetadataSet(METADATACLASS_BCP_USERS);
			
			User user = new User();
			
			user = fillUserData(user, userMetadataSet);
			
			userList.add(user);
			
			logger.debug("User: " + user.getUserName() + " - " + user.getFirstName());
		}	
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return userList;
	}
	
	/**
	 * Returns an user.
	 * 
	 * @param userName userName of the user
	 * @return user
	 * @throws Exception
	 */
	public synchronized static User getUser(String userName) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_GET;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_PARAM_FORMAT, operation, DATA_TYPE, userName));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		User user = null;
		
		MetadataClass metadataClass = MetadataClass.getMetadataClass(METADATACLASS_BCP_USERS);
		
		FilesetList userFilesetList = new FilesetList(metadataClass, " " + METADATANAME_USER_NAME + "='" + userName + "'", 0, 0, false, true);
		
		for (Fileset userFileset : userFilesetList) {
			
			user = new User();
			
			MetadataSet userMetadataSet = userFileset.getMetadataSet(METADATACLASS_BCP_USERS);

			user = fillUserData(user, userMetadataSet);
			
			logger.debug("User: " + user.getUserName() + " - " + user.getFirstName());
		}
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return user;
	}
	
	/**
	 * Returns the count of all users that match the whereClause.
	 * 
	 * @param whereClause where clause for retrieving information from database
	 * @return company list count
	 * @throws Exception
	 */
	public synchronized static int getUserListCount(String whereClause) throws Exception {
		
		// Logger operation constant
		String operation = FSRClientConstants.OPERATION_LIST_COUNT;
				
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		logger.debug(String.format(LoggerMessages.EXECUTING_OPERATION_FORMAT, operation, DATA_TYPE));
		logger.debug(LoggerMessages.SEPARATOR_FOR_CALLS);
		
		logger.debug("userListCount whereClause: " + whereClause);
		
		int userListCount = FilesetList.countRecordByClass(METADATACLASS_BCP_USERS, whereClause);
		
		logger.debug("userListCount: " + userListCount);
		
		logger.debug(String.format(LoggerMessages.OPERATION_SUCCESSFUL_FORMAT, operation, DATA_TYPE));
		
		return userListCount;
	}
	
	/**
	 * Fills a user with the data retrieved from a FSR MetadataSet
	 * 
	 * @param user user to be filled
	 * @param userMetadataSet
	 * @return filled user
	 * @throws Exception
	 */
	private synchronized static User fillUserData(User user, MetadataSet userMetadataSet) throws Exception {
		
		user.setUserName(userMetadataSet.getMetadataValue(METADATANAME_USER_NAME).getValue());
		user.setFirstName(userMetadataSet.getMetadataValue(METADATANAME_FIRST_NAME).getValue());
		user.setLastName(userMetadataSet.getMetadataValue(METADATANAME_LAST_NAME).getValue());
		user.setCompanyCode(userMetadataSet.getMetadataValue(METADATANAME_COMPANY_CODE).getValue());
		user.setUserMail(userMetadataSet.getMetadataValue(METADATANAME_USER_EMAIL).getValue());
//		user.setUserFunction(userMetadataSet.getMetadataValue(METADATANAME_USER_FUNCTION).getValue());
		user.setLogonTries(userMetadataSet.getMetadataValue(METADATANAME_LOGON_TRIES).getValueAsInteger());
		user.setUserType(userMetadataSet.getMetadataValue(METADATANAME_USER_TYPE).getValueAsChar());	
		user.setStatus(userMetadataSet.getMetadataValue(METADATANAME_STATUS).getValueAsChar());	
		user.setCreateDate(ParseUtil.stringToDate(userMetadataSet.getMetadataValue(METADATANAME_CREATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		user.setUpdateDate(ParseUtil.stringToDate(userMetadataSet.getMetadataValue(METADATANAME_UPDATE_DATE).getValue(),FSRClientConstants.FSR_DB_DATE_FORMAT));
		user.setGenerateMail(ParseUtil.IntegerToBoolean(userMetadataSet.getMetadataValue(METADATANAME_GENERATE_MAIL).getValueAsInteger()));
		user.setGenerateReport(ParseUtil.IntegerToBoolean(userMetadataSet.getMetadataValue(METADATANAME_GENERATE_REPORT).getValueAsInteger()));
		user.setMainUser(ParseUtil.IntegerToBoolean(userMetadataSet.getMetadataValue(METADATANAME_MAIN_USER).getValueAsInteger()));
		return user;
	}
}
