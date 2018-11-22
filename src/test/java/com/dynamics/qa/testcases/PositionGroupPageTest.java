/**
 *@author : Praveen.Kumar
 *@description : PositionGroup Page - Test cases (All webelements of PositionGroup page has been found here) 
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
import com.dynamics.qa.pages.PositionGroupPage;
import com.dynamics.qa.util.TestUtil;

public class PositionGroupPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
    HomePageTest homePageTest;
	PositionGroupPage positionGroupPage;
	PositionPageTest positionPageTest;
	
	HomePageTest HPT = new HomePageTest();
	
	String sheetName = "addPositionGroup";
	String sheetName2 = "editPositionGroup";
	
	SoftAssert softAssert = new SoftAssert();
	/* Test case ID: NA
	 * Test Case: NA
	 * Description:This method is constructor of ProductPageTest
	 * @author : Praveen.Kumar
	 */

	public PositionGroupPageTest() {
		super();
	}
	
/* Test case ID: NA
 * Description:This method is to launch URL,Login and navigate to IO home page
 * author : Praveen.Kumar
 */
	
	@Test(priority=1)	
	public void setUp() throws Exception {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		ioHomePage();
	} 
	
/* Test case ID: 
 * Description:This method is to navigate to PositionGroup's's home page from IO home page
 * author : Praveen.Kumar
 */
	@Test(priority=2)	
	public void verifyPresenceOfPositionGroupsEntityAndNavigationToPositionGroupsHomePage() throws Exception {			
		
		HPT.redirectToPositionGroupPage();
	}
	
/* Test case ID: 
 * Description: 1.This method verifies Position Group's home page is loaded successfully or not. 
 * 				2.It will take you to Position Group's home page and it will check presence of Add (Position group add) button.
 * author : Praveen.Kumar 
 */	
	@Test(priority=3)	
	public void verifyPositionGroupHomePage() throws Exception {
		
		String title = "Position Groups Active Position Groups - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
	}
	
/* Test case ID: NA
 * Description:This method provides data to create a Position Group
 * author : Praveen.Kumar 
 */	
	
	@DataProvider
	public Object[][] getAddPositionGroupTestData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
