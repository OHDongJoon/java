-- Member.xml(회원가입,  id로 memberDto로 가져오기,  로그인, 정보수정)
-- idConfirm
SELECT * FROM MEMBER WHERE mID='aaa';
SELECT * FROM MEMBER;
-- joinMember
INSERT INTO MEMBER VALUES ('bbb','111','유재석','yu@naver.com','67890','서울');-- getDetailMember
-- modifyMember

UPDATE MEMBER SET mNAME='오석구',
                        mPW = '123',
                        mMAIL = 'kok3443@naver.com',
                         mPOST = '12345',
                         mADDR ='제주'
            where mID='aaa';
-- 수정하기 (mid)뷰
SELECT * FROM MEMBER WHERE mID='aaa';

--Book.xml (페이징없이 신규순list, 페이지징! 포함도서list(책이름순), 책갯수 , 상세보기, 도서등록 , 도서수정)



-- mainList
SELECT * FROM BOOK;
SELECT * FROM BOOK order by brdate DESC;
commit;

-- bookList
SELECT * FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT * FROM BOOK ORDER BY bTITLE )A)
                WHERE RN BETWEEN 1 AND 10;
COMMIT;
-- totCntBook
SELECT COUNT(*) FROM BOOK;

-- getDetailBook
SELECT * FROM BOOK WHERE BNUM =1;
DELETE FROM BOOK WHERE BTITLE ='Spring frame';
-- registerBook
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'Spring frame','김작가',SYSDATE, 'noImg.png','noImg.png','스프링 프레임');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'web programing','박제이',SYSDATE, 'noImg.png','웹프로그래밍');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'web','윤길동',SYSDATE, 'noImg.png','정적 웹');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, '이것이 JAVA다','박자바',SYSDATE, 'OOP');
SELECT * FROM BOOK;

--modifyBook
UPDATE BOOK SET BTITLE='MYBA',
                        bWRITER = '오동준',
                        brdate = '22/07/26',
                        bIMG1 = 'noImg.png',
                        bIMG2 = 'noImg.png',
                        bINFO ='국비로살아남기'
            where bNUM='4';
SELECT * FROM BOOK WHERE BNUM = 4;
COMMIT;


