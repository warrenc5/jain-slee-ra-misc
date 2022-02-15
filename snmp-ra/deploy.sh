#!/bin/bash
. ~/.bash_profile

mvndeploy-pom-gen-recursive
mvnsite-link 

mvn -N clean install
mvngo ra service

cd ra
mvndeploy-all

#mvnjavadoc && mvnsite && mvndeploy && mvndeploysite && mvndeploy-pom-gen && mvn -Djava.net.preferIPv4Stack=true deploy:deploy-file \
#                       -Durl=http://www.mofokom.biz/maven/snapshots-public/ \
#                       -DrepositoryId=mofokom-private \
#                       -Dfile=target/jpa-ra-1.0-SNAPSHOT-du.jar \
#                       -DpomFile=pom-deploy.xml \
#                       -DgroupId=mofokom \
#                       -DartifactId=jpa-ra \
#                       -Dclassifier=du \
#                       -Dversion=1.0-SNAPSHOT \
#                       -Dpackaging=jar \
#                       -DuniqueVersion=false
#

cd ../service
mvndeploy-all-source

