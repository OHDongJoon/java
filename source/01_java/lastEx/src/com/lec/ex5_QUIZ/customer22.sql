-- 테이블 확인삭제
DROP TABLE CUSTOMER;
DROP SEQUENCE CUSTOMER_SEQ;

-- 테이블 생성
CREATE TABLE CUSTOMER(
sNO     NUMBER(1,0) PRIMARY KEY,
sTEL    VARCHAR2(20) NOT NULL,
sNAME VARCHAR2(30) NOT NULL,
sPOINT NUMBER(9,0) DEFAULT 1000 );
SELECT * FROM CUSTOMER;


--시퀀스 생성
CREATE SEQUENCE CUSTOMER_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;

--INSERT INTO CUSTOMER 
  --  VALUES (CUSTOMER_SEQ.NEXTVAL, '010-7777-7777','신길동', 0, 100000, 1);

--더미데이터 입력
INSERT INTO CUSTOMER
    VALUES (CUSTOMER_SEQ.NEXTVAL,'010-9999-9999','오동준',0);
INSERT INTO CUSTOMER 
    VALUES(CUSTOMER_SEQ.NEXTVAL,'010-8888-8888','최진영',0);
    SELECT * FROM CUSTOMER;

--1. 회원가입 가입버튼을 통해 가입된 회원 정보는 Oracle 데이터베이스에 저장된다.
--  (성공하면 1리턴 실패 0리턴)  int insertCustomer (String cTel, String cName)
INSERT INTO CUSTOMER (sNO, sTEL, sNAME)
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666', '유길동');
--DELETE FROM CUSTOMER WHERE CTEL='010-5555-5555';

--2. 폰4자리 폰조회 버튼은 폰 뒤4자리로도 폰전체로도 조회되며 조회된 결과는 JtextArea에 출력된다. 동명이인일 경우 모두 출력된다.
--  (FULL)검색 : ArrayList <CustomerDto> cTelGetCustomer(String cTel)
 
  SELECT*FROM CUSTOMER 
            WHERE  sTEL LIKE'%9999';
                                                          
--조건⑤출력버튼을 클릭하면, 가입된 모든 회원정보를 JTextArea에 출력된다.
SELECT * FROM CUSTOMER;

COMMIT;



--조건⑥ 종료버튼을 클릭하면 응용sw가 종료된다.