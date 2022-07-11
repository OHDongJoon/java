-- [x] VIEW , INLINE VIEW , TOP-N ����

-- 1. VIEW : ������ ���̺� (1)�ܼ��� (2) ���պ�

-- (1) �ܼ��� : �ϳ��� ���̺�� ������ �� 
--EMPv0�̶�� VIEW ���� �Ǵ� ���� = EMP���̺� �Ϻ� �ʵ带���� ������ ���̺�
 -- ������ ��ųʸ� �� Ȯ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; -- DDL�� �����ϸ� �����͵�ųʸ� �ڵ� ���� 

SELECT * FROM USER_VIEWS;
SELECT * FROM EMPv0; --������ ���̺�
INSERT INTO EMPv0 VALUES (1111,'ȫ','ITMANAGER',7369,SYSDATE, 40); -- �信 INSERT�ϸ� EMP ���̺��� INSERT �� 

SELECT * FROM EMPv0 WHERE EMPNO= 1111; -- 'ȫ' Ȯ��

SELECT * FROM EMPv0;
SELECT * FROM EMP; -- EMP���� �����Ͱ� �� 
UPDATE EMPv0 SET JOB='MANAGER' WHERE EMPNO = 1111; -- ������Ʈ�� ���� 

DELETE FROM EMPv0 WHERE EMPNO=1111; -- �� DELETE �ϸ� EMP ������ DELETE ��  �Ϳ� 


-- EMPv0�̶�� VIEW : EMP���̺��� 30�� �μ��ุ
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT * FROM EMP WHERE DEPTNO=30;
    DESC EMPv0;
SELECT * FROM EMPv0;
-- 30�� �μ� INSERT
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE,9000, 900, 30); --30�� �μ� INSERT

--40�� �μ� �Է� �ȳ���  ������ ���̺��̱� ������ 30���μ��� �����س��� ������ ���� EMP������ ����
INSERT INTO EMPv0 VALUES (1112, '��', NULL, NULL, SYSDATE, 8000, 800, 40);
SELECT * FROM EMPv0;--�ȳ���  ������ ���̺��̱� ������ 30���μ��� �����س��� ������ ���� EMP������ ����
SELECT * FROM EMP;  -- ���⼭�� �� ���̺��̱� ������ ����
DELETE FROM EMPv0 WHERE EMPNO IN(1111,1112); -- 1111�� �������� 1112�� EMP���� �� ������ 
 -- EMPv0 �� ó���� 30���μ��� ������ ���� ���⿡ 30���� �ִٰ� ������ 1111�� ������ 
 DELETE FROM EMP WHERE EMPNO = 1112; --40�� �μ� EMP ���� ���� 
 
-- EMPv0 �� ���� : ENAME, JOB, HIREDATE������ ��  (NOT NULL �ʵ带 �������ϸ� INSERT �Ұ�  )
CREATE OR REPLACE VIEW EMPv0
    AS SELECT ENAME, JOB, HIREDATE FROM EMP; -- ���� �����°Ծƴϰ� �Ϻ� �ʵ常 ������
    
INSERT INTO EMPv0 VALUES ('ȫ','SALESMAN', SYSDATE); -- �̷��� �ϸ� EMPNO�� NULL�� ���µ� EMPNO�� NOTNULL �̱⶧���� �ȵ�
SELECT * FROM EMPv0;
COMMIT;




-- VIEW�� ���� ���� (1) ���� ����  (2) �б�����

-- WITH CHECK OPTION ������ ��� ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ���� 

-- WITH READ ONLY�� ������ ��� �б� ���� ��

-- EMPv0 : EMP���̺��� 30�� �μ���
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT * FROM EMP WHERE DEPTNO =30
        WITH CHECK OPTION;
INSERT INTO EMPv0 VALUES (1111,'ȫ', NULL, NULL, SYSDATE, 9000,900,30); -- 30�� �μ��� INSERT 
INSERT INTO EMPv0 VALUES (1112,'ȫ', NULL, NULL, SYSDATE, 9000,900,40); -- WHERE ���ǿ� �������� ������ �Ұ�

SELECT * FROM EMP;
SELECT * FROM EMPv0;
DELETE FROM EMPv0 WHERE ENAME='SMITH'; -- 20�� �μ� SMITH
DELETE FROM EMPv0 WHERE EMPNO=1111; -- 30�� �μ� DELETE


-- EMPv0 : �б����� �� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO FROM EMP
    WITH READ ONLY; -- �б� ����  ����Ʈ �� �ƹ����Գ� ���� 
INSERT INTO EMPv0 VALUES (1111,'ȫ', NULL, NULL, 40) ; -- ���� (�б�����)




-- (2) ���պ� : 2�� �̻��� ���̺�� ������ ���̰ų� ������ �ʵ�� �並 ���� ���. DML���� ���������� ���
-- �� 2�� �̻��� ���̺� �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM EMPv0;

