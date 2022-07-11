-- [VI] SUB QUERY ; QUERY�ȿ� QUERY�� ����

-- �� 1. ���� ���� ����(�ʿ伺)
-- ���� ������ �ʿ伺 : �޿��� ���� ���� �޴� ����� ��� �̸� ��å �� �޿�
SELECT EMPNO, MAX(SAL) FROM EMP GROUP BY EMPNO ; --�� ���� 

SELECT MAX(SAL) FROM EMP; -- ��������

SELECT EMPNO, ENAME, JOB, SAL
     FROM EMP
     WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- ���� ����(���������� �ݵ�� ��ȣ�� ���� �־�� ��

-- ���������� ����(1) ������ ��������(�������� ����� ������) : =, > ,  >= , < , <= , !=
    --EX. SCOTT�� �ٹ��ϴ� �μ��̸� ���
    SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; -- ��������
   
    SELECT DNAME  FROM DEPT 
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- ���� ����
    
    SELECT DNAME FROM
    EMP E , DEPT D 
    WHERE E.DEPTNO=D.DEPTNO 
    AND ENAME='SCOTT'; -- JOIN �̿�



--���������� ����(2) ������ ��������(�������� ��� 2���̻�) :  IN, ANY, ALL, EXISTS

    -- EX. JOB �� MANAGER�� ����� �μ��̸�
    SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- ��������
    
    SELECT DNAME FROM DEPT
        WHERE DEPTNO IN ( SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
 
 -- SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; -- ��������
   
  --  SELECT DNAME  FROM DEPT 
   -- WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- ���� ���� ??? ������?


  --�� 2. ������ �������� 
  -- �Ʒ� ���� ��ó�� 
  SELECT E.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME='SCOTT';
 INSERT  INTO DEPT VALUES (50, 'IT', 'DALLAS');
  INSERT INTO EMP (EMPNO, ENAME, DEPTNO)VALUES (9999, '������',  50);
  SELECT * FROM DEPT;
  SELECT * FROM EMP WHERE EMPNO=9999;
  
    -- EX.  SCOTT�� ���� �μ��� ����� �̸��� �޿� 
  SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; --��������
        
        SELECT ENAME, SAL FROM EMP
        WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT') AND ENAME !='SCOTT'; -- ���� ����
    
    
    -- EX. SCOTT�� ���� �ٹ����� ����� �̸��� �޿�
SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME='SCOTT'; -- ��������


    SELECT ENAME, SAL ,D.LOC FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND 
                LOC =(SELECT LOC 
                         FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
    AND ENAME='SCOTT') -- ��������
    AND ENAME != 'SCOTT';

    ROLLBACK;  -- ������ �߰� ��� ( DML - �������߰�, ����, ������ ���)
    SELECT *  FROM EMP WHERE EMPNO = 9999; -- �߰��ߴ��� �ȳ��� 
    SELECT * FROM DEPT;
    
    
    
    -- EX. �����Ի��ϰ� ���� �Ի��ѻ���̸� , 
    SELECT MIN(HIREDATE) FROM EMP; -- ������ �������� 
    
    SELECT HIREDATE, ENAME
    FROM EMP
    WHERE HIREDATE = ( SELECT MIN(HIREDATE) FROM EMP);
    
    
    -- EX �ֱ��Ի��ϰ� �ֱ��Ի��� ����̸�
    SELECT MAX(HIREDATE) FROM EMP;
    
    SELECT HIREDATE, ENAME
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    
    
    -- EX. �����Ի��ϰ� �ּ� �Ի��ѻ���̸� , �ֱ��Ի��ϰ� �ֱ��Ի��� ����̸�
    
    SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME 
    FROM EMP E1, EMP E2
    WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) AND 
    E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
      
      SELECT 
        (SELECT MAX(HIREDATE) FROM EMP) LAST,
        (SELECT ENAME FROM EMP  WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP)) LASTMAN,
        (SELECT MIN(HIREDATE) FROM EMP) FIRST,
        (SELECT ENAME "FIRSTMAN" FROM EMP WHERE HIREDATE = ( SELECT MIN(HIREDATE) FROM EMP)) 
        FROM DUAL;
    
    
    
    
    
    
    -- EX. SCOTT �� ���� �μ��� �ٹ��ϴ� ������� �޿���  -- 20
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- ������
    SELECT SUM(SAL),ENAME FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
    
    --EX. SCOTT�� ������ ��å(JOB)�� ���� ����� ����ʵ�
    SELECT JOB FROM EMP WHERE ENAME = 'SCOTT';
    SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT'); -- ��������
    
    --EX. DALLAS���� �ٹ��ϴ� ����� �̸��� �μ� ���
    SELECT DEPTNO FROM DEPT  WHERE LOC = 'DALLAS'; --������
    
    SELECT ENAME , DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT  WHERE LOC = 'DALLAS');
    
    -- EX. 'KING'�� ���ӻ���� ����� �̸��� �޿� ���� ����
    SELECT EMPNO FROM EMP WHERE ENAME ='KING'; -- �������� 
    
    SELECT ENAME, SAL 
    FROM EMP
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME ='KING'); -- �������� 
    
    
    
    SELECT  W.ENAME, W.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING'; -- SELF JOIN �̿�
    
    
        -- źź ������ 
        -- EX1. ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���
        SELECT ENAME ,SAL FROM EMP
        WHERE  SAL <= (SELECT AVG(SAL) FROM EMP);
    
        -- EX2. ��� �޿� ���Ϸ� �޴� ����� �̸� , �޿�, ��ձ޿� ���
        SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)) avg
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    
    
    -- EX.3 ��� �޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��հ� ���̸� ���
    
    --              �̸�    �޿�   ����        ��� �޿�        - �޿�   , ù��° �ڸ�
    SELECT ENAME, SAL ,ROUND((SELECT AVG(SAL) FROM EMP)-SAL,1) 
    FROM EMP
    --       �޿���      ��� �޿�����   �۰ų� ������ ���
    WHERE  SAL <= (SELECT AVG(SAL) FROM EMP);
    
    
    
    
    -- ������ ���߿� �������� : SCOTT�̶� JOB�� DEPTNO�� ���� ������ ��� �ʵ� ���
    SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- �������� ������ ���߿�
    SELECT * FROM EMP 
    --             ������ =   ���� ��  DEPTNO ���� �̿��ǿ��� ���� ������ ���� �λ�� �ص�
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
        
    
    -- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT  MIN(HIREDATE) FROM EMP ; 

    SELECT HIREDATE, ENAME
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);



