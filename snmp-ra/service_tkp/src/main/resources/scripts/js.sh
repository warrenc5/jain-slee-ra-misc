RHINO_HOME=/opt/RhinoSDK/
OPTS="$OPTS -Djava.security.mananger"
OPTS="$OPTS -Djavax.net.ssl.keyStore=$RHINO_HOME/rhino-client.keystore"
OPTS="$OPTS -Djavax.net.ssl.keyStorePassword=changeit"
OPTS="$OPTS -Djavax.net.ssl.trustStore=$RHINO_HOME/rhino-server.keystore"
OPTS="$OPTS -Djavax.net.ssl.trustStorePassword=changeit"

echo $OPTS
CP=/opt/mobicents/server/default/deploy/mobicents-slee/lib/activities-3.0.0-SNAPSHOT.jar:jainslee-api-1.1.jar:/opt/mobicents/server/default/deploy/mobicents-slee/lib/spi-3.0.0-SNAPSHOT.jar:/opt/mobicents/server/default/deploy/mobicents-slee/lib/profiles-3.0.0-SNAPSHOT.jar
#DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,address=9009,server=y,suspend=y"
rm /tmp/script.js
cat $@ >> /tmp/script.js
java $BCP $OPTS $DEBUG -cp $CP -Djava.security.manager -Djava.security.policy=.java.policy -Djava.net.preferIPv4Stack=true com/sun/script/javascript/RhinoScriptEngine /tmp/script.js
#java $DEBUG -cp jainslee-api-1.1.jar:/opt/rhino1_7R2/js.jar -Djava.security.manager -Djava.security.policy=.java.policy -Djava.net.preferIPv4Stack=true org.mozilla.javascript.tools.shell.Main /code/js/test.js 
#jconsole -J-Djava.security.manager -J-Djava.security.policy=file:///home/wozza/.java.policy -J-Djava.net.preferIPv4Stack=true service:jmx:rmi://127.0.0.1/jndi/rmi://127.0.0.1:1090/jmxconnector
