-- first_name을 오름차순으로 정렬하여 출력 단 이름이 같다면 salary를 오름차순으로 정렬하여 출력
SELECT *
FROM employees
ORDER BY first_name asc, salary asc;

-- count(*)은 전체 레코드를 count한다.
SELECT count(*)
FROM employees;

-- count(필드명)은 null을 count하지 않는다.
SELECT count(commission_pct)
FROM employees;

-- 문자열 함수
-- lower, upper, initcap(영단어의 첫글자를 대문자로 나머지는 소문자로)
SELECT upper('korea')
FROM dual;
SELECT initcap('welCOME to mY sitE !!!')
FROM dual;

-- length: 문자열의 길이
SELECT LENGTH('korea')
FROM dual;
SELECT first_name, LENGTH(first_name) first_name_length, salary
FROM employees;

-- SUBSTR: 문자열 자르기
SELECT SUBSTR('Welcome to Oracle', -4, 3)
FROM dual;
SELECT first_name
FROM employees
--WHERE first_name LIKE '%a';
--WHERE SUBSTR(first_name, -1, 1) = 'a';
WHERE SUBSTR(first_name, LENGTH(first_name), 1) = 'a';
SELECT first_name
FROM employees
--WHERE first_name LIKE '%na';
--WHERE SUBSTR(first_name, -2, 2) = 'na';
WHERE SUBSTR(first_name, LENGTH(first_name)-1, 2) = 'na';
SELECT *
FROM employees
WHERE SUBSTR(hire_date, 1, 2) = '05';

-- INSTR: 해당 문자의 인덱스 위치를 찾기
SELECT INSTR('WELCOME TO ORACLE', 'O'), INSTR('WELCOME TO ORACLE', 'O', 6, 2)
FROM dual;
SELECT INSTR('WELCOME TO ORACLE', 'TO')
FROM dual;

-- LPAD, RPAD
SELECT LPAD('Oracle', 20, '#')
FROM dual;

-- TRIM, LTRIM, RTRIM
SELECT LTRIM('     Oracle')
FROM dual;
SELECT RTRIM('Oracle     ')
FROM dual;
SELECT TRIM('     Oracle     ')
FROM dual;

-- 필드(문자열) 결합: concat(오라클에서는 2개까지만 가능), ||
SELECT CONCAT('korea ', 'fighting')
FROM dual;
SELECT 'korea' || ' team ' || 'fighting'
FROM dual;

-- REPLACE
SELECT REPLACE('abcdefg', 'c', '000')
FROM dual;

-- 숫자 함수
-- ABS, FLOOR, ROUND, CEIL, TRUNC
SELECT -10, ABS(-10)
FROM dual;
SELECT 34.5678, FLOOR(34.5678)
FROM dual;
SELECT 34.5678, ROUND(34.5678, 2)
FROM dual;
SELECT 34.5678, ROUND(34.5678, -1)
FROM dual;
SELECT 34.5678, CEIL(34.5678)
FROM dual;
SELECT TRUNC(34.5678, 2), TRUNC(34.5678, -1), TRUNC(34.5678)
FROM dual;

-- MOD: 나머지 구하기
SELECT MOD(27, 2), MOD(27, 5)
FROM dual;

-- 날짜 함수
SELECT SYSDATE-1 어제, SYSDATE 오늘, SYSDATE+1 내일
FROM dual;

-- 사원별로 근무일수 출력
SELECT first_name, hire_date, ROUND(sysdate - hire_date) 근무일수
FROM employees;

-- ROUND(date, format), TRUNC(date, format)
SELECT hire_date, ROUND(hire_date, 'MONTH')
FROM employees;
SELECT hire_date, TRUNC(hire_date, 'MONTH')
FROM employees;

-- 사원별로 근무일수 출력(개월수)
SELECT  first_name,
        sysdate, 
        hire_date, 
        MONTHS_BETWEEN(SYSDATE, hire_date), 
        TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date)),
        FLOOR(MONTHS_BETWEEN(SYSDATE, hire_date)),
        ROUND(MONTHS_BETWEEN(SYSDATE,hire_date))
FROM employees;

-- ADD_MONTHS
SELECT hire_date, ADD_MONTHS(hire_date, 6)
FROM employees;

-- NEXT_DAY
SELECT SYSDATE, NEXT_DAY(SYSDATE, '월요일')
FROM dual;

-- LAST_DAY
SELECT hire_date, LAST_DAY(hire_date)
FROM employees;


-- 각 사원들에 대해서 사원의 이름과 근속연수를 나타내시오. 단, 근속연수는 연단위를 버림하시오.
SELECT first_name, hire_date, FLOOR(MONTHS_BETWEEN(SYSDATE, hire_date) / 12) 근속연수
FROM employees;

-- 오늘을 기준으로 100일전과 100일후를 구하시오.
SELECT SYSDATE-100 "100일 전", SYSDATE+100 "100일 후"
FROM dual;

-- ROWNUM: 행(레코드)번호
-- ROWID: ROUNUM의 주소값
SELECT ROWNUM, ROWID, employee_id, first_name
FROM employees;

