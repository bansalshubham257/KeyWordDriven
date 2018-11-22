package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class KeyMessagePage extends TestBase{
	
	@FindBy(xpath="//span[@class='ms-crm-CommandBar-Menu' and text()=' New ']")
	public static
	WebElement btnNew;
	
	
	@FindBy(id="indskr_name_i")
	public static
	WebElement tfName;
	
	@FindBy(id="Key Message_label")
	public static
	WebElement tfName1;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Description_label']")
	public static
	WebElement tf1Description;
	
	@FindBy(id="indskr_description_i")
	public static
	WebElement tfDescription;

	@FindBy(xpath="//input[@type='checkbox' and @value='AutomationProduct']")
	public static
	WebElement chkBoxAutomationProduct;
		
	//Check Product Dissociation In both Keymessages and Product
	@FindBy(xpath="//input[@id='crmGrid_findCriteria']")
	public static
	WebElement lnk1SearchKeyMessage;
	
	@FindBy(xpath="//a[@id='crmGrid_findCriteriaButton']")
	public static
	WebElement lnkSearchKeyMessage;

	// Initializing the Page Objects:
	
		public KeyMessagePage() {
			PageFactory.initElements(driver, this);
		}

}
