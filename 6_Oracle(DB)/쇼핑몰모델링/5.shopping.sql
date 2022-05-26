
CREATE TABLE job
(
	job_code              VARCHAR2(5)  NOT NULL ,
	job_name              VARCHAR2(20)  NULL ,
	useyn                 CHAR(1)  NULL ,
	indate                DATE  NULL ,
	worker                VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPK직업 ON job
(job_code  ASC);



ALTER TABLE job
	ADD CONSTRAINT  XPK직업 PRIMARY KEY (job_code);



CREATE TABLE member
(
	id                    VARCHAR2(20)  NOT NULL ,
	name                  VARCHAR2(50)  NULL ,
	pwd                   VARCHAR2(20)  NULL ,
	tel                   VARCHAR2(13)  NULL ,
	address               VARCHAR2(20)  NULL ,
	indate                DATE  NULL ,
	zipcode               VARCHAR2(7)  NULL ,
	job_code              VARCHAR2(5)  NULL 
);



CREATE UNIQUE INDEX XPK고객 ON member
(id  ASC);



ALTER TABLE member
	ADD CONSTRAINT  XPK고객 PRIMARY KEY (id);



CREATE TABLE orders
(
	id                    VARCHAR2(20)  NULL ,
	product_code          VARCHAR2(20)  NULL ,
	o_seq                 VARCHAR2(10)  NOT NULL ,
	product_size          VARCHAR2(5)  NULL ,
	indate                DATE  NULL ,
	quantity              VARCHAR2(5)  NULL ,
	result                CHAR(1)  NULL 
);



CREATE UNIQUE INDEX XPK주문 ON orders
(o_seq  ASC);



ALTER TABLE orders
	ADD CONSTRAINT  XPK주문 PRIMARY KEY (o_seq);



CREATE TABLE products
(
	indate                DATE  NULL ,
	product_image         VARCHAR2(50)  NULL ,
	product_content       VARCHAR2(1000)  NULL ,
	product_price2        VARCHAR2(10)  NULL ,
	product_price1        VARCHAR2(10)  NULL ,
	product_code          VARCHAR2(20)  NOT NULL ,
	product_quantity      VARCHAR2(5)  NULL ,
	sizeEt                VARCHAR2(5)  NULL ,
	sizeSt                VARCHAR2(5)  NULL ,
	product_kind          CHAR(1)  NULL ,
	product_name          VARCHAR2(100)  NULL ,
	useyn                 CHAR(1)  NULL 
);



CREATE UNIQUE INDEX XPK상품 ON products
(product_code  ASC);



ALTER TABLE products
	ADD CONSTRAINT  XPK상품 PRIMARY KEY (product_code);



CREATE TABLE rcv_and_frw
(
	product_code          VARCHAR2(20)  NULL ,
	wrhs_code             VARCHAR2(20)  NULL ,
	rcv_and_frw_seq       VARCHAR2(10)  NOT NULL ,
	rcv_and_frw_io        CHAR(1)  NULL ,
	indate                DATE  NULL ,
	rcv_and_frw_quantity  VARCHAR2(5)  NULL 
);



CREATE UNIQUE INDEX XPK입출고 ON rcv_and_frw
(rcv_and_frw_seq  ASC);



ALTER TABLE rcv_and_frw
	ADD CONSTRAINT  XPK입출고 PRIMARY KEY (rcv_and_frw_seq);



CREATE TABLE tb_zipcode
(
	zipcode               VARCHAR2(7)  NOT NULL ,
	sido                  VARCHAR2(30)  NULL ,
	gugun                 VARCHAR2(30)  NULL ,
	dong                  VARCHAR2(100)  NULL ,
	bunji                 VARCHAR2(30)  NULL ,
	zip_seq               VARCHAR2(10)  NULL 
);



CREATE UNIQUE INDEX XPK우편번호 ON tb_zipcode
(zipcode  ASC);



ALTER TABLE tb_zipcode
	ADD CONSTRAINT  XPK우편번호 PRIMARY KEY (zipcode);



CREATE TABLE wrhs
(
	wrhs_code             VARCHAR2(20)  NOT NULL ,
	wrhs_name             VARCHAR2(20)  NULL ,
	wrhs_address          VARCHAR2(20)  NULL ,
	indate                DATE  NULL ,
	wrhs_worker           VARCHAR2(20)  NULL 
);



CREATE UNIQUE INDEX XPK창고 ON wrhs
(wrhs_code  ASC);



ALTER TABLE wrhs
	ADD CONSTRAINT  XPK창고 PRIMARY KEY (wrhs_code);



ALTER TABLE member
	ADD (CONSTRAINT  R_4 FOREIGN KEY (zipcode) REFERENCES tb_zipcode(zipcode) ON DELETE SET NULL);



ALTER TABLE member
	ADD (CONSTRAINT  R_8 FOREIGN KEY (job_code) REFERENCES job(job_code) ON DELETE SET NULL);



ALTER TABLE orders
	ADD (CONSTRAINT  R_5 FOREIGN KEY (id) REFERENCES member(id) ON DELETE SET NULL);



ALTER TABLE orders
	ADD (CONSTRAINT  R_7 FOREIGN KEY (product_code) REFERENCES products(product_code) ON DELETE SET NULL);



ALTER TABLE rcv_and_frw
	ADD (CONSTRAINT  R_9 FOREIGN KEY (product_code) REFERENCES products(product_code) ON DELETE SET NULL);



ALTER TABLE rcv_and_frw
	ADD (CONSTRAINT  R_11 FOREIGN KEY (wrhs_code) REFERENCES wrhs(wrhs_code) ON DELETE SET NULL);



CREATE  TRIGGER tD_job AFTER DELETE ON job for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- DELETE trigger on job 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* job  member on parent delete set null */
    /* ERWIN_RELATION:CHECKSUM="0000ac30", PARENT_OWNER="", PARENT_TABLE="job"
    CHILD_OWNER="", CHILD_TABLE="member"
    P2C_VERB_PHRASE="R/8", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_8", FK_COLUMNS="job_code" */
    UPDATE member
      SET
        /* %SetFK(member,NULL) */
        member.job_code = NULL
      WHERE
        /* %JoinFKPK(member,:%Old," = "," AND") */
        member.job_code = :old.job_code;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

CREATE  TRIGGER tU_job AFTER UPDATE ON job for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- UPDATE trigger on job 
DECLARE NUMROWS INTEGER;
BEGIN
  /* job  member on parent update set null */
  /* ERWIN_RELATION:CHECKSUM="0000d4e0", PARENT_OWNER="", PARENT_TABLE="job"
    CHILD_OWNER="", CHILD_TABLE="member"
    P2C_VERB_PHRASE="R/8", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_8", FK_COLUMNS="job_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.job_code <> :new.job_code
  THEN
    UPDATE member
      SET
        /* %SetFK(member,NULL) */
        member.job_code = NULL
      WHERE
        /* %JoinFKPK(member,:%Old," = ",",") */
        member.job_code = :old.job_code;
  END IF;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/


CREATE  TRIGGER tI_member BEFORE INSERT ON member for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- INSERT trigger on member 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* tb_zipcode  member on child insert set null */
    /* ERWIN_RELATION:CHECKSUM="0001e8fd", PARENT_OWNER="", PARENT_TABLE="tb_zipcode"
    CHILD_OWNER="", CHILD_TABLE="member"
    P2C_VERB_PHRASE="R/4", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_4", FK_COLUMNS="zipcode" */
    UPDATE member
      SET
        /* %SetFK(member,NULL) */
        member.zipcode = NULL
      WHERE
        NOT EXISTS (
          SELECT * FROM tb_zipcode
            WHERE
              /* %JoinFKPK(:%New,tb_zipcode," = "," AND") */
              :new.zipcode = tb_zipcode.zipcode
        ) 
        /* %JoinPKPK(member,:%New," = "," AND") */
         and member.id = :new.id;

    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* job  member on child insert set null */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="job"
    CHILD_OWNER="", CHILD_TABLE="member"
    P2C_VERB_PHRASE="R/8", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_8", FK_COLUMNS="job_code" */
    UPDATE member
      SET
        /* %SetFK(member,NULL) */
        member.job_code = NULL
      WHERE
        NOT EXISTS (
          SELECT * FROM job
            WHERE
              /* %JoinFKPK(:%New,job," = "," AND") */
              :new.job_code = job.job_code
        ) 
        /* %JoinPKPK(member,:%New," = "," AND") */
         and member.id = :new.id;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

CREATE  TRIGGER tD_member AFTER DELETE ON member for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- DELETE trigger on member 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* member  orders on parent delete set null */
    /* ERWIN_RELATION:CHECKSUM="0000a7a8", PARENT_OWNER="", PARENT_TABLE="member"
    CHILD_OWNER="", CHILD_TABLE="orders"
    P2C_VERB_PHRASE="R/5", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_5", FK_COLUMNS="id" */
    UPDATE orders
      SET
        /* %SetFK(orders,NULL) */
        orders.id = NULL
      WHERE
        /* %JoinFKPK(orders,:%Old," = "," AND") */
        orders.id = :old.id;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

CREATE  TRIGGER tU_member AFTER UPDATE ON member for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- UPDATE trigger on member 
DECLARE NUMROWS INTEGER;
BEGIN
  /* member  orders on parent update set null */
  /* ERWIN_RELATION:CHECKSUM="0002ee72", PARENT_OWNER="", PARENT_TABLE="member"
    CHILD_OWNER="", CHILD_TABLE="orders"
    P2C_VERB_PHRASE="R/5", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_5", FK_COLUMNS="id" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.id <> :new.id
  THEN
    UPDATE orders
      SET
        /* %SetFK(orders,NULL) */
        orders.id = NULL
      WHERE
        /* %JoinFKPK(orders,:%Old," = ",",") */
        orders.id = :old.id;
  END IF;

  /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
  /* tb_zipcode  member on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="tb_zipcode"
    CHILD_OWNER="", CHILD_TABLE="member"
    P2C_VERB_PHRASE="R/4", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_4", FK_COLUMNS="zipcode" */
  SELECT count(*) INTO NUMROWS
    FROM tb_zipcode
    WHERE
      /* %JoinFKPK(:%New,tb_zipcode," = "," AND") */
      :new.zipcode = tb_zipcode.zipcode;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    :new.zipcode IS NOT NULL AND
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update member because tb_zipcode does not exist.'
    );
  END IF;

  /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
  /* job  member on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="job"
    CHILD_OWNER="", CHILD_TABLE="member"
    P2C_VERB_PHRASE="R/8", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_8", FK_COLUMNS="job_code" */
  SELECT count(*) INTO NUMROWS
    FROM job
    WHERE
      /* %JoinFKPK(:%New,job," = "," AND") */
      :new.job_code = job.job_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    :new.job_code IS NOT NULL AND
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update member because job does not exist.'
    );
  END IF;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/


