-- [III] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻�

SELECT * FROM EMP WHERE ENAME='SCOTT'; -- �μ���ȣ (DEPTNO 20)

SELECT * FROM DEPT ;

-- CROSS JOIN (FROM���� ���̺� 2�� �̻� �ִ°�)
SELECT * FROM EMP, DEPT WHERE ENAME='SCOTT';
SELECT * FROM EMP, DEPT ;
-----------------1  *  4

---- �߿� 1. EQUI JOIN (�������� : �����ʵ忣 DEPTNO���� ��ġ�Ǵ� ���� JOIN)
SELECT * FROM EMP, DEPT
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO=DEPT.DEPTNO;

SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO , DNAME, LOC
    FROM EMP, DEPT
    WHERE EMP.DEPTNO = DEPT.DEPTNO;
    
    -- ���̺��� ��Ī �� ������ ��Ī���θ� ���̺��� �׼����� �� �ֽ��ϴ�.
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
    
    --EX. �޿��� 2000�̻��� ������ �̸�, ��å(JOB), �޿�, �μ���, �ٹ��� ���
SELECT EMPNO, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000;
    -------(��     ��     ��     �� )----
    
    
    --EX. LOC�� 'CHICAGO'�� ����� �̸�, ����, �޿�, �μ���ȣ , �ٹ����� ���
    
SELECT ENAME, JOB,SAL, D.DEPTNO, LOC       
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND LOC = 'CHICAGO';
    
    
    -- EX. �μ���ȣ�� 10�̰ų� 20���� ����� �̸� ���� �ٹ��� �޿� (�޿��� ����)

SELECT ENAME , JOB, LOC,SAL
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN(10,20)
    ORDER BY SAL;
    
    
  
  
  
  
  
  
    --EX. JOB�� SALESMAN �̰ų� MANGER�� ����� �̸�, �޿�, ��, ���� ((SAL+COMM)*12), �μ��� 
    -- �ٹ����� ���(������ ū������ ����)
    
SELECT ENAME, SAL,COMM,LOC,((SAL+COMM)*12)
    FROM  EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB = 'SALESMAN' OR JOB ='MANGER' ORDER BY SAL DESC;

    -- EX. COMM�� NULL�̰� �޿��� 1200�̻��� ����� �̸� �޿� �Ի��� �μ���ȣ �μ��� ���
                -- (�μ����, �޿�ū�� ����)
SELECT ENAME,SAL,HIREDATE, D.DEPTNO,DNAME
FROM EMP E, DEPT D                                                                            
WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >=1200 ORDER BY DNAME, SAL DESC;
                                                                                                                   --�μ����                  �޿� ū��   
      
      --EX. 'NEW YORK'���� �ٹ��ϴ� ����� �̸��� �޿� ���
SELECT ENAME,SAL,LOC
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND LOC = 'NEW YORK';

      --EX. 'ACCOUNTING' �μ� �Ҽ��� ����̸��� �Ի��� ���
SELECT ENAME, HIREDATE, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO AND DNAME = 'ACCOUNTING';
     
      --EX. ����(JOB)�� MANAGER�� ����� �̸�, �μ��� ���
SELECT ENAME,DNAME,JOB
FROM EMP E, DEPT D
WHERE E.DEPT=D.DEPT AND JOB = 'MANAGER';
     
      --EX. COMM�� NULL�� �ƴ� ����� �̸�, �޿�, �μ���ȣ, �ٹ��� ���
SELECT ENAME,SAL,E.DEPTNO,LOC,COMM
FROM EMP E, DEPT D
WHERE  E.DEPTNO=D.DEPTNO AND COMM  IS NULL;
      
      
      
      
      
      
      
 -- �� 2. NON-EQUI JOIN ( �Ȱ��� �ƴϰ� ������ ������)
 SELECT * FROM EMP WHERE ENAME ='SCOTT'; -- ��� ���� 
 
 
 
 
 SELECT * FROM SALGRADE; --�޿� ��� ���� 
 -- CROSS JOIN = EMP �� �� * SALGRADE �� 5�� 
 SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT';

SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT' AND  SAL BETWEEN LOSAL AND HISAL;

        -- EX. ��� ����� ���, �̸�, JOB, �����, �޿�, �޿����(1���,2���, 
SELECT * FROM SALGRADE;
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'���' GRADE
     FROM EMP, SALGRADE 
     WHERE SAL BETWEEN LOSAL AND HISAL;
     
--�� 	źź������ ��������
-- źź1. Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ(EMPNO), �μ��̸�(DNAME), �ٹ���(LOC)�� ����Ͻÿ�. EQUI JOIN

SELECT ENAME,SAL,GRADE,D. EMPNO,DNAME, LOC
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL 
        AND E.DEPTNO=D.DEPTNO
        AND NOT COMM IS NULL;

-- źź 2.	�̸�, �޿�, �Ի���, �޿����
SELECT ENMAE , SAL , GRADE
FROM EMP E, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL;


-- 3 �̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIRDATE, GRADE, DNAME, LOC
FROM EMP E, DEPT D, SALGRADE
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;


--4 	�̸�, �޿�, ���, �μ��ڵ�(E.DEPTNO), �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC,COMM
FROM EMP E, DEPT D, SALGRADE 
WHERE E.DEPTNO = D.DEPTNO AND SAL  BETWEEN LOSAL AND HISAL AND NOT COMM IS NULL;


--5	�̸�, �޿�, �޿����, ����, �μ���, (�μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0)
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 , DNAME
FROM EMP E, DEPT D, SALGRADE
WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
ORDER BY DNAME;


--	4�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
    AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL DESC;



--	�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū�� 
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE LIKE '%81%'
        ORDER BY GRADE DESC;
    
    
    
    
-----------�� 3. SELF JOIN ------------------
    --        ���         �̸�       �����
SELECT EMPNO , ENAME , MGR     FROM EMP WHERE ENAME='SMITH'; -- SMITH ��� ���: 7902

SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;

SELECT * FROM EMP WORKER, EMP MANAGER;

                    -- (    ���� ) ( ��� ---- ���     ��� �̸� )
SELECT WORKER.EMPNO ��� , WORKER. ENAME �̸�, WORKER.MGR �����, MANAGER.EMPNO ����ȣ, MANAGER.ENAME ����̸�
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.ENAME='SMITH' AND WORKER.MGR=MANAGER.EMPNO;
    
    
    -- EX. ��� ����� ���, �̸� �����, ����̸� (13�� �������µ� KING�� MGR�� NULL�̶� KING��¾ȵ�)
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
     FROM EMP W, EMP M 
     WHERE  W.MGR=M.EMPNO;
  
    -- EX. 'SMITH�� ���� FORD��' �������� ������� ���
    SELECT W.ENAME || '�� ����' || M.ENAME || '��'
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
    

-- �� 4. OUTER JOIN : ���ν� ���ǿ� �������� ���� ����� ��Ÿ���� 
    
    SELECT W.EMPNO ���, W.ENAME �̸�, W.MGR �����, M.ENAME ����̸�
     FROM EMP W, EMP M 
     WHERE  W.MGR=M.EMPNO;
    
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+) = D.DEPTNO; -- E.DEPTNO���� 40�� �μ� ����  �׷��� �����ϸ� 4 0 �ȳ��� 

SELECT * FROM DEPT;
    
  -- ���� ����� �̸��� ���   
    SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
     FROM EMP W, EMP M 
     WHERE  W.MGR(+) =M.EMPNO AND W.EMPNO IS NULL;
    
    
    
    -- źź 1. �� 	SCOTT�� ������ �μ���ȣ(DEPTNO) ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
  
    SELECT * FROM EMP 
    WHERE ENAME = 'SCOTT';
    SELECT ENAME FROM EMP WHERE DEPTNO = 20 AND ENAME != 'SCOTT';
    
     -- 1�ܰ�
    SELECT E1.ENAME, E1.DEPTNO, E2.ENAME, E2.DEPTNO
    FROM EMP E1, EMP E2
    WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO=E2.DEPTNO AND E2.ENAME != 'SCOTT';
   
    --2�ܰ�
    SELECT E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.ENAME = 'SCOTT' AND E1.DEPTNO=E2.DEPTNO AND E2.ENAME != 'SCOTT';
   
    --źź 2. 	SCOTT�� ������ �ٹ���(LOC)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
    SELECT * FROM DEPT;
   
   -- ���������� DALLAS �ٹ��� �μ��� �ϳ� �߰�
    INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
    SELECT * FROM DEPT;
       
        --���������� 50�� �μ� ��� �߰�
    SELECT * FROM EMP ;
    INSERT INTO EMP VALUES (9999, 'ȫ�浿' , NULL, NULL, NULL, 9000,900,50);
     SELECT * FROM EMP ;
   
     
       --źź 2. 	SCOTT�� ������ �ٹ���(DALLAS)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
     --1�ܰ�      (EMP E1) (DEPT D1)  (EMP E2)     (DEPT D2)
      SELECT E1.ENAME, D1.LOC,    E2.ENAME, D2.LOC , E1.DEPTNO ,D2.DEPTNO
            
     FROM EMP E1, DEPT D1, EMP E2, DEPT D2
               
     WHERE E1.DEPTNO=D1.DEPTNO AND  E2.DEPTNO=D2.DEPTNO AND D1.LOC=D2.LOC
    AND E1.ENAME='SCOTT';

    --2�ܰ� ����
    SELECT E2.ENAME
    FROM EMP E1, DEPT D1, EMP E2, DEPT D2
    WHERE E1.DEPTNO=D1.DEPTNO AND  E2.DEPTNO=D2.DEPTNO AND D1.LOC=D2.LOC
    AND E1.ENAME='SCOTT' AND E2.ENAME != 'SCOTT';

    
    
    
    
    
    
    -- źź 3  ����� �̸��� KING�� ������� �̸��� JOB �� ���
