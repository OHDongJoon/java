package com.lec.ch15.dao;

import java.util.List;

import com.lec.ch15.model.Emp;

public interface EmpDao {
	
	public List<Emp> empList(Emp emp);
	public List<Emp> empDeptList(Emp emp);
	public int totCnt(); // resultType : int
	public Emp detail(int empno); // resultType : Emp , parameterType :int
	public List<Emp> managerList(); // 파라미터 타입 없음 
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	
}
