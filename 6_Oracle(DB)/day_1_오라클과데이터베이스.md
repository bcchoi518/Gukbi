학습 일자 : 2022.04.19  
학습 목표

1. 데이터베이스 기본 개념 이해
2. 오라클 설치 및 환경설정
3. 데이터 조회 기초 이해

---

## 데이터베이스 (오라클)

- 데이터베이스

  - 조직화된 정보의 집합

- 데이터베이스 관리 시스템
  - 연관성 있는 데이터들의 집합을 효율적으로 응용하기 위해 구성된 소프트웨어들의 집합체

### 관계형 데이터베이스

- 관계형 데이터베이스 정보를 테이블 형태로 저장
- 테이블은 2차원 형태의 표처럼 볼 수 있도록 로우(ROW:행)와 칼럼(COLUMN:열)으로 구성됨

### SQL(Structured Query Language)

데이터베이스에 저장된 데이터를 조회, 입력, 수정, 삭제하는 등의 조작이 나, 테이블을 비롯한 다양한 객체(시퀀스, 인덱스등)을 생성 및 제어하는 역할

- 데이터 정의어(DDL)  
  데이터베이스 관리자나 응용 프로그래머가 데이터베이스의 논리적 구조를 정의하기 위한 언어로서 데이터 사전(Data Dictionary)에 저장됨

- 데이터 조작어(DML)  
   데이터베이스에 저장된 데이터를 조작하기 위해 사용하는 언어로서 데이터 검색(Retrieval), 추가(Insert), 삭제(Delete),
  갱신(Update) 작업수행

- 데이터 저어어(DCL)
  데이터에 대한 접근 권한 부여 등의 데이터베이스 시스템의 트랜잭션을 관리하기 위한 목적으로 사용되는 언어

| 유형                                                                    | 명령문                                                                                                                                                  |
| ----------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------- |
| DQL: Data Query Language(질의어)                                        | SELECT(데이터 검색시 사용)                                                                                                                              |
| DML: Data Manipulation Language (데이터 조작어) - 데이터 변경시 사용    | INSERT(데이터 입력), UPDATE(데이터 수정), DELETE(데이터 삭제)                                                                                           |
| DDL: Data Definition Language(데이터 정의어) - 객체 생성 및 변경시 사용 | CREATE(데이터베이스 생성), ALTER(데이터베이스 변경), DROP(데이터베이스 삭제), RENAME(데이터베이스 객체이름 변경), TRUNCATE(데이터베이스 저장 공간 삭제) |
| TCL: Transaction Control Language(트랜잭션 처리어)                      | COMMIT(트랜잭션의 정상적인 종료처리), ROLLBACK(트랜잭션 취소), SAVEPOINT(트랜잭션내에 임시 저장점 설정)                                                 |
| DCL: Data Control Language(데이터 제어어)                               | GRANT(데이터베이스에 대한 일련의 권한 부여), REVOKE(데이터베이스에 대한 일련의 권한 취소)                                                               |

---

### 오라클 접속하기

데이터베이스 사용자는 오라클 계정(Account)이라는 용어와 같은 의미로 사용된다. 오라클을 설치하면 한개 이상의 데이터베이스 권한을 갖는 디폴트(기본적인) 사용자가 존재한다. 오라클에서 제공되는 사용자 계정은 다음과 같다
| 사용자계정 | 설명 |
|---|---|
| SYS | 오라클 Super 사용자 계정이며 데이터베이스에서 발생하는 모든 문제들을 처리할 수 있는 권한을 가지고 있음 |
| SYSTEM | 오라클 데이터베이스를 유지보수 관리할 때 사용하는 사용자계정이며, SYS 사용자와 차이점은 데이터베이스를 생성할 수 있는 권한이 없으면 불완전 복구를 할 수 없음 |
| SCOTT | 처음 오라클을 사용하는 사용자의 실습을 위해 만들어 놓은 연습용 계정 |
| HR | 오라클에 접근할 수 있도록 샘플로 만들어 놓은 사용자 계정 |

- 계정연결

  ```sql
  conn system/1234
  ```

- 관리자 계정(system)에서 연습용계정 언락

  ```sql
  alter user hr account unlock;
  ```

- hr 계정 언락 후 비밀번호 설정해줘야함

  ```sql
  alter user hr identified by 1234;
  ```

- 현재 접속 계정 확인

  ```sql
  show user
  ```

  _tip: SQLPLUS명령어: 명령문 뒤에 ; 안붙임  
   SQL명령어: 명령문 뒤에 ; 붙임_

  _@sql파일경로 엔터 하면 테이블이 작성됨_

- 테이블정보표시

  ```sql
  desc 테이블이름
  ```

  _column : 변수와 비슷하다_

