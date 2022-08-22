-- 메모장
CREATE TABLE memo (
    no NUMBER NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_memo START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from memo order by no desc;

commit;

--------------------------------------------------------------------------------------
-- 방명록
CREATE TABLE guestBook (
    no NUMBER NOT NULL,
    name VARCHAR2(50) NOT NULL,
    email VARCHAR2(50) NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_guestBook START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

SELECT * FROM guestBook;