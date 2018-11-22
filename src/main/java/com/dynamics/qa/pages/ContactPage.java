package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class ContactPage extends TestBase{
	
//NEW :
	@FindBy(xpath="//span[@class='ms-crm-CommandBar-Menu' and text()=' New ']")
	public static
	WebElement btnNew;
	
//Title :		
	@FindBy(id="Title_label")
	public static
	WebElement ddType1;
	
	@FindBy(id="indskr_title_i")
	public static
	WebElement ddType;
	
//Name :	
	@FindBy(id="Full Name_label")
	public static
	WebElement tfName1;
	
	@FindBy(id="fullname_compositionLinkControl_firstname_i")
	public static
	WebElement tfFirstName;
	
	@FindBy(id="Last Name_label")
	public static
	WebElement tfLastName1;
	
	@FindBy(id="fullname_compositionLinkControl_lastname_i")
	public static
	WebElement tfLastName;
	
	@FindBy(id="fullname_compositionLinkControl_flyoutLoadingArea-confirm")
	public static
	WebElement btnDone;

//Middle Name :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Middle Name_label\"]")
	public static
	WebElement tfMiddleName1;
	
	@FindBy(id="middlename_i")
	public static
	WebElement tfMiddleName; 
	
//Suffix : 
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Suffix_label\"]")
	public static
	WebElement tfSuffix1;
	
	@FindBy(id="suffix_i")
	public static
	WebElement tfSuffix; 
	
//Professional Designation :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/span/span[@id=\"indskr_lu_professional_designationid_lookupValue\"]")
	public static
	WebElement tfProfessionalDesignation1;
	
	@FindBy(id="indskr_lu_professional_designationid_ledit")
	public static
	WebElement tfProfessionalDesignation;
	
//Preferred Language :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/span/span[@id=\"indskr_lu_languageid_lookupValue\"]")
	public static
	WebElement tfPreferredLanguage1;
	
	@FindBy(id="indskr_lu_languageid_ledit")
	public static
	WebElement tfPreferredLanguage;
	
//Primary Specialty :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/span/span[@id=\"indskr_lu_specialtyid_lookupValue\"]")
	public static
	WebElement tfPimarySpeciality1;
	
	@FindBy(id="indskr_lu_specialtyid_ledit")
	public static
	WebElement tfPimarySpeciality;
	
//Speaker :
	@FindBy(id="indskr_speaker_i")
	public static
	WebElement chkBoxSpeaker;
	
//KOL :
	@FindBy(id="indskr_kol_i")
	public static
	WebElement chkBoxKOL;
	
//Business Phone :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Business Phone_label\"]")
	public static
	WebElement tfBusinessPhone1;
		
	@FindBy(id="telephone1_i")
	public static
	WebElement tfBusinessPhone;
	
//Mobile Phone :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Mobile Phone_label\"]")
	public static
	WebElement tfMobilePhone1;
				
	@FindBy(id="mobilephone_i")
	public static
	WebElement tfMobilePhone;	
	
//Email Association :
	@FindBy(xpath="//a[@id='EmailAddresses_addImageButton']")
	public static
	WebElement lnkAddEmail;	
	
//Email Association :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Email Address_label\"]")
	public static
	WebElement tfEmail1;
					
	@FindBy(id="indskr_emailaddress_i")
	public static
	WebElement tfEmail;
	
//Save :
	
	@FindBy(id="globalquickcreate_save_button_NavBarGloablQuickCreate")
	public static
	WebElement btnSave;

//Activate and Deactivate Contact :
	@FindBy(xpath="//a//span[text()=\" Deactivate \"]")
	public static
	WebElement lnkDeactivate;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Status Reason_label\"]")
	public static
	WebElement txtStatus;
		
	@FindBy(xpath="//a//span[text()=\" Activate \"]")
	public static
	WebElement lnkActivate;	
	
	@FindBy(id="ok_id")
	public static
	WebElement btnDeactivate;
	
	@FindBy(id="ok_id")
	public static
	WebElement btnActivate;
	
//Search Contact :
	@FindBy(id="crmGrid_findCriteria")
	public static
	WebElement tfSearchContact;
	
	@FindBy(id="crmGrid_findCriteriaButton")
	public static
	WebElement imgSearchContact;
	
//Dissociate Position :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-RefreshDialog-Footer')]//button[@title='Delete']")
	public static
	WebElement btnDelete;
	
	@FindBy(xpath="//a[@title='Delete']")
	public static
	WebElement lnkDeletePosition;
	
//Deleting Contact :
	@FindBy(xpath="//span//a//img[@class='ms-crm-moreCommand-image']")
	public static
	WebElement lnkFindMore;
	
	@FindBy(xpath="//a//span[text()=' Delete ']")
	public static
	WebElement ddDelete;
	
	@FindBy(id="butBegin")
	public static
	WebElement btnDeleteContact;
	
	// Initializing the Page Objects:
		public ContactPage() {
			PageFactory.initElements(driver, this);
		}

}
