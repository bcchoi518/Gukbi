--[1.1]
CREATE TABLE sangpum (
    s_id VARCHAR2(10) NOT NULL,
    s_name VARCHAR2(30) NOT NULL,
    s_price NUMBER NOT NULL,
    m_id VARCHAR2(10) NOT NULL
);


CREATE TABLE maker (
    m_id VARCHAR2(10) NOT NULL,
    m_name VARCHAR2(30) NOT NULL,
    m_mobile VARCHAR2(50) NOT NULL
);


ALTER TABLE sangpum ADD CONSTRAINT s_id_pk PRIMARY KEY (s_id);


ALTER TABLE maker ADD CONSTRAINT m_id_pk PRIMARY KEY (m_id);


ALTER TABLE sangpum ADD CONSTRAINT m_id_fk 
FOREIGN KEY (m_id) REFERENCES maker (m_id);


--[1.2]
INSERT INTO maker (m_id, m_name, m_mobile)
VALUES ('S01', '삼성', '1500-0101');
INSERT INTO maker (m_id, m_name, m_mobile)
VALUES ('L02', 'LG', '1500-0102');
INSERT INTO maker (m_id, m_name, m_mobile)
VALUES ('H03', '현대', '1500-0103');


INSERT INTO sangpum (s_id, s_name, s_price, m_id)
VALUES ('P01', '노트북', 1000, 'S01');
INSERT INTO sangpum (s_id, s_name, s_price, m_id)
VALUES ('P02', '공기청정기', 2000, 'S01');
INSERT INTO sangpum (s_id, s_name, s_price, m_id)
VALUES ('P03', '청소기', 2000, 'L02');
INSERT INTO sangpum (s_id, s_name, s_price, m_id)
VALUES ('P04', '에어콘', 2500, 'L02');
INSERT INTO sangpum (s_id, s_name, s_price, m_id)
VALUES ('P05', '그랜저', 5000, 'H03');


UPDATE maker SET m_name = '엘지' WHERE m_name = 'LG';


DELETE FROM sangpum WHERE s_name = '그랜저';


SELECT * FROM sangpum WHERE s_price >= 2000 AND m_id = 'L02';


COMMIT;


--[1.3]
DELETE FROM sangpum WHERE s_name = '공기청정기';


ROLLBACK;


--[2.1]
CREATE INDEX idx_mname ON maker (m_name);


--[2.2]
CREATE OR REPLACE VIEW v_test
AS
    SELECT m_name 제조사이름, m_mobile 제조사전화번호,
           s_name 제품이름, s_price 제품가격
    FROM maker m, sangpum s
    WHERE m.m_id = s.m_id;
SELECT * FROM v_test;


--[2.3]
SELECT m_name 제조사이름, m_mobile 제조사전화번호, 
        (SELECT SUM(s_price) 
         FROM sangpum
         WHERE sangpum.m_id = maker.m_id) 제조사의제품가격합계
FROM maker;


SELECT m.m_name 제조사이름, m.m_mobile 제조사전화번호,
       s.s_name 제품이름, s.s_price 제품가격
FROM maker m INNER JOIN sangpum s ON m.m_id = s.m_id;