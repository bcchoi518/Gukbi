create user jspTest identified by 1234
default tablespace jspTest;


grant connect, resource to jspTest;


create tablespace jspTest
datafile 'D:/Developement/oradata/jspTest.dbf' size 50m 
AUTOEXTEND on 
next 10m 
maxsize unlimited;   