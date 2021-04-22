package Work_folder;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPage;

import resources.Base;

public class Google extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	

	@BeforeTest
	public void GoogleinitilizeDriver() throws IOException
	{
		driver=initilizeDriver();
	}
	
	@Test
	public void GoogleLaunch() throws IOException
	{
		
		
		driver.get("https://google.com");
		log.info("I created Develop Branch and this is new test cases added for Google");
		
	}
	@AfterTest
	public void close() throws InterruptedException
	{
		Thread.sleep(5000);
		log.info("I will wait for 5 sec and Close");
		driver.close();
	}
}