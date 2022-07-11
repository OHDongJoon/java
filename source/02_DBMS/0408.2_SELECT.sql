--[IT] SELECT -- 가장 많이 쓰이는 DML(Data Mainpulation Lanfuage) : 검색 기능 
-- 1. SQL SELECT문장 작성법
-- SHOW USER 현재 계정을 (실행 ctrl + Enter)
SHOW USER; 

SELECT * FROM TAB; -- 현 계정(scott)이 가지고 있는 테이블  *이건 모든 것

SELECT* FROM EMP; -- EMP 테이블의 모든 열(필드), 모든행

SELECT * FROM DEPT; -- DEPT 테이블의 모든 열, 모든 행

--EMP 테이블의 구조 

DESC EMP;

DESC DEPT;

-- 2. SQL문 실행 (특정 열만 출력)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;

SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB FROM EMP; -- 별칭

SELECT EMPNO AS 사번,  ENAME AS 이름,  SAL AS 급여,  JOB FROM EMP;

SELECT EMPNO  "사 번",  ENAME  "이 름",  SAL "급 여",  JOB FROM EMP;

SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP; --TITLE :NO,  NAME,  SALARY



-- 3. 특정 행 출력 : WHERE 절(조건) - 비교연산자 ; 같다(=), 크거나같다 (>=) , 다르다(!=, ^=, <>) 
SELECT EMPNO "사번", ENAME "이름" , SAL "급여" FROM EMP  WHERE SAL = 3000;

SELECT EMPNO "사번", ENAME "이름" , SAL "급여" FROM EMP  WHERE SAL != 3000;

SELECT EMPNO "사번", ENAME "이름" , SAL "급여" FROM EMP  WHERE SAL ^= 3000;

SELECT EMPNO "사번", ENAME "이름" , SAL "급여" FROM EMP  WHERE SAL <> 3000;


                        --- 비교 연산자는 숫자, 문자, 날짜형 모두 가능-----------
                        ----사원이름(ENAME)이 'A','B','C'로 시작하는 시원의 모든 필드
SELECT * FROM EMP WHERE ENAME < 'D'; 
        -- 81년도 이전에 입사한 사원의 모든 필드
    
    SELECT * FROM EMP WHERE HIREDATE < '81/01/01';    

                    -- ex. 10번 부서번호(deptno)인 사원의 모든 필드를 출력
SELECT* FROM EMP WHERE DEPTNO=10;

        --ex. 이름이 (ENAME)이 FORD인 직원의 EMPNO, ENAME, MGR(상사의 사번)을 출력
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';
select empno, ename, mgr from emp where ename = 'FORD'; -- 데이터는 대소문자 구분


--- 4. 논리연산자 : AND, OR
        -- eX. 급여 (SAL)가 2000이상 3000미만인 직원의 모든 필드
SELECT*FROM EMP WHERE SAL>=2000 AND SAL<=3000;

---ex 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';

                --날짜 표기법 셋팅(현재 : YY/MM/DD OR RR/MM/DD) 현재 이렇게 셋팅 되잇음 
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';

ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

SELECT ENAME, HIREDATE FROM EMP;

        --연봉이 2400 이상인 직원의 ENAME, SAL, 연봉 출력 (연봉은 SAL*12)

SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 > 2400;
--SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE 연봉*12 > 2400; -- WHERE 절에는 별칭을 쓸 수 없다

SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12>2400 ORDER BY 연봉; -- ORDER BY절은 별칭사용

--  10번 부서(DEPTNO)이거나 직책이 MANAGER인 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB='MANAGER';

--부서 번호가 10번이 아닌 사람의 모든 필드 출력

SELECT * FROM EMP WHERE DEPTNO != 10;

SELECT * FROM EMP WHERE NOT DEPTNO = 10;



