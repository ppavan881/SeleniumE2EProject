package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	//user_email
	//user_password
	public WebDriver driver;
	By userEmail = By.id("user_email");
	By SendMeButton = By.xpath("//input[@type='submit']");
	
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement UserEmail()
	{
		return driver.findElement(userEmail);
	}
	public WebElement SendMeButtonMethod()
	{
		return driver.findElement(SendMeButton);
	}
	

}
