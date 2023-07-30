package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis);
		// System.out.println(prop.getProperty("browser"));

		// String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");

//		if (browserName.contains("chrome")) {
//
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
//			ChromeOptions option = new ChromeOptions();
//			if (browserName.contains("headless")) {
//				option.addArguments("--headless");
//			}
//			driver = new ChromeDriver(option);
//		} else if (browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		} else if (browserName.equals("IE")) {
//			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
//		}
		if(browserName.contains("chromeheadless"))
		{
			
			WebDriverManager.chromedriver().setup();

			System.setProperty("webdriver.chrome.silentOutput", "true");
		    ChromeOptions options = new ChromeOptions();
		    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			
		 
			
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				options.addArguments("--allow-insecure-localhost");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--window-size=1400,800");
			
				driver = new ChromeDriver(options);
			}

			
		
//		else if (browserName.contains("chrome")) {
//			//WebDriverManager.chromedriver().setup();
//			WebDriverManager.chromedriver().driverVersion("115.0.5790.110").setup();
//
//			System.setProperty("webdriver.chrome.silentOutput", "true");
//		   ChromeOptions options = new ChromeOptions();
//		   options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//			// options.addArguments("--incognito");
//			// driver = new ChromeDriver(options);
//		 
//			if (browserName.contains("headless")) {
//				//ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless");
//				options.addArguments("--disable-gpu");
//				options.addArguments("--no-sandbox");
//				options.addArguments("--allow-insecure-localhost");
//				options.addArguments("--disable-extensions");
//				options.addArguments("--disable-dev-shm-usage");
//				options.addArguments("--window-size=1400,800");
//			
//				driver = new ChromeDriver(options);
//			} else {
//				driver = new ChromeDriver(options);
//			}

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}
	
	

	public String [] getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		String [] paths = new String[2];
		String dT = getCurrentTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String fxt = testcaseName +"_"+dT+".png";
		String destFile = System.getProperty("user.dir") + "\\reports\\" +testcaseName+".png" ;
		FileUtils.copyFile(src, new File(destFile));
	
		paths[0]= destFile;
		String jenkinsPath = "http://localhost:8080/job/E2E_Maven/ws/reports/"+testcaseName+".png";
		//return destFile;
		System.out.println(jenkinsPath);
		paths[1] = jenkinsPath;
		return paths;
	}
	
	public String getCurrentTime() {
		
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now);  
		
	}

}
