-- [VI] SUB QUERY ; QUERY안에 QUERY가 내포

-- ★ 1. 서브 쿼리 개념(필요성)
-- 서브 쿼리의 필요성 : 급여를 제일 많이 받는 사람의 사번 이름 직책 과 급여
SELECT EMPNO, MAX(SAL) FROM EMP GROUP BY EMPNO ; --다 찍힘 

SELECT MAX(SAL) FROM EMP; -- 서브쿼리

SELECT EMPNO, ENAME, JOB, SAL
     FROM EMP
     WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- 메인 쿼리(서브쿼리는 반드시 괄호로 묶어 있어야 함

-- 서브쿼리의 종류(1) 단일행 서브쿼리(서브쿼리 결과가 단일행) : =, > ,  >= , < , <= , !=
    --EX. SCOTT이 근무하는 부서이름 출력
    SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; -- 서브쿼리
   
    SELECT DNAME  FROM DEPT 
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- 메인 쿼리
    
    SELECT DNAME FROM
    EMP E , DEPT D 
    WHERE E.DEPTNO=D.DEPTNO 
    AND ENAME='SCOTT'; -- JOIN 이용



--서브쿼리의 종류(2) 다중행 서브쿼리(서브쿼리 결과 2행이상) :  IN, ANY, ALL, EXISTS

    -- EX. JOB 이 MANAGER인 사람의 부서이름
    SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; -- 서브쿼리
    
    SELECT DNAME FROM DEPT
        WHERE DEPTNO IN ( SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
 
 -- SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; -- 서브쿼리
   
  --  SELECT DNAME  FROM DEPT 
   -- WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'); -- 메인 쿼리 ??? 뭔차이?


  --★ 2. 단일행 서브쿼리 
  -- 아래 문제 전처리 
  SELECT E.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME='SCOTT';
 INSERT  INTO DEPT VALUES (50, 'IT', 'DALLAS');
  INSERT INTO EMP (EMPNO, ENAME, DEPTNO)VALUES (9999, '오동준',  50);
  SELECT * FROM DEPT;
  SELECT * FROM EMP WHERE EMPNO=9999;
  
    -- EX.  SCOTT과 같은 부서인 사람의 이름과 급여 
  SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; --서브쿼리
        
        SELECT ENAME, SAL FROM EMP
        WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT') AND ENAME !='SCOTT'; -- 메인 쿼리
    
    
    -- EX. SCOTT과 같은 근무지인 사람의 이름과 급여
SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME='SCOTT'; -- 서브쿼리


    SELECT ENAME, SAL ,D.LOC FROM EMP E, DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND 
                LOC =(SELECT LOC 
                         FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO 
    AND ENAME='SCOTT') -- 메인쿼리
    AND ENAME != 'SCOTT';

    ROLLBACK;  -- 데이터 추가 취소 ( DML - 데이터추가, 수정, 삭제를 취소)
    SELECT *  FROM EMP WHERE EMPNO = 9999; -- 추가했던거 안나옴 
    SELECT * FROM DEPT;
    
    
    
    -- EX. 최초입사일과 최초 입사한사람이름 , 
    SELECT MIN(HIREDATE) FROM EMP; -- 단일행 서브쿼리 
    
    SELECT HIREDATE, ENAME
    FROM EMP
    WHERE HIREDATE = ( SELECT MIN(HIREDATE) FROM EMP);
    
    
    -- EX 최근입사일과 최근입사한 사람이름
    SELECT MAX(HIREDATE) FROM EMP;
    
    SELECT HIREDATE, ENAME
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    
    
    -- EX. 최초입사일과 최소 입사한사람이름 , 최근입사일과 최근입사한 사람이름
    
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
    
    
    
    
    
    
    -- EX. SCOTT 과 같은 부서에 근무하는 사람들의 급여합  -- 20
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- 단일행
    SELECT SUM(SAL),ENAME FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
    
    --EX. SCOTT과 동일한 직책(JOB)을 가진 사원의 모든필드
    SELECT JOB FROM EMP WHERE ENAME = 'SCOTT';
    SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT'); -- 메인쿼리
    
    --EX. DALLAS에서 근무하는 사원의 이름과 부서 출력
    SELECT DEPTNO FROM DEPT  WHERE LOC = 'DALLAS'; --단일행
    
    SELECT ENAME , DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT  WHERE LOC = 'DALLAS');
    
    -- EX. 'KING'이 직속상사인 사원의 이름과 급여 서브 쿼리
    SELECT EMPNO FROM EMP WHERE ENAME ='KING'; -- 서브쿼리 
    
    SELECT ENAME, SAL 
    FROM EMP
    WHERE MGR=(SELECT EMPNO FROM EMP WHERE ENAME ='KING'); -- 메인쿼리 
    
    
    
    SELECT  W.ENAME, W.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING'; -- SELF JOIN 이용
    
    
        -- 탄탄 다지기 
        -- EX1. 평균 급여 이하로 받는 사원의 이름과 급여를 출력
        SELECT ENAME ,SAL FROM EMP
        WHERE  SAL <= (SELECT AVG(SAL) FROM EMP);
    
        -- EX2. 평균 급여 이하로 받는 사원의 이름 , 급여, 평균급여 출력
        SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)) avg
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    
    
    -- EX.3 평균 급여 이하로 받는 사원의 이름, 급여, 평균과 차이를 출력
    
    --              이름    급여   라운드        평균 급여        - 급여   , 첫번째 자리
    SELECT ENAME, SAL ,ROUND((SELECT AVG(SAL) FROM EMP)-SAL,1) 
    FROM EMP
    --       급여가      평균 급여보다   작거나 같은거 출력
    WHERE  SAL <= (SELECT AVG(SAL) FROM EMP);
    
    
    
    
    -- 단일행 다중열 서브쿼리 : SCOTT이랑 JOB과 DEPTNO가 같은 직원의 모든 필드 출력
    SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- 서브쿼리 단일행 다중열
    SELECT * FROM EMP 
    --             업무가 =   셀렉 잡  DEPTNO 프롬 이엠피에서 웨어 네임이 스콧 인사람 앤드
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
        
    
    -- ★ 총 연습문제