-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT MIN(SAL) FROM EMP;

    SELECT ENAME, SAL
    FROM EMP
    WHERE SAL =(SELECT MIN(SAL) FROM EMP);

-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ROUND(AVG(SAL)) FROM EMP;

    SELECT ENAME,SAL,DEPTNO
    FROM EMP
    WHERE SAL > (SELECT ROUND(AVG(SAL)) FROM EMP );


--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ROUND(AVG(SAL)) FROM EMP;

    SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL < (SELECT ROUND(AVG(SAL)) FROM EMP);



--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT'; -- 82 / 12/ 09

    SELECT ENAME �̸�, HIREDATE �Ի���,SAL �޿�,GRADE ���
    FROM EMP,SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL AND 
    HIREDATE <(SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT') ORDER BY HIREDATE;



--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT'; -- 82 / 12/ 09

    SELECT ENAME �̸�, HIREDATE �Ի���,SAL �޿�,GRADE ���,D.DNAME �μ���
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.SAL BETWEEN LOSAL AND HISAL  
    AND E.DEPTNO = D.DEPTNO
    AND HIREDATE <(SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT') 
    ORDER BY SAL DESC;



--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT SAL FROM EMP WHERE ENAME = 'BLAKE';
    SELECT EMPNO ���, ENAME �̸�, SAL �޿�
    FROM EMP 
    WHERE SAL >(SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');



--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER'; -- 82 / 01/ 23
    SELECT EMPNO ��ȣ , ENAME �̸�, HIREDATE �Ի���
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');



--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT ROUND(AVG(SAL)) FROM EMP ;
    SELECT EMPNO ���, ENAME �̸�, SAL �޿�
    FROM EMP
    WHERE SAL > (SELECT ROUND(AVG(SAL)) FROM EMP );





--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
 -- CLARK 10���� 7782
    SELECT DEPTNO  FROM EMP WHERE ENAME = 'CLARK';
    SELECT SAL FROM EMP WHERE EMPNO =7698;
    
    SELECT EMPNO ��ȣ, ENAME �̸�, SAL �޿�
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO  FROM EMP WHERE ENAME = 'CLARK')
    AND SAL > (SELECT SAL FROM EMP WHERE EMPNO =7698);



--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
    SELECT DNAME FROM EMP ,DEPT WHERE ENAME = 'CLARK';
    SELECT SAL FROM EMP WHERE EMPNO =7698;
    
    SELECT EMPNO ��ȣ , ENAME �̸�, SAL �޿�
        FROM EMP E , DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND
        DNAME = (SELECT  DNAME  FROM EMP E ,DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO =7698);





--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE'; --30

    SELECT ENAME �̸�,HIREDATE �Ի����� ,DEPTNO �μ���ȣ FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');



--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
    
SELECT ROUND(AVG(SAL)) FROM EMP ; 

    SELECT EMPNO �����ȣ, ENAME �̸�, SAL �޿�
    FROM EMP
    WHERE SAL >=(SELECT ROUND(AVG(SAL)) FROM EMP)
    ORDER BY SAL DESC;
    
    

-- �� 3. ������ �������� : IN , ALL, ANY = SOME, EXISTS
   
-- (1) IN : �������� ��� �� �ϳ��� ��ġ�ϸ� ��
    -- EX. �μ����� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ 30�� �̸鼭 �Ի��� ���� ����, 20���̸鼭 �Ի��� ���� ����, 10���̸鼭 �Ի� ���� ������
    SELECT DEPTNO , MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- �������� (������ �ƴϰ� ���� ���� ������ (������)
    
    SELECT ENAME, HIREDATE, DEPTNO 
        FROM EMP
        WHERE (DEPTNO,HIREDATE)  IN (SELECT DEPTNO , MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); -- ��������
        
-- EX.  �޿� 3000�̻� �޴� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ����� ����
    SELECT DEPTNO FROM EMP WHERE SAL >= 3000; -- ��������(������)
    
    SELECT ENAME,SAL FROM EMP WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE SAL >= 3000); -- 3000�̻� �޴� ���  �μ��� ���
    
    
 -- (2) ALL :  �������� ����� ��� �����ؾ� ��
    --EX. 30�� �μ� �޿��� ��κ��� ū ��� (= 30�� �μ� �ִ� �޿����� ū���) ������ ��� �ʵ�
    SELECT SAL FROM EMP WHERE DEPTNO = 30;    -- ��������(������)
    SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);
    
    -- ���� ������ ���������� �����༭�������� 
    SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30; -- ���� ���� 
    SELECT * FROM EMP WHERE SAL >( SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);
    
    
    -- (3) ANY = SOME ; �������� ����� �ϳ��� �����ϸ� ��
    --EX. 30�� �μ� �޿� ������ �߿� �ϳ����̶� ū ��� (= 30�� �μ� �ּ� �޿����� ū ���) ������ ��� �ʵ�
    SELECT SAL , DEPTNO FROM EMP WHERE DEPTNO =30; -- �������� (������)
    
    SELECT * FROM EMP WHERE SAL > ANY ( SELECT SAL  FROM EMP WHERE DEPTNO =30); -- ��������
    
    --���� QUERY�� ������ ���������� 
    SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM  EMP WHERE DEPTNO =30);
    
    
    -- (4) EXISTS ; �������� ����� �����ϸ� �� 
        --EX ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
        -- ���Ӻ��� : ���� EMPNO�� ������ MGR
        SELECT * FROM EMP;
        SELECT EMPNO, ENAME, SAL 
        FROM EMP MANAGER
        WHERE EXISTS    (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- MANAGER EMPNO ����� = MGR �ϰ� �����ְ� �ֳ� ?
    
    SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO;  -- SLEF JOIN �̿�
        
        -- EX. ���� ����� ��� �ʵ� ��� ������ �Ȱ����� NOT �̵��鼭 ���ǰ� �ݴ� �� ��� ���
        SELECT * 
             FROM EMP MANAGER
             WHERE NOT EXISTS ( SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- ���� ��� ���� ���� ������ 
    
        SELECT M. *
            FROM EMP W, EMP M
            WHERE W.MGR(+)=M.EMPNO  AND  W.ENAME IS NULL;
    
    
    -- źź 1 . �μ����� ���� �޿��� ���� �޴� ����� ���� (��� ��ȣ , ����̸� , �޿�, �μ���ȣ) IN ������ ���
    SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
    SELECT EMPNO, ENAME, SAL, DEPTNO
        FROM EMP 
        WHERE (DEPTNO, SAL) IN(SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
    
    -- źź 2. ������ MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ��� IN
    SELECT  DEPTNO FROM EMP WHERE JOB = 'MANAGER'; -- ��������
    
    SELECT DEPTNO, DNAME, LOC
     FROM  DEPT
        WHERE DEPTNO IN (SELECT  DEPTNO FROM EMP WHERE JOB = 'MANAGER');
    
    -- źź 3.������ 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
    
    SELECT * FROM SALGRADE;
    
    SELECT SAL , ENAME, GRADE FROM EMP,SALGRADE 
    WHERE  SAL BETWEEN LOSAL AND HISAL AND
    SAL >= 3000 ;
    
    SELECT EMPNO,ENAME,JOB,HIREDATE,SAL,GRADE
    FROM EMP,SALGRADE
   WHERE SAL BETWEEN LOSAL AND HISAL 
    AND (SAL,GRADE) IN(SELECT SAL ,GRADE FROM EMP,SALGRADE 
    WHERE  SAL BETWEEN LOSAL AND HISAL AND
    SAL >= 3000 ) ;
    
  
   SELECT GRADE, MAX(SAL) FROM SALGRADE, EMP 
   WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000
   GROUP BY GRADE; -- �������� 4,5���
   
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL , GRADE
    
    FROM SALGRADE, EMP
    
            WHERE SAL BETWEEN LOSAL AND HISAL
            
                    AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM SALGRADE, EMP
                    
                                                        WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000 GROUP BY GRADE); -- ���� ����
    
   
    
    
    
    
    -- źź 4. �����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� 
    -- �б� , ��� , �̸� , JOB, �����, �Ի��� , �޿�, �󿩸� ����ϼ���
    -- 1,2,3 - 1�б�   /, 4,5,6 -> 2�б� , / 7,8,9 -> 3 / 10,11,12 -> 4  �б� ������ MM/3�� �ø�
    SELECT HIREDATE, CEIL (EXTRACT (MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP;
    
     SELECT HIREDATE, CEIL (TO_CHAR (HIREDATE, 'MM') /3) "QUARTER" FROM EMP;
   SELECT HIREDATE, TO_CHAR(HIREDATE, 'Q') "QUARTER" FROM EMP; -- ������
    
    SELECT CEIL (EXTRACT (MONTH FROM HIREDATE)/3) , MAX(SAL) FROM EMP
       GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3); -- ��������
       
       SELECT CEIL(EXTRACT(MONTH FROM HIREDATE) /3 ) "QUARTER" , EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
            FROM EMP
            WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN
                    (SELECT CEIL(EXTRACT (MONTH FROM HIREDATE)/3), MAX(SAL)
                        FROM EMP
                        GROUP BY CEIL (EXTRACT(MONTH FROM HIREDATE) /3))
                ORDER BY QUARTER;
    
    
--źź 5. �� SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� 
--�̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)

SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --��������
SELECT ENAME, SAL, JOB
    FROM EMP
        WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- ������ �������� �̿��� ��������

SELECT ENAME, SAL JOB
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB ='SALESMAN') AND JOB != 'SALESMAN';


--źź 6. �� SALESMAN ��� ����� �� ��ѻ�� ���� �޿��� ���� �޴� ������� 
--�̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ANY�̿�)

SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --��������
SELECT ENAME, SAL, JOB
    FROM EMP
        WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- ������ �������� �̿��� ��������

SELECT ENAME, SAL JOB
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB ='SALESMAN') AND JOB != 'SALESMAN';
    
-- źź 7. ������ 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, �Ի����� ���
SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000;
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000);

    
-- źź 8�� ������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� 
--�̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; -- ���� ���� 

SELECT ENAME, SAL, JOB, DEPTNO
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND DEPTNO != 20;
    
    
    
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT  DEPTNO FROM EMP WHERE ENAME LIKE '%T%';

        SELECT EMPNO, ENAME, SAL ,DEPTNO
        FROM EMP
        WHERE DEPTNO IN  (SELECT  DEPTNO FROM EMP WHERE ENAME LIKE '%T%');



-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT LOC FROM DEPT WHERE  LOC = UPPER('Dallas');

    SELECT ENAME, JOB , SAL , LOC
    FROM EMP , DEPT
    WHERE LOC IN(SELECT LOC FROM DEPT WHERE  LOC = UPPER('Dallas'));


-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT EMPNO FROM EMP WHERE ENAME = UPPER('King');

    SELECT W. ENAME,W.SAL , W.MGR
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO 
    AND W.MGR IN (SELECT EMPNO FROM EMP WHERE ENAME = UPPER('King'));
    
    SELECT ENAME, SAL FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE INITCAP(ENAME) = 'King');





