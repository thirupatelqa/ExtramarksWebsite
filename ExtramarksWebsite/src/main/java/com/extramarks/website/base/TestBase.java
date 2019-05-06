package com.extramarks.website.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.extramarks.website.utilities.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			File file = new File(System.getProperty("user.dir")+"\\Input\\Config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void launchBrowser(){
		
		String browserName = prop.getProperty("browser");
		try{
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", "E:/selenium_project"
						+ "/Website/src/main/java/com/extramarks/website/utilities/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("IE")){
				System.setProperty("webdriver.ie.driver", "E:/selenium_project"
						+ "/Website/src/main/java/com/extramarks/website/utilities/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else{
				System.out.println("Issue while opening a browser");
			}		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}