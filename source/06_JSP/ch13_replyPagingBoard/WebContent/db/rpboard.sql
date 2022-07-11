-- 테이블 drop & create -rpboard.sql-
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM              NUMBER(5,0)        PRIMARY KEY, --글번호
    WRITER          VARCHAR2(30)    NOT NULL, --글쓴이
    SUBJECT         VARCHAR(100)   NOT NULL, --글제목
    CONTENT         VARCHAR(4000) NOT NULL, -- 본문
    EMAIL               VARCHAR2(30),                         --작성자 이메일
    READCOUNT     NUMBER(5)        DEFAULT 0, -- 조회수 ( 글 HITT)
    PW                     VARCHAR2(30)  NOT NULL, -- 글 삭제시 사용할 비밀번호
    REF                  NUMBER(5,0)      NOT NULL, -- 글 그룹 (원글일 경우, 글번호 / 답변글일 경우 원글의 글번호로)
    RE_STEP             NUMBER(5)       NOT NULL, -- 그룹내 출력 순서 (원글 0 )
    RE_INDENT        NUMBER(5)       NOT NULL, -- 글 list 출력시 제목 들여쓰기 정도(원글0)
    IP                      VARCHAR2(20)  NOT NULL,  --  글작성시 컴퓨터 ip주소
    RDATE               DATE                  DEFAULT SYSDATE NOT NULL --글쓴 시점(날짜 + 시간)
    
    );
   
    
--1.글 갯수   (*) 특수문자 있어서  
SELECT COUNT(*) FROM BOARD; 

-- 2. 글 목록(최신글이 위로)
SELECT * FROM BOARD ORDER BY NUM DESC;
SELECT * FROM BOARD ORDER BY REF DESC;
    
-- 3. 글쓰기(원글쓰기)
    --글쓰기 시 글번호 만들기
    SELECT NVL(MAX(NUM),0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER,SUBJECT,CONTENT,EMAIL,PW,REF,RE_STEP,RE_INDENT, IP)
    VALUES(  (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '오동준', '글제목1' , '본문입니다\n 불금이야', NULL,
            '1',  (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0,'192.168.10.3');

INSERT INTO BOARD (NUM, WRITER,SUBJECT,CONTENT,EMAIL,PW,REF,RE_STEP,RE_INDENT, IP)
    VALUES(  (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '최진영', '글제목2' , '본문입니다\n 불금이야', NULL,
            '1',  (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0,'192.168.10.3');

INSERT INTO BOARD (NUM, WRITER,SUBJECT,CONTENT,EMAIL,PW,REF,RE_STEP,RE_INDENT, IP)
    VALUES(  (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '대환콩', '글제목3' , '본문입니다\n 불금이야', NULL,
            '1',  (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0,'192.168.10.3');

--4. 글번호를 글 (DTO) 가져오기 
SELECT * FROM BOARD WHERE NUM=2;

-- 5. 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM =1;


-- 6. 글수정
UPDATE BOARD SET SUBJECT = '수정된제목1',
                CONTENT = '브라질한테 5대1로 진 한국..',
                EMAIL = 'kok3@naver.com',
                PW = '1',
                IP = '127.0.0.1'
                WHERE NUM=2;


-- 7. 글 삭제(비밀번호)
COMMIT;
DELETE FROM BOARD WHERE NUM =1 AND PW='1';

 SELECT * FROM BOARD;


--조회수 조작
UPDATE BOARD SET READCOUNT = 12 WHERE NUM=3;

DELETE FROM BOARD WHERE NUM  BETWEEN    10 AND 20;


-- 8. 페이징을 위한 top-N 구문 (startRow~endRow 까지 출력할 top-N) 
SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP; -- 1단계

SELECT ROWNUM RN, A.*
    FROM(SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A; --2단계

SELECT * 
    FROM(SELECT ROWNUM RN, A.*
   FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A)
    WHERE RN BETWEEN 11 AND 20; -- 최종 TOP-N 구문


--9. 원글 150번 글 입력 : 글번호와 REF가 같고, RE_STEP=0, RE_INDENT=0
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES (150, '원글자','글150','본문','KOK@W.COM','1',
                    150, 0, 0, '192.168.1.1');
-- 답변글 저장전 해야할 STEP(엑셀의 ⓐ STEP)
UPDATE BOARD SET RE_STEP = RE_STEP+1 WHERE REF=150 AND RE_STEP>0;
COMMIT;
--150번글의 답변글
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES (151, '답변자', '글150-1', '본문', 'WOW@.COM','1',
                    150, 1, 1, '192.168.1.12');

--2번째-- 답변글 저장전 해야할 STEP(엑셀의 ⓐ STEP)
UPDATE BOARD SET RE_STEP = RE_STEP+1 WHERE REF=150 AND RE_STEP>0;

--150번글의 답변글
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES (152, '답변자2', '글150-2', '본문', 'WOW@.COM','1',
                    150, 1, 1, '192.168.1.12');


SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP;
SELECT * FROM BOARD WHERE NUM = 151;

-- 150번 원글의 답변글 152번글의 답변글
SELECT * FROM BOARD WHERE NUM = 152; -- 애가 이제 원글이 됩니다 
    -- ⓐ STEP 
    UPDATE BOARD SET RE_STEP=RE_STEP+1 WHERE REF=150 AND RE_STEP > 1;
    -- 답변글 저장 : 원글 152번의 REF, RE_STEP+1, RE_INDENT +1
    INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
        VALUES (153, '답답자' , '글152-1','본문',NULL,'1', 150, 2, 2, '192.168.1.1');

