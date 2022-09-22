CREATE TABLESPACE jspPortfolioModel2
DATAFILE 'C:/cbc/oradata/jspPortfolioModel2.dbf' SIZE 50m
AUTOEXTEND ON NEXT 10m MAXSIZE UNLIMITED;

CREATE USER jspPortfolioModel2 IDENTIFIED BY 1234
DEFAULT TABLESPACE jspPortfolioModel2;

GRANT CONNECT, RESOURCE TO jspPortfolioModel2;