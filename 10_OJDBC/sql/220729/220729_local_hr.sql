-- 프로시저
-- AS가 들어갈때: create table, create view, procedure

--CREATE OR REPLACE PROCEDURE 프로시저명(매개변수)
--AS 
--    변수1선언;
--    변수2선언;
--BEGIN 
--    실행문1;
--    실행문2;
--END;
--/

CREATE OR REPLACE PROCEDURE sp_salaryEname(
-- in: 변수 안에 값을 넣겠다.
-- table.column%type: 해당 column의 type과 같은 type으로 하겠다.
    v_first_name in employees.first_name%TYPE,
    v_last_name in employees.last_name%TYPE
)
AS 
    v_salary employees.salary%TYPE;
BEGIN 
    SELECT salary INTO v_salary
      FROM employees
     WHERE first_name = v_first_name AND last_name = v_last_name;
     DBMS_OUTPUT.put_line(v_first_name || ' ' || v_last_name || '의 급여는 ' ||v_salary || '입니다.');
END;
/

SET SERVEROUTPUT ON;
EXECUTE sp_salaryEname('Steven','King');

---------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE sp_salaryEname2(
    v_first_name IN employees.first_name%TYPE,
    v_last_name IN employees.last_name%TYPE,
    v_salary OUT employees.salary%TYPE
)
AS
BEGIN
    SELECT salary INTO v_salary
      FROM employees
     WHERE first_name = v_first_name AND last_name = v_last_name;
END;
/

SET SERVEROUTPUT ON;
VARIABLE v_salary VARCHAR2(20);
EXECUTE sp_salaryEname2('Steven','King', :v_salary);
PRINT v_salary;

---------------------------------------------------------------------------------------------

CREATE TABLE testEmployees
AS 
    SELECT * FROM employees;

SELECT * FROM testEmployees;

CREATE OR REPLACE PROCEDURE sp_updateSalary(v_employee_id IN NUMBER)
IS
BEGIN
    UPDATE testEmployees SET salary = (salary * 1.1) WHERE employee_id = v_employee_id;
END;
/

SELECT * FROM testEmployees WHERE employee_id = 200;

EXECUTE sp_updateSalary(200);

---------------------------------------------------------------------------------------------

