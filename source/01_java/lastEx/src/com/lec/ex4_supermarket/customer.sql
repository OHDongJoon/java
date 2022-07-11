--���̺� & ������ ���� 
DROP TABLE CUSTOMER; -- ���� ���̺긣�� ���� ��� ���� �Ұ�
--DROP TABLE CUSTOMER CASCADE CONSTRAINTS; --�����ϴ°� ���� ��� �ȳ��� ���� ����

DROP TABLE CUS_LEVEL;
DROP SEQUENCE CUSTOMER_SEQ; -- ������ ���� 


--���̺�&������ ����
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
    cTEL        VARCHAR2(20), -- ��ȭ��ȣ�� �ݵ�� ������ ��Ʈ��
    cNAME    VARCHAR2(30),
    cPOINT     NUMBER(9,0) DEFAULT 1000,  -- ����Ʈ���� �Է¾��ϸ� �⺻�� õ�� ������
    cAMOUNT   NUMBER(9,0) DEFAULT 0,  -- �������� �ݾ� 
    LEVELNO         NUMBER(1,0) DEFAULT 1 , -- ������ȣ 
    PRIMARY KEY (cID),
    FOREIGN KEY(LEVELNO) REFERENCES CUS_LEVEL(LEVELNO) );
    
-- ���� ������ �Է�(CUS_LEVEL)
INSERT INTO CUS_LEVEL VALUES (1, 'NORMAL', 0 , 999999);  -- ������ȣ , �����̸�, �ο�, ����  0~99 ����
INSERT INTO CUS_LEVEL VALUES (2, 'SILVER', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES (3, 'GOLD', 2000000, 2999999);
INSERT INTO CUS_LEVEL VALUES (4, 'VIP', 3000000, 3999999);
INSERT INTO CUS_LEVEL VALUES (5, 'VVIP', 4000000, 999999999); --  500�� �������� ������ ������ �� �ִ� ������ 
SELECT * FROM CUS_LEVEL;
SELECT * FROM CUSTOMER;

--���� ������ �Է�(CUSTOMER)
INSERT INTO CUSTOMER (cID, cTEL, cNAME)
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-9999-9999','ȫ�浿');

INSERT INTO CUSTOMER VALUES (CUSTOMER_SEQ.NEXTVAL, '010-8888-9999','ȫ�浿', 0, 4000000, 5);

INSERT INTO CUSTOMER 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-7777-7777','�ű浿', 0, 100000, 1);

--���� �׷��� �ʿ��� QUERY
-- 0. �����̸��� �˻� : Vector<String> getLevelNames() �޺��ڽ��� �� Ÿ���� ����
SELECT  LEVELNAME FROM CUS_LEVEL;


-- 1. ���̵� �˻�  :   CustomerDto  cIdGetCustomer (int cId)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP(�󸶻�� �������Ǵ���)
--                                                                  HIGH 99�������� 1���ϱ����ָ� �������Ҽ��ִ� �ݾ��̴ϱ� , 

--                  5�ܰ�� �ְ����̴ϰ� null�� ���;ߴ�  ????

SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO AND CID=1;


-- 2. ��4�ڸ� (FULL)�˻� : ArrayList <CustomerDto> cTelGetCustomer(String cTel)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP(�󸶻�� �������Ǵ���)
    SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO AND CTEL LIKE'%'||'9999';
  
-- 3.  ���̸��˻� : �������� �������� ������ ArrayList<CustomerDto> cNameGetCustomer(String cName) 
     -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP
      SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO AND CNAME ='ȫ�浿' ORDER BY CAMOUNT DESC;
                             

-- 4. ����Ʈ�θ� ���� : int buyWithPoint(1�� id�� 100�� ���� : int cId, int cAmount)
     -- ����Ʈ�� ���űݾ׺��� Ŀ�� ���� ���� 
    -- �ʿ��Ѱ� ���̵� �� ���űݾ�
    UPDATE CUSTOMER SET CPOINT = CPOINT - 100 WHERE CID = 1;
    SELECT * FROM CUSTOMER ;
    COMMIT;
    ROLLBACK;


-- 5. ��ǰ���� : int buy (int cId, int cAmount)
        --��ǰ���� update���� cPoint, cAmount / levelNo�� ����
    --5-1. cPoint, cAmount ����
    UPDATE CUSTOMER SET cPOINT = cPOINT + (1000000*0.05),
                                    cAMOUNT = cAMOUNT + 1000000
                                    WHERE CID=1;
                                    SELECT * FROM CUSTOMER;
    -- 5-2  levelNo �����ϱ� �� ��������ȣ�� ������ ������ȣ 
    SELECT CID, CNAME,CAMOUNT, C.LEVELNO ������, L.LEVELNO �����ɷ���
        FROM CUSTOMER C, CUS_LEVEL L 
            WHERE CAMOUNT BETWEEN LOW AND HIGH  AND CID= 1;
   
    -- 5-3 levelNO
    UPDATE CUSTOMER SET LEVELNO = (
          SELECT  L.LEVELNO 
        FROM CUSTOMER C, CUS_LEVEL L 
            WHERE CAMOUNT BETWEEN LOW AND HIGH  AND CID= 1)
            
            WHERE CID = 1;
            SELECT * FROM CUSTOMER;
    -- 5-1�� 5-3�� ����
   UPDATE CUSTOMER SET  cPOINT = cPOINT + (1000000*0.05),
                                    cAMOUNT = cAMOUNT + 1000000,
                                    LEVELNO =(SELECT L.LEVELNO
                                                         FROM CUSTOMER C, CUS_LEVEL L
                                                            WHERE CAMOUNT+1000000 BETWEEN LOW AND HIGH AND CID=1)
    
                    WHERE CID=1;
                    SELECT * FROM CUSTOMER;




-- 6. ��޺���� : ArrayList<CustomerDto> levelNameGetCustomer(String levelName)
     -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP
     SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME='NORMAL' ORDER BY CAMOUNT DESC;

-- 7. ��ü��� : ArrayList<CustomerDto> getCustomers()
     -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUP
 SELECT CID,CTEL,CNAME,CPOINT,CAMOUNT, LEVELNAME, 
           (SELECT  HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) forLevelUp
                    FROM CUSTOMER C, CUS_LEVEL L
                             WHERE C.LEVELNO = L.LEVELNO  ORDER BY CAMOUNT DESC;


-- 8. ȸ������ : (�����ϸ� 1���� ���� 0����)  int insertCustomer (String cTel, String cName)
INSERT INTO CUSTOMER (CID, CTEL, CNAME)
    VALUES (CUSTOMER_SEQ,NEXTVAL, '010-6666-6666', '���浿');
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER (cID, cTEL, cNAME)
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666','���浿');

-- 9.��ȣ���� : int updateCustomer(int cId, String cTel) 
UPDATE CUSTOMER SET CTEL = '010-5555-5555' WHERE CID = 4;


--10. ȸ��Ż�� :  int deleteCustomer(String cTel)
DELETE FROM CUSTOMER WHERE CTEL='010-5555-5555';
COMMIT;
DELETE FROM CUSTOMER;
