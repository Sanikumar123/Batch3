package com.zohosignintestpage.suitepack;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testbase.TestBase;

import zoho.classpages.ZohoCRMHomepageClass;
import zoho.classpages.ZohoSignInPageClass;
import zoho.classpages.ZohoSignUpClassPage;

public class ZohoSignInTestPage extends TestBase{
	
	ZohoSignUpClassPage zohosignuppage;
	ZohoSignInPageClass zohosignInPage;
	ZohoCRMHomepageClass zohoCrmHomePage;
	
	@BeforeMethod
	public void initalization()
	   {
		   launchBrowser();
		   zohosignuppage = new ZohoSignUpClassPage();
		   zohosignInPage =  zohosignuppage.clickOnSignInBtn();
		   
		  
	   }
	
	@Test
	public void validateZohoSignIn()
	{
		zohoCrmHomePage = zohosignInPage.loginIn(prop.getProperty("USERNAME"),prop.getProperty("PASSWORD") );
	}
	
	@AfterMethod
	   public void quit()
	   {
		   tearDown();
	   }

}
