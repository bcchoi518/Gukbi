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
--DB설계 끝

INSERT INTO MEMBER VALUES (seq_member.NEXTVAL, 'hong', '1234', '홍길동', '1234561234567', '01012345678', 'hong@mail.com', '대구', sysdate);
INSERT INTO MEMBER VALUES (seq_member.NEXTVAL, 'lee', '1234', '이성순', '1236541237654', '01043218756', 'lee@mail.com', '서울', sysdate);
INSERT INTO MEMBER VALUES (seq_member.NEXTVAL, 'jang', '1234', '장천용', '1324561324576', '01011112222', 'jang@mail.com', '경기', sysdate);

TRUNCATE TABLE MEMBER;

SELECT MAX(memberNo) FROM MEMBER;

SELECT * FROM MEMBER;