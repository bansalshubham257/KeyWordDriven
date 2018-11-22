package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;
import com.dynamics.qa.util.TestUtil;

public class LoginPage extends TestBase{

	
	//Page Factory - OR:
	@FindBy(id="i0116")
	static
	WebElement usernameTxtb;
	
	@FindBy(id="idSIButton9")
	static
	WebElement NextBtn;
	
	@FindBy(id="i0118")
	static
	WebElement passwordTxtb;
	
	@FindBy(id="idSIButton9")
	static
	WebElement loginBtn;
	
	@FindBy(id="idBtn_Back")
	WebElement staySignedInNoBtn;
	
	@FindBy(xpath="//ion-input[@placeholder=\"username\"]//input[@placeholder=\"username\"]")
	static
	WebElement tfUserName;
	
	@FindBy(xpath="//ion-input[@placeholder=\"password\"]//input[@placeholder=\"password\"]")
	static
	WebElement tfPassword;
	
	@FindBy(xpath="//span[text()='Login']")
	static
	WebElement btnLogin;

	
	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
	//Actions:
		public HomePage login(String un, String pwd){
			usernameTxtb.sendKeys(un);
			clickOn(driver, NextBtn, TestUtil.EXPLICIT_WAIT);
			passwordTxtb.sendKeys(pwd);
			clickOn(driver, loginBtn, TestUtil.EXPLICIT_WAIT);
			clickOn(driver, staySignedInNoBtn, TestUtil.EXPLICIT_WAIT);
		    return new HomePage();
		}   
			public static WFEPage loginWFE(String un, String pwd) throws InterruptedException{
				tfUserName.sendKeys(un);
				clickOn(driver, btnLogin, TestUtil.EXPLICIT_WAIT);
				usernameTxtb.sendKeys(un);
				clickOn(driver, NextBtn, TestUtil.EXPLICIT_WAIT);
				passwordTxtb.sendKeys(pwd);
				clickOn(driver, loginBtn, TestUtil.EXPLICIT_WAIT);
				return new WFEPage();
		}
			
}

