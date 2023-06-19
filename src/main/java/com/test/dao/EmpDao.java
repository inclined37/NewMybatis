package com.test.dao;

import java.util.List;

import com.test.vo.Emp;

public interface EmpDao {

	public List<Emp> getEmpList();
	
	public int insertEmp(Emp emp);
	
	public int updateEmp(Emp emp);
	
	public int deleteEmp(int empno);
}
