-- °Ô½ÃÆÇ(B)
CREATE TABLE boardBasic (
    no NUMBER NOT NULL,
    num NUMBER NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    subject VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    email VARCHAR2(50) NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    refNo NUMBER NOT NULL,
    stepNo NUMBER NOT NULL,
    levelNo NUMBER NOT NULL,
    hit NUMBER NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_boardBasic START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
drop sequence seq_boardBasic;

select * from boardBasic;
truncate table boardBasic;

SELECT NVL(max(num),0) max FROM boardbasic;