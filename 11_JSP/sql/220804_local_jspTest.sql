create table member(
id varchar2(50) not null,
passwd varchar2(50) not null,
name varchar2(50) not null,
phone varchar2(50) not null,
email varchar2(50) not null,
address VARCHAR2(50) NOT NULL,
regiDate date not null
);

CREATE TABLE product (
productCode NUMBER NOT NULL,
productName VARCHAR2(50) NOT NULL,
productPrice NUMBER NOT NULL,
productContent CLOB NOT NULL,
productCategory VARCHAR2(50) NOT NULL,
vendor VARCHAR2(50) NOT NULL,
regiDate DATE NOT NULL,
PRIMARY KEY (productCode)
);

CREATE SEQUENCE seq_product START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

INSERT INTO product (productCode, productName, productPrice, productContent, productCategory, vendor, regiDate) VALUES (seq_product.NEXTVAL, '°¶·°½ÃS22', 1000000, '¾öÃ» Â¯ ÁÁÀº ÈÞ´ëÆù', '¸ð¹ÙÀÏ', '»ï¼º', SYSDATE);
COMMIT;