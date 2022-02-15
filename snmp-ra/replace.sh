sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/basic/snmp/g $(find . -type d)
rename s/basic/snmp/g $(find . -type d)
rename s/Basic/SNMP/g $(find . -type f| grep -v replace)

