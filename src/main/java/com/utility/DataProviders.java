package com.utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginFB")
	public Object[][] getData() throws Exception
	{
		 Object[][] data = ExcelReader.data("E:\\Framework\\src\\test\\resources\\testdata\\FBLogin.xlsx");
		 return data;
		
	}
	
	@DataProvider(name="SecondPage")
	public Object[][] getDataFromSecondPage() throws Exception
	{
		 Object[][] data = ExcelReader.data("E:\\Framework\\src\\test\\resources\\testdata\\FBLogin.xlsx");
		 return data;
		
	}

	
	}


