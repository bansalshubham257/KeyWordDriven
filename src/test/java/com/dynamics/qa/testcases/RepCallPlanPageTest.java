package com.dynamics.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.RepCallPlanPage;
import com.dynamics.qa.util.TestUtil;

public class RepCallPlanPageTest extends TestBase{
	
	private static final String Open = "Open";
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
	
	HomePageTest HPT = new HomePageTest();
	SegmentCallPlanPageTest SCPT = new SegmentCallPlanPageTest();
	
	String sheetNameSegmentCallPlan = "segmentCallPlan";
	String sheetNameTargetedHCPsInCP  = "targetedHCPsInCP";  
	
	SoftAssert softAssert = new SoftAssert();
	
	public RepCallPlanPageTest() {
		super();
	}
	
	@Test(priority=1)	
	public void setUp() throws Exception {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("user1username"), prop.getProperty("user1password"));
		ioHomePage();
	} 
	
	@Test(priority=2)	
	public void verifyPresenceOfRepCallPlanAndNavigationToRepCallPlansHomePage() throws Exception {			
		
		HPT.redirectToRepCallPlan();
	}
	
	@Test(priority=3)	
	public void verifyRepCallPlanHomePage() throws Exception {
		
		String title = "Customer Call Plans My Current Call Plans - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
	}
	
	@DataProvider
	public Object[][] getSegmentCallPlanTestData(){
		Object[][] data = TestUtil.getTestData(sheetNameSegmentCallPlan);
		return data;
	}
	
	@Test(priority=4)	
	public void verify() throws Exception {
		
		TestUtil.switchToFirstFrame();
		clickOn(driver, RepCallPlanPage.ddViewSelect, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, RepCallPlanPage.lnkMyOpenRepCallPlansView, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=5)	
	public void verifyMyOpenRepCallPlanHomePage() throws Exception {
		
		String title = "Customer Call Plans My Open Rep Call Plans - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();
	}

//----------------------------Rep Login - Verify Details on the rep call plan present in the list of Rep Call Plans-----------------------------------------------------------------//
	
	@Test(priority=6, dataProvider="getSegmentCallPlanTestData")	
	public void verifyNumberOfRCPsCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalRCPInRepLogin);
		Thread.sleep(4000);
		List<WebElement> totalRCPsInRepLogin= driver.findElements(By.xpath("//a[@title='"+Open+" "+product+"']//li//span[@title='"+product+"']"));
		System.out.println(totalRCPsInRepLogin.size());
		softAssert.assertEquals(number, totalRCPsInRepLogin.size());
		softAssert.assertAll();
	}
	
	@Test(priority=7, dataProvider="getSegmentCallPlanTestData")	
	public void verifyNameOfRCPCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> list= driver.findElements(By.xpath("//a[@title='"+nameOfCCP+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=8, dataProvider="getSegmentCallPlanTestData")	
	public void verifyProductNameOnRCPList(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalRCPInRepLogin);
		List<WebElement> list= driver.findElements(By.xpath("//a[@title='"+Open+" "+product+"']//span[@title='"+product+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=9, dataProvider="getSegmentCallPlanTestData")	
	public void verifySegmentNameOnRCPList(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalRCPInRepLogin);
		List<WebElement> list= driver.findElements(By.xpath("//td[contains (@class,'ms-crm-List-DataCell')]//nobr//a[@title='"+Open+" "+segment+"']//li//span//span//span[text()='"+segment+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=10, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStartDateOnRCPCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalRCPInRepLogin);
		String start = conversionDates("dd-MMM-yyyy", "M/d/yyyy", startDate);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell')]//nobr//span[text()='"+start+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=11, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEndDateOnRCPCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalRCPInRepLogin);
		String end = conversionDates("dd-MMM-yyyy", "M/d/yyyy", startDate);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell')]//nobr//span[text()='"+end+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=12, dataProvider="getSegmentCallPlanTestData")	
	public void verifyCallGoalsOnRCPCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalRCPInRepLogin);
		int custCallGoalsnumber=(int) Double.parseDouble(customerCallGoals);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell')]//nobr//span[text()='"+custCallGoalsnumber+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=13, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEmailGoalsOnRCPCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalRCPInRepLogin);
		int custEmailGoalsnumber=(int) Double.parseDouble(customerEmailGoals);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell')]//nobr//span[text()='"+custEmailGoalsnumber+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=14, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStatusReasOnRCPCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int number=(int) Double.parseDouble(totalRCPInRepLogin);
		List<WebElement> list= driver.findElements(By.xpath("//td[starts-with(@class,'ms-crm-List-DataCell')]//nobr//span[text()='"+statusReason+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(number, list.size());
		softAssert.assertAll();
	}
	
	@Test(priority=15, dataProvider="getSegmentCallPlanTestData")	
	public void verifyClickOnNameOfRCPCreated(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		driver.findElement(By.xpath("//a[@title='"+nameOfCCP+"']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		TestUtil.switchToSecondFrame();
	}
	
//----------------------------Rep Login - Pick one of the Rep call plan and verify details inside that-----------------------------------------------------------------//

	@Test(priority=16, dataProvider="getSegmentCallPlanTestData")	
	public void verifyNameOfRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> CPName= driver.findElements(By.xpath("//div[@id='indskr_name']//div//label//div[contains(text(),'"+nameOfCCP+"')]"));
		System.out.println(CPName.size());
		softAssert.assertEquals(1, CPName.size());
		softAssert.assertAll();
	}	
	
	@Test(priority=17, dataProvider="getSegmentCallPlanTestData")	
	public void verifyProductInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> Product= driver.findElements(By.xpath("//div[@id='indskr_productid']//label[@id='Product_label']//following-sibling::span//span[contains(text(),'"+product+"')]"));
		System.out.println(Product.size());
		softAssert.assertEquals(1, Product.size());
		softAssert.assertAll();
	}
	
	@Test(priority=18, dataProvider="getSegmentCallPlanTestData")	
	public void verifySegmentInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> Segment= driver.findElements(By.xpath("//div[@id='indskr_segment_v2']//div//label[@id='Segment_label']//div[contains (text(),'Segment "+segment+"')]"));
		System.out.println(Segment.size());
		softAssert.assertEquals(1, Segment.size());
		softAssert.assertAll();
	}
	
	@Test(priority=19, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStatusInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> Status= driver.findElements(By.xpath("//div[@id='statuscode']//div//label[@id='Status_label']//div[contains(text(),'"+statusReason+"')]"));
		System.out.println(Status.size());
		softAssert.assertEquals(1, Status.size());
		softAssert.assertAll();
	}	
	
	@Test(priority=20, dataProvider="getSegmentCallPlanTestData")	
	public void verifyCallPlanNameInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> CallPlanName= driver.findElements(By.xpath("//div[@id='indskr_cycleplanid']//div//label[@id='Call Plan_label']//following-sibling::span//span[contains(text(),'"+segmentCallPlanName+"')]"));
		System.out.println(CallPlanName.size());
		softAssert.assertEquals(1, CallPlanName.size());
		softAssert.assertAll();
	}
	
	@Test(priority=21, dataProvider="getSegmentCallPlanTestData")	
	public void verifyStartDateInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		String start = conversionDates("dd-MMM-yyyy", "M/d/yyyy", startDate);
		List<WebElement> StartDate= driver.findElements(By.xpath("//div[@id='indskr_startdate']//div//label[@id='Period Start Date_label' and contains(text(),'"+start+"')]"));
		System.out.println(StartDate.size());
		softAssert.assertEquals(1, StartDate.size());
		softAssert.assertAll();
	}
	
	@Test(priority=22, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEndDateInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		String end = conversionDates("dd-MMM-yyyy", "M/d/yyyy", endDate);
		List<WebElement> EndDate= driver.findElements(By.xpath("//div[@id='indskr_enddate']//div//label[@id='Period End Date_label' and contains(text(),'"+end+"')]"));
		System.out.println(EndDate.size());
		softAssert.assertEquals(1, EndDate.size());
		softAssert.assertAll();
	}
	
	@Test(priority=23, dataProvider="getSegmentCallPlanTestData")	
	public void verifyMeetingGoalsInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int custCallGoalsnumber=(int) Double.parseDouble(customerCallGoals);
		List<WebElement> MeetingGoal= driver.findElements(By.xpath("//div[@id='indskr_hocalls']//div//label[@id='Meetings Goal_label' and contains(text(),'"+custCallGoalsnumber+"')]"));
		System.out.println(MeetingGoal.size());
		softAssert.assertEquals(1, MeetingGoal.size());
		softAssert.assertAll();
	}
	
	@Test(priority=24, dataProvider="getSegmentCallPlanTestData")	
	public void verifyEmailGoalsInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		int custEmailGoalsnumber=(int) Double.parseDouble(customerEmailGoals);
		List<WebElement> EmailGoal= driver.findElements(By.xpath("//div[@id='indskr_hoemails']//div//label[@id='Emails Goal_label' and contains(text(),'"+custEmailGoalsnumber+"')]"));
		System.out.println(EmailGoal.size());
		softAssert.assertEquals(1, EmailGoal.size());
		softAssert.assertAll();
	}
	
	@Test(priority=25, dataProvider="getSegmentCallPlanTestData")	
	public void verifyPositionNameInRCP(String segmentCallPlanName, String product, String segment, String startDate, String endDate, String customerCallGoals, 
			String customerEmailGoals, String totalCustCallPlans, String nameOfCCP, String statusReason, String totalRepCallPlans, String positinOnRCP, String totalRCPInRepLogin) throws Exception {
		
		List<WebElement> CallPlanName= driver.findElements(By.xpath("//div[@id='indskr_positionid']//div//label[@id='Position_label']//following-sibling::span//span[contains(text(),'"+positinOnRCP+"')]"));
		System.out.println(CallPlanName.size());
		softAssert.assertEquals(1, CallPlanName.size());
		softAssert.assertAll();
	}
}
