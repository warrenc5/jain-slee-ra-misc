find . -name \.svn | xargs rm -vrf 
sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/basic/directory/g $(find . -type d)
rename s/basic/directory/g $(find . -type f)
rename s/Basic/Directory/g $(find . -type f| grep -v replace)

