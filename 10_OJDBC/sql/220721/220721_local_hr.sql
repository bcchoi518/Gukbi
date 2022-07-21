select table_name from user_tables; --유저테이블정보

select * from dictionary; --메타데이터

select * from user_constraints; --제약조건

--user_col_comments 라는 데이터사전을 조회
select * from user_col_comments;

select * from employees;
desc employees;

select * from departments;

-- 2007년도에 입사한 사람 뽑기
select * from employees where hire_date >= '07/01/01' and hire_date <= '07/12/31';
select * from employees where hire_date between '2007-01-01' and '2007-12-31';
select * from employees where hire_date like '07%';
select * from employees where substr(hire_date, 1, 2) = '07';

-- 급여가 9000 이상인 사람
select * from employees where salary >= 9000;

-- 이름, 급여, 연봉 출력
select first_name 이름, salary 급여, (salary * 12) 연봉 from employees;

-- 이름, 급여, 커미션_pct, 연봉 출력
select first_name 이름, salary 급여, commission_pct 커미션, (salary + (salary * nvl(commission_pct, 0))) 연봉 from employees;