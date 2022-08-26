alter table boardBasic add memberNo number default 0;
alter table boardBasic add ip varchar2(50) default '-';
alter table boardBasic add parentNo number default 0;

select subject, refno, stepno, levelno from boardbasic order by refno desc, levelno asc;

-- 게시판(본격적인?)
CREATE TABLE board (
    no NUMBER NOT NULL,
    num NUMBER NOT NULL,
    tbl VARCHAR2(50) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    subject VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    email VARCHAR2(50) NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    refNo NUMBER NOT NULL,
    stepNo NUMBER NOT NULL,
    levelNo NUMBER NOT NULL,
    parentNo NUMBER NOT NULL,
    hit NUMBER NOT NULL,
    ip VARCHAR2(50) NOT NULL,
    memberNo NUMBER NOT NULL,
    noticeNo NUMBER NOT NULL,
    secretGubun VARCHAR2(1) NOT NULL CHECK (secretGubun in ('T', 'F')),
    regiDate DATE NOT NULL,
    attachInfo CLOB NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_board START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;