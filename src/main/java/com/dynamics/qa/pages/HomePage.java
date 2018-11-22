/**
 *@author : Praveen.Kumar
 *@description : Home Page - WebElements (All Home Page related webelements has been found here) 
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

public class HomePage extends TestBase {

/*@object Names : indLogo, ddIndegene, lnkOminiPresence , lnkOminiPresence
 *@description : These are the web elements found in a way to get to a IO home page after we login.
 *author : Praveen.Kumar
 */

	@FindBy(xpath="//img[contains(@class,'navTabLogoTextThemeImage')]")
	WebElement indLogo;
	
	@FindBy(id="TabArrowDivider")
	public static
	WebElement ddIndegene;
	
	
	@FindBy(xpath="(//span[@class='item-label' and text()='Omnipresence'])[1]")
	public static
	WebElement lnkOminiPresence;
	
	@FindBy(xpath="//span[@id='TabSFA' or @name='TabHome']")
	public static
	WebElement ddOminiPresence;
	
/*@object Names : lnkOminiPresenceAdmin, lnkProduct;
 *@description : These are the web elements found in a way to get to a Product home page from IO home page.
 *author : Praveen.Kumar
 */
	
	@FindBy(id="NewArea_f81c827")
	public static
	WebElement lnkOminiPresenceAdmin;
	
	@FindBy(id="SFA")
	public static
	WebElement lnkOminiPresenceSales;
	
	@FindBy(id="NewSubArea_ed42cda3")
	public static
	WebElement lnkProduct;
	
	@FindBy(id="Settings")
	public static
	WebElement lnkSettings;
	
	@FindBy(id="nav_security")
	public static
	WebElement lnkSecuritys;
	
	@FindBy(id="_A01")
	public static
	WebElement lnkSecurityRoles;
	
/*@object Name : lnkPositionGroups
 *@description : This web element found in a way to get to a PositionGroups home page from IO home page.
 *author : Praveen.Kumar
 */	
	@FindBy(id="NewSubArea_06e330af")
	public static
	WebElement lnkPositions;
	
	@FindBy(id="NewSubArea_9b960248")
	public static
	WebElement lnkPositionGroups;
	
/*@object Name : lnkKeyMessages
 *@description : This web element found in a way to get to a KeyMessages home page from IO home page.
 *author : Praveen.Kumar
 */	
	@FindBy(id="NewSubArea_d4f752f6")
	public static
	WebElement lnkKeyMessages;
	
/*@object Name : lnkContacts
 *@description : This web element found in a way to get to a Contacts home page from IO home page.
 *author : Praveen.Kumar
 */	
	@FindBy(id="nav_conts")
	public static
	WebElement lnkContacts;
	
/*@object Name : lnkMeetings
*@description : This web element found in a way to get to a Meetings home page from IO home page.
*author : Praveen.Kumar
*/	
	@FindBy(id="NewSubArea_6fdf8253")
	public static
	WebElement lnkMeetings;
	
/*@object Name : lnkSegmentCallPlan
*@description : This web element found in a way to get to a Segment Call Plan's home page from IO home page.
*author : Praveen.Kumar
*/	
	
	@FindBy(id="NewSubArea_9a06d1d4")
	public static
	WebElement lnkSegmentCallPlan;
	
/*@object Name : lnkRepCallPlan
*@description : This web element found in a way to get to a Segment Call Plan's home page from IO home page.
*author : Praveen.Kumar
*/	
		
	@FindBy(id="NewSubArea_fb7185f6")
	public static
	WebElement lnkRepCallPlan;

//==========================/////////////////Resuable Xpaths/WebElements //////////////////////===================================//////////////////////////////	
/*@object Name : lnkSaveAndClose, lnkSave
*@description : These are the web elements used in many place (Reusable Xpaths/WebElements) .
*author : Praveen.Kumar
*/	
	
	@FindBy(xpath="//span[@class='ms-crm-CommandBar-Menu' and text()=' Save & Close ']")
	public static
	WebElement lnkSaveAndClose;
	
	@FindBy(xpath="//a//span[text()=' Save ']")
	public static
	WebElement lnkSave;
	
	@FindBy(xpath="//a//span[text()=' Delete ']")
	public static
	WebElement lnkDelete;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-RefreshDialog-Footer')]//button[@title='Delete']")
	public static
	WebElement btnDelete;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
}

