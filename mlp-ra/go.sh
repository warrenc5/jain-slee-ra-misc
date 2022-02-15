#!/bin/bash
. ~/.bash_profile
mvndeploy-pom-gen-recursive snapshots-public
mvn -o -fae -Dmaven.test.skip clean install
if [ $? -gt 0 ] ; then 
exit 1 
fi

cd ra
mvndeploy
cd -
cd service
mvndeploysource
