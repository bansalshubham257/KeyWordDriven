/**
 *@author : Praveen.Kumar
 *@description : Home Page - Test cases (All HomePage related test cases has been written here) 
 *@class : HomePageTest
 */

/**
 * dd => drop down
 * lnk => link
 * btn => button
 * tf => text field
 */

package com.dynamics.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.ContactPage;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.KeyMessagePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.MeetingDetailsPage;
import com.dynamics.qa.pages.MultipleMeetingsPage;
import com.dynamics.qa.pages.PositionGroupPage;
import com.dynamics.qa.pages.PositionPage;
import com.dynamics.qa.pages.ProductPage;
import com.dynamics.qa.pages.RepCallPlanPage;
import com.dynamics.qa.pages.ScheduleMeetingPage;
import com.dynamics.qa.pages.SecurityRolesPage;
import com.dynamics.qa.pages.SegmentCallPlanPage;
import com.dynamics.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;


	public HomePageTest() {
		super();
	}
	
/* Test case ID: NA
 * Description:This method is to launch URL,Login with proper credentials 
 * author : Praveen.Kumar
 */

	@Test(priority=1)
	public void setUp() throws Exception {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
	}
	
/* Test case ID: NA
 * Description:This method is to verify Default CRM login Success.
 * author : Praveen.Kumar
 */	
	
	@Test(priority=2)
	public void homePageTitleTest(){
		String title = "Dashboards: Sales Activity Social Dashboard - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
	}
	
/* Test case ID: NA
 * Description:This method is to navigate to IO home page and verify that by title of IO home page.
 * author : Praveen.Kumar
 */	
	
	@Test(priority=3 , dependsOnMethods=("homePageTitleTest"))
	public void ioHomePage() {
		clickOn(driver, HomePage.ddIndegene, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresence, TestUtil.EXPLICIT_WAIT);
		String title2 = "Microsoft Dynamics 365";
		getTitle(driver, title2, TestUtil.EXPLICIT_WAIT);
	}
	
/* Test case ID: NA
 * Description:This method is to Navigate to Product's home page from IO home page.
 * author : Praveen.Kumar
 */
	
	@Test(priority=4)
	public ProductPage redirectToProductPage() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresenceAdmin, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkProduct, TestUtil.EXPLICIT_WAIT);
		return new ProductPage();
	}
	
/* Test case ID: NA
 * Description:This method is to Navigate to Position's home page from IO home page.
 * author : Praveen.Kumar
 */	
	
	@Test(priority=5)
	public PositionPage redirectToPositionPage() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresenceAdmin, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkPositions, TestUtil.EXPLICIT_WAIT);
		/*clickOn(driver, HomePage.lnkSettings, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkSecuritys, TestUtil.EXPLICIT_WAIT);*/
		return new PositionPage();
	}
	
/* Test case ID: NA
 * Description:This method is to Navigate to Position Group's home page from IO home page.
 * author : Praveen.Kumar
 */	
	
	@Test(priority=6)
	public PositionGroupPage redirectToPositionGroupPage() throws InterruptedException {
		Thread.sleep(4000);
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresenceAdmin, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkPositionGroups, TestUtil.EXPLICIT_WAIT);
		return new PositionGroupPage();
	}
	
/* Test case ID: NA
 * Description:This method is to Navigate to KeyMessagePage's home page from IO home page.
 * author : Praveen.Kumar
 */	
	
	@Test(priority=7)
	public KeyMessagePage redirectToKeyMessagePage() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresenceAdmin, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkKeyMessages, TestUtil.EXPLICIT_WAIT);
		return new KeyMessagePage();
	}
	
/* Test case ID: NA
 * Description:This method is to Navigate to ContactPage's home page from IO home page.
 * author : Praveen.Kumar
 */		
	
	@Test(priority=8)
	public ContactPage redirectToContactPage() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresenceSales, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkContacts, TestUtil.EXPLICIT_WAIT);
		return new ContactPage();
	}
	
/* Test case ID: NA
 * Description:This method is to Navigate to ContactPage's home page from IO home page.
 * author : Praveen.Kumar
 */		
	
	@Test(priority=9)
	public ScheduleMeetingPage redirectToScheduleMeetingPage() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkContacts, TestUtil.EXPLICIT_WAIT);
		return new ScheduleMeetingPage();
	}
	
/* Test case ID: NA
 * Description:This method is to Navigate to Meeting's home page from IO home page.
 * author : Praveen.Kumar
 */		
	
	@Test(priority=10)
	public MeetingDetailsPage redirectToMeetingDetailsPage() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkMeetings, TestUtil.EXPLICIT_WAIT);
		return new MeetingDetailsPage();
	}
	
/* Test case ID: NA
 * Description:This method is to Navigate to Meeting's home page from IO home page.
 * author : Praveen.Kumar
 */	
	@Test(priority=11)
	public MultipleMeetingsPage redirectToMultipleMeetingsPage() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkMeetings, TestUtil.EXPLICIT_WAIT);
		return new MultipleMeetingsPage();
	}
	
	@Test(priority=12)
	public SecurityRolesPage redirectToSecurityRolesPage() throws IOException, InterruptedException {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkSettings, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkSecuritys, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();
		Thread.sleep(6000);
		clickOn(driver, HomePage.lnkSecurityRoles, TestUtil.EXPLICIT_WAIT);
		return new SecurityRolesPage();
	}
	
	@Test(priority=13)
	public SegmentCallPlanPage redirectToSegmentCallPlan() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresenceAdmin, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkSegmentCallPlan, TestUtil.EXPLICIT_WAIT);
		return new SegmentCallPlanPage();
	}
	
	@Test(priority=14)
	public RepCallPlanPage redirectToRepCallPlan() {
		clickOn(driver, HomePage.ddOminiPresence, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkOminiPresenceSales, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, HomePage.lnkRepCallPlan, TestUtil.EXPLICIT_WAIT);
		return new RepCallPlanPage();
	}
}
