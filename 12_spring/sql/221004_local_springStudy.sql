CREATE TABLE product (
    productNo NUMBER NOT NULL,
    productName VARCHAR2(50) NOT NULL,
    productPrice NUMBER NOT NULL,
    productDescription CLOB NOT NULL,
    vendorNo VARCHAR2(50) NOT NULL,
    vendorName VARCHAR2(50) NOT NULL,
    attachInfo CLOB NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (productNo)
);

CREATE SEQUENCE seq_product START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
select * from product;

CREATE TABLE cart (
    cartNo NUMBER NOT NULL,
    productNo NUMBER NOT NULL,
    amount NUMBER NOT NULL,
    memberNo NUMBER NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (cartNo)
);

CREATE SEQUENCE seq_cart START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from cart;