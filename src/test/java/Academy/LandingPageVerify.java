package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class LandingPageVerify extends base {
	
	@Test
	public void verifyPageTitle() throws IOException {
		driver = initializeDriver();
        driver.get("http://www.qaclickacademy.com/");
		
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		
	}

	@Test
	public void verifyNavBarDisplay() throws IOException {
		
		
		driver = initializeDriver();
        driver.get("http://www.qaclickacademy.com/");
		
		LandingPage l = new LandingPage(driver);
		boolean isDisplay = l.getNavBar().isDisplayed();
		Assert.assertEquals(isDisplay, true);
		
	}
}
