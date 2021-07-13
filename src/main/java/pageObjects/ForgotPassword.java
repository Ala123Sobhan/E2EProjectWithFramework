package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
    
	WebDriver driver;
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By email = By.cssSelector("input[type = 'email']");
	private By sendMeBtn = By.cssSelector("input[type = 'submit']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getSendMebtn() {
		return driver.findElement(sendMeBtn);
	}
	
}
