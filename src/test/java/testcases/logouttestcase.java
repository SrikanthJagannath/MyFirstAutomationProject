package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.logoutpage;
import factory.Browserfactrory;
import factory.configfactory;

public class logouttestcase {
	
	WebDriver driver;
	Homepage page;
	logoutpage  page2;
	@BeforeMethod
	
public void setup()
{
		   driver = Browserfactrory.getbrowser("chrome");
		   driver.get(configfactory.getconfigr().geturl());
		   page = PageFactory.initElements(driver, Homepage.class);
		   page2 = PageFactory.initElements(driver, logoutpage.class);
}
	
	@Test
  public void logoutte() throws Exception
  {
		 page.loginapp();
		 page2.logoutpf();
	     String mymessage =  page2.logoutmessageverfiy();
	   	Assert.assertTrue(mymessage.contains("You are now logged out."));
  }
	@AfterMethod
	public void Teardown()
	{
		Browserfactrory.closebrowser(driver);
	}
}
