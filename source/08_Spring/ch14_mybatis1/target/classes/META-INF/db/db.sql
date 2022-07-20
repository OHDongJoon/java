-- Dept.xml 파일안에서 sql문 하나당 id 하나씩 (나중에 sql문을 사용하려 할때 그 sql문의 아이디를 호출 하기 땜)

-- DEPT.XML 의 ID=deptList
SELECT * FROM DEPT;

-- Emp.xml의 id=emlpList  
 --  ENAME JOB 이 0일 수도 있는데 DEPTNO만 입력하면 SQL 문이 완성 안됨  
 --그래서 WHERE 1=1
 -- 부분적으로 실행 가능 한거만 출력 
SELECT * FROM EMP WHERE 1=1
   AND  ENAME LIKE '%' || 'A' || '%'
        AND JOB LIKE '%' || 'E' || '%' 
            AND DEPTNO=20;

