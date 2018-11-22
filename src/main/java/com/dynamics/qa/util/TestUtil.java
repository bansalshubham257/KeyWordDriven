package com.dynamics.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.ExtentTest;
import com.dynamics.qa.base.TestBase;

public class TestUtil extends TestBase{
//==========================///////////////////Wait Configurations //////////////////////===================================//	
	public static long PAGE_LOAD_TIMEOUT = 90;
	public static long IMPLICIT_WAIT = 90;
	public static long EXPLICIT_WAIT = 90;
	public static ExtentTest extentTest;

//==========================/////////////////Test Data Path Configuration //////////////////////===================================//
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"//Files//Dynamics_TestData.xlsx";
	
	
	
	public static String TESTDATA_SHEET_PATH_2 = System.getProperty("user.dir")+"//Files//Test_data_second_sheet.xlsx";

	
	public static String TESTDATA_SHEET_PATH_3 = System.getProperty("user.dir")+"//Files//Test_Data_For_Base_Setup.xlsx";
	
	
	static Workbook book;
	static Sheet sheet;
	
//==========================/////////////////Frames Reusable Methods //////////////////////===================================//
	
	public static void switchToFirstFrame() throws IOException {
		driver.switchTo().frame(0);
	}

	public static void switchToSecondFrame() throws IOException {
		driver.switchTo().frame(1);
	}
	
	public static void switchToThirdFrame() throws IOException {
		driver.switchTo().frame(2);
	}
	
//==========================/////////////////Alert Pop-up Reusable Method //////////////////////===================================//

	
	public static void alertWindow() {
	          if(isAlertPresent()){
	              Alert alert = driver.switchTo().alert();
	              System.out.println("Alert Present");
	              System.out.println(alert.getText());
	              alert.accept();
	            }
	          }
	public static boolean isAlertPresent(){
	          try{
	              driver.switchTo().alert();
	              return true;
	              }catch(NoAlertPresentException ex){
	            	  System.out.println("No Alert Present");
	                    return false;
	              }
	          }
//==========================/////////////////Mouse hover Reusable Method //////////////////////===================================//

	
	public static void mousehover(WebElement locator) {
		Actions action = new Actions(driver);
		action.moveToElement(locator).build().perform();
	}

//==========================/////////////////Test Data For Dynamics Automation //////////////////////===================================//	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				if (sheet.getRow(i + 1).getCell(k)!= null)
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
//==========================/////////////////Test Data For WFE Automation //////////////////////===================================//	
	
	public static Object[][] getWFETestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH_2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				if (sheet.getRow(i + 1).getCell(k)!= null)
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
//==========================/////////////////Test Data For Base Setup Automation //////////////////////===================================//	
	
	public static Object[][] getBaseSetupTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH_3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				if (sheet.getRow(i + 1).getCell(k)!= null)
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
//==========================/////////////////Code to take screenshot on failure of test case //////////////////////===================================//
	
public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/ScreenShots/" + System.currentTimeMillis() + ".png"));
		/*extentTest.log(LogStatus.FAIL,extentTest.addScreencast(currentDir));*/
		
		}
}
