CREATE USER hong IDENTIFIED BY 1234;

GRANT CONNECT, RESOURCE TO hong;

SELECT * FROM all_users;

--유저생성
CREATE USER kim IDENTIFIED BY 1234;
--권한부여
GRANT CONNECT, RESOURCE TO kim;
--전체유저조회
SELECT * FROM all_users;
--권한조회
SELECT grantee, granted_role FROM dba_role_privs WHERE grantee = 'KIM';
--권한회수
REVOKE CONNECT FROM kim;
--유저삭제
DROP USER hong CASCADE;


CREATE USER kim IDENTIFIED BY 1234;
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE temp;


--Table Space 생성
CREATE TABLESPACE javaOracle
DATAFILE 'C:/cbc/oradata/javaOracle.dbf' SIZE 50m
AUTOEXTEND ON
NEXT 10m
MAXSIZE UNLIMITED;
--사용자 계정 생성
CREATE USER javaOracle IDENTIFIED BY 1234
DEFAULT TABLESPACE javaOracle;
--권한 부여
GRANT CONNECT, RESOURCE TO javaOracle;
--유저 삭제
DROP USER javaOracle;
--Table Space 삭제
DROP TABLESPACE javaOracle INCLUDING CONTENTS AND DATAFILES CASCADE CONSTRAINTS;