-- 17. SALES�μ� ����� �̸�, ����
SELECT JOB FROM EMP WHERE JOB = 'SALESMAN';

    SELECT ENAME, JOB
    FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE JOB = 'SALESMAN');


-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT MIN(SAL) FROM EMP WHERE DEPTNO ='30' GROUP BY DEPTNO ;


    
   SELECT * FROM EMP
   WHERE SAL > ALL(SELECT MIN(SAL) FROM EMP WHERE DEPTNO ='30' GROUP BY DEPTNO);




-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����

SELECT JOB FROM EMP WHERE DEPTNO=30;

SELECT ENAME, JOB FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30)
        AND DEPTNO=10;



-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT JOB,SAL FROM EMP WHERE ENAME ='FORD';

SELECT * FROM EMP
    WHERE (JOB,SAL) IN (SELECT JOB,SAL FROM EMP WHERE ENAME ='FORD') AND ENAME != 'FORD'; 

-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
    SELECT JOB,SAL, ENAME FROM EMP WHERE ENAME ='JONES' OR ENAME ='FORD'; 
    
    SELECT ENAME, JOB, DEPTNO, SAL
        FROM EMP
            WHERE JOB IN (SELECT JOB FROM EMP WHERE ENAME ='JONES')
                                OR SAL >=(SELECT SAL FROM EMP WHERE ENAME = 'FORD');
    
    SELECT SAL FROM EMP;
    