SELECT W.ENAME, W.JOB
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME='KING';
    
    
    
    -- ----------------------PART1 -------------------------------
--1. �̸�, ���ӻ��

SELECT  W.ENAME �̸�, M.ENAME ����̸�
     FROM EMP W, EMP M 
     WHERE  W.MGR=M.EMPNO; --��������

--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME �̸�, W.SAL �޿�, W.JOB ����, M.ENAME ����̸�
    FROM EMP W, EMP M 
    WHERE W.MGR = M.EMPNO;

--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME , W.SAL �޿�, W.JOB ����, NVL(M.ENAME,'����')  MANAGER
     FROM EMP W, EMP M
     WHERE W.MGR = M.EMPNO(+) ;
    

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME , W.SAL , DNAME , M.ENAME MANAGER
    FROM EMP W,  EMP M, DEPT D
   
    WHERE  W.MGR = M.EMPNO AND 
    W.DEPTNO = D.DEPTNO;

--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, M.ENAME
FROM EMP W , EMP M, DEPT D 
WHERE W.DEPTNO =  D.DEPTNO AND 
 W.MGR = M.EMPNO;

--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W. SAL , GRADE, D.DNAME , M.ENAME
FROM EMP W, EMP M,  DEPT D , SALGRADE
WHERE W.SAL BETWEEN LOSAL AND HISAL 
AND W.DEPTNO = D.DEPTNO
AND W.MGR = M.EMPNO 
AND W.SAL >= 2000;





--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME MANAGER
  FROM EMP W, EMP M, DEPT D, SALGRADE
  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO 
    AND W.SAL BETWEEN LOSAL AND HISAL
  ORDER BY DNAME;



--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, GRADE, DNAME, (W.SAL+NVL(W.COMM,0))*12 ANNUAL_SAL, M.ENAME MANAGER
  FROM EMP W, EMP M, DEPT D, SALGRADE 
  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL;





--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
   SELECT W.ENAME, W.SAL, GRADE, DNAME, 
        (W.SAL+NVL(W.COMM,0))*12 ANNUAL_SAL, M.ENAME MANAGER
  FROM EMP W, EMP M, DEPT D, SALGRADE 
  WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
  ORDER BY DNAME, W.SAL DESC;



--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME ,E.DEPTNO, DNAME 
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;

--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���

SELECT ENAME , JOB, SAL , DNAME

FROM EMP E, DEPT D

WHERE E.DEPTNO=D.DEPTNO AND 
LOC = 'NEW YORK';


--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME , DNAME, LOC , COMM
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND
  COMM IS NOT NULL AND COMM != 0;



--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME , JOB, DNAME , LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND
 ENAME LIKE '%L%';


--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO , ENAME , D. DEPTNO, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO ORDER BY ENAME;

--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO,ENAME, SAL , DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000 
ORDER BY SAL DESC;



--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO , ENAME , JOB, SAL, DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND
JOB = 'MANAGER' AND SAL >= 2500;





--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE
FROM EMP E, DEPT D, SALGRADE
WHERE E.DEPTNO = D.DEPTNO 
AND SAL BETWEEN LOSAL AND HISAL  ORDER BY SAL DESC;




--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT E1. ENAME , E2.ENAME 
FROM EMP E1, EMP E2 
WHERE E1.MGR = E2.EMPNO(+);

--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT E1.ENAME, E2.ENAME, E3.ENAME
FROM EMP E1, EMP E2 , EMP E3
WHERE E1.MGR = E2.EMPNO AND E2.MGR = E3.EMPNO;



--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT E1.ENAME, E2.ENAME, E3.ENAME
FROM EMP E1, EMP E2 , EMP E3
WHERE E1.MGR = E2.EMPNO(+) AND E2.MGR = E3.EMPNO(+);




