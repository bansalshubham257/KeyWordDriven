	/**
	 *@author : Praveen.Kumar
	 *@description : Position Page - WebElements (All webelements of Position related pages has been found here) 
	 *@class : PositionPage
	 */
package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class PositionPage extends TestBase{
	
//==========================/////////////////CREATING POSITION //////////////////////===================================//
	
	/*@object Name : 'New' Link
	 *@description : 'New' Link will be visible in Settings >> Security page
	 *author : Praveen.Kumar
	 */
	
	@FindBy(xpath="//a//span[text()=' New ']")
	public static
	WebElement createLnk;
	
	/*@object Name : 'Name' text field
	 *@description : 'New' Link will be visible in Settings >> Security page
	 *author : Praveen.Kumar
	 */
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Name_label\"]")
	public static
	WebElement nameEditBox1;
	
	@FindBy(id="name")
	public static
	WebElement tfFocusName;
	
	@FindBy(id="name_i")
	public static
	WebElement nameEditBox;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Description_label\"]")
	public static
	WebElement descriptionEditBox1;
	
	@FindBy(id="description_i")
	public static
	WebElement descriptionEditBox;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Parent Position_label\"]//following-sibling::span//span[@id=\"parentpositionid_lookupValue\"]")
	public static
	WebElement parentPositionDrpDwn1;
	
	@FindBy(id="parentpositionid_ledit")
	public static
	WebElement parentPositionDrpDwn;
	
	@FindBy(xpath="//a//span[text()=' Save ']")
	public static
	WebElement saveLink;

// ASSOCIATING SINGLE CUSTOMER :
	@FindBy(xpath="//a[@id='Contacts_addImageButton']")
	public static
	WebElement addContactsLnk;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Customer_label\"]//following-sibling::span//span[@id=\"indskr_customerid_lookupValue\"]")
	public static
	WebElement hcpNameEditBox1;
	
	@FindBy(id="indskr_customerid_ledit")
	public static
	WebElement hcpNameEditBox;

	
	@FindBy(id="globalquickcreate_save_button_NavBarGloablQuickCreate")
	public static
	WebElement saveBtn;
	
// ASSOCIATING BULK CUSTOMERS :
	@FindBy(id="TabNode_tab0Tab")
	public static
	WebElement ddNavigationToAssociate;
	
	@FindBy(id="Node_nav_indskr_position_contact")
	public static
	WebElement lnkNavigationToAddCustomer;
	
	@FindBy(xpath="//a//span[contains(text(),'Add Existing Contact')]")
	public static
	WebElement lnkAddExistingContact;
	
	@FindBy(id="lookup_crmGrid_indskr_position_contact_ledit")
	public static
	WebElement tfInputContact;
	
	@FindBy(xpath="//a[@title='Look Up More Records']//span//nobr//span[contains(text(),'Look Up More Records')]")
	public static
	WebElement lnkLookUpMore;
	
	@FindBy(id="showMyRecords")
	public static
	WebElement chkBoxShowMyRecords;
	
	@FindBy(id="crmGrid_gridBodyTable_checkBox_Image_All")
	public static
	WebElement chkBoxCheckAll;
	
	@FindBy(id="btnAdd")
	public static
	WebElement btnSelect;
	
	@FindBy(id="butBegin")
	public static
	WebElement btnAdd;
	
	@FindBy(id="TabNode_tab0Tab-main")
	public static
	WebElement lnkPositionName;
	
	@FindBy(xpath="//a[@title='Automation HCP']")
	public static
	WebElement lnkAddHCP;

// ASSOCIATING SINGLE USER:
	@FindBy(xpath="//a[@id='MEMBERS_addImageButton']")
	public static
	WebElement addUsersLnk;
	
	@FindBy(id="indskr_primaryposition_i")
	public static
	WebElement primaryCheckBox;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"User_label\"]//following-sibling::span//span[@id=\"indskr_userid_lookupValue\"]")
	public static
	WebElement userNameEditBox1;
	
	@FindBy(id="indskr_userid_ledit")
	public static
	WebElement userNameEditBox;
	
// ASSOCIATING BULK USERS:
	@FindBy(id="Node_nav_indskr_position_systemuser")
	public static
	WebElement lnkNavigationToAddUser;
	
	@FindBy(xpath="//a//span[contains(text(),'Add Existing User')]")
	public static
	WebElement lnkAddExistingUser;
	
	@FindBy(id="lookup_crmGrid_indskr_position_systemuser_ledit")
	public static
	WebElement tfInputUser;
	
