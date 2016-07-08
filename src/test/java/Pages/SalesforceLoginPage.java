package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Helper;

public class SalesforceLoginPage 
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
	
		Helper.highLightElement(driver, username).sendKeys("mukeshotwani@learn-automation.com");
		
	    Helper.highLightElement(driver, password).sendKeys("titan@5000");
	    
	    Helper.highLightElement(driver, loginButton).click();
	   
	}
	
}
