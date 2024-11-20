	package org.Testcases;

import java.awt.AWTException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class SystemUserMultipleTerminalRegression extends TestHooks {

	private WebDriver driver;
	org.Locators.BaseClassLocator BL;
	org.Locators.SystemUserLocatores S;
	org.Locators.LoginLocators L;
	org.Locators.BankLocators B;
	org.Locators.AggregatorLocators A;
	org.Locators.ISOLocators ISO;
	org.Locators.SUBISOLocators SUBISO;
	org.Locators.GroupMerchantLocator GM;
	org.Locators.MerchantLocators M;
	org.Locators.TerminalLocators T;

	ExtentTest test;
	ExcelUtilsDataCache cache = ExcelUtilsDataCache.getInstance();

	public SystemUserMultipleTerminalRegression() throws InterruptedException {
		this.driver = CustomWebDriverManager.getDriver();
//			 this.driver = driver;
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		
		BL = new org.Locators.BaseClassLocator(driver);

		L = new org.Locators.LoginLocators(driver);

		S = new org.Locators.SystemUserLocatores(driver);

		B = new org.Locators.BankLocators(driver);

		A = new org.Locators.AggregatorLocators(driver);

		ISO = new org.Locators.ISOLocators(driver);

		SUBISO = new org.Locators.SUBISOLocators(driver);

		GM = new org.Locators.GroupMerchantLocator(driver);

		M = new org.Locators.MerchantLocators(driver);

		T = new org.Locators.TerminalLocators(driver);


	}
	
	@When("the System Maker clicks the Terminal module")
	public void SystemMakerClicktheSUBISOModule() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			BL.clickElement(S.ClickOnTerminal);

//			S.ClickOnTerminal();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - SUB ISO");
			throw e;
		}

	}
	
	int totalTestCaseCount = 0;

	@Then("the System Maker Terminal Onboarding should prompt users to enter valid inputs using the sheet name {string}")
	public void processAllData(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		// Load data from the cache only once
		List<Map<String, String>> testData = cache.getCachedData(sheetName);

		if (testData == null || testData.isEmpty()) {
			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);
		}

		int numberOfRows = testData.size(); // Number of rows based on cached data
		System.out.println("Total rows found: " + numberOfRows);

		TestCaseManager testCaseManager = new TestCaseManager();

		// Iterate over the cached data
		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
			System.out.println("Running test for row number: " + rowNumber);

			// Group by row number in Allure
			testCaseManager.startNewTestSuite(rowNumber);

			// Get row data from cache
			Map<String, String> rowData = testData.get(rowNumber - 1);

			try {
				// Start the test case and log the input data for the row
				testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);
				testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));

				int rowTestCaseCount = runTestForRow(sheetName, rowData, rowNumber);
				totalTestCaseCount += rowTestCaseCount;
				testCaseManager.endTestCase(true);
			} catch (Exception e) {
				takeScreenshot(rowNumber);
				testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports
				Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());
				testCaseManager.endTestCase(false);
			} finally {
				testCaseManager.endTestSuite(); // End the suite (grouping) for this row
			}

			if (rowNumber == numberOfRows) {
				System.out.println("Finished processing the last row. Logging out...");
				performLogout();
			}
		}

		logDashboardCount();
	}

	private void logDashboardCount() {
		String message = "Total Dashboard Count: " + totalTestCaseCount;

		ExtentCucumberAdapter.addTestStepLog(message);
		Allure.parameter("Total Test Case Count", totalTestCaseCount);

		System.out.println(message);
	}

	private int runTestForRow(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {

		// Log the test data for the current row
		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Initialize the locators (e.g., BankLocators)
		B = new org.Locators.BankLocators(driver);

		int testCaseCount = 0;

		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow(testData, rowNumber);

		return testCaseCount;
	}

	private void takeScreenshot(int rowNumber) {
		try {

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" + rowNumber
					+ ".png";

			FileUtils.copyFile(screenshot, new File(screenshotPath));

			Allure.addAttachment("Screenshot for Row " + rowNumber,
					new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	ArrayList<String> key = new ArrayList<>();
	ArrayList<String> value = new ArrayList<>();

	private int validateFieldsForRow(Map<String, String> testData, int TestcaseNo)
			throws Exception {

		// Initialize the locators
		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;

		// Terminal Info Section

		validatedFieldsCount += executeStep(() -> {
			try {
				
				String generatedterminalName = fillTerminalInfo(testData, TestcaseNo);
				testData.put("TerminalName", generatedterminalName);
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Terminal Info");
		
		validatedFieldsCount += executeStep(() -> {
			try {

				TransactionSet(TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Transaction Set");


		validatedFieldsCount += executeStep(() -> {
			try {
				submitForVerification(TestcaseNo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Final Submission");

		// Return the total count of validated fields/sections
		return validatedFieldsCount;
	}

	private int executeStep(Runnable step, String stepName) {
		try {
			step.run();
			return 1; // Return 1 for successful execution
		} catch (Exception e) {
			// Handle the exception and log the error
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, stepName);
			return 0; // Return 0 for failed execution
		}
	}

	
	private String fillTerminalInfo(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {
			
			String Merchant = testData.get("Merchant Name");
			String TerminalName = testData.get("Terminal Name");
			String TerminalType = testData.get("Terminal Type");
			String UPITerminalType = testData.get("UPI Terminal Type");
			String UPIOffliceType = testData.get("UPI Offline Type");
			String DeviceModel = testData.get("Device Model");
			String DeviceNumber = testData.get("Device Number");
			String ActiveDeviceNumber = testData.get("Active Device Number");
			String IMEINumber = testData.get("IMEI Number");
			String DeviceType = testData.get("Device Type");
			String Devicecommercial = testData.get("Device commercial");
			String TIDFeeApplicable = testData.get("TID Fee Applicable");
			String DevicePrice = testData.get("Device Price");
			String InstallationFee = testData.get("Installation Fee");
			String errorMessage = "The data does not match or is empty.";

			if (Merchant != null && !Merchant.trim().isEmpty()) {

				BL.clickElement(B.Createbutton);
				BL.clickElement(T.Merchant);
				BL.enterElement(T.Merchant, Merchant);
				Thread.sleep(4000);
				BL.TerminaltypeselectDropdownOption(Merchant);
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage();
				}
				
				  logTestStep(TestcaseNo, "Merchant Name", Merchant , Status, errorMessage);

			}
		
			if (TerminalName != null && !TerminalName.trim().isEmpty()) {
				BL.clickElement(T.TerminalName);
				BL.enterElement(T.TerminalName, TerminalName);

				boolean Status = true;

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				 logTestStep(TestcaseNo, "Terminal Name", TerminalName , Status, errorMessage);

			}
			if (TerminalType != null && !TerminalType.trim().isEmpty()) {

				BL.clickElement(T.Terminaltype);
				BL.enterElement(T.Terminaltype, TerminalType);
				BL.TerminaltypeselectDropdownOption(TerminalType);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Terminal Type", TerminalType , Status, errorMessage);


			}
			if (UPITerminalType != null && !UPITerminalType.trim().isEmpty()) {

				BL.clickElement(M.UPITerminalType);

				BL.selectDropdownOption(UPITerminalType);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "UPI Terminal Type", UPITerminalType , Status, errorMessage);

			}

			if (UPIOffliceType != null && !UPIOffliceType.trim().isEmpty()) {

				BL.clickElement(M.UPIofflineType);

				BL.selectDropdownOption(UPIOffliceType);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "UPI Offline Type", UPIOffliceType , Status, errorMessage);

			}

			if (DeviceModel != null && !DeviceModel.trim().isEmpty()) {

				BL.clickElement(T.DeviceModel);

				BL.enterElement(T.DeviceModel, DeviceModel);

				BL.selectDropdownOption(DeviceModel);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device Model", DeviceModel , Status, errorMessage);

			}
			if (DeviceNumber != null && !DeviceNumber.trim().isEmpty()) {

				BL.clickElement(T.DeviceNumber);

				BL.enterElement(T.DeviceNumber, DeviceNumber);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device Number", DeviceNumber , Status, errorMessage);

			}

			if (ActiveDeviceNumber != null && !ActiveDeviceNumber.trim().isEmpty()) {

				BL.clickElement(T.ActiveDeviceNumber);

				BL.enterElement(T.ActiveDeviceNumber, ActiveDeviceNumber);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Active Device Number", ActiveDeviceNumber , Status, errorMessage);
			}

			if (IMEINumber != null && !IMEINumber.trim().isEmpty()) {

				BL.clickElement(T.IMEINumber);

				BL.enterElement(T.IMEINumber, IMEINumber);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "IMEI Number", IMEINumber , Status, errorMessage);
				
			}

			if (DeviceType != null && !DeviceType.trim().isEmpty()) {

				BL.clickElement(M.DeviceType);

				BL.selectDropdownOption(DeviceType);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device Type", DeviceType , Status, errorMessage);
			}

			if (Devicecommercial != null && !Devicecommercial.trim().isEmpty()) {

				BL.clickElement(T.DeviceCommericialmode);

				BL.selectDropdownOption(Devicecommercial);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device commercial", Devicecommercial , Status, errorMessage);
			}

			if (TIDFeeApplicable != null && !TIDFeeApplicable.trim().isEmpty()) {

				BL.clickElement(T.TIDFeeApplicable);

				BL.selectDropdownOption(TIDFeeApplicable);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "TID Fee Applicable", TIDFeeApplicable , Status, errorMessage);
			}

			if (DevicePrice != null && !DevicePrice.trim().isEmpty()) {

				BL.clickElement(T.Deviceprice);

				BL.enterElement(T.Deviceprice, DevicePrice);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Device Price", DevicePrice , Status, errorMessage);
			}

			if (InstallationFee != null && !InstallationFee.trim().isEmpty()) {

				BL.clickElement(T.InstallationFee);

				BL.enterElement(T.InstallationFee, InstallationFee);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				
				logTestStep(TestcaseNo, "Installation Fee", InstallationFee , Status, errorMessage);
			}

			try {
				BL.clickElement(B.NextStep);
				if(!BL.isElementDisplayed(T.DisplayTransctionSet, "Transaction Set Page")) {
					throw new AssertionError("Assertion Error ");
				}
			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr(" Terminal Onboarding : Terminal Info "); // Take screenshot on error
			}
			return TerminalName;
			
		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Terminal Info");
			throw e; // Re-throw the exception after handling
		}
		

	}
	
	
	private void TransactionSet(int TestcaseNo) throws Exception {
		try {
			
			String errorMessage = "The data does not match or is empty.";
			
			boolean SaveStatus = true;
			try {
				
//				BL.clickElement(T.TransctionSet);
				BL.clickElement(B.SaveButton);
				BL.clickElement(B.OKButton);
				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}	
			
			logTestStep(TestcaseNo, "Transaction Set", "Save Successfully" , SaveStatus, errorMessage);
			
		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Terminal Info");
			throw e; // Re-throw the exception after handling
		}

	}
	private void submitForVerification(int TestcaseNo) throws InterruptedException {
		try {
			String errorMessage = "The data does not match or is empty.";
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.SubmitforVerification);

				logTestStep(TestcaseNo, "MMS : Terminal Onboarding : Submit for Verification", "Terminal Onboarding",
						SaveStatus, errorMessage);

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			try {
				BL.clickElement(B.YesButton);
				if (!BL.isElementDisplayed(B.VerfiedSuccessCompleted, "Submit for Verification")) {
					throw new AssertionError(
							"Verification not completed. 'Submit for Verification' element not displayed.");
				}

				logTestStep(TestcaseNo, "MMS : Terminal Onboarding : System Maker : Yes Button",
						"Submit for Verfication", SaveStatus, errorMessage);

			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Maker Verification"); // Take screenshot on error

			}
			BL.ActionclickElement(B.OKButton);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Submit for verification");
			throw e;
		}
	}
	
	@When("the System Verifier clicks the Terminal module")
	public void SystemVerifierClicktheModule() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			BL.clickElement(S.ClickOnTerminal);

//			S.ClickOnTerminal();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - SUB ISO");
			throw e;
		}

	}
	
	
	@Then("the System Verifier completes Terminal Onboarding, the system should prompt to verify all steps using the sheet name {string}")
	public void processAllData1(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		// Load data from the cache only once
		List<Map<String, String>> testData = cache.getCachedData(sheetName);

		if (testData == null || testData.isEmpty()) {
			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);
		}

		int numberOfRows = testData.size(); // Number of rows based on cached data
		System.out.println("Total rows found: " + numberOfRows);

		TestCaseManager testCaseManager = new TestCaseManager();

		// Iterate over the cached data
		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
			System.out.println("Running test for row number: " + rowNumber);

			// Group by row number in Allure
			testCaseManager.startNewTestSuite(rowNumber);

			// Get row data from cache
			Map<String, String> rowData = testData.get(rowNumber - 1);

			try {
				// Start the test case and log the input data for the row
				testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);
				testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));

				int rowTestCaseCount = runTestForRow1(sheetName, rowData, rowNumber);
				totalTestCaseCount += rowTestCaseCount;
				testCaseManager.endTestCase(true);
			} catch (Exception e) {
				takeScreenshot(rowNumber);
				testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports
				Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());
				testCaseManager.endTestCase(false);
			} finally {
				testCaseManager.endTestSuite(); // End the suite (grouping) for this row
			}

			if (rowNumber == numberOfRows) {
				System.out.println("Finished processing the last row. Logging out...");
				performLogout();
			}
		}

		logDashboardCount1();
	}

	private void logDashboardCount1() {
		String message = "Total Dashboard Count: " + totalTestCaseCount;

		ExtentCucumberAdapter.addTestStepLog(message);
		Allure.parameter("Total Test Case Count", totalTestCaseCount);

		System.out.println(message);
	}

	private int runTestForRow1(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {

		// Log the test data for the current row
		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Initialize the locators (e.g., BankLocators)
		B = new org.Locators.BankLocators(driver);

		int testCaseCount = 0;

		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow1(testData, rowNumber);

		return testCaseCount;

	}

	private int validateFieldsForRow1(Map<String, String> testData, int TestcaseNo)
			throws Exception {

		// Initialize the locators
		B = new org.Locators.BankLocators(driver);

		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;
		// Bank Details Section
		validatedFieldsCount += executeStep1(() -> {
			try {
				Searchbyname(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Searchbyname");

		// Return the total count of validated fields/sections
		return validatedFieldsCount;
	}

	private int executeStep1(Runnable step, String stepName) {
		try {
			step.run();
			return 1; // Return 1 for successful execution
		} catch (Exception e) {
			// Handle the exception and log the error
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, stepName);
			return 0; // Return 0 for failed execution
		}
	}

	private void Searchbyname(Map<String, String> testData, int TestcaseNo) throws InterruptedException, AWTException {

		String TerminalName = testData.get("Terminal Name");

		key.clear();
		value.clear();
		
		String errorMessag = "The data does not match or is empty.";

		boolean VerifiedStatus = true;

		try {

			String errorMessage = "The data does not match or is empty.";

			boolean Status = true;
			try {
				Thread.sleep(3000);

				BL.clickElement(B.SearchbyBankName);
				Thread.sleep(3000);

				BL.UploadImage(B.SearchbyBankName, TerminalName);

			}catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "Search by name");
				throw e;
			}
			
			
			try {

			logTestStep(TestcaseNo, "Search by name", TerminalName, Status, errorMessage);

			Thread.sleep(3000);

			BL.clickElement(B.ActionClick);

			Thread.sleep(2000);

			BL.ActionclickElement(B.ViewButton);
			
			}catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "ACTION AND VIEW BUTTON");
				throw e;
			}


			BL.clickElement(B.SubmitforApproval);

				BL.clickElement(B.YesButton);

				BL.clickElement(B.OKButton);

				BL.clickElement(B.ApproveCancel);

			} catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "Verified");
				throw e;
			}
		
		logTestStep(TestcaseNo, "Verified", "Terminal", VerifiedStatus, errorMessag);

	}
	
	@When("the System Approver clicks the Terminal module")
	public void SystemApproverClicktheModule() throws InterruptedException {

		try {

			B = new org.Locators.BankLocators(driver);

			S = new org.Locators.SystemUserLocatores(driver);

			BL.clickElement(S.ClickOnTerminal);

//			S.ClickOnTerminal();

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding - SUB ISO");
			throw e;
		}

	}
	
	@Then("the System Approver completes Terminal Onboarding, the system should prompt to Approve using the sheet name {string}")
	public void processAllData2(String sheetName)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		// Load data from the cache only once
		List<Map<String, String>> testData = cache.getCachedData(sheetName);

		if (testData == null || testData.isEmpty()) {
			throw new RuntimeException("No data found in the cache for sheet: " + sheetName);
		}

		int numberOfRows = testData.size(); // Number of rows based on cached data
		System.out.println("Total rows found: " + numberOfRows);

		TestCaseManager testCaseManager = new TestCaseManager();

		// Iterate over the cached data
		for (int rowNumber = 1; rowNumber <= numberOfRows; rowNumber++) {
			System.out.println("Running test for row number: " + rowNumber);

			// Group by row number in Allure
			testCaseManager.startNewTestSuite(rowNumber);

			// Get row data from cache
			Map<String, String> rowData = testData.get(rowNumber - 1);

			try {
				// Start the test case and log the input data for the row
				testCaseManager.startNewTestCase("Test Case for Row " + rowNumber, true);
				testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));

				int rowTestCaseCount = runTestForRow2(sheetName, rowData, rowNumber);
				totalTestCaseCount += rowTestCaseCount;
				testCaseManager.endTestCase(true);
			} catch (Exception e) {
				takeScreenshot(rowNumber);
				testCaseManager.logErrorInExtent(e.getMessage()); // Log the error in Extent reports
				Assert.fail("Exception encountered while processing row " + rowNumber + ": " + e.getMessage());
				testCaseManager.endTestCase(false);
			} finally {
				testCaseManager.endTestSuite(); // End the suite (grouping) for this row
			}

			if (rowNumber == numberOfRows) {
				System.out.println("Finished processing the last row. Logging out...");
				performLogout();
			}
		}

		logDashboardCount2();
	}

	private void logDashboardCount2() {
		String message = "Total Dashboard Count: " + totalTestCaseCount;

		ExtentCucumberAdapter.addTestStepLog(message);
		Allure.parameter("Total Test Case Count", totalTestCaseCount);

		System.out.println(message);
	}

	private int runTestForRow2(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {

		// Log the test data for the current row
		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Initialize the locators (e.g., BankLocators)
		B = new org.Locators.BankLocators(driver);

		int testCaseCount = 0;

		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow2(testData, rowNumber);

		return testCaseCount;

	}

	private int validateFieldsForRow2(Map<String, String> testData, int TestcaseNo)
			throws Exception {

		// Initialize the locators
		B = new org.Locators.BankLocators(driver);

		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;
		// Bank Details Section
		validatedFieldsCount += executeStep2(() -> {
			try {
				approveOnboarding(testData, TestcaseNo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "approveOnboarding");

		// Return the total count of validated fields/sections
		return validatedFieldsCount;
	}

	private int executeStep2(Runnable step, String stepName) {
		try {
			step.run();
			return 1; // Return 1 for successful execution
		} catch (Exception e) {
			// Handle the exception and log the error
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, stepName);
			return 0; // Return 0 for failed execution
		}
	}

	private void approveOnboarding(Map<String, String> testData, int TestcaseNo) throws InterruptedException {

		String TerminalName = testData.get("Terminal Name");

		key.clear();
		value.clear();

		String errorMessag = "The data does not match or is empty.";

		boolean Status = true;
		try {
			Thread.sleep(3000);

			BL.clickElement(B.SearchbyBankName);
			Thread.sleep(3000);

			BL.enterElement(B.SearchbyBankName, TerminalName);

		} catch (AssertionError e) {
			Status = false;
			errorMessag = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "Search by name", TerminalName, Status, errorMessag);
		Thread.sleep(4000);

		BL.ActionclickElement(B.ActionClick);

		Thread.sleep(1000);

		BL.clickElement(B.ViewButton);

		String errorMessage = "Approve Button is not visible.";

		boolean ApprovedStatus = true;

		try {

			BL.clickElement(B.Approve);

			BL.clickElement(B.YesButton);

			BL.clickElement(B.OKButton);

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "Approved", "Terminal", ApprovedStatus, errorMessage);
		BL.clickElement(B.ApproveCancel);

		Thread.sleep(3000);

		BL.clickElement(B.SearchbyBankName);
		Thread.sleep(3000);

		BL.UploadImage(B.SearchbyBankName, TerminalName);
		Thread.sleep(3000);

		BL.ActionclickElement(B.ActionClick);

		try {

			BL.clickElement(B.ViewButton);

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "Terminal CPID", BL.getElementValue(B.CPID), ApprovedStatus, errorMessage);

		BL.clickElement(B.ApproveCancel);

	}
	
	private void logTestStep(int testcaseCount, String fieldName, String fieldValue, Boolean status,
			String errorMessage) {
		String message = "TO Test Case " + testcaseCount + ": " + fieldName + " with value '" + fieldValue + "' "
				+ (status ? "passed." : "failed.");

		// Log to Extent Report
		ExtentCucumberAdapter.addTestStepLog(message);

		List<String> keys = new ArrayList<>();
		List<String> values = new ArrayList<>();

		TestCaseManager testCaseManager = new TestCaseManager();

		// Start a new test case
		testCaseManager.startNewTestCase(message, status);

		// Add field name and value to the lists
		keys.add(fieldName);
		values.add(fieldValue);

		testCaseManager.logInputDataa(keys, values);
		Allure.step("Test case for row " + testcaseCount);
		testCaseManager.endTestCase(status);

		// Log error message if status is false
		if (!status && errorMessage != null) {
			// Log the assertion error message
			ExtentCucumberAdapter.addTestStepLog("Error: " + errorMessage);
		}
		System.out.println(message);
	}


	
		

	private void performLogout() throws InterruptedException {

		BL.clickElement(B.Profile);

		BL.clickElement(B.LogOut);

		BL.clickElement(B.YesButton);

	}
}
