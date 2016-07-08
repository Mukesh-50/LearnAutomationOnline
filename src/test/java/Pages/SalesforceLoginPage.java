package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.BaseClass;
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
	
		Helper.highLightElement(driver, username).sendKeys(BaseClass.userName);
		
	    Helper.highLightElement(driver, password).sendKeys(BaseClass.passWord);
	    
	    Helper.highLightElement(driver, loginButton).click();
	   
	}
	
}
