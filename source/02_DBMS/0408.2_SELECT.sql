--[IT] SELECT -- ���� ���� ���̴� DML(Data Mainpulation Lanfuage) : �˻� ��� 
-- 1. SQL SELECT���� �ۼ���
-- SHOW USER ���� ������ (���� ctrl + Enter)
SHOW USER; 

SELECT * FROM TAB; -- �� ����(scott)�� ������ �ִ� ���̺�  *�̰� ��� ��

SELECT* FROM EMP; -- EMP ���̺��� ��� ��(�ʵ�), �����

SELECT * FROM DEPT; -- DEPT ���̺��� ��� ��, ��� ��

--EMP ���̺��� ���� 

DESC EMP;

DESC DEPT;

-- 2. SQL�� ���� (Ư�� ���� ���)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;

SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB FROM EMP; -- ��Ī

SELECT EMPNO AS ���,  ENAME AS �̸�,  SAL AS �޿�,  JOB FROM EMP;

SELECT EMPNO  "�� ��",  ENAME  "�� ��",  SAL "�� ��",  JOB FROM EMP;

SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP; --TITLE :NO,  NAME,  SALARY



-- 3. Ư�� �� ��� : WHERE ��(����) - �񱳿����� ; ����(=), ũ�ų����� (>=) , �ٸ���(!=, ^=, <>) 
SELECT EMPNO "���", ENAME "�̸�" , SAL "�޿�" FROM EMP  WHERE SAL = 3000;

SELECT EMPNO "���", ENAME "�̸�" , SAL "�޿�" FROM EMP  WHERE SAL != 3000;

SELECT EMPNO "���", ENAME "�̸�" , SAL "�޿�" FROM EMP  WHERE SAL ^= 3000;

SELECT EMPNO "���", ENAME "�̸�" , SAL "�޿�" FROM EMP  WHERE SAL <> 3000;


                        --- �� �����ڴ� ����, ����, ��¥�� ��� ����-----------
                        ----����̸�(ENAME)�� 'A','B','C'�� �����ϴ� �ÿ��� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME < 'D'; 
        -- 81�⵵ ������ �Ի��� ����� ��� �ʵ�
    
    SELECT * FROM EMP WHERE HIREDATE < '81/01/01';    

                    -- ex. 10�� �μ���ȣ(deptno)�� ����� ��� �ʵ带 ���
SELECT* FROM EMP WHERE DEPTNO=10;

        --ex. �̸��� (ENAME)�� FORD�� ������ EMPNO, ENAME, MGR(����� ���)�� ���
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';
select empno, ename, mgr from emp where ename = 'FORD'; -- �����ʹ� ��ҹ��� ����


--- 4. �������� : AND, OR
        -- eX. �޿� (SAL)�� 2000�̻� 3000�̸��� ������ ��� �ʵ�
SELECT*FROM EMP WHERE SAL>=2000 AND SAL<=3000;

---ex 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';

                --��¥ ǥ��� ����(���� : YY/MM/DD OR RR/MM/DD) ���� �̷��� ���� ������ 
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';

ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

SELECT ENAME, HIREDATE FROM EMP;

        --������ 2400 �̻��� ������ ENAME, SAL, ���� ��� (������ SAL*12)

SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12 > 2400;
--SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE ����*12 > 2400; -- WHERE ������ ��Ī�� �� �� ����

SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12>2400 ORDER BY ����; -- ORDER BY���� ��Ī���

--  10�� �μ�(DEPTNO)�̰ų� ��å�� MANAGER�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB='MANAGER';

--�μ� ��ȣ�� 10���� �ƴ� ����� ��� �ʵ� ���

SELECT * FROM EMP WHERE DEPTNO != 10;

SELECT * FROM EMP WHERE NOT DEPTNO = 10;



-- 5. ���ǥ����
SELECT ENAME, SAL "����޿�",SAL+100 "�ø� �޿�" FROM EMP WHERE DEPTNO = 10;

            -- ex. ��� ����� �̸� (ENAME), ����(SAL), ��(COMM) , ����(SAL*12+COM)
            --��������� ����� NULL�����ϸ� ����� NULL 
            -- NVL(NULL�� ���� �ִ� �ʵ��, ��ġ��) �ݵ�� �Ű����� ���� Ÿ���� ���ƾ� ��
            
            
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;

SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP;


        ---��� ����� �����(ENAME), ����� ���(MGR) �� ���(��������  (����) = 0)
SELECT ENAME, NVL(MGR,0) FROM EMP;
        
SELECT ENAME, NVL(MGR,'����') FROM EMP;  -- NBL �Ű����� Ÿ�� ����ġ ����


-- 6. ���Ῥ����(||) : ���̳� ���ڸ� ���� 
SELECT ENAME  || '��' || JOB "EMPLOYESS" FROM EMP;

        --ex. "SMITH : ���� = XXX"�� ���� ��� �� ���(���� = SAL*12+COMM)
SELECT ENAME || ': ���� = ' || (SAL*12+NVL(COMM,0)) FROM EMP;



--7. �ߺ����� (DISTINCT)
SELECT JOB FROM EMP;

