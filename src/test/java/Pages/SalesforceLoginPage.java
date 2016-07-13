package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import utility.BaseClass;
import utility.Helper;
import utility.MobileBaseClass;

public class SalesforceLoginPage extends BaseClass
{

	WebDriver driver;
	
	public SalesforceLoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	@FindBy(id="username") WebElement username;

	@FindBy(name="pw") WebElement password;
	
	@FindBy(id="Login") WebElement loginButton;
	
	public void loginToSalesforce()
	{
	
		Helper.highLightElement(driver, username).sendKeys(BaseClass.userName);
		
	    Helper.highLightElement(driver, password).sendKeys(BaseClass.passWord);
	  
	    BaseClass.logger.log(LogStatus.INFO, "Login Page");
	    BaseClass.logger.log(LogStatus.INFO,"Login Screen",BaseClass.logger.addScreenCapture(Helper.captureScreenshot(driver, "Login")));
	    Helper.highLightElement(driver, loginButton).click();
	   
	}
	
	public void loginToMobileSalesforce()
	{
	
		Helper.highLightElement(driver, username).sendKeys("mukeshotwani@learn-automation.com");
		
	    Helper.highLightElement(driver, password).sendKeys("titan@5000");
	    
	    MobileBaseClass.logger.log(LogStatus.INFO,"Login Screen",MobileBaseClass.logger.addScreenCapture(Helper.captureScreenshot(driver, "Login")));
	    
	    Helper.highLightElement(driver, loginButton).click();
	   
	}
	
}
