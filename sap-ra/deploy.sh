#!/bin/bash
. ~/.bash_profile

mvndeploy-pom-gen-recursive 
mvnsite-link

cd ra-type
mvndeploy-all-source

cd ../lib
mvndeploy-all

cd ../event
mvndeploy-all-source

cd ../ra
mvn-deploy-all

cd ../service
mvndeploy-all-source

cd ../service-du
mvndeploy-all-source

cd ../du
mvn-deploy-all

