package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By Signin = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By NavBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage getLogin()
	{
		driver.findElement(Signin).click();
		LoginPage Login = new LoginPage(driver);
		return Login;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement NavigationBar()
	{
		return driver.findElement(NavBar);
	}
	
	
}
