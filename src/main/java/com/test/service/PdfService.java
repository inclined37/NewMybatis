package com.test.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
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
			
			//테이블 생성
			PdfPTable table = new PdfPTable(8); //열 8개
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);
			
			//테이블 헤더
			Font headerFont = new Font(Font.BOLD, 14);
			Paragraph header1 = new Paragraph("사원번호", headerFont);
			Paragraph header2 = new Paragraph("사원이름", headerFont);
			Paragraph header3 = new Paragraph("직급", headerFont);
			Paragraph header4 = new Paragraph("직속상사", headerFont);
			Paragraph header5 = new Paragraph("입사일", headerFont);
			Paragraph header6 = new Paragraph("월급", headerFont);
			Paragraph header7 = new Paragraph("성과금", headerFont);
			Paragraph header8 = new Paragraph("부서번호", headerFont);
			
			table.addCell(header1);
			table.addCell(header2);
			table.addCell(header3);
			table.addCell(header4);
			table.addCell(header5);
			table.addCell(header6);
			table.addCell(header7);
			table.addCell(header8);
			
			
			//테이블 데이터 추가
			Font contentFont = new Font(Font.HELVETICA, 14);
			Paragraph content1 = new Paragraph(String.valueOf(emp.getEmpno()), contentFont);
			Paragraph content2 = new Paragraph(emp.getEname(), contentFont);
			Paragraph content3 = new Paragraph(emp.getJob(), contentFont);
			Paragraph content4 = new Paragraph(String.valueOf(emp.getMgr()), contentFont);
			Paragraph content5 = new Paragraph(emp.getHiredate(), contentFont);
			Paragraph content6 = new Paragraph(String.valueOf(emp.getSal()), contentFont);
			Paragraph content7 = new Paragraph(String.valueOf(emp.getComm()), contentFont);
			Paragraph content8 = new Paragraph(String.valueOf(emp.getDeptno()), contentFont);
			
			table.addCell(content1);
			table.addCell(content2);
			table.addCell(content3);
			table.addCell(content4);
			table.addCell(content5);
			table.addCell(content6);
			table.addCell(content7);
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
