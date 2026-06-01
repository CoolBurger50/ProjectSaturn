#!/bin/bash

user=raymondz66
path=/home/${user}/Projects/ProjectSaturn/Main

rm $path/sql/InsertStatements.sql
touch $path/sql/InsertStatements.sql

insertsql=$path/sql/InsertStatements.sql
createsql=$path/sql/CreateTables.sql

mysql -u $user -p -h 127.0.0.1 -D ${user}_db < $createsql

javac $path/src/*.java
java -cp $path/src Main

mysql -u $user -p -h 127.0.0.1 -D ${user}_db < $insertsql
