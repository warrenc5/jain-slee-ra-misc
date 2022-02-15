#!/bin/bash
. ~/.bash_profile
mvndeploy-pom-gen-recursive snapshots-public
mvn -o -fae -Dmaven.test.skip clean install
if [ $? -gt 0 ] ; then 
exit 1 
fi

cd du
mvngo .
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

cd ..
cd ucip-ratype
mvndeploy
cd -
cd acip-ratype
mvndeploy
cd -
cd vsip-ratype
mvndeploy

cd -
cd ucip-event
mvndeploy
cd -
cd acip-event
mvndeploy
cd -
cd vsip-event
mvndeploy

cd -
cd ucip-service
mvndeploysource
cd -
cd acip-service
mvndeploysource
cd -
cd vsip-service
mvndeploysource
cd -
cd service-du
mvndeploysource

