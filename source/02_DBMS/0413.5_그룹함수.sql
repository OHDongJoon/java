-- [V] 그룹함수 : SUM, AVG , MIN(최소값), MAX(최대값), COUNT(숫자세는거), STDDEV(표준편차), VARIANCE(분산)


SELECT ENAME ,SAL FROM EMP;

SELECT ENAME, ROUND(SAL, -2) FROM EMP; --10의 자리에서 반올림 한다 (단일행함수) 4장 

SELECT MAX(SAL) FROM EMP;  -- SAL이 제일큰 거만 출력    -- 애가  그룹함수 5장  

SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 그룹함수(5장) -- 30번 부서에서 젤 많은 애 20번에서 급여 젤많은애 출력

SELECT ENAME, MAX(SAL) FROM EMP ;       --   (그룹이랑 단일이랑 그냥못씀)   최대급여를 받는 사람의 이름 (6장 서브쿼리) 셀렉트안에 셀렉트가있는거 


--★ 1. 그룹함수들 실습
SELECT ROUND (AVG(SAL),2) FROM EMP;

SELECT COUNT(*) FROM EMP; -- EMP 테이블의  행(로우ROW) TN 

SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;

SELECT COMM FROM EMP; --  SUM :300 + 500 + 1400 + 0(2200)  썸이 있으면 널은 빼놓고 더함   AVG :2200/4=550
 
-- 모든 그룹함수는 NULL값을 제외
SELECT SUM(COMM)합, AVG(COMM)평균, COUNT(COMM)몇명 , MIN(COMM) 최소, MAX(COMM) 최대 FROM EMP;

--  SAL의 평균, 합, 최소급여, 최대급여, 급여분산, 급여표준편차, 급여 갯수
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), VARIANCE(SAL) 급여분산, STDDEV(SAL) 표준편차 FROM EMP;

SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) FROM EMP;

-- 그룹함수 MIN, MAX, COUNT는 숫자형 앤 문자형 앤 날자형 모두 사용가능

SELECT MIN(ENAME)아스키코드작은애 , MAX(ENAME)아스키코드큰애, COUNT(ENAME), COUNT(COMM) FROM EMP;



-- 탄탄 1. 가장 최근에 입사한 사원의 입사일과 , 가장 최초입사한 사원의 입사일
SELECT MIN(HIREDATE) 최초입사일, MAX(HIREDATE)최근입사일, COUNT(HIREDATE)갯수 FROM EMP; 

-- 탄탄 2. 83/01/12 최근입사일 : XX,XXX일 근무 , 80/12/17 최초입사일 : XX,XXX일 근무 
SELECT MAX(HIREDATE) ||'  최근입사일 :'|| TRUNC(SYSDATE -MAX(HIREDATE))||'근무, '|| 
MIN(HIREDATE)||' 최초입사일 : '|| TRUNC (SYSDATE -MIN(HIREDATE))  FROM EMP;

SELECT MAX(HIREDATE) || ' 최근 입사일 : ' ||  
        TO_CHAR(SYSDATE-MAX(HIREDATE) , '99,999') || ' 일 근무 ,' || 
        MIN(HIREDATE)  || '최초 입사 : ' || 
        TO_CHAR (SYSDATE-MIN(HIREDATE), '99,999') || '일 근무'
    FROM EMP;
    
    
SELECT MAX(HIREDATE) || ' 최근입사일 : ' | | 
        TO_CHAR(MIN(SYSDATE-HIREDATE), '99,999') || '일 근무, ' || 
        MIN(HIREDATE) || '최초입사일 : ' ||
        TO_CHAR(MAX(SYSDATE-HIREDATE), '99,999') || '일 근무'
     FROM EMP;
     
-- 10번 부서소속의 사원 급여 평균 

-- 순서        (3)   --   FORM(1)  --      WHERE(2)
SELECT AVG(SAL) FROM EMP WHERE DEPTNO=10;
     
     
-- 해당 부서소속의 급여 평균


