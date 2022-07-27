CREATE TABLE book_all (
id NUMBER NOT NULL,
subject VARCHAR2(50) NOT NULL,
author VARCHAR2(50) NOT NULL,
created DATE NOT NULL,
profile VARCHAR2(50) NOT NULL
);

INSERT INTO book_all VALUES (1,'점프 투 파이썬', '박응용', '2019-07-14', '프로그래밍');
INSERT INTO book_all VALUES (2,'점프 투 자바', '박응용', '2018-08-25', '프로그래밍');
INSERT INTO book_all VALUES (3,'딥 러닝을 이용한 자연어 처리 입문', 'WJY', '2019-07-12', '프로그래밍');
INSERT INTO book_all VALUES (4,'공이의 수학정리노트', 'Donghoon', '2019-04-05', '수학');
INSERT INTO book_all VALUES (5,'예제로 배우는 ORACLE 11g', '초록우산', '2019-07-12', '데이타베이스');
INSERT INTO book_all VALUES (6,'주식 시장을 이기는 마법의 자동매매', '엑슬론', '2019-03-16', '주식');
INSERT INTO book_all VALUES (7,'비트코인 개발자 가이드', 'Soori', '2018-02-24', '금융');
INSERT INTO book_all VALUES (8,'미국 금융공학 유학', '엑슬론', '2019-07-12', '주식');
INSERT INTO book_all VALUES (9,'Deep Inside VBA', '곽승주', '2019-04-27', 'VBA');
INSERT INTO book_all VALUES (10,'CentOS 만들기', '박응용', '2016-10-19', '프로그래밍');
INSERT INTO book_all VALUES (11,'Windows Server 만들기', '박응용', '2017-08-09', '프로그래밍');
COMMIT;
SELECT * FROM book_all;

-- 저자가 박응용인 서적 출력
SELECT *
FROM book_all
WHERE author = '박응용';

-- 발행년도가 2019년도인 서적 출력
SELECT *
FROM book_all
WHERE created BETWEEN '19/01/01' AND '19/12/31';

-- 분류의 갯수
SELECT COUNT(DISTINCT profile)
FROM book_all;

-- 분류 출력 (중복제거)
SELECT DISTINCT profile
FROM book_all;

-- 저자가 박응용 이거나 분류가 수학인 서적 출력
SELECT *
FROM book_all
WHERE author = '박응용' OR profile = '수학';

-- 오라클과 관련된 내용이 있는 서적 출력
SELECT *
FROM book_all
WHERE subject LIKE '%오라클%' OR LOWER(subject) LIKE '%oracle%';

-- 분류가 프로그래밍 이거나 주식 이거나 VBA인 서적 출력
SELECT *
FROM book_all
WHERE profile IN ('프로그래밍', '주식', 'VBA');

CREATE TABLE book_01 (
id NUMBER NOT NULL,
author VARCHAR2(50) NOT NULL,
profile VARCHAR2(50) NOT NULL,
PRIMARY KEY (id)
);
CREATE SEQUENCE seq_book_01 START WITH 20 INCREMENT BY 1 MINVALUE 1;

INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'박응용', '프로그래밍');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'WJY', '프로그래밍');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'Donghoon', '수학');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'초록우산', '데이타베이스');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'엑슬론', '주식');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'Soori', '금융');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'곽승주', 'VBA');
COMMIT;
SELECT * FROM book_01;

CREATE TABLE book_02 (
id NUMBER NOT NULL,
subject VARCHAR2(100) NOT NULL,
created DATE NOT NULL,
author_id NUMBER NOT NULL,
PRIMARY KEY (id)
-- FOREIGN KEY (author_id) REFERENCES book_01 (id)
);
CREATE SEQUENCE seq_book_02 START WITH 50 INCREMENT BY 1 MINVALUE 1;

INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'점프 투 파이썬', '2019-07-14', 20);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'점프 투 자바', '2018-08-25', 20);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'딥 러닝을 이용한 자연어 처리 입문', '2019-07-12', 21);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'공이의 수학정리노트', '2019-04-05', 22);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'예제로 배우는 ORACLE 11g', '2019-07-12', 23);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'주식 시장을 이기는 마법의 자동매매', '2019-03-16', 24);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'비트코인 개발자 가이드', '2018-02-24', 25);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'미국 금융공학 유학', '2019-07-12', 24);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'Deep Inside VBA', '2019-04-27', 26);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'CentOS 만들기', '2016-10-19', 20);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'Windows Server 만들기', '2017-08-09', 20);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'Python', '2022-07-27', 200);
COMMIT;
SELECT * FROM book_02;

-- 내부조인
SELECT book_02.id, book_02.subject, book_01.author, book_02.created, book_01.profile
FROM book_02 INNER JOIN book_01 ON book_02.author_id = book_01.id;

SELECT book_02.id, book_02.subject, book_01.author, book_02.created, book_01.profile
FROM book_01, book_02
WHERE book_01.id = book_02.author_id;

-- 외부조인
SELECT book_02.id, book_02.subject, book_01.author, book_02.created, book_01.profile
FROM book_02 LEFT OUTER JOIN book_01 ON book_02.author_id = book_01.id;

SELECT book_02.id, book_02.subject, book_01.author, book_02.created, book_01.profile
FROM book_01, book_02
WHERE book_01.id(+) = book_02.author_id;

-- 데이터 수정
UPDATE book_01 SET profile = 'PG' WHERE author = '박응용';
COMMIT;

-- 19년도 서적 출력
SELECT b2.id, b2.subject, b2.created,(SELECT author
             FROM book_01 b1
             WHERE b1.id = b2.author_id) author,
            (SELECT profile
             FROM book_01 b1
             WHERE b1.id = b2.author_id) profile
FROM book_02 b2
WHERE SUBSTR(created, 1, 2) = '19';

SELECT b2.id, b2.subject, b1.author, b2.created, b1.profile
FROM book_02 b2 INNER JOIN book_01 b1 ON b2.author_id = b1.id
WHERE SUBSTR(created, 1, 2) = '19';

CREATE TABLE book_03 (
id NUMBER NOT NULL,
memo VARCHAR2(50) NOT NULL,
wdate DATE NOT NULL,
author_id NUMBER NOT NULL,
PRIMARY KEY (ID),
FOREIGN KEY (author_id) REFERENCES book_01 (ID)
);
CREATE SEQUENCE seq_book_03 START WITH 1 INCREMENT BY 1 MINVALUE 1;