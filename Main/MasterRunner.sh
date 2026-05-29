#!/bin/bash

path=/home/raymondz66/Projects/ProjectSaturn/Main
user=raymondz66

rm $path/sql/InsertStatements.sql
touch $path/sql/InsertStatements.sql

insertsql=$path/sql/InsertStatements.sql
createsql=$path/sql/CreateTables.sql

mysql -u $user -p -h 127.0.0.1 -D ${user}_db < $createsql

javac $path/src/*.java
java -cp $path/src Main

mysql -u $user -p -h 127.0.0.1 -D ${user}_db < $insertsql
