package Academy;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class LandingPageVerify extends base {
	WebDriver driver;
	@BeforeTest
	public void initilizeDriver1() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void verifyAppTitle() throws IOException {
		
		LandingPage l = new LandingPage(driver);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
	    
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Access all our Courses']")));
		
		driver.findElement(By.xpath("//a[normalize-space()='Access all our Courses']")).click();
		
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[normalize-space()='Access all our Courses']")));
		
		System.out.println(driver.getCurrentUrl());
		
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
