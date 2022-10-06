CREATE TABLE book (
    code NUMBER NOT NULL,
    title VARCHAR2(100) NOT NULL,
    category VARCHAR2(50) NOT NULL, -- 정규화 필요
    author VARCHAR2(50) NOT NULL, -- 정규화 필요
    publisher VARCHAR2(50) NOT NULL, -- 정규화 필요
    publicationDate DATE NOT NULL,
    regiDate DATE NOT NULL,
    PRIMARY KEY (code)
);

CREATE SEQUENCE seq_book START WITH 1000 INCREMENT BY 1 NOMAXVALUE NOCACHE;