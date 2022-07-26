-- first_name�� ������������ �����Ͽ� ��� �� �̸��� ���ٸ� salary�� ������������ �����Ͽ� ���
SELECT *
FROM employees
ORDER BY first_name asc, salary asc;

-- count(*)�� ��ü ���ڵ带 count�Ѵ�.
SELECT count(*)
FROM employees;

-- count(�ʵ��)�� null�� count���� �ʴ´�.
SELECT count(commission_pct)
FROM employees;

-- ���ڿ� �Լ�
-- lower, upper, initcap(���ܾ��� ù���ڸ� �빮�ڷ� �������� �ҹ��ڷ�)
SELECT upper('korea')
FROM dual;
SELECT initcap('welCOME to mY sitE !!!')
FROM dual;

-- length: ���ڿ��� ����
SELECT LENGTH('korea')
FROM dual;
SELECT first_name, LENGTH(first_name) first_name_length, salary
FROM employees;

-- SUBSTR: ���ڿ� �ڸ���
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

-- INSTR: �ش� ������ �ε��� ��ġ�� ã��
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

-- �ʵ�(���ڿ�) ����: concat(����Ŭ������ 2�������� ����), ||
SELECT CONCAT('korea ', 'fighting')
FROM dual;
SELECT 'korea' || ' team ' || 'fighting'
FROM dual;

-- REPLACE
SELECT REPLACE('abcdefg', 'c', '000')
FROM dual;

-- ���� �Լ�
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

-- MOD: ������ ���ϱ�
SELECT MOD(27, 2), MOD(27, 5)
FROM dual;

-- ��¥ �Լ�
SELECT SYSDATE-1 ����, SYSDATE ����, SYSDATE+1 ����
FROM dual;

-- ������� �ٹ��ϼ� ���
SELECT first_name, hire_date, ROUND(sysdate - hire_date) �ٹ��ϼ�
FROM employees;

-- ROUND(date, format), TRUNC(date, format)
SELECT hire_date, ROUND(hire_date, 'MONTH')
FROM employees;
SELECT hire_date, TRUNC(hire_date, 'MONTH')
FROM employees;

-- ������� �ٹ��ϼ� ���(������)
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
SELECT SYSDATE, NEXT_DAY(SYSDATE, '������')
FROM dual;

-- LAST_DAY
SELECT hire_date, LAST_DAY(hire_date)
FROM employees;


-- �� ����鿡 ���ؼ� ����� �̸��� �ټӿ����� ��Ÿ���ÿ�. ��, �ټӿ����� �������� �����Ͻÿ�.
SELECT first_name, hire_date, FLOOR(MONTHS_BETWEEN(SYSDATE, hire_date) / 12) �ټӿ���
FROM employees;

-- ������ �������� 100������ 100���ĸ� ���Ͻÿ�.
SELECT SYSDATE-100 "100�� ��", SYSDATE+100 "100�� ��"
FROM dual;

-- ROWNUM: ��(���ڵ�)��ȣ
-- ROWID: ROUNUM�� �ּҰ�
SELECT ROWNUM, ROWID, employee_id, first_name
FROM employees;

-- ����ȯ �Լ�
-- TO_CHAR(): ��¥���̳� �������� ���ڷ� ��ȯ�϶�
SELECT SYSDATE, TO_CHAR(SYSDATE, 'yyyy-mm-dd hh24:mi:ss')
FROM dual;
SELECT 1230000, TO_CHAR(1230000)
FROM dual;
SELECT first_name, salary, TO_CHAR(salary, '999,999')
FROM employees;

-- TO_DATE(): ���ڸ� ��¥������ ��ȯ�϶�
SELECT first_name, hire_date, TO_DATE('20051025', 'YYYYMMDD')
From employees;
SELECT TRUNC(SYSDATE - TO_DATE('2008/01/01', 'YYYY/MM/DD'))
FROM dual;

-- TO_NUMBER(): ���ڸ� ���������� ��ȯ�϶�
SELECT 100-10, 100+10, 100*10, 100/10
FROM dual;
SELECT TO_NUMBER('100') + 1
FROM dual;
SELECT TO_NUMBER('20,000', '99,999') - TO_NUMBER('10,000', '99,999')
FROM dual;

-- �Ϲ��Լ�
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

-- decode �Լ�: switch���� ���
SELECT first_name, department_id,
    DECODE(department_id,
        10, 'ACCOUNTING',
        20, 'RESEARCH',
        30, 'SALES',
        40, 'OPERATIONS',
        'DEFAULT') dname
FROM employees
ORDER BY department_id ASC;

-- case �Լ�
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

-- �����Լ�(sum, avg, max, min, count)
SELECT SUM(salary), ROUND(AVG(salary), 2), MAX(salary), MIN(salary), COUNT(*)
FROM employees;

-- GROUP BY
-- �Ҽ� �μ��� �޿� �հ踦 �μ���ȣ�� �Բ� ���
SELECT department_id, SUM(salary) sum_sal
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

-- �Ҽ� �μ��� ��� �޿�
SELECT department_id, ROUND(AVG(salary)) avg_sal
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

-- ��å�� �ο����� �޿��հ踦 �μ���ȣ�� �Բ� ���
SELECT department_id, job_id, count(*), sum(salary)
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id;

-- �μ��� �޿� �Ѿ��� 50000 �̻��� �μ��� ��ȣ�� �μ��� �޿� �Ѿ� ���ϱ�
SELECT department_id, sum(salary)
FROM employees
GROUP BY department_id
HAVING sum(salary) >= 50000
ORDER BY department_id;

-- job_id�� IT_PROG�� �����ϰ� �޿� �Ѿ��� 5000 �̻��� ����(job_id)�� �޿� �Ѿ� ���ϱ�
SELECT job_id, SUM(salary)
FROM employees
WHERE NOT (job_id = 'IT_PROG')
GROUP BY job_id
HAVING SUM(salary) >= 5000
ORDER BY SUM(salary);

-- department_id �� ��� �޿� �� �ְ� ����ϱ�(�����Լ� ��ø�� 2�������� ���)
SELECT ROUND(MAX(AVG(salary)))
FROM employees
GROUP BY department_id;

-- ��������, ��������
-- Lex ���� �޿��� ���� �޴� ��� �˻�...
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT salary
                FROM employees
                WHERE lower(first_name) = 'lex');
                
-- Lex�� ������ �μ����� �ٹ��ϴ� ��� ����ϱ�
SELECT first_name, department_id
FROM employees
WHERE department_id = (SELECT department_id
                       FROM employees
                       WHERE lower(first_name) = 'lex');

-- �ּ� �޿��� �޴� ����� �̸�, ������, �޿��� ����ϱ�
SELECT first_name, job_id, salary
FROM employees
WHERE salary = (SELECT min(salary)
                FROM employees);
                
-- Steven King�� ������ �μ��� �ٹ��ϴ� ��� ����ϱ�
SELECT *
FROM employees
WHERE department_id = (SELECT department_id
                       FROM employees
                       WHERE first_name = 'Steven' AND last_name = 'King');

-- SELECT���� �������� ����ϱ�
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

-- �μ��� �ּұ޿��� �޴� ��� ���ϱ�
SELECT department_id, (
    SELECT department_name
    FROM departments
    WHERE departments.department_id = employees.department_id
    ) department_name,
    min(salary) min_sal
FROM employees
GROUP BY department_id;