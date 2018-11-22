/**
 *@author : Praveen.Kumar
 *@description : PositionGroupPage - Test cases (All Position Group related webelements has been found here) 
 *@class : HomePageTest
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

public class PositionGroupPage extends TestBase {
	
/*@object Names : btnNew, tfNameCreate, tf1Description , tfDescription, lnkSave
 *@description : These are the web elements found while creating a Position Group.
 *author : Praveen.Kumar
 */
	@FindBy(xpath="//span[@class='ms-crm-CommandBar-Menu' and text()=' New ']")
	public static
	WebElement btnNew;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline')]/input[@id=\"indskr_name_i\"]")
	public static
	WebElement tfNameCreate;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Description_label\"]")
	public static
	WebElement tf1Description;
	
	@FindBy(id="indskr_description_i")
	public static
	WebElement tfDescription;
	
/*@object Names : lnkAddPositions, tfAddPosition, tfAddPositionSearch, tfAddPositionSelect
 *@description : These are the web elements found while adding Position to a Position Group.
 *author : Praveen.Kumar
 */	
	
	@FindBy(xpath="//a[@id='Positions_addImageButton']")
	public static
	WebElement lnkAddPositions;
	
	@FindBy(id="lookup_Positions_ledit")
	public static
	WebElement tfAddPosition;
	
	@FindBy(id="lookup_Positions_i")
	public static
	WebElement tfAddPositionSearch;
	
	@FindBy(xpath="//a[@title='AutomationParentPosition' or @title='Child Position bS Automation']")
	public static
	WebElement tfAddPositionSelect;
	
/*@object Names : lnkAddEmailTemplates, tfAddEmailTemplates, tfAddEmailTemplatesSearch, tfAddEmailTemplatesSelect
 *@description : These are the web elements found while adding EmailTemplate to a Position Group.
 *author : Praveen.Kumar
 */	
	
	@FindBy(xpath="//a[@id='EmailTemplates_addImageButton']")
	public static
	WebElement lnkAddEmailTemplates;
	
	@FindBy(id="lookup_EmailTemplates_ledit")
	public static
	WebElement tfAddEmailTemplates;
	
	@FindBy(id="lookup_EmailTemplates_i")
	public static
	WebElement tfAddEmailTemplatesSearch;
		
/*@object Names : tfSearchPositionGroup, imgSearchPositionGroup, lnkCreatedPositionGroup
 *@description : These are the web elements found while searching created Position Group.
 *author : Praveen.Kumar
 */		
	
	@FindBy(id="crmGrid_findCriteria")
	public static
	WebElement tfSearchPositionGroup;
	
	@FindBy(id="crmGrid_findCriteriaButton")
	public static
	WebElement imgSearchPositionGroup;

/*@object Names : tf1NameEdit, tf1DescriptionEdit
 *@description : These are the web elements found while editing Position Group.
 *author : Praveen.Kumar
 */
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Name_label\"]")
	public static
	WebElement tf1NameEdit;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id=\"Description_label\"]")
	public static
	WebElement tf1DescriptionEdit;
		
/*@object Names : lnk1SearchPosition, lnkSearchPosition, lnkCreatedPosition
 *@description : These are the web elements found while searching created Position.
 *author : Praveen.Kumar
 */	
	@FindBy(id="crmGrid_findCriteria")
	public static
	WebElement lnk1SearchPosition;
		
	@FindBy(id="crmGrid_findCriteriaButton")
	public static
	WebElement lnkSearchPosition;
	
/*@object Names : lnkEmailTemplate, lnkExpander, lnkCreatedEmailTemplate
 *@description : These are the web elements found while checking Position Group association in EmailTemplate.
 *author : Praveen.Kumar
 */	
	@FindBy(id="NewSubArea_6c187a9d")
	public static
	WebElement lnkEmailTemplate;
	
	@FindBy(id="PositionGroups_Expander")
	public static
	WebElement lnkExpander;
	
/*@object Names : ddOminiPresenceUpdated
 *@description : These are the web elements found while checking Position Group association in Email Templates.
 *author : Praveen.Kumar
 */	
	
	@FindBy(id="TabNewArea_f81c827")
	public static
	WebElement ddOminiPresenceUpdated;


/*@object Names : lnkDeactivate, txtStatus, lnkActivate, btnDeactivate
 *@description : These are the web elements found while deactivating and activating.
 *author : Praveen.Kumar
 */
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
	
	@FindBy(id="ok_id")
	public static
	WebElement btnDeactivate;

	// Initializing the Page Objects:
	
	public PositionGroupPage() {
		PageFactory.initElements(driver, this);
	}

}
