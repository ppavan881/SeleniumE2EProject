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

public class validateNavBar extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	

	@BeforeTest
	public void initilizeDriverInValidateNavBar() throws IOException
	{
		driver=initilizeDriver();
	}
	
	@Test
	public void validateVavigationBar() throws IOException
	{
		
		
		driver.get(prop.getProperty("url"));
		LandingPage land = new LandingPage(driver);
		
		Assert.assertTrue(land.NavigationBar().isDisplayed());
		log.info("test Is paased for Navigation Bar.. Navgaion Bar is in protal");
		
	}
	@AfterTest
	public void close()
	{
		log.info("Closing Driver Instance, its for NavBar");
		driver.close();
	}
}