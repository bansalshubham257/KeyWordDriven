package com.dynamics.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class BaseSetupPage extends TestBase{
	
	
	
	
	// Initializing the Page Objects:
			public BaseSetupPage() {
				PageFactory.initElements(driver, this);
			}

}
