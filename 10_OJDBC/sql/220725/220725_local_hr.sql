-- 관계형 데이터베이스: 표, PK-FK
select table_name from user_tables;

-- FROM부터 시작해서 내려가다가 SELECT 후 ORDER BY 로 진행
-- WHERE 조건
-- GROUP BY 필드는 무조건 SELECT 절에도 적어주자 ex) SELECT 필드명, 집계함수
-- GROUP BY 필드명
-- HAVING 조건
-- ORDER BY

-- count(*): null 포함
-- count(필드명): null 제외

-- 문자열 결합
SELECT first_name || ' ' || last_name name
FROM employees;

SELECT first_name, hire_date, salary, commission_pct, ((salary*12) + nvl(commission_pct, 0)) "1년치연봉"
FROM employees;

-- null: 미확정값

-- distinct 중복된 데이터를 한번씩만 출력
SELECT DISTINCT department_id
FROM employees;

-- 나머지 구하기 mod(피연산자1, 피연산자2)
SELECT MOD(1, 2) FROM dual;

SELECT salary, salary + 5000000 FROM employees;

-- 사원 테이블에서 부서 아이디가 10인 사원 출력
SELECT *
FROM employees
WHERE department_id = 10;

-- first_name에서 Lex이름을 가진 사원 출력
SELECT *
FROM employees
WHERE first_name = 'Lex';

-- 2005년 이후에 입사한 사원 출력
SELECT *
FROM employees
WHERE hire_date >= '2005-01-01';

-- 2005년도에 입사한 사원 출력
SELECT *
FROM employees
WHERE substr(hire_date, 1, 2) = '05';

-- 2005년 이후에 입사한 사원중에 부서번호가 60인 사원
SELECT *
FROM employees
WHERE hire_date > '05/01/01' AND department_id = 60;

-- 2005년 이후에 입사한 사원중에 부서번호가 60이면서 급여가 15000 이상인 사원
SELECT *
FROM employees
WHERE hire_date > '05/01/01' AND department_id = 60 AND salary <= 15000;

-- COMMISSION_PCT가 0.1 이거나 0.25 이거나 0.3
SELECT *
FROM employees
WHERE commission_pct IN (0.1, 0.25, 0.3);

-- salary가 15000 에서 20000 사이인 사원
SELECT *
FROM employees
WHERE salary BETWEEN 15000 AND 20000;
--WHERE salary >= 15000 AND salary <= 20000;

-- first_name에서 대문자 N으로 시작하는 사원
SELECT *
FROM employees
WHERE first_name LIKE 'N%';

-- first_name에 대문자 N이 포함된 사원
SELECT *
FROM employees
WHERE first_name LIKE '%N%';

-- first_name에 대소문자 상관없이 n이 포함된 사원
SELECT *
FROM employees
--WHERE LOWER(first_name) LIKE '%n%';
WHERE UPPER(first_name) LIKE '%N%';

-- first_name에 3번째 글자가 a인 사원
SELECT *
FROM employees
WHERE first_name LIKE '__a%';

-- null
SELECT *
FROM employees
WHERE commission_pct IS NULL;