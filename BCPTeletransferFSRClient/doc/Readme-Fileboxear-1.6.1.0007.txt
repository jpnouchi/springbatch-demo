[INTSRUCTIONS TO APPLY FSR FIX FileboxEAR-1.6.1-0007.ear]

- Stop FSR
- Put the *ear file in $INST_PATH/standalone/deployments
- Backup old deployments: FileboxEAR-1.6.1-0005.ear
- Delete old deployments: FileboxEAR-1.6.1-0005.ear from that folder
- Update config file "$INST_PATH/cfg/spfab.system.sip.properties" as follows:
	- this property #graph.persistencyType=jenaInMemory|jenaDB
	- put it in graph.persistencyType=jenaInMemory
- Start FSR


