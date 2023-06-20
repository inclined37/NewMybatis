package com.test.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.test.vo.Emp;

@Service
public class ExcelService {
    
    public void generateExcel(Emp emp, HttpServletResponse response) throws IOException {
        // Excel 파일 생성
    	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Employee Data");
        
        // Excel 데이터 작성
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("사원번호");
        row.createCell(1).setCellValue("사원명");
        row.createCell(2).setCellValue("직책");
        row.createCell(3).setCellValue("선임번호");
        row.createCell(4).setCellValue("입사일");
        row.createCell(5).setCellValue("급여");
        row.createCell(6).setCellValue("성과금");
        row.createCell(7).setCellValue("부서번호");
        // 추가 필드가 있다면 더 작성
        
        row = sheet.createRow(1);
        row.createCell(0).setCellValue(emp.getEmpno());
        row.createCell(1).setCellValue(emp.getEname());
        row.createCell(2).setCellValue(emp.getJob());
        row.createCell(3).setCellValue(emp.getMgr());
        row.createCell(4).setCellValue(emp.getHiredate());
        row.createCell(5).setCellValue(emp.getSal());
        row.createCell(6).setCellValue(emp.getComm());
        row.createCell(7).setCellValue(emp.getDeptno());
        // 추가 필드가 있다면 더 작성
        
        // Excel 파일 다운로드 설정
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=employee_data.xls");
        
        // Excel 파일 출력
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
