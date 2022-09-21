CREATE TABLE employee (
    sabun NUMBER NOT NULL,
    name VARCHAR2(50) NOT NULL,
    phone VARCHAR2(50) NOT NULL,
    hireDate DATE NOT NULL,
    email VARCHAR2(50) NOT NULL,
    salary NUMBER NOT NULL,
    buseoNo NUMBER NOT NULL,
    positionNo NUMBER NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (sabun)
);
CREATE SEQUENCE seq_employee START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
SELECT * FROM employee;

CREATE TABLE buseo (
    buseoNo NUMBER NOT NULL,
    buseoName VARCHAR2(50) NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (buseoNo)
);
CREATE SEQUENCE seq_buseo START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;
SELECT * FROM buseo;

CREATE TABLE position (
    positionNo NUMBER NOT NULL,
    positionName VARCHAR2(50) NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (positionNo)
);
CREATE SEQUENCE seq_position START WITH 1 INCREMENT BY 1 NOMAXVALUE NOCACHE;

CREATE TABLE jepum (
    code VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    standard VARCHAR2(50) NOT NULL,
    unit VARCHAR2(50) NOT NULL,
    barcode VARCHAR2(50) NOT NULL,
    wdate DATE NOT NULL,
    PRIMARY KEY (code)
);

INSERT INTO jepum VALUES ('001', 'Æ¼¼ÅÃ÷', 'std', 'uni', 'b001', SYSDATE);
COMMIT;

CREATE TABLE saengsanIpgo (
    gisiCode VARCHAR2(50) NOT NULL,
    gisiDate DATE NOT NULL,
    nabkiDate DATE NOT NULL,
    gisiSu NUMBER NOT NULL,
    sabun NUMBER NOT NULL,
    jepumCode NUMBER NOT NULL,
    processOk VARCHAR2(1) NOT NULL,
    PRIMARY KEY (gisiCode)
);