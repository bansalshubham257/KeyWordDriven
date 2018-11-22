package com.dynamics.qa.testcases;


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
import com.dynamics.qa.pages.SegmentCallPlanPage;
import com.dynamics.qa.util.TestUtil;

public class SegmentCallPlanPageTest extends TestBase{
	
	private static final String Open = "Open";
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
	
	HomePageTest HPT = new HomePageTest();
	
	String sheetNameSegmentCallPlan = "segmentCallPlan";
	String sheetNameTargetedHCPsInCP  = "targetedHCPsInCP";  
	
	SoftAssert softAssert = new SoftAssert();
	
	public SegmentCallPlanPageTest() {
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
	public void verifyPresenceOfSegmentCallPlanAndNavigationToSegmentCallPlansHomePage() throws Exception {			
		
		HPT.redirectToSegmentCallPlan();
	}	
	
	@Test(priority=3)	
	public void verifySegmentCallPlanHomePage() throws Exception {
		
		String title = "Call Plans All Call Plans - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
	}
	
	@DataProvider
	public Object[][] getSegmentCallPlanTestData(){
		Object[][] data = TestUtil.getTestData(sheetNameSegmentCallPlan);
		return data;
	}
	
	@Test(priority=4, dataProvider="getSegmentCallPlanTestData")
	public void verifyContactCreation(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception { 
		
		driver.navigate().refresh();
		Thread.sleep(4000);
		clickOn(driver, SegmentCallPlanPage.btnNew, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToSecondFrame();
		Thread.sleep(20000);
		SegmentCallPlanPage.tfName.sendKeys(segmentCallPlanName);
		
		clickOn(driver, SegmentCallPlanPage.labelProduct, TestUtil.EXPLICIT_WAIT);
		SegmentCallPlanPage.tfProduct.sendKeys(product);
		
		clickOn(driver, SegmentCallPlanPage.labelSegment, TestUtil.EXPLICIT_WAIT);
		SegmentCallPlanPage.tfSegment.sendKeys(segment);
		
		clickOn(driver, SegmentCallPlanPage.labelCallPlanStartDate, TestUtil.EXPLICIT_WAIT);
		SegmentCallPlanPage.tfCallPlanStartDate.sendKeys(startDate);
		
		clickOn(driver, SegmentCallPlanPage.labelCallPlanEndDate, TestUtil.EXPLICIT_WAIT);
		SegmentCallPlanPage.tfCallPlanEndDate.sendKeys(endDate);
		
		clickOn(driver, SegmentCallPlanPage.labelCustomerCallGoals, TestUtil.EXPLICIT_WAIT);
		SegmentCallPlanPage.tfCustomerCallGoals.sendKeys(customerCallGoals);
		
		clickOn(driver, SegmentCallPlanPage.labelCustomerEmailGoals, TestUtil.EXPLICIT_WAIT);
		SegmentCallPlanPage.tfCustomerEmailGoals.sendKeys(customerEmailGoals);
		driver.switchTo().defaultContent();
		Save();
	}
	
	@Test(priority=5)	
	public void verifyNewStatusWhenCallPlanSaved() throws Exception {
		
		TestUtil.switchToSecondFrame();
	    String expected = "New";
	    Thread.sleep(4000);
	    String actual = SegmentCallPlanPage.txtStatus.getText();
	    System.out.println(actual);
	 
	    softAssert.assertEquals(actual,expected);
	    driver.switchTo().defaultContent();
	    softAssert.assertAll();
	}
	
	@Test(priority=6)	
	public void verifyDistributeCallPlan() throws Exception {
		
		clickOn(driver, SegmentCallPlanPage.lnkDistribute, TestUtil.EXPLICIT_WAIT);
		TestUtil.alertWindow();
	}
	
	@Test(priority=7)	
	public void verifyDistributedStatusWhenCallPlanDistributed() throws Exception {
		
		TestUtil.switchToSecondFrame();
	    String expected = "Distributed";
	    Thread.sleep(6000);
	    String actual = SegmentCallPlanPage.txtStatus.getText();
	    System.out.println(actual);
	 
	    softAssert.assertEquals(actual,expected);
	    driver.switchTo().defaultContent();
	    softAssert.assertAll();
	    TestUtil.switchToSecondFrame();
	}
//----------------------------Verify Details in the Segment call plan that we created-----------------------------------------------------------------//
	
	@Test(priority=8, dataProvider="getSegmentCallPlanTestData")	
	public void verifyNumberOfCustomerCallPlansCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalCustCallPlans);
		List<WebElement> list= driver.findElements(By.xpath("//a[@title='"+Open+" "+product+"']//span[@title='"+product+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}

	@Test(priority=9, dataProvider="getSegmentCallPlanTestData")	
	public void verifyNameOfCCPCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> list= driver.findElements(By.xpath("//a[@title='"+nameOfCCP+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		softAssert.assertAll();
	}
	

	@Test(priority=10, dataProvider="getSegmentCallPlanTestData")	
	public void verifyProductNameOnCustCallPlansCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		verifyNumberOfCustomerCallPlansCreated(segmentCallPlanName, product, segment, startDate, endDate, customerCallGoals, customerEmailGoals, totalCustCallPlans, nameOfCCP, statusReason, totalRepCallPlans, positinOnRCP, totalRCPInRepLogin);
	}
	
	@Test(priority=11, dataProvider="getSegmentCallPlanTestData")	
	public void verifySegmentNameOnCustCallPlansCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalCustCallPlans);
		List<WebElement> list= driver.findElements(By.xpath("//td[@class='ms-crm-List-DataCell-Lite']//a[@title='"+Open+" "+segment+"']//li//span[@title='"+segment+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=12, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStartDateOnCustCallPlansCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalCustCallPlans);
		String start = conversionDates("dd-MMM-yyyy", "M/d/yyyy", startDate);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell-Lite')]//div[text()='"+start+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=13, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEndDateOnCustCallPlansCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalCustCallPlans);
		String end = conversionDates("dd-MMM-yyyy", "M/d/yyyy", startDate);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell-Lite')]//div[text()='"+end+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=14, dataProvider="getSegmentCallPlanTestData")	
	public void verifyCallGoalsOnCustCallPlansCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalCustCallPlans);
		int custCallGoalsnumber=(int) Double.parseDouble(customerCallGoals);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell-Lite')]//div[text()='"+custCallGoalsnumber+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=15, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEmailGoalsOnCustCallPlansCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalCustCallPlans);
		int custEmailGoalsnumber=(int) Double.parseDouble(customerEmailGoals);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell-Lite')]//div[text()='"+custEmailGoalsnumber+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=16, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStatusReasonCallPlansCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalCustCallPlans);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell-Lite')]//div[text()='"+statusReason+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@DataProvider
	public Object[][] getTargetedHCPsData(){
		Object[][] data = TestUtil.getTestData(sheetNameTargetedHCPsInCP);
		return data;
	}
	
	@Test(priority=17, dataProvider="getTargetedHCPsData")	
	public void verifyHCPNameOnCCPCreated(String targetedHcps) throws Exception {
		List<WebElement> list= driver.findElements(By.xpath("//span[@title='"+targetedHcps+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
	}

//----------------------------Picking one customer call plan and verifying details inside it-----------------------------------------------------------------//	
	
	@Test(priority=18, dataProvider="getSegmentCallPlanTestData")	
	public void verifyClickOnOneCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
//Click on one of the Customer call plan
		driver.findElement(By.xpath("//a[@title='"+nameOfCCP+"']")).click();
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=19, dataProvider="getSegmentCallPlanTestData")	
	public void verifyNameOfCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		TestUtil.switchToSecondFrame();
		List<WebElement> CPName= driver.findElements(By.xpath("//div[@id='indskr_name']//div//label//div[contains(text(),'"+nameOfCCP+"')]"));
		System.out.println(CPName.size());
		softAssert.assertEquals(1, CPName.size());
		softAssert.assertAll();
	}	
	
	@Test(priority=20, dataProvider="getSegmentCallPlanTestData")	
	public void verifyProductInCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> Product= driver.findElements(By.xpath("//div[@id='indskr_productid']//label[@id='Product_label']//following-sibling::span//span[contains(text(),'"+product+"')]"));
		System.out.println(Product.size());
		softAssert.assertEquals(1, Product.size());
		softAssert.assertAll();
	}
	
	@Test(priority=21, dataProvider="getSegmentCallPlanTestData")	
	public void verifySegmentInCPP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> Segment= driver.findElements(By.xpath("//div[@id='indskr_segment_v2']//div//label[@id='Segment_label']//div[contains (text(),'Segment "+segment+"')]"));
		System.out.println(Segment.size());
		softAssert.assertEquals(1, Segment.size());
		softAssert.assertAll();
	}
	
