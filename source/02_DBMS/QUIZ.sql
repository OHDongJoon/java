--1. ������ ���̺��� ����� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT * FROM EMP; 
SELECT * FROM DEPT;

--2. TO_DATE �������Լ��� �̿��Ͽ� EMP ���̺��� HIREDATE�� 1981�� 2�� 20�Ϻ��� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� �����Ի��Ϻ��� �ֱ��Ի��� ������ �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
--????
SELECT ENAME, JOB, HIREDATE
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '81/02/20' AND '81/05/01';
   

  
  
  
--3. EMP���̺�� DEPT���̺��� self join�� outer join�� �̿��Ͽ� �����, �޿�, �μ���ȣ, �μ���, �ٹ���, ���ӻ����� ��簡 ���� �������� ��ü ���� �� ����ϴ� SQL���� �ۼ��Ͻÿ�. ��, ��簡 ���� ��� ���� ��� ���������� ����Ѵ�(5��).
SELECT E.ENAME, E.SAL, E.DEPTNO, D.DNAME, D.LOC, M.ENAME, E.MGR
    FROM EMP E, DEPT D, EMP M
        WHERE E.DEPTNO = D. DEPTNO AND E.MGR = M.EMPNO(+);
       

--4. SALGRADE ���̺��� LOSAL�� ������� �޿�, HISAL�� ��� �ְ� �޿��� �̿��Ͽ�, EMP ���̺��� ����� ���, �����, ��å, �޿�, �޿������ �޿� ���� ������������ �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE
        WHERE SAL BETWEEN LOSAL AND HISAL ORDER BY GRADE DESC;

--5. EMP ���̺��� �μ���ȣ�� 20���� ����� ���, �����, �޿��� ����ϵ� �޿� �տ��� $�� ���̰�, ���ڴ� 3�ڸ����� �޸�( , )�� �߰��Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�. �� �޿�(SAL)�� Ÿ���� NUMBER(7,2)�� �Ѵ�(5��).
SELECT EMPNO,ENAME,TO_CHAR(SAL, '$99,999,99') 
    FROM EMP
        WHERE DEPTNO = '20';

SELECT * FROM DEPT WHERE DEPTNO ='20';


--6. EMP ���̺��� ��å�� �޿� ����� 3000�̻��� ��å�� ���Ͽ� �����, ��ձ޿�, �ݿ��� ���� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT JOB, ROUND(AVG(SAL)), SUM(SAL)
    FROM EMP
        GROUP BY JOB
            HAVING ROUND(AVG(SAL)) >= 3000 ;



--7. EMP���̺��� ������� ��FORD���� ������ ��å(JOB)�� �޿�(SAL)�� ���� ����� ��� ������ ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT * FROM EMP WHERE ENAME = 'FORD'; -- ��������
      
       SELECT * FROM EMP
        WHERE  JOB = (SELECT JOB FROM EMP WHERE ENAME ='FORD') AND
            SAL =(SELECT SAL FROM EMP WHERE ENAME='FORD') AND ENAME != 'FORD';






--8. EMP ���̺��� ������� ��FORD���� ����� �����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
 DELETE FROM EMP
        WHERE ENAME = 'FORD' ;
            SELECT * FROM EMP WHERE ENAME ='FORD';





--9. �����ͺ��̽����� Ʈ������� ������ ó���� �� ������ ���Ѵ�. �����͸� �����ϱ� ���� INSERT, UPDATE, DELETE ���� ��ɵ��� ����ʰ� ���ÿ� Ʈ������� ����Ǵµ�, 
--�̵� INSERT, UPDATE, DELETE�۾��� ���������� �����ͺ��̽��� �ݿ���ó���ǵ��� ��ɾ �ۼ��Ͻÿ�(5��).

SELECT * FROM EMP;

INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES ('33','������','IT','55','22/09/01',900,0,20);

 UPDATE EMP 

    SET SAL = 1000

        WHERE ENAME = '������';

        SELECT * FROM EMP WHERE ENAME ='������';
        
        COMMIT;

 



--10. EMP���̺��� ��������� ��ȸ�ϴ� �ð��� �����ϱ� ���� ���Ǵ� �ε��� ���� ��ɾ �ۼ��Ͻÿ�. ������ �ε����� �̸��� IDX_EMP_ENAME���� �Ѵ�(10��).

CREATE INDEX IDX_EMP_ENAME ON EMP(ENAME); 
SELECT * FROM EMP WHERE ENAME='������'; -- �ε��� ���� �� : 0.001 ~ 0.002�� 

--11. ���� ���� ������ ���̺� ���� ������ ������ ������ ��ųʸ��並 ���캸�� SQL���� �ۼ��Ͻÿ�(5��).
SHOW USER;