- 테이블 이름 조회

  ```sql
    SELECT table_name FROM all_tables; (전체)
    SELECT table_name FROM user_tables; (현재 유저)
  ```

---

### 데이터 조회하기

SELECT문은 데이터를 조회하기 위한 SQL명령어이다

```sql
SELECT [DISTINCT] { * 또는 column[Alias], ...... }
FROM table_name
[WHERE condition]
[GROUP BY group_by_expression]
[HAVING group_condition]
[ORDER BY column];
```

_{ column[Alias], ... } : 반드시 있어야 함_  
_[Alias] : 별칭_

**※데이터를 조회하기 위한 SQL문을 작성할때는 반드시 위에서 아래의 순서대로 작성해야 한다.**

| 절          | 기능                                                |
| ----------- | --------------------------------------------------- |
| SELECT 절   | 조회하고자 하는 칼럼(column)명의 리스트를 나열한다. |
| DISTINCT 절 | 동일한 내용을 한 번씩만 출력하여 중복을 제거한다.   |
| FROM 절     | 조회하고자 하는 테이블명의 리스트를 나열한다.       |
| WHERE 절    | 조회하고자 하는 로우의 조건(row)을 나열한다.        |
| GROUP BY 절 | 동일한 값을 갖는 로우(row)들을 한 그룹으로 묶는다.  |
| HAVING 절   | 로우(row)들의 그룹이 만족해야 하는 조건을 제시한다. |
| ORDER BY 절 | 로우(row)들의 정렬 순서를 제시한다.                 |

- SELECT 절
  - SELECT는 데이터베이스 내에 저장되어있는 테이블을 조회하기 위한 명령어
  - SELECT 다음에는 조회하는 대상의 칼럼(column)명을 기술 (\* : 지정된 테이블의 모든 칼럼 조회)
  - FROM 다음에는 조회하는 대상의 테이블 이름을 기술
  - 다수의 칼럼(column)을 조회하려면 칼럼명과 칼럼명 사이에 콤마(,)로 구분하여 기술
- DISTINCT 절
  - 칼럼(column)내에 중복된 값이 있으면 중복값을 제거한 데이터를 조회

---

### 산술 연산자

데이터를 조회할 때 칼럼(column)에 산술 연산을 하여 그 결과를 조회할 수 있다.

| 종류 | 예                                |
| ---- | --------------------------------- |
| +    | SELECT salary + 300 FROM employee |
| -    | SELECT salary - 300 FROM employee |
| \*   | SELECT salary \* 12 FROM employee |
| /    | SELECT salary / 4 FROM employee   |

칼럼(column)에 산술연산한 결과는 새로운 칼럼(column)으로 조회되는데 이것은 데이터베이스 테이블 내에 존재하는 것이 아니라 메모리내에 존재하는 가상칼럼이다.

---

### nvl 함수 사용하기

null은 ? 혹은 ∞의 이미이기 때문에 연산, 할당, 비교가 불가능하다.
칼럼(column)에 null값이 존재하는 경우에는 nvl함수를 이용하여 계산한다.

```sql
계산할 대상 + nvl(null값이 존재하는 칼럼(column), 0)
```

계산할 대상에 산술연산을 하는 경우에는 위와 같이 nvl 함수를 기술한다.

---

### 칼럼에 별칭 지정하기

SQL에서 쿼리문의 결과가 출력될 때, 칼럼(column)명이 칼럼(column)에 대한 헤딩(heaing)으로 출력된다.

```sql
SELECT 칼럼명 별칭
FROM 테이블명;
```

위의 명령문으로 작성하면 칼럼(column)과 별칭의 구분이 어렵기 때문에 아래와 같이 작성한다.

```sql
SELECT 칼럼명 as 별칭
FROM 테이블명;
```

별칭을 작성할 때 별칭안에 공백이나 특수문자($, \_, #, 등)를 추가하고 싶거나 대소문자를 구분해야 하는 경우에는 **" "**를 사용하여 별칭을 부여하면 된다.

```sql
SELECT 칼럼명 "별 칭"
FROM 테이블명;
```

---

### DUAL TABLE

테이블의 구조를 살펴보려면 DESC 명령어를 사용한다.

```sql
DESC dual
```

- 오라클이 설치될 때 만들어지는 기본 임시 테이블이다.
- DUMMY라는 단 하나의 칼럼(column)으로 구성되어 있고 최대 길이는 1이다.
- 칼럼(column)에 X 라는 단 하나의 로우(row)만을 저장하고 있으나 이 값은 아무런 의미가 없다.
- 쿼리문의 수행 결과가 하나의 로우(row)로 출력되도록 하기 위해서 단 하나의 로우(row)를 구성하고 있을 뿐이다.
- 다음과 같은 예로 사용할 때 DUAL 테이블을 이용한다.

```sql
SELECT SYSDATE
FROM DUAL;
```
