--반정규화(정규화된 테이블을 다시 합침)
select i.infoNo, i.subject, i.created, a.author, p.profile, i.regidate
from bookinfo i, bookauthor a, bookprofile p
where i.authorno = a.authorno and i.profileno = p.profileno;

SELECT bookInfo.infoNo, bookInfo.subject, bookInfo.created, (
    SELECT author FROM bookAuthor WHERE bookAuthor.authorNo = bookInfo.authorNo
    ) Author, bookInfo.regiDate
FROM bookInfo;

SELECT bookInfo.infoNo, bookInfo.subject, bookInfo.created, 
    (SELECT author
       FROM bookAuthor
      WHERE bookAuthor.authorNo = bookInfo.authorNo) Author,
    (SELECT profile 
       FROM bookProfile 
      WHERE bookProfile.profileNo = bookInfo.profileNo) profile,
     bookInfo.regiDate
FROM bookInfo;

CREATE TABLE book (
    no NUMBER NOT NULL,
    subject VARCHAR2(50) NOT NULL,
    author VARCHAR2(50) NOT NULL,
    created DATE NOT NULL,
    profile VARCHAR2(50) NOT NULL, -- 분류
    regiDate DATE NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_book START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

SELECT * FROM book;

CREATE TABLE bookInfo (
    infoNo NUMBER NOT NULL,
    subject VARCHAR2(50) NOT NULL,
    created DATE NOT NULL,
    authorNo NUMBER NOT NULL,
    profileNo NUMBER NOT NULL,
    regiDate DATE NOT NULL,
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
    profile VARCHAR2(50) NOT NULL, -- 분류
    regiDate DATE NOT NULL,
    PRIMARY KEY (profileNo)
);
CREATE SEQUENCE seq_bookProfile START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

INSERT INTO bookAuthor VALUES (seq_bookauthor.NEXTVAL, '똘콩', SYSDATE);
INSERT INTO bookAuthor VALUES (seq_bookauthor.NEXTVAL, '진이', SYSDATE);
INSERT INTO bookAuthor VALUES (seq_bookauthor.NEXTVAL, '길동이', SYSDATE);

INSERT INTO bookProfile VALUES (seq_bookProfile.NEXTVAL, 'PG', SYSDATE);
INSERT INTO bookProfile VALUES (seq_bookProfile.NEXTVAL, '프로그램', SYSDATE);
INSERT INTO bookProfile VALUES (seq_bookProfile.NEXTVAL, '프로그래밍', SYSDATE);

INSERT INTO bookInfo VALUES (seq_bookInfo.NEXTVAL, '자바는 왜 배울까?', '2022-08-01', 3, 3, SYSDATE);
INSERT INTO bookInfo VALUES (seq_bookInfo.NEXTVAL, '해진이와 함께하는 JSP', '2022-08-05', 2, 3, SYSDATE);
INSERT INTO bookInfo VALUES (seq_bookInfo.NEXTVAL, '파이썬', '2022-01-01', 1, 2, SYSDATE);
INSERT INTO bookInfo VALUES (seq_bookInfo.NEXTVAL, 'PHP 웹 프로그램', '2022-02-02', 1, 1, SYSDATE);

select * from bookinfo order by infono desc;
select * from bookauthor;
select * from bookprofile;
drop table bookinfo cascade CONSTRAINTS;