CREATE  TRIGGER tI_orders BEFORE INSERT ON orders for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- INSERT trigger on orders 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* member  orders on child insert set null */
    /* ERWIN_RELATION:CHECKSUM="0001d6cc", PARENT_OWNER="", PARENT_TABLE="member"
    CHILD_OWNER="", CHILD_TABLE="orders"
    P2C_VERB_PHRASE="R/5", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_5", FK_COLUMNS="id" */
    UPDATE orders
      SET
        /* %SetFK(orders,NULL) */
        orders.id = NULL
      WHERE
        NOT EXISTS (
          SELECT * FROM member
            WHERE
              /* %JoinFKPK(:%New,member," = "," AND") */
              :new.id = member.id
        ) 
        /* %JoinPKPK(orders,:%New," = "," AND") */
         and orders.o_seq = :new.o_seq;

    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* products  orders on child insert set null */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="products"
    CHILD_OWNER="", CHILD_TABLE="orders"
    P2C_VERB_PHRASE="R/7", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="product_code" */
    UPDATE orders
      SET
        /* %SetFK(orders,NULL) */
        orders.product_code = NULL
      WHERE
        NOT EXISTS (
          SELECT * FROM products
            WHERE
              /* %JoinFKPK(:%New,products," = "," AND") */
              :new.product_code = products.product_code
        ) 
        /* %JoinPKPK(orders,:%New," = "," AND") */
         and orders.o_seq = :new.o_seq;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

