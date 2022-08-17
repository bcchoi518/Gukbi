CREATE TABLESPACE jspPortfolioModel1
DATAFILE 'C:/cbc/oradata/jspPortfolioModel1.dbf'
SIZE 50m AUTOEXTEND ON NEXT 10m MAXSIZE UNLIMITED;

CREATE USER jspPortfolioModel1 IDENTIFIED BY 1234
DEFAULT TABLESPACE jspPortfolioModel1;

grant connect, resource to jspPortfolioModel1;