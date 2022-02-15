find . -name \.svn | xargs rm -vrf 
sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/basic/telnet/g $(find . -type d)
rename s/basic/telnet/g $(find . -type f)
rename s/Basic/TelNet/g $(find . -type f| grep -v replace)

