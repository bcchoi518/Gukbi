-- ������ �����ͺ��̽�: ǥ, PK-FK
select table_name from user_tables;

-- FROM���� �����ؼ� �������ٰ� SELECT �� ORDER BY �� ����
-- WHERE ����
-- GROUP BY �ʵ�� ������ SELECT ������ �������� ex) SELECT �ʵ��, �����Լ�
-- GROUP BY �ʵ��
-- HAVING ����
-- ORDER BY

-- count(*): null ����
-- count(�ʵ��): null ����

-- ���ڿ� ����
SELECT first_name || ' ' || last_name name
FROM employees;

SELECT first_name, hire_date, salary, commission_pct, ((salary*12) + nvl(commission_pct, 0)) "1��ġ����"
FROM employees;

-- null: ��Ȯ����

-- distinct �ߺ��� �����͸� �ѹ����� ���
SELECT DISTINCT department_id
FROM employees;

-- ������ ���ϱ� mod(�ǿ�����1, �ǿ�����2)
SELECT MOD(1, 2) FROM dual;

SELECT salary, salary + 5000000 FROM employees;

-- ��� ���̺��� �μ� ���̵� 10�� ��� ���
SELECT *
FROM employees
WHERE department_id = 10;

-- first_name���� Lex�̸��� ���� ��� ���
SELECT *
FROM employees
WHERE first_name = 'Lex';

-- 2005�� ���Ŀ� �Ի��� ��� ���
SELECT *
FROM employees
WHERE hire_date >= '2005-01-01';

-- 2005�⵵�� �Ի��� ��� ���
SELECT *
FROM employees
WHERE substr(hire_date, 1, 2) = '05';

-- 2005�� ���Ŀ� �Ի��� ����߿� �μ���ȣ�� 60�� ���
SELECT *
FROM employees
WHERE hire_date > '05/01/01' AND department_id = 60;

-- 2005�� ���Ŀ� �Ի��� ����߿� �μ���ȣ�� 60�̸鼭 �޿��� 15000 �̻��� ���
SELECT *
FROM employees
WHERE hire_date > '05/01/01' AND department_id = 60 AND salary <= 15000;

-- COMMISSION_PCT�� 0.1 �̰ų� 0.25 �̰ų� 0.3
SELECT *
FROM employees
WHERE commission_pct IN (0.1, 0.25, 0.3);

-- salary�� 15000 ���� 20000 ������ ���
SELECT *
FROM employees
WHERE salary BETWEEN 15000 AND 20000;
--WHERE salary >= 15000 AND salary <= 20000;

-- first_name���� �빮�� N���� �����ϴ� ���
SELECT *
FROM employees
WHERE first_name LIKE 'N%';

-- first_name�� �빮�� N�� ���Ե� ���
SELECT *
FROM employees
WHERE first_name LIKE '%N%';

-- first_name�� ��ҹ��� ������� n�� ���Ե� ���
SELECT *
FROM employees
--WHERE LOWER(first_name) LIKE '%n%';
WHERE UPPER(first_name) LIKE '%N%';

-- first_name�� 3��° ���ڰ� a�� ���
SELECT *
FROM employees
WHERE first_name LIKE '__a%';

-- null
SELECT *
FROM employees
WHERE commission_pct IS NULL;