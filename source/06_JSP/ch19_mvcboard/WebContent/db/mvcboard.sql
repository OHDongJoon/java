-- BOARD table DROP & CREATE
    DROP SEQUENCE BOARD_SEQ;
    CREATE SEQUENCE BOARD_SEQ 
      MAXVALUE 999999
      NOCACHE 
      NOCYCLE;
    DROP TABLE BOARD;
-- DUMMY DATA
    CREATE TABLE BOARD(
       bID NUMBER(6) PRIMARY KEY,
       bNAME       VARCHAR2(50)          NOT NULL,
       bTITLE      VARCHAR2(100)        NOT NULL,
       bCONTENT VARCHAR2(1000),
       bDATE        DATE                         DEFAULT SYSDATE NOT NULL, -- 작성시점
       bHIT           NUMBER(6)               DEFAULT    0 NOT NULL,             -- 조회수 
       bGROUP     NUMBER(6)                NOT NULL,                                  -- 글 그룹
       bSTEP         NUMBER(6)               NOT NULL,                                   -- 글 그룹내 출력순서
       bINDENT     NUMBER(6)                NOT NULL,                                  -- 들여쓰기
       bIP              VARCHAR2(20)          NOT NULL);

-- DUMMY DATA

    INSERT INTO BOARD (bID , bNAME , bTITLE, bCONTENT , bGROUP , bSTEP , bINDENT , bIP)
           VALUES (BOARD_SEQ.NEXTVAL, '손석구', '글1' , '-' , BOARD_SEQ.CURRVAL, 0, 0, '192.168.10.30');
    
    INSERT INTO BOARD (bID , bNAME , bTITLE, bCONTENT , bGROUP , bSTEP , bINDENT , bIP)
           VALUES (BOARD_SEQ.NEXTVAL, '마동석', '글2' , '-' , BOARD_SEQ.CURRVAL, 0, 0, '192.168.10.30');
    SELECT * FROM BOARD;
      --1번글의 답변 DUMMY DATA
    INSERT INTO BOARD (bID , bNAME , bTITLE, bCONTENT , bGROUP , bSTEP , bINDENT , bIP)
         VALUES (BOARD_SEQ.NEXTVAL, '답녀' , '글1-1', '답' , 1, 1, 1, '191.222');

-- DAO에 들어갈 QUERY

-- 글목록 (startRow ~ endRow)
    SELECT *FROM BOARD ORDER BY BGROUP DESC, BSTEP;  -- 글 출력 순서
        SELECT * 
               FROM (SELECT ROWNUM RN, A.* FROM(SELECT *FROM BOARD ORDER BY BGROUP DESC, BSTEP) A)
                      WHERE RN BETWEEN 1 AND 5;

--전체 글 갯수 
SELECT  COUNT(*) FROM BOARD;

-- 원글쓰기 
     INSERT INTO BOARD (bID , bNAME , bTITLE, bCONTENT , bGROUP , bSTEP , bINDENT , bIP)
               VALUES (BOARD_SEQ.NEXTVAL, '신민아', '글3' , '-' , BOARD_SEQ.CURRVAL, 0, 0, '192.168.10.30');

-- BID로 조회수 올리기 
    UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID=1;
    
    commit;
    
    
    
    
    
    
    
    


-- 글 상세보기 (bID로 DTO 가져오기 )
    SELECT * FROM BOARD WHERE BID=1;

-- 답변글 쓰기전 STEP A  (기존의 답변글의 출력 순서를 +1) :1번글의 답변글 쓸 예정
    SELECT * FROM BOARD WHERE BGROUP = 1;  -- 1번 글 GROUP 출력
    UPDATE BOARD SET  BSTEP = BSTEP + 1 WHERE BGROUP = 1 AND BSTEP > 0 ;

-- 답변글 쓰기 
INSERT INTO BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)
         VALUES (BOARD_SEQ.NEXTVAL, '홍답' , '글1-2', NULL , 1,1,1, '127.9');

-- 글  수정 
UPDATE BOARD SET BNAME = '강호동',
                                    BTITLE = '수정글',
                                    BCONTENT = '수정된 본문 입니다',
                                    BIP = '192.168.'
                            WHERE BID = 2;
SELECT * FROM BOARD;
-- 글삭제 
DELETE FROM BOARD WHERE BID =2;











