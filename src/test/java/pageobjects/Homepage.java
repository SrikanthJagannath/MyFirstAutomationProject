package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.configfactory;


public class Homepage {
	
	WebDriver driver;
	public Homepage(WebDriver ldriver)
	{
		
		this.driver =ldriver ;
	}
	
	@FindBy(xpath=("//input[@id='user_login']"))WebElement username;
	@FindBy(xpath=("//input[@id='user_pass']")) WebElement password;
	@FindBy(xpath=("//input[@id='wp-submit']"))WebElement Submit;
	@FindBy(xpath=("//a[@title='Powered by WordPress']"))WebElement header;
	@FindBy(xpath=("//a[text()='Dashboard']")) WebElement dashboard;
	
	public  void loginapp() 
	{
		username.sendKeys(configfactory.getconfigr().getusername());
		password.sendKeys(configfactory.getconfigr().getpassword());
		Submit.click();
	}
	
	public String logingpageheader()
	{
		return header.getText();
		 
	}
	public String finddashboard()
	{
		return driver.getTitle();
	}
	

}
