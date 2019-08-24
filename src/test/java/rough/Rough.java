package rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testbase.TestBase;
import com.utility.DataProviders;



public class Rough extends TestBase{
	
	
	

   @BeforeMethod
   public void initalization()
   {
	   
   }
   
   @Test(dataProviderClass=DataProviders.class,dataProvider="LoginFB")
   public void launch(String uname, String pass)
   {
	System.out.println(uname);
	System.out.println(pass);
}
   
   @AfterMethod
   public void quit()
   {
	   
	   
   }
}