--1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT  MIN(HIREDATE) FROM EMP ; 

    SELECT HIREDATE, ENAME
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);



-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT MIN(SAL) FROM EMP;

    SELECT ENAME, SAL
    FROM EMP
    WHERE SAL =(SELECT MIN(SAL) FROM EMP);

-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ROUND(AVG(SAL)) FROM EMP;

    SELECT ENAME,SAL,DEPTNO
    FROM EMP
    WHERE SAL > (SELECT ROUND(AVG(SAL)) FROM EMP );


--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ROUND(AVG(SAL)) FROM EMP;

    SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL < (SELECT ROUND(AVG(SAL)) FROM EMP);



--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT'; -- 82 / 12/ 09

    SELECT ENAME 이름, HIREDATE 입사일,SAL 급여,GRADE 등급
    FROM EMP,SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL AND 
    HIREDATE <(SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT') ORDER BY HIREDATE;



--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT'; -- 82 / 12/ 09

    SELECT ENAME 이름, HIREDATE 입사일,SAL 급여,GRADE 등급,D.DNAME 부서명
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.SAL BETWEEN LOSAL AND HISAL  
    AND E.DEPTNO = D.DEPTNO
    AND HIREDATE <(SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT') 
    ORDER BY SAL DESC;



--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT SAL FROM EMP WHERE ENAME = 'BLAKE';
    SELECT EMPNO 사번, ENAME 이름, SAL 급여
    FROM EMP 
    WHERE SAL >(SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');



--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일
SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER'; -- 82 / 01/ 23
    SELECT EMPNO 번호 , ENAME 이름, HIREDATE 입사일
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');



--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT ROUND(AVG(SAL)) FROM EMP ;
    SELECT EMPNO 사번, ENAME 이름, SAL 급여
    FROM EMP
    WHERE SAL > (SELECT ROUND(AVG(SAL)) FROM EMP );





--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
 -- CLARK 10번에 7782
    SELECT DEPTNO  FROM EMP WHERE ENAME = 'CLARK';
    SELECT SAL FROM EMP WHERE EMPNO =7698;
    
    SELECT EMPNO 번호, ENAME 이름, SAL 급여
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO  FROM EMP WHERE ENAME = 'CLARK')
    AND SAL > (SELECT SAL FROM EMP WHERE EMPNO =7698);



--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
    SELECT DNAME FROM EMP ,DEPT WHERE ENAME = 'CLARK';
    SELECT SAL FROM EMP WHERE EMPNO =7698;
    
    SELECT EMPNO 번호 , ENAME 이름, SAL 급여
        FROM EMP E , DEPT D
        WHERE E.DEPTNO=D.DEPTNO AND
        DNAME = (SELECT  DNAME  FROM EMP E ,DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO =7698);





--12. BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자
SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE'; --30

    SELECT ENAME 이름,HIREDATE 입사일자 ,DEPTNO 부서번호 FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');



--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름 단 급여가 많은 순으로 출력)
    
SELECT ROUND(AVG(SAL)) FROM EMP ; 

    SELECT EMPNO 사원번호, ENAME 이름, SAL 급여
    FROM EMP
    WHERE SAL >=(SELECT ROUND(AVG(SAL)) FROM EMP)
    ORDER BY SAL DESC;
    
    

-- ★ 3. 다중행 서브쿼리 : IN , ALL, ANY = SOME, EXISTS
   
-- (1) IN : 서브쿼리 결과 중 하나라도 일치하면 참
    -- EX. 부서별로 입사일이 가장 늦은 사람의 이름, 입사일, 부서번호 30번 이면서 입사일 가장 느린, 20번이면서 입사일 가장 느린, 10번이면서 입사 가장 늦은애
    SELECT DEPTNO , MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- 서브쿼리 (한줄이 아니고 한줄 보다 많으면 (다중행)
    
    SELECT ENAME, HIREDATE, DEPTNO 
        FROM EMP
        WHERE (DEPTNO,HIREDATE)  IN (SELECT DEPTNO , MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); -- 메인쿼리
        
-- EX.  급여 3000이상 받는 사원이 소속된 부서에서 근무하는 사원의 정보
    SELECT DEPTNO FROM EMP WHERE SAL >= 3000; -- 서브쿼리(다중행)
    
    SELECT ENAME,SAL FROM EMP WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE SAL >= 3000); -- 3000이상 받는 사람  부서를 출력
    
    
 -- (2) ALL :  서브쿼리 결과가 모두 만족해야 참
    --EX. 30번 부서 급여들 모두보다 큰 경우 (= 30번 부서 최대 급여보다 큰경우) 직원의 모든 필드
    SELECT SAL FROM EMP WHERE DEPTNO = 30;    -- 서브쿼리(다중행)
    SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);
    
    -- 위의 다중행 서브쿼리를 단일행서브쿼리로 
    SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30; -- 서브 쿼리 
    SELECT * FROM EMP WHERE SAL >( SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);
    
    
    -- (3) ANY = SOME ; 서브쿼리 결과가 하나라도 만족하면 참
    --EX. 30번 부서 급여 여러개 중에 하나만이라도 큰 경우 (= 30번 부서 최소 급여보다 큰 경우) 직원의 모든 필드
    SELECT SAL , DEPTNO FROM EMP WHERE DEPTNO =30; -- 서브쿼리 (다중행)
    
    SELECT * FROM EMP WHERE SAL > ANY ( SELECT SAL  FROM EMP WHERE DEPTNO =30); -- 메인쿼리
    
    --위의 QUERY를 단일행 서브쿼리로 
    SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM  EMP WHERE DEPTNO =30);
    
    
    -- (4) EXISTS ; 서브쿼리 결과가 존재하면 참 
        --EX 직속부하가 있는 직원들의 사번, 이름, 급여
        -- 직속부하 : 나의 EMPNO가 부하의 MGR
        SELECT * FROM EMP;
        SELECT EMPNO, ENAME, SAL 
        FROM EMP MANAGER
        WHERE EXISTS    (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- MANAGER EMPNO 사번이 = MGR 하고 같은애가 있냐 ?
    
    SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO;  -- SLEF JOIN 이용
        
        -- EX. 말단 사원의 모든 필드 출력 위에랑 똑같으나 NOT 이들어가면서 조건과 반대 인 사람 출력
        SELECT * 
             FROM EMP MANAGER
             WHERE NOT EXISTS ( SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- 말단 사원 존재 하지 않은애 
    
        SELECT M. *
            FROM EMP W, EMP M
            WHERE W.MGR(+)=M.EMPNO  AND  W.ENAME IS NULL;
    
    
    -- 탄탄 1 . 부서별로 가장 급여를 많이 받는 사원의 정보 (사원 번호 , 사원이름 , 급여, 부서번호) IN 연산자 출력
    SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 서브쿼리
    SELECT EMPNO, ENAME, SAL, DEPTNO
        FROM EMP 
        WHERE (DEPTNO, SAL) IN(SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);
    
    -- 탄탄 2. 직급이 MANAGER인 사람의 속한 부서의 부서 번호와 부서명과 지역을 출력 IN
    SELECT  DEPTNO FROM EMP WHERE JOB = 'MANAGER'; -- 서브쿼리
    
    SELECT DEPTNO, DNAME, LOC
     FROM  DEPT
        WHERE DEPTNO IN (SELECT  DEPTNO FROM EMP WHERE JOB = 'MANAGER');
    
    -- 탄탄 3.연봉이 3000이상인 사람들 중 연봉 등급을 나누어서 해당 등급별 최고 연봉을 받는 사람들의 사번, 이름, 직업, 입사일, 급여, 급여등급을 출력
    
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
   GROUP BY GRADE; -- 서브쿼리 4,5등급
   
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL , GRADE
    
    FROM SALGRADE, EMP
    
            WHERE SAL BETWEEN LOSAL AND HISAL
            
                    AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM SALGRADE, EMP
                    
                                                        WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000 GROUP BY GRADE); -- 메인 쿼리
    
   
    
    
    
    
    -- 탄탄 4. 응용심화 : 입사일 분기별로 가장 높은 연봉을 받는 사람들의 
    -- 분기 , 사번 , 이름 , JOB, 상사사번, 입사일 , 급여, 상여를 출력하세요
    -- 1,2,3 - 1분기   /, 4,5,6 -> 2분기 , / 7,8,9 -> 3 / 10,11,12 -> 4  분기 추출은 MM/3을 올림
    SELECT HIREDATE, CEIL (EXTRACT (MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP;
    
     SELECT HIREDATE, CEIL (TO_CHAR (HIREDATE, 'MM') /3) "QUARTER" FROM EMP;
   SELECT HIREDATE, TO_CHAR(HIREDATE, 'Q') "QUARTER" FROM EMP; -- 서예린
    
    SELECT CEIL (EXTRACT (MONTH FROM HIREDATE)/3) , MAX(SAL) FROM EMP
       GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3); -- 서브쿼리
       
       SELECT CEIL(EXTRACT(MONTH FROM HIREDATE) /3 ) "QUARTER" , EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
            FROM EMP
            WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN
                    (SELECT CEIL(EXTRACT (MONTH FROM HIREDATE)/3), MAX(SAL)
                        FROM EMP
                        GROUP BY CEIL (EXTRACT(MONTH FROM HIREDATE) /3))
                ORDER BY QUARTER;
    
    
--탄탄 5. ● SALESMAN 모든 사원들 보다 급여를 많이 받는 사원들의 
--이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력하지 않는다.(ALL이용)

SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --서브쿼리
SELECT ENAME, SAL, JOB
    FROM EMP
        WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- 다중행 서브쿼리 이용한 메인쿼리

SELECT ENAME, SAL JOB
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB ='SALESMAN') AND JOB != 'SALESMAN';


--탄탄 6. ● SALESMAN 모든 사원들 중 어떤한사람 보다 급여를 많이 받는 사원들의 
--이름과 급여와 직급(담당 업무)를 출력하되 영업 사원은 출력하지 않는다.(ANY이용)

SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --서브쿼리
SELECT ENAME, SAL, JOB
    FROM EMP
        WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- 다중행 서브쿼리 이용한 메인쿼리

SELECT ENAME, SAL JOB
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB ='SALESMAN') AND JOB != 'SALESMAN';
    
