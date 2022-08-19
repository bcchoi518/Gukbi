--[1.1]
CREATE OR REPLACE PROCEDURE pc_totalTableCounter (v_totalTable OUT NUMBER)
AS
    v_count_countries NUMBER;
    v_count_departments NUMBER;
    v_count_employees NUMBER;
    v_count_job_history NUMBER;
    v_count_jobs NUMBER;
    v_count_locations NUMBER;
    v_count_regions NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count_countries FROM countries;
    SELECT COUNT(*) INTO v_count_departments FROM departments;
    SELECT COUNT(*) INTO v_count_employees FROM employees;
    SELECT COUNT(*) INTO v_count_job_history FROM job_history;
    SELECT COUNT(*) INTO v_count_jobs FROM jobs;
    SELECT COUNT(*) INTO v_count_locations FROM locations;
    SELECT COUNT(*) INTO v_count_regions FROM regions;
    
    v_totalTable := v_count_countries + v_count_departments + v_count_employees
                  + v_count_job_history + v_count_jobs + v_count_locations + v_count_regions;
    
END pc_totalTableCounter;
/


VARIABLE v_totalTable NUMBER;
EXECUTE pc_totalTableCounter(:v_totalTable);
PRINT v_totalTable;



--[1.2]
CREATE OR REPLACE FUNCTION fc_search_salary
(
    v_first_name IN employees.first_name%TYPE,
    v_last_name IN employees.last_name%TYPE
)
RETURN NUMBER
AS
    v_salary employees.salary%TYPE;
BEGIN
    SELECT salary INTO v_salary
    FROM employees
    WHERE first_name = v_first_name AND last_name = v_last_name;
    
    RETURN v_salary;
END fc_search_salary;
/

VARIABLE v_salary NUMBER;
EXECUTE :v_salary := fc_search_salary('Steven','King');
PRINT v_salary;

--[1.3]
CREATE TABLE dept_original AS SELECT * FROM departments WHERE 0=1;
CREATE TABLE dept_copy AS SELECT * FROM departments WHERE 0=1;

CREATE OR REPLACE TRIGGER tr_auto_insert
AFTER INSERT
ON dept_original
FOR EACH ROW
BEGIN
    INSERT INTO dept_copy
    VALUES (:NEW.department_id, :NEW.department_name, :NEW.manager_id, :NEW.location_id);
END tr_auto_insert;
/

INSERT INTO dept_original VALUES (1, '트리거문제첫번째문장', 1, 1);
INSERT INTO dept_original VALUES (2, '트리거문제두번째문장', 2, 2);

SELECT * 
FROM dept_original do, dept_copy dc
WHERE do.department_id = dc.department_id;

--[2.1]
CREATE TABLE pivotTest(
    uName NCHAR(3),
    season NCHAR(2),
    amount NUMBER(3)
);
INSERT INTO pivotTest VALUES ('이성순', '겨울', 10);
INSERT INTO pivotTest VALUES ('장천용', '여름', 15);
INSERT INTO pivotTest VALUES ('이성순', '가을', 25);
INSERT INTO pivotTest VALUES ('이성순', '봄', 3);
INSERT INTO pivotTest VALUES ('이성순', '봄', 37);
INSERT INTO pivotTest VALUES ('장천용', '겨울', 40);
INSERT INTO pivotTest VALUES ('이성순', '여름', 14);
INSERT INTO pivotTest VALUES ('이성순', '겨울', 22);
INSERT INTO pivotTest VALUES ('장천용', '여름', 64);

SELECT * FROM pivotTest;

SELECT uName, season, SUM(amount)
FROM pivotTest
GROUP BY uName, season
ORDER BY uName;