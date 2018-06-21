#!/bin/sh

#Variables
export SPAZIO=/opt/spazio
export CHUAO=/SPAZIO/APFTDES/chuao/bin
export FSR=/SPAZIO/APFSRDES/fsr/bin
export TELETRANSFER=/SPAZIO/APFTDES/teletransfer

_path=$TELETRANSFER

#Run the script stopAll.sh to stop all the components
$_path/stopAll.sh

#Run the script startAll.sh to start all the components
$_path/startAll.sh

