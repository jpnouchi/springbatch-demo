#!/bin/ksh

#Variables
export SPAZIO=/opt/spazio
export CHUAO=/SPAZIO/APFTDES/chuao/bin
export FSR=/SPAZIO/APFSRDES/fsr/bin
export SPOS=SP_SPAZIO
export DSTK_VAR=/opt/spazio
export TELETRANSFER=/SPAZIO/APFTDES/teletransfer
export PATH=$PATH:$SPAZIO/bin
export LIBPATH=$SPAZIO/os_supp/lib-os:$SPAZIO/lib:$LIBPATH

_path=$TELETRANSFER
_path_log="$_path/restartAll.log"
echo "Inicio de apagado total de teletransfer" >> $_path_log
chmod 777 $_path_log  

#Apagado de los componentes del modulo de integracion: Distribuidor, Validador, Extractor y EventSelector
echo - Apagando el Modulo de Integracion >> $_path_log
#su - spazio -c "$_path/stopIntegrationModule.sh $_path>> $_path_log"
$_path/stopIntegrationModule.sh >> $_path_log

#Apagado de FSR
#echo ------------------------------------------- >> $_path_log
#echo - Apagando FSR >> $_path_log
#su - fsr -c "$FSR/shutPrimeur.sh >> $_path_log" 

#Apagado de CHUAO
#echo ------------------------------------------- >> $_path_log
#echo - Apagando CHUAO >>  $_path_log
#su - spazio -c "$CHUAO/chuaovm stop >> $_path_log"
#$CHUAO/chuaovm stop >> $_path_log

#Apagado de SPAZIO
echo ------------------------------------------- >>$_path_log
echo - Apagando SPAZIO >> $_path_log
#su - spazio -c "$SPAZIO/bin/sp_shut >> $_path_log"
$SPAZIO/bin/sp_shut >> $_path_log

echo - Finalizado apagado de componentes >> $_path_log
echo ------------------------------------------- >> $_path_log
cd $_path

