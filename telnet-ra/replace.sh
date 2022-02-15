sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/basic/telnet/g $(find . -type d)
rename s/basic/telnet/g $(find . -type d)
rename s/Basic/TelNet/g $(find . -type f| grep -v replace)