	@Test(priority=22, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStatusInCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> Status= driver.findElements(By.xpath("//div[@id='statuscode']//div//label[@id='Status_label']//div[contains(text(),'"+statusReason+"')]"));
		System.out.println(Status.size());
		softAssert.assertEquals(1, Status.size());
		softAssert.assertAll();
	}	
	
	@Test(priority=23, dataProvider="getSegmentCallPlanTestData")	
	public void verifyCallPlanNameInCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> CallPlanName= driver.findElements(By.xpath("//div[@id='indskr_cycleplanid']//div//label[@id='Call Plan_label']//following-sibling::span//span[contains(text(),'"+segmentCallPlanName+"')]"));
		System.out.println(CallPlanName.size());
		softAssert.assertEquals(1, CallPlanName.size());
		softAssert.assertAll();
	}
	
	@Test(priority=24, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStartDateInCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		String start = conversionDates("dd-MMM-yyyy", "M/d/yyyy", startDate);
		List<WebElement> StartDate= driver.findElements(By.xpath("//div[@id='indskr_startdate']//div//label[@id='Period Start Date_label' and contains(text(),'"+start+"')]"));
		System.out.println(StartDate.size());
		softAssert.assertEquals(1, StartDate.size());
		softAssert.assertAll();
	}
	
	@Test(priority=25, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEndDateInCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		String end = conversionDates("dd-MMM-yyyy", "M/d/yyyy", endDate);
		List<WebElement> EndDate= driver.findElements(By.xpath("//div[@id='indskr_enddate']//div//label[@id='Period End Date_label' and contains(text(),'"+end+"')]"));
		System.out.println(EndDate.size());
		softAssert.assertEquals(1, EndDate.size());
		softAssert.assertAll();
	}
	
	@Test(priority=26, dataProvider="getSegmentCallPlanTestData")	
	public void verifyMeetingGoalsInOneOfTheCreatedCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int custCallGoalsnumber=(int) Double.parseDouble(customerCallGoals);
		List<WebElement> MeetingGoal= driver.findElements(By.xpath("//div[@id='indskr_hocalls']//div//label[@id='Meetings Goal_label' and contains(text(),'"+custCallGoalsnumber+"')]"));
		System.out.println(MeetingGoal.size());
		softAssert.assertEquals(1, MeetingGoal.size());
		softAssert.assertAll();
	}
	
	@Test(priority=27, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEmailGoalsInOneOfTheCreatedCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int custEmailGoalsnumber=(int) Double.parseDouble(customerEmailGoals);
		List<WebElement> EmailGoal= driver.findElements(By.xpath("//div[@id='indskr_hoemails']//div//label[@id='Emails Goal_label' and contains(text(),'"+custEmailGoalsnumber+"')]"));
		System.out.println(EmailGoal.size());
		softAssert.assertEquals(1, EmailGoal.size());
		softAssert.assertAll();
	}
	
