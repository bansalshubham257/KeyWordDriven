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
import com.dynamics.qa.pages.KeyMessagePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.ProductPage;
import com.dynamics.qa.util.TestUtil;

public class KeyMessagePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
    HomePageTest homePageTest;
    KeyMessagePage keyMessagePage;
    ProductPage productPage;
    
    HomePageTest HPT = new HomePageTest();
    ProductPageTest PPT = new ProductPageTest();
	
	String sheetNameAddKeyMessage = "addKeyMessage";
	String sheetNameAddProduct = "addProduct";
	
	SoftAssert softAssert = new SoftAssert();
	
	public KeyMessagePageTest() {
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
		productPage = new ProductPage();
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
	public void verifyPresenceOfKeyMessagesEntityAndNavigationToKeyMessageHomePage() throws Exception {			
		
		HPT.redirectToKeyMessagePage();
	}
	
	@Test(priority=3)	
	public void verifyKeyMessageHomePageAndPresenceOfAddButton() throws Exception {
		
		String title = "Key Messages All Key Messages - Microsoft Dynamics 365";
		getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
		clickOn(driver, KeyMessagePage.btnNew, TestUtil.EXPLICIT_WAIT);
		
	}
	
	@DataProvider
	public Object[][] getAddKeyMessageTestData(){
		Object[][] data = TestUtil.getTestData(sheetNameAddKeyMessage);
		return data;
	}
	
	/* Test case ID: 
	 * Test Case: verifyCreationOfNewProduct
	 * Description:This method verifies creation of New Product 
	 * author : Praveen.Kumar
	 */

	@Test(priority=4, dataProvider="getAddKeyMessageTestData")
	public void verifyCreationOfNewKeyMessage(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws IOException, InterruptedException {
		
		driver.switchTo().frame("contentIFrame1");
		System.out.println("inside frame");
		Thread.sleep(12000);
		KeyMessagePage.tfName.sendKeys(fName);
		
	    clickOn(driver, KeyMessagePage.tf1Description, TestUtil.EXPLICIT_WAIT);
	    KeyMessagePage.tfDescription.click();
	    KeyMessagePage.tfDescription.sendKeys(desc);
	    
	    driver.switchTo().defaultContent();
	    Save();
	    driver.navigate().refresh();
	    TestUtil.alertWindow();
	}	
	
	@Test(priority=5)
	public void verifyProductAssociationInKeyMessage() throws IOException, InterruptedException {
		
		TestUtil.switchToFirstFrame();
		System.out.println("Inside 1st frame");
		driver.switchTo().frame("WebResource_products");
		System.out.println("WebResource_products");
		Thread.sleep(4000);
		clickOn(driver, KeyMessagePage.chkBoxAutomationProduct, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		Save();
	}
		
	@Test(priority=6, dataProvider="getAddKeyMessageTestData")	
	public void verifySearchOptionForProducts(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws Exception {
		
		HPT.redirectToProductPage();
		PPT.verifySearchOptionForProducts(productName, descEdit, desc, fNameEdit, keyMessageName);
	}
	
	@Test(priority=7, dataProvider="getAddKeyMessageTestData")
	public void verifyKeyMessageAssociationInProduct(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws IOException, InterruptedException {
		
		driver.switchTo().defaultContent();
		TestUtil.switchToSecondFrame();
		List<WebElement> list= driver.findElements(By.xpath("//a[text()='"+fName+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(1, list.size());
		softAssert.assertAll();
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=8, dataProvider="getAddKeyMessageTestData")
	public void verifyKeyMessageSearch(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws IOException, InterruptedException {
		
		HPT.redirectToKeyMessagePage();
		driver.navigate().refresh();
		TestUtil.switchToFirstFrame();
		Thread.sleep(5000);
		clickOn(driver, KeyMessagePage.lnk1SearchKeyMessage, TestUtil.EXPLICIT_WAIT);
		KeyMessagePage.lnk1SearchKeyMessage.clear();
		clickOn(driver, KeyMessagePage.lnk1SearchKeyMessage, TestUtil.EXPLICIT_WAIT);
		KeyMessagePage.lnk1SearchKeyMessage.sendKeys(keyMessageName);
		clickOn(driver, KeyMessagePage.lnkSearchKeyMessage, TestUtil.EXPLICIT_WAIT);
		driver.findElement(By.xpath("//a[@title='"+fName+"']")).click();
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=9, dataProvider="getAddKeyMessageTestData")
	public void verifyKeyMessageDissociation(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws IOException, InterruptedException {
		
		driver.navigate().refresh();
		TestUtil.switchToFirstFrame();
		System.out.println("Inside 1st frame");
		driver.switchTo().frame("WebResource_products");
		System.out.println("WebResource_products");
		Thread.sleep(4000);
		clickOn(driver, KeyMessagePage.chkBoxAutomationProduct, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		Save();
	}
	
	@Test(priority=10, dataProvider="getAddKeyMessageTestData")
	public void verifyKeyMessageDissociationInProduct(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws Exception {
		
		verifySearchOptionForProducts(fName, desc, productName, keyMessageName, fNameEdit, descEdit);
		TestUtil.alertWindow();
		TestUtil.switchToSecondFrame();
		Thread.sleep(4000);
		List<WebElement> list= driver.findElements(By.xpath("//a[text()='"+fName+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(0, list.size());
		softAssert.assertAll();
		driver.switchTo().defaultContent();
		verifyKeyMessageSearch(fName, desc, productName, keyMessageName, fNameEdit, descEdit);
	}
	
	@Test(priority=11, dataProvider="getAddKeyMessageTestData")
	public void verifyKeyMessageEdit(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws IOException, InterruptedException {
		
		driver.switchTo().frame("contentIFrame1");
		System.out.println("inside frame");
		Thread.sleep(4000);
		clickOn(driver, KeyMessagePage.tfName1, TestUtil.EXPLICIT_WAIT);
		KeyMessagePage.tfName.clear();
		KeyMessagePage.tfName.sendKeys(fNameEdit);
		
	    clickOn(driver, KeyMessagePage.tf1Description, TestUtil.EXPLICIT_WAIT);
	    KeyMessagePage.tfDescription.click();
	    KeyMessagePage.tfDescription.clear();
	    KeyMessagePage.tfDescription.sendKeys(desc);
	    clickOn(driver, KeyMessagePage.tfName1, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().frame("WebResource_products");
		System.out.println("WebResource_products");
		Thread.sleep(4000);
		clickOn(driver, KeyMessagePage.chkBoxAutomationProduct, TestUtil.EXPLICIT_WAIT);
		driver.switchTo().defaultContent();
		Save();
		TestUtil.alertWindow();
	    
	}
	
	@Test(priority=12)	
	public void verifyKeyMessageDelete() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		Delete();
	    TestUtil.alertWindow();
	    Thread.sleep(3000);
	    driver.navigate().refresh();
	    TestUtil.alertWindow();
	}
	
	@Test(priority=13, dataProvider="getAddKeyMessageTestData")	
	public void verifyPresenceOfDeletedKeyMessage(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws InterruptedException, IOException {	    
	    
		TestUtil.switchToFirstFrame();
	    Thread.sleep(5000);
	    List<WebElement> list= driver.findElements(By.xpath("//a[text()='"+fNameEdit+"']"));
	    System.out.println(list.size());
	    softAssert.assertEquals(0, list.size());
	    softAssert.assertAll();
	    driver.switchTo().defaultContent();
	    
	}
	
	@Test(priority=14, dataProvider="getAddKeyMessageTestData")
	public void verifyKeyMessageDeletionInProduct(String fName, String desc, String productName, String keyMessageName, String fNameEdit,
			String descEdit) throws Exception {
		
		verifySearchOptionForProducts(fName, desc, productName, keyMessageName, fNameEdit, descEdit);
		TestUtil.switchToSecondFrame();
		List<WebElement> list= driver.findElements(By.xpath("//a[text()='"+fNameEdit+"']"));
		System.out.println(list.size());
		softAssert.assertEquals(0, list.size());
		softAssert.assertAll();
		driver.switchTo().defaultContent();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
