package com.dynamics.qa.testcases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.MultipleMeetingsPage;
import com.dynamics.qa.pages.WFEPage;
import com.dynamics.qa.util.TestUtil;

public class MultipleMeetingsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	WFEPage wfePage;
    TestUtil testUtil;
    HomePageTest homePageTest;
    SoftAssert softAssert = new SoftAssert();
    
    String sheetNameMeeting = "MultipleMeetingDynamics";
    String sheetNameWFEMeeting = "MultipleMeetingsWFE";
    
    HomePageTest HPT = new HomePageTest();
    WFEPageTest WFEPT = new WFEPageTest();
    
    public MultipleMeetingsPageTest() {
		super();
	}
	
	@Test(priority=1)	
	public void setUp() throws Exception {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		ioHomePage();
		homePageTest = new HomePageTest();
		HPT.redirectToMultipleMeetingsPage();
		Thread.sleep(6000);
		clickOn(driver, MultipleMeetingsPage.lnkScheduleMeeting, TestUtil.EXPLICIT_WAIT);
		driver.navigate().refresh();
	}
	
	@DataProvider
	public Object[][] getCreateMeetingTestData(){
		Object[][] data = TestUtil.getWFETestData(sheetNameMeeting);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getCreateMeetingTestData")	
	public void createMeeting(String subject, String location, String startDate, String endDate, String notes) throws Exception {
		
		TestUtil.switchToFirstFrame();
		System.out.println("inside 2nd frame");
		Thread.sleep(4000);
		
		clickOn(driver, MultipleMeetingsPage.tfSubject1, TestUtil.EXPLICIT_WAIT);
		MultipleMeetingsPage.tfSubject.clear();
		MultipleMeetingsPage.tfSubject.sendKeys(subject);
		
		clickOn(driver, MultipleMeetingsPage.tfLocation1, TestUtil.EXPLICIT_WAIT);
		MultipleMeetingsPage.tfLocation.clear();
		MultipleMeetingsPage.tfLocation.sendKeys(location);
		
		clickOn(driver, MultipleMeetingsPage.tfStartDate1, TestUtil.EXPLICIT_WAIT);
		MultipleMeetingsPage.tfStartDate.clear();
		MultipleMeetingsPage.tfStartDate.sendKeys(startDate);
		
		clickOn(driver, MultipleMeetingsPage.tfEndDate1, TestUtil.EXPLICIT_WAIT);
		MultipleMeetingsPage.tfEndDate.clear();
		MultipleMeetingsPage.tfEndDate.sendKeys(endDate);
		
		clickOn(driver, MultipleMeetingsPage.tfNotes1, TestUtil.EXPLICIT_WAIT);
		MultipleMeetingsPage.tfNotes.clear();
		MultipleMeetingsPage.tfNotes.sendKeys(notes);
		
		driver.switchTo().defaultContent();
		clickOn(driver, MultipleMeetingsPage.lnkSave, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, MultipleMeetingsPage.lnkSave, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(4000);
		driver.navigate().refresh();
	}
	
	@Test(priority=3)	
	public void tearDown(){
		driver.quit();
	}
		
	/*@Test(priority=1)	
	public void WfeLogin() throws Exception {
		WFEPT.setUp();
		wfePage = new WFEPage();
		Thread.sleep(7000);
		clickOn(driver, WFEPage.btnMenu, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, WFEPage.btnSync, TestUtil.EXPLICIT_WAIT);
		driver.quit();
	}*/
	
	@DataProvider
	public Object[][] getMultipleMeetingTestData(){
		Object[][] data = TestUtil.getWFETestData(sheetNameWFEMeeting); 
		return data;
	}
	
	@Test(priority=4)
	public void login() throws Exception {	
		WFEPT.setUp();
	}
	
	
	@Test(priority=5, dataProvider="getMultipleMeetingTestData")
	public void AssociateToMultpleMeetings(String scheduledMeeting, String subject, String location, String account, String participant, String presentation) throws Exception {	
		Thread.sleep(6000);
		WFEPT.VerifyScheduledMetting(scheduledMeeting, subject, location, account, participant, presentation);
		Thread.sleep(30000);
		WFEPT.VerifyAddingAccountToMeeting(scheduledMeeting, subject, location, account, participant, presentation);
		WFEPT.VerifyAddingParticipantToMeeting(scheduledMeeting, subject, location, account, participant, presentation);
		WFEPT.VerifyAddingPresentationToMeeting(scheduledMeeting, subject, location, account, participant, presentation);
		/*driver.quit();*/
	}

}
