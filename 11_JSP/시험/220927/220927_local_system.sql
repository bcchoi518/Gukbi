CREATE TABLESPACE application_test
DATAFILE 'C:/cbc/oradata/applicationTest.dbf'
SIZE 50m AUTOEXTEND ON NEXT 10m MAXSIZE UNLIMITED;

CREATE USER application_test IDENTIFIED BY 1234
DEFAULT TABLESPACE application_test;

GRANT CONNECT, RESOURCE TO application_test;