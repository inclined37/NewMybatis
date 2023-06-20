package com.test.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.test.vo.Emp;

@Service
public class PdfService {
	
	public void createPdf(Emp emp, HttpServletResponse response) throws IOException {
		Document document = new Document();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			PdfWriter.getInstance(document, baos);
			document.open();
			

			/*
			float[] columnWidths = {50f, 30f, 20f}; // 각 열의 상대적인 너비
			table.setWidths(columnWidths);
			*/
			
			
			Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
			Paragraph title = new Paragraph("Employee Information", titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			
			
			//테이블 생성
			PdfPTable table = new PdfPTable(2); //열 2개
			table.setWidthPercentage(100);
			table.setSpacingBefore(15f);
			table.setSpacingAfter(15f);
			
			
			Font font = new Font(Font.HELVETICA, 12);
			Paragraph header1 = new Paragraph("EMPLOYEE NUMBER", font);
			Paragraph content1 = new Paragraph(String.valueOf(emp.getEmpno()), font);
			
			Paragraph header2 = new Paragraph("EMPLOYEE NAME", font);
			Paragraph content2 = new Paragraph(emp.getEname(), font);
			
			Paragraph header3 = new Paragraph("JOB", font);
			Paragraph content3 = new Paragraph(emp.getJob(), font);
			
			Paragraph header4 = new Paragraph("MANAGER NUMBER", font);
			Paragraph content4 = new Paragraph(String.valueOf(emp.getMgr()), font);
			
			Paragraph header5 = new Paragraph("HIREDATE", font);
			Paragraph content5 = new Paragraph(emp.getHiredate(), font);
			
			Paragraph header6 = new Paragraph("SALARY", font);
			Paragraph content6 = new Paragraph(String.valueOf(emp.getSal()), font);
			
			Paragraph header7 = new Paragraph("COMMISSION", font);
			Paragraph content7 = new Paragraph(String.valueOf(emp.getComm()), font);
			
			Paragraph header8 = new Paragraph("DEPARTMENT NUMBER", font);
			Paragraph content8 = new Paragraph(String.valueOf(emp.getDeptno()), font);


			
			//테이블 데이터 추가
			table.addCell(header1);
			table.addCell(content1);
			
			table.addCell(header2);
			table.addCell(content2);
			
			table.addCell(header3);
			table.addCell(content3);
			
			table.addCell(header4);
			table.addCell(content4);
			
			table.addCell(header5);
			table.addCell(content5);
			
			table.addCell(header6);
			table.addCell(content6);
			
			table.addCell(header7);
			table.addCell(content7);
			
			table.addCell(header8);
			table.addCell(content8);
			
			

			document.add(table);
			document.close();
			
			// HTTP 응답 헤더 설정
			response.setHeader("Content-Disposition", "inline; filename=output.pdf");
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			
			// PDF 파일 전송
			baos.writeTo(response.getOutputStream());
			response.getOutputStream().flush();
			
			System.out.println("PDF 생성 완료");
			
		} catch (Exception e) {
			System.out.println("PDF 생성 오류 발생 *************************");
			System.out.println(e.getMessage());
		} finally {
			baos.close();
		}
		
	}
}
