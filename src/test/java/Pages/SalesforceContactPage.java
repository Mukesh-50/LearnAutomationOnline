package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utility.BaseClass;
import utility.Helper;

public class SalesforceContactPage extends BaseClass
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
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(contactTab));
		Helper.highLightElement(driver, contactTab).click();
		Helper.highLightElement(driver, newButton).click();
		Helper.highLightElement(driver, lastName).sendKeys("Selenium 1");
		Helper.highLightElement(driver, saveButton).click();
		logger.log(LogStatus.INFO, "Contact created");
	    logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver, "Contact created")));
	}
	
	
	
}
