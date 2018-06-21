#!/bin/sh

#Variables

export SPAZIO=/home/bcp/spazio
export CHUAO=/home/bcp/chuao/bin
export FSR=/home/fsr/fsr_1.6.1/bin
export SPOS=SPOS_BCP
export DSTK_VAR=/home/bcp/spazio
export TELETRANSFER=/home/bcp/teletransfer
export PATH=$PATH:$SPAZIO/bin
export LIBPATH=$SPAZIO/os_supp/lib-os:$SPAZIO/lib:$LIBPATH

_path=$TELETRANSFER
_path_log="$_path/restartAll.log"

#Encendido de SPAZIO
echo ------------------------------------------- >>$_path_log 
echo - Iniciando SPAZIO >> $_path_log
#su - spazio -c " $SPAZIO/bin/sp_start >> $_path_log"
$SPAZIO/bin/sp_start >> $_path_log

#Encendido de CHUAO
#echo ------------------------------------------- >> $_path_log
#echo - Iniciando CHUAO >>  $_path_log
#su - spazio -c "$CHUAO/chuaovm start >> $_path_log"
#$CHUAO/chuaovm start >> $_path_log

#Encendido de FSR
#echo ------------------------------------------- >> $_path_log
#echo - Iniciando FSR >> $_path_log
#su - fsr -c "nohup $FSR/primeur.sh >> $_path_log &"

#Encendido de los componentes del modulo de integracion: Distribuidor, EventSelector, Extractor y Validator
echo ------------------------------------------- >> $_path_log 
echo - Iniciando el Modulo de Integracion >> $_path_log 
#su - spazio -c "$_path/startIntegrationModule.sh $_path >>  $_path_log"
$_path/startIntegrationModule.sh >>  $_path_log

echo - Finalizado inicio de componentes >> $_path_log
echo ------------------------------------------- >> $_path_log
cd $_path


