#!/bin/bash
if [ $# -eq 0 ]
then
echo "Need environment name like unew or dnew"
else
env=$1
mailadd=$(cat /home/dev_build1/buildScripts/common/mailidsList.txt | grep $env | awk -F"=" '{print $2}')
upperenv=$(echo $env | tr /a-z/ /A-Z/)
source /home/dev_build1/buildScripts/common/env_jupdate.sh
echo $PATH
java -version
ant -version
mail -s "$upperenv - ftcs-app-dev-04 Common build Started" $mailadd < /dev/null
echo "--------------------------CHECKOUT STARTS------------------------"
/home/dev_build1/buildScripts/common/tfsCheckout.sh /tss.rehost/source/ftcs/$env CommonServices
echo "---------------------------CHECKOUT ENDS-------------------------"
rm -rf /tss.rehost/source/ftcs/$env/CommonServices/build/java_dist/
cd /tss.rehost/source/ftcs/$env/CommonServices
ant all
if [ $? -eq 1 ]
then
echo -e "CommonServices compilation Error\n"
exit 1
else
echo "CommonServices Compilation SUCCESS"
cp -rf /tss.rehost/source/ftcs/$env/CommonServices/build/java_dist/*.war /data/ftcs$env/installableApps
cd /home/dev_build1/buildScripts/common
./deploy.sh $env common
fi
mail -s "$upperenv - ftcs-app-dev-04 Common build is up and running" $mailadd < /dev/null
exit
fi
