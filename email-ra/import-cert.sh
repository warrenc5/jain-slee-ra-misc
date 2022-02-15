RHINO_HOME=/opt/RhinoSDK
PASS=changeit
KEYSTORE=/opt/java/jre/lib/security/jssecacerts
#KEYSTORE=/opt/java/jre/lib/security/cacerts
OPTS="-Djavax.net.ssl.trustStore=${RHINO_HOME}/rhino-server.keystore -Djavax.net.ssl.trustStorePassword=${PASS}"
OPTS="-Djavax.net.ssl.trustStore=${KEYSTORE} -Djavax.net.ssl.trustStorePassword=${PASS}"
#java $OPTS -cp /code InstallCert imap.gmail.com:993
#java $OPTS -cp /code InstallCert smtp.gmail.com:465
java $OPTS -cp /code InstallCert lo:993
keytool -list -keystore jssecacerts -storepass $PASS
echo cp jssecacerts $KEYSTORE

