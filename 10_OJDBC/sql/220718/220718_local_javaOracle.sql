create table sungjuk (
no number not null,
name varchar2(50) not null,
kor number not null,
eng number not null,
mat number not null,
tot number not null,
avg number not null,
grade varchar2(50) not null,
regiDate date not null,
primary key (no)
);

create sequence seq_sungjuk start with 1 increment by 1 nomaxvalue nocache;

select * from sungjuk;