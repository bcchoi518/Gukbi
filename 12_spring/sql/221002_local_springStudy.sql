CREATE TABLE member (
    no       NUMBER       NOT NULL,
    id       VARCHAR2(50) NOT NULL,
    passwd   VARCHAR2(50) NOT NULL,
    name     VARCHAR2(50) NOT NULL,
    phone    VARCHAR2(50) NOT NULL,
    email    VARCHAR2(50) NOT NULL,
    jumin    VARCHAR2(50) NOT NULL,
    juso1    VARCHAR2(50) NOT NULL,
    juso2    VARCHAR2(50) NOT NULL,
    juso3    VARCHAR2(50) NOT NULL,
    juso4    VARCHAR2(50) NOT NULL,
    grade    VARCHAR2(50) NOT NULL,
    regiDate DATE         NOT NULL,
    attachInfo CLOB       NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (no)
);
CREATE SEQUENCE seq_member START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
SELECT * FROM member;