// ASSOCIATING SINGLE PRODUCT:
	@FindBy(xpath="//a[@id='AssignedDetailProducts_addImageButton']")
	public static
	WebElement addProductsLnk;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Product_label\"]//following-sibling::span//span[@id=\"indskr_productid_lookupValue\"]")
	public static
	WebElement detailProductEditBox1;
	
	@FindBy(id="indskr_productid_ledit")
	public static
	WebElement detailProductEditBox;
	
// ASSOCIATING BULK PRODUCTS:
	@FindBy(id="Node_nav_indskr_position_product")
	public static
	WebElement lnkNavigationToAddProduct;
	
	@FindBy(xpath="//a//span[contains(text(),'Add Existing Product')]")
	public static
	WebElement lnkAddExistingProduct;
	
	@FindBy(id="lookup_crmGrid_indskr_position_product_ledit")
	public static
	WebElement tfInputProduct;
	
	@FindBy(id="crmGrid_SavedQuerySelector")
	public static
	WebElement ddLookIn;
	
// ASSOCIATING SINGLE ACCOUNT :
	@FindBy(xpath="//a[@id='Accounts_addImageButton']")
	public static
	WebElement addAccountssLnk;

// ASSOCIATING BULK ACCOUNTS :
	@FindBy(id="Node_nav_indskr_position_account")
	public static
	WebElement lnkNavigationToAddAccount;
	
	@FindBy(xpath="//a//span[contains(text(),'Add Existing Account')]")
	public static
	WebElement lnkAddExistingAccount;
	
	@FindBy(id="lookup_crmGrid_indskr_position_account_ledit")
	public static
	WebElement tfInputAccount;
	
// EDIT POSITION :
	@FindBy(xpath="//input[@id=\"crmGrid_findCriteria\"]")
	public static
	WebElement searchPositionLnk1;
	
	@FindBy(xpath="//a[@id=\"crmGrid_findCriteriaButton\"]")
	public static
	WebElement searchPositionLnk;
		
// DISSOCIATING BULK USERS/ACCOUNTS/CONTACTS/PRODUCTS :
	@FindBy(xpath="//a//span[text()=' Remove ']")
	public static
	WebElement lnkRemove;
	
	@FindBy(id="crmGrid_indskr_position_systemuser_gridBodyTable_checkBox_Image_All")
	public static
	WebElement chkBoxCheckAllUsers;
	
	@FindBy(id="crmGrid_indskr_position_contact_gridBodyTable_checkBox_Image_All")
	public static
	WebElement chkBoxCheckAllCustomers;
	
	@FindBy(id="crmGrid_indskr_position_product_gridBodyTable_checkBox_Image_All")
	public static
	WebElement chkBoxCheckAllProducts;
	
	@FindBy(id="crmGrid_indskr_position_account_gridBodyTable_checkBox_Image_All")
	public static
	WebElement chkBoxCheckAllAccounts;
	
	@FindBy(id="butBegin")
	public static
	WebElement btnRemove;
	
// DISSOCIATING SINGLE ASSOCIATIONS (USER/HCP/PRODUCT/CUSTOMER) :
	@FindBy(xpath="//a[@title=\"Delete\"]")
	public static
	WebElement dissociateSingleAssociations;	

	@FindBy(xpath="//div[starts-with(@class,'ms-crm-RefreshDialog-Footer')]//button[@id=\"butBegin\"]")
	public static
	WebElement deleteBtn;
	
// DELETING POSITION :
	@FindBy(xpath="//a//span[text()=\" Delete \"]")
	public static
	WebElement deletePositionLnk;
	
// DEACTIVATING AND ACTIVATING POSITION :
	@FindBy(xpath="//a//span[text()=\" Deactivate \"]")
	public static
	WebElement lnkDeactivate;
	
	@FindBy(id="Status_label")
	public static
	WebElement txtStatus;
	
	@FindBy(xpath="//a//span[text()=\" Activate \"]")
	public static
	WebElement lnkActivate;
	
	// Initializing the Page Objects:
	
	public PositionPage() {
		PageFactory.initElements(driver, this);
	}
	
}