CREATE  TRIGGER tU_orders AFTER UPDATE ON orders for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- UPDATE trigger on orders 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
  /* member  orders on child update no action */
  /* ERWIN_RELATION:CHECKSUM="000204c7", PARENT_OWNER="", PARENT_TABLE="member"
    CHILD_OWNER="", CHILD_TABLE="orders"
    P2C_VERB_PHRASE="R/5", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_5", FK_COLUMNS="id" */
  SELECT count(*) INTO NUMROWS
    FROM member
    WHERE
      /* %JoinFKPK(:%New,member," = "," AND") */
      :new.id = member.id;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    :new.id IS NOT NULL AND
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update orders because member does not exist.'
    );
  END IF;

  /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
  /* products  orders on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="products"
    CHILD_OWNER="", CHILD_TABLE="orders"
    P2C_VERB_PHRASE="R/7", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="product_code" */
  SELECT count(*) INTO NUMROWS
    FROM products
    WHERE
      /* %JoinFKPK(:%New,products," = "," AND") */
      :new.product_code = products.product_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    :new.product_code IS NOT NULL AND
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update orders because products does not exist.'
    );
  END IF;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/


CREATE  TRIGGER tD_products AFTER DELETE ON products for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- DELETE trigger on products 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* products  orders on parent delete set null */
    /* ERWIN_RELATION:CHECKSUM="0001a824", PARENT_OWNER="", PARENT_TABLE="products"
    CHILD_OWNER="", CHILD_TABLE="orders"
    P2C_VERB_PHRASE="R/7", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="product_code" */
    UPDATE orders
      SET
        /* %SetFK(orders,NULL) */
        orders.product_code = NULL
      WHERE
        /* %JoinFKPK(orders,:%Old," = "," AND") */
        orders.product_code = :old.product_code;

    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* products  rcv_and_frw on parent delete set null */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="products"
    CHILD_OWNER="", CHILD_TABLE="rcv_and_frw"
    P2C_VERB_PHRASE="R/9", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="product_code" */
    UPDATE rcv_and_frw
      SET
        /* %SetFK(rcv_and_frw,NULL) */
        rcv_and_frw.product_code = NULL
      WHERE
        /* %JoinFKPK(rcv_and_frw,:%Old," = "," AND") */
        rcv_and_frw.product_code = :old.product_code;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

