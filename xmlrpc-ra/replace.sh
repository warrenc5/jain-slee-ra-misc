sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/basic/xmlrpc/g $(find . -type f)
rename s/basic/xmlrpc/g $(find . -type d)
rename s/Basic/XmlRpc/g $(find . -type d)
rename s/Basic/XmlRpc/g $(find . -type f)
rename s/BASIC/XMLRPC/g $(find . -type f| grep -v replace)

