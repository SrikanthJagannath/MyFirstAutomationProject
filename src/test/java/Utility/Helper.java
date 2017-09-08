package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {

	
	public static String captureScreenShot(WebDriver driver, String ScreenShotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File filesource = ts.getScreenshotAs(OutputType.FILE);
		String Destination = "C:\\seleniumworkspace\\hybridframework\\ScreenShots\\"+ScreenShotName+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(filesource, new File(Destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to capture ScreenShot"+ e.getMessage());
		}
		return Destination;
}
}
