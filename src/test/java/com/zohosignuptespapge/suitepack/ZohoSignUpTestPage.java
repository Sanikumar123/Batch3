package com.zohosignuptespapge.suitepack;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testbase.TestBase;
import com.utility.Constants;

import zoho.classpages.ZohoSignInPageClass;
import zoho.classpages.ZohoSignUpClassPage;

public class ZohoSignUpTestPage extends TestBase {
	
	ZohoSignUpClassPage zohosignuppage;
	ZohoSignInPageClass zohosignInPage;
	
	 @BeforeMethod
	   public void initalization()
	   {
		   launchBrowser();
		   zohosignuppage = new ZohoSignUpClassPage();
	   }
	 
	 @Test(enabled=true)
	 public void validateZohoSignUpPageTitle()
	 {
		 zohosignuppage.verifySignUpPageTitle(Constants.ZohoSignUpPageTitle);
	 }
	 
	 
	 @Test(enabled=false)
	 public void clickOnSignInBtn()
	 {
		 zohosignInPage =  zohosignuppage.clickOnSignInBtn();
	 }
	 
	 
	 @AfterMethod
	   public void quit()
	   {
		   tearDown();
	   }

}
