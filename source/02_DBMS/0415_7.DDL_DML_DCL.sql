-- [VII] DDL, DML, DCL
-- SQL = DDL( ���̺� ���� , ���̺� ����, ���̺� ��������, ���̺� ��� ������ ����) �� �� ����
  --         DML(�˻� = SELECT, �߰� = INSERT, ����=UPDATE, ���� = DELETE)
  --         DCL(����ڰ�������, ����ڱ��Ѻο�,  ���ѹ�Ż, ����ڰ�������

-- �� VARCHAR2 :���� ���� ���� ������ , (1~4000)  

-- �� CHAR : ���� ���� ���� ������  �Էµ� �ڷ��� ���̿� ��� ���� ������ ���� ��ŭ ����

-- �� NUMBER(w) ; W�ڸ������� ��ġ�� �ִ� 38�ڸ����� �����ϴ�. (38�ڸ��� ��ȿ �����̴�.)

-- �� NUMBER(w, d) ; W�� ��ü ����, d�� �Ҽ��� ���� �ڸ����̴�. �Ҽ����� �ڸ����� ���Ե��� �ʴ´�.

-- �� DATE : BC 4712�� 1�� 1��~AD 4712�� 12�� 31�ϱ����� ��¥


----  ��  CLOB�� e-BOOK�� ���� ��뷮�� �ؽ�Ʈ �����͸� �����ϱ� ���ؼ� ����մϴ�. 


-- �� �� �� DDL �� �� �� 

-- 1. ���̺� ���� (CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID          NUMBER(4),   -- ���� ��ȣ  BOOKID �ʵ� Ÿ���� ���� 4�ڸ�
    BOOKNAME    VARCHAR2(300) , -- å�̸� BOOKNAME �ʵ�� ���� 300BYTE
    PUBLISHER    VARCHAR2(300) , -- ���ǻ� PUBLISHER �ʵ�� ���� 300 BYTE
    RDATE           DATE,                      -- ������ RDATE �ʵ�� DATE��
    PRICE            NUMBER(8),              -- ���� PRICE �ʵ�� ���� 8�ڸ� 
    PRIMARY KEY(BOOKID) );        --  ���̺� �� ��Ű(PRIMARY KEY) ����  -NOT NULL, ������ �� �Է�

SELECT * FROM BOOK;

DROP TABLE BOOK;

CREATE TABLE book (
    bookid              NUMBER (4) PRIMARY KEY,
    BOOKNAME      VARCHAR2 (20), -- ���� ���� ���� ������ , (1~4000)    , CHAR ���� ���� ���� ������  �Էµ� �ڷ��� ���̿� ��� ���� ������ ���� ��ŭ ����
    PUBLISHER      VARCHAR2(20),
    RDATE             DATE,
    PRICE              NUMBER(8) ) ;      
    
    SELECT * FROM BOOK;
    DESC EMP;
    
    SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM : ���̺��� �о���� ���� ����
    SELECT ROWNUM , EMPNO, ENAME FROM  EMP WHERE DEPTNO=20 ORDER BY ENAME;




-- EMP ���̺�� ������ EMP01 : EMPNO(����4) , ENAME(����20), SAL(����7,2)

CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL   NUMBER(7,2) ) ;

-- DEPT�� ������ DEPT01 : DEPTNO(���� 2 , PK) , DNAME(���� 14) , LOC(���� 13)
CREATE TABLE DEPT01 (
    DEPTNO NUMBER(2) ,
    DNAME VARCHAR2(14),
    LOC     VARCHAR2(13),
    PRIMARY KEY(DEPTNO) ) ;
DESC DEPT01;

SELECT * FROM TAB;  -- SCOTT�� ������ ���̺� LIST

--�������� �� �̿��� ���̺� ����

                                            --(��������)
CREATE TABLE EMP02 AS SELECT * FROM EMP;  -- �������� ����� EMP02���̺� ������ �� (������������ ������) ?? 

DESC EMP;

SELECT * FROM EMP02;

DESC EMP02;

    --EX. EMP03 : EMP ���̺��� EMPNO, ENAME, DEPTNO�� ������ �����ͷ� ���̺� 
CREATE TABLE EMP03
        AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
                    SELECT * FROM EMP03;
    
    -- EX EMP04 : EMP ���̺��� 10�� �μ��� ������ �����ͷ� ���̺�
