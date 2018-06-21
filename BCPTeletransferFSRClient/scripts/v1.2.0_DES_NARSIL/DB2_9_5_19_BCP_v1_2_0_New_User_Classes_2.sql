----------------------------------
-- BCP v1.2.0 New User Classes  --
----------------------------------

-- Fix Wrong Counters

UPDATE SPMFTS_COUNTERS SET LAST_VALUE = 6 WHERE DESCRIPTION = 'SPFB_USER_CLASS_COUNTER';

COMMIT;

----------------------------------------------------------------------------
-- STORED PROCEDURES --
----------------------------------------------------------------------------

-- DROP PROCEDURE INCREMENT_COUNTER (INTEGER, BIGINT);

CREATE PROCEDURE INCREMENT_COUNTER ( IN counterID INTEGER, OUT nextVal BIGINT )
DYNAMIC RESULT SETS 1
------------------------------------------------------------------------
-- SQL Stored Procedure 
------------------------------------------------------------------------
BEGIN
	SELECT LAST_VALUE INTO nextVal FROM SPMFTS_COUNTERS WHERE ID_COUNTER = counterID;
		
	SET nextVal = nextVal + 1;
	
	UPDATE SPMFTS_COUNTERS SET LAST_VALUE = nextVal  WHERE ID_COUNTER = counterID;
END;
/

CREATE PROCEDURE CREATE_USER_CLASSES
------------------------------------------------------------------------
-- SQL Stored Procedure 
------------------------------------------------------------------------
BEGIN
	
	DECLARE userClassId BIGINT;
	
	------------------------------------------------------------------------
	-- BCP Teletransfer Administrator User class
	------------------------------------------------------------------------
	CALL INCREMENT_COUNTER(8, userClassId);
	INSERT INTO SPFB_USER_CLASSES(ID_USER_CLASS, USER_CLASS_CODE, DESCRIPTION, CLASS_TYPE, ID_STORAGE_CLASS, EXPIRY_AFTER_PUT, EXPIRY_AFTER_READ, DELETE_MODE, ARCHIVING_OPT, CREATION_DATE, UPDATE_DATE) VALUES (userClassId, 'BCPTTADMIN', 'BCP Teletransfer Administrator User class', 0, 7, 0, 0, 0, 0, null, null); 
	
	------------------------------------------------------------------------
	-- BCP Teletransfer Administrator Audit User class
	------------------------------------------------------------------------
	CALL INCREMENT_COUNTER(8, userClassId);
	INSERT INTO SPFB_USER_CLASSES(ID_USER_CLASS, USER_CLASS_CODE, DESCRIPTION, CLASS_TYPE, ID_STORAGE_CLASS, EXPIRY_AFTER_PUT, EXPIRY_AFTER_READ, DELETE_MODE, ARCHIVING_OPT, CREATION_DATE, UPDATE_DATE) VALUES (userClassId, 'BCPTTADMIN_AUDIT', 'BCP Teletransfer Administrator Audit User class', 0, 7, 15120000, 0, 0, 0, null, null); 

END;
/

CALL CREATE_USER_CLASSES;
COMMIT;
	
DROP PROCEDURE INCREMENT_COUNTER (INTEGER, BIGINT);
DROP PROCEDURE CREATE_USER_CLASSES;

COMMIT;
