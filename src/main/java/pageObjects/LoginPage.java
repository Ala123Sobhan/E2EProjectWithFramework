package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.id("user_email");
	By pass = By.id("user_password");
	By login = By.cssSelector("input[value = 'Log In']");
	By forgotPass = By.cssSelector("a[href *= 'password/new']");
	
	
	public WebElement getForgotPassLink() {
		return driver.findElement(forgotPass);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPass() {
		return driver.findElement(pass);
	}
	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
