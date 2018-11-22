	/**
	 *@author : Praveen.Kumar
	 *@description : Product Page - Test cases (CRUD Operation Test cases)
	 *@class : ProductPageTest 
	 */

package com.dynamics.qa.testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.PositionPage;
import com.dynamics.qa.util.TestUtil;

public class PositionPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
    HomePageTest homePageTest;
	PositionPage positionPage;
	String title = "Position: AutomationChildPosition";
	
	HomePageTest HPT = new HomePageTest();
	
	String sheetName = "addPosition";
	String sheetNameEdit = "editPosition";
	String sheetNameAssociate = "associatePosition";
	
	SoftAssert softAssert = new SoftAssert();
	
	/* Test case ID: NA
	 * Test Case: NA
	 * Description:This method is constructor of ProductPageTest
	 * @author : Praveen.Kumar
	 */

	public PositionPageTest() {
		super();
	}
	
	/* Test case ID: NA
	 * Test Case: verifyLogin
	 * Description:This method runs initialize methods of base class and verifies login to dynamics application
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
	
	/* Test case ID: NA
	 * Test Case: verifyHomePage
	 * Description:This method takes us to ominipresence home page
	 * author : Praveen.Kumar
	 */

	
	@Test(priority=2)	
	public void verifyPresenceOfPositionEntityAndNavigationToPositionHomePage() throws Exception {			
		HPT.redirectToPositionPage();
	}	
	
	/* Test case ID: 
	 * Test Case: verifyProductsHomePageAndPresenceOfAddButton
	 * Description: 1.This method verifies home page is loaded successfully or not. 
	 * 				2.It will take you to Position's home page and it will check presence of Add (Position add) button. 
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=3)	
	public void verifyPositionsHomePage() {
		String title = "Positions Active Positions - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
		
	}	
		
	
	/* Test case ID: NA
	 * Test Case: NA
	 * Description:This method provides data to create a Position
	 * author : Praveen.Kumar
	 */
	
	@DataProvider
	public Object[][] getAddPositionTestData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	/* Test case ID: 
	 * Test Case: verifyPositionCreation
	 * Description:This method verifies,Whether Position is getting created or not
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=4, dataProvider="getAddPositionTestData")	
	public void verifyPositionCreation(String pName, String pDescription, String pParentPosition, String pDescriptionEdit) throws Exception { 
//CREATING POSITION :
		clickOn(driver, PositionPage.createLnk, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(4000);
		driver.navigate().refresh();
		TestUtil.switchToFirstFrame();
		Thread.sleep(4000);
		clickOn(driver, PositionPage.nameEditBox, TestUtil.EXPLICIT_WAIT);
		PositionPage.nameEditBox.sendKeys(pName);
		
	    clickOn(driver, PositionPage.descriptionEditBox1, TestUtil.EXPLICIT_WAIT);
	    PositionPage.descriptionEditBox.click();
	    PositionPage.descriptionEditBox.sendKeys(pDescription);
	    clickOn(driver, PositionPage.tfFocusName, TestUtil.EXPLICIT_WAIT);
	    driver.switchTo().defaultContent();
	    Save();
	    Thread.sleep(4000);
	    driver.navigate().refresh();
	    TestUtil.alertWindow();
	    
	   }
	
	@DataProvider
	public Object[][] getEditPositionTestData(){
		Object[][] data = TestUtil.getTestData(sheetNameEdit);
		return data;
	}
	
	@Test(priority=5, dataProvider="getEditPositionTestData")	
	public void verifyParentSelection(String pNameEdit, String pDescriptionEdit, String pPositionbs) throws Exception { 
//Selecting Parent :
		TestUtil.switchToFirstFrame();
	    clickOn(driver, PositionPage.parentPositionDrpDwn1, TestUtil.EXPLICIT_WAIT);
	    PositionPage.parentPositionDrpDwn.click();
	    PositionPage.parentPositionDrpDwn.sendKeys(pPositionbs);
	    driver.switchTo().defaultContent();
	    Save();
	    Save();
	}

	
	@Test(priority=6)	
	public void verifyPositionDeactivation() throws IOException, InterruptedException {
		Thread.sleep(4000);
		clickOn(driver, PositionPage.lnkDeactivate, TestUtil.EXPLICIT_WAIT);
		TestUtil.alertWindow();
		TestUtil.switchToFirstFrame();
		String expected = "Inactive";
		Thread.sleep(4000);
	    String actal = PositionPage.txtStatus.getText();
	    System.out.println(actal);
	 
	    softAssert.assertEquals(actal,expected);
	    driver.switchTo().defaultContent();
	    
	}
	
	@Test(priority=7)	
	public void verifyPositionActivation() throws IOException, InterruptedException {
		Thread.sleep(4000);
		clickOn(driver, PositionPage.lnkActivate, TestUtil.EXPLICIT_WAIT);
		TestUtil.alertWindow();
		TestUtil.switchToFirstFrame();
		String expected = "Active";
		Thread.sleep(4000);
	    String actal = PositionPage.txtStatus.getText();
	    System.out.println(actal);
	 
	    softAssert.assertEquals(actal,expected);
	    driver.switchTo().defaultContent();
	}
	
	
	
	/* Test case ID: 
	 * Test Case: verifyUserAssociationToPosition
	 * Description:This method verifies,Whether we are able to associate User to Positions or not
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=8)	
	public void verifyBulkUsersAssociationToPosition() throws Exception {
// ASSOCIATING USERS IN BULK : 	
		clickOn(driver, PositionPage.ddNavigationToAssociate, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkNavigationToAddUser, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();
		System.out.println("inside Frame");
		driver.switchTo().frame("areaindskr_position_systemuserFrame");
		System.out.println("inside 2nd Frame");
		Thread.sleep(10000);
		clickOn(driver, PositionPage.lnkAddExistingUser, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkAddExistingUser, TestUtil.EXPLICIT_WAIT);
		PositionPage.tfInputUser.sendKeys(Keys.ENTER);
		clickOn(driver, PositionPage.lnkLookUpMore, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("InlineDialog_Iframe");
		System.out.println("inside inline Frame");
		Thread.sleep(4000);
		Select views = new Select(PositionPage.ddLookIn);
		views.selectByVisibleText("Administrative Access Users");
		clickOn(driver, PositionPage.chkBoxCheckAll, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.btnSelect, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.btnAdd, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		clickOn(driver, PositionPage.lnkPositionName, TestUtil.EXPLICIT_WAIT);
	}
	
	/* Test case ID: 
	 * Test Case: verifyCustomerAssociationToPosition
	 * Description:This method verifies,Whether we are able to associate Customer to Positions or not
	 */
	
	@Test(priority=9)	
	public void verifyBulkCustomerAssociationToPosition() throws Exception { 
// ASSOCIATING BULK CUSTOMERS :
		clickOn(driver, PositionPage.ddNavigationToAssociate, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkNavigationToAddCustomer, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();
		System.out.println("inside Frame");
		driver.switchTo().frame("areaindskr_position_contactFrame");
		System.out.println("inside 2nd Frame");
		Thread.sleep(4000);
		clickOn(driver, PositionPage.lnkAddExistingContact, TestUtil.EXPLICIT_WAIT);
		PositionPage.tfInputContact.sendKeys(Keys.ENTER);
		clickOn(driver, PositionPage.lnkLookUpMore, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("InlineDialog_Iframe");
		System.out.println("inside inline Frame");
		Thread.sleep(4000);
		Select views = new Select(PositionPage.ddLookIn);
		views.selectByVisibleText("My Contacts");
		clickOn(driver, PositionPage.chkBoxCheckAll, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.btnSelect, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.btnAdd, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		clickOn(driver, PositionPage.lnkPositionName, TestUtil.EXPLICIT_WAIT);
	}

		
	/* Test case ID: 
	 * Test Case: verifyProductAssociationToPosition
	 * Description:This method verifies,Whether we are able to associate Product to Positions or not
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=10)	
	public void verifyBulkProductAssociationToPosition() throws Exception {
// ASSOCIATING BULK PRODUCTS :
		clickOn(driver, PositionPage.ddNavigationToAssociate, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkNavigationToAddProduct, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();  
		System.out.println("inside Frame");
		driver.switchTo().frame("areaindskr_position_productFrame");
		System.out.println("inside 2nd Frame");
		Thread.sleep(4000);
		clickOn(driver, PositionPage.lnkAddExistingProduct, TestUtil.EXPLICIT_WAIT);
		PositionPage.tfInputProduct.sendKeys(Keys.ENTER);
		clickOn(driver, PositionPage.lnkLookUpMore, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("InlineDialog_Iframe");
		System.out.println("inside inline Frame");
		Thread.sleep(4000);
		Select views = new Select(PositionPage.ddLookIn);
		views.selectByVisibleText("My Brand Products");
		clickOn(driver, PositionPage.chkBoxCheckAll, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.btnSelect, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.btnAdd, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		clickOn(driver, PositionPage.lnkPositionName, TestUtil.EXPLICIT_WAIT);
	}
		
	/* Test case ID: 
	 * Test Case: verifyAccountAssociationToPosition
	 * Description:This method verifies,Whether we are able to associate Account to Positions or not
	 * author : Praveen.Kumar*/
	 
	
	@Test(priority=11)	
	public void verifyBulkAccountAssociationToPosition() throws Exception {
// ASSOCIATING BULK ACCOUNTS :
		clickOn(driver, PositionPage.ddNavigationToAssociate, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkNavigationToAddAccount, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();  
		System.out.println("inside Frame");
		driver.switchTo().frame("areaindskr_position_accountFrame");
		System.out.println("inside 2nd Frame");
		Thread.sleep(4000);
		clickOn(driver, PositionPage.lnkAddExistingAccount, TestUtil.EXPLICIT_WAIT);
		PositionPage.tfInputAccount.sendKeys(Keys.ENTER);
		clickOn(driver, PositionPage.lnkLookUpMore, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
				
		driver.switchTo().frame("InlineDialog_Iframe");
		System.out.println("inside inline Frame");
		Thread.sleep(4000);
		Select views = new Select(PositionPage.ddLookIn);
		views.selectByVisibleText("My Accounts");
		clickOn(driver, PositionPage.chkBoxCheckAll, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.btnSelect, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.btnAdd, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		clickOn(driver, PositionPage.lnkPositionName, TestUtil.EXPLICIT_WAIT);	
		driver.navigate().refresh();
	}
	
		
/*	 Test case ID: NA
	 * Test Case: NA
	 * Description:This method provides data to Edit a Position
	 * author : Praveen.Kumar*/
	 
	
	@Test(priority=12)	
	public void verifyBulkUsersDissociationToPosition() throws Exception {
// DISSOCIATING USERS IN BULK : 	
		
		clickOn(driver, PositionPage.ddNavigationToAssociate, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkNavigationToAddUser, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame(); 
		System.out.println("inside Frame");
		driver.switchTo().frame("areaindskr_position_systemuserFrame");
		System.out.println("inside 2nd Frame");
		Thread.sleep(4000);
		clickOn(driver, PositionPage.chkBoxCheckAllUsers, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(5000);
		clickOn(driver, PositionPage.lnkRemove, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("InlineDialog_Iframe");
		System.out.println("inside inline Frame");
		Thread.sleep(5000);
		clickOn(driver, PositionPage.btnRemove, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		clickOn(driver, PositionPage.lnkPositionName, TestUtil.EXPLICIT_WAIT);
		
	}
	
	@Test(priority=13)	
	public void verifyBulkContactsDissociationToPosition() throws Exception {
// DISSOCIATING CONTACTS IN BULK : 	
		
		clickOn(driver, PositionPage.ddNavigationToAssociate, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkNavigationToAddCustomer, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();  
		System.out.println("inside Frame");
		driver.switchTo().frame("areaindskr_position_contactFrame");
		System.out.println("inside 2nd Frame");
		Thread.sleep(6000);
		clickOn(driver, PositionPage.chkBoxCheckAllCustomers, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(6000);
		clickOn(driver, PositionPage.lnkRemove, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("InlineDialog_Iframe");
		System.out.println("inside inline Frame");
		Thread.sleep(6000);
		clickOn(driver, PositionPage.btnRemove, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		clickOn(driver, PositionPage.lnkPositionName, TestUtil.EXPLICIT_WAIT);
	}
	
	
	@Test(priority=14)	
	public void verifyBulkProductsDissociationToPosition() throws Exception {
// DISSOCIATING PRODUCTS IN BULK : 	
		
		clickOn(driver, PositionPage.ddNavigationToAssociate, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkNavigationToAddProduct, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();  
		System.out.println("inside Frame");
		driver.switchTo().frame("areaindskr_position_productFrame");
		System.out.println("inside 2nd Frame");
		Thread.sleep(4000);
		clickOn(driver, PositionPage.chkBoxCheckAllProducts, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(6000);
		clickOn(driver, PositionPage.lnkRemove, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("InlineDialog_Iframe");
		System.out.println("inside inline Frame");
		Thread.sleep(4000);
		clickOn(driver, PositionPage.btnRemove, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		clickOn(driver, PositionPage.lnkPositionName, TestUtil.EXPLICIT_WAIT);
	}
	
	@Test(priority=15)	
	public void verifyBulkAccountsDissociationToPosition() throws Exception {
// DISSOCIATING ACCOUNTS IN BULK : 	
		
		clickOn(driver, PositionPage.ddNavigationToAssociate, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.lnkNavigationToAddAccount, TestUtil.EXPLICIT_WAIT);
		TestUtil.switchToFirstFrame();  
		System.out.println("inside Frame");
		driver.switchTo().frame("areaindskr_position_accountFrame");
		System.out.println("inside 2nd Frame");
		Thread.sleep(4000);
		clickOn(driver, PositionPage.chkBoxCheckAllAccounts, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(3000);
		clickOn(driver, PositionPage.lnkRemove, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("InlineDialog_Iframe");
		System.out.println("inside inline Frame");
		Thread.sleep(4000);
		clickOn(driver, PositionPage.btnRemove, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		clickOn(driver, PositionPage.lnkPositionName, TestUtil.EXPLICIT_WAIT);
		driver.navigate().refresh();
		
	}
	
	@DataProvider
	public Object[][] getAssociatePositionTestData(){
		Object[][] data = TestUtil.getTestData(sheetNameAssociate);
		return data;
	}
	
	@Test(priority=16, dataProvider="getAssociatePositionTestData")	
	public void verifySingleUserAssociationToPosition(String hcpName,String userName, String product, String accountName) throws Exception { 
// ASSOCIATING SINGLE USER :    
	    TestUtil.switchToFirstFrame();
	    
	    System.out.println("inside Frame");
	    clickOn(driver, PositionPage.addUsersLnk, TestUtil.EXPLICIT_WAIT);
	    driver.switchTo().defaultContent();

	    driver.switchTo().frame("NavBarGloablQuickCreate");
	    System.out.println("inside Frame");
	    Thread.sleep(4000);
	    PositionPage.userNameEditBox.click();
		PositionPage.userNameEditBox.sendKeys(userName);
	    driver.switchTo().defaultContent();
	    Thread.sleep(3000);
	    clickOn(driver, PositionPage.saveBtn, TestUtil.EXPLICIT_WAIT);
	    clickOn(driver, PositionPage.saveBtn, TestUtil.EXPLICIT_WAIT);
	    Thread.sleep(3000);
	    driver.navigate().refresh();
	    TestUtil.alertWindow();
		/*getTitle(driver, title, TestUtil.EXPLICIT_WAIT);*/
	}
	
	@Test(priority=17, dataProvider="getAssociatePositionTestData")	
	public void verifySingleCustomerAssociationToPosition(String hcpName,String userName, String product, String accountName) throws Exception { 
// ASSOCIATING SINGLE CUSTOMER :	
		TestUtil.switchToFirstFrame(); 
		System.out.println("inside Frame");
		clickOn(driver, PositionPage.addContactsLnk, TestUtil.EXPLICIT_WAIT);	    
		driver.switchTo().defaultContent();	    
		driver.switchTo().frame("NavBarGloablQuickCreate");
		System.out.println("inside Frame");	       
    
		/*	clickOn(driver, PositionPage.hcpNameEditBox1, TestUtil.EXPLICIT_WAIT);*/
		PositionPage.hcpNameEditBox.click();
		PositionPage.hcpNameEditBox.sendKeys(hcpName);
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		clickOn(driver, PositionPage.saveBtn, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, PositionPage.saveBtn, TestUtil.EXPLICIT_WAIT);
		Thread.sleep(3000);
		driver.navigate().refresh();
		TestUtil.alertWindow();
		/*getTitle(driver, title, TestUtil.EXPLICIT_WAIT);*/
}

	@Test(priority=18, dataProvider="getAssociatePositionTestData")	
	public void verifySingleProductAssociationToPosition(String hcpName,String userName, String product, String accountName) throws Exception {  
//ASSOCIATING SINGLE PRODUCT :
	    TestUtil.switchToFirstFrame(); 
	    System.out.println("inside Frame");
	    clickOn(driver, PositionPage.addProductsLnk, TestUtil.EXPLICIT_WAIT);	    
	    driver.switchTo().defaultContent();	    
	    driver.switchTo().frame("NavBarGloablQuickCreate");
	    System.out.println("inside Frame");
	    
	    clickOn(driver, PositionPage.detailProductEditBox1, TestUtil.EXPLICIT_WAIT);
	    PositionPage.detailProductEditBox.click();
	    PositionPage.detailProductEditBox.sendKeys(product);
		
	    driver.switchTo().defaultContent();
	    clickOn(driver, PositionPage.saveBtn, TestUtil.EXPLICIT_WAIT);
	    clickOn(driver, PositionPage.saveBtn, TestUtil.EXPLICIT_WAIT);
	    Thread.sleep(3000);
	    driver.navigate().refresh();
	    TestUtil.alertWindow();
	}
	
	@Test(priority=19, dataProvider="getAssociatePositionTestData")	
	public void verifySingleAccountAssociationToPosition(String hcpName,String userName, String product, String accountName) throws Exception {
// ASSOCIATING SINGLE ACCOUNT :
	    TestUtil.switchToFirstFrame(); 
	    System.out.println("inside Frame");
	    clickOn(driver, PositionPage.addAccountssLnk, TestUtil.EXPLICIT_WAIT);	    
	    driver.switchTo().defaultContent();	    
	    driver.switchTo().frame("NavBarGloablQuickCreate");
	    System.out.println("inside Frame");    
	    
	    /*clickOn(driver, PositionPage.hcpNameEditBox1, TestUtil.EXPLICIT_WAIT);*/
	    PositionPage.hcpNameEditBox.click();
		PositionPage.hcpNameEditBox.sendKeys(accountName);
			    
	    driver.switchTo().defaultContent();
	    Thread.sleep(2000);
	    clickOn(driver, PositionPage.saveBtn, TestUtil.EXPLICIT_WAIT);
	    clickOn(driver, PositionPage.saveBtn, TestUtil.EXPLICIT_WAIT);
	    Thread.sleep(3000);
	    driver.navigate().refresh();
	    TestUtil.alertWindow();
	    driver.navigate().back();
	    
	}
	
	
	/* Test case ID: 
	 * Test Case: verifySearchOptionForPositions
	 * Description:This method verifies,Whether the created Position is showing in Product home page or not
	 * author : Praveen.Kumar*/
	 
	
	@Test(priority=20, dataProvider="getEditPositionTestData")	
	public void verifySearchOptionForPositions(String pName, String pDescription, String pPositionbs) throws Exception {
//SEARCH CREATED POSITION AND GET-IN :	
		driver.navigate().refresh();
		TestUtil.switchToFirstFrame();
		System.out.println("inside Frame");
		clickOn(driver, PositionPage.searchPositionLnk1, TestUtil.EXPLICIT_WAIT);
		PositionPage.searchPositionLnk1.clear();
		clickOn(driver, PositionPage.searchPositionLnk1, TestUtil.EXPLICIT_WAIT);
		PositionPage.searchPositionLnk1.sendKeys(pName);
		clickOn(driver, PositionPage.searchPositionLnk, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+pName+"']")).click();
		driver.switchTo().defaultContent();
	}
	
	/* Test case ID: 
	 * Test Case: verifyPositionEdit
	 * Description:This method verifies,Whether user is able to Edit details of a created position or not
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=21, dataProvider="getEditPositionTestData")	
	public void verifyPositionEdit(String pName, String pDescription, String pPositionbs) throws Exception {
//EDIT POSITION DETAILS :
		TestUtil.switchToSecondFrame();
		System.out.println("inside Frame inside Position Edit");
		Thread.sleep(6000);
		clickOn(driver, PositionPage.nameEditBox1, TestUtil.EXPLICIT_WAIT);
		PositionPage.nameEditBox.clear();
		PositionPage.nameEditBox.sendKeys(pName);
		
	    clickOn(driver, PositionPage.descriptionEditBox1, TestUtil.EXPLICIT_WAIT);
	    PositionPage.descriptionEditBox.click();
	    PositionPage.descriptionEditBox.clear();
	    PositionPage.descriptionEditBox.sendKeys(pDescription);
	    clickOn(driver, PositionPage.tfFocusName, TestUtil.EXPLICIT_WAIT);
	    driver.switchTo().defaultContent();
	    Save();
	    
	    
	}
	
	/* Test case ID: 
	 * Test Case: verifyUserDissociationFromPosition	
	 * Description:This method verifies,Whether are we able to dissociate user from Position or not
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=22, dataProvider="getAssociatePositionTestData")
	public void verifyUserDissociationFromPosition(String hcpName,String userName, String product, String accountName) throws Exception {
// DISSOCIATING SINGLE USER FROM POSITION :
		Thread.sleep(5000);
		TestUtil.switchToSecondFrame();
		WebElement user = driver.findElement(By.xpath("//span[text()='"+userName+"']"));
		TestUtil.mousehover(user);
	    clickOn(driver, PositionPage.dissociateSingleAssociations, TestUtil.EXPLICIT_WAIT);
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("InlineDialog_Iframe");
	    System.out.println("you are inside frame");
	    Thread.sleep(5000);
	    PositionPage.deleteBtn.click();
	    driver.switchTo().defaultContent();
	    driver.navigate().refresh();
	    
	}
	
	/* Test case ID: 
	 * Test Case: verifyProductDissociationFromPosition
	 * Description:This method verifies,Whether are we able to dissociate Product from Position or not
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=23, dataProvider="getAssociatePositionTestData")
	public void verifyProductDissociationFromPosition(String hcpName,String userName, String product, String accountName) throws Exception {
// DISSOCIATING SINGLE PRODUCT FROM POSITION :   
		TestUtil.switchToFirstFrame();
		Thread.sleep(5000);
		WebElement productVariable = driver.findElement(By.xpath("//span[text()='"+product+"']"));
		TestUtil.mousehover(productVariable);
	    clickOn(driver, PositionPage.dissociateSingleAssociations, TestUtil.EXPLICIT_WAIT);
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("InlineDialog_Iframe");
	    System.out.println("you are inside frame");
	    Thread.sleep(5000);
	    PositionPage.deleteBtn.click();
	    driver.switchTo().defaultContent();
	    driver.navigate().refresh();
	   
	}
	
	@Test(priority=24, dataProvider="getAssociatePositionTestData")
	public void verifyCustomerDissociationFromPosition(String hcpName,String userName, String product, String accountName) throws Exception {
// DISSOCIATING SINGLE CUSTOMER FROM POSITION :
	    TestUtil.switchToFirstFrame();
		WebElement hcpVariable = driver.findElement(By.xpath("//span[text()='"+hcpName+"']"));
		TestUtil.mousehover(hcpVariable);
	    PositionPage.dissociateSingleAssociations.click();
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("InlineDialog_Iframe");
	    System.out.println("you are inside frame");
	    Thread.sleep(5000);
	    PositionPage.deleteBtn.click();
	    driver.switchTo().defaultContent();
	    driver.navigate().refresh();
	    
	}
	
	/* Test case ID: 
	 * Test Case: verifyPresenceOfDeletedProduct
	 * Description:This method verifies,Whether are we able to dissociate Accounts from Position or not
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=25, dataProvider="getAssociatePositionTestData")
	public void verifyAccountDissociationFromPosition(String hcpName,String userName, String product, String accountName) throws Exception {
// DISSOCIATING SINGLE ACCOUNT FROM POSITION :
		TestUtil.switchToFirstFrame();
		Thread.sleep(5000);
		WebElement accountVariable = driver.findElement(By.xpath("//span[text()='"+accountName+"']"));
		TestUtil.mousehover(accountVariable);
	    clickOn(driver, PositionPage.dissociateSingleAssociations, TestUtil.EXPLICIT_WAIT);
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame("InlineDialog_Iframe");
	    System.out.println("you are inside frame");
	    Thread.sleep(5000);
	    PositionPage.deleteBtn.click();
	    driver.switchTo().defaultContent();
	    driver.navigate().refresh();
		
	}
	
	/* Test case ID: 
	 * Test Case: verifyPresenceOfDeletedProduct
	 * Description:This method verifies,Whether we are able to delete Position or not
	 * author : Praveen.Kumar
	 */
	
	@Test(priority=26)	
	public void verifyPositionDelete() throws InterruptedException, IOException {
// DELETING POSITION :	
		Delete();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
	