CREATE TABLE EMP04 
                AS SELECT * FROM EMP WHERE DEPTNO = 10;
                            SELECT * FROM EMP04;
    
 
    -- EX EMP 05 : EMP ���̺� ������ ���� �ʵ� Ÿ�Ը� �����ʹ� ��
    CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE 1=0; -- ������ �����;� �Ǳ� ������ WHERE �� 1�� 0�� ���� �̰� ��� �����̴� 
    
    SELECT * FROM EMP05;

    DESC EMP05;
    

---- 2. ���̺� ���� ����(ALTER TABLE)

-- ALTER TABLE ���̺�� ADD  ||  MODIFT || DROP ~

-- (1) �ʵ� �߰� (ADD)  : �߰��� �ʵ��� �����ʹ� NULL

SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO �̰ſ��� 

ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2)); -- JOB SAL �߰�

SELECT * FROM EMP03; 

ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));

-- (2) �ʵ� ���� (MODIFY)
SELECT * FROM EMP03;  -- EMPNO(��4), ENAME(��10), DEPTNO(��2) /  ������ NULL: JOB(��20), SAL(�� 7,2), COMM(�� 7,2)

ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- �̹� ���� �����Ͱ� ��� �־ ������ �ٲٱ� ���̵帣���ϴ�  ���ڷθ� ���� ����
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- ���� ���� Ÿ���� �����ѵ� ��� �ִ� ������ ���� ������ �ȵ� �Ұ���
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- ����
ALTER TABLE EMP03 MODIFY (ENAME NUMBER(4)); -- ���� �����Ͱ� ��� �ִ�  ���¿����� ���ڷθ� ���� ����
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(3000));
DESC EMP03;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6));
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- ���� ( 6BYTE ���� �����Ͱ� �־)

ALTER TABLE EMP03 MODIFY (JOB NUMBER(4));

-- (3) �ʵ� ���� (DROP) 
ALTER TABLE EMP03 DROP COLUMN JOB; -- JOB �ʵ� ���� 
SELECT * FROM EMP03;

-- �������� Ư�� �ʵ带 ���� ���ϵ��� (��)
ALTER TABLE EMP03 SET UNUSED (DEPTNO); -- 
SELECT * FROM EMP03;

