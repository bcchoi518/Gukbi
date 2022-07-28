-- 이름에 A가 포함된 모든 사원의 이름과 부서명을 출력
SELECT e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id AND LOWER(first_name) LIKE '%a%';

SELECT e.first_name, d.department_name
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id AND LOWER(first_name) LIKE '%a%';

SELECT first_name, (SELECT department_name
                    FROM departments
                    WHERE departments.department_id = employees.department_id) department_name
FROM employees
WHERE LOWER(first_name) LIKE '%a%';

-- US에 근무하는 사원출력하기
SELECT e.first_name, l.country_id
FROM locations l, departments d, employees e
WHERE d.location_id = l.location_id AND e.department_id = d.department_id AND l.country_id = 'US';

SELECT e.first_name, l.country_id
FROM locations l INNER JOIN departments d ON d.location_id = l.location_id
                 INNER JOIN employees e ON e.department_id = d.department_id
WHERE l.country_id = 'US';

-- London에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
SELECT e.first_name, e.job_id, e.department_id, d.department_name
FROM locations l,departments d, employees e
WHERE d.location_id = l.location_id AND e.department_id = d.department_id AND LOWER(l.city) = 'london';

SELECT e.first_name, e.job_id, e.department_id, d.department_name
FROM locations l RIGHT OUTER JOIN departments d ON d.location_id = l.location_id
                 RIGHT OUTER JOIN employees e ON e.department_id = d.department_id
WHERE LOWER(l.city) = 'london';

-- 사원이름, 부서장아이디, 부서장이름: 자체조인, self join
SELECT e.first_name, e.manager_id, m.employee_id, m.first_name
FROM employees e, employees m
WHERE e.manager_id = m.employee_id;

SELECT e.first_name, e.manager_id, m.employee_id, m.first_name
FROM employees e INNER JOIN employees m ON  e.manager_id = m.employee_id;

CREATE TABLE testMember (
memberNo NUMBER NOT NULL,
memberId VARCHAR2(50) NOT NULL,
memberName VARCHAR2(50) NOT NULL,
regiDate DATE NOT NULL
);
CREATE SEQUENCE seq_testMember START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

SELECT seq_testMember.CURRVAL FROM dual;
SELECT seq_testMember.NEXTVAL FROM dual;

ALTER TABLE testMember ADD PRIMARY KEY (memberId);
ALTER TABLE testMember ADD UNiQUE (memberNo);

SELECT * FROM testMember;

SELECT * FROM tab;

CREATE TABLE testDepartments
AS
    SELECT * FROM departments;
    
SELECT * FROM testDepartments;

DROP TABLE testDepartments CASCADE CONSTRAINTS; -- 위험(다른 테이블의 연관된 제약조건을 다 지워버림)

CREATE TABLE testEmployees
AS
    SELECT * FROM employees WHERE 1 = 0;
    
SELECT * FROM testEmployees;

DROP TABLE testEmployees CASCADE CONSTRAINTS;
DROP TABLE testMember CASCADE CONSTRAINTS;

CREATE TABLE testProduct (
no NUMBER NOT NULL, -- 상품번호, 시퀀스사용
productId VARCHAR2(50) NOT NULL,
vendorId VARCHAR2(50) NOT NULL,
productName VARCHAR2(50) NOT NULL,
productPrice NUMBER NOT NULL,
productDesc CLOB,
wDate DATE DEFAULT SYSDATE
);
CREATE SEQUENCE seq_testProduct START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

INSERT INTO testProduct (no, productId, vendorId, productName, productPrice, productDesc, wDate)
       VALUES (seq_testProduct.NEXTVAL, 'P001', 'SEC', '무풍에어컨', 1400000, '바람없는 에어컨', SYSDATE);
       
INSERT INTO testProduct (no, productId, vendorId, productName, productPrice, productDesc)
       VALUES (seq_testProduct.NEXTVAL, 'P002', 'LG', '창문형에어컨', 700000, '창틀에 설치하는 에어컨');
       
INSERT INTO testProduct
       VALUES (seq_testProduct.NEXTVAL, 'P003', 'Winia', '위니아 에어컨', 1000000, '위니아 에어컨', null);
       
ALTER TABLE testProduct ADD bigo VARCHAR2(50);

INSERT INTO testProduct
       VALUES (seq_testProduct.NEXTVAL, 'P004', '갤럭시01', '갤럭시01', 1000000, '갤럭시01', SYSDATE);
       
INSERT INTO testProduct (no, productId, vendorId, productName, productPrice, productDesc)
       VALUES (seq_testProduct.NEXTVAL, 'P005', 'LG5', '창문형에어컨5', 500000, '창틀에 설치하는 에어컨5');
       
SELECT * FROM testProduct;

DROP TABLE testProduct;

SELECT constraint_name FROM user_constraints;

CREATE TABLE testExample01 (
    col1 VARCHAR2(10),
    col2 VARCHAR2(10) NOT NULL
);

CREATE TABLE testExample02 (
    col1 VARCHAR2(10),
    col2 VARCHAR2(10) CONSTRAINT col2_notNull NOT NULL --제약조건 이름 지정
);

CREATE TABLE testExample03 (
    col1 VARCHAR2(10) UNIQUE,
    col2 VARCHAR2(10) UNIQUE NOT NULL,
    col3 VARCHAR2(10) CONSTRAINT col3_unique UNIQUE
);

