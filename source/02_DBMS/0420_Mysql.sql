-- DCL (계저어생성 , 권한부여, 권한 박탈, 게정삭제)
-- DDL (제약조건 , 시퀀스 없음 )
-- DML ( outer join, AND = &&, OR=||, 일부단행함수)
-- java에서 쓸 데이터 넣고 연습해 보기 

show databases; -- database 리스트 보기 

-- ★ ★ ★ DCL(계정 생성, 권한 부여, 권한 박탈, 계정 제거)
create user user01 identified by 'password';-- 계정 생성 했숨돠
grant all privileges on *.* to user01; -- 권한부여
revoke all on *.* from user01; -- 권한 박탈
drop user user01;


-- 데이터베이스로 들어감
show databases;
create database kimdb;   -- 새로운 kimdb 데이터베이스 생성
use kimdb; -- kimdb 데이터베이스로 들어감
select database(); -- 현재 들어와 있는 데이터베이스 
use world; -- world 데이터베이스로 들어감
use kimdb; -- kimdb 데이터베이스로 들어감
show tables; -- 오라클의 select * from tab;





--   ★ ★ ★ DDL (테이블생성, 제약조건, 시퀀스 없음)
create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique,
    sal		numeric(7,2) check(sal>0),
    hiredate   datetime  default now(),
    comm	numeric(7,2) default 0
    
);
select * from emp;
drop table if exists emp; -- 있으면 지워라 !
-- Major (mCode(시퀀스같은 순차번호) : PK, mName, mOffice)
-- Student (sNo:PK, sName, mCode)

create table major(
	mCode int primary key auto_increment, -- auto_increment일 경우 int,  시퀀스 없어서 = auto_increment
    mName varchar(20), 
    mOffice varchar(50) );
create table student(
	sNo int primary key,
    sName varchar(20),
    mcode int references major(mCode) );
insert into major (mName, mOffice) values ('컴공', '402호');
insert into major (mName, mOffice) values ('경영', '502호');
insert into major (mName, mOffice) values ('경제', '301호');
select * from major;

insert into student values (1111,'홍', 1);
insert into student values (2222,'이', 2);
insert into student values (3333,'사', 3);
insert into student values (4444,'박', 4);

select * from student;

drop table if exists student;
drop table if exists major;

create table major (
	mCode int  auto_increment,
    mName varchar(30) not null,
    mOffi varchar(30),
    primary key (mCode));

create table student(
	sNo int,
    sName varchar(30),
    mCode int,
    primary key(sNo),
    foreign key(mCode) references major(mCode) );
insert into major (mName, mOffi) values ('컴공', '402호');
insert into major (mName, mOffi) values ('경영', '502호');
insert into major (mName, mOffi) values ('경제', '301호');
select * from major;

insert into student values (1111,'홍', 1);
insert into student values (2222,'이', 2);
insert into student values (3333,'사', 3);
insert into student values (4444,'박', 4);

select * from student;
-- 학번, 이름 , 학과코드, 학과명, 사무실
select sNo, sName, s.mCode, mName, mOffi
	from student s, major m
    where s.mCode = m.mCode;
-- 자바 수업시간에 쓸 테이블
drop table if exists personal;  -- emp 테이블 유사
drop table if exists division;  -- dept 테이블과 유사 

create table division(
	dno int, 			-- 부서번호
    dname varchar (20), -- 부서이름
    phone varchar (20), -- 전화번호 
	position varchar(20), -- 부서위치
    primary key(dno) );
insert into division values (10, 'finance', '02-545-5555','강남');
insert into division values (20, 'research', '02-777-7777','회현');
insert into division values (30, 'sales', '02-333-3333','서초');
insert into division values (40, 'marketing', '02-666-6666','과천');
select * from division;

create table personal(
	pno int , 					-- 사번
    pname varchar(20) not null,	-- 사원명
    job   varchar(20) not null, -- 직책
    manager int,				-- 상사의 사번
    startdate date,				-- 입사일
    pay		int,					-- 급여 
    bonus 	int,					-- 상여
    dno		int,
    primary key(pno),
    foreign key(dno) references division(dno) );
    



insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
commit;
select * from personal;
select * from division;



-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
 select pno, pname, dno 
	from personal  
		where dno in (10,20);
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay 
	from personal
		where bonus is null order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서번호 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal  
		order by dno , pay desc;
		
-- 6. 사번, 이름, 부서명
select pno, pname , dname
	from personal p , division d
		where p.dno = d.dno ;

-- 7. 사번, 이름, 상사이름
select w.pno'사번', w.pname '이름', m.pname '상사이름'
	from personal w, personal m
		where w.manager = m.pno;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력, 상사가 없으면 대신 null 대신 'ceo')

