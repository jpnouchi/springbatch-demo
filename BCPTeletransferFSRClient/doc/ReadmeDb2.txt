Creazione Database DB2

Come amministratore Db2:

DB2 CREATE DATABASE SP_MFTS AUTOMATIC STORAGE YES ALIAS SP_MFTS USING CODESET UTF-8 TERRITORY IT (modificare opportunamente il TERRITORY

Posizionarsi nella directory dove si trovano gli script:

- DB2_9_5_19_clpplus.sql
- DB2_9_5_19_BCP_clpplus.sql

>clpplus -nw
CLPPlus: Version 1.6
Copyright (c) 2009, 2011, IBM CORPORATION.  All rights reserved.

SQL> connect db2inst1/db2inst1@192.168.170.210:50001/SP_MFTS; (modificare opportunamente)

Database Connection Information :
---------------------------------
Hostname = 192.168.170.210 
Database server = DB2/LINUXX8664  SQL09073 
SQL authorization ID = db2inst1 
Local database alias = SP_MFTS 
Port = 50001 

SQL> @DB2_9_5_19_clpplus.sql /home/db2inst1/db2inst1/NODE0000/SP_MFTS; (modificareopportunamente il path delle TABLESPACES)
SQL>@DB2_9_5_19_BCP_clpplus.sql;
SQL>
SQL>quit
