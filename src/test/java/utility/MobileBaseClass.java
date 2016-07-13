package utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class MobileBaseClass 
{
	protected static WebDriver driver;
	protected ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setupReport()
	{
		report=new ExtentReports(System.getProperty("user.dir")+"\\Mobile_Reports\\Salesforce"+Helper.getCurrentDateTime()+".html");
	}
	
	
	@AfterMethod
	public void tearDownReport()
	{
		report.endTest(MobileBaseClass.logger);
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
		
	}
	
	@AfterSuite
	public void generateReport()
	{
		report.flush();
	}
	
}
