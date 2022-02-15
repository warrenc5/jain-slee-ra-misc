#!/bin/bash
. ~/.bash_profile
#mvn -N clean install
#mvngo megaco-api ra service

cd megaco-api/
mvndeploysource
mvnjavadoc
mvnsite
mvndeploysite

#
#
cd ../ra
mvn clean && mvn -Pdefault -DdeployPomFile=pom-deploy.xml -Dsite.url=www.mofokom.biz:8822/var/www/mofokom/site -Dmaven.test.skip deploy
mvnjavadoc
mvnsite
mvndeploysite

#
#mvn -Djava.net.preferIPv4Stack=true deploy:deploy-file \
#                       -Durl=http://www.mofokom.biz/maven/snapshots-private-tpsa/ \
#                       -DrepositoryId=mofokom-private \
#                       -Dfile=target/megaco-ra-1.0-SNAPSHOT-du.jar \
#                       -DpomFile=pom-deploy.xml \
#                       -DgroupId=mofokom \
#                       -DartifactId=snmp-ra \
#                       -Dclassifier=du \
#                       -Dversion=1.0-SNAPSHOT \
#                       -Dpackaging=jar \
#                       -DuniqueVersion=false
#

cd ../service
mvndeploysource
mvnjavadoc
mvnsite
mvndeploysite

