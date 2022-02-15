for i in $(find ./src/test/resources/data/ -name *.txt) ; do

f=`basename $i`
if [ -f "./src/test/resources/output/$f.out" ] ; then 
echo $i
diff -suBw ./src/test/resources/data/$f ./src/test/resources/output/$f.out
fi

done
