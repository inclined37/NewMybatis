package com.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.EmpService;
import com.test.vo.Emp;

@RestController
public class ApiController {
	private EmpService empservice;
	
	@Autowired
	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}
	
    @PostMapping("api/delete")
    public String deleteEmp(@RequestParam("empNo") String empNo) {
    	System.out.println("삭제 진입");
    	
    	try {
    		System.out.println("try 시작");
			empservice.deleteEmp(Integer.parseInt(empNo));
			System.out.println("try 끝");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
        return "성공~";
    }
	
    @GetMapping("api/search")
    public Map<Integer, List> getEmpListByEname(String ename){
    	System.out.println("ename 으로 검색합니다"+ename);
    	List<Emp> list = null;
    	Map<Integer, List> map = new HashMap<Integer, List>();
    	try {
			list = empservice.getEmpListByEname(ename);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	map.put(1,list);
    	return map;
    }
}