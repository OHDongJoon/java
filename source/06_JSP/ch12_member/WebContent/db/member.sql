--TABLE DROP & CREATE
DROP TABLE MEMBER CASCADE CONSTRAINTS;

CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
     PHONE3 VARCHAR2(5),
     GENDER VARCHAR2(1),
     EMAIL    VARCHAR2(30),
     BIRTH    DATE,
     RDATE    DATE NOT NULL,
     ADDRESS VARCHAR2(200)
) ;


--1. 회원가입시 ID중복체크:  public int  confirmID(String id)
SELECT * FROM MEMBER WHERE ID='aaa' ;

--2.회원가입 :public int joinMember(MemberDto dto) 변수 
INSERT INTO MEMBER (ID, PW, NAME, PHONE1,PHONE2,PHONE3,GENDER,EMAIL,BIRTH,RDATE,ADDRESS)
    VALUES ('aaa','111','오동준','02','1111','1111','m','dong@.com', '1995-10-10',SYSDATE,'서울');

--3.로그인 (id/pw) : public int loginCheck(String id, String pw)
SELECT id,pw FROM MEMBER WHERE ID ='aaa';

--4. ID로 dto(모든변수값) 가져오기 : public MemberDto getMember(String id)
SELECT * FROM MEMBER WHERE ID='aaa';


--5. 회원정보 수정  : public int modifyMember(MemberDto dto)
UPDATE MEMBER SET PW='111',
                                NAME = '오원빈',
                                PHONE1 = '010',
                                PHONE2='9999',
                                PHONE3='8888',
                                GENDER = 'm',
                                EMAIL = 'a@A.COM',
                                BIRTH = '1990-12-01',
                                ADDRESS = '제주'
                            WHERE ID='aaa';



SELECT * FROM MEMBER; --회원가입해 1 안돼 0
COMMIT;













