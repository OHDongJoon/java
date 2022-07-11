-- [VII] DDL, DML, DCL
-- SQL = DDL( 테이블 생성 , 테이블 삭제, 테이블 구조변경, 테이블 모든 데이터 제거) 롤 백 못함
  --         DML(검색 = SELECT, 추가 = INSERT, 수정=UPDATE, 삭제 = DELETE)
  --         DCL(사용자계정생성, 사용자권한부여,  권한박탈, 사용자게정삭제

-- ● VARCHAR2 :가변 길이 문자 데이터 , (1~4000)  

-- ● CHAR : 고정 길이 문자 데이터  입력된 자료의 길이와 상관 없이 정해진 길이 만큼 차지

-- ● NUMBER(w) ; W자리까지의 수치로 최대 38자리까지 가능하다. (38자리가 유효 숫자이다.)

-- ● NUMBER(w, d) ; W는 전체 길이, d는 소수점 이하 자릿수이다. 소수점은 자릿수에 포함되지 않는다.

-- ● DATE : BC 4712년 1월 1일~AD 4712년 12월 31일까지의 날짜


----  ●  CLOB는 e-BOOK과 같은 대용량의 텍스트 데이터를 저장하기 위해서 사용합니다. 


-- ★ ★ ★ DDL ★ ★ ★ 

-- 1. 테이블 생성 (CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID          NUMBER(4),   -- 도서 번호  BOOKID 필드 타입은 숫자 4자리
    BOOKNAME    VARCHAR2(300) , -- 책이름 BOOKNAME 필드는 문자 300BYTE
    PUBLISHER    VARCHAR2(300) , -- 출판사 PUBLISHER 필드는 문자 300 BYTE
    RDATE           DATE,                      -- 출판일 RDATE 필드는 DATE형
    PRICE            NUMBER(8),              -- 가격 PRICE 필드는 숫자 8자리 
    PRIMARY KEY(BOOKID) );        --  테이블 내 주키(PRIMARY KEY) 설정  -NOT NULL, 유일한 값 입력

SELECT * FROM BOOK;

DROP TABLE BOOK;

CREATE TABLE book (
    bookid              NUMBER (4) PRIMARY KEY,
    BOOKNAME      VARCHAR2 (20), -- 가변 길이 문자 데이터 , (1~4000)    , CHAR 고정 길이 문자 데이터  입력된 자료의 길이와 상관 없이 정해진 길이 만큼 차지
    PUBLISHER      VARCHAR2(20),
    RDATE             DATE,
    PRICE              NUMBER(8) ) ;      
    
    SELECT * FROM BOOK;
    DESC EMP;
    
    SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM : 테이블에서 읽어들인 논리적 순서
    SELECT ROWNUM , EMPNO, ENAME FROM  EMP WHERE DEPTNO=20 ORDER BY ENAME;




-- EMP 테이블과 유사한 EMP01 : EMPNO(숫자4) , ENAME(문자20), SAL(숫자7,2)

CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL   NUMBER(7,2) ) ;

-- DEPT와 유사한 DEPT01 : DEPTNO(숫자 2 , PK) , DNAME(문자 14) , LOC(문자 13)
CREATE TABLE DEPT01 (
    DEPTNO NUMBER(2) ,
    DNAME VARCHAR2(14),
    LOC     VARCHAR2(13),
    PRIMARY KEY(DEPTNO) ) ;
DESC DEPT01;

SELECT * FROM TAB;  -- SCOTT이 생성한 테이블 LIST

--서브쿼리 를 이용한 테이블 생성

                                            --(서브쿼리)
CREATE TABLE EMP02 AS SELECT * FROM EMP;  -- 서브쿼리 결과만 EMP02테이블 생성후 들어감 (제약조건으느 미포함) ?? 

DESC EMP;

SELECT * FROM EMP02;

DESC EMP02;

    --EX. EMP03 : EMP 테이블에서 EMPNO, ENAME, DEPTNO만 추출한 데이터로 테이블 
CREATE TABLE EMP03
        AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
                    SELECT * FROM EMP03;
    
    -- EX EMP04 : EMP 테이블에서 10번 부서만 추출한 데이터로 테이블
CREATE TABLE EMP04 
                AS SELECT * FROM EMP WHERE DEPTNO = 10;
                            SELECT * FROM EMP04;
    
 
    -- EX EMP 05 : EMP 테이블 구조만 추출 필드 타입만 데이터는 놉
    CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE 1=0; -- 구조만 가져와야 되기 때문에 WHERE 에 1은 0랑 같다 이건 평생 거짓이다 
    
    SELECT * FROM EMP05;

    DESC EMP05;
    

