SELECT employee_id, first_name, department_id, job_id, salary
FROM employees
WHERE salary IN (
    SELECT MIN(salary)
    FROM employees
    GROUP BY department_id
);

-- 부서별로 최소급여가 30번 부서의 최소급여보다 많은 부서의 최소급여를 출력하세요.
SELECT department_id, (
    SELECT department_name
    FROM departments
    WHERE departments.department_id = employees.department_id
    ) department_name,
    MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (SELECT MIN(salary)
                      FROM employees
                      WHERE department_id = 30)
ORDER BY MIN(salary) ASC;

-- 다중행 결과 서브쿼리
SELECT employee_id, first_name, salary
FROM employees
WHERE salary IN (
    SELECT min(salary)
    FROM employees
    GROUP BY department_id
);

-- 직급이 IT_PROG가 아니면서 급여가 임의의 IT_PROG보다 낮은 사원을 출력...
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE salary < ANY (SELECT salary FROM employees WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';
-- < ANY: 최대값 보다 작은 것
-- > ANY: 최소값 보다 큰 것

-- 직급이 IT_PROG가 아니면서 직급이 IT_PROG인 사원보다 급여가 적은 사원을 모두 출력...
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE salary < ALL (SELECT salary FROM employees WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';
-- < ALL: 최소값 보다 작은 것
-- > ALL: 최대값 보다 큰 것

-- 사원번호가 109인 사원과 담당업무가 같은 사원을 표시(사원이름과 담당업무)하시오.
SELECT first_name, job_id
FROM employees
WHERE job_id = (SELECT job_id
                FROM employees
                WHERE employee_id = 109);
                
-- 사원번호가 110인 사원보다 급여가 많은 사원을 표시(사원이름과 담당업무)하시오.
SELECT first_name, job_id, salary
FROM employees
WHERE salary > (SELECT salary
                FROM employees
                WHERE employee_id = 110);
                
-- 평균 급여가 가장 적은 사원의 담당 업무를 찾아 직급과 평균 급여를 표시하시오.

-- JOIN
-- 카다시안곱
-- 조건없이 테이블을 조인할 경우, 레코드 X 레코드 수 만큼 만들어짐
SELECT count(*)
FROM employees;

SELECT count(*)
FROM departments;

SELECT *
FROM employees, departments
WHERE employee_id = '100';

SELECT *
FROM employees, departments
WHERE employee_id = 100 and departments.department_id = 90;

SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- inner join: 
-- 조인되는 테이블 각각에 값이 존재 할 때만 결과 출력

-- [left/right] outer join: 
-- 조인되는 테이블 중 지정한 테이블[left/right]은 레코드 전체를 나타내고 나머지 테이블에 해당하는 값이 있을 경우 값 표시, 없을경우 null 결과 출력


-- 내부조인(레코드:106)
-- Oracle 조인
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- ANSI 표준 조인(INNER 생략가능)
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e INNER JOIN departments d
  ON e.department_id = d.department_id;

-- Lex라는 사원의 사원번호, 이름, 부서아이디, 부서명 출력...
-- ANSI 표준
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e INNER JOIN departments d
                 ON e.department_id = d.department_id
                 AND e.first_name = 'Lex';
-- Oracle
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
  AND e.first_name = 'Lex';

-- 각 사원들의 소속된 부서정보 보기
SELECT *
FROM employees e INNER JOIN departments d
                 ON e.department_id = d.department_id;

-- 사원번호가 101인 사원의 사원번호, 사원이름, 소속부서 이름 출력하기
SELECT e.employee_id, e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
  AND e.employee_id = 101;
  
-- 서브쿼리로 구현
SELECT employee_id, first_name, (SELECT department_name
                                 FROM departments
                                 WHERE departments.department_id = employees.department_id
                                 ) department_name
FROM employees
WHERE employee_id = 101;

-- 외부조인
-- Oracle
SELECT e.first_name, e.hire_date, e.salary, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

-- ANSI 표준
SELECT e.first_name, e.hire_date, e.salary, d.department_name
FROM employees e LEFT OUTER JOIN departments d
                 ON e.department_id = d.department_id;
                 

SELECT d.department_id, COUNT(e.salary), SUM(e.salary)
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_id;

SELECT d.department_id, COUNT(e.salary), SUM(e.salary)
FROM employees e LEFT OUTER JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_id;

SELECT d.department_id, COUNT(e.salary), SUM(e.salary)
FROM employees e RIGHT OUTER JOIN departments d ON e.department_id = d.department_id
GROUP BY d.department_id;

-- Steven King 사원의 부서이름 출력하기
SELECT e.first_name, e.last_name, d.department_name
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id
WHERE e.first_name = 'Steven'
  AND e.last_name = 'King';
  
-- 사원이름과 그 사원이 소속된 부서이름과 지역명 출력하기
SELECT e.first_name, d.department_name, l.city
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id
                 INNER JOIN locations l ON d.location_id = l.location_id;
                 
-- 커미션을 받는 모든 사원의 이름, 부서이름, 지역명 출력
SELECT e.first_name, e.commission_pct, d.department_name, l.city
FROM employees e LEFT OUTER JOIN departments d ON e.department_id = d.department_id
                 LEFT OUTER JOIN locations l ON d.location_id = l.location_id
WHERE e.commission_pct IS NOT NULL;

SELECT e.first_name, e.commission_pct, d.department_name, l.city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id(+) AND d.location_id = l.location_id(+) AND e.commission_pct IS NOT NULL;