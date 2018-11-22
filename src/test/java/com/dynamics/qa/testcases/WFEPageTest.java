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
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.WFEPage;
import com.dynamics.qa.util.TestUtil;

public class WFEPageTest extends TestBase {
	TestUtil testUtil;
	LoginPage loginPage;
	WFEPage  wfePage;
	SoftAssert softAssert = new SoftAssert();
	
	String sheetName = "MeetingWfe";
	
	public WFEPageTest() {
		super();
	}
	
	@Test(priority=1)
	public void setUp() throws Exception {
		
		initializationForWFE();
		testUtil = new TestUtil();
		TestUtil.alertWindow();
		loginPage = new LoginPage();
		wfePage = LoginPage.loginWFE(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		clickOn(driver, WFEPage.radioBtnIndegeneQA, TestUtil.EXPLICIT_WAIT);// For QA environment
		/*clickOn(driver, WFEPage.radioBtnPERF1, TestUtil.EXPLICIT_WAIT);// For Performance environment
*/		clickOn(driver, WFEPage.btnContinue, TestUtil.EXPLICIT_WAIT);
	}
	

	@DataProvider
	public Object[][] getCreateWFEMeetingTestData(){
		Object[][] data = TestUtil.getWFETestData(sheetName);
		return data;
	}
	
	@Test(priority=2)
	public void VerifyMeetingSchedule() throws IOException, InterruptedException {
		Thread.sleep(8000);
		clickOn(driver, WFEPage.btnAddMeeting, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(5000);
		clickOn(driver, WFEPage.lnkConfirm, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(20000);
	}
	
	@Test(priority=3, dataProvider="getCreateWFEMeetingTestData")
	public void VerifyScheduledMetting(String scheduledMeeting, String subject, String location, String account, String participant, String presentation) throws IOException, InterruptedException {	
		/*clickOn(driver, WFEPage.lnkNewMeeting, TestUtil.EXPLICIT_WAIT);*/
		driver.findElement(By.xpath("//div[h2[text()='"+scheduledMeeting+"']]")).click();
	}
		
	@Test(priority=4, dataProvider="getCreateWFEMeetingTestData")
	public void VerifyMeetingSubjectChange(String scheduledMeeting, String subject, String location, String account, String participant, String presentation) throws IOException, InterruptedException {	
		Thread.sleep(8000);
		clickOn(driver, WFEPage.lnkSubject, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, WFEPage.tfTextSbuject, TestUtil.EXPLICIT_WAIT);
		WFEPage.tfTextSbuject.clear();
		WFEPage.tfTextSbuject.sendKeys(subject);
		clickOn(driver, WFEPage.btnDone, TestUtil.EXPLICIT_WAIT);
	}	
		
	@Test(priority=5, dataProvider="getCreateWFEMeetingTestData")
	public void VerifyMeetingLocationChange(String scheduledMeeting, String subject, String location, String account, String participant, String presentation) throws IOException, InterruptedException {			
		clickOn(driver, WFEPage.lnkLocation, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, WFEPage.tfLocation, TestUtil.EXPLICIT_WAIT);
		WFEPage.tfLocation.sendKeys(location);
		clickOn(driver, WFEPage.btnDone, TestUtil.EXPLICIT_WAIT);
	}
	
	@Test(priority=7, dataProvider="getCreateWFEMeetingTestData")
	public void VerifyAddingAccountToMeeting(String scheduledMeeting, String subject, String location, String account, String participant, String presentation) throws IOException, InterruptedException {			
		clickOn(driver, WFEPage.lnkSelectAccount, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(3000);
/*		clickOn(driver, WFEPage.tfSearchAccount, TestUtil.EXPLICIT_WAIT);
		WFEPage.tfSearchAccount.sendKeys(account);*/
		/*Thread.sleep(3000);*/
		clickOn(driver, WFEPage.chkboxAddbox, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, WFEPage.btnDone, TestUtil.EXPLICIT_WAIT);
	}	
	
	@Test(priority=8, dataProvider="getCreateWFEMeetingTestData")
	public void VerifyAddingParticipantToMeeting(String scheduledMeeting, String subject, String location, String account, String participant, String presentation) throws IOException, InterruptedException {		
		clickOn(driver, WFEPage.lnkSelectParticipants, TestUtil.EXPLICIT_WAIT);
		/*clickOn(driver, WFEPage.tfSearchParticipants, TestUtil.EXPLICIT_WAIT);
		WFEPage.tfSearchParticipants.sendKeys(participant);
		List<WebElement> list= driver.findElements(By.xpath("//div[ion-label[span[contains(text(),'"+participant+"')]]]//following-sibling::ion-icon[contains(text(),'') and @name='add']"));
	    System.out.println(list.size());
	    list.get(0).click();*/
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[ion-label[span[contains(text(),'"+participant+"')]]]//following-sibling::ion-icon[contains(text(),'') and @name='add']")).click();
	    clickOn(driver, WFEPage.btnDone, TestUtil.EXPLICIT_WAIT);
	}    
	 
	@Test(priority=6, dataProvider="getCreateWFEMeetingTestData")
	public void VerifyAddingPresentationToMeeting(String scheduledMeeting, String subject, String location, String account, String participant, String presentation) throws IOException, InterruptedException {	
	    clickOn(driver, WFEPage.lnkAddPresentation, TestUtil.EXPLICIT_WAIT);
	    Thread.sleep(5000);
		clickOn(driver, WFEPage.tfSearchPresentation, TestUtil.EXPLICIT_WAIT);
		WFEPage.tfSearchPresentation.sendKeys(presentation);
		Thread.sleep(5000);
		clickOn(driver, WFEPage.lnkPlusPresentation, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, WFEPage.btnDone, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(8000);
		softAssert.assertAll();
	}
	
	@Test(priority=9)
	public void VerifyPresentation() throws Exception {
		Thread.sleep(8000);
		clickOn(driver, WFEPage.btnMenu, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, WFEPage.lnkPresentations, TestUtil.EXPLICIT_WAIT);
		List<WebElement> list= driver.findElements(By.xpath("//ion-item//div//div//ion-label[contains(text(),'analyses post - hoc.pdf')]"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		Thread.sleep(7000);
		clickOn(driver, WFEPage.btnBack, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, WFEPage.lnkBackArrow, TestUtil.EXPLICIT_WAIT);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
