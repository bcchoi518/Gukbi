SELECT employee_id, first_name, department_id, job_id, salary
FROM employees
WHERE salary IN (
    SELECT MIN(salary)
    FROM employees
    GROUP BY department_id
);

-- �μ����� �ּұ޿��� 30�� �μ��� �ּұ޿����� ���� �μ��� �ּұ޿��� ����ϼ���.
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

-- ������ ��� ��������
SELECT employee_id, first_name, salary
FROM employees
WHERE salary IN (
    SELECT min(salary)
    FROM employees
    GROUP BY department_id
);

-- ������ IT_PROG�� �ƴϸ鼭 �޿��� ������ IT_PROG���� ���� ����� ���...
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE salary < ANY (SELECT salary FROM employees WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';
-- < ANY: �ִ밪 ���� ���� ��
-- > ANY: �ּҰ� ���� ū ��

-- ������ IT_PROG�� �ƴϸ鼭 ������ IT_PROG�� ������� �޿��� ���� ����� ��� ���...
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE salary < ALL (SELECT salary FROM employees WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';
-- < ALL: �ּҰ� ���� ���� ��
-- > ALL: �ִ밪 ���� ū ��

-- �����ȣ�� 109�� ����� �������� ���� ����� ǥ��(����̸��� ������)�Ͻÿ�.
SELECT first_name, job_id
FROM employees
WHERE job_id = (SELECT job_id
                FROM employees
                WHERE employee_id = 109);
                
-- �����ȣ�� 110�� ������� �޿��� ���� ����� ǥ��(����̸��� ������)�Ͻÿ�.
SELECT first_name, job_id, salary
FROM employees
WHERE salary > (SELECT salary
                FROM employees
                WHERE employee_id = 110);
                
-- ��� �޿��� ���� ���� ����� ��� ������ ã�� ���ް� ��� �޿��� ǥ���Ͻÿ�.

-- JOIN
-- ī�ٽþȰ�
-- ���Ǿ��� ���̺��� ������ ���, ���ڵ� X ���ڵ� �� ��ŭ �������
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
-- ���εǴ� ���̺� ������ ���� ���� �� ���� ��� ���

-- [left/right] outer join: 
-- ���εǴ� ���̺� �� ������ ���̺�[left/right]�� ���ڵ� ��ü�� ��Ÿ���� ������ ���̺� �ش��ϴ� ���� ���� ��� �� ǥ��, ������� null ��� ���


-- ��������(���ڵ�:106)
-- Oracle ����
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- ANSI ǥ�� ����(INNER ��������)
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e INNER JOIN departments d
  ON e.department_id = d.department_id;

-- Lex��� ����� �����ȣ, �̸�, �μ����̵�, �μ��� ���...
-- ANSI ǥ��
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e INNER JOIN departments d
                 ON e.department_id = d.department_id
                 AND e.first_name = 'Lex';
-- Oracle
SELECT e.employee_id, e.first_name, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
  AND e.first_name = 'Lex';

-- �� ������� �Ҽӵ� �μ����� ����
SELECT *
FROM employees e INNER JOIN departments d
                 ON e.department_id = d.department_id;

-- �����ȣ�� 101�� ����� �����ȣ, ����̸�, �ҼӺμ� �̸� ����ϱ�
SELECT e.employee_id, e.first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
  AND e.employee_id = 101;
  
-- ���������� ����
SELECT employee_id, first_name, (SELECT department_name
                                 FROM departments
                                 WHERE departments.department_id = employees.department_id
                                 ) department_name
FROM employees
WHERE employee_id = 101;

-- �ܺ�����
-- Oracle
SELECT e.first_name, e.hire_date, e.salary, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

-- ANSI ǥ��
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

-- Steven King ����� �μ��̸� ����ϱ�
SELECT e.first_name, e.last_name, d.department_name
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id
WHERE e.first_name = 'Steven'
  AND e.last_name = 'King';
  
-- ����̸��� �� ����� �Ҽӵ� �μ��̸��� ������ ����ϱ�
SELECT e.first_name, d.department_name, l.city
FROM employees e INNER JOIN departments d ON e.department_id = d.department_id
                 INNER JOIN locations l ON d.location_id = l.location_id;
                 
-- Ŀ�̼��� �޴� ��� ����� �̸�, �μ��̸�, ������ ���
SELECT e.first_name, e.commission_pct, d.department_name, l.city
FROM employees e LEFT OUTER JOIN departments d ON e.department_id = d.department_id
                 LEFT OUTER JOIN locations l ON d.location_id = l.location_id
WHERE e.commission_pct IS NOT NULL;

SELECT e.first_name, e.commission_pct, d.department_name, l.city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id(+) AND d.location_id = l.location_id(+) AND e.commission_pct IS NOT NULL;