package com.lec.ch15.service;

import java.util.List;

import com.lec.ch15.model.Dept;
import com.lec.ch15.model.Emp;
//EmpServlce는 컨트롤러에서 호출당하는아이 

public interface EmpService {
	public List<Dept> deptList();
	// list.do?pageNum=? 이렇게 호출 될수도 있기 때문에 (String pageNum사용)
	public List<Emp> empList(String pageNum);
	public List<Emp> empDeptList(String pageNum);
	public int totCnt(); // resultType : int
	public Emp detail(int empno); // resultType : Emp , parameterType :int
	public List<Emp> managerList(); // 파라미터 타입 없음 
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public void dummDataInsert50();
	
	
}
