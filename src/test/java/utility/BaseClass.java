package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import factory.DataProviderFactory;

public class BaseClass 
{
	protected static WebDriver driver;
	
	@Parameters("browser")
    @BeforeTest
	public static WebDriver getBrowser(String browserName)
	{
		
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
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
}
