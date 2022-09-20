CREATE TABLE boardComment (
    commentNo NUMBER NOT NULL PRIMARY KEY, -- 댓글 일련번호
    boardNo NUMBER NOT NULL REFERENCES board(no), -- 게시물 번호
    writer VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    memberNo NUMBER NOT NULL,
    ip VARCHAR2(50) NOT NULL,
    regiDate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_boardComment START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from boardComment;