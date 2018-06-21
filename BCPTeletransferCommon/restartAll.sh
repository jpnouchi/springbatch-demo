#!/bin/sh

#Variables
export SPAZIO=/home/bcp/spazio
export CHUAO=/home/bcp/chuao/bin
export FSR=/home/fsr/fsr_1.6.1/bin
export TELETRANSFER=/home/bcp/teletransfer

_path=$TELETRANSFER

#Run the script stopAll.sh to stop all the components
$_path/stopAll.sh

#Run the script startAll.sh to start all the components
$_path/startAll.sh