-- �������� ���� �Ұ��ߴ� �ʵ带 ���������� ����(����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;
SELECT * FROM EMP03;


-- 3. ���̺� ����( DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- �ٸ� ���̺��� �����ϴ� �����Ͱ� ���� ��� DROP  �ȵ�
SELECT * FROM EMP; 

-- 4. ���̺��� ��� ���� ���� (TRUNCATE) 
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- EMP03���� ��絥���� ���� ( �ѹ� (��ҺҰ�) ������ ����

-- 5. ���̺�� ����(RENAME)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT*FROM EMP2;


-- -6)������ ��ųʸ�(���� �Ұ�) VS. ������ ��ųʸ� ��(����� ���ٿ�)
--����


--USER_XXX : �� ������ �����ϰ� �ִ� ��ü(���̺�, �ε���, ��������, ��)
    --EX.USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS


SELECT * FROM USER_TABLES;  --�� ������ ������ ���̺� ��ü ����
SELECT * FROM USER_INDEXES; --�� ������ ������ �ε��� ����
SELECT * FROM USER_CONSTRAINTS; --�� ������ ������ �������ǵ�
SELECT * FROM USER_VIEWS;   --�� ������ ������ �� ����

--ALL_XXX : �� ������ ���� ������ ��ü(���̺�, �ε���, ��������, ��)
    --EX.ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;

--DBA_XXX : DBA�����ڸ� ���� ����, DBMS�� ��� ��ü
    --EX.DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
    
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;



-- �� �� �� DCL(����ڰ�������, ����ڱ��Ѻο�, ���ѹ�Ż, ����ڰ�������) �� �� �� ????
-- scott2 ���� ����
CREATE USER scott2 IDENTIFIED BY 1234; 
-- ���Ѻο�(���Ǳ���, scott.EMP, scott.DEPT ���̺� ���� ��� ����

GRANT CREATE SESSION TO scott2; -- �α���

GRANT ALL ON EMP TO scott2; -- EMP ���̺� ���� ��� ���� (�˻�, �߰�, ����, ����) SCOTT2 �� EMP ALL�� �ٰ����� 

GRANT ALL ON DEPT TO scott2;

show user;

--���� ��Ż REVOKE : (���ѹ�Ż�� ����ڰ����� �������� �ϰ� �Ҽ�����)
REVOKE ALL ON EMP FROM scott2; -- scott2 �� emp ���̺� ���� ��� ���� ��Ż

REVOKE ALL ON DEPT FROM scott2;
show user;
-- ����� ���� ���� (���� ���� ���� ���� �Ұ�)
DROP USER scott2 CASCADE;


SELECT * FROM EMP WHERE DEPTNO = 10;

-- -----------------------------����

DROP TABLE SAM01;

CREATE TABLE SAM01(
    EMPNO          NUMBER(4),   
    ENAME    VARCHAR2(10) , 
    JOB        VARCHAR2(9) ,
    SAL          NUMBER(7,2),                  
               
               CONSTRAINT SAMPK PRIMARY KEY(EMPNO) );        -- PIRMARY KEY �̸� �ֱ� 
              
                DESC SAM01;
                SELECT * FROM SAM01;
                SELECT * FROM USER_CONSTRAINTS;
                
                
                
-- EMPNO ENAME JOB SAL
--1000 APPLE POLICE 10000
--1010 BANANA NURSE 15000
--1020 ORANGE DOCTOR 25000
--1030 VERY (NULL) 25000
--1040 CAT (NULL) 2000




INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES( 1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES( 1010,'BANANA','NURSE',15000);
INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES(1020,'ORANGE','DOCTOR',25000);
INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES(1030,'VERY', NULL,25000);
INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES(1040,'CAT',NULL,2000);

INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO = 10 ;


                            
                            SELECT * FROM SAM01;
-- Ʈ�����  ��ɾ� 
COMMIT;
--COMMIT : Ʈ����� Ȯ�� (TCL)

-- 2. UPDATE ���̺�� SET �ʵ��1 = ��1 [, �ʵ��2=��2, ...] [WHERE ����] ;

DROP TABLE EMP01;
    CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- EMP01 ���̺��� �μ���ȣ�� 30���� ����(WHERE �� ���̴� ��� ���� ����)
UPDATE EMP01 SET DEPTNO=30;
    ROLLBACK;  Ʈ����� ��� (DML�� ��� ����)
    SELECT * FROM EMP01;

-- EMP01 ���̺��� ��� ����� �޿��� 10%=1.1 �λ�
UPDATE EMP01 SET SAL = SAL * 1.1 ;
SELECT * FROM EMP01;

-- 10�� �μ��� ������ �Ի����� ���÷�, �μ���ȣ�� 30������ ����
UPDATE EMP01 
        SET HIREDATE = SYSDATE , 
            DEPTNO = 30 
                WHERE DEPTNO = 10; 
SELECT * FROM EMP01;

-- SAL�� 3000�̻��� ����� SAL 10%�λ�
UPDATE EMP01
    SET SAL = SAL *1.1 WHERE SAL >= 3000;

-- 'DALLAS'�� �ٹ��ϴ� ������ �޿��� 1000$�� �λ� (�����������)
-- ������ �ȵǴ� �޶󽺿��� �ٹ��ϴ� DEPTNO�������� ���������� 
-- DEPTNO�� SELECT DEPTNO FROM DEPT ���� LOC �޶� 
UPDATE EMP01 
    SET SAL = SAL + 1000 
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC ='DALLAS');
    SELECT * FROM DEPT, EMP ORDER BY LOC ;
    
    -- SCOTT�� �μ���ȣ�� 20���� , JOB�� MANAGER�� , SAL�� COMM�� 500�� �λ�, ��� KING���� ����
    UPDATE EMP01
        SET DEPTNO = 20 , 
            JOB ='MANAGER',
                SAL = SAL + 500 ,
                    COMM = NVL(COMM,0) + 500,
                        MGR = (SELECT EMPNO FROM EMP WHERE ENAME ='KING') 
                        -- ���� �����˿�     ŷ ���   ���� �̿��ǿ��� �������� ������ ŷ �� 
                    WHERE ENAME = 'SCOTT';
                SELECT * FROM EMP01 WHERE ENAME = 'SCOTT';
                SELECT * FROM EMP01 WHERE ENAME = 'KING';
    
    
    SELECT * FROM DEPT01;
    -- DETO01 ���� 20������ �������� DEPT ���̺��� 60���μ��� ���������� ����
    UPDATE DEPT01
        --���Ѵ� ���� LOC�� ( ��� ? 
        SET LOC =(SELECT LOC FROM DEPT WHERE DEPTNO = 60)
            WHERE DEPTNO>=20; -- NULL�� �������� DEPT ���̺��� 60�� �μ��� ��� NULL ������ ����
   
    -- EMP01���̺��� ��� ����� �޿��� �Ի����� 'KING'�� �޿��� �Ի��Ϸ� ����'
 COMMIT;
 ROLLBACK;
    UPDATE EMP01
        SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
                HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
    SELECT * FROM EMP01;
    
UPDATE EMP01
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');
 
 -- DEPT01 ���̺��� 20�� �μ��� ������� �μ����� 40�� �μ��� ������� �μ������� ����
 UPDATE DEPT01
    SET (DNAME,LOC) = (SELECT DNAME,LOC  FROM DEPT01 WHERE DEPTNO = 40 )
    WHERE DEPTNO =20;
 COMMIT;
 
 
 
--3. DELETE FROM ���̺�� [WHERE ����] ;   = �����  =  (TRUNCATE)   -- 4. ���̺��� ��� ���� ����  �ٸ� ���� �ѹ� �����
SELECT * FROM EMP01;
DELETE FROM EMP01;  -- WHERE ���� �� ����� ��ü ���� ��� ���� 
ROLLBACK;


-- EMP01���̺���  'FORD'�� ����� ���� 
    DELETE FROM EMP01
        WHERE ENAME = 'FORD' ;
            SELECT * FROM EMP01 WHERE ENAME ='FORD';

-- EMP01 ���̺��� 30�� �μ� ������ ����
    DELETE FROM EMP01 WHERE DEPTNO = 30;
    SELECT * FROM EMP01;
-- EMP01 ���̺��� �μ����� RESEARCH �μ� ������ ����
    DELETE FROM EMP01
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
            SELECT * FROM EMP01;

-- SAM01 ���̺��� JOB�� �������� ���� ����� ����
SELECT * FROM SAM01;
    DELETE FROM SAM01 
        WHERE JOB IS NULL;
            SELECT * FROM SAM01;
-- SAM01 ���̺��� ENAME�� ORANGE�� ����� �����ϼ���
    DELETE FROM SAM01
        WHERE ENAME =  'ORANGE';
 
 SELECT * FROM SAM01;
 
 
 -- ���� 2
 --1�� ���̺� �����

CREATE TABLE MY_DATA(

ID              NUMBER(4),

NAME            VARCHAR2(30),

USERID        VARCHAR2(30) ,

SALLARY            NUMBER(10,2),

    CONSTRAINT DATA PRIMARY KEY(ID) );

  

    SELECT  *   FROM MY_DATA; 

    -- 2�� MY_DATA INSERT

INSERT INTO MY_DATA (ID, NAME, USERID,  SALLARY )VALUES( 1, 'Scott', 'sscott', 1000000);

INSERT INTO MY_DATA (ID, NAME, USERID, SALLARY  ) VALUES( 2, 'Ford', 'fford' , 1300000);

INSERT INTO MY_DATA (ID, NAME, USERID, SALLARY  ) VALUES( 3, 'Patel', 'ppatel', 3300000);

INSERT INTO MY_DATA (ID, NAME, USERID, SALLARY  ) VALUES( 4, 'Report','rreport',2350000);

INSERT INTO MY_DATA (ID, NAME, USERID, SALLARY  ) VALUES( 5, 'Good' ,'ggood',4445000);

 

--3. ȭ��ó�� SELECT 

SELECT  ID , NAME , USERID , TO_CHAR(SALLARY ,'99,999,99') FROM MY_DATA ORDER BY ID;

 

--4 COMMIT �ϱ� ���ƾ�

COMMIT;

--5. ID 3���� ������� �޿� 65000.00 �ٲٱ� 

UPDATE MY_DATA 

    SET SALLARY = 65000.00 

        WHERE ID = '3';

        SELECT * FROM MY_DATA WHERE ID ='3';

        

-- 6. FORD ��� �����ϰ� Ŀ��  (DELETE �� FROM ��ߴ� )

DELETE FROM MY_DATA 

    WHERE NAME = 'Ford';

        SELECT * FROM MY_DATA 

            WHERE NAME ='Ford';

                    COMMIT;

-- 7. SALARY�� 15,000.00 ������ ����� �޿��� 15,000.00���� �����϶�

UPDATE MY_DATA

    SET SALLARY = 1500000 

            WHERE SALLARY <= 1500000; 

             SELECT * FROM MY_DATA ORDER BY ID;

-- 8 ���� 

    DROP TABLE MY_DATA;
    
    
    -- �ڡڡ� �������� : �������� �����Ͱ� ���̺� ���ԵǴ� ���� �����ϱ� ���� 
    SELECT * FROM EMP ;
    INSERT INTO EMP VALUES (NULL, 'ȫ', NULL, NULL , SYSDATE, NULL, NULL, 40);  -- �Ȱ��� SMITH�� ��ȣ ��� �����ڳ� 
`    UPDATE EMP SET EMPNO=7369 WHERE ENAME = 'ALLEN'; -- SMITH ����� �ߺ� ���� 

-- �� (1) PRIMARY KEY  : �����ϰ� ���̺��� �� ���� �ĺ�. NOT NULL  NULL �ȵǰ� ������ ���� �־�� ��
               INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES  (7369, 'ȫ', 40) ; -- �ߺ� ��� �ԷºҰ�
        
-- (2) NOT NULL        : NULL ���� �������� ���� 

-- (3) UNIQUE            : ��� �࿡ ���� �����ؾ�. NULL���� ��� (NULL�� ������ �Է� ����)

--��(4) FOREIGN KEY  : ���̺��� ���� �ٸ� ���̺��� ���� ���� (EX. EMP���̺��� DEPTNO�� DEPT ���̺��� DEPTNO�� ����)
               
                -- ��ĺ� ���� : �θ����̺��� ��Ű�� �ڽ����̺��� �ϹݼӼ��� ���� �ʵ�� ���� (exERD���� ��������ȭ��ǥ)
                
                -- �ĺ�  ����   :  �θ����̺��� ��Ű�� �ڽ����̺��� ��Ű�� ���� �ʵ�� ���� ( exERD���� �ʷ�����ȭ��ǥ)
                 INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES  (1111, 'ȫ', 90);  -- DEPTNO 90 ������ ���� (�ܷ�Ű�� 90�� �Է� �Ұ�)
    
-- (5) CHECK(����)          :   �ش� ������ ����(NULL�� ���)


--    DEFAULT               : �⺻�� ����( �ش� ���� ������ �Է� ���� ������   NULL�� ��)



CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE, -- �����ؾߵ� NULL �� ��� 
    LOC     VARCHAR2(13)    NOT NULL);


CREATE TABLE EMP1(
    EMPNO    NUMBER(4)          PRIMARY KEY,
    ENAME   VARCHAR2(10)    NOT NULL,
    JOB         VARCHAR2(9)    ,
    MGR         NUMBER(4),
    HIREDATE DATE               DEFAULT SYSDATE, 
    SAL           NUMBER(7,2)     CHECK(SAL>0),
    COMM        NUMBER(7,2),
    DEPTNO     NUMBER(2) REFERENCES DEPT1(DEPTNO));



DROP TABLE EMP1; -- �ڽ����̺�(�����ϴ� ���̺�) ���� DROP
DROP TABLE DEPT1; --�ٸ� ���̺��� �����ϴ� �ʵ尡 ���� ��(�θ����̺���) ���� DROP �� ��.

DROP TABLE DEPT1 CASCADE CONSTRAINTS; -- ���� ( �����ϴ� ���̺��� �־ �����ϰ� DROP)
DROP TABLE DEPT1;
CREATE TABLE DEPT1(
    DEPTNO NUMBER(2),
    DNAME   VARCHAR2(14),
    LOC         VARCHAR2(13) NOT NULL,
    PRIMARY KEY( DEPTNO),
    UNIQUE(DNAME ) );

CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL ,
    JOB     VARCHAR2(9),
    MGR     NUMBER(4),
    HIREDATE    DATE DEFAULT SYSDATE,
    SAL     NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO  NUMBER(2),
    PRIMARY KEY (EMPNO),
    CHECK(SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)); --ī�װ��ڵ�

INSERT INTO DEPT1 SELECT * FROM DEPT;

SELECT * FROM DEPT1;
INSERT INTO DEPT1 VALUES (40, 'IT', 'SEOUL'); --  40 �վ�PK ����
INSERT INTO DEPT1 VALUES (50, 'SALES', 'SEOUL'); -- ����ũ 
INSERT INTO DEPT1 VALUES (50, 'IT', NULL); -- NOT NULL DNLQO


INSERT INTO EMP1 ( EMPNO, ENAME, DEPTNO)
            VALUES ( 1001, ' ȫ', 10);
SELECT * FROM EMP1; -- HIREATE�� ������ �⺻�� �Է� ( EMP1 =HIREDATE    DATE DEFAULT SYSDATE,)

INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO)
    VALUES (1001, '��', 10) -- PK ����

INSERT INTO EMP1 (EMPNO, DEPTNO)
    VALUES (1002, 20); -- ENAME�� NOT NULL ���� ENAME�� �� ������ ������ 

INSERT INTO EMP1 (EMPNO, ENAME, SAL)
    VALUES (1002, '��', -1);  -- SAL > 0  Ŀ�� �Ǵµ� -1 �̿��� 
INSERT INTO EMP1 VALUES (1002, '��', NULL , MGR ,TO_DATE( '95/01/01', 'YY/MM/DD'),900,NULL,99);  -- FK ���� 



SELECT * FROM DEPT1;

 
 -- �������� (PDF, 4,5������)
 CREATE TABLE  BOOKCATEGORY(
    CATEGORY_CODE    NUMBER(3) PRIMARY KEY,
    CATEGORY_NAME   VARCHAR2(50) UNIQUE,
    OFFICE_LOC            VARCHAR2(50) NOT NULL);
 

  --BOOKCATEGORY
 INSERT INTO BOOKCATEGORY VALUES (100,'ö��','3�� �ι���');
  INSERT INTO BOOKCATEGORY VALUES (200,'�ι�','3�� �ι���');
   INSERT INTO BOOKCATEGORY VALUES (300,'�ڿ�����','4�� ���н�');
    INSERT INTO BOOKCATEGORY VALUES (400,'IT','4�����н�');
  SELECT * FROM BOOKCATEGORY;
 ------------------------------------------------------------
 
 CREATE TABLE BOOK(
    CATEGORY_CODE   NUMBER(3),
    BOOKNO              VARCHAR2(10)  PRIMARY KEY,
    BOOKNAME              VARCHAR(50),
    PUBLISHER               VARCHAR(50),
    PUBYEAR                   NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE),
    FOREIGN KEY(CATEGORY_CODE) REFERENCES BOOKCATEGORY(CATEGORY_CODE)
 );
 SELECT * FROM BOOK;
 
 --BOOK 
 INSERT INTO BOOK VALUES(100,'100A01','ö������ ��', '��������',2021);
 INSERT INTO BOOK VALUES(400,'400A01','�̰���DB��','��������',2018-11-30);
 INSERT INTO BOOK VALUES (400,'400A02','�̰���D��','������',2018);
---------------------------------------------------------------------------------------------
----5������ ````````````````-----------------------------------------
CREATE TABLE (
    MAJOR_CODE   NUMBER(2) PRIMARY KEY,
    MOJOR_NAME    VARCHAR(50) UNIQUE,
    MAJOR_LOC      VARCHAR(50) NOT NULL
);
 SELECT * FROM MAJOR;
 
 
 INSERT INTO MAJOR VALUES(1,'�濵����','�濵��305ȣ');
 INSERT INTO MAJOR VALUES(2,'����Ʈ�������','������ 808ȣ');
 INSERT INTO MAJOR VALUES(3,'������','������606ȣ');
 INSERT INTO MAJOR VALUES(4,'����','����202ȣ');

 
 CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR(3) PRIMARY KEY,
    STUDENT_NAME VARCHAR(50) NOT NULL,
    SCORE                  NUMBER(3)  ,       ------------ ��� 
    MAJOR_CODE   NUMBER(2),
    FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE)
   );
 INSERT INTO STUDENT VALUES('A01','��浿',100,1);
  INSERT INTO STUDENT VALUES('A02','���浿',90,2);
   INSERT INTO STUDENT VALUES('A03','ȫ�浿',95,1);
 SELECT * FROM STUDENT;