-- 탄탄 7. 연봉이 3000미만인 사람 중에 가장 최근에 입사한 사람의 사원번호와 이름, 연봉, 입사일을 출력
SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000;
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000);

    
-- 탄탄 8● 직급이 ‘SALESMAN’인 사원이 받는 급여의 최소 급여보다 많이 받는 사원들의 
--이름, 급여, 직급, 부서번호를 출력하되 부서번호가 20번인 사원은 제외한다(ANY 연산자 이용)
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; -- 서브 쿼리 

SELECT ENAME, SAL, JOB, DEPTNO
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND DEPTNO != 20;
    
    
    
-- 14.  이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 직원의 사원 번호,이름,급여(단 사번 순 출력)
SELECT  DEPTNO FROM EMP WHERE ENAME LIKE '%T%';

        SELECT EMPNO, ENAME, SAL ,DEPTNO
        FROM EMP
        WHERE DEPTNO IN  (SELECT  DEPTNO FROM EMP WHERE ENAME LIKE '%T%');



-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여
SELECT LOC FROM DEPT WHERE  LOC = UPPER('Dallas');

    SELECT ENAME, JOB , SAL , LOC
    FROM EMP , DEPT
    WHERE LOC IN(SELECT LOC FROM DEPT WHERE  LOC = UPPER('Dallas'));