---- 2. 테이블 구조 변경(ALTER TABLE)

-- ALTER TABLE 테이블명 ADD  ||  MODIFT || DROP ~

-- (1) 필드 추가 (ADD)  : 추가된 필드의 데이터는 NULL

SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO 이거에서 

ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2)); -- JOB SAL 추가

SELECT * FROM EMP03; 

ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));

-- (2) 필드 수정 (MODIFY)
SELECT * FROM EMP03;  -- EMPNO(숫4), ENAME(문10), DEPTNO(숫2) /  데이터 NULL: JOB(문20), SAL(숫 7,2), COMM(숫 7,2)

ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- 이미 숫자 데이터가 들어 있어서 바차로 바꾸기 힘이드르무니다  숫자로만 변경 가능
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- 에러 같은 타입은 가능한데 들어 있는 데이터 보다 작으면 안됨 불가능
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- 가능
ALTER TABLE EMP03 MODIFY (ENAME NUMBER(4)); -- 문자 데이터가 들어 있는  상태에서는 문자로만 변경 가능
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(3000));
DESC EMP03;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6));
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- 에러 ( 6BYTE 글자 데이터가 있어서)

ALTER TABLE EMP03 MODIFY (JOB NUMBER(4));

-- (3) 필드 삭제 (DROP) 
ALTER TABLE EMP03 DROP COLUMN JOB; -- JOB 필드 삭제 
SELECT * FROM EMP03;

-- 논리적으로 특정 필드를 접근 못하도록 (낮)
ALTER TABLE EMP03 SET UNUSED (DEPTNO); -- 
SELECT * FROM EMP03;

-- 논리적으로 접근 불가했던 필드를 물리적으로 삭제(새벽)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;
SELECT * FROM EMP03;


