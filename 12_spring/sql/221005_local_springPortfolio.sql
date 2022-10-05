CREATE TABLE member (
    no NUMBER NOT NULL,
    id VARCHAR2(10) NOT NULL,
    passwd VARCHAR2(250) NOT NULL,
    name VARCHAR2(15) NOT NULL,
    jumin1 VARCHAR2(6) NOT NULL,
    jumin2 VARCHAR2(1) NOT NULL,
    phone1 VARCHAR2(3) NOT NULL CHECK (phone1  in ('010', '011', '016')),
    phone2 VARCHAR2(4) NOT NULL,
    phone3 VARCHAR2(4) NOT NULL,
    email1 VARCHAR2(50) NOT NULL,
    email2 VARCHAR2(50) NOT NULL,
    
    postcode VARCHAR2(50) NOT NULL,
    address VARCHAR2(50) NOT NULL,
    detailAddress VARCHAR2(50) NOT NULL,
    extraAddress VARCHAR2(50) NOT NULL,
    
    regiDate DATE DEFAULT SYSDATE,
    PRIMARY KEY (id),
    UNIQUE (no)
);
CREATE SEQUENCE seq_member START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
SELECT * FROM member;

--------------------------------------------------------------------------------------

-- 메모장
CREATE TABLE memo (
    no NUMBER NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_memo START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from memo order by no desc;

commit;

--------------------------------------------------------------------------------------
-- 방명록
CREATE TABLE guestBook (
    no NUMBER NOT NULL,
    name VARCHAR2(50) NOT NULL,
    email VARCHAR2(50) NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    regiDate DATE NOT NULL,
    memberNo NUMBER NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_guestBook START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

SELECT * FROM guestBook;

--------------------------------------------------------------------------------------

-- 게시판(본격적인?)
CREATE TABLE board (
    no NUMBER NOT NULL,
    num NUMBER NOT NULL,
    tbl VARCHAR2(50) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    subject VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    email VARCHAR2(50) NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    refNo NUMBER NOT NULL,
    stepNo NUMBER NOT NULL,
    levelNo NUMBER NOT NULL,
    parentNo NUMBER NOT NULL,
    hit NUMBER NOT NULL,
    ip VARCHAR2(50) NOT NULL,
    memberNo NUMBER NOT NULL,
    noticeNo NUMBER NOT NULL,
    secretGubun VARCHAR2(1) NOT NULL CHECK (secretGubun in ('T', 'F')),
    regiDate DATE NOT NULL,
    attachInfo CLOB NOT NULL,
    PRIMARY KEY (no)
);

CREATE SEQUENCE seq_board START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

--------------------------------------------------------------------------------------

--상품관리
--테이블: product
--상품코드
--상품이름
--상품가격
--제조사
--등록일

CREATE TABLE product (
    productCode NUMBER NOT NULL,
    productName VARCHAR2(50) NOT NULL,
    productPrice NUMBER NOT NULL,
    vendorCode NUMBER NOT NULL,
    attachInfo CLOB NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (productCode)
);

CREATE SEQUENCE seq_product START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

--------------------------------------------------------------------------------------

--제조사관리
--테이블: vendor

CREATE TABLE vendor (
    vendorCode NUMBER NOT NULL,
    vendorName VARCHAR2(50) NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (vendorCode)
);

CREATE SEQUENCE seq_vendor START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from product order by productCode desc;

--------------------------------------------------------------------------------------

CREATE TABLE cart (
    cartNo NUMBER NOT NULL,
    memberNo NUMBER NOT NULL,
    productCode NUMBER NOT NULL,
    amount NUMBER NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (cartNo)
);

CREATE SEQUENCE seq_cart START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from cart;

--------------------------------------------------------------------------------------

CREATE TABLE boardComment (
    commentNo NUMBER NOT NULL PRIMARY KEY, -- 댓글 일련번호
    boardNo NUMBER NOT NULL REFERENCES board(no), -- 게시물 번호
    writer VARCHAR2(50) NOT NULL,
    content CLOB NOT NULL,
    passwd VARCHAR2(50) NOT NULL,
    memberNo NUMBER NOT NULL,
    ip VARCHAR2(50) NOT NULL,
    regiDate DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_boardComment START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from boardComment;

--------------------------------------------------------------------------------------

CREATE TABLE boardChk (
    boardChkNo NUMBER NOT NULL,
    tbl VARCHAR2(50) NOT NULL,
    tblName VARCHAR2(50) NOT NULL,
    regiDate DATE DEFAULT SYSDATE,
    PRIMARY KEY (tbl),
    UNIQUE (boardChkNo)
);

CREATE SEQUENCE seq_boardChk START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

SELECT * FROM boardChk;