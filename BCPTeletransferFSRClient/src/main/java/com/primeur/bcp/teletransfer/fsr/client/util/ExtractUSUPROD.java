package com.primeur.bcp.teletransfer.fsr.client.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.primeur.bcp.teletransfer.common.constant.BCPTTCommonLoggerMessages;
import com.primeur.bcp.teletransfer.common.model.CompanyProduct;
import com.primeur.bcp.teletransfer.fsr.client.BCPTeletransferFSRClient;
import com.primeur.bcp.teletransfer.fsr.client.dao.CompanyProductDao;

public class ExtractUSUPROD {
	
	private static Properties prop;
	
	private static Logger logger= Logger.getLogger(ExtractUSUPROD.class);
	
	public static void main(String[] args) {
		ExtractUSUPROD.extractionUSUPROD();
	}
	
	public static void extractionUSUPROD() {
		
		String propiedades = "extractUsuProd.properties";
		
		String connection="";
		String file="";
	
		org.apache.log4j.xml.DOMConfigurator.configure("../config/log4jBCP.xml");
		
		try{
            prop = obtenerArchivoPropiedades(propiedades);
            file = prop.getProperty("path_output");
            connection = prop.getProperty("FSR_connection");
        }catch (FileNotFoundException e){
            logger.error("ERROR: No existe el fichero "+propiedades);
            System.exit(1);
        }
        catch(IOException e){
            logger.error("ERROR: Fallo al recuperar los datos del fichero "+propiedades);
            System.exit(1);
        }
		
		//1.- Connection with FSR
		logger.info (BCPTTCommonLoggerMessages.USUPROD_CONN_ATTEMPT);
		BCPTeletransferFSRClient.setEndPoint(connection);
		logger.info (BCPTTCommonLoggerMessages.USUPROD_CONN_SUCCESS);
		
		//2.- Get UsuProd File 
		logger.info(BCPTTCommonLoggerMessages.USUPROD_EXTRACT_ATTEMPT);
		try {
			//2.1- Get the information from the FSR 
			String companyProductWhereClause = CompanyProductDao.METADATANAME_USU_PROD_CODE + " IS NOT NULL";
			String companyProductOrderByClause = CompanyProductDao.METADATANAME_USU_PROD_CODE + " ASC";
			List<CompanyProduct> CompanyProductList = CompanyProductDao.getCompanyProductList(companyProductWhereClause, companyProductOrderByClause, 0, 0);
			String usuprodText = "";
		
			//2.2.- Delete the file if exist, and create it again
			deleteFile(file);
			existFile (file);
			
			//2.3.- Put the information into "file"
			for (CompanyProduct companyProduct : CompanyProductList) {
				usuprodText = usuprodText + companyProduct.getCompanyCode() + companyProduct.getProductCode() + companyProduct.getUsuProdCode() + "\n";
			}
			writeLine(file, usuprodText);
			logger.info(BCPTTCommonLoggerMessages.USUPROD_WRITING_SUCCESS);
		}
		catch (Exception e) {
			logger.error(BCPTTCommonLoggerMessages.USUPROD_EXTRACT_ERROR);
		}
}

	/**
	 * Function that append a line to a file
	 * @param fich FILE
	 * @param linea LINE
	 */
	static private void writeLine (String fich, String linea)
    {   
    	FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {   fichero = new FileWriter(fich, true);
            pw = new PrintWriter(fichero);
            pw.println(linea);}
        catch (Exception e){
        	logger.error(BCPTTCommonLoggerMessages.USUPROD_WRITING_ERROR);
        }
        finally {
           try {
        	   if (null != fichero)
        		   fichero.close();
           }catch (Exception e2){
        	   logger.error(BCPTTCommonLoggerMessages.USUPROD_CLOSING_ERROR);
           }
        }
    }
	
	/**
     * Function that verifies if a File exist, and if not, it will be created
     * @param fichero File to verify
     */
    static private void existFile (String fichero){
    	File output = new File(fichero);
    	if (!output.exists()){
    		try{output.createNewFile();}
    	   	catch (Exception e){
    	   		logger.error(BCPTTCommonLoggerMessages.USUPROD_CREATE_ERROR);
    	   	}
    	}
    }
    
    /**
     * Function that search the properties file at the executable directory
     * @param arc Name of the file
     * @return Properties
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static Properties obtenerArchivoPropiedades(String arc) throws FileNotFoundException , IOException{
        Properties prop = null;
        try {
        	String aux = System.getProperty("user.dir");
        	File jarDir = new File (aux+"/../"+arc);
            prop= new Properties();
            prop.load(new BufferedReader(new FileReader(jarDir)));
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("ERROR: No se encontro el fichero de propiedades"+arc);
        } catch (Exception ex) {
            throw new IOException("ERROR: No se ha podido leer el fichero de propiedades "+arc);
        }
        return prop;
    }
    
    /**
     * Function that verifies if a directory exist, and if not, it will be created
     * @param ruta Directory to verify
     */
    public static void existDirectory (String ruta){
    	File arch = new File (ruta);
    	if (!arch.exists())
    		arch.mkdir();
    	}
    
    /**
     * Function that delete a File
     * @param ruta Directory path
     * @param nombre File name
     * @return
     */
    static public int deleteFile (String ruta){
    	String cmd []={"rm",ruta};
    	Process p;
    	try {
    		p = Runtime.getRuntime().exec(cmd);
    		p.waitFor();
    	} catch (Exception e) {
    		return 1;
    	}
    	return 0;
    }
}
