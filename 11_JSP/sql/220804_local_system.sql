CREATE TABLESPACE jspTest
DATAFILE 'C:/cbc/oradata/jspTest.dbf'
SIZE 50m AUTOEXTEND ON NEXT 10m MAXSIZE UNLIMITED;

CREATE USER jspTest IDENTIFIED BY 1234
DEFAULT TABLESPACE jspTest;

GRANT CONNECT, RESOURCE TO jspTest;