CREATE TABLE haksaMember (
    hakbun NUMBER NOT NULL,
    name VARCHAR2(50) NOT NULL,
    phone VARCHAR2(50) NOT NULL,
    parentPhone VARCHAR2(50) NOT NULL,
    addr1 VARCHAR2(50) NOT NULL,
    addr2 VARCHAR2(50) NOT NULL,
    addr3 VARCHAR2(50) NOT NULL,
    addr4 VARCHAR2(50) NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (hakbun)
);
CREATE SEQUENCE seq_haksaMember START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
SELECT * FROM haksaMember;

CREATE TABLE haksaSihum (
    sihumNo NUMBER NOT NULL,
    sihumName  VARCHAR2(50) NOT NULL,
    sihumDate DATE NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (sihumNo)
);
CREATE SEQUENCE seq_haksaSihum START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
SELECT * FROM haksaSihum;

CREATE TABLE haksaSungjuk (
    sungjukNo NUMBER NOT NULL,
    kor	NUMBER NOT NULL,
    eng	NUMBER NOT NULL,
    mat	NUMBER NOT NULL,
    sci	NUMBER NOT NULL,
    his	NUMBER NOT NULL,
    tot	NUMBER NOT NULL,
    avg	NUMBER NOT NULL,
    grade VARCHAR2(50) NOT NULL,
    hakbun NUMBER NOT NULL,
    sihumNo	NUMBER NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (sungjukNo)
);
CREATE SEQUENCE seq_haksaSungjuk START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
SELECT * FROM haksaSungjuk;

ALTER TABLE haksaSungjuk ADD CONSTRAINT FK_haksaSungjuk_haksaMember
FOREIGN KEY (hakbun) REFERENCES haksaMember (hakbun);

ALTER TABLE haksaSungjuk ADD CONSTRAINT FK_haksaSungjuk_haksaSihum
FOREIGN KEY (sihumNo) REFERENCES haksaSihum (sihumNo);




SELECT mb.name, sh.sihumName, sj.* 
FROM haksaSungjuk sj, haksaMember mb, haksaSihum sh 
WHERE sj.hakbun = mb.hakbun AND sj.sihumNo = sh.sihumNo 
ORDER BY sungjukNo DESC;