CREATE  TRIGGER tU_products AFTER UPDATE ON products for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- UPDATE trigger on products 
DECLARE NUMROWS INTEGER;
BEGIN
  /* products  orders on parent update set null */
  /* ERWIN_RELATION:CHECKSUM="0001e4c9", PARENT_OWNER="", PARENT_TABLE="products"
    CHILD_OWNER="", CHILD_TABLE="orders"
    P2C_VERB_PHRASE="R/7", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_7", FK_COLUMNS="product_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.product_code <> :new.product_code
  THEN
    UPDATE orders
      SET
        /* %SetFK(orders,NULL) */
        orders.product_code = NULL
      WHERE
        /* %JoinFKPK(orders,:%Old," = ",",") */
        orders.product_code = :old.product_code;
  END IF;

  /* products  rcv_and_frw on parent update set null */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="products"
    CHILD_OWNER="", CHILD_TABLE="rcv_and_frw"
    P2C_VERB_PHRASE="R/9", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="product_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.product_code <> :new.product_code
  THEN
    UPDATE rcv_and_frw
      SET
        /* %SetFK(rcv_and_frw,NULL) */
        rcv_and_frw.product_code = NULL
      WHERE
        /* %JoinFKPK(rcv_and_frw,:%Old," = ",",") */
        rcv_and_frw.product_code = :old.product_code;
  END IF;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/


