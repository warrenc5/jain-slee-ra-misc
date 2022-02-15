find . -name \.svn | xargs rm -vrf 
sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/basic/mgcp/g $(find . -type d)
rename s/basic/mgcp/g $(find . -type d)
rename s/Basic/MGCP/g $(find . -type f| grep -v replace)

