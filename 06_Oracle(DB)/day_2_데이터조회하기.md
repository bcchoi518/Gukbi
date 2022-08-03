학습 일자 : 2022.04.21  
학습 목표

1. WHERE 절로 원하는 조건에 맞는 데이터 검색
2. ORDER BY 절로 테이블을 일정한 순서로 나열

---

오라클 타입 : ANSI표준, ORACLE표준

### WHERE 절을 이용한 조건 검색

WHERE 절은 테이블에 저장된 데이터 중에서 원하는 데이터만 선택적으로 추출하기 위해서 사용

```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

---

### 비교 연산자

원하는 데이터를 추출할 때 비교 연산자를 이용하여 조건문을 기술한다.

| 연산자     | 의미        | 예 제                                                       |
| ---------- | ----------- | ----------------------------------------------------------- |
| =          | 같다        | SELECT eno, ename, salary FROM employee WHERE salary=1500;  |
| >          | 크다        | SELECT eno, ename, salary FROM employee WHERE salary>1500;  |
| <          | 작다        | SELECT eno, ename, salary FROM employee WHERE salary<1500;  |
| >=         | 크거나 같다 | SELECT eno, ename, salary FROM employee WHERE salary>=1500; |
| <=         | 작거나 같다 | SELECT eno, ename, salary FROM employee WHERE salary<=1500; |
| <>, !=, ^= | 다르다      | SELECT eno, ename, salary FROM employee WHERE salary<>1500; |

_비교 연산할때는 비교 대상들의 데이터 타입을 일치시켜야함_

---

### 문자 데이터 조회

문자 상수임을 알리기 위해 **' '** 작은 따옴표로 묶어주면 오류가 발생하지 않고 조회된다.

```sql
SELECT 칼럼명
FROM 테이블명
WHERE 대상칼럼='문자 상수';
```

### 날짜 데이터 조회

날짜 상수도 **' '** 작은 따옴표로 묶어주면 오류가 발생하지 않고 조회된다.

```sql
SELECT 칼럼명
FROM 테이블명
WHERE 대상칼럼='날짜 상수';
```

### 논리 연산자

오라클에서 사용가능한 논리 연산자는 AND, OR, NOT이 있다.
| 연산자 | 의미 | 예제 |
|---|---|---|
| AND | 두 가지 조건을 모두 만족해야만 검색 | SELECT _ FROM employee WHERE dno=10 and job='MANAGER'; |
| OR | 두 가지 조건 중에서 한 가지만 만족하더라도 검색 | SELECT _ FROM employee WHERE dno=10 or job='MANAGER'; |
| NOT | 조건에 만족하지 못하는 것만 검색 | SELECT \* FROM employee WHERE not dno=10; |

### BETWEEN AND 연산자

BETWEEN AND 연산자는 특정 칼럼의 데이터 값이 하한값(A)와 상한값(B) 사이에 포함되는 로우(row)를 검색하기 위한 연산자다.

```sql
SELECT 칼럼명
FROM 테이블명
WHERE 칼럼명 BETWEEN 하한값 AND 상한값;
```

### IN 연산자

IN 연산자는 특정 칼럼(column)의 값이 A, B, C 중 하나라도 일치하면 참이 되는 연산자다.

```sql
SELECT 칼럼명
FROM 테이블명
WHERE 칼럼명 IN (값A, 값B, 값C);
```

### LIKE 연산자와 와일드카드

LIKE 연산자는 칼럼(column)에 저장된 문자상수 중에서 LIKE 연산자에서 지정한 문자패턴과 부분적으로 일치하면 참이 되는 연산자다.

```sql
SELECT 칼럼명
FROM 테이블명
WHERE 칼럼명 LIKE pattern;
```

| 와일드카드 | 의미                                                       | 예제                                             |
| ---------- | ---------------------------------------------------------- | ------------------------------------------------ |
| %          | 문자가 없거나, 하나 이상의 문자가 어떤 값이 와도 상관없다. | SELECT \* FROM employee WHERE ename LIKE '%F%';  |
| \_         | 하나의 문자가 어떤 값이 와도 상관없다.                     | SELECT \* FROM employee WHERE ename LIKE '\_A%'; |

_pattern에는 두 가지 와일드카드가 사용되며 이 와일드카드 덕분에 임의의 문자 또는 문자열을 포함한 값을 찾을 수 있다._

### IS NULL과 IS NOT NULL

어떤 칼럼(column)을 NULL 즉, 모르는 값과 같다(=)라는 것은 의미상으로 말이 되지 않기 때문에 = 대신 IS NULL 연산자를 사용해야 한다.

```sql
SELECT 칼럼명
FROM 테이블명
WHERE 칼럼명 IS NULL;
```

_칼럼값이 NULL인지 조회한다._

```sql
SELECT 칼럼명
FROM 테이블명
WHERE 칼럼명 IS NOT NULL;
```

_칼럼값이 NULL이 아닌 자료만 조회한다._

### 정렬을 위한 ORDER BY 절

데이터를 크기 순서대로 나열하는 것을 의미

- 오름차순(ascending) 정렬 방식  
  작은 것이 위에 출력되고 아래로 갈수록 큰 값이 출력
- 내림차순(descending) 정렬 방식  
  큰 값이 위에 출력되고 아래로 갈수록 작은 값이 출력

| 구분 | ASC(오름차순)         | DESC(내림차순)        |
| ---- | --------------------- | --------------------- |
| 숫자 | 작은 값부터 정렬      | 큰 값부터 정렬        |
| 문자 | 사전 순서로 정렬      | 사전 반대 순서로 정렬 |
| 날짜 | 빠른 날짜 순서로 정렬 | 늦은 날짜 순서로 정렬 |
| NULL | 가장 마지막에 나온다  | 가장 먼저 나온다      |

```sql
SELECT 칼럼명
FROM 테이블명
ORDER BY 칼럼명 정렬방식;
```
