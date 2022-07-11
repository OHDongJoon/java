--테이블 & 시퀀스 삭제 
DROP TABLE CUSTOMER; -- 참조 테이브르이 있을 경우 삭제 불가
--DROP TABLE CUSTOMER CASCADE CONSTRAINTS; --참조하는게 뭔지 기억 안날때 강제 삭제

DROP TABLE CUS_LEVEL;
DROP SEQUENCE CUSTOMER_SEQ; -- 시퀀스 삭제 


--테이블&시퀀스 생성
-- CRATE TABLE ((CUS_LEVEL -> CUSTOMER)
CREATE TABLE CUS_LEVEL(
   LEVELNO          NUMBER(1,0),
   LEVELNAME      VARCHAR2(20),
   LOW                  NUMBER(9,0),
   HIGH                NUMBER(9,0),
   PRIMARY KEY(LEVELNO) );
   
   
CREATE SEQUENCE CUSTOMER_SEQ MAXVALUE 999999 NOCACHE NOCYCLE; 
DROP TABLE CUSTOMER_SEQ;


CREATE TABLE CUSTOMER(
    cID         NUMBER(6,0),
    cTEL        VARCHAR2(20), -- 전화번호는 반드시 바차로 인트놉
    cNAME    VARCHAR2(30),
    cPOINT     NUMBER(9,0) DEFAULT 1000,  -- 포인트점수 입력안하면 기본값 천점 구냥줌
    cAMOUNT   NUMBER(9,0) DEFAULT 0,  -- 누적구매 금액 
    LEVELNO         NUMBER(1,0) DEFAULT 1 , -- 레벨번호 
    PRIMARY KEY (cID),
    FOREIGN KEY(LEVELNO) REFERENCES CUS_LEVEL(LEVELNO) );
    
-- 더미 데이터 입력(CUS_LEVEL)
INSERT INTO CUS_LEVEL VALUES (1, 'NORMAL', 0 , 999999);  -- 레벨번호 , 레벨이름, 로우, 하이  0~99 만원
INSERT INTO CUS_LEVEL VALUES (2, 'SILVER', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES (3, 'GOLD', 2000000, 2999999);
INSERT INTO CUS_LEVEL VALUES (4, 'VIP', 3000000, 3999999);
INSERT INTO CUS_LEVEL VALUES (5, 'VVIP', 4000000, 999999999); --  500이 넘을수도 있으니 설정한 값 최대 값으로 
SELECT * FROM CUS_LEVEL;
SELECT * FROM CUSTOMER;

--더미 데이터 입력(CUSTOMER)
INSERT INTO CUSTOMER (cID, cTEL, cNAME)
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-9999-9999','홍길동');

INSERT INTO CUSTOMER VALUES (CUSTOMER_SEQ.NEXTVAL, '010-8888-9999','홍길동', 0, 4000000, 5);

INSERT INTO CUSTOMER 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-7777-7777','신길동', 0, 100000, 1);

--프로 그램에 필요한 QUERY
-- 0. 레벨이름들 검색 : Vector<String> getLevelNames() 콤보박스에 들어갈 타입은 벡터
SELECT  LEVELNAME FROM CUS_LEVEL;


-- 1. 아이디 검색  :   CustomerDto  cIdGetCustomer (int cId)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP(얼마사면 레벨업되는지)
--                                                                  HIGH 99만원에서 1더하기해주면 레벨업할수있는 금액이니까 , 

--                  5단계는 최고등급이니가 null이 나와야댐  ????

SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO AND CID=1;


-- 2. 폰4자리 (FULL)검색 : ArrayList <CustomerDto> cTelGetCustomer(String cTel)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP(얼마사면 레벨업되는지)
    SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO AND CTEL LIKE'%'||'9999';
  
-- 3.  고객이름검색 : 동명이인 있을수도 있으니 ArrayList<CustomerDto> cNameGetCustomer(String cName) 
     -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP
      SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO AND CNAME ='홍길동' ORDER BY CAMOUNT DESC;
                             

-- 4. 포인트로만 구매 : int buyWithPoint(1번 id가 100원 구매 : int cId, int cAmount)
     -- 포인트가 구매금액보다 커야 구매 가능 
    -- 필요한거 아이디 랑 구매금액
    UPDATE CUSTOMER SET CPOINT = CPOINT - 100 WHERE CID = 1;
    SELECT * FROM CUSTOMER ;
    COMMIT;
    ROLLBACK;


-- 5. 물품구매 : int buy (int cId, int cAmount)
        --물품구매 update에는 cPoint, cAmount / levelNo가 수정
    --5-1. cPoint, cAmount 변경
    UPDATE CUSTOMER SET cPOINT = cPOINT + (1000000*0.05),
                                    cAMOUNT = cAMOUNT + 1000000
                                    WHERE CID=1;
                                    SELECT * FROM CUSTOMER;
    -- 5-2  levelNo 변경하기 전 현레벨번호와 수정될 레벨번호 
    SELECT CID, CNAME,CAMOUNT, C.LEVELNO 현레벨, L.LEVELNO 수정될레벨
        FROM CUSTOMER C, CUS_LEVEL L 
            WHERE CAMOUNT BETWEEN LOW AND HIGH  AND CID= 1;
   
    -- 5-3 levelNO
    UPDATE CUSTOMER SET LEVELNO = (
          SELECT  L.LEVELNO 
        FROM CUSTOMER C, CUS_LEVEL L 
            WHERE CAMOUNT BETWEEN LOW AND HIGH  AND CID= 1)
            
            WHERE CID = 1;
            SELECT * FROM CUSTOMER;
    -- 5-1과 5-3을 합쳐
   UPDATE CUSTOMER SET  cPOINT = cPOINT + (1000000*0.05),
                                    cAMOUNT = cAMOUNT + 1000000,
                                    LEVELNO =(SELECT L.LEVELNO
                                                         FROM CUSTOMER C, CUS_LEVEL L
                                                            WHERE CAMOUNT+1000000 BETWEEN LOW AND HIGH AND CID=1)
    
                    WHERE CID=1;
                    SELECT * FROM CUSTOMER;




-- 6. 등급별출력 : ArrayList<CustomerDto> levelNameGetCustomer(String levelName)
     -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP
     SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME='NORMAL' ORDER BY CAMOUNT DESC;

-- 7. 전체출력 : ArrayList<CustomerDto> getCustomers()
     -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP
 SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO  ORDER BY CAMOUNT DESC;


-- 8. 회원가입 : (성공하면 1리턴 실패 0리턴)  int insertCustomer (String cTel, String cName)
INSERT INTO CUSTOMER (CID, CTEL, CNAME)
    VALUES (CUSTOMER_SEQ,NEXTVAL, '010-6666-6666', '유길동');
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER (cID, cTEL, cNAME)
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666','유길동');

-- 9.번호수정 : int updateCustomer(int cId, String cTel) 
UPDATE CUSTOMER SET CTEL = '010-5555-5555' WHERE CID = 4;


--10. 회원탈퇴 :  int deleteCustomer(String cTel)
DELETE FROM CUSTOMER WHERE CTEL='010-5555-5555';
COMMIT;
DELETE FROM CUSTOMER;
