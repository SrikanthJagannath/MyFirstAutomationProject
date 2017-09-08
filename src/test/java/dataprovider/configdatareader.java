package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configdatareader {
	Properties pro;
	public  configdatareader()
	{
		File src =new File("C:\\seleniumworkspace\\hybridframework\\Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			 pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		
		}
	}
	
	public String geturl()
	{
		String myurl = pro.getProperty("url");
		//System.out.println(myurl);
		return myurl;
	}

	public String getchromepath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
		
	}
	public String getIEpath()
	{
		String IEpath = pro.getProperty("iepath");
		return IEpath;
		
	}
	public String getFirefoxpath()
	{
		String foxpath = pro.getProperty("firefoxpath");
		
		return foxpath;
	
}
	public String getusername()
	{
		String uname = pro.getProperty("username");
		return uname;
	}
	public String getpassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
}
