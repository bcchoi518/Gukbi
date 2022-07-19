create table product (
productCode number not null,
productName varchar2(50) not null,
productPrice number not null,
productContent clob not null,
vender varchar2(50) not null,
regiDate date not null,
primary key (productCode)
);

create sequence seq_product start with 1 increment by 1 nomaxvalue nocache;