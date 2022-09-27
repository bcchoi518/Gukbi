CREATE TABLE testMember (
    id VARCHAR2(50) NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    changeDate DATE DEFAULT sysdate NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO testMember
VALUES ('hong', '1234', to_date('2022-01-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO testMember
VALUES ('kim', '1234', to_date('2022-07-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'));

COMMIT;

SELECT * FROM testMember;
delete from testMember;

SELECT id, trunc(months_between(sysdate, changeDate)) from testMember;
SELECT id, round(months_between(sysdate, changeDate)) from testMember;

select * from board;