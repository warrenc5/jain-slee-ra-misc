find . -name \.svn | xargs rm -vrf 
sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/mgcp/megaco/g $(find . -type d)
rename s/mgcp/megaco/g $(find . -type f)
rename s/MGCP/MegaCo/g $(find . -type f| grep -v replace)

