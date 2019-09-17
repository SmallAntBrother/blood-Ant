package com.hwk.leetCode.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFTest {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("target/test.pdf"));
		document.open();
		Font font = FontFactory.getFont("SIMHEI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED );
		document.add(new Paragraph("<h1>sss手机卡包括设备</h1>", font));
		document.close();
		writer.close();
	}

}
