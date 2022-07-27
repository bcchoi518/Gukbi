CREATE TABLE book_all (
id NUMBER NOT NULL,
subject VARCHAR2(50) NOT NULL,
author VARCHAR2(50) NOT NULL,
created DATE NOT NULL,
profile VARCHAR2(50) NOT NULL
);

INSERT INTO book_all VALUES (1,'���� �� ���̽�', '������', '2019-07-14', '���α׷���');
INSERT INTO book_all VALUES (2,'���� �� �ڹ�', '������', '2018-08-25', '���α׷���');
INSERT INTO book_all VALUES (3,'�� ������ �̿��� �ڿ��� ó�� �Թ�', 'WJY', '2019-07-12', '���α׷���');
INSERT INTO book_all VALUES (4,'������ ����������Ʈ', 'Donghoon', '2019-04-05', '����');
INSERT INTO book_all VALUES (5,'������ ���� ORACLE 11g', '�ʷϿ��', '2019-07-12', '����Ÿ���̽�');
INSERT INTO book_all VALUES (6,'�ֽ� ������ �̱�� ������ �ڵ��Ÿ�', '������', '2019-03-16', '�ֽ�');
INSERT INTO book_all VALUES (7,'��Ʈ���� ������ ���̵�', 'Soori', '2018-02-24', '����');
INSERT INTO book_all VALUES (8,'�̱� �������� ����', '������', '2019-07-12', '�ֽ�');
INSERT INTO book_all VALUES (9,'Deep Inside VBA', '������', '2019-04-27', 'VBA');
INSERT INTO book_all VALUES (10,'CentOS �����', '������', '2016-10-19', '���α׷���');
INSERT INTO book_all VALUES (11,'Windows Server �����', '������', '2017-08-09', '���α׷���');
COMMIT;
SELECT * FROM book_all;

-- ���ڰ� �������� ���� ���
SELECT *
FROM book_all
WHERE author = '������';

-- ����⵵�� 2019�⵵�� ���� ���
SELECT *
FROM book_all
WHERE created BETWEEN '19/01/01' AND '19/12/31';

-- �з��� ����
SELECT COUNT(DISTINCT profile)
FROM book_all;

-- �з� ��� (�ߺ�����)
SELECT DISTINCT profile
FROM book_all;

-- ���ڰ� ������ �̰ų� �з��� ������ ���� ���
SELECT *
FROM book_all
WHERE author = '������' OR profile = '����';

-- ����Ŭ�� ���õ� ������ �ִ� ���� ���
SELECT *
FROM book_all
WHERE subject LIKE '%����Ŭ%' OR LOWER(subject) LIKE '%oracle%';

-- �з��� ���α׷��� �̰ų� �ֽ� �̰ų� VBA�� ���� ���
SELECT *
FROM book_all
WHERE profile IN ('���α׷���', '�ֽ�', 'VBA');

CREATE TABLE book_01 (
id NUMBER NOT NULL,
author VARCHAR2(50) NOT NULL,
profile VARCHAR2(50) NOT NULL,
PRIMARY KEY (id)
);
CREATE SEQUENCE seq_book_01 START WITH 20 INCREMENT BY 1 MINVALUE 1;

INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'������', '���α׷���');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'WJY', '���α׷���');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'Donghoon', '����');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'�ʷϿ��', '����Ÿ���̽�');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'������', '�ֽ�');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'Soori', '����');
INSERT INTO book_01 VALUES (seq_book_01.NEXTVAL,'������', 'VBA');
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

INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'���� �� ���̽�', '2019-07-14', 20);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'���� �� �ڹ�', '2018-08-25', 20);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'�� ������ �̿��� �ڿ��� ó�� �Թ�', '2019-07-12', 21);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'������ ����������Ʈ', '2019-04-05', 22);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'������ ���� ORACLE 11g', '2019-07-12', 23);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'�ֽ� ������ �̱�� ������ �ڵ��Ÿ�', '2019-03-16', 24);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'��Ʈ���� ������ ���̵�', '2018-02-24', 25);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'�̱� �������� ����', '2019-07-12', 24);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'Deep Inside VBA', '2019-04-27', 26);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'CentOS �����', '2016-10-19', 20);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'Windows Server �����', '2017-08-09', 20);
INSERT INTO book_02 VALUES (seq_book_02.NEXTVAL,'Python', '2022-07-27', 200);
COMMIT;
SELECT * FROM book_02;

-- ��������
SELECT book_02.id, book_02.subject, book_01.author, book_02.created, book_01.profile
FROM book_02 INNER JOIN book_01 ON book_02.author_id = book_01.id;

SELECT book_02.id, book_02.subject, book_01.author, book_02.created, book_01.profile
FROM book_01, book_02
WHERE book_01.id = book_02.author_id;

-- �ܺ�����
SELECT book_02.id, book_02.subject, book_01.author, book_02.created, book_01.profile
FROM book_02 LEFT OUTER JOIN book_01 ON book_02.author_id = book_01.id;

SELECT book_02.id, book_02.subject, book_01.author, book_02.created, book_01.profile
FROM book_01, book_02
WHERE book_01.id(+) = book_02.author_id;

-- ������ ����
UPDATE book_01 SET profile = 'PG' WHERE author = '������';
COMMIT;

-- 19�⵵ ���� ���
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