-- 메모장
CREATE TABLE testMemo (
idx NUMBER PRIMARY KEY,
writer VARCHAR2(50) NOT NULL,
memo VARCHAR2(500) NOT NULL,
wdate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_testMemo START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

INSERT INTO testMemo (idx, writer, memo) VALUES (seq_testMemo.NEXTVAL, 'hong', 'test001');
INSERT INTO testMemo (idx, writer, memo) VALUES (seq_testMemo.NEXTVAL, 'lee', 'test002');
COMMIT;

CREATE OR REPLACE PROCEDURE testMemoInsert(
    v_writer IN testmemo.writer%TYPE,
    v_memo IN testmemo.memo%TYPE
)
AS
BEGIN
    INSERT INTO testMemo (idx, writer, memo) VALUES (seq_testMemo.NEXTVAL, v_writer, v_memo);
    COMMIT;
END;
/

EXECUTE testMemoInsert('jang','test003');
EXECUTE testMemoInsert('kim','test004');

SELECT *
  FROM testMemo;
  
---------------------------------------------------------------------------------------------

CREATE TABLE testMember (
id VARCHAR2(50) NOT NULL,
passwd VARCHAR2(50) NOT NULL,
name VARCHAR2(50) NOT NULL,
email VARCHAR2(50) NOT NULL,
addr VARCHAR2(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE OR REPLACE PROCEDURE sp_testMember (
    v_id IN testMember.id%TYPE,
    v_passwd IN testMember.passwd%TYPE,
    v_name IN testMember.name%TYPE,
    v_email IN testMember.email%TYPE,
    v_addr IN testMember.addr%TYPE
)
AS
BEGIN
    INSERT INTO testMember (id, passwd, name, email, addr) VALUES (v_id, v_passwd, v_name, v_email, v_addr);
    COMMIT;
END;
/

EXECUTE sp_testMember('hong', '1234', '홍길동', 'hong@mail.com', '대구');
EXECUTE sp_testMember('lee', '1234', '이성순', 'lee@mail.com', '구미');

SELECT *
  FROM testMember;
  
---------------------------------------------------------------------------------------------

-- Cursor
-- SELECT의 결과가 하나인 행인 경우는 INTO절을 이용해서 변수에 저장할 수 있다.
-- 그러나, 복수행일 경우는 INTO절을 사용할 수가 없다.
-- 이렇게 복수행의 결과를 행단위로 처리하기 위해 사용하는것이 커서이다.

-- %NOTFOUND: 커서 영역의 자료가 모두 FETCH 되었다면 TRUE.
-- %FOUND: 커서 영역에 FETCH 되지 않은 자료가 있다면 TRUE.
-- %ISOPEN: 커서가 OPEN된 상태이면 TRUE.
-- %ROWCOUNT: 커서가 얻어 온 레코드 갯수.

-- FETCH: 커서에서 원하는 결과값을 추출하는 것.
-- DECLARE: 한번 선언하고 사용하면 끝
DECLARE
    v_dept departments%ROWTYPE;
    CURSOR c1
    IS
        SELECT department_id, department_name, location_id FROM departments;
BEGIN
    DBMS_OUTPUT.PUT_LINE('부서번호     부서명     지역아이디');
    DBMS_OUTPUT.PUT_LINE('------------------------------');
    OPEN c1;
        LOOP
            FETCH c1 INTO v_dept.department_id, v_dept.department_name, v_dept.location_id;
            EXIT WHEN c1%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(v_dept.department_id || '     ' || v_dept.department_name || '     ' || v_dept.location_id);
        END LOOP;
    CLOSE c1;
END;
/

CREATE OR REPLACE PROCEDURE cursor_c2
AS
    v_dept departments%ROWTYPE;
    CURSOR c2
    IS
        SELECT department_id, department_name, location_id FROM departments;
BEGIN
    DBMS_OUTPUT.PUT_LINE('부서번호     부서명     지역아이디');
    DBMS_OUTPUT.PUT_LINE('------------------------------');
    OPEN c2;
        LOOP
            FETCH c2 INTO v_dept.department_id, v_dept.department_name, v_dept.location_id;
            EXIT WHEN c2%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(v_dept.department_id || '     ' || v_dept.department_name || '     ' || v_dept.location_id);
        END LOOP;
    CLOSE c2;
END;
/

EXECUTE cursor_c2;

DECLARE
    v_dept departments%ROWTYPE;
    CURSOR c1
    IS
        SELECT department_id, department_name, location_id FROM departments;
BEGIN
    DBMS_OUTPUT.PUT_LINE('부서번호     부서명     지역아이디');
    DBMS_OUTPUT.PUT_LINE('------------------------------');
    FOR v_dept IN c1 LOOP
        EXIT WHEN c1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_dept.department_id || '     ' || v_dept.department_name || '     ' || v_dept.location_id);
    END LOOP;
END;
/

---------------------------------------------------------------------------------------------

-- 함수
CREATE OR REPLACE FUNCTION fn_salary_ename (
    v_first_name IN employees.first_name%TYPE,
    v_last_name IN employees.last_name%TYPE
)
    RETURN NUMBER
AS
    v_salary NUMBER(7, 2);
BEGIN
    SELECT salary INTO v_salary
    FROM employees
    WHERE first_name = v_first_name AND last_name = v_last_name;
    RETURN v_salary;
END;
/

VARIABLE v_salary NUMBER;
EXECUTE :v_salary := fn_salary_ename('Steven','King');
PRINT v_salary;

SELECT employee_id, first_name, fn_salary_ename('Steven','King')
  FROM employees
 WHERE first_name = 'Steven' AND last_name = 'King';
 
---------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION fn_updateSalary(
    v_employee_id IN employees.salary%TYPE
)
    RETURN NUMBER
AS
    v_salary number(7,2);
BEGIN
    UPDATE testEmployees SET salary = (salary * 1.1) WHERE employee_id = v_employee_id;
    COMMIT;
    SELECT salary INTO v_salary FROM testEmployees WHERE employee_id = v_employee_id;
    RETURN v_salary;
END;
/

SELECT * FROM testEmployees WHERE employee_id = 200;

VARIABLE v_salary NUMBER;
EXECUTE :v_salary := fn_updateSalary(200);
PRINT v_salary;

---------------------------------------------------------------------------------------------
SELECT TABLE_NAME FROM USER_TABLES;
-- 트리거
CREATE OR REPLACE TRIGGER triggerSample1
    AFTER INSERT
    ON testDepartments
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('INSERT 트리거 발생');
    INSERT INTO testDepartmentsCopy VALUES (
        :NEW.department_id,
        :NEW.department_name,
        :NEW.manager_id,
        :NEW.location_id
    );
END;
/

INSERT INTO testDepartments VALUES ('10', 'ACCOUNTING', '3', '5');

CREATE OR REPLACE TRIGGER triggerSample2
    AFTER DELETE
    ON testDepartments
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('DELETE 트리거 발생');
    DELETE FROM testDepartmentsCopy
    WHERE testDepartmentsCopy.department_id = :old.department_id;
END;
/

INSERT INTO testDepartments VALUES ('20', 'Design', '3', '5');
DELETE FROM testDepartments WHERE department_id = '10';

SELECT * FROM testDepartments;
SELECT * FROM testDepartmentsCopy;

---------------------------------------------------------------------------------------------

CREATE TABLE testDepartments01 (
id VARCHAR2(10) PRIMARY KEY,
name VARCHAR2(15) NOT NULL,
location VARCHAR2(50)
);

INSERT INTO testDepartments01 VALUES ('10', '영업부', '서울 강남구');
SAVEPOINT a;
INSERT INTO testDepartments01 VALUES ('20', '회계부', '부산 동래구');
SAVEPOINT b;
INSERT INTO testDepartments01 VALUES ('30', '개발부', '대구 동구');
SAVEPOINT c;

SELECT * FROM testdepartments01;
ROLLBACK TO a;
rollback;