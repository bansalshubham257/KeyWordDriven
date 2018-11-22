package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class MeetingDetailsPage extends TestBase{

//Search Created Meeting in WFE :	
	@FindBy(id="crmGrid_findCriteria")
	public static
	WebElement tfSearchMeeting;
	
	@FindBy(id="crmGrid_findCriteriaButton")
	public static
	WebElement imgSearchMeeting;
	
	@FindBy(xpath="//a[@title='Dynamics Automation Meeting']")
	public static
	WebElement lnkCreatedMeeting;
	
	
	
	
	// Initializing the Page Objects:
	public MeetingDetailsPage() {
		PageFactory.initElements(driver, this);
		
	}

}