-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT SAL FROM EMP WHERE ENAME IN('SCOTT','WARD');

    SELECT ENAME , JOB, SAL
        FROM EMP
                WHERE SAL IN(SELECT SAL FROM EMP WHERE ENAME IN('SCOTT','WARD'));




-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT JOB , LOC FROM EMP , DEPT  WHERE LOC = 'CHICAGO' ;
        
        SELECT ENAME , JOB, LOC
            FROM EMP , DEPT 
                WHERE   (JOB,LOC) IN (SELECT JOB,LOC FROM EMP , DEPT  WHERE LOC = 'CHICAGO');





-- 24. �μ����� ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT * FROM EMP;
SELECT DEPTNO , ROUND(AVG(SAL)) FROM EMP  GROUP BY DEPTNO;

    SELECT EMPNO, ENAME, SAL, DEPTNO
        FROM EMP E
            WHERE SAL   > (SELECT ROUND(AVG(SAL)) FROM EMP  WHERE E.DEPTNO=DEPTNO);
            




-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT JOB , ROUND(AVG(SAL)) FROM EMP  GROUP BY JOB ;

    SELECT DEPTNO,ENAME,SAL
        FROM EMP E
            WHERE SAL > (SELECT ROUND(AVG(SAL)) FROM EMP WHERE E.JOB = JOB);
            
            SELECT ROUND(AVG(SAL)) FROM EMP WHERE 'MANAGER'=JOB;



-- �ش�μ���պ��� ���� ����� ���� - ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ��� �޿�(�Ҽ���2�ڸ�)
SELECT EMPNO, ENAME, SAL , DEPTNO , ROUND((SELECT AVG(SAL)  FROM EMP WHERE DEPTNO=E.DEPTNO),2) AVG
        FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO); -- �������� 

SELECT EMPNO, ENAME, SAL, E.DEPTNO AVG
    FROM EMP E, (SELECT DEPTNO , ROUND(AVG(SAL), 2) "AVG"
    FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO AND SAL>AVG ; -- INLINE VIEW �̿�





-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
  SELECT *FROM EMP;
        SELECT JOB,ENAME, EMPNO, DEPTNO 
        FROM EMP MANAGER
        WHERE EXISTS    (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR)
        ORDER BY  DEPTNO; 
    








-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ    
   SELECT EMPNO,ENAME,JOB,DEPTNO
             FROM EMP 
             WHERE EMPNO NOT IN ( SELECT NVL(MGR,0) FROM EMP);
    
    