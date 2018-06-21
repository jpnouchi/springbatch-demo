--------------------------------------------------------
---- DB2_9_5_19_BCP_v1_2_1_Static_Data_1_Tables.sql ---- 
--------------------------------------------------------


CREATE TABLE BCP_DEPARTMENT (
      ID				BIGINT NOT NULL,
      NAME				VARCHAR(50) NOT NULL
)  IN "FB_TS_METADATA";

ALTER TABLE BCP_DEPARTMENT ADD CONSTRAINT BCP_DEPARTMENT_PK PRIMARY KEY (ID);
ALTER TABLE BCP_DEPARTMENT ADD CONSTRAINT BCP_DEPARTMENT_UN1 UNIQUE (NAME);
-- CREATE INDEX BCP_DEPARTMENT_IX1 ON BCP_DEPARTMENT (NAME ASC);


CREATE TABLE BCP_PROVINCE (
      ID				BIGINT NOT NULL,
      NAME				VARCHAR(50) NOT NULL,
	  ID_DEPARTMENT 	BIGINT NOT NULL
)  IN "FB_TS_METADATA";

ALTER TABLE BCP_PROVINCE ADD CONSTRAINT BCP_PROVINCE_PK PRIMARY KEY (ID);
ALTER TABLE BCP_PROVINCE ADD CONSTRAINT BCP_PROVINCE_UN1 UNIQUE (NAME, ID_DEPARTMENT);
ALTER TABLE BCP_PROVINCE ADD CONSTRAINT BCP_PROVINCE_FK1 FOREIGN KEY (ID_DEPARTMENT) REFERENCES BCP_DEPARTMENT (ID) ON DELETE CASCADE;
CREATE INDEX BCP_PROVINCE_IX1 ON BCP_PROVINCE (NAME ASC);


CREATE TABLE BCP_DISTRICT (
      ID				BIGINT NOT NULL,
      NAME				VARCHAR(50) NOT NULL,
	  ID_PROVINCE 		BIGINT NOT NULL
)  IN "FB_TS_METADATA";

ALTER TABLE BCP_DISTRICT ADD CONSTRAINT BCP_DISTRICT_PK PRIMARY KEY (ID);
ALTER TABLE BCP_DISTRICT ADD CONSTRAINT BCP_DISTRICT_UN1 UNIQUE (NAME, ID_PROVINCE);
ALTER TABLE BCP_DISTRICT ADD CONSTRAINT BCP_DISTRICT_FK1 FOREIGN KEY (ID_PROVINCE) REFERENCES BCP_PROVINCE (ID) ON DELETE CASCADE;
CREATE INDEX BCP_DISTRICT_IX1 ON BCP_DISTRICT (NAME ASC);


CREATE TABLE BCP_STATIC_DATA_TYPE (
      ID				BIGINT NOT NULL,
      NAME				VARCHAR(50) NOT NULL
)  IN "FB_TS_METADATA";

ALTER TABLE BCP_STATIC_DATA_TYPE ADD CONSTRAINT BCP_STATIC_DATA_TYPE_PK PRIMARY KEY (ID);
ALTER TABLE BCP_STATIC_DATA_TYPE ADD CONSTRAINT BCP_STATIC_DATA_TYPE_UN1 UNIQUE (NAME);
-- CREATE INDEX BCP_STATIC_DATA_TYPE_IX1 ON BCP_STATIC_DATA_TYPE (NAME ASC); 
CREATE SEQUENCE BCP_STATIC_DATA_TYPE_SEQ AS BIGINT START WITH 1 INCREMENT BY 1 NO MAXVALUE NO CYCLE CACHE 20;


CREATE TABLE BCP_STATIC_DATA (
      ID				BIGINT NOT NULL,
      NAME				VARCHAR(50) NOT NULL,
      VAL				VARCHAR(50) NOT NULL,
      ID_TYPE			BIGINT NOT NULL
)  IN "FB_TS_METADATA";

ALTER TABLE BCP_STATIC_DATA ADD CONSTRAINT BCP_STATIC_DATA_PK PRIMARY KEY (ID);
ALTER TABLE BCP_STATIC_DATA ADD CONSTRAINT BCP_STATIC_UN1 UNIQUE (NAME, ID_TYPE);
ALTER TABLE BCP_STATIC_DATA ADD CONSTRAINT BCP_STATIC_DATA_FK1 FOREIGN KEY (ID_TYPE) REFERENCES BCP_STATIC_DATA_TYPE (ID) ON DELETE CASCADE;
CREATE INDEX BCP_STATIC_DATA_IX1 ON BCP_STATIC_DATA (NAME ASC);
CREATE SEQUENCE BCP_STATIC_DATA_SEQ AS BIGINT START WITH 1 INCREMENT BY 1 NO MAXVALUE NO CYCLE CACHE 20;


COMMIT;