package com.test.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.test.vo.Emp;

@Service
public class ExcelService {
    
    public void generateExcel(Emp emp, HttpServletResponse response) throws IOException {
        // Excel 파일 생성
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employee Data");
        
        // Excel 데이터 작성
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("Employee No");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Department");
        // 추가 필드가 있다면 더 작성
        
        row = sheet.createRow(1);
        row.createCell(0).setCellValue(emp.getEmpno());
        row.createCell(1).setCellValue(emp.getEname());
        row.createCell(2).setCellValue(emp.getJob());
        // 추가 필드가 있다면 더 작성
        
        // Excel 파일 다운로드 설정
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=employee_data.xls");
        
        // Excel 파일 출력
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
