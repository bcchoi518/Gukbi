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