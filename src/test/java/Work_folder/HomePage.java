
package Work_folder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void Initilize() throws IOException
	{
		driver=initilizeDriver();	
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		log.info("Driver Initilized for HomePage and URL is loaded");
		
		LandingPage land = new LandingPage(driver);
		LoginPage Login=land.getLogin(); // Intead of created Abject of each page obeject class. We can directly create that object into one of the methind in PageObject and use through out ouu test
        // This will help only to jump on next page or navigating
		log.info("I am at Login page and Providing Details");
		Login.UserEmail().sendKeys(username);
		Login.UserPass().sendKeys(password);
		Login.logButton().click();
		log.info("Provided Details for" +username+ "Clicked on Submit");
		
		ForgotPassword ForPass = Login.ForgotPasswordMethod();// Whenever I want to click I will pass the control/Driver to next page
		ForPass.UserEmail().sendKeys("Mipavan Pawar");
		ForPass.SendMeButtonMethod().click();
		
		log.info("i am on Forgot password Page");
		
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = new Object[2][2];
		//1st set of data
		data[0][0] = "pavan@gmail.com";
		data[0][1] = "123456";
		//2nd set of data
		data[1][0] = "pawar@gmail.com";
		data[1][1] = "123456";
		
		return data;
		
	}
	@AfterTest
	public void close()
	{
		log.info("Closing Driver instane, its for homePage");
		driver.close();
	}

}
