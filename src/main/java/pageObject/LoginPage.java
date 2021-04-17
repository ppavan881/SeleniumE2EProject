package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//user_email
	//user_password
	public WebDriver driver;
	By userEmail = By.id("user_email");
	By userPass = By.id("user_password");
	By LogButton = By.xpath("//input[@type='submit']");
	By forgotPass = By.cssSelector("[href*='password/new/index.php']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement UserEmail()
	{
		return driver.findElement(userEmail);
	}
	public WebElement UserPass()
	{
		return driver.findElement(userPass);
	}
	public WebElement logButton()
	{
		return driver.findElement(LogButton);
	}
	public ForgotPassword ForgotPasswordMethod()
	{
		driver.findElement(forgotPass).click();
		ForgotPassword ForPass = new ForgotPassword(driver);
		return ForPass;
	}

}