CREATE  TRIGGER tI_rcv_and_frw BEFORE INSERT ON rcv_and_frw for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- INSERT trigger on rcv_and_frw 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* products  rcv_and_frw on child insert set null */
    /* ERWIN_RELATION:CHECKSUM="00022166", PARENT_OWNER="", PARENT_TABLE="products"
    CHILD_OWNER="", CHILD_TABLE="rcv_and_frw"
    P2C_VERB_PHRASE="R/9", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="product_code" */
    UPDATE rcv_and_frw
      SET
        /* %SetFK(rcv_and_frw,NULL) */
        rcv_and_frw.product_code = NULL
      WHERE
        NOT EXISTS (
          SELECT * FROM products
            WHERE
              /* %JoinFKPK(:%New,products," = "," AND") */
              :new.product_code = products.product_code
        ) 
        /* %JoinPKPK(rcv_and_frw,:%New," = "," AND") */
         and rcv_and_frw.rcv_and_frw_seq = :new.rcv_and_frw_seq;

    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* wrhs  rcv_and_frw on child insert set null */
    /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="wrhs"
    CHILD_OWNER="", CHILD_TABLE="rcv_and_frw"
    P2C_VERB_PHRASE="R/11", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="wrhs_code" */
    UPDATE rcv_and_frw
      SET
        /* %SetFK(rcv_and_frw,NULL) */
        rcv_and_frw.wrhs_code = NULL
      WHERE
        NOT EXISTS (
          SELECT * FROM wrhs
            WHERE
              /* %JoinFKPK(:%New,wrhs," = "," AND") */
              :new.wrhs_code = wrhs.wrhs_code
        ) 
        /* %JoinPKPK(rcv_and_frw,:%New," = "," AND") */
         and rcv_and_frw.rcv_and_frw_seq = :new.rcv_and_frw_seq;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

CREATE  TRIGGER tU_rcv_and_frw AFTER UPDATE ON rcv_and_frw for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- UPDATE trigger on rcv_and_frw 
DECLARE NUMROWS INTEGER;
BEGIN
  /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
  /* products  rcv_and_frw on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00022505", PARENT_OWNER="", PARENT_TABLE="products"
    CHILD_OWNER="", CHILD_TABLE="rcv_and_frw"
    P2C_VERB_PHRASE="R/9", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_9", FK_COLUMNS="product_code" */
  SELECT count(*) INTO NUMROWS
    FROM products
    WHERE
      /* %JoinFKPK(:%New,products," = "," AND") */
      :new.product_code = products.product_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    :new.product_code IS NOT NULL AND
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update rcv_and_frw because products does not exist.'
    );
  END IF;

  /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
  /* wrhs  rcv_and_frw on child update no action */
  /* ERWIN_RELATION:CHECKSUM="00000000", PARENT_OWNER="", PARENT_TABLE="wrhs"
    CHILD_OWNER="", CHILD_TABLE="rcv_and_frw"
    P2C_VERB_PHRASE="R/11", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="wrhs_code" */
  SELECT count(*) INTO NUMROWS
    FROM wrhs
    WHERE
      /* %JoinFKPK(:%New,wrhs," = "," AND") */
      :new.wrhs_code = wrhs.wrhs_code;
  IF (
    /* %NotnullFK(:%New," IS NOT NULL AND") */
    :new.wrhs_code IS NOT NULL AND
    NUMROWS = 0
  )
  THEN
    raise_application_error(
      -20007,
      'Cannot update rcv_and_frw because wrhs does not exist.'
    );
  END IF;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/


