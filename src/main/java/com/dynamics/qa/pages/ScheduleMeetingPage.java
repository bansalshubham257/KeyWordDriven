package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class ScheduleMeetingPage extends TestBase{

//Scheduler Link :
	@FindBy(xpath="//a[text()=' Scheduler ']")
	public static
	WebElement lnkScheduler;
	
//Scheduler Dropdown :
	@FindBy(xpath="//a[contains(@title,'Scheduler')]")
	public static
	WebElement ddScheduler;
	
//Call For Availability link :
	@FindBy(xpath="//a[starts-with(@class,'ms-crm-Menu-Label')]//span[text()=' Call for Availability ']")
	public static
	WebElement lnkCallForAvailability;
	
//Subject :	
	@FindBy(xpath="//div[@id='subject1']//div[starts-with(@class,'ms-crm-Inline-Value')]//label[@id='Subject_label']")
	public static
	WebElement tfSubject1;
	
	@FindBy(id="subject1_i")
	public static
	WebElement tfSubject;
//Phone Number :	
	@FindBy(xpath="//div[@id='phonenumber1']//div[starts-with(@class,'ms-crm-Inline-Value')]//label[@id='Phone Number_label']")
	public static
	WebElement tfPhoneNumber1;
	
	@FindBy(id="phonenumber1_i")
	public static
	WebElement tfPhoneNumber;
//GateKeeper :	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Gatekeeper_label']")
	public static
	WebElement tfGateKeeper1;
	
	@FindBy(id="indskr_assistantname_i")
	public static
	WebElement tfGateKeeper;
	
//Meeting Start Date :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Scheduled Start_label']")
	public static
	WebElement tfMeetingStartDate1;
	
	@FindBy(id="indskr_scheduledstart_iDateInput")
	public static
	WebElement tfMeetingStartDate;
	
//Meeting End Date :
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Scheduled End_label']")
	public static
	WebElement tfMeetingEndDate1;
	
	@FindBy(id="indskr_scheduledend_iDateInput")
	public static
	WebElement tfMeetingEndDate;
	
//Save :
	@FindBy(xpath="//a//span[text()=' Save & Close ']")
	public static
	WebElement lnkSaveAndClose;
	
//Description :
	@FindBy(xpath="//div[@id='indskr_description1']//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Description_label']")
	public static
	WebElement tfDescription1;
	
	@FindBy(id="indskr_description1_i")
	public static
	WebElement tfDescription;
	
//Call or Meeting Activity Delete :
	
	@FindBy(xpath="//a//span[text()=' Delete ']")
	public static
	WebElement lnkDelete;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-RefreshDialog-Footer')]//button[@title='Delete']")
	public static
	WebElement btnDelete;

	
	// Initializing the Page Objects:
	public ScheduleMeetingPage() {
		PageFactory.initElements(driver, this);
	}

}
