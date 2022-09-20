DECLARE
n NUMBER := 6;
BEGIN
    LOOP
    DBMS_OUTPUT.PUT_LINE(n);
    n := n+1;
    insert into board values (seq_board.nextval, n, 'onebyone', n, n, n, n, n, n, 1, 1, 0, 0, '127.0.0.1', 0, 0, 'F', sysdate, '-');
    commit;
    EXIT WHEN n >= 11; -- 1000
    END LOOP;
END;
/

CREATE TABLE boardChk (
    boardChkNo NUMBER NOT NULL,
    tbl VARCHAR2(50) NOT NULL,
    tblName VARCHAR2(50) NOT NULL,
    regiDate DATE DEFAULT SYSDATE,
    PRIMARY KEY (tbl),
    UNIQUE (boardChkNo)
);

CREATE SEQUENCE seq_boardChk START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

SELECT * FROM boardChk;