package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.SalesforceContactPage;
import Pages.SalesforceLoginPage;
import utility.BaseClass;

public class CRMTest extends BaseClass{

	
	@Test(priority=0)
	public void validLogin() throws InterruptedException
	{
		
	 SalesforceLoginPage login=PageFactory.initElements(driver, SalesforceLoginPage.class);
	 
	 login.loginToSalesforce();
	 
	 Thread.sleep(40000);
	}
	
	@Test(priority=1)
	public void createContact()
	{
		
		SalesforceContactPage contactPage=PageFactory.initElements(driver, SalesforceContactPage.class);
	 
		contactPage.createContacts();
	}
}
