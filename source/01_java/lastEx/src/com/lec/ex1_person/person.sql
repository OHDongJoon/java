-- ���̺� ���� (���� �̸��� ���̺��� �����Ǿ��� ��� DROP)
DROP TABLE JOB;
DROP TABLE PERSON;
CREATE TABLE JOB(
    JNO     NUMBER(2)       PRIMARY KEY,
    JNAME VARCHAR2(30) NOT NULL );
    
CREATE TABLE PERSON(
    PNO NUMBER(5) PRIMARY KEY,
    PNAME VARCHAR2(30)  NOT NULL,
    JNO      NUMBER(2),
    KOR     NUMBER(3),
    ENG     NUMBER(3),
    MAT     NUMBER(3),
    FOREIGN KEY(JNO) REFERENCES Job(JNO));
    
    DROP SEQUENCE PERSON_NO_SQ;
    DROP TABLE PERSON;
    CREATE SEQUENCE PERSON_NO_SQ MAXVALUE 9999 NOCACHE NOCYCLE;
-- ���̵�����
 INSERT INTO JOB VALUES (10, '���');
     INSERT INTO JOB VALUES (20, '����');
     INSERT INTO JOB VALUES(30,'����');
     SELECT * FROM JOB;
     
      INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL ,'���켺', 10 , 90, 80, 81);
    INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL , '�ڼ���', 10, 80, 90 ,80);
    INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, '�����',  20, 70, 90, 90);
    INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL ,'����',    20, 95, 95,95);
    INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL ,'������',  10, 100,10,100);
   SELECT * FROM PERSON;

COMMIT;
-- 1�� : pNAME(�̸�) , JNAME(������), KOR, ENG, MAT�� �Է¹޾� INSERT
INSERT INTO PERSON
    VALUES (PERSON_NO_SQ.NEXTVAL , 'ȫ�浿', (SELECT JNO FROM JOB WHERE JNAME ='����'), 81,83,85);

-- 2�� : �������� �Է� �޾� ���    �̸� (pNO) ������(jNAME) , ����, ���� , ���� , ������ ���(�������������� �������� ����)
SELECT PNAME | | ' (' ||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT,  KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
        WHERE P.JNO = J.JNO AND JNAME='���'
            ORDER BY SUM DESC;

-- 3�� : ��� ���� ���, �̸� (pNO) ������(jNAME) , ����, ���� , ���� , ������ ���(�������������� �������� ����)

SELECT  ROWNUM RANK, A.*

    FROM (SELECT PNAME | | ' (' ||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT,  KOR+ENG+MAT SUM 
        FROM PERSON P, JOB J
            WHERE P.JNO = J.JNO ORDER BY SUM DESC)A;


-- �޺��ڽ��� �� ������ list 
SELECT JNAME FROM JOB;

   
   





