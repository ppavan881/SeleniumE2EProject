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

public class Newtest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	

	@BeforeTest
	public void NewTestMethodinitilizeDriver() throws IOException
	{
		driver=initilizeDriver();
	}
	
	@Test
	public void NewTestMethod() throws IOException
	{
		
		
		driver.get("https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html");
		log.info("This is My Newly Added Test for GIT COMMMANDS");
		
	}
	@AfterTest
	public void close() throws InterruptedException
	{
		Thread.sleep(5000);
		log.info("I will wait for 5 sec and Close");
		driver.close();
	}
}