/* Test case ID: 
 * Description:This method verifies creation of PositionGroup 
 * author : Praveen.Kumar
 */	
	
	@Test(priority=4, dataProvider="getAddPositionGroupTestData")	
	public void verifyPositionGroupCreation(String pgName, String pgDescription) throws Exception { 
//==========================/////////////////CREATING POSITION GROUP //////////////////////===================================//
		
		clickOn(driver, PositionGroupPage.btnNew, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(4000);
		driver.navigate().refresh();
		TestUtil.switchToFirstFrame();
		System.out.println("Inside Frame");
		Thread.sleep(12000);
		PositionGroupPage.tfNameCreate.sendKeys(pgName);
		
	    clickOn(driver, PositionGroupPage.tf1Description, TestUtil.EXPLICIT_WAIT);
	    PositionGroupPage.tfDescription.click();
	    PositionGroupPage.tfDescription.sendKeys(pgDescription);
		
	    driver.switchTo().defaultContent();
	    Save();
	}
	
/* Test case ID: 
 * Description:This method verifies PositionGroup Deactivation 
 * author : Praveen.Kumar
 */	
	
	@Test(priority=5)	
	public void verifyPositionGroupDeactivation() throws IOException, InterruptedException {
		
		Thread.sleep(6000);
		clickOn(driver, PositionGroupPage.lnkDeactivate, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().frame("InlineDialog_Iframe");
		Thread.sleep(10000);
		clickOn(driver, PositionGroupPage.btnDeactivate, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		TestUtil.switchToFirstFrame();
		String expected = "Inactive";
		Thread.sleep(4000);
	    String actal = PositionGroupPage.txtStatus.getText();
	    System.out.println(actal);
	 
	    softAssert.assertEquals(actal,expected);
	    driver.switchTo().defaultContent();
	    
	}
	
/* Test case ID: 
 * Description:This method verifies PositionGroup Activation
 * author : Praveen.Kumar
 */		
	
	@Test(priority=6)	
	public void verifyPositionGroupActivation() throws IOException, InterruptedException {
		
		Thread.sleep(5000);
		clickOn(driver, PositionGroupPage.lnkActivate, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();
		String expected = "Active";
		Thread.sleep(4000);
	    String actal = PositionGroupPage.txtStatus.getText();
	    System.out.println(actal);
	 
	    softAssert.assertEquals(actal,expected);
	    driver.switchTo().defaultContent();
	}
	
	@DataProvider
	public Object[][] getEditPositionGroupTestData(){
		Object[][] data = TestUtil.getTestData(sheetName2);
		return data;
	}
	
/* Test case ID: 
 * Description:This method verifies Position Association to Position Group
 * author : Praveen.Kumar
 */		
	
	@Test(priority=7, dataProvider="getEditPositionGroupTestData")	
	public void verifyPositionAssociation(String pgName, String pgDescription,String position,String emailTemplate) throws Exception { 
//==========================/////////////////ASSOCIATING POSITIONS //////////////////////===================================//
		
		TestUtil.switchToFirstFrame();
		System.out.println("Inside Frame");
		clickOn(driver, PositionGroupPage.lnkAddPositions, TestUtil.EXPLICIT_WAIT);
		PositionGroupPage.tfAddPosition.sendKeys(position);
		clickOn(driver, PositionGroupPage.tfAddPositionSearch, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+position+"']")).click();
	}
	
/* Test case ID: 
 * Description:This method verifies Position Association to Position Group
 * author : Praveen.Kumar
 */		
	
	@Test(priority=8, dataProvider="getEditPositionGroupTestData")	
	public void verifyEmailTemplatesAssociation(String pgName, String pgDescription,String position,String emailTemplate) throws Exception { 
//==========================/////////////////ASSOCIATING EMAIL TEMPLATES//////////////////////===================================//
		
		clickOn(driver, PositionGroupPage.lnkAddEmailTemplates, TestUtil.EXPLICIT_WAIT);
		PositionGroupPage.tfAddEmailTemplates.sendKeys(emailTemplate);
		clickOn(driver, PositionGroupPage.tfAddEmailTemplatesSearch, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+emailTemplate+"']")).click();
		driver.switchTo().defaultContent();
		driver.navigate().back();
	}
	
/* Test case ID: 
 * Description:This method verifies Position Association to Position Group
 * author : Praveen.Kumar
 */		
	
	@Test(priority=9, dataProvider="getAddPositionGroupTestData")	
	public void verifySearchOptionForPositionGroup(String pgName, String pgDescription) throws Exception { 
//==========================/////////////////ASSOCIATING EMAIL TEMPLATES//////////////////////===================================//
		
		TestUtil.switchToSecondFrame();
		System.out.println("Inside Frame");
		Thread.sleep(3000);
		clickOn(driver, PositionGroupPage.tfSearchPositionGroup, TestUtil.EXPLICIT_WAIT);
		PositionGroupPage.tfSearchPositionGroup.clear();
		PositionGroupPage.tfSearchPositionGroup.sendKeys(pgName);
		clickOn(driver, PositionGroupPage.imgSearchPositionGroup, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+pgName+"']")).click();
		driver.switchTo().defaultContent();
		
	}
	
	
	@Test(priority=10, dataProvider="getEditPositionGroupTestData")	
	public void verifyPositionGrouopEdit(String pgName, String pgDescription, String position,String emailTemplate) throws Exception { 
//EDITING POSITION GROUP :
		
		TestUtil.switchToFirstFrame();
		System.out.println("Inside Frame");
		Thread.sleep(5000);
		clickOn(driver, PositionGroupPage.tf1NameEdit, TestUtil.EXPLICIT_WAIT);
		PositionGroupPage.tfNameCreate.clear();
		PositionGroupPage.tfNameCreate.sendKeys(pgName);
		
	    clickOn(driver, PositionGroupPage.tf1DescriptionEdit, TestUtil.EXPLICIT_WAIT);
	    PositionGroupPage.tfDescription.clear();
	    PositionGroupPage.tfDescription.sendKeys(pgDescription);
	    clickOn(driver, PositionGroupPage.tf1NameEdit, TestUtil.EXPLICIT_WAIT);
	    driver.switchTo().defaultContent();
	    Save();
	}
	
	@Test(priority=11)
	public void verifyPositionGrouopDelete() throws Exception {
		
		Thread.sleep(5000);
		Delete();
	    Thread.sleep(5000);
	}
	
	@Test(priority=12, dataProvider="getEditPositionGroupTestData")
	public void verifyDissociationOfPositionGroupInPosition(String pgName, String pgDescription,String position,String emailTemplate) throws Exception {
		
		HPT.redirectToPositionPage();
		TestUtil.switchToThirdFrame();
		System.out.println("Inside Frame");
		Thread.sleep(3000);
		clickOn(driver, PositionGroupPage.lnk1SearchPosition, TestUtil.EXPLICIT_WAIT);
		PositionGroupPage.lnk1SearchPosition.clear();
		clickOn(driver, PositionGroupPage.lnk1SearchPosition, TestUtil.EXPLICIT_WAIT);
		PositionGroupPage.lnk1SearchPosition.sendKeys(position);
		clickOn(driver, PositionGroupPage.lnkSearchPosition, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+position+"']")).click();
		driver.switchTo().defaultContent();
		
		TestUtil.switchToFirstFrame();
		System.out.println("Inside Frame");
	    List<WebElement> list= driver.findElements(By.xpath("//a[text()='"+pgName+"']"));
	    System.out.println(list.size());
	    softAssert.assertEquals(0, list.size());
	    driver.switchTo().defaultContent();
	    
	    softAssert.assertAll();
	    
		}
	
	@Test(priority=13, dataProvider="getEditPositionGroupTestData")
	public void verifyDissociationOfPositionGroupInEmailTemplate(String pgName, String pgDescription,String position,String emailTemplate) throws Exception {
		driver.navigate().back();
		
		clickOn(driver, PositionGroupPage.ddOminiPresenceUpdated, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionGroupPage.lnkEmailTemplate, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToSecondFrame();
		System.out.println("Inside Frame");
		Thread.sleep(3000);
		clickOn(driver, PositionGroupPage.lnk1SearchPosition, TestUtil.EXPLICIT_WAIT);
		PositionGroupPage.lnk1SearchPosition.clear();
		clickOn(driver, PositionGroupPage.lnk1SearchPosition, TestUtil.EXPLICIT_WAIT);
		PositionGroupPage.lnk1SearchPosition.sendKeys(emailTemplate);
		clickOn(driver, PositionGroupPage.lnkSearchPosition, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+emailTemplate+"']")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("contentIFrame1");
		System.out.println("Inside Frame");
		List<WebElement> list= driver.findElements(By.xpath("//a[text()='"+pgName+"']"));
	    System.out.println(list.size());
	    softAssert.assertEquals(0, list.size());
	    driver.switchTo().defaultContent();
	    
	    
	    softAssert.assertAll();
		driver.switchTo().defaultContent();
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
		
}
