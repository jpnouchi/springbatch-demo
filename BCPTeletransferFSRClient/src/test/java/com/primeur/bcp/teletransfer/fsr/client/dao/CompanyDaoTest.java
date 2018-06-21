package com.primeur.bcp.teletransfer.fsr.client.dao;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.primeur.bcp.teletransfer.common.constant.CompanyConstants;
import com.primeur.bcp.teletransfer.common.model.Company;
import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;

/**
 * FSR CompanyDao test class
 * 
 * @author David Reyes
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyDaoTest extends AbstractTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertCompanyTest() throws Exception {

		Company company = new Company();
		
		company.setCompanyCode("X00001");
		company.setCompanyName("X00001");
		company.setDescription("Synch Test");
		company.setCompanyAddress("Address");
		company.setCountry("Country");
		company.setOfficeHours("Office Hours");
		company.setTelephone("Telephone");
		company.setFax("Fax");
		company.setResponsible("Responsible");
		company.setResponsibleEmail("primeur@primeur.com");
		company.setTechnicalResponsible("Technical Responsible");
		company.setTechnicalResponsibleEmail("primeur@primeur.com");
		company.setDocType("A");
		company.setDocValue("Doc Value");
		company.setProvince("Province");
		company.setDistrict("District");
		company.setDepartment("Department");
		company.setOutQueueName("C.X00001.OUT");
		company.setInQueueName("C.X00001.IN");
		company.setLastInstallDate(new Date());
		company.setAffiliationDate(new Date());
		company.setDisaffiliationDate(new Date());
		company.setUseFrequency("Use Frequency");
		company.setAverageSentVol("Average sent vol");
		company.setStatus('A');
		company.setCreateDate(new Date());
		company.setUpdateDate(new Date());
		company.setContingency(true);
		company.setActivationDate(new Date());
		company.setClientType(CompanyConstants.TELETRANSFER_CLIENT_CLIENT_TYPE);
		
		CompanyDao.insertCompany(company);
		
		company = new Company();
		
		company.setCompanyCode("X00002");
		company.setCompanyName("X00002");
		company.setDescription("Synch Test");
		company.setCompanyAddress("Address");
		company.setCountry("Country");
		company.setOfficeHours("Office Hours");
		company.setTelephone("Telephone");
		company.setFax("Fax");
		company.setResponsible("Responsible");
		company.setResponsibleEmail("primeur@primeur.com");
		company.setTechnicalResponsible("Technical Responsible");
		company.setTechnicalResponsibleEmail("primeur@primeur.com");
		company.setDocType("A");
		company.setDocValue("Doc Value");
		company.setProvince("Province");
		company.setDistrict("District");
		company.setDepartment("Department");
		company.setOutQueueName("C.X00002.OUT");
		company.setInQueueName("C.X00002.IN");
		company.setLastInstallDate(new Date());
		company.setAffiliationDate(new Date());
		company.setDisaffiliationDate(new Date());
		company.setUseFrequency("Use Frequency");
		company.setAverageSentVol("Average sent vol");
		company.setStatus('A');
		company.setCreateDate(new Date());
		company.setUpdateDate(new Date());
		company.setContingency(true);
		company.setActivationDate(new Date());
		company.setClientType(CompanyConstants.TTMATIC_CLIENT_TYPE);
		
		CompanyDao.insertCompany(company);
		
		company = new Company();
		
		company.setCompanyCode("X00003");
		company.setCompanyName("X00003");
		company.setDescription("Synch Test");
		company.setCompanyAddress("Address");
		company.setCountry("Country");
		company.setOfficeHours("Office Hours");
		company.setTelephone("Telephone");
		company.setFax("Fax");
		company.setResponsible("Responsible");
		company.setResponsibleEmail("primeur@primeur.com");
		company.setTechnicalResponsible("Technical Responsible");
		company.setTechnicalResponsibleEmail("primeur@primeur.com");
		company.setDocType("A");
		company.setDocValue("Doc Value");
		company.setProvince("Province");
		company.setDistrict("District");
		company.setDepartment("Department");
		company.setOutQueueName("C.X00003.OUT");
		company.setInQueueName("C.X00003.IN");
		company.setLastInstallDate(new Date());
		company.setAffiliationDate(new Date());
		company.setDisaffiliationDate(new Date());
		company.setUseFrequency("Use Frequency");
		company.setAverageSentVol("Average sent vol");
		company.setStatus('A');
		company.setCreateDate(new Date());
		company.setUpdateDate(new Date());
		company.setContingency(true);
		company.setActivationDate(new Date());
		company.setClientType(CompanyConstants.SFTP_CLIENT_TYPE);
		
		CompanyDao.insertCompany(company);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test001_insertCompaniesTest() throws Exception {

		for (int i = 1000; i < 4000; i++) {
			
			Company company = new Company();
			
			company.setCompanyCode("X0" + i);
			company.setCompanyName("COMPANY NAME");
			company.setDescription("Company description");
			company.setCompanyAddress("Address");
			company.setCountry("Country");
			company.setOfficeHours("Office Hours");
			company.setTelephone("Telephone");
			company.setFax("Fax");
			company.setResponsible("Responsible");
			company.setResponsibleEmail("primeur@primeur.com");
			company.setTechnicalResponsible("Technical Responsible");
			company.setTechnicalResponsibleEmail("primeur@primeur.com");
			company.setDocType("Doc Type");
			company.setDocValue("Doc Value");
			company.setProvince("Province");
			company.setDistrict("District");
			company.setDepartment("Department");
			company.setOutQueueName("Out queue name");
			company.setInQueueName("In queue name");
			company.setLastInstallDate(new Date());
			company.setAffiliationDate(new Date());
			company.setDisaffiliationDate(new Date());
			company.setUseFrequency("Use Frequency");
			company.setAverageSentVol("Average sent vol");
			company.setStatus('A');
			company.setCreateDate(new Date());
			company.setUpdateDate(new Date());
			company.setContingency(true);
			company.setActivationDate(null);
			company.setClientType('0');
			
			CompanyDao.insertCompany(company);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test002_updateCompanyTest() throws Exception {

		Company company = new Company();
		
		company.setCompanyCode("X00003");
		company.setCompanyName("X00003");
		company.setDescription("Synch Test");
		company.setCompanyAddress("Address");
		company.setCountry("Country");
		company.setOfficeHours("Office Hours");
		company.setTelephone("Telephone");
		company.setFax("Fax");
		company.setResponsible("Responsible");
		company.setResponsibleEmail("primeur@primeur.com");
		company.setTechnicalResponsible("Technical Responsible");
		company.setTechnicalResponsibleEmail("primeur@primeur.com");
		company.setDocType("A");
		company.setDocValue("Doc Value");
		company.setProvince("Province");
		company.setDistrict("District");
		company.setDepartment("Department");
		company.setOutQueueName("C.X00003.OUT");
		company.setInQueueName("C.X00003.IN");
		company.setLastInstallDate(new Date());
		company.setAffiliationDate(new Date());
		company.setDisaffiliationDate(new Date());
		company.setUseFrequency("Use Frequency");
		company.setAverageSentVol("Average sent vol");
		company.setStatus('A');
		company.setCreateDate(new Date());
		company.setUpdateDate(new Date());
		company.setContingency(true);
		company.setActivationDate(new Date());
		company.setClientType(CompanyConstants.SFTP_CLIENT_TYPE);
		
		CompanyDao.updateCompany(company);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test003_getCompanyListTest() throws Exception {

//		String whereClause = "COMPANY_CODE IS NOT NULL";
//		String orderByClause = "COMPANY_CODE ASC";
		
		String whereClause = "TO_DATE(VARCHAR_FORMAT(CREATE_DATE,'dd/MM/yyyy'), 'dd/MM/yyyy') >= TO_DATE('20/02/2014','dd/MM/yyyy') AND TO_DATE(VARCHAR_FORMAT(CREATE_DATE,'dd/MM/yyyy'), 'dd/MM/yyyy') <= TO_DATE('20/02/2014','dd/MM/yyyy')";
		String orderByClause = "COMPANY_CODE ASC";
		
		CompanyDao.getCompanyList(whereClause, orderByClause, 0, 10);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_deleteCompanyTest() throws Exception {

		CompanyDao.deleteCompany("TSQQ02");
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test004_deleteCompaniesTest() throws Exception {
		
		for (int i = 1000; i < 4000; i++) {

			CompanyDao.deleteCompany("X_" + i);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void test005_getCompanyListCountTest() throws Exception {
		
		String whereClause = CompanyDao.METADATANAME_STATUS + " = 'A'";

		CompanyDao.getCompanyListCount(whereClause);
	}
}
