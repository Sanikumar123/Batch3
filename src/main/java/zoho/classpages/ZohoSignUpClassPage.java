package zoho.classpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utility.DriverFactory;



public class ZohoSignUpClassPage {
	
	
	//Object Repository
	@FindBy(xpath="//div[@class='zgh-utilities']/div[3]/a[1]")
	WebElement loginBtn;
	
	
	//Initialization
	public ZohoSignUpClassPage()
	{
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	
	
	//Reusable mathods
	public void verifySignUpPageTitle(String expectedTitle)
	{
		
		String actualTitle = DriverFactory.getDriver().getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

       
	}
	
	public ZohoSignInPageClass clickOnSignInBtn()
	{
		loginBtn.click();
		
		return new ZohoSignInPageClass();
	}

}