-- 형변환 함수
-- TO_CHAR(): 날짜형이나 숫자형을 문자로 변환하라
SELECT SYSDATE, TO_CHAR(SYSDATE, 'yyyy-mm-dd hh24:mi:ss')
FROM dual;
SELECT 1230000, TO_CHAR(1230000)
FROM dual;
SELECT first_name, salary, TO_CHAR(salary, '999,999')
FROM employees;

-- TO_DATE(): 문자를 날짜형으로 변환하라
SELECT first_name, hire_date, TO_DATE('20051025', 'YYYYMMDD')
From employees;
SELECT TRUNC(SYSDATE - TO_DATE('2008/01/01', 'YYYY/MM/DD'))
FROM dual;

-- TO_NUMBER(): 문자를 숫자형으로 변환하라
SELECT 100-10, 100+10, 100*10, 100/10
FROM dual;
SELECT TO_NUMBER('100') + 1
FROM dual;
SELECT TO_NUMBER('20,000', '99,999') - TO_NUMBER('10,000', '99,999')
FROM dual;

-- 일반함수
-- nvl
SELECT first_name, salary, commission_pct, nvl(commission_pct, 0)
FROM employees
ORDER BY job_id;

-- nvl2
SELECT first_name, salary, commission_pct, nvl2(commission_pct, salary * 12 + commission_pct, salary * 12)
FROM employees
ORDER BY job_id;

-- nullif
SELECT NULLIF('A', 'A'), NULLIF('A','B')
FROM dual;

-- coalesce
SELECT first_name,
        commission_pct,
        salary,
        COALESCE(commission_pct, salary, 0)
FROM employees
ORDER BY job_id;

-- decode 함수: switch문과 비슷
SELECT first_name, department_id,
    DECODE(department_id,
        10, 'ACCOUNTING',
        20, 'RESEARCH',
        30, 'SALES',
        40, 'OPERATIONS',
        'DEFAULT') dname
FROM employees
ORDER BY department_id ASC;

-- case 함수
SELECT first_name, department_id,
    CASE
        WHEN department_id = 10 then 'ACCOUNTING'
        WHEN department_id = 20 then 'RESEARCH'
        WHEN department_id = 30 then 'SALES'
        WHEN department_id = 40 then 'OPERATIONS'
        ELSE 'DEFAULT'
    END dname
FROM employees
ORDER BY department_id ASC;

-- 집계함수(sum, avg, max, min, count)
SELECT SUM(salary), ROUND(AVG(salary), 2), MAX(salary), MIN(salary), COUNT(*)
FROM employees;

-- GROUP BY
-- 소속 부서별 급여 합계를 부서번호와 함께 출력
SELECT department_id, SUM(salary) sum_sal
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

-- 소속 부서별 평균 급여
SELECT department_id, ROUND(AVG(salary)) avg_sal
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

-- 직책별 인원수와 급여합계를 부서번호와 함께 출력
SELECT department_id, job_id, count(*), sum(salary)
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id;

-- 부서별 급여 총액이 50000 이상인 부서의 번호와 부서별 급여 총액 구하기
SELECT department_id, sum(salary)
FROM employees
GROUP BY department_id
HAVING sum(salary) >= 50000
ORDER BY department_id;

-- job_id가 IT_PROG를 제외하고 급여 총액이 5000 이상인 직급(job_id)별 급여 총액 구하기
SELECT job_id, SUM(salary)
FROM employees
WHERE NOT (job_id = 'IT_PROG')
GROUP BY job_id
HAVING SUM(salary) >= 5000
ORDER BY SUM(salary);

-- department_id 의 평균 급여 중 최고를 출력하기(집계함수 중첩은 2번까지만 허용)
SELECT ROUND(MAX(AVG(salary)))
FROM employees
GROUP BY department_id;

-- 하위쿼리, 서브쿼리
-- Lex 보다 급여를 많이 받는 사원 검색...
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT salary
                FROM employees
                WHERE lower(first_name) = 'lex');
                
-- Lex와 동일한 부서에서 근무하는 사원 출력하기
SELECT first_name, department_id
FROM employees
WHERE department_id = (SELECT department_id
                       FROM employees
                       WHERE lower(first_name) = 'lex');

-- 최소 급여를 받는 사원의 이름, 담당업무, 급여를 출력하기
SELECT first_name, job_id, salary
FROM employees
WHERE salary = (SELECT min(salary)
                FROM employees);
                
-- Steven King과 동일한 부서에 근무하는 사원 출력하기
SELECT *
FROM employees
WHERE department_id = (SELECT department_id
                       FROM employees
                       WHERE first_name = 'Steven' AND last_name = 'King');

-- SELECT절에 서브쿼리 사용하기
SELECT first_name, salary, department_id, (
    SELECT department_name
    FROM departments
    WHERE departments.department_id = employees.department_id
    ) department_name
FROM employees;

SELECT first_name, job_id, (
    SELECT job_title
    FROM jobs
    WHERE jobs.job_id = employees.job_id
    ) job_title
FROM employees;

-- 부서별 최소급여를 받는 사원 구하기
SELECT department_id, (
    SELECT department_name
    FROM departments
    WHERE departments.department_id = employees.department_id
    ) department_name,
    min(salary) min_sal
FROM employees
GROUP BY department_id;