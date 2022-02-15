#!/bin/bash
. ~/.bash_profile
cd du
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

