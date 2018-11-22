package com.dynamics.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class WFEPage extends TestBase{
	
//Login elements :
	@FindBy(id="rb-2-0")
	public static
	WebElement radioBtnIndegeneQA;
	
	@FindBy(id="rb-7-0")
	public static
	WebElement radioBtnPERF1; // For performance environment
	
	@FindBy(xpath="//span[text()='Continue']")
	public static
	WebElement btnContinue;
	
//Presentation Present or not :
	@FindBy(xpath="//ion-item//div//div//ion-label[contains(text(),\"bmsContent\")]")
	public static
	By lnkPresentation;
	
//Menu Button :
	@FindBy(xpath="//ion-buttons[@left='']//button[@icon-only='']")
	public static
	WebElement btnMenu;
	
//Presentation option :	
	@FindBy(xpath="//ion-item//div//div//ion-label[contains(text(),\"Presentations\")]")
	public static
	WebElement lnkPresentations;
//Back labeled link :	
	@FindBy(xpath="//ion-buttons[@left='']//button[span[div[contains(text(),'Back')]]]")
	public static
	WebElement btnBack;
//Back Arrow :	
	@FindBy(xpath="//button[span[ion-icon[@name='arrow-back']]]")
	public static
	WebElement lnkBackArrow;
	
//Add Meeting link :
	@FindBy(xpath="//ion-buttons[@right=\"\"]//button[@icon-only=\"\"]")
	public static
	WebElement btnAddMeeting;
	
//Confirm link :
	@FindBy(xpath="//a[text()='Confirm']")
	public static
	WebElement lnkConfirm;

//New Meeting link :
	@FindBy(xpath="//div[h2[text()='New Meeting']]")
	public static
	WebElement lnkNewMeeting;
	
//Subject New Meeting :
	@FindBy(xpath="//div[@class=\"itemContent subjectContainer\" and contains(text(),'New Meeting')]")
	public static
	WebElement lnkSubject;
//Text area to change Subject :
	@FindBy(xpath="//textarea[starts-with(@class,'ng-') and @maxlength='200']")
	public static
	WebElement tfTextSbuject;
//Done button :	
	@FindBy(xpath="//button[span[contains(text(),'Done')]]")
	public static
	WebElement btnDone;
//No Location Label:	
	@FindBy(xpath="//div[span[contains(text(),'No Location')]]")
	public static
	WebElement lnkLocation;
//Location Text field :	
	@FindBy(xpath="//input[@class='searchbar-input']")
	public static
	WebElement tfLocation;
//Done Button :
	@FindBy(xpath="//button[span[contains(text(),'DONE')]]")
	public static
	WebElement btnDONE;
	
//Select Account Label:
	@FindBy(xpath="//div[contains(text(),'Select accounts')]")
	public static
	WebElement lnkSelectAccount;
	
//Search Account :
	@FindBy(xpath="//input[@class='searchbar-input']")
	public static
	WebElement tfSearchAccount;
	
//Click On One of the Check box :
	@FindBy(xpath="//label[text()='Automation Account 1']/preceding-sibling::ion-checkbox[@mode='ios']")
	public static
	WebElement chkboxAddbox;

//Select Participants Label:
	@FindBy(xpath="//div[contains(text(),'Select participants')]")
	public static
	WebElement lnkSelectParticipants;
		
//Search Account :
	@FindBy(xpath="//input[@class=\"searchbar-input\"]")
	public static
	WebElement tfSearchParticipants;

//Add Presentation link :
	@FindBy(xpath="//button[span[contains(text(),'Add')]]")
	public static
	WebElement lnkAddPresentation;
	
//Search Presentation :
	@FindBy(xpath="//input[@class=\"searchbar-input\"]")
	public static
	WebElement tfSearchPresentation;
	
//Click "+" link for Presentation :
	@FindBy(xpath="//ion-icon[@item-end=\"\" and @name=\"md-add\"]")
	public static
	WebElement lnkPlusPresentation;
	
//Click Sync button :
	@FindBy(xpath="//button[span[ion-icon[@name='sync']]]")
	public static
	WebElement btnSync;
	
	
	
	// Initializing the Page Objects:
	public WFEPage() {
		PageFactory.initElements(driver, this);
	}
	
}
