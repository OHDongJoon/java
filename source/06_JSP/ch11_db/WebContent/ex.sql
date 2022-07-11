SELECT * FROM EMP; -- 실행은 실행하고자하는 sql문을 블럭잡고 alt+x  => result 탭에 결과 나옴 간단한견 여기에 실행할 수 있는데 비추천 얍
SELECT * FROM DEPT;
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE ENAME LIKE '%'||upper('al')||'%';
DESC EMP;