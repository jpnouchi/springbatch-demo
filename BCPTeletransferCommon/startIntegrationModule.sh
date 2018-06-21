export TELETRANSFER=/home/bcp/teletransfer

cd $TELETRANSFER/consolidator/bin/
nohup ./extractor.sh &
cd $TELETRANSFER/distributor/bin/
nohup ./distDaemon.sh &
cd $TELETRANSFER/validator/bin/
nohup ./validator.sh &
cd $TELETRANSFER/eventSelector/bin/
nohup ./eventSelector.sh &
cd $TELETRANSFER
