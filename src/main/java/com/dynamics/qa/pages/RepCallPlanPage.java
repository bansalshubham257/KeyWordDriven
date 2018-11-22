package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class RepCallPlanPage extends TestBase{
	
	//View Selector :	
		@FindBy(id="crmGrid_SavedNewQuerySelector")
		public static
		WebElement ddViewSelect;
	
	//View Name:
	    @FindBy(xpath="//a[@title='My Open Rep Call Plans']")
		public static
		WebElement lnkMyOpenRepCallPlansView;
	
// Initializing the Page Objects:
	public RepCallPlanPage() {
		PageFactory.initElements(driver, this);
	}

}
