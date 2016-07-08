package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Helper;

public class HomePage 
{

	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		
		this.driver=ldriver;
	}
	
	
	@FindBy(xpath="//a[text()='Sign In']") WebElement signInlink;
	
	@FindBy(xpath="//a[text()='My Account']") WebElement myAccountLink;
	
	@FindBy(xpath="//a[text()='My cart']") WebElement myCartLink;
	
	@FindBy(xpath="//a[text()='Checkout']") WebElement checkOutink;
	
	
	public void clickOnSigninLink()
	{
		Helper.highLightElement(driver, signInlink);
		signInlink.click();
	}
	
	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}
	
	public void clickOnMyCartLink()
	{
		myCartLink.click();
	}
	
	public void clickOnCheckoutlink()
	{
		checkOutink.click();
	}
	
	public String getApplicationTitle()
	{
		 return driver.getTitle();
	}

	
}
