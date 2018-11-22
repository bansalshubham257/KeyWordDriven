package com.dynamics.qa.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.pages.HomePage;
import com.dynamics.qa.pages.LoginPage;
import com.dynamics.qa.util.TestUtil;

public class BaseSetupTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
    HomePageTest homePageTest;
    SoftAssert softAssert = new SoftAssert();
    
    ContactPageTest CPT = new ContactPageTest();
    HomePageTest HPT = new HomePageTest();
    ProductPageTest PPT = new ProductPageTest();
    PositionPageTest PSPT = new PositionPageTest();
    PositionGroupPageTest PGT = new PositionGroupPageTest();
    
    String sheetNameContact = "bsContact";
    String sheetNameProduct = "bsProduct";
    String sheetParentPosition = "bsPositionAdd";
    String sheetChildPosition = "bsPositionChild";
    String sheetAssociatePosition = "bsPositionAssciation";
    String sheetPositionGroup = "bsPositionGroupAdd";
	
    
    public BaseSetupTest() {
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
	
	@DataProvider
	public Object[][] getCreateProductTestData(){
		Object[][] data = TestUtil.getBaseSetupTestData(sheetNameProduct);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCreateProductTestData")
	public void productCreation(String fName, String prodId, String desc, String consentTerms, String keyMessage) throws Exception{
		
		HPT.redirectToProductPage();
		PPT.verifyCreationOfNewProduct(fName, prodId, desc, consentTerms, keyMessage);
		PPT.verifyActivationOfProduct();
	}
	
	@DataProvider
	public Object[][] getAddPositionTestDataParent(){
		Object[][] data = TestUtil.getBaseSetupTestData(sheetParentPosition);
		return data;
	}
	
	@Test(priority=3, dataProvider="getAddPositionTestDataParent")	
	public void positionCreation(String hcpName, String pDescription, String pParentPosition,String pDescriptionEdit) throws Exception {
		HPT.redirectToPositionPage();
		PSPT.verifyPositionCreation(hcpName, pDescription, pParentPosition, pDescriptionEdit);
		
	}
	
	@DataProvider
	public Object[][] getAddPositionTestDataChild(){
		Object[][] data = TestUtil.getBaseSetupTestData(sheetChildPosition);
		return data;
	}
	
	@Test(priority=4, dataProvider="getAddPositionTestDataChild")	
	public void SelectingParentPosition(String pNameEdit, String pDescriptionEdit, String pPositionbs) throws Exception {
		PSPT.verifyParentSelection(pNameEdit, pDescriptionEdit, pPositionbs);
	}
	
	@DataProvider
	public Object[][] getAssociatePositionTestData(){
		Object[][] data = TestUtil.getBaseSetupTestData(sheetAssociatePosition);
		return data;
	}	
	
	@Test(priority=5, dataProvider="getAssociatePositionTestData")	
	public void userContactProductAssciation(String hcpName,String userName, String product, String accountName) throws Exception {
		PSPT.verifySingleUserAssociationToPosition(hcpName, userName, product, accountName);
		PSPT.verifySingleProductAssociationToPosition(hcpName, userName, product, accountName);
	}
	

	@DataProvider
	public Object[][] getAddContactTestData(){
		Object[][] data = TestUtil.getBaseSetupTestData(sheetNameContact);
		return data;
	}
	
	@Test(priority=6, dataProvider="getAddContactTestData")	
	public void contactCreation(String firstName, String secondName, String middleName, String suffix, String prfdesignation,String preferredLanguage,
			String primarySpeciality, String bPhone, String mPhone, String email, String ePD, String ePS, String eBP, String eMP, String position) throws Exception {
		
		CPT.verifyPresenceOfContactEntityAndNavigationToContactsHomePage();
		CPT.verifyContactCreation(firstName, secondName, middleName, suffix, prfdesignation, preferredLanguage, primarySpeciality, bPhone, mPhone, email, ePD, ePS, eBP, eMP, position);
	}
	
	@DataProvider
	public Object[][] getAddPositionGroupTestData(){
		Object[][] data = TestUtil.getBaseSetupTestData(sheetPositionGroup);
		return data;
	}
	
	@Test(priority=7, dataProvider="getAddPositionGroupTestData")	
	public void positionGroupCreation(String pgName,String pgDescription, String position, String emailTemplate) throws Exception {
		HPT.redirectToPositionGroupPage();
		PGT.verifyPositionGroupCreation(pgName, pgDescription);
		PGT.verifyPositionAssociation(pgName, pgDescription, position, emailTemplate);
	}
	
	
}
