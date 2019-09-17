package com.hwk.leetCode.pdf;


import com.hwk.leetCode.pdf.entity.MarkdownEntity;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.junit.Test;
 
/**
 * Created by lujianing on 2017/5/7.
 */
public class JavaToPdfHtml {
 
    private static final String DEST = "target/HelloWorld_CN_HTML.pdf";
    private static final String FONT = "simsun.ttc,1";
 
 
    public static void main(String[] args) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        // step 3
        document.open();
        // step 4
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        fontImp.register(FONT);
        
//        BaseFont bfChinese = BaseFont.createFont( "STSongStd-Light" , "UniGB-UCS2-H" , false );
//        Font fontChinese = new Font(bfChinese , 12 , Font.NORMAL, BaseColor.GREEN);

          MarkdownEntity html = MarkDown2HtmlWrapper.ofContent("### **mhvjvj更换成观察观察萨克的那款手机dfd**");
          System.out.println(html.toString());
          InputStream   inputStream   =   new   ByteArrayInputStream(html.toString().getBytes("UTF-8"));

        //inputStream
        //new FileInputStream("src\\main\\resources\\template.html")
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
        		inputStream , null, Charset.forName("UTF-8"), fontImp);

        
        // step 5
        document.close();
    }
    
    
    
    @Test
    public void test1() throws IOException, DocumentException {
    	// step 1

        Document document = new Document();

        // step 2

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));

        // step 3

        document.open();

        MarkdownEntity html = MarkDown2HtmlWrapper.ofContent("### **萨克的那款手机dfd**");
//        System.out.println(html.toString());
        InputStream   inputStream   =   new   ByteArrayInputStream(html.toString().getBytes());

        
        // step 4

        XMLWorkerHelper.getInstance().parseXHtml(writer, document,

        		inputStream);

        // step 5

        document.close();
    }
    
    @Test
    public void markdown2html() {
    	String file = "md/tutorial.md";
        MarkdownEntity html = MarkDown2HtmlWrapper.ofContent("### **萨克的那款手机dfd**");
        System.out.println(html.toString());
    }
}