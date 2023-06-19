package com.test.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.service.EmpService;
import com.test.vo.Emp;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("common/*")
public class CommonController {
	
	private EmpService empservice;
	
	@Autowired
	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}

	@GetMapping("main")
	public String main(Model model) {
		
		System.out.println(empservice.getEmpList());
		
		model.addAttribute("empList", empservice.getEmpList());
		
		return "common/main";
	}
	
	@PostMapping("insert")
	public String insert(Emp emp) {
		System.out.println(emp.toString());
		try {
			empservice.insertEmp(emp);
		} catch (Exception e) {
			e.getMessage();
		}
		return "redirect:main";
	}

	@PostMapping("update")
	public String update(Emp emp) {
		System.out.println("update: "+emp.toString());
		try {
			empservice.updateEmp(emp);
		} catch (Exception e) {
			e.getMessage();
		}
		return "common/main";
	}
	
	@GetMapping("delete")
	public String delete(int empno) {
		System.out.println("delete: "+empno);
		try {
			empservice.deleteEmp(empno);
		} catch (Exception e) {
			e.getMessage();
		}
		return "common/main";
	}
}