-- ★ 2. GROUP BY 절 
-- 부서번호별 최대급여, 최소급여, 급여평균, 급여합
-- GROUP BY 절에는 별칭 사용 불가
SELECT DEPTNO , JOB, MAX(SAL)최대급여, MIN(SAL)최소급여, ROUND(AVG(SAL))평균급여, SUM(SAL)합  
    FROM EMP 
    GROUP BY DEPTNO,JOB; 

            --EX. SAL이 5000 미만인 사원에 대해서만 부서번호별 사원수, 최대급여, 최소급여, 평균 급여 (부서번호순 정렬)
SELECT DEPTNO 부서, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL))  --SELECT 절에서는 필드 별칭 사용가능
    FROM EMP 
    WHERE SAL < 5000  --WHERE절에서는 필드 별칭 사용 불가
    GROUP BY DEPTNO  --  GROUP BY 절에서는 필드 별칭 사용 불가
    ORDER BY 부서;  --  ORDER BY 절에서는 필드 별칭  사용 쌉가능
    
    --EX. 부서명별 사원수, 최대급여, 최소급여, 평균급여  소수점 2자리
    SELECT DNAME , COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2) 
        FROM EMP E, DEPT D                                -- (1) ???질문
        WHERE E.DEPTNO = D.DEPTNO                --(2)
        GROUP BY DNAME                                  -- 3 <--> SELECT DNAME 
        ORDER BY COUNT(*) DESC;                     --4
        
        SELECT * FROM EMP;
        SELECT * FROM DEPT;
        


-- ★ 3. HAVING 절 : 그룹함수 결과의 조건
-- 부서번호별 평균 급여 ( 평균급여가 2000이상인 부서만 출력)
SELECT DEPTNO, ROUND(AVG(SAL)) FROM EMP GROUP BY DEPTNO;

------------그룹에서 사용못하는거--------------
SELECT DEPTNO, AVG(SAL) FROM EMP
    WHERE AVG(SAL)>=2000
    GROUP BY DEPTNO;  -- WHERE  절에서는 GROUP 함수 못씀 SELECT 에서만 사용ㅇ가능
----------------------------------------------

    SELECT DEPTNO, AVG(SAL) 
    FROM EMP       
     
     GROUP BY DEPTNO
     
     HAVING AVG(SAL) >= 2000 -- 별칭사용못함
     
     ORDER BY AVG(SAL);
   



-- SAL이 5000미만인 사원에 대해 부서명별 최소급여, 최대급여 평균 급여 (단, 평균급여가 2000이상인 부서명에 대해서 평균급여순으로 정렬)

SELECT DNAME, COUNT(*) , MIN(SAL), MAX(SAL), ROUND(AVG(SAL))
    FROM EMP E, DEPT D
   
   WHERE  E.DEPTNO = D.DEPTNO AND SAL < 5000
   
   GROUP BY DNAME
   
   HAVING AVG(SAL) >= 1800
   
   ORDER BY AVG(SAL);
    
  
  -- ★ 4. 결과 집합 내 집계값 생성
  
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
            -- 부서별, JOB별  급여합 
            
        SELECT DEPTNO, JOB, SUM(SAL) FROM EMP  GROUP BY  DEPTNO, JOB ORDER BY DEPTNO;
     
     -- 부서별, JOB별 급여함 ( 소계와 전체합 포함)
     SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP (DEPTNO, JOB);
     
     
   -- ★<총 연습문제>

-- 1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT ENAME ,COUNT(*),MAX(SAL), MIN(SAL),SUM(SAL) FROM EMP GROUP BY ENAME;


-- 2. 업무별 인원수를 구하여 출력
SELECT JOB,COUNT(*) FROM EMP GROUP BY JOB;




--- 3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT '최고급여 : '|| MAX(SAL),'최소급여 : '|| MIN(SAL),MAX(SAL)-MIN(SAL) FROM EMP; 




-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT DEPTNO 부서 , COUNT(*) 인원, ROUND(AVG(SAL))급여평균, MIN(SAL)최저급여, MAX(SAL)최고급여, SUM(SAL)급여의합 
FROM EMP 
GROUP BY DEPTNO 
ORDER BY SUM(SAL) DESC;



