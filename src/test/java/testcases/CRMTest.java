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
	
	 BaseClass.logger=report.startTest("Valid login");	
		
	 SalesforceLoginPage login=PageFactory.initElements(driver, SalesforceLoginPage.class);
	 
	 login.loginToSalesforce();
	 
	}
	
	@Test(priority=1)
	public void createContact()
	{
		
		logger=report.startTest("Create Contact");	
		
		SalesforceContactPage contactPage=PageFactory.initElements(driver, SalesforceContactPage.class);
	 
		contactPage.createContacts();
	}
}
