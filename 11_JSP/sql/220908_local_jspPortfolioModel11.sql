CREATE TABLE boardComment (
    commentNo NUMBER NOT NULL PRIMARY KEY, -- ��� �Ϸù�ȣ
    boardNo NUMBER NOT NULL REFERENCES board(no), -- �Խù� ��ȣ
    writer VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    memberNo NUMBER NOT NULL,
    ip VARCHAR2(50) NOT NULL,
    regiDate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_boardComment START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from boardComment;