-- 5. 부서별(DEPTNO), 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력(부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO,JOB ,COUNT(*)인원수,AVG(SAL)급여의평균, SUM(SAL)급여의합
FROM EMP 
GROUP BY DEPTNO,JOB 
ORDER BY DEPTNO,JOB;




-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력
--(출력결과는 업무순, 부서번호 순 오름차순 정렬)

SELECT JOB 업무, DEPTNO 부서번호 , COUNT(*) 인원수,AVG(SAL) 급여의평균 ,SUM(SAL) 급여의합 
    FROM EMP
    GROUP BY JOB,DEPTNO 
    ORDER BY JOB,DEPTNO ;



--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO 부서번호,COUNT(*) 사원수
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*) >=5;




-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME 부서명,COUNT(*)사원수
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*) >= 5;



--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB 업무명 , ROUND(AVG(SAL)) 평균급여,SUM(SAL)급여의합
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL) >= 3000;




--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL) > 5000
    ORDER BY SUM(SAL) DESC;




--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT DEPTNO 부서 , ROUND(AVG(SAL))부서급여평균, SUM(SAL)부서급여합, MIN(SAL)부서별최소급여
FROM EMP
GROUP BY DEPTNO;



--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력
SELECT MAX(ROUND(AVG(SAL)))부서별급여평균최대값, MAX(SUM(SAL))부서별급여합의최대치 , MAX(MIN(SAL))부서별최소급여최대치
FROM EMP 
GROUP BY DEPTNO;




--WHERE WHERE TO_CHAR(HIREDATE, 'RR')='81';
--13. 사원 테이블에서 아래의 결과를 출력
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	  AVG(SAL)	SUM(SAL)
--     80	      1		           800		       800		800		    800
--  	 81	      10		       950		    5000	       2282.5	    22825
--    82	         2		        1300	         3000	      2150		   4300
--   83	        1		        1100	         1100	     1100	   1100
SELECT SUBSTR(HIREDATE, 1,2) H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL)), SUM(SAL)
FROM EMP

GROUP BY SUBSTR(HIREDATE, 1,2)
ORDER BY SUBSTR(HIREDATE, 1,2) ;
-------------------------------------------------------------------------------------------
SELECT TO_CHAR(HIREDATE,'RR') H_YEAR,COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL)), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE,'RR')
    ORDER BY H_YEAR;
-------------------------------------------------------

-- 14.  아래의 결과를 출력(입사년도별 사원수)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE,'YYYY'),'total') 년도, COUNT(*) 사원수
FROM EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE,'YYYY'))
ORDER BY TO_CHAR(HIREDATE,'YYYY');

SELECT NVL(EXTRACT(YEAR FROM HIREDATE),'total') 년도, COUNT(*) 사원수
FROM EMP
GROUP BY ROLLUP(EXTRACT(HIREDATE,'YYYY'))
ORDER BY YEAR;

--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL)최대급여, MIN(SAL) 최소급여, SUM(SAL) 전체급여합, ROUND(AVG(SAL)) 평균
FROM EMP;


--16. 부서별 인원수 출력
SELECT DEPTNO 부서,COUNT(*) 인원수
FROM EMP
GROUP BY DEPTNO;

--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DEPTNO 부서번호, COUNT(*) 인원수
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) >= 6;

--18. 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. 
-- (힌트 self join, group by, count사용)
--ENAME	    등수
--________________________
--KING		1
--SCOTT		2
--……  
SELECT E1.ENAME 이름, COUNT(E2.ENAME)+1 등수 
FROM EMP E1, EMP E2
WHERE E1.SAL < E2.SAL(+)
GROUP BY E1.ENAME 
ORDER BY COUNT(E2.ENAME)+1;


SELECT E1.ENAME,COUNT(E2.ENAME)+1
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+)      -- 1단계 : SELF JOIN / OUTER JOIN
     GROUP BY E1.ENAME
     ORDER BY COUNT(E2.ENAME)+1;
     
     
     
     -- 함수 사용
     
     SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK" ,
     DENSE_RANK() OVER(ORDER BY SAL DESC) "DANSE_RANK",
     ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER" FROM EMP;
     
     
     
     





     
     
     
     















