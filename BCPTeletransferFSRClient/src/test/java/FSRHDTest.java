import java.sql.Timestamp;

import org.junit.Test;

import com.primeur.bcp.teletransfer.fsr.client.abstracts.AbstractTest;
import com.primeur.spmfts.filebox.domain.DistinctMetadataSetList;
import com.primeur.spmfts.filebox.domain.FilesetList;
import com.primeur.spmfts.filebox.domain.MetadataClass;
import com.primeur.spmfts.filebox.exception.FileboxClientException;
import com.primeur.spmfts.filebox.toolkit.exception.FileboxToolkitException;

public class FSRHDTest extends AbstractTest {

	private static final String FTEE_FILE_ACTIVITIES_VIEW = "FTEE_FILE_ACTIVITIES_VIEW";
	
	// ... and its METADATANAMEs
	public static final String METADATANAME_CONTENT_ID						= "CONTENT_ID";						// VARCHAR()
	//public static final String METADATANAME_ID_FILESET					= "ID_FILESET";						// VARCHAR()
	public static final String METADATANAME_FILE_NAME						= "FILE_NAME";						// VARCHAR()
	public static final String METADATANAME_ACTION_TS          				= "ACTION_TS";						// TIMESTAMP()
	public static final String METADATANAME_ACTIVITY_ID		          		= "ID_FILE_ACTIVITY";				// VARCHAR()
	public static final String METADATANAME_ACTIVITY_NAME          			= "ACTIVITY_NAME";					// VARCHAR()
	public static final String METADATANAME_ACTIVITY_STATUS          		= "ACTIVITY_STATUS";				// VARCHAR()
	public static final String METADATANAME_VERSUS          				= "VERSUS";							// VARCHAR()
	public static final String METADATANAME_USERNAME          				= "USERNAME";						// VARCHAR()
	
    @Test
    public void testListFilesetByClassWhere() throws FileboxClientException, FileboxToolkitException{
    	
    	System.out.println("Fileset by classname with WHERE condition");

        Timestamp start = null;
        Timestamp end = null;

        // MetadataClass metadataClass =
        // MetadataClass.getMetadataClass(FTEE_FILE_ACTIVITIES_VIEW);
        MetadataClass metadataClass = new MetadataClass();
        metadataClass.setClassName(FTEE_FILE_ACTIVITIES_VIEW);
        
        String whereClause = "((ACTIVITY_NAME = 'consolidation' AND VERSUS = 'OUTPUT') OR (ACTIVITY_NAME = 'distribution' AND VERSUS = 'INPUT') OR (ACTIVITY_NAME like '%put' AND VERSUS = 'OUTPUT') OR (VERSUS = 'OUTPUT' AND FILE_NAME LIKE '%/C.%.OUT/%')) AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') >= TO_DATE('26/03/2015','dd/MM/yyyy') AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') <= TO_DATE('26/03/2015','dd/MM/yyyy')";
		String orderByClause = "CONTENT_ID DESC";
        
        start = new Timestamp(System.currentTimeMillis());
        int numRec = FilesetList.countRecordByClass(FTEE_FILE_ACTIVITIES_VIEW, "1 = 1");
        end = new Timestamp(System.currentTimeMillis());     
                
        System.out.println("Number of records in Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + ": " + numRec);
        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));

        start = new Timestamp(System.currentTimeMillis());
        numRec = FilesetList.countRecordByClass(FTEE_FILE_ACTIVITIES_VIEW, whereClause);
        end = new Timestamp(System.currentTimeMillis());     
        
        System.out.println("Number of records in Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + " with query: " + numRec);
        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));

        start = new Timestamp(System.currentTimeMillis());
        FilesetList filesetList = new FilesetList(metadataClass, whereClause, orderByClause, 0, 10, false, true);
        end = new Timestamp(System.currentTimeMillis());     
        
        System.out.println("Get firt 10 records Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + " with query: ");
        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));

        start = new Timestamp(System.currentTimeMillis());
        filesetList = new FilesetList(metadataClass, whereClause, orderByClause, 1000, 10, false, true);
        end = new Timestamp(System.currentTimeMillis());     
        
        System.out.println("Get 10 after 1000 records Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + " with query: ");
        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));