SELECT DEPTNO FROM EMP ;

SELECT DISTINCT JOB FROM EMP;

SELECT DISTINCT DEPTNO FROM EMP;


-- �� �������� �� Ǯ��
    --1. emp ���̺��� ���� ���(����Ŭ������ ��������)
DESC EMP;
DESC DEPT;

    --2. emp ���̺��� ��� ������ ���
SELECT*FROM EMP;

    --3. �� scott �������� ��밡���� ���̺� ���
SHOW USER;
SELECT*FROM TAB;  -- ���� ������ ������ �ִ� ���̺�

    --4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO AS "���" ,ENAME AS "�̸�" ,SAL AS "�޿�" ,JOB AS "����", HIREDATE "�Ի���"  FROM EMP;

    --5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL < 2000;

    --6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO,ENAME,JOB,HIREDATE FROM EMP 
WHERE HIREDATE >'81/02/01'; 

    -- TO_CHAR(��¥�� �����͸� Ư���� �������� ����)
SELECT EMPNO,ENAME,JOB,HIREDATE FROM EMP 
WHERE TO_CHAR(HIREDATE,'RR/MM/DD') >= '81/02/01'; 

    --TO_DATE(������ �����͸� Ư���� �������� ����)
SELECT EMPNO,ENAME,JOB,HIREDATE FROM EMP 
WHERE HIREDATE >= TO_DATE('81/02/01', 'YYYY-MM-DD'); 

        --DESC EMP;(����Ÿ������ Ȯ���ϴ¹�)

        -- # ��¥ ���� (YYYY �⵵ 4�ڸ� , RR �⵵ 2�ڸ� , M�� , D ��)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT ='RR/MM/DD';

    -- # ��¥�� -> ������ ��ȯ�ϴ� �Լ� :  TO_CHAR(��¥�������͸�, ����)
    -- # ������ -> ��¥�� ��ȯ�ϴ� �Լ� : TO_DATE(�����������͸�, ����)

        --7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';

        --8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ��� <> , ^= , NOT ,
