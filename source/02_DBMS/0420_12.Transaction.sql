-- [XII] TRANSACTION 명령어 : COMMIT(트랜잭션반영); , ROLLBACK(트랜잭션 취소);, SAVEPOINT(트랜잭션 분할)
DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT; 
SELECT * FROM DEPT01; -- 10,20,30,40 
DELETE FROM DEPT01; -- 삭제 
SELECT * FROM DEPT01; --확인 없는거
ROLLBACK; -- 새로운 트랜잭션 시작  다시 원상복구
SELECT * FROM DEPT01; -- 10, 20, 30, 40
DELETE FROM DEPT01 WHERE DEPTNO=40;
COMMIT;
-- 새로운 트랜젝션 시작
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO = 30;
SELECT * FROM DEPT01;
SAVEPOINT C1; -- C1지점 : 10,20번 부서 

DELETE FROM DEPT01 WHERE DEPTNO = 20;
SELECT * FROM DEPT01; -- 10
SAVEPOINT C2; --C2지점 10번 부서 


DELETE FROM DEPT01 WHERE DEPTNO = 10;
SELECT * FROM DEPT01 ; -- 데이터 없음 

ROLLBACK TO C2;
SELECT * FROM DEPT01 ;-- 10번 부서 로 고고링 

ROLLBACK TO C1;
SELECT * FROM DEPT01; --10 , 20번 부서 

COMMIT;
SELECT * FROM DEPT01;





















