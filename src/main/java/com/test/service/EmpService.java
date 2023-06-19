package com.test.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.EmpDao;
import com.test.vo.Emp;

@Service
public class EmpService {
	
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	public List<Emp> getEmpList(){
		List<Emp> list = null;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			list = empDao.getEmpList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public Emp getEmp(int empno) {
		Emp emp = null;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			emp = empDao.getEmp(empno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}
	
	public int insertEmp(Emp emp) {
		int result = 0;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			result = empDao.insertEmp(emp);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return result;
	}
	
	public int updateEmp(Emp emp) {
		int result = 0;
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			result = empDao.updateEmp(emp);
		} catch (Exception e) {
			e.getMessage();
		}
		return result;
	}
	
	public int deleteEmp(int empno) {
		int result = 0;
		try {
			
			System.out.println("서비스 시작");
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			result = empDao.deleteEmp(empno);
			System.out.println("서비스 끝");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
}