-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여
SELECT EMPNO FROM EMP WHERE ENAME = UPPER('King');

    SELECT W. ENAME,W.SAL , W.MGR
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO 
    AND W.MGR IN (SELECT EMPNO FROM EMP WHERE ENAME = UPPER('King'));
    
    SELECT ENAME, SAL FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE INITCAP(ENAME) = 'King');





-- 17. SALES부서 사원의 이름, 업무
SELECT JOB FROM EMP WHERE JOB = 'SALESMAN';

    SELECT ENAME, JOB
    FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE JOB = 'SALESMAN');


-- 18. 월급이 부서 30의 최저 월급보다 높은 사원의 모든 필드
SELECT MIN(SAL) FROM EMP WHERE DEPTNO ='30' GROUP BY DEPTNO ;


    
   SELECT * FROM EMP
   WHERE SAL > ALL(SELECT MIN(SAL) FROM EMP WHERE DEPTNO ='30' GROUP BY DEPTNO);




-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무

SELECT JOB FROM EMP WHERE DEPTNO=30;

SELECT ENAME, JOB FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30)
        AND DEPTNO=10;



-- 20.  FORD와 업무도 월급도 같은 사원의 모든 필드
SELECT JOB,SAL FROM EMP WHERE ENAME ='FORD';

SELECT * FROM EMP
    WHERE (JOB,SAL) IN (SELECT JOB,SAL FROM EMP WHERE ENAME ='FORD') AND ENAME != 'FORD'; 

