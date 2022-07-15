CREATE TABLE MEMBER (
	memberno		NUMBER		 NOT NULL,
	memberid		VARCHAR2(50) NOT NULL,
	memberpasswd	VARCHAR2(50) NOT NULL,
	membername		VARCHAR2(50) NOT NULL,
	memberjumin		VARCHAR2(50) NOT NULL,
	memberphone		VARCHAR2(50) NOT NULL,
	memberemail		VARCHAR2(50) NOT NULL,
	memberaddress	VARCHAR2(50) NOT NULL,
	regidate		DATE		 NOT NULL,
	UNIQUE (memberno),
	PRIMARY KEY (memberid),
	UNIQUE (memberjumin)
);

CREATE SEQUENCE seq_member START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
--DB���� ��

INSERT INTO MEMBER VALUES (seq_member.NEXTVAL, 'hong', '1234', 'ȫ�浿', '1234561234567', '01012345678', 'hong@mail.com', '�뱸', sysdate);
INSERT INTO MEMBER VALUES (seq_member.NEXTVAL, 'lee', '1234', '�̼���', '1236541237654', '01043218756', 'lee@mail.com', '����', sysdate);
INSERT INTO MEMBER VALUES (seq_member.NEXTVAL, 'jang', '1234', '��õ��', '1324561324576', '01011112222', 'jang@mail.com', '���', sysdate);

TRUNCATE TABLE MEMBER;

SELECT MAX(memberNo) FROM MEMBER;

SELECT * FROM MEMBER;