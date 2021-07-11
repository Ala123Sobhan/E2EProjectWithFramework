package Academy;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	@Test
	public void verifyPageNavigation() throws IOException {
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		
		LandingPage l = new LandingPage(driver);
		l.getsignIn().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("bob@ht.com");
		lp.getPass().sendKeys("1234!");
		lp.getLogin().click();
	}

}
