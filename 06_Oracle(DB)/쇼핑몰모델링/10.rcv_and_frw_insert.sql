insert into rcv_and_frw 
(product_code, wrhs_code, rcv_and_frw_io, indate, rcv_and_frw_quantity, rcv_and_frw_seq)
values('hi0001', 'st001', 'i', SYSDATE, '100',RCV_AND_FRW_SEQ.nextval);

insert into rcv_and_frw 
(product_code, wrhs_code, rcv_and_frw_io, indate, rcv_and_frw_quantity, rcv_and_frw_seq)
values('bt0001', 'st002', 'i', SYSDATE, '200', RCV_AND_FRW_SEQ.nextval);

insert into rcv_and_frw 
(product_code, wrhs_code, rcv_and_frw_io, indate, rcv_and_frw_quantity, rcv_and_frw_seq)
values('sd0001', 'st002', 'o', '1', SYSDATE, '150', RCV_AND_FRW_SEQ.nextval);

insert into rcv_and_frw 
(product_code, wrhs_code, rcv_and_frw_io, indate, rcv_and_frw_quantity, rcv_and_frw_seq)
values('sp0001', 'st003', 'o', SYSDATE, '1000', RCV_AND_FRW_SEQ.nextval);

insert into rcv_and_frw 
(product_code, wrhs_code, rcv_and_frw_io, indate, rcv_and_frw_quantity, rcv_and_frw_seq)
values('sh0001', 'st004', 'i', SYSDATE, '600', RCV_AND_FRW_SEQ.nextval);

insert into rcv_and_frw 
(product_code, wrhs_code, rcv_and_frw_io, indate, rcv_and_frw_quantity, rcv_and_frw_seq)
values('sa0001', 'st005', 'o', SYSDATE, '800', RCV_AND_FRW_SEQ.nextval);
COMMIT;