package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class logoutpage {
	
	 WebDriver driver;

	public logoutpage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}

	@FindBy(xpath=("//a[@title='My Account']")) WebElement logoutmenu;
	@FindBy(xpath=("//ul[@id='wp-admin-bar-user-actions']/li[3]/a"))WebElement logoutSubmenu;
	@FindBy(xpath=("//p[@class='message']"))WebElement logoutmessage;
	
	public void logoutpf() throws Exception
	{
		Actions myaction = new Actions(driver);
	    myaction.moveToElement(logoutmenu).perform();
	    Thread.sleep(3000);
	   logoutSubmenu.click();
	   Thread.sleep(3000);
	}
	
	public String logoutmessageverfiy()
	{
		
	return	logoutmessage.getAttribute("innerHTML");

		
	}
}