CREATE  TRIGGER tD_tb_zipcode AFTER DELETE ON tb_zipcode for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- DELETE trigger on tb_zipcode 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* tb_zipcode  member on parent delete set null */
    /* ERWIN_RELATION:CHECKSUM="0000bbbf", PARENT_OWNER="", PARENT_TABLE="tb_zipcode"
    CHILD_OWNER="", CHILD_TABLE="member"
    P2C_VERB_PHRASE="R/4", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_4", FK_COLUMNS="zipcode" */
    UPDATE member
      SET
        /* %SetFK(member,NULL) */
        member.zipcode = NULL
      WHERE
        /* %JoinFKPK(member,:%Old," = "," AND") */
        member.zipcode = :old.zipcode;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

CREATE  TRIGGER tU_tb_zipcode AFTER UPDATE ON tb_zipcode for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- UPDATE trigger on tb_zipcode 
DECLARE NUMROWS INTEGER;
BEGIN
  /* tb_zipcode  member on parent update set null */
  /* ERWIN_RELATION:CHECKSUM="0000e45b", PARENT_OWNER="", PARENT_TABLE="tb_zipcode"
    CHILD_OWNER="", CHILD_TABLE="member"
    P2C_VERB_PHRASE="R/4", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_4", FK_COLUMNS="zipcode" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.zipcode <> :new.zipcode
  THEN
    UPDATE member
      SET
        /* %SetFK(member,NULL) */
        member.zipcode = NULL
      WHERE
        /* %JoinFKPK(member,:%Old," = ",",") */
        member.zipcode = :old.zipcode;
  END IF;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/


CREATE  TRIGGER tD_wrhs AFTER DELETE ON wrhs for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- DELETE trigger on wrhs 
DECLARE NUMROWS INTEGER;
BEGIN
    /* ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00 */
    /* wrhs  rcv_and_frw on parent delete set null */
    /* ERWIN_RELATION:CHECKSUM="0000ca8b", PARENT_OWNER="", PARENT_TABLE="wrhs"
    CHILD_OWNER="", CHILD_TABLE="rcv_and_frw"
    P2C_VERB_PHRASE="R/11", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="wrhs_code" */
    UPDATE rcv_and_frw
      SET
        /* %SetFK(rcv_and_frw,NULL) */
        rcv_and_frw.wrhs_code = NULL
      WHERE
        /* %JoinFKPK(rcv_and_frw,:%Old," = "," AND") */
        rcv_and_frw.wrhs_code = :old.wrhs_code;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

CREATE  TRIGGER tU_wrhs AFTER UPDATE ON wrhs for each row
-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
-- UPDATE trigger on wrhs 
DECLARE NUMROWS INTEGER;
BEGIN
  /* wrhs  rcv_and_frw on parent update set null */
  /* ERWIN_RELATION:CHECKSUM="0000e90f", PARENT_OWNER="", PARENT_TABLE="wrhs"
    CHILD_OWNER="", CHILD_TABLE="rcv_and_frw"
    P2C_VERB_PHRASE="R/11", C2P_VERB_PHRASE="", 
    FK_CONSTRAINT="R_11", FK_COLUMNS="wrhs_code" */
  IF
    /* %JoinPKPK(:%Old,:%New," <> "," OR ") */
    :old.wrhs_code <> :new.wrhs_code
  THEN
    UPDATE rcv_and_frw
      SET
        /* %SetFK(rcv_and_frw,NULL) */
        rcv_and_frw.wrhs_code = NULL
      WHERE
        /* %JoinFKPK(rcv_and_frw,:%Old," = ",",") */
        rcv_and_frw.wrhs_code = :old.wrhs_code;
  END IF;


-- ERwin Builtin 2022년 5월 26일 목요일 오후 4:02:00
END;
/

