#!/bin/bash
. ~/.bash_profile

mvn -N clean install
mvngo ra service

cd ra
mvndeploy
mvndeploysite

mvn -Djava.net.preferIPv4Stack=true deploy:deploy-file \
                       -Durl=http://www.mofokom.biz/maven/snapshots-private-tpsa/ \
                       -DrepositoryId=mofokom-private \
                       -Dfile=target/snmp-ra-1.0-SNAPSHOT-du.jar \
                       -DpomFile=pom-deploy.xml \
                       -DgroupId=mofokom \
                       -DartifactId=snmp-ra \
                       -Dclassifier=du \
                       -Dversion=1.0-SNAPSHOT \
                       -Dpackaging=jar \
                       -DuniqueVersion=false


cd ../service
mvndeploysource
mvndeploysite

