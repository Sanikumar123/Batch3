package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import com.utility.DriverFactory;

public class TestBase {
	
	public WebDriver driver;
	public Properties prop = new Properties();
	public FileInputStream fin;
	public static boolean gridStatus = true;
	
	
	@BeforeSuite
	public void setUp()
	{
		
		
		DriverFactory.setGridPath("http://192.168.0.4:5556/wd/hub");
				
		//Setting config file location
		DriverFactory.setConfigPropertyFilePath(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\confuguration.properties");
		

        //Load properties file
		try {
			fin = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Setting drivers location
		if(prop.getProperty("BROWSER").equals("chrome"))
		{
			DriverFactory.setChromeDriverExePath(System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
		}
		else if(prop.getProperty("BROWSER").equals("firefox"))
		{
			DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\geckodriver.exe");
		}
		
		
	}
	
	
	public void launchBrowser()
	{
		
		/*
		 * Launch respective browser based on requirement
		 * Intialize the WebDriver
		 * Set Implicit Wait
		 * Maximize Browser
		 * Launch the browser
		 */
		
		
		DriverFactory.setRemote(gridStatus);
		
		if(DriverFactory.isRemote())
		{
		DesiredCapabilities cap = null;
		
		if(prop.getProperty("BROWSER").equals("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
		}
		else if(prop.getProperty("BROWSER").equals("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
		}
		else if(prop.getProperty("BROWSER").equals("ie"))
		{
			cap=DesiredCapabilities.internetExplorer();
			cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		try {
			driver= new RemoteWebDriver(new URL(DriverFactory.getGridPath()),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else
		{
		
		if(prop.getProperty("BROWSER").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					DriverFactory.getChromeDriverExePath());
			
			driver = new ChromeDriver();
			
		}
		else if(prop.getProperty("BROWSER").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					DriverFactory.getGeckoDriverExePath());
			
			driver = new FirefoxDriver();
		}
		}
		
		DriverFactory.setDriver(driver);
		DriverFactory.getDriver().get(prop.getProperty("TESTURL"));
	    DriverFactory.getDriver().manage().window().maximize();
	    DriverFactory.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
        
}
	
	public void tearDown()
	{
		DriverFactory.getDriver().quit();
	}

}
