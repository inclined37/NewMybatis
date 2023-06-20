package com.test.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

public class PDFView extends AbstractView {

	 @Override
	  protected void renderMergedOutputModel(
	      Map<String, Object> model,
	      HttpServletRequest request,
	      HttpServletResponse response) throws Exception {

	    // PDF 생성 로직을 구현합니다.
	    Document document = new Document();
	    PdfWriter.getInstance(document, response.getOutputStream());

	    // PDF 문서 구성을 위한 데이터 및 스타일 처리 등을 수행합니다.

	    // 문서를 닫고 응답으로 전송합니다.
	    document.close();
	  }
}
