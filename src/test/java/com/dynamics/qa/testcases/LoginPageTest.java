package com.dynamics.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.util.TestUtil;
import com.dynamics.qa.base.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();  
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title2 = "Sign in to your account";
		getTitle(driver, title2, TestUtil.EXPLICIT_WAIT);
		
	}
	
	@Test(priority=2)
	public void loginTest() throws Exception{
		homePage = loginPage.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}