CREATE TABLE testExample04 (
    col1 VARCHAR2(10),
    col2 VARCHAR2(10),
    col3 VARCHAR2(10),
    PRIMARY KEY (col1, col2) --슈퍼키
);

CREATE TABLE testExample05 (
    col1 VARCHAR2(10),
    col2 VARCHAR2(10),
    col3 VARCHAR2(10),
    CONSTRAINT pk_testExample05 PRIMARY KEY (col1, col2)
);

SELECT table_name FROM user_tables;

CREATE TABLE testExample06 (
    col1 VARCHAR2(10) NOT NULL,
    col2 VARCHAR2(10) NOT NULL,
    PRIMARY KEY (col1)
);

CREATE TABLE testExample07 (
    col3 VARCHAR2(10) NOT NULL,
    col4 VARCHAR2(10) NOT NULL,
    col5 VARCHAR2(10) NOT NULL,
    PRIMARY KEY (col3),
    FOREIGN KEY (col5) REFERENCES testExample06(col1)
);

INSERT INTO testExample06 (col1, col2) VALUES ('1', '11');
SELECT * FROM testExample06;
INSERT INTO testExample07 (col3, col4, col5) VALUES ('a', 'aa', '1');
SELECT * FROM testExample07;
ROLLBACK;

CREATE TABLE testProduct (
no NUMBER NOT NULL, -- 상품번호, 시퀀스사용
productId VARCHAR2(50) NOT NULL,
vendorId VARCHAR2(50) NOT NULL,
productName VARCHAR2(50) NOT NULL,
productPrice NUMBER NOT NULL,
productDesc CLOB,
wDate DATE DEFAULT SYSDATE
);

SELECT * FROM testProduct;

ALTER TABLE testProduct ADD vendorPhone CHAR(20);

desc testProduct;

ALTER TABLE testProduct MODIFY productId VARCHAR2(100);

ALTER TABLE testProduct MODIFY vendorId NUMBER;

ALTER TABLE testProduct RENAME COLUMN vendorId to vendorName;

ALTER TABLE testProduct DROP COLUMN vendorName;

ALTER TABLE testProduct SET UNUSED (vendorPhone);

SELECT * FROM testProduct;

ALTER TABLE testProduct DROP UNUSED COLUMNS;

CREATE TABLE testEmployees
AS
    SELECT * FROM employees WHERE 1=0;
    
INSERT INTO testEmployees
    SELECT * FROM employees;
    
SELECT * FROM testEmployees;

DELETE FROM testEmployees;
COMMIT;

TRUNCATE TABLE testEmployees;

DROP TABLE testEmployees;

-- 뷰
CREATE VIEW v_testEmployee(사번, 사원이름, 부서번호, 담당업무)
AS 
    SELECT employee_id, first_name, department_id, job_id
    FROM testEmployees;
    
SELECT * FROM user_views;

SELECT * FROM v_testEmployee;

SELECT * 
FROM v_testEmployee
WHERE 사번 BETWEEN 100 AND 105;

DROP VIEW v_testEmployee;

CREATE TABLE testDepartments
AS
    SELECT * FROM departments;
    
SELECT * FROM testEmployees;
SELECT * FROM testDepartments;
SELECT * FROM testEmployees NATURAL JOIN testDepartments;

-- 뷰에서 집계함수를 사용하려면 반드시 별칭을 사용해야 한다.
CREATE VIEW v_employees_salary02
AS
    SELECT department_id, SUM(salary) sum_sal, ROUND(AVG(salary)) avg_sal
    FROM testEmployees
    GROUP BY department_id;
    
SELECT * FROM v_employees_salary02;

-- WITH CHECK OPTION을 사용하면, 해당 뷰를 통해서 볼 수 있는 범위 내에서만 UPDATE 또는 INSERT가 가능하다.
-- WITH READ ONLY
-- SELECT만 가능하고, INSERT, UPDATE, DELETE는 불가...
-- 이옵션을 지정하지 않으면 INSERT, UPDATE, DELETE는 가능...
DROP TABLE TBLMEMBER;
CREATE TABLE TBLMEMBER (
id VARCHAR2(50),
passwd VARCHAR2(50),
name VARCHAR2(50),
phone VARCHAR2(50),
email VARCHAR2(50)
);

CREATE OR REPLACE VIEW v_tblMember (id, passwd, name)
AS
    SELECT id, passwd, name FROM tblMember WITH READ ONLY;
    
SELECT * FROM user_views;

INSERT INTO v_tblMember (id, passwd, name) VALUES ('hong', '1234', '홍길동');
COMMIT;

SELECT * FROM v_tblMember;

-- 프로시저: 스토어드프로시저, Stored procedure
SELECT (SELECT COUNT(*) FROM employees) + (SELECT COUNT(*) FROM departments)
FROM dual;

CREATE OR REPLACE PROCEDURE p_counter
AS
    var1 INT;
    var2 INT;
    var3 INT;
BEGIN
    SELECT COUNT(*) INTO var1 FROM employees;
    SELECT COUNT(*) INTO var2 FROM departments;
    SELECT COUNT(*) INTO var3 FROM locations;
    DBMS_OUTPUT.PUT_LINE(var1 + var2 + var3);
END;
/

DROP PROCEDURE p_counter;

SELECT * FROM user_source;

SET SERVEROUTPUT ON;
EXECUTE p_counter;