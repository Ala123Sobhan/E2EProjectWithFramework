package Academy;

import java.beans.PropertyChangeSupport;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class VerifyNavBar extends base {
	
	@BeforeTest
	public void initilizeDriver() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void verifyNavBarDisplay() throws IOException {
		
		
	
		
		LandingPage l = new LandingPage(driver);
		boolean isDisplay = l.getNavBar().isDisplayed();
		Assert.assertTrue(isDisplay);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
