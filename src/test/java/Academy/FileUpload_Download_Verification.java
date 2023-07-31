package Academy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload_Download_Verification {

	public static void main(String[] args) throws InterruptedException, IOException {

//		String downloadPath = System.getProperty("user.dir");
//
//		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//		chromePrefs.put("profile.default_content_settings.popups", 0);
//		chromePrefs.put("download.default_directory", downloadPath);
//
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", chromePrefs);
//
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver(options);
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		driver.get("https://altoconvertpdftojpg.com/");
//		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();
//
//		Thread.sleep(3000);
//		Runtime.getRuntime().exec("D:\\fileuploadscript.exe");
//
////		WebDriverWait wait = new WebDriverWait(driver, 30);
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
//		driver.findElement(By.cssSelector("button[class*='medium']")).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
//		driver.findElement(By.linkText("Download")).click();
//		Thread.sleep(5000);
//
//		File f = new File(downloadPath + "/Result.zip");
//		if (f.exists()) {
//			System.out.println("file exists..");
//			Assert.assertTrue(f.exists());
//			if(f.delete())
//			System.out.println("file deleted..");
//			 }
//		
//		driver.quit();
//		  
		}
	
       
	}

