package com.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.EmpService;
import com.test.service.ExcelService;
import com.test.service.PdfService;
import com.test.vo.Emp;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("common/*")
public class CommonController {

	private EmpService empservice;
	private PdfService pdfservice;
	private ExcelService excelservice;

	@Autowired
	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}

	@Autowired
	public void setPdfservice(PdfService pdfservice) {
		this.pdfservice = pdfservice;
	}
	
	@Autowired
	public void setExcelservice(ExcelService excelservice) {
	    this.excelservice = excelservice;
	}

	@GetMapping("main")
	public String main(Model model) {

		System.out.println(empservice.getEmpList());

		model.addAttribute("empList", empservice.getEmpList());

		return "common/main";
	}

	@GetMapping("insert")
	public String insert() {
		System.out.println("insert 페이지 이동 컨트롤러 진입");
		// return "redirect:empInsert";
		return "common/empInsert";
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
		System.out.println("update: " + emp.toString());
		try {
			empservice.updateEmp(emp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:main";
	}

	/*
	 * @GetMapping("empDetail") public String empDetail(int empno) {
	 * 
	 * 
	 * return "detail?empno="+empno; }
	 */

	@GetMapping("empDetail")
	public String empDetail(@RequestParam("empno") String empno, Model model) {

		// empno를 가져옴. 가져온 empno를 통해서 emp객체를 가져옴. 가져온 emp객체를 return하는 페이지로 전달
		System.out.println("empDetail: " + empno);
		Emp emp = null;
		try {
			emp = empservice.getEmp(Integer.parseInt(empno));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// model.addAttribute(emp);
		model.addAttribute("employee", emp);
		return "common/empDetail";
	}

	// PDF 뷰어
	@RequestMapping("pdfview")
	@ResponseBody
	public void getEmpByPdf(@RequestParam("empno") String empno, HttpServletResponse response) {
		// 사원번호로 사원정보를 가져옴
		System.out.println("empDetail: " + empno);
		Emp emp = null;
		try {
			emp = empservice.getEmp(Integer.parseInt(empno));
			pdfservice.createPdf(emp, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(emp);
	}

	
	// Excel
	@RequestMapping(value = "empToExcel", method = RequestMethod.GET, produces = "application/vnd.ms-excel")
	public void empToExcel(@RequestParam("empno") String empno, HttpServletResponse response) {
	    try {
	        Emp emp = empservice.getEmp(Integer.parseInt(empno));
	        excelservice.generateExcel(emp, response);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}



	

}
