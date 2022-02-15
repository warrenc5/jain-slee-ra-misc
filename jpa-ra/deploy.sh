#!/bin/bash
. ~/.bash_profile

mvnsite-link
mvndeploy-pom-gen-recursive

mvn -N clean install


cd ra
mvn clean
mvn install
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
mvn clean install
mvndeploy-all-source

