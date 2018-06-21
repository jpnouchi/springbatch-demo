package com.primeur.bcp.teletransfer.fsr.client.filebox;

import org.junit.Ignore;
import org.junit.Test;

import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;
import com.primeur.spmfts.filebox.domain.DistinctMetadataSetList;
import com.primeur.spmfts.filebox.domain.MetadataSet;
import com.primeur.spmfts.filebox.domain.MetadataValue;
import com.primeur.spmfts.filebox.exception.FileboxClientException;
import com.primeur.spmfts.filebox.toolkit.exception.FileboxToolkitException;

public class TestDistinctQuery extends AbstractTest {
	
	@Test
	@Ignore
	public void testDisctinctQuery() throws FileboxClientException, FileboxToolkitException {
		String mdClass = "FTEE_FILE_ACTIVITIES_VIEW";
		String[] fields = {"CONTENT_ID", "ID_FILE_ACTIVITY", "FILE_NAME", "ACTIVITY_NAME"};
//		String query = "CONTENT_ID IS NOT NULL";
		String query = "((ACTIVITY_NAME = 'consolidation' AND VERSUS = 'OUTPUT') OR (ACTIVITY_NAME = 'distribution' AND VERSUS = 'INPUT') OR (VERSUS = 'OUTPUT' AND FILE_NAME LIKE '%/C.%.OUT/%')) AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') >= TO_DATE('27/05/2014','dd/MM/yyyy') AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') <= TO_DATE('27/05/2014','dd/MM/yyyy')";
		String orderBy = "FILE_NAME DESC";
		
		System.out.println("----------------------------------------------------------------------------------------------------------");

		int count = DistinctMetadataSetList.countRecordBcountDistinctRecordByClass(mdClass, fields, query);
		
		System.out.println("Distinct record in query: " + count);
		System.out.println("----------------------------------------------------------------------------------------------------------");		
				
		System.out.println("----------------------------------------------------------------------------------------------------------");

		DistinctMetadataSetList result = new DistinctMetadataSetList(mdClass, fields, 10, 20);
		printQueryResult(result);
		
		System.out.println("----------------------------------------------------------------------------------------------------------");

		result = new DistinctMetadataSetList(mdClass, fields, query, 10, 20);
		printQueryResult(result);
		
		System.out.println("----------------------------------------------------------------------------------------------------------");

		result = new DistinctMetadataSetList(mdClass, fields, query, orderBy, 10, 20);
		printQueryResult(result);
	}
	
	private void printQueryResult(DistinctMetadataSetList result) {
		for (MetadataSet mds : result) {
			System.out.println("Row for Metadata Class: " + mds.getMetadataClass());
			
			for (MetadataValue mdv : mds.getMetadataValueList()) {
				System.out.println("Metadat: " + mdv.getMetadataName() + " Value: " + mdv.getValue());
			}
		}
	}
}
