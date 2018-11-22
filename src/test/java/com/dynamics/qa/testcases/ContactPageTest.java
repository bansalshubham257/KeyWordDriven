package com.dynamics.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.ContactPage;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
    ContactPage contactPage;
	
	HomePageTest HPT = new HomePageTest();
	
	String sheetName = "addContact";
	
	SoftAssert softAssert = new SoftAssert();
	
	public ContactPageTest() {
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
	public void verifyPresenceOfContactEntityAndNavigationToContactsHomePage() throws Exception {			
		
		HPT.redirectToContactPage();
	}	
	
	@Test(priority=3)	
	public void verifyContactHomePage() throws Exception {
		
		String title = "Contacts My Contacts - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
		
		
	}
	
	@DataProvider
	public Object[][] getAddContactTestData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=4, dataProvider="getAddContactTestData")
	public void verifyContactCreation(String firstName, String secondName, String middleName, String suffix, String prfdesignation,String preferredLanguage,
			String primarySpeciality, String bPhone, String mPhone, String email, String ePD, String ePS, String eBP, String eMP, String position) throws Exception { 
		
		Thread.sleep(8000);
		clickOn(driver, ContactPage.btnNew, TestUtil.EXPLICIT_WAIT);
		driver.navigate().refresh();
//Title :
		TestUtil.switchToFirstFrame();	
		Thread.sleep(4000);
		clickOn(driver, ContactPage.ddType1, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, ContactPage.ddType, TestUtil.EXPLICIT_WAIT);
		Select select = new Select(ContactPage.ddType);
		select.selectByVisibleText("Mrs."); //pass it from excel
//Name :	
		clickOn(driver, ContactPage.tfName1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfFirstName.sendKeys(firstName);
		clickOn(driver, ContactPage.tfLastName1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfLastName.sendKeys(secondName);
		clickOn(driver, ContactPage.btnDone, TestUtil.EXPLICIT_WAIT);
//Middle Name :	
		clickOn(driver, ContactPage.tfMiddleName1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfMiddleName.sendKeys(middleName);
//Suffix :	
		clickOn(driver, ContactPage.tfSuffix1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfSuffix.sendKeys(suffix);
//Professional Designation :
		clickOn(driver, ContactPage.tfProfessionalDesignation1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfProfessionalDesignation.sendKeys(prfdesignation);

//Preferred Language :
		clickOn(driver, ContactPage.tfPreferredLanguage1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfPreferredLanguage.sendKeys(preferredLanguage);

//Primary Specialty :
		clickOn(driver, ContactPage.tfPimarySpeciality1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfPimarySpeciality.sendKeys(primarySpeciality);

//Speaker :	
		clickOn(driver, ContactPage.chkBoxSpeaker, TestUtil.EXPLICIT_WAIT);
//KOL :	
		clickOn(driver, ContactPage.chkBoxKOL, TestUtil.EXPLICIT_WAIT);
//Business Phone :	
		clickOn(driver, ContactPage.tfBusinessPhone1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfBusinessPhone.sendKeys(bPhone);
//Mobile Phone :
		clickOn(driver, ContactPage.tfMobilePhone1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfMobilePhone.sendKeys(mPhone);
		
		driver.switchTo().defaultContent();
		Save();
		Thread.sleep(5000);
		driver.navigate().refresh();
		TestUtil.alertWindow();
	}
	
	@Test(priority=5, dataProvider="getAddContactTestData")
	public void verifyEmailAssociation(String firstName, String secondName, String middleName, String suffix, String prfdesignation,String preferredLanguage,
			String primarySpeciality, String bPhone, String mPhone, String email, String ePD, String ePS, String eBP, String eMP, String position) throws Exception { 
		
		Thread.sleep(3000);
		TestUtil.switchToFirstFrame();
		clickOn(driver, ContactPage.lnkAddEmail, TestUtil.EXPLICIT_WAIT);	    
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("NavBarGloablQuickCreate");
		System.out.println("inside Frame");
		clickOn(driver, ContactPage.tfEmail1, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfEmail.sendKeys(email);
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		clickOn(driver, ContactPage.btnSave, TestUtil.EXPLICIT_WAIT);
		driver.navigate().refresh();
		TestUtil.alertWindow();
		
	}
	
	@Test(priority=6, dataProvider="getAddContactTestData")
	public void verifyAutomaticallyAssociatedPosition(String firstName, String secondName, String middleName, String suffix, String prfdesignation,String preferredLanguage,
			String primarySpeciality, String bPhone, String mPhone, String email, String ePD, String ePS, String eBP, String eMP, String position) throws Exception {
		
		TestUtil.switchToFirstFrame();
	    List<WebElement> list= driver.findElements(By.xpath("//a//li//span//span//span[text()='"+position+"']"));//Put this in Configuration.
	    System.out.println(list.size());
	    softAssert.assertEquals(1, list.size());
	    
	    softAssert.assertAll();
	    driver.switchTo().defaultContent();
	}
	
	@Test(priority=7)	
	public void verifyContactDeactivation() throws IOException, InterruptedException {
		
		Thread.sleep(6000);
		clickOn(driver, ContactPage.lnkDeactivate, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().frame("InlineDialog_Iframe");
		Thread.sleep(6000);
		clickOn(driver, ContactPage.btnDeactivate, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		TestUtil.switchToFirstFrame();
		String expected = "Inactive";
		Thread.sleep(4000);
	    String actual = ContactPage.txtStatus.getText();
	    System.out.println(actual);
	 
	    softAssert.assertEquals(actual,expected);
	    driver.switchTo().defaultContent();
	    
	}
	
	@Test(priority=8)	
	public void verifyContactActivation() throws IOException, InterruptedException {
		
		Thread.sleep(4000);
		clickOn(driver, ContactPage.lnkActivate, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().frame("InlineDialog_Iframe");
		Thread.sleep(6000);
		clickOn(driver, ContactPage.btnActivate, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		TestUtil.switchToFirstFrame();
		String expected = "Active";
		Thread.sleep(4000);
	    String actal = ContactPage.txtStatus.getText();
	    System.out.println(actal);
	 
	    softAssert.assertEquals(actal,expected);
	    driver.switchTo().defaultContent();
	}
	
	@Test(priority=9, dataProvider="getAddContactTestData")	
	public void verifyContactSearch(String firstName, String secondName, String middleName, String suffix, String prfdesignation,String preferredLanguage,
			String primarySpeciality, String bPhone, String mPhone, String email, String ePD, String ePS, String eBP, String eMP, String position) throws IOException, InterruptedException {
		
		Thread.sleep(4000);
		driver.navigate().back();
		TestUtil.switchToSecondFrame();
		System.out.println("Inside Frame");
		Thread.sleep(5000);
		clickOn(driver, ContactPage.tfSearchContact, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfSearchContact.clear();
		ContactPage.tfSearchContact.sendKeys(firstName);
		clickOn(driver, ContactPage.imgSearchContact, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+firstName+" "+secondName+"']")).click();
		driver.switchTo().defaultContent();
		
	}
	
	@Test(priority=10, dataProvider="getAddContactTestData")	
	public void verifyEditContact(String firstName, String secondName, String middleName, String suffix, String prfdesignation,String preferredLanguage,
			String primarySpeciality, String bPhone, String mPhone, String email, String ePD, String ePS, String eBP, String eMP, String position) throws IOException, InterruptedException {
		
		TestUtil.switchToFirstFrame();	
		Thread.sleep(4000);
//Speaker :	
		clickOn(driver, ContactPage.chkBoxSpeaker, TestUtil.EXPLICIT_WAIT);
//KOL :	
		clickOn(driver, ContactPage.chkBoxKOL, TestUtil.EXPLICIT_WAIT);
		
		driver.switchTo().defaultContent();
		Save();
		Thread.sleep(4000);
		driver.navigate().refresh();
		
	}
	
	@Test(priority=11, dataProvider="getAddContactTestData")	
	public void verifyPositionDissociationFromContact(String firstName, String secondName, String middleName, String suffix, String prfdesignation,String preferredLanguage,
			String primarySpeciality, String bPhone, String mPhone, String email, String ePD, String ePS, String eBP, String eMP, String position) throws Exception {
		
		TestUtil.switchToFirstFrame();
		System.out.println("Inside First Frame");
		WebElement Value = driver.findElement(By.xpath("//a//li//span//span//span[text()='"+position+"']"));
	    TestUtil.mousehover(Value);
		List<WebElement> list= driver.findElements(By.xpath("//a[@title='Delete']"));
	    System.out.println(list.size());
	    list.get(1).click();
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("InlineDialog_Iframe");
		Thread.sleep(4000);
		clickOn(driver, ContactPage.btnDelete, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=12)	
	public void verifyDeletingContact() throws Exception {
		
		Thread.sleep(4000);
		clickOn(driver, ContactPage.lnkFindMore, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, ContactPage.ddDelete, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().frame("InlineDialog_Iframe");
		Thread.sleep(4000);
		clickOn(driver, ContactPage.btnDeleteContact, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
	}
	
	@Test(priority=13, dataProvider="getAddContactTestData")	
	public void verifyContactDelete(String firstName, String secondName, String middleName, String suffix, String prfdesignation,String preferredLanguage,
			String primarySpeciality, String bPhone, String mPhone, String email, String ePD, String ePS, String eBP, String eMP, String position) throws Exception {
		
		TestUtil.switchToSecondFrame();
		System.out.println("Inside Frame");
		Thread.sleep(3000);
		clickOn(driver, ContactPage.tfSearchContact, TestUtil.EXPLICIT_WAIT);
		ContactPage.tfSearchContact.clear();
		ContactPage.tfSearchContact.sendKeys(firstName);
		clickOn(driver, ContactPage.imgSearchContact, TestUtil.EXPLICIT_WAIT);
		List<WebElement> list= driver.findElements(By.xpath("//a[@title='"+firstName+" "+secondName+"']"));
	    System.out.println(list.size());
	    softAssert.assertEquals(0, list.size());
	    softAssert.assertAll();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
