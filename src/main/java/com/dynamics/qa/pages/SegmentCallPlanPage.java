package com.dynamics.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dynamics.qa.base.TestBase;

public class SegmentCallPlanPage extends TestBase{

//NEW :
	@FindBy(xpath="//div//ul//li//span/a//span[@class='ms-crm-CommandBar-Menu' and text()=' New ']")
	public static
	WebElement btnNew;
	
//Name :	
	@FindBy(id="indskr_name_i")
	public static
	WebElement tfName;
	
//Product :	
    @FindBy(id="indskr_productid_ledit")
	public static
	WebElement tfProduct;
    
    @FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/span/span[@id='indskr_productid_lookupValue']")
	public static
	WebElement labelProduct;
    
//Segment :	
    @FindBy(id="indskr_segment_v2_ledit")
	public static
	WebElement tfSegment;
    
    @FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/span/span[@id='indskr_segment_v2_lookupValue']")
	public static
	WebElement labelSegment;
    
//Call Plan Start date :    
	@FindBy(id="indskr_startdate_iDateInput")
	public static
	WebElement tfCallPlanStartDate;
	
    @FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Period Start Date_label']")
	public static
	WebElement labelCallPlanStartDate;
	
//Call Plan End date :    
	@FindBy(id="indskr_enddate_iDateInput")
	public static
	WebElement tfCallPlanEndDate;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Period End Date_label']")
	public static
	WebElement labelCallPlanEndDate;
	
//Call Goals :    
	@FindBy(id="indskr_hocalls_i")
	public static
	WebElement tfCustomerCallGoals;
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Customer Meeting Goals_label']")
	public static
	WebElement labelCustomerCallGoals;
	
//Email Goals :    
	@FindBy(id="indskr_hoemails_i")
	public static
	WebElement tfCustomerEmailGoals;	
	
	@FindBy(xpath="//div[starts-with(@class,'ms-crm-Inline-Value')]/label[@id='Customer Email Goals_label']")
	public static
	WebElement labelCustomerEmailGoals;
	
// Status :
	@FindBy(id="Status_label")
	public static
	WebElement txtStatus;
	
//Distribute Distribute :
	@FindBy(xpath="//a//span[contains(text(),'Distribute')]")
	public static
	WebElement lnkDistribute;
// Initializing the Page Objects:
	public SegmentCallPlanPage() {
		PageFactory.initElements(driver, this);
		}
	}
