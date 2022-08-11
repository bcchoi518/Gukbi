CREATE TABLE book (
    no NUMBER NOT NULL,
    subject VARCHAR2(50) NOT NULL,
    author VARCHAR2(50) NOT NULL,
    created DATE NOT NULL,
    profile VARCHAR2(50) NOT NULL, -- �з�
    regiDate DATE NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_book START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

SELECT * FROM book;

CREATE TABLE bookInfo (
    infoNo NUMBER NOT NULL,
    subject VARCHAR2(50) NOT NULL,
    created DATE NOT NULL,
    regiDate DATE NOT NULL,
    authorNo NUMBER NOT NULL,
    profileNo NUMBER NOT NULL,
    PRIMARY KEY (infoNo),
    FOREIGN KEY (authorNo) REFERENCES bookAuthor (authorNo),
    FOREIGN KEY (profileNo) REFERENCES bookProfile (profileNo)
);
CREATE SEQUENCE seq_bookInfo START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

CREATE TABLE bookAuthor (
    authorNo NUMBER NOT NULL,
    author VARCHAR2(50) NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (authorNo)
);
CREATE SEQUENCE seq_bookAuthor START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

CREATE TABLE bookProfile (
    profileNo NUMBER NOT NULL,
    profile VARCHAR2(50) NOT NULL, -- �з�
    regiDate DATE NOT NULL,
    PRIMARY KEY (profileNo)
);
CREATE SEQUENCE seq_bookProfile START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

INSERT INTO bookAuthor VALUES (seq_bookauthor.NEXTVAL, '����', SYSDATE);
INSERT INTO bookAuthor VALUES (seq_bookauthor.NEXTVAL, '����', SYSDATE);
INSERT INTO bookAuthor VALUES (seq_bookauthor.NEXTVAL, '�浿��', SYSDATE);

INSERT INTO bookProfile VALUES (seq_bookProfile.NEXTVAL, 'PG', SYSDATE);
INSERT INTO bookProfile VALUES (seq_bookProfile.NEXTVAL, '���α׷�', SYSDATE);
INSERT INTO bookProfile VALUES (seq_bookProfile.NEXTVAL, '���α׷���', SYSDATE);

INSERT INTO bookInfo VALUES (seq_bookInfo.NEXTVAL, '�ڹٴ� �� ����?', '2022-08-01', SYSDATE, 3, 3);
INSERT INTO bookInfo VALUES (seq_bookInfo.NEXTVAL, '���̽�', '2022-01-01', SYSDATE, 1, 2);
INSERT INTO bookInfo VALUES (seq_bookInfo.NEXTVAL, '�����̿� �Բ��ϴ� JSP', '2022-08-05', SYSDATE, 2, 3);
INSERT INTO bookInfo VALUES (seq_bookInfo.NEXTVAL, 'PHP �� ���α׷�', '2022-02-02', SYSDATE, 1, 1);

select * 
from bookinfo i, bookauthor a, bookprofile p
where i.authorno = a.authorno and i.profileno = p.profileno;