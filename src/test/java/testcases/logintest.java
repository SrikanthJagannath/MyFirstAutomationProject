package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageobjects.Homepage;
import factory.Browserfactrory;
import factory.configfactory;


public class logintest {
	
	WebDriver driver;
	Homepage page;
	ExtentReports report;
	ExtentTest loggerr;
	ExtentHtmlReporter htmlReporter;
	@BeforeMethod
	
public void setup()

{
		
		htmlReporter=new ExtentHtmlReporter("extent.html");
		report=new ExtentReports();  
		report.attachReporter(htmlReporter);
		loggerr = report.createTest("Login Page Test", "ALL the logges will be saved here");
		driver = Browserfactrory.getbrowser("chrome");
		driver.get(configfactory.getconfigr().geturl());
		page = PageFactory.initElements(driver, Homepage.class);
}
	
	@Test
	public void loginapp() 
	{
		report.config();
		report.createTest("logintest");
		  String actual =	 driver.getTitle();
		 assertTrue(actual.contains("WordPress"));
		String landingpagetitle = page.logingpageheader();
		loggerr.info("Validation of login page is done");
	   	assertTrue(landingpagetitle.contains("Demo"));
	    page.loginapp();
	    loggerr.log(Status.INFO, Helper.captureScreenShot(driver, "validation2"));
	    loggerr.info("Loggin page validation");
	    String mytitle = page.finddashboard();
        assertTrue(mytitle.contains("Dashboard"));	
       loggerr.info("Logged in successfully");
       report.flush();
	}
	
	@AfterMethod
	public void Teardown(ITestResult result)
	{
		if (result.getStatus()== ITestResult.FAILURE)
		{
			String path = Helper.captureScreenShot(driver, result.getName());
			//loggerr.log(Status.FAIL,  loggerr.addScreenCaptureFromPath(path));
			try {
				loggerr.log(Status.FAIL, (Markup) loggerr.addScreenCaptureFromPath(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Failed to save screenshot"+ e.getMessage());
			}
		}
		Browserfactrory.closebrowser(driver);
		//loggerr.
	}

}
 