package com.lec.ch15.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch15.model.Emp;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	@Override
	public List<Emp> empList(Emp emp) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("empList", emp);
	}

	@Override
	public List<Emp> empDeptList(Emp emp) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("empDeptList", emp);
	}

	@Override
	public int totCnt() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("totCnt");
	}

	@Override
	public Emp detail(int empno) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("detail", empno);
	}

	@Override
	public List<Emp> managerList() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("managerList");
	}

	@Override
	public int insert(Emp emp) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("insert",emp);
	}

	@Override
	public int update(Emp emp) {
		// TODO Auto-generated method stub
		return sessionTemplate.update("update", emp);
	}

	@Override
	public int delete(int empno) {
		// TODO Auto-generated method stub
		return sessionTemplate.delete("delete", empno);
	}

}
