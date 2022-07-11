-- DROP TABLE
DROP TABLE STUDENT;
DROP TABLE MAJOR;
-- CREATE TABLE
CREATE TABLE MAJOR(
    mNO NUMBER(2),
    mNAME VARCHAR2(50) NOT NULL,
    PRIMARY KEY(mNO));
CREATE TABLE STUDENT(
    sNO VARCHAR2(7),
    sNAME VARCHAR2(50) NOT NULL,
    mNO NUMBER(2) NOT NULL,
    SCORE NUMBER(3) DEFAULT 0,
    sEXPEL NUMBER(1) DEFAULT 0,
    PRIMARY KEY(sNO),
    CHECK(SCORE>=0 AND SCORE<=100),
    CHECK(sEXPEL=0 OR sEXPEL=1),
    FOREIGN KEY(mNO) REFERENCES MAJOR(mNO));
DROP SEQUENCE STUDENT_SEQ;
CREATE SEQUENCE STUDENT_SEQ MAXVALUE 999 NOCACHE NOCYCLE;
-- ���� ������ �Է� : �а�����
INSERT INTO MAJOR VALUES (1, '��ǻ�Ͱ���');
INSERT INTO MAJOR VALUES (2, '�濵������');
INSERT INTO MAJOR VALUES (3, '���������');
INSERT INTO MAJOR VALUES (4, '�Ź������');
INSERT INTO MAJOR VALUES (5, '�������');
SELECT * FROM MAJOR;
-- �й� �����ϱ�
SELECT TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY')||SUBSTR(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000'), 2, 3) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY')||LPAD(STUDENT_SEQ.NEXTVAL, 3, '0') FROM DUAL;

SELECT EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000')) FROM DUAL;
SELECT EXTRACT(YEAR FROM SYSDATE)||SUBSTR(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000'), 2, 3) FROM DUAL;
SELECT EXTRACT(YEAR FROM SYSDATE)||LPAD(STUDENT_SEQ.NEXTVAL, 3, '0') FROM DUAL;

DROP SEQUENCE STUDENT_SEQ;
CREATE SEQUENCE STUDENT_SEQ MAXVALUE 999 NOCACHE NOCYCLE;

-- ���� ������ : �л� ����
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE)
    VALUES (EXTRACT(YEAR FROM SYSDATE)||LPAD(STUDENT_SEQ.NEXTVAL, 3, '0'), 'ȫ�浿',
            (SELECT MNO FROM MAJOR WHERE MNAME='��ǻ�Ͱ���'), 100);
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE)
    VALUES (EXTRACT(YEAR FROM SYSDATE)||LPAD(STUDENT_SEQ.NEXTVAL, 3, '0'), 'ȫ�浿',
            (SELECT MNO FROM MAJOR WHERE MNAME='��ǻ�Ͱ���'), 90);
COMMIT;
SELECT * FROM STUDENT;
-- ���α׷� DAO�� �� SQL��
--0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName) : public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;
--1. �й��˻� (sNo, sName, mName, score) : public StudentDto sNogetStudent(String sNo)
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND SNO='2022001';
--2. �̸��˻� (sNo, sName, mName, score) : public ArrayList<StudentDto> sNamegetStudent(String sName)
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M
    WHERE S.MNO=M.MNO AND SNAME='ȫ�浿';
--3. �����˻� (rank, sName(sNo����), mName(mNo����), score) 
                    --: public ArrayList<StudentDto> mNamegetStudent(String mName)
SELECT ROWNUM RANK, SNAME, MNAME, SCORE
    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE
                FROM STUDENT S, MAJOR M
                WHERE S.MNO=M.MNO AND MNAME='��ǻ�Ͱ���'
                ORDER BY SCORE DESC); -- DAO�� �� SQL
--4. �л��Է� : public int insertStudent(StudentDto dto)
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE)
    VALUES (EXTRACT(YEAR FROM SYSDATE)||LPAD(STUDENT_SEQ.NEXTVAL, 3, '0'), '�ű浿',
            (SELECT MNO FROM MAJOR WHERE MNAME='�濵������'), 99);
COMMIT;
SELECT * FROM STUDENT;
--5. �л����� : public int updateStudent(StudentDto dto)
UPDATE STUDENT SET SNAME='�ż���',
                   MNO=(SELECT MNO FROM MAJOR WHERE MNAME='���������'),
                   SCORE = 98
            WHERE SNO=2022003;
    -- ������ �л�����(SCORE)�� 80�̻��̰�, �������� ��� ���������� �߰��ϰ��� �� ��
    UPDATE STUDENT SET SEXPEL = 0
            WHERE SNO=2022003 AND SCORE>80;
COMMIT;
SELECT * FROM STUDENT;
--6. �л���� (rank, sName(sNo����), mName(mNo����), score) : public ArrayList<StudentDto> getStudents()
SELECT ROWNUM RANK, SNAME, MNAME, SCORE
    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE
                FROM STUDENT S, MAJOR M
                WHERE S.MNO=M.MNO AND SEXPEL=0
                ORDER BY SCORE DESC);
--7. ���������  (rank, sName(sNo����), mName(mNo����), score) 
                    -- : public ArrayList<StudentDto> getStudentsExpel()
SELECT ROWNUM RANK, SNAME, MNAME, SCORE
    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||M.MNO||')' MNAME, SCORE
                FROM STUDENT S, MAJOR M
                WHERE S.MNO=M.MNO AND SEXPEL=1
                ORDER BY SCORE DESC);
--8. ����ó�� : public int sNoExpel(String sNo)
UPDATE STUDENT SET SEXPEL = 1 WHERE SNO=2022003;
ROLLBACK;


    