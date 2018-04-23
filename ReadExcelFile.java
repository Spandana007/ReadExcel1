package demo;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
@SuppressWarnings("unused")
public class ReadExcelFile 
{


	
 public int readExcel() throws Exception, NumberFormatException 
 {
		//ReadExcelFile DT=new ReadExcelFile();
		
    	int balance=0;
		String FilePath = "C:/Users/688714/workspace/Balance/WebContent/CustData.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet("Sheet1");
		
		
		//int tamnt=0;
		String balstr=sh.getCell(1,7).getContents();
		balance=Integer.parseInt(balstr);
		
		System.out.println(balance);
		return balance;
 }
	
}	
	
	

