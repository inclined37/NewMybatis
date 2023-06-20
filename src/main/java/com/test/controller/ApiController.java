package com.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void getEmpListByEname(String ename, HttpServletResponse response) {
        System.out.println("ename으로 검색합니다: " + ename);
        List<Emp> list = new ArrayList<>();
        try {
            list = empservice.getEmpListByEname(ename);

            // JSON 형태로 응답 설정
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // List<Emp>를 JSON으로 변환하여 응답
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(response.getWriter(), list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    
    
}