sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/basic/USSD/g $(find . -type d)
rename s/basic/USSD/g $(find . -type d)
rename s/Basic/USSD/g $(find . -type f| grep -v replace)

