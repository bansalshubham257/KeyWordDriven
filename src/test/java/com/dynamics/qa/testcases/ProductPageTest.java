/**
 *@author : Praveen.Kumar
 *@description : Home Page - Test cases (All Product related test cases has been written here) 
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.pages.ProductPage;
import com.dynamics.qa.util.TestUtil;

public class ProductPageTest extends TestBase {
		LoginPage loginPage;
		HomePage homePage;
	    TestUtil testUtil;
		HomePageTest homePageTest;
		ProductPage productPage;
		
		SoftAssert softAssert = new SoftAssert();
		
		HomePageTest HPT = new HomePageTest();
		
		String sheetNameAddProduct = "addProduct";
		String sheetNameEditProduct = "editProduct";
		

		public ProductPageTest() {
			super();
		}

		
/* Test case ID: NA
 * Description:This method is to launch URL,Login and navigate to IO home page
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
		
/* Test case ID: 
 * Description:This method is to navigate to Product's home page from IO home page
 * author : Praveen.Kumar
 */
		
		@Test(priority=2)	
		public void verifyPresenceOfProductsEntityAndNavigationToProductHomePage() {	
			
			HPT.redirectToProductPage();
		}
		
/* Test case ID: 
 * Description: 1.This method verifies home page is loaded successfully or not. 
 * 				2.It will take you to Products home page and it will check presence of Add (Product add) button.
 * author : Praveen.Kumar 
*/
		
		@Test(priority=3)	
		public void verifyProductsHomePage() {
			
			String title = "Products Active Brand Products - Microsoft Dynamics 365";
			getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
			
		}
		
/* Test case ID: NA
 * Description:This method provides data to create a Product
 * author : Praveen.Kumar 
 */
		@DataProvider
		public Object[][] getCreateProductTestData(){
			Object[][] data = TestUtil.getTestData(sheetNameAddProduct);
			return data;
		}
		
/* Test case ID: 
 * Description:This method verifies creation of New Product 
 * author : Praveen.Kumar
 */
		@Test(priority=4, dataProvider="getCreateProductTestData")
		public void verifyCreationOfNewProduct(String fName, String prodId, String desc, String consentTerms, String keyMessage) throws IOException, InterruptedException{
			
			clickOn(driver, ProductPage.btnAddProduct, TestUtil.EXPLICIT_WAIT);
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver.switchTo().frame("contentIFrame0");
			System.out.println("inside frame");
			Thread.sleep(6000);
			clickOn(driver, ProductPage.tf1Name, TestUtil.EXPLICIT_WAIT);
			ProductPage.tfName.clear();
		    ProductPage.tfName.sendKeys(fName);
			
		    clickOn(driver, ProductPage.tf1ProductId, TestUtil.EXPLICIT_WAIT);
		    ProductPage.tfProductId.clear();
		    ProductPage.tfProductId.sendKeys(prodId);
		    
		    clickOn(driver, ProductPage.tf1Description, TestUtil.EXPLICIT_WAIT);
		    ProductPage.tfDescription.clear();
		    ProductPage.tfDescription.sendKeys(desc);
		    
/*		    clickOn(driver, ProductPage.tf1ConsentTerms, TestUtil.EXPLICIT_WAIT);
		    ProductPage.tfConsentTerms.clear();
		    ProductPage.tfConsentTerms.sendKeys(consentTerms);*/
		
		    driver.switchTo().defaultContent();
		    Save();

		   
		}
		
/*Test case ID: 
 * Description:This method verifies,Whether we are able to Publish a Product after we edit or not
 * author : Praveen.Kumar
 */
						
		@Test(priority=5)
		public void verifyActivationOfProduct() throws Exception {
			
			Thread.sleep(3000);
		    clickOn(driver, ProductPage.lnkPublish, TestUtil.EXPLICIT_WAIT);
		    driver.switchTo().frame("InlineDialog_Iframe");
		    System.out.println("you are inside frame");
		    Thread.sleep(6000);
		    ProductPage.btnPublish.click();
		    driver.switchTo().defaultContent();
		    driver.navigate().refresh();
		    TestUtil.switchToFirstFrame();
		    String expected = "Active";
		    Thread.sleep(4000);
		    String actual = ProductPage.txtStatus.getText();
		    System.out.println(actual);
		 
		    softAssert.assertEquals(actual,expected);
		    
		    softAssert.assertAll();
		    
		    driver.switchTo().defaultContent(); 
		    driver.navigate().refresh();
		    
		}
		
/* Test case ID: 
 * Description:This method verifies Association of key message to Product 
 * author : Praveen.Kumar
 */		
		
		@Test(priority=6, dataProvider="getCreateProductTestData")
		public void verifyAssociationOfKeyMessage(String fName, String prodId, String desc, String consentTerms, String keyMessage) throws IOException, InterruptedException{
			
			driver.switchTo().frame("contentIFrame0");
			System.out.println("inside frame 0");
			Thread.sleep(4000);
			clickOn(driver, ProductPage.addKeyMessagesLnk, TestUtil.EXPLICIT_WAIT);
			ProductPage.tfSearch.sendKeys(keyMessage);
			ProductPage.tfSearch.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//a[@title='"+keyMessage+"']")).click();
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			SaveAndClose();
		}	
			
