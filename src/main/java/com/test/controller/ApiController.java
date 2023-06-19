package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.EmpService;

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
	
}