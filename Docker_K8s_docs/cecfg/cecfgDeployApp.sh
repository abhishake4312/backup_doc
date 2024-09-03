#!/bin/bash

ANT_HOME="/usr/local/apache-ant-1.10/apache-ant-1.10.7/bin"
LOCAL_WKSPACE="/usr/local/cecfg/code"
VOLUME_DIR="/usr/cecfg/"
TOMCAT_HOME="/usr/local/tomcat"
CONFIG_LOC="/usr/local/cecfg/configs"

#COPYING FILES FROM MOUNTED DIR TO LOCAL WORKSPACE
if find "$VOLUME_DIR" -mindepth 1 -print -quit 2>/dev/null | grep -q .
then
        echo "***** COPYING SOURCE CODE FROM MOUNTED VOLUME TO LOCAL WORKSPACE *******"
        rm -rf $LOCAL_WKSPACE/*
        cp -r $VOLUME_DIR/* $LOCAL_WKSPACE
		rm -rf $LOCAL_WKSPACE/FTCS.CECFG/src/main/webapp/WEB-INF/config/persistence/jpa-config-tomcat.xml

        #UPDATE PROP AND UTIL FILES
        cp $CONFIG_LOC/CecfgApplication.properties $LOCAL_WKSPACE/FTCS.CECFG/src/main/resources/
        cp $CONFIG_LOC/SecurityValidationUtil.java $LOCAL_WKSPACE/FTCS.CECFG/src/main/java/com/boeing/cecfg/common/util/
		cp $CONFIG_LOC/jpa-config-tomcat.xml $LOCAL_WKSPACE/FTCS.CECFG/src/main/webapp/WEB-INF/config/persistence

        #APPLICATION BUILD
        echo "****** CECFG Build Starts *******"
        cd $LOCAL_WKSPACE/FTCS.CECFG
        java -version
        $ANT_HOME/ant -version
        $ANT_HOME/ant all
        if [ $? -eq 1 ]
        then
                echo ""****** CECFG Build Failed *******"
                exit 1
        else
                echo ""****** CECFG Build Completed *******"
        fi

        #APPLICATION DEPLOYMENT
        pid=$(ps x | grep "${TOMCAT_HOME}" | grep -v grep | cut -d 'p' -f 1)
        if [ "${pid}" ]; then
                eval "kill ${pid}"
        fi

        echo "****** Uninstalling deployed apps ******"
        cd $TOMCAT_HOME/webapps
        rm -rf *.war
        rm -rf cecfg

        echo "****** Installing application ******"
        cp $LOCAL_WKSPACE/FTCS.CECFG/build/java_dist/cecfg.war $TOMCAT_HOME/webapps/
        chmod -R 777 $TOMCAT_HOME/webapps/*.war

        cd $TOMCAT_HOME/bin/
        ./startup.sh
        tail -10f $TOMCAT_HOME/logs/catalina.out
else
        echo "Mounted volume is empty. Please correct it and try again"
        exit 1
fi