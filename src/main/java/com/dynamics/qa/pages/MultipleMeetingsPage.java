package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class MultipleMeetingsPage extends TestBase{
	
	//Scheduler Link :
		@FindBy(xpath="//span[text()=' Schedule Meeting ']")
		public static
		WebElement lnkScheduleMeeting;
	
		@FindBy(id="subject2")
		public static
		WebElement tfSubject1;
		
		@FindBy(id="subject2_i")
		public static
		WebElement tfSubject;
		
		@FindBy(id="location1")
		public static
		WebElement tfLocation1;
		
		@FindBy(id="location1_i")
		public static
		WebElement tfLocation;
		
		@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Start_label']")
		public static
		WebElement tfStartDate1;
		
		@FindBy(id="scheduledstart2_iDateInput")
		public static
		WebElement tfStartDate;
		
		@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='End_label']")
		public static
		WebElement tfEndDate1;
		
		@FindBy(id="scheduledend2_iDateInput")
		public static
		WebElement tfEndDate;
		
		@FindBy(id="indskr_positionid1_lookupValue")
		public static
		WebElement tfPosition1;
		
		@FindBy(id="indskr_positionid1_ledit")
		public static
		WebElement tfPosition;
		
		@FindBy(id="indskr_positionid1_i")
		public static
		WebElement imgSearchPosition;
		
		@FindBy(id="Notes_label")
		public static
		WebElement tfNotes1;
		
		@FindBy(id="indskr_notes_i")
		public static
		WebElement tfNotes;
		
		@FindBy(xpath="//a//span[text()=' Save ']")
		public static
		WebElement lnkSave;

		public MultipleMeetingsPage() {
		PageFactory.initElements(driver, this);
	}

}
