#!/bin/bash
. ~/.bash_profile
cd `dirname $0`
BASE=`pwd -P`
mvndeploy-pom-gen-recursive snapshots-public
mvn -o -fae -Dmaven.test.skip clean install
if [ $? -gt 0 ] ; then 
exit 1 
fi

cd $BASE/du
mvn -Djava.net.preferIPv4Stack=true deploy:deploy-file \
                       -Durl=http://www.mofokom.biz/maven/snapshots-public/ \
                      -DrepositoryId=mofokom-public \
                       -Dfile=target/air-du-1.0-SNAPSHOT.jar \
                      -DpomFile=pom-deploy.xml \
                       -DgroupId=mofokom \
                       -DartifactId=air-du \
                      -Dversion=1.0-SNAPSHOT \
                       -Dpackaging=jar \
                      -DuniqueVersion=true
mvndeploy-all

cd $BASE/ucip-ratype
mvndeploy-all-source
cd $BASE/acip-ratype
mvndeploy-all-source
cd $BASE/vsip-ratype
mvndeploy-all-source

cd $BASE/ucip-event
mvndeploy-all-source
cd $BASE/acip-event
mvndeploy-all-source
cd $BASE/vsip-event
mvndeploy-all-source

cd $BASE/ucip-service
mvndeploy-all-source
cd $BASE/acip-service
cd $BASE/vsip-service
mvndeploy-all-source
cd $BASE/service-du

