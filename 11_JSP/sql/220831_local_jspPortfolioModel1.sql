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

---------------------------------------------------------------------------------
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