//		for (Fileset fileset : filesetList) {
//      	System.out.println("Fileset    id: " + fileset.getIdFileset());
//          System.out.println("        descr: " + fileset.getDescription());
//          printAllMetadataSets(fileset.getMetadataSetList());
//		}
    }
    
    @Test
    public void testListDistinctFilesetByClassWhere() {
    	
    	try {
    	
	    	String[] fields = {METADATANAME_CONTENT_ID, METADATANAME_ACTIVITY_ID, METADATANAME_FILE_NAME};
	    	
	    	System.out.println("Fileset by classname with WHERE condition");
	
	        Timestamp start = null;
	        Timestamp end = null;
	
	        // MetadataClass metadataClass =
	        // MetadataClass.getMetadataClass(FTEE_FILE_ACTIVITIES_VIEW);
	//        MetadataClass metadataClass = new MetadataClass();
	//        metadataClass.setClassName(FTEE_FILE_ACTIVITIES_VIEW);
	        
	        String whereClause = "((ACTIVITY_NAME = 'consolidation' AND VERSUS = 'OUTPUT') OR (ACTIVITY_NAME = 'distribution' AND VERSUS = 'INPUT') OR (ACTIVITY_NAME like '%put' AND VERSUS = 'OUTPUT') OR (VERSUS = 'OUTPUT' AND FILE_NAME LIKE '%/C.%.OUT/%')) AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') >= TO_DATE('26/03/2015','dd/MM/yyyy') AND TO_DATE(VARCHAR_FORMAT(ACTION_TS,'dd/MM/yyyy'), 'dd/MM/yyyy') <= TO_DATE('26/03/2015','dd/MM/yyyy')";
			String orderByClause = "CONTENT_ID DESC";
			
			System.out.println("");
	        start = new Timestamp(System.currentTimeMillis());
	        int numRec = DistinctMetadataSetList.countRecordBcountDistinctRecordByClass(FTEE_FILE_ACTIVITIES_VIEW, fields, "1 = 1");
	        end = new Timestamp(System.currentTimeMillis());     
	                
	        System.out.println("Number of records in Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + ": " + numRec);
	        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));
	
	        System.out.println("");
	        start = new Timestamp(System.currentTimeMillis());
	        numRec = DistinctMetadataSetList.countRecordBcountDistinctRecordByClass(FTEE_FILE_ACTIVITIES_VIEW, fields, whereClause);
	        end = new Timestamp(System.currentTimeMillis());     
	        
	        System.out.println("Number of records in Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + " with query: " + numRec);
	        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));
	
	        System.out.println("");
	        start = new Timestamp(System.currentTimeMillis());
	        DistinctMetadataSetList filesetList = new DistinctMetadataSetList(FTEE_FILE_ACTIVITIES_VIEW, fields, whereClause, orderByClause, 0, 10);
	        end = new Timestamp(System.currentTimeMillis());     
	        
	        System.out.println("Get firt 10 records Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + " with query: ");
	        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));
	
	        System.out.println("");
	        System.out.println("Get 10 after 999 records Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + " with query: ");	
	        start = new Timestamp(System.currentTimeMillis());
	        filesetList = new DistinctMetadataSetList(FTEE_FILE_ACTIVITIES_VIEW, fields, whereClause, orderByClause, 999, 10);
	        end = new Timestamp(System.currentTimeMillis());     
	        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));
	        
	        System.out.println("");
	        System.out.println("Get 10 after 1000 records Metadata Class " + FTEE_FILE_ACTIVITIES_VIEW + " with query: ");	
	        start = new Timestamp(System.currentTimeMillis());
	        filesetList = new DistinctMetadataSetList(FTEE_FILE_ACTIVITIES_VIEW, fields, whereClause, orderByClause, 1000, 10);
	        end = new Timestamp(System.currentTimeMillis());     
	        System.out.println("Start: " + start.toString() + " End: " + end.toString() + " Diff (sec): " + ((end.getTime() - start.getTime()) / 1000));
	
	//		for (Fileset fileset : filesetList) {
	//      	System.out.println("Fileset    id: " + fileset.getIdFileset());
	//          System.out.println("        descr: " + fileset.getDescription());
	//          printAllMetadataSets(fileset.getMetadataSetList());
	//		}
	        
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}
    }
}
