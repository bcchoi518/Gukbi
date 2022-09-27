CREATE TABLE member (
    id VARCHAR2(50) NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    changeDate DATE DEFAULT sysdate NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO member
VALUES ('hong', '1234', To_Date('2020-01-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO member
VALUES ('kim', '0987', TO_DATE('2020-07-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'));

COMMIT;

SELECT * FROM member;
delete from member;

SELECT id, trunc(months_between(sysdate, changeDate)) from member;
SELECT id, ROUND(MONTHS_BETWEEN(sysdate, changeDate)) from member where id = 'hong';