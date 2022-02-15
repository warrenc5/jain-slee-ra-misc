gen.pl | xsltproc gen.xslt - | split.pl .
gen.pl > test.xml
#gen.pl | xsltproc --stringparam impl 'true' gen.xslt - | split.pl .

