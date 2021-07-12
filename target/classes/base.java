package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
    public Properties prop;
    
	public WebDriver initializeDriver() throws IOException {

	    prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ala12\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//System.out.println(prop.getProperty("browser"));

		if (prop.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ala12\\eclipse-workspace\\E2EProject\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ala12\\eclipse-workspace\\E2EProject\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (prop.getProperty("browser").equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\ala12\\eclipse-workspace\\E2EProject\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;

	}
	
	public void getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+ "\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(src, new File(destFile));
	}

}
