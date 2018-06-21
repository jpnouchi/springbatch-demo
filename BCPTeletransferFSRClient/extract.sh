cd /home/bcp/teletransfer/extractUsuProd/bin

/home/bcp/spazio/bin/jre/bin/java -Xms64m -Xmx128m -cp ../config/log4jBCP.xml:../config/log4jPrimeur.xml:../../lib/log4j-1.2.17.jar:../../lib/dstk.jar:../../lib/FileboxClient.jar:../../lib/FileboxToolkit.jar:../../lib/FileboxWEBEnunciate.jar:../../lib/apache-activemq-4.1.1.jar:../../lib/BCPTeletransferFSRClient.jar:../../lib/BCPTeletransferCommon.jar com.primeur.bcp.teletransfer.fsr.client.util.ExtractUSUPROD
