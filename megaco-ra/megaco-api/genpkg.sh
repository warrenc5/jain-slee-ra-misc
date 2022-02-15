find src/main/java/javax/megaco/pkg/ -name \*.java | grep -v .svn | sed -e 's/.*javax/javax/' -e 's/.java//' -e 's/\//./g'>  src/test/resources/pkg 
