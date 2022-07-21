create table guestBook (
no number not null,
writer varchar2(50) not null,
subject varchar2(50) not null,
content clob not null,
passwd varchar2(50) not null,
regiDate date not null,
primary key (no)
);

create sequence seq_guestBook start with 1 increment by 1 nomaxvalue nocache;

select * from guestBook;

drop sequence seq_guestbook;

select * from member;

truncate table member;

select * from (select rownum num, member.* from member) where num between 21 and 30;

select rownum, member.* from member;





declare
n number := 0;
begin
    loop
        dbms_output.put_line(n);
        n := n + 1;
        insert into member values (seq_member.nextval, n, n, n, n, n, n, n, sysdate);
        commit;
        exit when n >= 10000;
    end loop;
end;