-- 5. 산술표현식
SELECT ENAME, SAL "현재급여",SAL+100 "올릴 급여" FROM EMP WHERE DEPTNO = 10;

            -- ex. 모든 사원의 이름 (ENAME), 월급(SAL), 상여(COMM) , 연봉(SAL*12+COM)
            --산술연산의 결과는 NULL포함하면 결과도 NULL 
            -- NVL(NULL일 수도 있는 필드명, 대치값) 반드시 매개변수 둘은 타입이 같아야 함
            
            
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;

SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP;


        ---모든 사원의 사원명(ENAME), 상사의 사번(MGR) 을 출력(상사없으면  (없음) = 0)
SELECT ENAME, NVL(MGR,0) FROM EMP;
        
SELECT ENAME, NVL(MGR,'없음') FROM EMP;  -- NBL 매개변수 타입 불일치 에러


-- 6. 연결연산자(||) : 열이나 문자를 연결 
SELECT ENAME  || '은' || JOB "EMPLOYESS" FROM EMP;

        --ex. "SMITH : 연봉 = XXX"과 같이 모든 행 출력(연봉 = SAL*12+COMM)
SELECT ENAME || ': 연봉 = ' || (SAL*12+NVL(COMM,0)) FROM EMP;



--7. 중복제거 (DISTINCT)
SELECT JOB FROM EMP;

SELECT DEPTNO FROM EMP ;

SELECT DISTINCT JOB FROM EMP;

SELECT DISTINCT DEPTNO FROM EMP;


-- ★ 연습문제 꼭 풀기
    --1. emp 테이블의 구조 출력(오라클에서만 쓸수있음)
DESC EMP;
DESC DEPT;

    --2. emp 테이블의 모든 내용을 출력
SELECT*FROM EMP;

    --3. 현 scott 계정에서 사용가능한 테이블 출력
SHOW USER;
SELECT*FROM TAB;  -- 현재 계정이 가지고 있는 테이블

    --4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO AS "사번" ,ENAME AS "이름" ,SAL AS "급여" ,JOB AS "업무", HIREDATE "입사일"  FROM EMP;

    --5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL < 2000;

    --6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO,ENAME,JOB,HIREDATE FROM EMP 
WHERE HIREDATE >'81/02/01'; 

    -- TO_CHAR(날짜형 데이터를 특정한 패턴으로 변경)
SELECT EMPNO,ENAME,JOB,HIREDATE FROM EMP 
WHERE TO_CHAR(HIREDATE,'RR/MM/DD') >= '81/02/01'; 

    --TO_DATE(문자형 데이터를 특정한 패턴으로 변경)
SELECT EMPNO,ENAME,JOB,HIREDATE FROM EMP 
WHERE HIREDATE >= TO_DATE('81/02/01', 'YYYY-MM-DD'); 

        --DESC EMP;(무슨타입인지 확인하는법)

        -- # 날짜 설정 (YYYY 년도 4자리 , RR 년도 2자리 , M월 , D 일)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT ='RR/MM/DD';

    -- # 날짜형 -> 문자형 변환하는 함수 :  TO_CHAR(날짜형데이터를, 패턴)
    -- # 문자형 -> 날짜형 변환하는 함수 : TO_DATE(문자형데이터를, 패턴)

        --7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB = 'SALESMAN';

        --8. 업무가 CLERK이 아닌 사람들 모든 자료 출력 <> , ^= , NOT ,
