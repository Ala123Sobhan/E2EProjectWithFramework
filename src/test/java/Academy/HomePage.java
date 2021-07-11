package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	@BeforeTest
	public void initilizeDriver() throws IOException {
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider = "getData")
	public void verifyLogin(String uname, String pass, String status) throws IOException {
		
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getsignIn().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(uname);
		lp.getPass().sendKeys(pass);
		System.out.println(status);
		lp.getLogin().click();
	}

	
	@DataProvider
	public Object[][] getData() throws InterruptedException {
		
		//row - how many times test shd run with diff data types;
		//col - how many value each test got
		Object [][] data = new Object[2][3];
		data[0][0] = "nonres@qw.com";
		data[0][1] = "1233!";
		data[0][2] = "non restricted";
		data[1][0] = "res@qw.com";
		data[1][1] = "1234!";
		data[1][2] = "restricted";
		
		return data;
	}
	

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	
	
}
