 DEST=tmp/mofokom/mgcp/resource/impl/codec/abnf
 mkdir -p $DEST
 java -jar /hold/aparse-2.2.jar -java 5.0 -destdir $DEST -package mofokom.mgcp.resource.impl.codec.abnf src/test/resources/rfc3435.cf

javac -d tmp $DEST/*.java

 rm $DEST/Parser.java 
 cp $DEST/*.java src/main/java/mofokom/mgcp/resource/impl/codec/abnf

 for i in $(ls src/test/resources/data/) ; do 

 echo $i
 java -cp tmp mofokom.mgcp.resource.impl.codec.abnf.Parser -rule "MGCPMessage" -file src/test/resources/data/$i 

 done