//----------------------------Picking one customer call plan and verifying Rep call Plan details inside it-----------------------------------------------------------------//		
	@Test(priority=28, dataProvider="getSegmentCallPlanTestData")	
	public void verifyTotalRCPsCreatedinCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int totalRepCallPlansCreated=(int) Double.parseDouble(totalRepCallPlans);
		List<WebElement> repCallplans= driver.findElements(By.xpath("//a[@title='"+nameOfCCP+"']"));
		System.out.println(repCallplans.size());
		softAssert.assertEquals(totalRepCallPlansCreated, repCallplans.size());
		softAssert.assertAll();
	}
	
	@Test(priority=29, dataProvider="getSegmentCallPlanTestData")	
	public void verifyNameOnRCPsCreatedInCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		verifyTotalRCPsCreatedinCCP(segmentCallPlanName, product, segment, startDate, endDate, customerCallGoals, customerEmailGoals, totalCustCallPlans, nameOfCCP, statusReason, totalRepCallPlans, positinOnRCP, totalRCPInRepLogin);
/*		int totalRepCallPlansCreated=(int) Double.parseDouble(totalRepCallPlans);
		List<WebElement> repCallplans= driver.findElements(By.xpath("//a[@title='"+nameOfCCP+"']"));
		System.out.println(repCallplans.size());
		softAssert.assertEquals(totalRepCallPlansCreated, repCallplans.size());
		softAssert.assertAll();*/
	}
	
	@Test(priority=30, dataProvider="getSegmentCallPlanTestData")	
	public void verifyPositionNameOnRCPCreatedInCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinNameOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> repCallplans= driver.findElements(By.xpath("//span[@title='"+positinNameOnRCP+"']//span//span[contains(text(),'"+positinNameOnRCP+"')]"));
		System.out.println(repCallplans.size());
		softAssert.assertEquals(1, repCallplans.size());
		softAssert.assertAll();
	}
	
	@Test(priority=31, dataProvider="getSegmentCallPlanTestData")	
	public void verifyCallGoalsOnRPCCreatedinCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int totalRepCallPlansCreated=(int) Double.parseDouble(totalRepCallPlans);
		int custCallGoalsnumber=(int) Double.parseDouble(customerCallGoals);
		List<WebElement> repCallGoals= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell-Lite')]//div[text()='"+custCallGoalsnumber+"']"));
		System.out.println(repCallGoals.size());
		softAssert.assertEquals(totalRepCallPlansCreated, repCallGoals.size());
		softAssert.assertAll();
	}
	
	@Test(priority=32, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEmailGoalsOnRPCCreatedinCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int totalRepCallPlansCreated=(int) Double.parseDouble(totalRepCallPlans);
		int custEmailGoalsnumber=(int) Double.parseDouble(customerEmailGoals);
		List<WebElement> repEmailGoals= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell-Lite')]//div[text()='"+custEmailGoalsnumber+"']"));
		System.out.println(repEmailGoals.size());
		softAssert.assertEquals(totalRepCallPlansCreated, repEmailGoals.size());
		softAssert.assertAll();
	}
	
	@Test(priority=33, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStatusReasOnRPCCreatedinCCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int totalRepCallPlansCreated=(int) Double.parseDouble(totalRepCallPlans);
		List<WebElement> status= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell-Lite')]//div[text()='"+statusReason+"']"));
		System.out.println(status.size());
		softAssert.assertEquals(totalRepCallPlansCreated, status.size());
		softAssert.assertAll();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
}
