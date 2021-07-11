package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	By signin = By.cssSelector("a[href *= 'sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navbar = By.cssSelector("ul.nav.navbar-nav.navbar-right>li>a");
	By popUp = By.cssSelector("div.sumome-react-wysiwyg-component.sumome-react-wysiwyg-popup-background.sumome-react-wysiwyg-background");
	By popupCancel = By.xpath("//button[text() ='NO THANKS']");
	
	public WebElement getsignIn() {
		return driver.findElement(signin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavBar() {
		return driver.findElement(navbar);
	}
	public WebElement getPopUp() {
		return driver.findElement(popUp);
	}
	public WebElement getPopCancel() {
		return driver.findElement(popupCancel);
	}
	

}
