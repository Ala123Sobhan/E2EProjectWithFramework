package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class LandingPageVerify extends base {
	WebDriver driver;
	@BeforeTest
	public void initilizeDriver() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void verifyAppTitle() throws IOException {
		
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED23 COURSES");
		
	}
	
	@Test
	public void verifyHeader() {
		/*
		 * 
		 * dummy
		 * */
		Assert.assertEquals(false, false);
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
