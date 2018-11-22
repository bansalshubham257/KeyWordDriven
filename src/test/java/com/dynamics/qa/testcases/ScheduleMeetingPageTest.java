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
import com.dynamics.qa.pages.ContactPage;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.ScheduleMeetingPage;
import com.dynamics.qa.util.TestUtil;

public class ScheduleMeetingPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
    HomePageTest homePageTest;
    ScheduleMeetingPage scheduleMeetingPage;
	ContactPage contactPage;
	
	HomePageTest HPT = new HomePageTest();
	
	String sheetName = "scheduleMeeting";
	
	SoftAssert softAssert = new SoftAssert();
	
	public ScheduleMeetingPageTest() {
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
		contactPage = new ContactPage();
		HPT.redirectToScheduleMeetingPage();
	} 
	
	@DataProvider
	public Object[][] getAddContactTestData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getAddContactTestData")	
	public void verifyContactSearchAndPresenceOfSchedulerOption(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws IOException, InterruptedException {
		Thread.sleep(5000);
		TestUtil.switchToFirstFrame();
		System.out.println("Inside Frame");
		Thread.sleep(5000);
		clickOn(driver, ContactPage.tfSearchContact, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfSearchContact.clear();
		ContactPage.tfSearchContact.sendKeys(firstName);
		clickOn(driver, ContactPage.imgSearchContact, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+firstName+"']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		clickOn(driver, ScheduleMeetingPage.ddScheduler, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(4000);
		clickOn(driver, ScheduleMeetingPage.lnkCallForAvailability, TestUtil.EXPLICIT_WAIT);
	}
	
	@Test(priority=3, dataProvider="getAddContactTestData")	
	public void VerifyCallFromAutofillData(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws Exception {
		TestUtil.switchToSecondFrame();
	    List<WebElement> list= driver.findElements(By.xpath("//div[starts-with(@class,'ms-crm-Inline-Value')]//label[contains(@id,'Call From_label')]//following-sibling::span//span[@title='"+user+"'][1]"));
	    System.out.println(list.size());
	    System.out.println("For CALL From");
	    softAssert.assertEquals(2, list.size());
	}
	
	@Test(priority=4, dataProvider="getAddContactTestData")	
	public void VerifyCallToAutofillData(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws Exception {
	
	    List<WebElement> list= driver.findElements(By.xpath("//div[starts-with(@class,'ms-crm-Inline-Value')]//label[contains(@id,'Call To_label')]//following-sibling::span[@title='"+firstName+"']"));
	    System.out.println(list.size());
	    System.out.println("For CALL To");
	    softAssert.assertEquals(2, list.size());

	}
	
	@Test(priority=5, dataProvider="getAddContactTestData")	
	public void VerifyPositionAutofillData(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws Exception {

	    List<WebElement> list= driver.findElements(By.xpath("//div[starts-with(@class,'ms-crm-Inline-Value')]//label[contains(@id,\"Position_label\")]//following-sibling::span//span[@title='"+position+"']"));
	    System.out.println(list.size());
	    System.out.println("For Position");
	    softAssert.assertEquals(2, list.size());
	    
	    softAssert.assertAll();

	}
	
	@Test(priority=6, dataProvider="getAddContactTestData")	
	public void VerifyScheduleMeeting(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws Exception {
//Subject :
		clickOn(driver, ScheduleMeetingPage.tfSubject1, TestUtil.EXPLICIT_WAIT);
		ScheduleMeetingPage.tfSubject.clear();
		ScheduleMeetingPage.tfSubject.sendKeys(callSubject);
//Phone Number :
		clickOn(driver, ScheduleMeetingPage.tfPhoneNumber1, TestUtil.EXPLICIT_WAIT);
		ScheduleMeetingPage.tfPhoneNumber.sendKeys(mobileNumber);
//GateKeeper :
		clickOn(driver, ScheduleMeetingPage.tfGateKeeper1, TestUtil.EXPLICIT_WAIT);
		ScheduleMeetingPage.tfGateKeeper.sendKeys(gateKeeper);
		
//Meeting Start Date :
	  	clickOn(driver, ScheduleMeetingPage.tfMeetingStartDate1, TestUtil.EXPLICIT_WAIT);
	  	ScheduleMeetingPage.tfMeetingStartDate.clear();;
	  	ScheduleMeetingPage.tfMeetingStartDate.sendKeys(startDate);	  
//Meeting End Date :
	  	clickOn(driver, ScheduleMeetingPage.tfMeetingEndDate1, TestUtil.EXPLICIT_WAIT);
	  	ScheduleMeetingPage.tfMeetingEndDate.clear();;
	  	ScheduleMeetingPage.tfMeetingEndDate.sendKeys(endDate);	 
	  	clickOn(driver, ScheduleMeetingPage.tfSubject1, TestUtil.EXPLICIT_WAIT);
//Description :
		clickOn(driver, ScheduleMeetingPage.tfDescription1, TestUtil.EXPLICIT_WAIT);
		ScheduleMeetingPage.tfDescription.clear();
		ScheduleMeetingPage.tfDescription.sendKeys(description);
	  	driver.switchTo().defaultContent();
	  	Save();
	  	Thread.sleep(4000);
	  	SaveAndClose();
	  	TestUtil.alertWindow();
	  	
	}
	
	@Test(priority=7, dataProvider="getAddContactTestData")	
	public void VerifyCreatedCall(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws Exception {
		TestUtil.switchToSecondFrame();
	    List<WebElement> list= driver.findElements(By.xpath("//div//div//a[@title='"+callSubject+"']"));
	    System.out.println(list.size());
	    System.out.println("For Position");
	    softAssert.assertEquals(1, list.size());
	}
	
	@Test(priority=8, dataProvider="getAddContactTestData")	
	public void VerifyCreatedMeeting(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws Exception {
	    List<WebElement> list= driver.findElements(By.xpath("//div//div//a[@title='"+meetingSubject+"']"));
	    System.out.println(list.size());
	    System.out.println("For Position");
	    softAssert.assertEquals(1, list.size());
	    
	}
	
	@Test(priority=9, dataProvider="getAddContactTestData")	
	public void VerifyDeletionOfCreatedCall(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws Exception {
		driver.findElement(By.xpath("//a//img[@title='"+cretaedCall+"']")).click();
		driver.switchTo().defaultContent();
		clickOn(driver, ScheduleMeetingPage.lnkDelete, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().frame("InlineDialog_Iframe");
		Thread.sleep(6000);
		clickOn(driver, ScheduleMeetingPage.btnDelete, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		
	}
	
	@Test(priority=10, dataProvider="getAddContactTestData")	
	public void VerifyDeletionOfCreatedMeeting(String firstName, String callSubject, String mobileNumber, String gateKeeper,String startDate, String endDate,
			String description, String user, String position, String meetingSubject, String cretaedCall, String createdMeeting) throws Exception {
		TestUtil.switchToSecondFrame();
		driver.findElement(By.xpath("//a//img[@title='"+createdMeeting+"']")).click();
		driver.switchTo().defaultContent();
		clickOn(driver, ScheduleMeetingPage.lnkDelete, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().frame("InlineDialog_Iframe");
		Thread.sleep(6000);
		clickOn(driver, ScheduleMeetingPage.btnDelete, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
