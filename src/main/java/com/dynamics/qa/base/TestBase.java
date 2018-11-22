package com.dynamics.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.util.TestUtil;
import com.dynamics.qa.util.WebEventListener;

public class TestBase{
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"//Files//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//==========================/////////////////Initial Configuration for Dynamics //////////////////////===================================//	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\praveen.kumar\\Downloads\\INSTALLED_SOFTWARES\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\praveen.kumar\\Downloads\\INSTALLED_SOFTWARES\\geckodriver-v0.19.1-win64\\geckodriver.exe");	
			//driver = new FirefoxDriver(); 
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	}
	
//==========================/////////////////Initial Configuration for WFE //////////////////////===================================//		
	
	public static void initializationForWFE(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\praveen.kumar\\Downloads\\INSTALLED_SOFTWARES\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addExtensions(new File("C:\\Users\\praveen.kumar\\Downloads\\INSTALLED_SOFTWARES\\AddOns\\Pop-up-blocker-for-Chrome™-Poper-Blocker_v4.0.6.4.crx"));
			DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-bundled-ppapi-flash");
			
			
			driver = new ChromeDriver(options);  
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\praveen.kumar\\Downloads\\INSTALLED_SOFTWARES\\geckodriver-v0.19.1-win64\\geckodriver.exe");	
			//driver = new FirefoxDriver(); 
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url2"));
	
	}
	
//==========================///////////////// Reusable Method to Click on any Element with specified Time (Explicit Wait) //////////////////////==============================//		
	
	public static void clickOn(WebDriver driver, WebElement locator, long timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.and (ExpectedConditions.elementToBeClickable(locator), 
				ExpectedConditions.visibilityOf(locator)));
		locator.click();
	}

//===================///////////////// Reusable Method to get Title of the page with specified Time (Explicit Wait) //////////////////////==============================//	
	
	public static void getTitle(WebDriver driver,String title, long timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.titleIs(title));
		
	}
	
//==========================///////////////// Reusable Method to Click on Save link in any page with specified Time (Explicit Wait) //////////////////////=====================//	
	public void Save() {
		clickOn(driver, HomePage.lnkSave, TestUtil.EXPLICIT_WAIT);
	}
	
//==========================///////////////// Reusable Method to Click on SaveAndClose link in any page with specified Time (Explicit Wait) //////////////=====================//	
	
	public void SaveAndClose() {
		clickOn(driver, HomePage.lnkSaveAndClose, TestUtil.EXPLICIT_WAIT);
	}
	
//==========================///////////////// Reusable Method to Click on Delete link and Delete button on alert popup in any page with specified Time (Explicit Wait)////==================//	
	public void Delete() throws InterruptedException {
		clickOn(driver, HomePage.lnkDelete, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().frame("InlineDialog_Iframe");
		Thread.sleep(4000);
		HomePage.btnDelete.click();
	    driver.switchTo().defaultContent();
	}
	
	//==========================///////////////// Reusable Method to format Date////==================//	
	public String conversionDates(String inputPattern, String outputPattern, String givenDate) throws ParseException {
		SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
		SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
		
		Date date =null;
		
		String requiredDate = null;
		
		date = inputFormat.parse(givenDate);
		requiredDate = outputFormat.format(date);
		
		return requiredDate;
	}
	
//==========================///////////////// Reusable Method to redirect from Dynamices home Page to IO home Page in all the test scripts //////////////=====================//	
	
	public void ioHomePage() {
		clickOn(driver, HomePage.ddIndegene, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresence, TestUtil.EXPLICIT_WAIT);
		String title2 = "Microsoft Dynamics 365";
		getTitle(driver, title2, TestUtil.EXPLICIT_WAIT);
	}
	
}

 
