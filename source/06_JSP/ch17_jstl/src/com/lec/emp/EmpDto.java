package com.lec.emp;

import java.sql.Date;

public class EmpDto {
   private int empno;
   private String ename;
   private String job;
   private int mgr;
   private Date hiredate;
   private int sal;
   private int com;
   private int deptno;
public EmpDto() {}
public EmpDto(int empno, String ename, String job, int mgr, Date hiredate, int sal, int com, int deptno) {
	this.empno = empno;
	this.ename = ename;
	this.job = job;
	this.mgr = mgr;
	this.hiredate = hiredate;
	this.sal = sal;
	this.com = com;
	this.deptno = deptno;
}
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public int getMgr() {
	return mgr;
}
public void setMgr(int mgr) {
	this.mgr = mgr;
}
public Date getHiredate() {
	return hiredate;
}
public void setHiredate(Date hiredate) {
	this.hiredate = hiredate;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
public int getCom() {
	return com;
}
public void setCom(int comm) {
	this.com = comm;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
@Override
public String toString() {
	return "EmpDto [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
			+ ", sal=" + sal + ", comm=" + com + ", deptno=" + deptno + "]";
}
   
}
