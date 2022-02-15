CP=$CP:~/.m2/repository/javax/slee/jain-slee/1.1/jain-slee-1.1.jar
CP=$CP:../du/target/xmlrpc-ra-1.0-SNAPSHOT.jar
CP=$CP:../du/target/xmlrpc-ra-type-1.0-SNAPSHOT.jar
CP=$CP:../du/target/xmlrpc-library-1.0-SNAPSHOT.jar
CP=$CP:../du/target/httpcore-nio-4.1-beta2.jar
CP=$CP:../du/target/httpcore-4.1-beta2.jar

javac -classpath $CP:. src/test/java/AbstractBullshit.java
java -classpath $CP:src/test/java AbstractBullshit