-- 3. 테이블 삭제( DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- 다른 테이블에서 참조하는 데이터가 있을 경우 DROP  안됨
SELECT * FROM EMP; 

-- 4. 테이블의 모든 행을 제거 (TRUNCATE) 
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- EMP03안의 모든데이터 제거 ( 롤백 (취소불가) 구조만 남음

-- 5. 테이블명 변경(RENAME)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT*FROM EMP2;


-- -6)데이터 딕셔너리(접근 불가) VS. 데이터 딕셔너리 뷰(사용자 접근용)
--종류


--USER_XXX : 현 계정이 소유하고 있는 객체(테이블, 인덱스, 제약조건, 뷰)
    --EX.USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS


SELECT * FROM USER_TABLES;  --내 계정이 소유한 테이블 객체 정보
SELECT * FROM USER_INDEXES; --내 계정이 소유한 인덱스 정보
SELECT * FROM USER_CONSTRAINTS; --내 계정이 소유한 제약조건들
SELECT * FROM USER_VIEWS;   --내 계정이 소유한 뷰 정보

--ALL_XXX : 현 계정이 접근 가능한 객체(테이블, 인덱스, 제약조건, 뷰)
    --EX.ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;

--DBA_XXX : DBA권한자만 접근 가능, DBMS의 모든 객체
    --EX.DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS
    
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;



-- ★ ★ ★ DCL(사용자계정생성, 사용자권한부여, 권한박탈, 사용자계정삭제) ★ ★ ★ ????
-- scott2 계정 생성
CREATE USER scott2 IDENTIFIED BY 1234; 
-- 권한부여(세션권한, scott.EMP, scott.DEPT 테이블에 대해 모든 권한

GRANT CREATE SESSION TO scott2; -- 로그인

GRANT ALL ON EMP TO scott2; -- EMP 테이블에 대한 모든 권한 (검색, 추가, 수정, 삭제) SCOTT2 는 EMP ALL로 다가져옴 

GRANT ALL ON DEPT TO scott2;

show user;

--권한 박탈 REVOKE : (권한박탈할 사용자계정이 접속해제 하고 할수있음)
REVOKE ALL ON EMP FROM scott2; -- scott2 의 emp 테이블에 대한 모든 권한 박탈

REVOKE ALL ON DEPT FROM scott2;
show user;
-- 사용자 계정 삭제 (접속 중인 계정 삭제 불가)
DROP USER scott2 CASCADE;


SELECT * FROM EMP WHERE DEPTNO = 10;

-- -----------------------------문제

DROP TABLE SAM01;

CREATE TABLE SAM01(
    EMPNO          NUMBER(4),   
    ENAME    VARCHAR2(10) , 
    JOB        VARCHAR2(9) ,
    SAL          NUMBER(7,2),                  
               
               CONSTRAINT SAMPK PRIMARY KEY(EMPNO) );        -- PIRMARY KEY 이름 넣기 
              
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
-- 트래잭션  명령어 
COMMIT;
--COMMIT : 트랜잭션 확정 (TCL)

-- 2. UPDATE 테이블명 SET 필드명1 = 값1 [, 필드명2=값2, ...] [WHERE 조건] ;

DROP TABLE EMP01;
    CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- EMP01 테이블의 부서번호를 30으로 수정(WHERE 절 없이는 모든 행이 수정)
UPDATE EMP01 SET DEPTNO=30;
    ROLLBACK;  트래잭션 취소 (DML만 취소 가능)
    SELECT * FROM EMP01;

-- EMP01 테이블의 모든 사원의 급여를 10%=1.1 인상
UPDATE EMP01 SET SAL = SAL * 1.1 ;
SELECT * FROM EMP01;

-- 10번 부서의 직원의 입사일을 오늘로, 부서번호는 30번으로 수정
UPDATE EMP01 
        SET HIREDATE = SYSDATE , 
            DEPTNO = 30 
                WHERE DEPTNO = 10; 
SELECT * FROM EMP01;

-- SAL이 3000이상인 사원만 SAL 10%인상
UPDATE EMP01
    SET SAL = SAL *1.1 WHERE SAL >= 3000;

-- 'DALLAS'에 근무하는 직원의 급여를 1000$씩 인상 (서브쿼리사용)
-- 조인이 안되니 달라스에서 근무하는 DEPTNO을가져와 서브쿼리에 
-- DEPTNO에 SELECT DEPTNO FROM DEPT 웨어 LOC 달라스 
UPDATE EMP01 
    SET SAL = SAL + 1000 
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC ='DALLAS');
    SELECT * FROM DEPT, EMP ORDER BY LOC ;
    
    -- SCOTT의 부서번호를 20으로 , JOB을 MANAGER로 , SAL과 COMM을 500씩 인상, 상사 KING으로 수정
    UPDATE EMP01
        SET DEPTNO = 20 , 
            JOB ='MANAGER',
                SAL = SAL + 500 ,
                    COMM = NVL(COMM,0) + 500,
                        MGR = (SELECT EMPNO FROM EMP WHERE ENAME ='KING') 
                        -- 스콧 엠지알에     킹 사번   프롬 이엠피에서 웨어조건 네임이 킹 인 
                    WHERE ENAME = 'SCOTT';
                SELECT * FROM EMP01 WHERE ENAME = 'SCOTT';
                SELECT * FROM EMP01 WHERE ENAME = 'KING';
    
    
    SELECT * FROM DEPT01;
    -- DETO01 에서 20부터의 지역명을 DEPT 테이블의 60번부서의 지역명으로 변경
    UPDATE DEPT01
        --셋한다 뭐를 LOC를 ( 어떻게 ? 
        SET LOC =(SELECT LOC FROM DEPT WHERE DEPTNO = 60)
            WHERE DEPTNO>=20; -- NULL이 들어가는이유 DEPT 테이블의 60번 부서가 없어서 NULL 값으로 수정
   
    -- EMP01테이블의 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정'
 COMMIT;
 ROLLBACK;
    UPDATE EMP01
        SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
                HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
    SELECT * FROM EMP01;
    
UPDATE EMP01
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');
 
 -- DEPT01 테이블의 20번 부서의 지역명과 부서명을 40번 부서의 지역명과 부서명으로 변경
 UPDATE DEPT01
    SET (DNAME,LOC) = (SELECT DNAME,LOC  FROM DEPT01 WHERE DEPTNO = 40 )
    WHERE DEPTNO =20;
 COMMIT;
 
 
 
--3. DELETE FROM 테이블명 [WHERE 조건] ;   = 비슷함  =  (TRUNCATE)   -- 4. 테이블의 모든 행을 제거  다른 점은 롤백 비슷함
SELECT * FROM EMP01;
DELETE FROM EMP01;  -- WHERE 절을 안 쓸경우 전체 행이 모두 삭제 
ROLLBACK;


-- EMP01테이블에서  'FORD'인 사원을 삭제 
    DELETE FROM EMP01
        WHERE ENAME = 'FORD' ;
            SELECT * FROM EMP01 WHERE ENAME ='FORD';

-- EMP01 테이블에서 30번 부서 직원을 삭제
    DELETE FROM EMP01 WHERE DEPTNO = 30;
    SELECT * FROM EMP01;
-- EMP01 테이블에서 부서명이 RESEARCH 부서 직원을 삭제
    DELETE FROM EMP01
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
            SELECT * FROM EMP01;

-- SAM01 테이블에서 JOB이 정해지지 않은 사원을 삭제
SELECT * FROM SAM01;
    DELETE FROM SAM01 
        WHERE JOB IS NULL;
            SELECT * FROM SAM01;
-- SAM01 테이블에서 ENAME이 ORANGE인 사원을 삭제하세요
    DELETE FROM SAM01
        WHERE ENAME =  'ORANGE';
 
 SELECT * FROM SAM01;
 
 
 -- 문제 2
 --1번 테이블 만들기

CREATE TABLE MY_DATA(

ID              NUMBER(4),

NAME            VARCHAR2(30),

USERID        VARCHAR2(30) ,

SALLARY            NUMBER(10,2),

    CONSTRAINT DATA PRIMARY KEY(ID) );

  

    SELECT  *   FROM MY_DATA; 

    -- 2번 MY_DATA INSERT

INSERT INTO MY_DATA (ID, NAME, USERID,  SALLARY )VALUES( 1, 'Scott', 'sscott', 1000000);

INSERT INTO MY_DATA (ID, NAME, USERID, SALLARY  ) VALUES( 2, 'Ford', 'fford' , 1300000);

INSERT INTO MY_DATA (ID, NAME, USERID, SALLARY  ) VALUES( 3, 'Patel', 'ppatel', 3300000);

INSERT INTO MY_DATA (ID, NAME, USERID, SALLARY  ) VALUES( 4, 'Report','rreport',2350000);

INSERT INTO MY_DATA (ID, NAME, USERID, SALLARY  ) VALUES( 5, 'Good' ,'ggood',4445000);

 

--3. 화면처럼 SELECT 

SELECT  ID , NAME , USERID , TO_CHAR(SALLARY ,'99,999,99') FROM MY_DATA ORDER BY ID;

 

--4 COMMIT 하기 조아쓰

COMMIT;

--5. ID 3번인 사람한테 급여 65000.00 바꾸기 

UPDATE MY_DATA 

    SET SALLARY = 65000.00 

        WHERE ID = '3';

        SELECT * FROM MY_DATA WHERE ID ='3';

        

-- 6. FORD 사람 삭제하고 커밋  (DELETE 는 FROM 써야댐 )

DELETE FROM MY_DATA 

    WHERE NAME = 'Ford';

        SELECT * FROM MY_DATA 

            WHERE NAME ='Ford';

                    COMMIT;

-- 7. SALARY가 15,000.00 이하인 사람의 급여를 15,000.00으로 변경하라

UPDATE MY_DATA

    SET SALLARY = 1500000 

            WHERE SALLARY <= 1500000; 

             SELECT * FROM MY_DATA ORDER BY ID;

-- 8 삭제 

    DROP TABLE MY_DATA;
    
    
    -- ★★★ 제약조건 : 부적합한 데이터가 테이블에 삽입되는 것을 방지하기 위해 
    SELECT * FROM EMP ;
    INSERT INTO EMP VALUES (NULL, '홍', NULL, NULL , SYSDATE, NULL, NULL, 40);  -- 똑같은 SMITH랑 번호 사번 못들어가자나 
`    UPDATE EMP SET EMPNO=7369 WHERE ENAME = 'ALLEN'; -- SMITH 사번과 중복 에러 

-- ★ (1) PRIMARY KEY  : 유일하게 테이블의 각 행을 식별. NOT NULL  NULL 안되고 무조건 값을 넣어야 됨
               INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES  (7369, '홍', 40) ; -- 중복 사번 입력불가
        
-- (2) NOT NULL        : NULL 값을 포함하지 않음 

-- (3) UNIQUE            : 모든 행에 대해 유일해야. NULL값을 허용 (NULL은 여러행 입력 가능)

--★(4) FOREIGN KEY  : 테이블의 열은 다른 테이블의 열을 참조 (EX. EMP테이블의 DEPTNO는 DEPT 테이블의 DEPTNO를 참조)
               
                -- 비식별 관계 : 부모테이블의 주키가 자식테이블의 일반속성에 속한 필드로 관계 (exERD에서 빨간점선화살표)
                
                -- 식별  관계   :  부모테이블의 주키가 자식테이블의 주키에 속한 필드로 관계 ( exERD에서 초록점선화살표)
                 INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES  (1111, '홍', 90);  -- DEPTNO 90 없으면 오류 (외래키로 90번 입력 불가)
    
-- (5) CHECK(조건)          :   해당 조건이 만족(NULL값 허용)


--    DEFAULT               : 기본값 설정( 해당 열의 데이터 입력 값이 없으면   NULL이 들어감)



CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE, -- 유일해야됨 NULL 값 허용 
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



DROP TABLE EMP1; -- 자식테이블(참조하는 테이블) 먼저 DROP
DROP TABLE DEPT1; --다른 테이블에서 참조하는 필드가 있을 때(부모테이블은) 먼저 DROP 안 됨.

DROP TABLE DEPT1 CASCADE CONSTRAINTS; -- 비추 ( 참조하는 테이블이 있어도 무시하고 DROP)
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
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO)); --카테고리코드

INSERT INTO DEPT1 SELECT * FROM DEPT;

SELECT * FROM DEPT1;
INSERT INTO DEPT1 VALUES (40, 'IT', 'SEOUL'); --  40 잇어PK 위배
INSERT INTO DEPT1 VALUES (50, 'SALES', 'SEOUL'); -- 유니크 
INSERT INTO DEPT1 VALUES (50, 'IT', NULL); -- NOT NULL DNLQO


INSERT INTO EMP1 ( EMPNO, ENAME, DEPTNO)
            VALUES ( 1001, ' 홍', 10);
SELECT * FROM EMP1; -- HIREATE에 설정된 기본값 입력 ( EMP1 =HIREDATE    DATE DEFAULT SYSDATE,)

INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO)
    VALUES (1001, '김', 10) -- PK 위배

INSERT INTO EMP1 (EMPNO, DEPTNO)
    VALUES (1002, 20); -- ENAME인 NOT NULL 위배 ENAME은 값 무조건 들어가야지 

INSERT INTO EMP1 (EMPNO, ENAME, SAL)
    VALUES (1002, '박', -1);  -- SAL > 0  커야 되는데 -1 이여서 
INSERT INTO EMP1 VALUES (1002, '윤', NULL , MGR ,TO_DATE( '95/01/01', 'YY/MM/DD'),900,NULL,99);  -- FK 위배 



SELECT * FROM DEPT1;

 
 -- 연습문제 (PDF, 4,5페이지)
 CREATE TABLE  BOOKCATEGORY(
    CATEGORY_CODE    NUMBER(3) PRIMARY KEY,
    CATEGORY_NAME   VARCHAR2(50) UNIQUE,
    OFFICE_LOC            VARCHAR2(50) NOT NULL);
 

  --BOOKCATEGORY
 INSERT INTO BOOKCATEGORY VALUES (100,'철학','3층 인문실');
  INSERT INTO BOOKCATEGORY VALUES (200,'인문','3층 인문실');
   INSERT INTO BOOKCATEGORY VALUES (300,'자연과학','4층 과학실');
    INSERT INTO BOOKCATEGORY VALUES (400,'IT','4층과학실');
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
 INSERT INTO BOOK VALUES(100,'100A01','철학자의 삶', '더존출판',2021);
 INSERT INTO BOOK VALUES(400,'400A01','이것이DB다','더존출판',2018-11-30);
 INSERT INTO BOOK VALUES (400,'400A02','이것이D다','더출판',2018);
---------------------------------------------------------------------------------------------
----5페이지 ````````````````-----------------------------------------
CREATE TABLE (
    MAJOR_CODE   NUMBER(2) PRIMARY KEY,
    MOJOR_NAME    VARCHAR(50) UNIQUE,
    MAJOR_LOC      VARCHAR(50) NOT NULL
);
 SELECT * FROM MAJOR;
 
 
 INSERT INTO MAJOR VALUES(1,'경영정보','경영관305호');
 INSERT INTO MAJOR VALUES(2,'소프트웨어공학','정보관 808호');
 INSERT INTO MAJOR VALUES(3,'디자인','예술관606호');
 INSERT INTO MAJOR VALUES(4,'경제','경상관202호');

 
 CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR(3) PRIMARY KEY,
    STUDENT_NAME VARCHAR(50) NOT NULL,
    SCORE                  NUMBER(3)  ,       ------------ 요기 
    MAJOR_CODE   NUMBER(2),
    FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE)
   );
 INSERT INTO STUDENT VALUES('A01','김길동',100,1);
  INSERT INTO STUDENT VALUES('A02','문길동',90,2);
   INSERT INTO STUDENT VALUES('A03','홍길동',95,1);
 SELECT * FROM STUDENT;