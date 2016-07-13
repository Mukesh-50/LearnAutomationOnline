package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utility.Helper;
import utility.MobileBaseClass;

public class StartApplication extends MobileBaseClass
{
	WebDriver driver;
    @Test
	public void test1() throws InterruptedException
	{
    	DesiredCapabilities cap=DesiredCapabilities.android();
    	
    	cap.setCapability("platformVersion","5.1.1");
    	
    	cap.setCapability("platformName","Android");
    	
    	cap.setCapability("deviceName","b7b8b8a8");
    	
    	cap.setCapability("appPackage", "io.selendroid.testapp");
    	
    	cap.setCapability("appActivity", ".HomeScreenActivity");
    	
    	try 
    	{
			URL url= new URL("http://127.0.0.1:4727/wd/hub");
  
			driver = new AndroidDriver(url, cap);
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			
		}
    	MobileBaseClass.logger=report.startTest("Test Native Application");
    	
    	driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']")).sendKeys("Mukesh Selenium Appium");
    	
    	MobileBaseClass.logger.log(LogStatus.INFO,MobileBaseClass.logger.addScreenCapture(Helper.captureScreenshot(driver, "Login")));
    	
    	driver.findElement(By.name("startUserRegistrationCD")).click();
    	
    	driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("KAPLAN");
    	
    	driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("users@kaplan.com");
    	
    	driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("mypassword");
    	
    	((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage")).click();
    	
    	MobileBaseClass.logger.log(LogStatus.INFO,MobileBaseClass.logger.addScreenCapture(Helper.captureScreenshot(driver, "Selection of Language")));
    	
    	driver.findElement(By.name("Java")).click();
    	
    	driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
    	
    	MobileBaseClass.logger.log(LogStatus.INFO,MobileBaseClass.logger.addScreenCapture(Helper.captureScreenshot(driver, "Form filled")));
    	
    	driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
    	
    	MobileBaseClass.logger.log(LogStatus.INFO,MobileBaseClass.logger.addScreenCapture(Helper.captureScreenshot(driver, "last status")));
	}
	
	
}