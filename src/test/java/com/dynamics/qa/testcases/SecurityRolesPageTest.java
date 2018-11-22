package com.dynamics.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.SecurityRolesPage;
import com.dynamics.qa.util.TestUtil;

public class SecurityRolesPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
	HomePageTest homePageTest;
	SecurityRolesPage securityRolesPage;
	
	SoftAssert softAssert = new SoftAssert();
	
	String sheetNameProduct = "addProduct";
	
	HomePageTest HPT = new HomePageTest();
	
	public SecurityRolesPageTest() {
			super();
	}
		
	@Test(priority=1)	
	public void setUp() throws Exception {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		ioHomePage();
	}
	
	@Test(priority=2)	
	public void verifyPresenceOfSecurityEntityAndNavigationToSecurityHomePage() throws IOException, InterruptedException {	
		HPT.redirectToSecurityRolesPage();
	}
	
	/*@Test(priority=3)	
	public void verifyPresenceOfSecurityRoleEntityAndNavigationToSecurityRoleHomePage() throws IOException {	
		HPT.redirectToSecurityRolesPage();
	}*/
	
}
