package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import factory.DataProviderFactory;

public class BaseClass 
{
	protected static WebDriver driver;
	public static String Url;
	public static String userName;
	public static String passWord;
	
	protected ExtentReports report;
	protected static ExtentTest logger;
	
	@BeforeSuite
	public void setupReport()
	{
		String reportpath=System.getProperty("user.dir")+"\\Reports\\Salesforce"+Helper.getCurrentDateTime()+".html";
		report=new ExtentReports(reportpath);
		System.out.println("================After execution report can be checked at "+reportpath);
	}
	
	
	@Parameters({"browser","url","username","password"})
    @BeforeTest
	public static WebDriver getBrowser(String browserName,String url,String username,String password)
	{
		Url=url;
		userName=username;
		passWord=password;
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromePath());
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",DataProviderFactory.getConfig().getIEPath());
			
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(BaseClass.Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	@AfterMethod
	public void tearDownReport()
	{
		report.endTest(BaseClass.logger);
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
	@AfterSuite
	public void generateReport()
	{
		report.flush();
	}
	
}
