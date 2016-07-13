package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utility.MobileBaseClass;
import Pages.SalesforceLoginPage;

public class StartChrome extends MobileBaseClass
{
	WebDriver driver;
    @Test
	public void test1()
	{
    	DesiredCapabilities cap=DesiredCapabilities.android();
    	
    	cap.setCapability("platformVersion","5.1.1");
    	
    	cap.setCapability("platformName","Android");
    	
    	cap.setCapability("deviceName","b7b8b8a8");
    	
    	cap.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
    	try 
    	{
			URL url= new URL("http://127.0.0.1:4727/wd/hub");
  
			driver = new AndroidDriver(url, cap);
			
			driver.get("https://login.salesforce.com/");
			
		} catch (Exception e) {
			
		}
    	 MobileBaseClass.logger=report.startTest("Test Salesforce on Mobile Chrome");
    	 
    	 SalesforceLoginPage login=PageFactory.initElements(driver, SalesforceLoginPage.class);
    	 
    	 login.loginToMobileSalesforce();
	}
	
	
}