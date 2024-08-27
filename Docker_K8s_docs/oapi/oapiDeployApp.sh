#!/bin/bash

ANT_HOME="/usr/local/apache-ant-1.10/apache-ant-1.10.7/bin"
LOCAL_WKSPACE="/usr/local/oapi/code"
VOLUME_DIR="/usr/oapi/"
TOMCAT_HOME="/usr/local/tomcat"
CONFIG_LOC="/usr/local/oapi/configs"

#COPYING FILES FROM MOUNTED DIR TO LOCAL WORKSPACE
if find "$VOLUME_DIR" -mindepth 1 -print -quit 2>/dev/null | grep -q .
then
        echo "***** COPYING SOURCE CODE FROM MOUNTED VOLUME TO LOCAL WORKSPACE *******"
        rm -rf $LOCAL_WKSPACE/*
        cp -r $VOLUME_DIR/* $LOCAL_WKSPACE

        #UPDATE PROP AND UTIL FILES
        cp $CONFIG_LOC/OapiApplication.properties $LOCAL_WKSPACE/FTCS.OAPI/src/main/resources/
        cp $CONFIG_LOC/SecurityValidationUtils.java $LOCAL_WKSPACE/FTCS.OAPI/src/main/java/com/boeing/oapi/common/util/
		cp $CONFIG_LOC/jpa-config-tomcat.xml $LOCAL_WKSPACE/FTCS.OAPI/src/main/webapp/WEB-INF/config/persistence/

        #APPLICATION BUILD
        echo "****** OAPI Build Starts *******"
        cd $LOCAL_WKSPACE/FTCS.OAPI
        java -version
        $ANT_HOME/ant -version
        $ANT_HOME/ant all
        if [ $? -eq 1 ]
        then
                echo ""****** OAPI Build Failed *******"
                exit 1
        else
                echo ""****** OAPI Build Completed *******"
        fi

        #APPLICATION DEPLOYMENT
        pid=$(ps x | grep "${TOMCAT_HOME}" | grep -v grep | cut -d 'p' -f 1)
        if [ "${pid}" ]; then
                eval "kill ${pid}"
        fi

        echo "****** Uninstalling deployed apps ******"
        cd $TOMCAT_HOME/webapps
        rm -rf *.war
        rm -rf oapi

        echo "****** Installing application ******"
        cp $LOCAL_WKSPACE/FTCS.OAPI/build/java_dist/oapi.war $TOMCAT_HOME/webapps/
        chmod -R 777 $TOMCAT_HOME/webapps/*.war

        cd $TOMCAT_HOME/bin/
        ./startup.sh
        tail -10f $TOMCAT_HOME/logs/catalina.out
else
        echo "Mounted volume is empty. Please correct it and try again"
        exit 1
fi