/* Test case ID: 
 * Description:This method verifies that we are able to search created product and click on it. 
 * author : Praveen.Kumar
 */
		
		@Test(priority=7, dataProvider="getCreateProductTestData")	
		public void verifySearchOptionForProducts(String fName, String prodId, String desc, String consentTerms, String keyMessage) throws Exception {
			
			driver.navigate().refresh();
			String title = "Products Active Brand Products - Microsoft Dynamics 365";
			getTitle(driver, title, TestUtil.EXPLICIT_WAIT);
			TestUtil.switchToFirstFrame();
			clickOn(driver, ProductPage.lnk1SearchProduct, TestUtil.EXPLICIT_WAIT);
			ProductPage.lnk1SearchProduct.clear();
			clickOn(driver, ProductPage.lnk1SearchProduct, TestUtil.EXPLICIT_WAIT);
			ProductPage.lnk1SearchProduct.sendKeys(fName);
			clickOn(driver, ProductPage.lnkSearchProduct, TestUtil.EXPLICIT_WAIT);
			driver.findElement(By.xpath("//a[@title='"+fName+"']")).click();
			driver.switchTo().defaultContent();
			
		}
		
/*Test case ID: NA
 * Description:This method provides data to Edit a Product 
 * author : Praveen.Kumar
 */
		 
		
		@DataProvider
		public Object[][] getEditProductTestData(){
			Object[][] data = TestUtil.getTestData(sheetNameEditProduct);
			return data;
		}
		
/*Test case ID: 
 * Description:This method verifies whether we are able to Edit a Product or not 
 * author : Praveen.Kumar
 */
		@Test(priority=8, dataProvider="getEditProductTestData")
		public void verifyProductEdit(String fName, String prodId, String desc, String consentTerms) throws IOException, InterruptedException {
			
			driver.switchTo().frame("contentIFrame1");
			System.out.println("inside frame");
			Thread.sleep(3000);
			clickOn(driver, ProductPage.tf1Name, TestUtil.EXPLICIT_WAIT);
			clickOn(driver, ProductPage.tfName, TestUtil.EXPLICIT_WAIT);
			ProductPage.tfName.clear();
		    ProductPage.tfName.sendKeys(fName);
		   
		    clickOn(driver, ProductPage.tf1ProductId, TestUtil.EXPLICIT_WAIT);
		    clickOn(driver, ProductPage.tfProductId, TestUtil.EXPLICIT_WAIT);
		    ProductPage.tfProductId.clear();
		    ProductPage.tfProductId.sendKeys(prodId);
		    
		    clickOn(driver, ProductPage.tf1Description, TestUtil.EXPLICIT_WAIT);
		    ProductPage.tfDescription.clear();
		    ProductPage.tfDescription.sendKeys(desc);
			
		    clickOn(driver, ProductPage.tf1Name, TestUtil.EXPLICIT_WAIT);
			
			
			 driver.switchTo().defaultContent();
			 Save();
			 Save();
		    
		}  
				
/*Test case ID: 
 * Description:This method verifies,Whether we are able delete created Product or not
 * author : Praveen.Kumar
 */
		@Test(priority=9)	
		public void verifyProductDelete() throws InterruptedException, IOException {	
			
			Thread.sleep(3000);
			Delete();
		    Thread.sleep(3000);
		}
		
/*Test case ID: 
 * Description:This method verifies,Whether the deleted Product is showing is Product home page or not
 * author : Praveen.Kumar*/
		 
		@Test(priority=10, dataProvider="getEditProductTestData")	
		public void verifyPresenceOfDeletedProduct(String fName, String prodId, String desc, String consentTerms) throws InterruptedException, IOException {	 
			
			driver.navigate().refresh();
		    TestUtil.switchToFirstFrame();
		    Thread.sleep(4000);
		    
		    clickOn(driver, ProductPage.lnk1SearchProduct, TestUtil.EXPLICIT_WAIT);
			ProductPage.lnk1SearchProduct.clear();
			clickOn(driver, ProductPage.lnk1SearchProduct, TestUtil.EXPLICIT_WAIT);
			ProductPage.lnk1SearchProduct.sendKeys(fName);
			clickOn(driver, ProductPage.lnkSearchProduct, TestUtil.EXPLICIT_WAIT);
		    /*softAssert.fail("Purposely Failed This Case");
		    WebDriverWait wait = new WebDriverWait(driver, 240); 
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='AutomationAsperine']")));
		    softAssert.assertFalse(ProductPage.createdProductLnkDelete.isDisplayed(), "Bug!! The element is appeared");*/
		    
		    List<WebElement> list= driver.findElements(By.xpath("//a[text()='"+fName+"']"));
		    System.out.println(list.size());
		    softAssert.assertEquals(0, list.size());
		    softAssert.assertAll();
		    
		}

		@AfterClass
		public void tearDown(){
			driver.quit();
		}
}



/*clickOn(driver, ProductPage.btnSaveAndClose, TestUtil.EXPLICIT_WAIT);
TestUtil.alertWindow();
clickOn(driver, ProductPage.dp1From, TestUtil.EXPLICIT_WAIT);
ProductPage.dpFrom.click();
ProductPage.dpFrom.sendKeys(fromDate);

clickOn(driver, ProductPage.dp1To, TestUtil.EXPLICIT_WAIT);
ProductPage.dpTo.click();
ProductPage.dpTo.sendKeys(toDate);
		    
clickOn(driver, ProductPage.dd1Type, TestUtil.EXPLICIT_WAIT);
clickOn(driver, ProductPage.ddType, TestUtil.EXPLICIT_WAIT);
Select select = new Select(ProductPage.ddType);
select.selectByVisibleText("Detail");
clickOn(driver, ProductPage.tf1UnitGroup, TestUtil.EXPLICIT_WAIT);
ProductPage.tfUnitGroup.click();
ProductPage.tfUnitGroup.sendKeys(unitGroup);

clickOn(driver, ProductPage.tf1DefaultGroup, TestUtil.EXPLICIT_WAIT);
clickOn(driver, ProductPage.tf1DefaultGroup, TestUtil.EXPLICIT_WAIT);
ProductPage.tfDefaultGroup.click();
ProductPage.tfDefaultGroup.sendKeys(defaultGroup);*/
