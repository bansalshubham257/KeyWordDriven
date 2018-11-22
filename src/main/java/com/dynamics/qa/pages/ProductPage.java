/**
 *@author : Praveen.Kumar
 *@description : Product's Home Page - WebElements (All ProductPage related webelements has been found here) 
 *@class : HomePage
 */

/**
 * dd => drop down
 * lnk => link
 * btn => button
 * tf => text field
 */
package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.dynamics.qa.base.TestBase;


	
public class ProductPage extends TestBase{
	
/*@object Names : btnAddProduct, tf1Name, tfName , tfProductId, tf1ProductId, tf1ConsentTerms
 *@description : These are the web elements found while creating a Product.
 *author : Praveen.Kumar
 */	
	@FindBy(xpath="//a//span[text()=' Add Product ']")
	public static
	WebElement btnAddProduct;
	
	@FindBy(id="Name_label")
	public static
	WebElement tf1Name;

	@FindBy(id="name_i")
	public static
	WebElement tfName;

	@FindBy(id="Product ID_label")
	public static
	WebElement tf1ProductId;
	
	@FindBy(id="productnumber_i")
	public static
	WebElement tfProductId;
	
	@FindBy(id="Description_label")
	public static
	WebElement tf1Description;
	
	@FindBy(id="description_i")
	public static
	WebElement tfDescription;
	
	@FindBy(id="indskr_consentterms_lookupValue")
	public static
	WebElement tf1ConsentTerms;
	
	@FindBy(id="indskr_consentterms_ledit")
	public static
	WebElement tfConsentTerms;
	
	
/*@object Names : lnkPublish, btnPublish, txtStatus
 *@description : These web elements are found when we Publish or republish the Products 
 *author : Praveen.Kumar
 */
	
	@FindBy(xpath="//a//span[text()=' Publish ']")
	public static
	WebElement lnkPublish;
		
	@FindBy(id="butBegin")
	public static
	WebElement btnPublish;
	
	@FindBy(id="Status_label")
	public static
	WebElement txtStatus;
	

	
/*@object Names : lnk1SearchProduct, lnkSearchProduct, createdProductLnk
 *@description : These web elements are found when we Search for created Product and clicking on that.
 *author : Praveen.Kumar
 */	
	
	@FindBy(xpath="//input[@id=\"crmGrid_findCriteria\"]")
	public static
	WebElement lnk1SearchProduct;

	@FindBy(xpath="//a[@id=\"crmGrid_findCriteriaButton\"]")
	public static
	WebElement lnkSearchProduct;
	
/*@object Names : addKeyMessagesLnk, addKeyMessagesLnk1, tfSearch
 *@description : These web elements are found while adding keymessage to a Product .
 *author : Praveen.Kumar
 */	
	
	@FindBy(xpath="//a[@id='AssociatedKeyMessages_addImageButton']")
	public static
	WebElement addKeyMessagesLnk;
	
	@FindBy(id="lookup_AssociatedKeyMessages_ledit")
	public static
	WebElement tfSearch;
	
	
	// Initializing the Page Objects:
	public ProductPage() {
		
		PageFactory.initElements(driver, this);
	}

}

/* @FindBy(id="Type_label")
public static
WebElement dd1Type;

@object Name : 'Type' drop down
 *@description : Same 'Type' drop down, identified with other object to perform action
 *author : Praveen.Kumar
 

@FindBy(id="indskr_producttype_i")
public static
WebElement ddType;

@object Name : 'Unit Group' text Field
 *@description : 'Unit Group' Field present in Product creation/Edit page
 *author : Praveen.Kumar
 

@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]//label[contains(@id,\"Unit Group_label\")]//following-sibling::span//span[@id=\"defaultuomscheduleid_lookupValue\"]")
public static
WebElement tf1UnitGroup;

@object Name : 'Unit Group' text Field
 *@description : Same 'Unit Group' Field, identified with other object to perform action
 *author : Praveen.Kumar
 

@FindBy(id="defaultuomscheduleid_ledit")
public static
WebElement tfUnitGroup;

@object Name : 'Default Group' text Field
 *@description : 'Default Group' Field present in Product creation/Edit page
 *author : Praveen.Kumar
 

@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]//label[contains(@id,\"Default Unit_label\")]//following-sibling::span//span[@id=\"defaultuomid_lookupValue\"]")
public static
WebElement tf1DefaultGroup;

@object Name : 'Default Group' text Field
 *@description : Same 'Default Group' Field, identified with other object to perform action
 *author : Praveen.Kumar
 

@FindBy(id="defaultuomid_ledit")
public static
WebElement tfDefaultGroup;

@object Name : 'From' date picker
 *@description : 'From' date picker present in Product creation/Edit page
 *author : Praveen.Kumar
 

@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Valid From_label\"]")
public static
WebElement dp1From;

@object Name : 'From' date picker
 *@description : Same 'From' date picker, identified with other object to perform action
 *author : Praveen.Kumar
 

@FindBy(id="validfromdate_iDateInput")
public static
WebElement dpFrom;

@object Name : 'To' date picker
 *@description : 'To' date picker present in Product creation/Edit page
 *author : Praveen.Kumar
 

@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Valid To_label\"]")
public static
WebElement dp1To;

@object Name : 'To' date picker
 *@description : Same 'To' date picker, identified with other object to perform action
 *author : Praveen.Kumar
 

@FindBy(id="validtodate_iDateInput")
public static
WebElement dpTo;*/

