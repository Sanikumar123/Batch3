package zoho.classpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverFactory;



public class ZohoSignInPageClass {
	
	@FindBy(xpath="//input[@id='lid']")
    WebElement username;
	
	@FindBy(xpath="//input[@id='pwd']")
    WebElement password;
	
	@FindBy(xpath="//div[@id='signin_submit']")
    WebElement signInBtn;
	
	public ZohoSignInPageClass()
	{
		PageFactory.initElements(DriverFactory.getDriver(),this);
	}
	
	
	public ZohoCRMHomepageClass loginIn(String uname, String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		signInBtn.click();
		
		return new ZohoCRMHomepageClass();
	}
	

}
