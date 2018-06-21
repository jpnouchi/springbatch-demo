package com.primeur.bcp.teletransfer.common.constant;

/**
 * This class contains file constants.
 * 
 * @author David Reyes
 *
 */
public class FileConstants {
	
	
	public static final String VALIDATOR_SENDER = "VALID"; 
	
	/**
	 * Status Codes
	 */

	/**
	 * Sent KO
	 * When the sending process to MFT server doesn’t end successfully	
	 * Updated by: SPAZIO
	 */
	public static final char SENT_KO_CODE = '1';
	
	/**
	 * Sent OK
	 * When the file needs no validation and the sending process to MFT server has been successful
	 * Updated by: Validation Process
	 */
	public static final char SENT_OK_CODE = '2';
	
	/**
	 * Validation Not Started
	 * Validation didn’t start	When the validation process couldn´t start	
	 * Updated by: Validation Process
	 */
	public static final char VALIDATION_NOT_STARTED_CODE = '3';
	
	/**
	 * Validation In Process
	 * When the validation process is running	
	 * Updated by: Validation Process
	 */
	public static final char VALIDATION_IN_PROCESS_CODE = '4';
	
	/**
	 * Validation Interrupted
	 * When the validation process started but couldn’t end	Validation 
	 * because of an error thrown by product custom validator process
	 * Updated by: Validation Process
	 */
	public static final char VALIDATION_INTERRUPTED_CODE = '5';
	
	/**
	 * Validation KO
	 * When the validation process has ended with errors that have to be fixed
	 * Updated by: Validation Process
	 */
	public static final char VALIDATION_KO_CODE = '6';
	
	/**
	 * Validation OK
	 * When the validation process has ended without errors
	 * Updated by: Validation Process
	 */
	public static final char VALIDATION_OK_CODE = '7';
	
	/**
	 * Out Of Window	
	 * File has been received out of the processing window of the associated product
	 * Updated by: Consolidation Process
	 */
	public static final char OUT_OF_WINDOW_CODE = '8';
	
	/**
	 * Not Consolidated
	 * File has not been consolidated
	 * Updated by: Consolidation Process
	 */
	public static final char NOT_CONSOLIDATED_CODE = '9';
	
	/**
	 * Consolidated	
	 * File has been consolidated
	 * Updated by: Consolidation Process
	 */
	public static final char CONSOLIDATED_CODE = 'A';
	
	/**
	 * Status Descriptions
	 */
	
	public static final String SENT_KO_DESCRIPTION = "Envío no satisfactorio";
	
	public static final String SPAZIO_RECEIVED_OK_DESCRIPTION = "Preparado para procesar";
	
	public static final String SENT_OK_DESCRIPTION = "Envío satisfactorio";
	
	public static final String VALIDATION_NOT_STARTED_DESCRIPTION = "Validación no iniciada";
	
	public static final String VALIDATION_IN_PROCESS_DESCRIPTION = "Validación en proceso";
	
	public static final String VALIDATION_INTERRUPTED_DESCRIPTION = "Validación interrumpida";
	
	public static final String VALIDATION_KO_DESCRIPTION = "Validación con errores";
	
	public static final String VALIDATION_OK_DESCRIPTION = "Validación conforme";
	
	public static final String OUT_OF_WINDOW_DESCRIPTION = "Fuera de ventana";
	
	public static final String NOT_CONSOLIDATED_DESCRIPTION = "No consolidado";
	
	public static final String CONSOLIDATED_DESCRIPTION = "Consolidado";
}
