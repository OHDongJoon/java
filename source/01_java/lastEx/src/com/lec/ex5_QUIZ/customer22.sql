-- ���̺� Ȯ�λ���
DROP TABLE CUSTOMER;
DROP SEQUENCE CUSTOMER_SEQ;

-- ���̺� ����
CREATE TABLE CUSTOMER(
sNO     NUMBER(1,0) PRIMARY KEY,
sTEL    VARCHAR2(20) NOT NULL,
sNAME VARCHAR2(30) NOT NULL,
sPOINT NUMBER(9,0) DEFAULT 1000 );
SELECT * FROM CUSTOMER;


--������ ����
CREATE SEQUENCE CUSTOMER_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;

--INSERT INTO CUSTOMER 
  --  VALUES (CUSTOMER_SEQ.NEXTVAL, '010-7777-7777','�ű浿', 0, 100000, 1);

--���̵����� �Է�
INSERT INTO CUSTOMER
    VALUES (CUSTOMER_SEQ.NEXTVAL,'010-9999-9999','������',0);
INSERT INTO CUSTOMER 
    VALUES(CUSTOMER_SEQ.NEXTVAL,'010-8888-8888','������',0);
    SELECT * FROM CUSTOMER;

--1. ȸ������ ���Թ�ư�� ���� ���Ե� ȸ�� ������ Oracle �����ͺ��̽��� ����ȴ�.
--  (�����ϸ� 1���� ���� 0����)  int insertCustomer (String cTel, String cName)
INSERT INTO CUSTOMER (sNO, sTEL, sNAME)
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666', '���浿');
--DELETE FROM CUSTOMER WHERE CTEL='010-5555-5555';

--2. ��4�ڸ� ����ȸ ��ư�� �� ��4�ڸ��ε� ����ü�ε� ��ȸ�Ǹ� ��ȸ�� ����� JtextArea�� ��µȴ�. ���������� ��� ��� ��µȴ�.
--  (FULL)�˻� : ArrayList <CustomerDto> cTelGetCustomer(String cTel)
 
  SELECT*FROM CUSTOMER 
            WHERE  sTEL LIKE'%9999';
                                                          
--���Ǩ���¹�ư�� Ŭ���ϸ�, ���Ե� ��� ȸ�������� JTextArea�� ��µȴ�.
SELECT * FROM CUSTOMER;

COMMIT;



--���Ǩ� �����ư�� Ŭ���ϸ� ����sw�� ����ȴ�.