----------------------------------
-- BCP v1.4.0 New Metadata      --
----------------------------------

-- New Columns

ALTER TABLE SPFB_BCP_ADMINISTRATOR_AUDIT_MD ADD ERROR_DESCRIPTION VARCHAR(1024);

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

-- DROP PROCEDURE INSERT_METADATA_IN_DICT (BIGINT, INTEGER, VARCHAR(32), VARCHAR(128), INTEGER, INTEGER);

CREATE PROCEDURE INSERT_METADATA_IN_DICT ( IN classId BIGINT,
					   IN typeId INTEGER,
					   IN metadtaName VARCHAR(32), 
					   IN desc VARCHAR(128),
					   IN length INTEGER,
					   IN prec INTEGER 
					   )
DYNAMIC RESULT SETS 1
------------------------------------------------------------------------
-- SQL Stored Procedure 
------------------------------------------------------------------------
BEGIN
	DECLARE metadataId BIGINT;
	
	CALL INCREMENT_COUNTER(7, metadataId);
	
	INSERT INTO SPFB_METADATA(ID_METADATA, ID_METADATA_TYPE, METADATA_DESCRIPTION, METADATA_NAME, LENGTH, PRECISION) VALUES (metadataId, typeId, desc, metadtaName, length, prec);
	INSERT INTO SPFB_META_CLASS_STRUCT (ID_METADATA_CLASS, ID_METADATA, METADATA_ORDER) VALUES(classId, metadataId, 100); 
END;
/


CREATE PROCEDURE UPDATE_METADATA_DICT
------------------------------------------------------------------------
-- SQL Stored Procedure 
------------------------------------------------------------------------
BEGIN
	
	------------------------------------------------------------------------
	-- Protected Metadata Class SPFB_BCP_ADMINISTRATOR_AUDIT_MD
	------------------------------------------------------------------------
	CALL INSERT_METADATA_IN_DICT((SELECT ID_METADATA_CLASS FROM SPFB_META_CLASS WHERE CLASS_NAME = 'SPFB_BCP_ADMINISTRATOR_AUDIT_MD'), 1, 'ERROR_DESCRIPTION', 'ERROR_DESCRIPTION', 1024, 0);
	
END;
/

CALL UPDATE_METADATA_DICT;
COMMIT;
	
DROP PROCEDURE INCREMENT_COUNTER (INTEGER, BIGINT);
DROP PROCEDURE INSERT_METADATA_IN_DICT (BIGINT, INTEGER, VARCHAR(32), VARCHAR(128), INTEGER, INTEGER);
DROP PROCEDURE UPDATE_METADATA_DICT;

COMMIT;