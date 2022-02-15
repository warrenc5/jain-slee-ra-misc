sed -i -f replace.sed $(find . -type f | grep -v replace)
rename s/jpa/mlp/g $(find . -type d)
rename s/ojpa/mlp/g $(find . -type d)
rename s/JPA/MLP/g $(find . -type f| grep -v replace)

