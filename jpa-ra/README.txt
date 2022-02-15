  <property name="openjpa.jdbc.SynchronizeMappings" value="buildSchema(PrimaryKeys=true,ForeignKeys=true,Sequences=true),add,refresh,deleteTableContents"/>

su - postgres
createuser -P jpa
Enter password for new role: 
Enter it again: 
Shall the new role be a superuser? (y/n) y
createuser: creation of new role failed: ERROR:  role "jpa" already exists
postgres@splice:~$ drop    
dropdb    droplang  dropuser  
postgres@splice:~$ dropuser jpa
postgres@splice:~$ createuser -P jpa
Enter password for new role: 
Enter it again: 
Shall the new role be a superuser? (y/n) y
postgres@splice:~$ exit
$ 