select w.pno, w.pname, ifnull(m.pname, 'ceo') 
	from personal w left outer join personal m
    on w.manager = m.pno; -- left outter join 

select w.pno, w.pname, if(m.pname is null , 'ceo', m.pname) 
	from personal w left outer join personal m
    on w.manager = m.pno; -- left outter join 
    
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal 
	where pname like '%s%';

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno '사번', w.pname'이름', w.pay'급여', d.dname'부서명' , m.pname'상사이름'
	from personal w, personal m , division d
		where w.manager = m.pno and  w.dno = d.dno ;

-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from  personal 
		group by dno;




-- 12. 부서명, 급여평균, 인원수
select d.dname, avg(pay), count(*)
	from division d, personal p
		where d.dno = p.dno
		group by d.dname;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select d.dname, sum(pay), count(*) 
	from division d, personal p
		where d.dno = p.dno and count(*) >= 4 group by d.dname ;
	



-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno , pname, pay ,max(pay)
	from personal ;

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno 
	from personal 
		where pay > (select avg(pay) from personal);

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pname, pay, p.dno, dname
	from personal p, division d
		where p.dno = d.dno
			and pay > (select avg(pay) from personal)
				order by dname,pay desc;





-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select pname, pay, dno, round((select avg(pay) from personal where dno = p.dno))
	from personal p
		where pay > (select avg(pay) from personal where dno=p.dno);



-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
	select pname, pay, startdate
		from  personal 
			 where startdate = (select min(startdate) from personal);


-- 19. 이름, 급여, 해당부서평균
	select pname, pay,  round((select avg(pay) from personal where dno=p.dno))
		from personal p;



-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, d.dname, round((select avg(pay) from personal where dno=p.dno))
	from personal p , division d 
		where p.dno= d.dno ; 

-- Oracle 에서의 단일행함수와 MySQL 컬럼함수의 다른 부분alter
select round(789.56, 2) ; -- from 절 없이도 실행 가능
select pname || '은' || job || '이다' from personal; -- 못씀 
select concat(pname, '은', job, '이다') from personal;

-- 날짜 관련 컬럼함수  (personal 테이블의 startdate의 타입 : datetime)
select year(startdate),month(startdate), day(startdate), 
	hour(startdate), minute(startdate), second(startdate) pname from personal;
    
	-- date_format(날짜형이나 시간형데이터, '포맷')
		-- 포맷글자 :  %y: 22(년도2자리), %Y : 2022(년도4자리), 
        -- (%M 월이름 , %b 짤은월이름,  %m 04월05월,  %c 4 (월수)
        -- %d 20,01,02,03.. (일2자리) %e 20,1,2,3
        -- (%H 24시간), (%h 12시간), (%p 오전오후) , %i분, %s초

-- 시스템으로부터 현재 날짜와 시간
select sysdate();
select now();

-- 시스템으로 현재 날짜 
select current_date();
select curdate();

-- 시스템으로부터 현재 시간 
select current_time();
select curtime();

-- 포맷글자 : %Y : 2022(년도4자리), 
        -- %m 04월05월, 
        --  %e 20,1,2,3
        -- (%h 12시간), (%p 오전오후) , %i분
select date_format(now(), '%Y년%m월%e일 %p %h시 %i분');

-- format(숫자데이터) ; 3자리 콤마 추가 
-- format(숫자데이터, 소수점자리수) ; 소수점 확보되면서 3자리 콤마 
select format(pay,1) from personal;

-- workbench에서 데이터 삭제하거나 수정 (where절에 primary key를 이용한 비교)
insert into personal (pno, pname, job, manager, startdate, pay, bonus, dno)
	values (1000, 'hong', 'manager',1001, curdate(), 9000, 900, 40);
    select * from personal;
    commit;
    set sql_safe_updates = 0;
    delete from personal where pname = 'hong';
    
    -- ★ ★ ★ TOP-N구문
    select rownum, pno from personal;
    select pname, pay from personal order by pay desc;
    
    -- limit n ( 1~ n등 까지)
    select pname, pay from personal order by pay desc limit 5; -- 1등 ~ 5등
	
    -- limit 3번째 부터,3 자리   ( 4등~ 6등)
    select pname, pay from personal order by pay desc limit 3,3; -- 4등부터 3개 출력 ( 4 5 6 )
    
    -- limit 5번재 	, 4 자리		(6등~9등까지)
    select pname, pay from personal order by pay desc limit 5,4; -- 6등 부터 4개 출력 ( 6 7 8 9 )
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

