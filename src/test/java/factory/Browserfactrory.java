package factory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browserfactrory
{
	static WebDriver driver;
	
	public static WebDriver getbrowser(String browsername) 
	{
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			//ConfigDataProvider config= new ConfigDataProvider();
			System.setProperty("webdriver.gecko.driver",configfactory.getconfigr().getFirefoxpath() );
		//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//dataproviderfactory.getconfig().getFirefoxpath()
			driver = new FirefoxDriver();
			
		}
		else if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configfactory.getconfigr().getchromepath());
			driver = new ChromeDriver();
			
			
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", configfactory.getconfigr().getIEpath());
			driver = new InternetExplorerDriver();
			
			
		}
	//	driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
			
	}
	
public static void closebrowser(WebDriver driver)
{
	driver.quit();
}
}

