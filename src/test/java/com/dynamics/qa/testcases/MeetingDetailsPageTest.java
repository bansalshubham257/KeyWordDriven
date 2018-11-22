package com.dynamics.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.MeetingDetailsPage;
import com.dynamics.qa.util.TestUtil;

public class MeetingDetailsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
	HomePageTest homePageTest;
	MeetingDetailsPage meetingDetailsPage;
	
	SoftAssert softAssert = new SoftAssert();
	
	HomePageTest HPT = new HomePageTest();
	
	String sheetName = "MeetingWfe";
	
	
	/* Test case ID: NA
	 * Test Case: NA
	 * Description:This method is constructor of ProductPageTest
	 * author : Praveen.Kumar
	 */
	public MeetingDetailsPageTest() {
		super();
	}

	
	/* Test case ID: NA
	 * Test Case: verifyLogin
	 * Description:This method runs initialize methods of base class and verifies login to dynamics application
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=1)
	public void verifyLogin() throws Exception {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		ioHomePage();
	} 
	
	@Test(priority=2)	
	public void verifyPresenceOfMeetingEntityAndNavigationToMeetingHomePage() {	
		HPT.redirectToMeetingDetailsPage();
	}
	
	@DataProvider
	public Object[][] getCreatedWFEMeetingTestData(){
		Object[][] data = TestUtil.getWFETestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCreatedWFEMeetingTestData")
	public void VerifyMeetingsHomePageAndSearch(String scheduledMeeting, String subject, String location, String account, String participant, String presentation) throws IOException, InterruptedException {	
		String title = "Appointments My Meetings - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(4000);
		TestUtil.switchToFirstFrame();
		System.out.println("Inside Frame");
		Thread.sleep(3000);
		clickOn(driver, MeetingDetailsPage.tfSearchMeeting, TestUtil.EXPLICIT_WAIT);
		MeetingDetailsPage.tfSearchMeeting.clear();
		MeetingDetailsPage.tfSearchMeeting.sendKeys(subject);
		clickOn(driver, MeetingDetailsPage.imgSearchMeeting, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, MeetingDetailsPage.lnkCreatedMeeting, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
	}	
	
	@Test(priority=4)
	public void VerifyMeetingLocation() throws IOException, InterruptedException {
		TestUtil.switchToSecondFrame();
		Thread.sleep(4000);
		List<WebElement> list= driver.findElements(By.xpath("//div[@id='location1']//div//label//div[contains(text(),'Bengaluru')]"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=5)
	public void VerifyAddedPositionToMeeting() throws IOException, InterruptedException {
		List<WebElement> list= driver.findElements(By.xpath("//div[@id='indskr_positionid1']//div[contains(@class,'ms-crm-Inline-Value')]//span//span[contains(@title,'AutomationPosition')]"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=6)
	public void VerifyAddedPresentationToMeeting() throws IOException, InterruptedException {
		List<WebElement> list= driver.findElements(By.xpath("//span//span[contains(text(),'analyses post - hoc.pdf')]"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=7)
	public void VerifyAddedAccountToMeeting() throws IOException, InterruptedException {
		
		List<WebElement> list= driver.findElements(By.xpath("//a[contains(@title,'Automation Account 1')]"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		softAssert.assertAll();
		
	}
	
	@Test(priority=8)
	public void VerifyAddedHCPToMeeting() throws IOException, InterruptedException {
		
		List<WebElement> list= driver.findElements(By.xpath("//a[contains(@title,'HCP Automation 1') and contains(text(),'HCP')]"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		softAssert.assertAll();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