INSERT INTO EMPv0 VALUES (1111, 'HONG', 'MANAGER', 'RESEARCH', 'DALLAS') ; -- ���պ�� ���� �Ұ���

-- �� ������ �ʵ�� ��  : �÷��� ��Ī (�����ڷν���, ������, ����, _) �� �̿��Ͽ� �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL*12 "YEAR_SAL"FROM EMP WHERE DEPTNO= 10; -- (SAL*12�� ����)
    SELECT * FROM EMPv0;

CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL)   -- �䷸�Ե� ����   ��Ī�鸸 ���� ���� 
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO= 10;
    SELECT * FROM EMPv0;
    INSERT INTO EMPv0 VALUES (1111, 'ȫ', 2400); -- ���պ�� ���� �Ұ� 


-- ex. �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���ձ޿��� ������ DEPTv1 �並 ���� 
CREATE OR REPLACE VIEW DEPTv1(DEPTNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO,MIN(SAL),MAX(SAL),AVG(SAL) FROM EMP  
        GROUP BY DEPTNO;

-- ex. ��å, �μ��� ������ EMPv0 �並 ����
SELECT * FROM DEPTv1;


-- ex. ��å, �μ��� ������ EMPv0 �並 ���� : DISTINCT�� ������ ��� �б� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT  JOB, DEPTNO FROM EMP ORDER BY DEPTNO;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES ('CLERK', 10); -- �б� �����̶� ���� 


-- 2. INLINE VIEW : FROM�� ���� �������� INLINE VIEW�� �ϸ�, FROM���� ���� ���������� VIEWó�� �ۿ� 
-- ex. �޿��� 2000�� �ʰ��ϴ� ����� ��� �޿� 
SELECT AVG(SAL) FROM EMP WHERE SAL > 2000; -- EMP���̺��߿� 2000�Ѵ¾� ��� 
SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000);

--EX. �μ� ��� ���޺��� ���� ����� ���, �̸� �޿� �������� �������� 24,15

SELECT EMPNO, ENAME, SAL
        FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO ); --������

SELECT EMPNO, ENAME, SAL , AVGSAL
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) A 
    WHERE E.DEPTNO=A.DEPTNO AND SAL>AVGSAL; -- INLINE VIEW
        

-- 3. TOP-N ���� ( TOP 1~10�� / TOP 11~20�� /TOP 6~10��)
-- �� ROWNUM : FROM�� ���̺�κ��� �����¼���
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME ;
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20;

-- ���, �̸�, SAL (��ü�࿡ ����) 
SELECT ROWNUM,ENAME, SAL FROM EMP ORDER BY SAL DESC; -- ROWNUM�� ����� �ƴϰ� ���̺�� ���� ������ ���� 
                                                                        -- �� �������� ������ ����
SELECT ROWNUM RANK, ENAME, SAL FROM  (SELECT * FROM EMP ORDER BY SAL DESC); -- ROWNUM�� ��� 

-- �Լ��� �̿��� RANK ��� (��TO THE ��)
SELECT RANK() OVER(ORDER BY SAL DESC) RANK, 
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,
    ENAME, SAL FROM EMP;

-- SAL �������� 1~5�� 






SELECT ROWNUM, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 5; -- 1~ 5�� 

--SAL �������� 6~10��
SELECT ROWNUM, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 6 AND 10; -- �ȳ��Ϳ� �Ф� ����! �����ϴ¾ְ� ������ 1�̵Ǳ⶧���� 6�̻� 10�� ���ü��� ���� 
    
-- �� TOP - N ���� 1�ܰ� ���� ���
SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);
--�� TOP - N ���� 2�ܰ� (�ϼ��� TOP-N ����) RN �����ƽ� �ʿ�
SELECT ROWNUM, RN, ENAME, SAL 
    FROM(SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC))
    WHERE RN BETWEEN 1 AND 5 ;
    
-- �̸��� ���ĺ� ������� �����ؼ� 6~10��°���� ���(��� , �̸�, ��� , JOB, MGR, HIREDATE)

SELECT ROWNUM RN , ENAME,EMPNO, JOB, MGR,HIREDATE FROM (SELECT * FROM EMP ORDER BY ENAME);
SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM(SELECT ROWNUM RN , ENAME,EMPNO, JOB, MGR,HIREDATE FROM (SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;
    



-- �� ��������

-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
    SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER)
    AS SELECT W.ENAME, M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). -- �л� ����
SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC; -- �μ��� �հ� ���(�޿��հ� ��������)
SELECT DEPTNO, SUM, ROWNUM RANK
    FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC);

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.


SELECT *
    FROM (SELECT DEPTNO, SUM, ROWNUM RANK
            FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM DESC))
    WHERE RANK BETWEEN 2 AND 3;

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT *
    FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC)
    WHERE ROWNUM<=5; -- TOP N ������ �ƴ�




-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT ROWNUM RN, A.*
    FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A; -- �ֽź��� ������ ������ ��ü
SELECT EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10; 







