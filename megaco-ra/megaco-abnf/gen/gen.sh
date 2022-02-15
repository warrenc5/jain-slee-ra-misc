 DEST=mofokom/megaco/resource/impl/codec/abnf
 java -jar /hold/aparse-2.2.jar -java 5.0 -destdir $DEST -package mofokom.megaco.resource.impl.codec.abnf all.cf

javac $DEST/*.java

 rm $DEST/Parser.java 
 cp $DEST/*.java ../src/main/java/mofokom/megaco/resource/impl/codec/abnf

 for i in $(ls ../../ra/src/test/resources/data/) ; do 

 echo $i
 java -cp . mofokom.megaco.resource.impl.codec.Parser -rule "megacoMessage" -file ../../ra/src/test/resources/data/$i 

 done
