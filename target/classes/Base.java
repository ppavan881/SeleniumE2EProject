package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Base {
	
	public  WebDriver driver;
	public Properties prop;
	public  WebDriver initilizeDriver() throws IOException
	{
		
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String Browser_name = prop.getProperty("browser");
		
		//chrome
		if(Browser_name.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", ".\\src\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		
		//firefox
		else if(Browser_name.equals("FireFox"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\geckodriver.exe");
			driver = new ChromeDriver();
			
		}
		
		//IE
		else if(Browser_name.equals("IE"))
		{
			
		}
	
		
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 return driver;  // returing Driver life to method whoeevr is calling initilizeDriver()
		

	}
	public String takeScreenshot(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String detinationfile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(Source,new File(detinationfile));
		return detinationfile;
	}

}
