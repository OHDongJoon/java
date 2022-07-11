-- DROP & CREATE
DROP TABLE MVC_MEMBER;
CREATE TABLE MVC_MEMBER (
     MID           VARCHAR2(30)      PRIMARY KEY,
    MPW           VARCHAR2(30)      NOT NULL,
    MNAME       VARCHAR2(30)  NOT NULL,
    MEMAIL       VARCHAR2(30) UNIQUE,
    MPHOTO      VARCHAR2(30) NOT NULL,    -- 회원가입시 사진업로드를 안 할시 기본 이미지로(NOIMG.JPG)
    MBIRTH       DATE,
    MADDRESS  VARCHAR2(300),
    MRDATE       DATE DEFAULT SYSDATE NOT NULL
);
     SELECT * FROM MVC_MEMBER;
     --더미데이터
     INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jang','1','장동건',null,'jang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jo','1','조현우',null,'jo.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kang','1','강동원',null,'kang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kim','1','김태희',null,'kim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lee','1','이선빈',null,'lee.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lim','1','임요한',null,'lim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('park','1','박보검',null,'park.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('rain','1','비',null,'rain.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('s','1','송가연',null,'s.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('son','1','손흥민',null,'son.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('song','1','송중기',null,'song.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('song2','1','송혜교',null,'song2.jpg',null,null);
     -- DAO에 들어갈 QUERT
     --(1) 로그인
     SELECT * FROM MVC_MEMBER WHERE MID='aaa' AND MPW='111';
     
     --(2) mID 로 DTO 가져오기 (
            SELECT * FROM MVC_MEMBER WHERE MID ='aaa';
     
     --(3) 회원중ID복체크
   SELECT * FROM MVC_MEMBER WHERE MID='aaa';
     
     --(4)회원가입
     INSERT INTO MVC_MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO,MBIRTH, MADDRESS)
          VALUES ('aaa','111','슬기','KOK@.COM','sl.png','1995-10-10','강남구');
          
     INSERT INTO MVC_MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO,MBIRTH, MADDRESS)
          VALUES ('bbb','111','슬기2','aaa@.COM','sl2.jpg','1995-10-10','부산');
    
     INSERT INTO MVC_MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO,MBIRTH, MADDRESS)
          VALUES ('ccc','111','슬기3','bbb@.COM','sl3.jpg','1995-12-11','익산');
          
     INSERT INTO MVC_MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO,MBIRTH, MADDRESS)
          VALUES ('ddd','111','슬기4','bbb@.COM','sl4.png','1995-12-11','서울');
    
     INSERT INTO MVC_MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO,MBIRTH, MADDRESS)
          VALUES ('ADF','111','슬기5','bbb@.COM','sl5.jpg','1995-12-11','서울');
          
    
          
    --(5) 회원정보 수정
    UPDATE MVC_MEMBER SET MPW ='111',
                                            MNAME ='슬기',
                                            MEMAIL = 'NAVER@.COM',
                                            MPHOTO = 'sl6.jpg',
                                            MBIRTH = '1300-10-20',
                                            MADDRESS = '제주'
                                            WHERE MID     = 'aaa';
    --(6) 회원리스트(TOP-N구문)
    SELECT  *
    FROM(SELECT ROWNUM RN, MID, MPW, MNAME, MEMAIL, MADDRESS ,MRDATE
                    FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE))
    WHERE RN BETWEEN 1 AND 3;

SELECT  *
				    FROM(SELECT ROWNUM RN, MID, MPW, MNAME, MEMAIL,MPHOTO,MBIRTH, MADDRESS ,MRDATE
				                    FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE)) 
				   WHERE RN BETWEEN 1 AND 3;
    --(7) 회원수 
 SELECT COUNT (*) TOTCNT FROM MVC_MEMBER;
                                            
     SELECT * FROM MVC_MEMBER;
     COMMIT;
     
     
     