SELECT * FROM EMP WHERE JOB != 'CLERK';

        --9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;

         --10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

        --11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO,ENAME,JOB,DEPTNO, SAL FROM EMP WHERE  JOB = 'SALESMAN' OR SAL >=3000;

        --12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER' ;

        --13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���((SAL*12+NVL(COMM,0)) FROM EMP;
SELECT ENAME || '��   ' || JOB || '   �����̰� ������   ' || (SAL *12 +NVL(COMM,0)) FROM EMP;





-------8. SQL ������(BETWEEN, IN  , LIKE, IS NULL_
        --(1) ������ BETWEEON A AND B (A<=B)
        -- ex . SAL ��   1500�̻� 3000������ ��� �̸� �޿�
        
        -----------------------------------(WHERE  SAL) BETWEEON -------------------------
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >=1500 AND SAL<= 3000;

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500; -- X


--  EX. 1500�̸�, 3000�ʰ��ϴ� ��� �ʵ� ( NOT)
SELECT * FROM EMP  WHERE SAL  NOT BETWEEN 1500 AND 3000;
  
    --ex . 82�⵵�� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';

SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND '82/12/31';

    --ex . ����̸��� 'A', 'B'�� �����ϴ�  ����� ��� �ʵ� 
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME != 'C'; --A����ũ�� C���� ���ų�������  ,  ������ AND ENAME != C

    -- ex. ����̸��� 'B','C'�� �����ϴ�  ����� ����ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME != 'D';

  -----------------  -- -------------------------(2)������ IN (A,B,C...)------------------------------------
        -- ex. �μ���ȣ�� 10,20,40���� �μ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO =10 OR DEPTNO = 20 OR DEPTNO = 40;

SELECT * FROM EMP WHERE DEPTNO IN (10,20,40);
    
 ------------------   ------------ NOT IN ------------------------------------------
    -- ex. �μ���ȣ�� 10,20,40�� �μ��� ������ ����� ����ʵ� 
SELECT * FROM EMP WHERE DEPTNO NOT IN(10,20,40);

    -- ex. ����� 7902, 7788, 7566�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE EMPNO IN(7902,7788,7566);



-----------(3) LIKE ����----------
-- (����) ������ LIKE ����(%

    --EX �̸��� M�� �� ����� ��� �ʵ�


SELECT * FROM EMP WHERE ENAME LIKE '%M%';

   --EX �̸��� M���� �����ϴ� ����� ����ʵ�
   SELECT * FROM EMP WHERE ENAME LIKE 'M%';
   
   -- EX �̸��� S�� ������ �� ������ ����ʵ�
   SELECT * FROM EMP WHERE ENAME LIKE '%S';
   
   --EX SAL�� (����)  5�� ������ ����� ��� �ʵ�------------
   SELECT * FROM EMP WHERE SAL LIKE '%5';
   SELECT * FROM EMP WHERE SAL = '2975'; -- �������� ������ �� ����
   
   --EX 82 �⵵�� �Ի��� ����� ��� �ʵ�
   SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
   
   --EX 10�⵵ �� �Ի������� TO_CHAR
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
 
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82' ;  
   
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,  'RR') = 82;
   
   --EX 1���� �Ի��� ����� ��� �ʵ�
   
   SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '__/01/__';
   
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '01';
   
   -- 82 �ƴ�
   SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';
   
    -- EX. �̸��� %�� �� ����� ��� �ʵ� 
    SELECT * FROM EMP  WHERE ENAME LIKE '%%%' ;  -- % 0�����̻� �̰� ����ʵ� �����
   SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
    INSERT INTO EMP VALUES (9999, 'ȫ%' , NULL, NULL, NULL, 9000, 900, 40) ; --������ �Է�
    
    ROLLBACK; -- DML (�߰�, ����, ����) �� ������ ������ ���󺹱� (DML ���)
    
   -- (4) ---------IS NULL ;
   SELECT * FROM EMP ;
    -- EX. �󿩱��� NULL�� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE COMM IS NULL;

SELECT * FROM EMP WHERE COMM = NULL; -- NULL �񱳽� �ݵ�� IS NULL��.

    -- EX. �󿩱��� ���� ����� ��� �ʵ�(COMM �� NULL �̰ų� 0 )
    SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;
    
    --EX. �󿩱��� �ִ� ����� ��� �ʵ�
    SELECT * FROM EMP WHERE NOT  COMM  IS   NULL AND COMM != 0;
    
    
    
-- ----------9. ����(��������, ��������)
SELECT ENAME, SAL FROM EMP ORDER BY SAL; -- �޿� �������� ����

SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC; -- �޿� �������� ����

SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC; -- �޿� �������� ����


SELECT ENAME, SAL FROM EMP ORDER BY ENAME; -- �̸� ABCD������  ���

SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; -- �̸�  ���ĺ��� �ݴ�� 

SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE; --��¥ ������� ���� 

SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- �ֽż����� ����

        --�̸� , ����(SAL*12+COMM)�� ���(������ ���� ������ ������ ���� ��� �̸�������)
SELECT ENAME, SAL*12+NVL(COMM, 0) AS "ANNUAL_SAL" FROM EMP 
ORDER BY SAL*12+NVL(COMM, 0) DESC, ENAME;

SELECT ENAME, SAL*12+NVL(COMM, 0) AS "ANNUAL_SAL" 
    FROM EMP 
    ORDER BY ANNUAL_SAL DESC, ENAME; -- ORDER BY ������ ��Ī ��� ����(FROM - WHERE - SELECT - ORDER)

    --EX. ���, �̸�, �Ի���, �޿�, �μ���ȣ( �μ���ȣ��, �μ��� ������ �Ի��Ͽ������� ���� ���
    SELECT EMPNO, ENAME,HIREDATE,DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE DESC;




-- ��   ���� ���� (�� �����ϱ�)

--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
 SELECT  EMPNO, ENAME, JON, SAL 
 FROM EMP 
 WHERE SAL >= 3000;

--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT EMPNO,ENAME, DEPTNO
FROM EMP 
WHERE EMPNO = 7788;

--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO,ENAME,SAL 
FROM EMP WHERE (SAL*12+NVL(COMM, 0)) >= 24000
ORDER BY SAL  DESC;

--4.	DLQ������ 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� ��� (�� hiredate ������ ���)  ???@#?!?#!@?#
SELECT ENAME,JOB,HIREDATE FROM EMP 
WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' 
ORDER BY HIREDATE;

--5.	deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME DESC;

--6.	sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� TITLE�� employee�� Monthly Salary�� ���)
SELECT DEPTNO, ENAME "EMPLOYEE", SAL "MONTHLY SALARY" FROM EMP 
WHERE SAL >= 1500 AND DEPTNO IN (10,30);

--7.	hiredate�� 1982���� ����� ��� ������ ���
  SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/__/__';
 SELECT * FROM EMP  WHERE TO_CHAR(HIREDATE,'RR/MM/DD') LIKE '82__/__/';
 SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
 SELECT * FROM EMP WHERE HIREDATE LIKE '82%';

--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME != 'Q' ORDER BY SAL, ENAME;


--9.	comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL,COMM FROM EMP WHERE COMM > SAL * 1.1;


--10.	job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���

 
 SELECT*FROM EMP WHERE  
 JOB = 'CLERK'  OR  JOB = 'ANALYST' 
 AND  SAL NOT IN (1000, 3000,5000);

--11.	ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT* FROM EMP 
WHERE ENAME LIKE '%L%L% 'AND DEPTNO = 30 OR MGR ='7782' ;

--12.	�Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
WHERE TO_CHAR(HIREDATE,'RR') =81;

--13.	�Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME,HIREDATE,JOB,SAL FROM EMP 
WHERE TO_CHAR(HIREDATE,'RR')=81 AND JOB !='SALESMAN';

--14.	���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE , JOB, SAL FROM EMP  
    ORDER BY SAL DESC, HIREDATE;

--15.	������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';

--17.	����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO,ENAME,SAL*12 ���� FROM EMP WHERE SAL *12 >= 10000;

