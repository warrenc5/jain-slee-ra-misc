#!/bin/bash
. ~/.bash_profile
mvndeploy-pom-gen-recursive
doIt() {
mvndeploysite
}

cd ucip-ratype
doIt
cd - 
cd acip-ratype
doIt
cd - 
cd vsip-ratype
doIt
mvndeploysite
cd - 
cd ucip-event
doIt
cd - 
cd acip-event
doIt
cd - 
cd vsip-event
doIt
cd - 
cd ucip-service
doIt
cd - 
cd acip-service
doIt
cd - 
cd vsip-service
doIt
cd - 
cd service-du
doIt

