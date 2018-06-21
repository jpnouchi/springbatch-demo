package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.primeur.bcp.teletransfer.common.model.SystemProperty;
import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;

/**
 * FSR SystemPropertyDao test class
 * 
 * @author David Reyes
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemPropertyDaoTest extends AbstractTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertSystemPropertyTest() throws Exception {	
		
		SystemProperty systemProperty = new SystemProperty();
		
		systemProperty.setParameter("Parameter");
		systemProperty.setValue("Value");
		systemProperty.setDescription("Description");
		systemProperty.setApplication('A');
		systemProperty.setStatus('S');
		systemProperty.setCreateDate(new Date());
		systemProperty.setUpdateDate(new Date());
		
		SystemPropertyDao.insertSystemProperty(systemProperty);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test002_updateSystemPropertyTest() throws Exception {

		SystemProperty systemProperty = new SystemProperty();
		
		systemProperty.setParameter("Parameter");
		systemProperty.setValue("Value");
		systemProperty.setDescription("Description");
		systemProperty.setApplication('A');
		systemProperty.setStatus('S');
		systemProperty.setCreateDate(new Date());
		systemProperty.setUpdateDate(new Date());
		
		SystemPropertyDao.updateSystemProperty(systemProperty);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test003_getSystemPropertyListTest() throws Exception {

		SystemPropertyDao.getSystemPropertyList();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_deleteSystemPropertyTest() throws Exception {

		SystemPropertyDao.deleteSystemProperty("Parameter");
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test005_getSystemProperyListCountTest() throws Exception {
		
		String whereClause = "";

		SystemPropertyDao.getSystemPropertyListCount(whereClause);
	}
}
