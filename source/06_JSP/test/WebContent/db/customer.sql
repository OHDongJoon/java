DROP TABLE CUSTOMER CASCADE CONSTRAINTS;
CREATE TABLE CUSTOMER(
    CID VARCHAR2(50) PRIMARY KEY,
    CNAME VARCHAR2(50) NOT NULL,
    CPW VARCHAR2(50) NOT NULL,
    CTEL VARCHAR2(50) NOT NULL,
    CEMAIL VARCHAR2(50) ,
    CADDRESS VARCHAR2(50),
    CGENDER VARCHAR2(10) ,
    CBIRTH DATE ,
    CRDATE DATE 
);
--1. 회원가입시 ID 중복체크 : public int confirmID(String id)
SELECT * FROM CUSTOMER WHERE CID='aaa';

--2.회원가입 : public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER (CID,CNAME,CPW,CTEL,CEMAIL,CADDRESS,
    CGENDER,CBIRTH,CRDATE)
    VALUES('aaa','오동준','111','010-9603-0024','abc@aaa.com','서울','m',
    '1995-10-10',SYSDATE);
    
--3.로그인 (id/pw) : public int loginCheck(String id , String pw)
SELECT CID,CPW FROM CUSTOMER WHERE CID ='aaa';

--4. ID로 dto(모든변수값) 가져오기 : public CustomerDto getCustomer(String id)
SELECT * FROM CUSTOMER WHERE CID='aaa';

--5.회원정보 수정 : public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CNAME='오원빈',
                                        CPW='111',
                                        CTEL='010-9603-0025',
                                        CEMAIL = 'a@a.com',
                                        CADDRESS = '제주',
                                        CGENDER = 'f',
                                        CBIRTH ='1990-12-01'
                                        WHERE CID='aaa';
    commit;
    select * from customer;