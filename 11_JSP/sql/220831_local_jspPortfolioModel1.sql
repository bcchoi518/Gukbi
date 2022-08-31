--��ǰ����
--���̺�: product
--��ǰ�ڵ�
--��ǰ�̸�
--��ǰ����
--������
--�����

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
--���������
--���̺�: vendor

CREATE TABLE vendor (
    vendorCode NUMBER NOT NULL,
    vendorName VARCHAR2(50) NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (vendorCode)
);

CREATE SEQUENCE seq_vendor START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

select * from product order by productCode desc;