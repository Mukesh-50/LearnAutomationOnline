package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Helper;

public class SalesforceContactPage 
{

	WebDriver driver;
	
	 public SalesforceContactPage(WebDriver ldriver) 
	 {
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[@title='Contacts Tab']") WebElement contactTab;
	
	@FindBy(name="new") WebElement newButton;
	
	@FindBy(xpath="//input[contains(@id,'name_last')]") WebElement lastName;
	
	@FindBy(name="save") WebElement saveButton;
	
	
	
	public void createContacts()
	{
		Helper.highLightElement(driver, contactTab).click();
		Helper.highLightElement(driver, newButton).click();
		Helper.highLightElement(driver, lastName).sendKeys("Selenium 1");
		Helper.highLightElement(driver, saveButton).click();
	}
	
	
	
}
