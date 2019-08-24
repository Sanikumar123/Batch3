package com.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] data(String excelPath) throws Exception
	{
		File file = new File(excelPath);
		FileInputStream fin = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(0);
		int cellcount = row.getLastCellNum();
		
		Object[][] data = new Object[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=1;j<=cellcount;j++)
			{
			 data[i-1][j-1]= sheet.getRow(i).getCell(j-1).getStringCellValue();
			 
			}
		}
		return data;
		
		
		
		
		}
	
	


}
