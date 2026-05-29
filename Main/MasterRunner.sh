#!/bin/bash

path=/home/raymondz66/Projects/ProjectSaturn/Main
user=raymondz66

rm $path/sql/InsertStatements.sql
touch $path/sql/InsertStatements.sql

mysql -u $user -p -h 127.0.0.1 -D ${user}_db < /sql/CreateTables.sql

javac $path/src/*.java
java -cp $path/src Main

mysql -u $user -p -h 127.0.0.1 -D ${user}_db < /sql/InsertStatements.sql