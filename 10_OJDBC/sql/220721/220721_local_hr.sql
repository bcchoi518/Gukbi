select table_name from user_tables; --�������̺�����

select * from dictionary; --��Ÿ������

select * from user_constraints; --��������

--user_col_comments ��� �����ͻ����� ��ȸ
select * from user_col_comments;

select * from employees;
desc employees;

select * from departments;

-- 2007�⵵�� �Ի��� ��� �̱�
select * from employees where hire_date >= '07/01/01' and hire_date <= '07/12/31';
select * from employees where hire_date between '2007-01-01' and '2007-12-31';
select * from employees where hire_date like '07%';
select * from employees where substr(hire_date, 1, 2) = '07';

-- �޿��� 9000 �̻��� ���
select * from employees where salary >= 9000;

-- �̸�, �޿�, ���� ���
select first_name �̸�, salary �޿�, (salary * 12) ���� from employees;

-- �̸�, �޿�, Ŀ�̼�_pct, ���� ���
select first_name �̸�, salary �޿�, commission_pct Ŀ�̼�, (salary + (salary * nvl(commission_pct, 0))) ���� from employees;