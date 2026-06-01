#!/bin/bash

user=raymondz66
path=/home/${user}/Projects/ProjectSaturn/Main

rm $path/sql/InsertStatements.sql
touch $path/sql/InsertStatements.sql

rm $path/sql/Installation.sql
touch $path/sql/Installation.sql

createsql=$path/sql/CreateTables.sql
dropsql=$path/sql/DropTables.sql
insertsql=$path/sql/InsertStatements.sql
installationsql=$path/sql/Installation.sql

javac $path/src/*.java
java -cp $path/src Main

cat $dropsql >> $installationsql
cat $createsql >> $installationsql
cat $insertsql >> $installationsql

mysql -u $user -p -h 127.0.0.1 -D ${user}_db < $installationsql
