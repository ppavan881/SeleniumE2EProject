
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

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	public void validatetitle() throws IOException
	{
		
		driver=initilizeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage land = new LandingPage(driver);
		
		Assert.assertEquals("FEATURED COURSES",land.getTitle().getText());
		
	}
	@AfterTest
	public void close()
	{
		log.info("Closing Driver Instance, its for ValidateTitle");
		driver.close();
	}
}