-- 21. 이름이 JONES인 직원의 JOB과 같거나 FORD의 SAL 이상을 받는 사원의 정보를 이름, 업무, 부서번호, 급여
    -- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력
    SELECT JOB,SAL, ENAME FROM EMP WHERE ENAME ='JONES' OR ENAME ='FORD'; 
    
    SELECT ENAME, JOB, DEPTNO, SAL
        FROM EMP
            WHERE JOB IN (SELECT JOB FROM EMP WHERE ENAME ='JONES')
                                OR SAL >=(SELECT SAL FROM EMP WHERE ENAME = 'FORD');
    
    SELECT SAL FROM EMP;
    

-- 22. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여
SELECT SAL FROM EMP WHERE ENAME IN('SCOTT','WARD');

    SELECT ENAME , JOB, SAL
        FROM EMP
                WHERE SAL IN(SELECT SAL FROM EMP WHERE ENAME IN('SCOTT','WARD'));




-- 23. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무
SELECT JOB , LOC FROM EMP , DEPT  WHERE LOC = 'CHICAGO' ;
        
        SELECT ENAME , JOB, LOC
            FROM EMP , DEPT 
                WHERE   (JOB,LOC) IN (SELECT JOB,LOC FROM EMP , DEPT  WHERE LOC = 'CHICAGO');





-- 24. 부서별로 평균 월급보다 높은 사원을 사번, 이름, 급여, 부서번호
SELECT * FROM EMP;
SELECT DEPTNO , ROUND(AVG(SAL)) FROM EMP  GROUP BY DEPTNO;

    SELECT EMPNO, ENAME, SAL, DEPTNO
        FROM EMP E
            WHERE SAL   > (SELECT ROUND(AVG(SAL)) FROM EMP  WHERE E.DEPTNO=DEPTNO);
            




-- 25. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여
SELECT JOB , ROUND(AVG(SAL)) FROM EMP  GROUP BY JOB ;

    SELECT DEPTNO,ENAME,SAL
        FROM EMP E
            WHERE SAL > (SELECT ROUND(AVG(SAL)) FROM EMP WHERE E.JOB = JOB);
            
            SELECT ROUND(AVG(SAL)) FROM EMP WHERE 'MANAGER'=JOB;



-- 해당부서평균보다 높은 사원의 정보 - 사번, 이름, 급여, 부서번호, 해당부서의 평균 급여(소수점2자리)
SELECT EMPNO, ENAME, SAL , DEPTNO , ROUND((SELECT AVG(SAL)  FROM EMP WHERE DEPTNO=E.DEPTNO),2) AVG
        FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO); -- 서브쿼리 

SELECT EMPNO, ENAME, SAL, E.DEPTNO AVG
    FROM EMP E, (SELECT DEPTNO , ROUND(AVG(SAL), 2) "AVG"
    FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO AND SAL>AVG ; -- INLINE VIEW 이용





-- 26. 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무, 이름, 사번, 부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
  SELECT *FROM EMP;
        SELECT JOB,ENAME, EMPNO, DEPTNO 
        FROM EMP MANAGER
        WHERE EXISTS    (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR)
        ORDER BY  DEPTNO; 
    








-- 27.  말단 사원의 사번, 이름, 업무, 부서번호    
   SELECT EMPNO,ENAME,JOB,DEPTNO
             FROM EMP 
             WHERE EMPNO NOT IN ( SELECT NVL(MGR,0) FROM EMP);
    
    