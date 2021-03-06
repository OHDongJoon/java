-- [VIII] SEQUENCE : 순차번호 생성기, 대부분 인위적인 PX 사용 용도 
DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ
    START WITH 1  --1 부터시작
    INCREMENT BY 1    --1 씩 증가 
    MAXVALUE 9999    --  MAX9999
    MINVALUE 1             -- MIN 1
    NOCACHE        --  1 .2.3. 4. 실행했다고 치면 컴퓨터는 23 까지 공간을 만들어 놓는데   컴퓨터 종료 후 실행하면  5부터 시작안하고 23부터 시작 
    NOCYCLE;       -- 9999  다음 1로 못가게하고 에러를 발생 시킴
    
    
    
    
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;     --수행할때 마다 1씩 증가 
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

DROP TABLE FRIEND;
CREATE TABLE FRIEND (
    NUM NUMBER(4) PRIMARY KEY,         -- 시퀀스 이용 
    NAME VARCHAR2(30) NOT NULL,
    TEL      VARCHAR2(30) UNIQUE,     --번호는 똑같은 번호 없으니까 유니끄  ,  NULL허용 , 유일한 값
    ADDRESS VARCHAR2(300),
    LAST_MODIFYED DATE DEFAULT SYSDATE);

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL ,'박길동' ,'010-9999-9999' ,'서울시 강남구 강남대로94길 13 삼겸빌딩 402' );

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
    VALUES (FRIEND_SEQ.NEXTVAL, '신길동', '010-8888-8888', '서울시 영등포구');
SELECT * FROM FRIEND;


SELECT FRIEND_SEQ.CURRVAL FROM DUAL;
COMMIT;


-- ex. 초기값 101 부터 최대값 999,999까지 1씩 증가하는 test_seq 시퀀스를 생성
CREATE SEQUENCE TEST_SEQ START WITH 101 MAXVALUE 999999 NOCACHE NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL;  -- 시퀀스의 현재 값이 없어서 에러
SELECT TEST_SEQ.NEXTVAL FROM DUAL;   -- 


SELECT * FROM MAJOR;


-- 총 연습문제  1
SELECT * FROM MEMBER;
CREATE SEQUENCE MEMBER_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    MINVALUE 1
    NOCACHE        
    NOCYCLE;
SELECT MEMBER_SEQ.NEXTVAL FROM DUAL;     --수행할때 마다 1씩 증가 
DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(2) PRIMARY KEY,
    LEVELNAME VARCHAR2(30) NOT NULL
    );
SELECT * FROM MEMBER_LEVEL;


    DROP TABLE MEMBER;
    INSERT INTO MEMBER_LEVEL(LEVELNO,LEVELNAME) VALUES(-1,'bLACK');
    INSERT INTO MEMBER_LEVEL(LEVELNO,LEVELNAME) VALUES(0,'일반');
    INSERT INTO MEMBER_LEVEL(LEVELNO,LEVELNAME) VALUES(1,'실버');
    INSERT INTO MEMBER_LEVEL(LEVELNO,LEVELNAME) VALUES(2,'골드');
    
    
    CREATE TABLE MEMBER(
    mNO     NUMBER(2) PRIMARY KEY,
    mNAME VARCHAR(30) NOT NULL,
    mPW     VARCHAR(8),
    mEMAIL VARCHAR(50),
    mPOINT  NUMBER(4) CHECK(mPOINT>=0),
    mRDATE DATE DEFAULT SYSDATE,
     LEVELNO NUMBER(2) NOT NULL,
    FOREIGN KEY(LEVELNO) REFERENCES MEMBER_LEVEL(LEVELNO)
    );
    
    DROP TABLE MEMBER;
    
    INSERT INTO MEMBER ( mNO, mNAME,  mPW ,mEMAIL,mPOINT,mRDATE,LEVELNO) 
             VALUES (MEMBER_SEQ.NEXTVAL ,'홍길동' ,'aa' ,'hong@hong.com', 0,'22/03/10',0);
    
    INSERT INTO MEMBER ( mNO, mNAME,  mPW ,mEMAIL,mPOINT,mRDATE,LEVELNO) 
             VALUES (MEMBER_SEQ.NEXTVAL ,'신길동' ,'BB' ,'sin@sin.com ', 1000,'22/04/01',1);
            
             SELECT * FROM MEMBER M ,MEMBER_LEVEL L 
             WHERE M.LEVELNO = L.LEVELNO;
   
    
    
   

    
    