SELECT * FROM EMP WHERE JOB != 'CLERK';

        --9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;

         --10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO,ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

        --11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO,ENAME,JOB,DEPTNO, SAL FROM EMP WHERE  JOB = 'SALESMAN' OR SAL >=3000;

        --12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER' ;

        --13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력((SAL*12+NVL(COMM,0)) FROM EMP;
SELECT ENAME || '은   ' || JOB || '   업무이고 연봉은   ' || (SAL *12 +NVL(COMM,0)) FROM EMP;





-------8. SQL 연산자(BETWEEN, IN  , LIKE, IS NULL_
        --(1) 데이터 BETWEEON A AND B (A<=B)
        -- ex . SAL 이   1500이상 3000이하인 사번 이름 급여
        
        -----------------------------------(WHERE  SAL) BETWEEON -------------------------
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >=1500 AND SAL<= 3000;

SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500; -- X


--  EX. 1500미만, 3000초과하는 모든 필드 ( NOT)
SELECT * FROM EMP  WHERE SAL  NOT BETWEEN 1500 AND 3000;
  
    --ex . 82년도에 입사한 직원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';

SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND '82/12/31';

    --ex . 사원이름이 'A', 'B'로 시작하는  사원의 모든 필드 
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME != 'C'; --A보다크고 C보다 같거나작은애  ,  뺄려면 AND ENAME != C

    -- ex. 사원이름이 'B','C'로 시작하는  사원의 모든필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME != 'D';

  -----------------  -- -------------------------(2)데이터 IN (A,B,C...)------------------------------------
        -- ex. 부서번호가 10,20,40번인 부서 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO =10 OR DEPTNO = 20 OR DEPTNO = 40;

SELECT * FROM EMP WHERE DEPTNO IN (10,20,40);
    
 ------------------   ------------ NOT IN ------------------------------------------
    -- ex. 부서번호가 10,20,40번 부서를 제외한 사원의 모든필드 
SELECT * FROM EMP WHERE DEPTNO NOT IN(10,20,40);

    -- ex. 사번이 7902, 7788, 7566인 사원의 모든 필드
SELECT * FROM EMP WHERE EMPNO IN(7902,7788,7566);



-----------(3) LIKE 연산----------
-- (문법) 데이터 LIKE 패턴(%

    --EX 이름이 M이 들어간 사원의 모든 필드


SELECT * FROM EMP WHERE ENAME LIKE '%M%';

   --EX 이름이 M으로 시작하는 사원의 모든필드
   SELECT * FROM EMP WHERE ENAME LIKE 'M%';
   
   -- EX 이름이 S로 끝나는 ㅅ ㅏ원의 모든필드
   SELECT * FROM EMP WHERE ENAME LIKE '%S';
   
   --EX SAL이 (숫자)  5로 끝나는 사원의 모든 필드------------
   SELECT * FROM EMP WHERE SAL LIKE '%5';
   SELECT * FROM EMP WHERE SAL = '2975'; -- 숫자형과 문자형 비교 가능
   
   --EX 82 년도에 입사한 사원의 모든 필드
   SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
   
   --EX 10년도 에 입사했으면 TO_CHAR
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
 
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82' ;  
   
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,  'RR') = 82;
   
   --EX 1월에 입사한 사원의 모든 필드
   
   SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '__/01/__';
   
   SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '01';
   
   -- 82 아닌
   SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';
   
    -- EX. 이름에 %가 들어간 사원의 모든 필드 
    SELECT * FROM EMP  WHERE ENAME LIKE '%%%' ;  -- % 0글자이상 이건 모든필드 다출력
   SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
    INSERT INTO EMP VALUES (9999, '홍%' , NULL, NULL, NULL, 9000, 900, 40) ; --데이터 입력
    
    ROLLBACK; -- DML (추가, 삭제, 수정) 로 수정된 데이터 원상복구 (DML 취소)
    
   -- (4) ---------IS NULL ;
   SELECT * FROM EMP ;
    -- EX. 상여금이 NULL인 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE COMM IS NULL;

SELECT * FROM EMP WHERE COMM = NULL; -- NULL 비교시 반드시 IS NULL로.

    -- EX. 상여금이 없는 사원의 모든 필드(COMM 이 NULL 이거나 0 )
    SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;
    
    --EX. 상여금이 있는 사원의 모든 필드
    SELECT * FROM EMP WHERE NOT  COMM  IS   NULL AND COMM != 0;
    
    
    
-- ----------9. 정렬(오름차순, 내림차순)
SELECT ENAME, SAL FROM EMP ORDER BY SAL; -- 급여 오름차순 정렬

SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC; -- 급여 오름차순 정렬

SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC; -- 급여 내림차순 정렬


SELECT ENAME, SAL FROM EMP ORDER BY ENAME; -- 이름 ABCD순으로  출력

SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; -- 이름  알파벳순 반대로 

SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE; --날짜 순서대로 정렬 

SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- 최신순서로 정렬

        --이름 , 연봉(SAL*12+COMM)을 출력(연봉이 높은 순으로 연봉이 같은 경우 이름순으로)
SELECT ENAME, SAL*12+NVL(COMM, 0) AS "ANNUAL_SAL" FROM EMP 
ORDER BY SAL*12+NVL(COMM, 0) DESC, ENAME;

SELECT ENAME, SAL*12+NVL(COMM, 0) AS "ANNUAL_SAL" 
    FROM EMP 
    ORDER BY ANNUAL_SAL DESC, ENAME; -- ORDER BY 절에는 별칭 사용 가능(FROM - WHERE - SELECT - ORDER)

    --EX. 사번, 이름, 입사일, 급여, 부서번호( 부서번호순, 부서가 같으면 입사일오름차순 으로 출력
    SELECT EMPNO, ENAME,HIREDATE,DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE DESC;




-- ★   연습 문제 (꼭 구현하기)

--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
 SELECT  EMPNO, ENAME, JON, SAL 
 FROM EMP 
 WHERE SAL >= 3000;

--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT EMPNO,ENAME, DEPTNO
FROM EMP 
WHERE EMPNO = 7788;

--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO,ENAME,SAL 
FROM EMP WHERE (SAL*12+NVL(COMM, 0)) >= 24000
ORDER BY SAL  DESC;

--4.	DLQ싸일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 출력 (단 hiredate 순으로 출력)  ???@#?!?#!@?#
SELECT ENAME,JOB,HIREDATE FROM EMP 
WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' 
ORDER BY HIREDATE;

--5.	deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME DESC;

--6.	sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 TITLE을 employee과 Monthly Salary로 출력)
SELECT DEPTNO, ENAME "EMPLOYEE", SAL "MONTHLY SALARY" FROM EMP 
WHERE SAL >= 1500 AND DEPTNO IN (10,30);

--7.	hiredate가 1982년인 사원의 모든 정보를 출력
  SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/__/__';
 SELECT * FROM EMP  WHERE TO_CHAR(HIREDATE,'RR/MM/DD') LIKE '82__/__/';
 SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
 SELECT * FROM EMP WHERE HIREDATE LIKE '82%';

--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME != 'Q' ORDER BY SAL, ENAME;


--9.	comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
--출력하는 SELECT 문을 작성
SELECT ENAME, SAL,COMM FROM EMP WHERE COMM > SAL * 1.1;


--10.	job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력

 
 SELECT*FROM EMP WHERE  
 JOB = 'CLERK'  OR  JOB = 'ANALYST' 
 AND  SAL NOT IN (1000, 3000,5000);

--11.	ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
--모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT* FROM EMP 
WHERE ENAME LIKE '%L%L% 'AND DEPTNO = 30 OR MGR ='7782' ;

--12.	입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
WHERE TO_CHAR(HIREDATE,'RR') =81;

--13.	입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
-- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME,HIREDATE,JOB,SAL FROM EMP 
WHERE TO_CHAR(HIREDATE,'RR')=81 AND JOB !='SALESMAN';

--14.	사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE , JOB, SAL FROM EMP  
    ORDER BY SAL DESC, HIREDATE;

--15.	사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--16.	사원명에 'A'가 들어간 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';

--17.	연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO,ENAME,SAL*12 연봉 FROM EMP WHERE SAL *12 >= 10000;

