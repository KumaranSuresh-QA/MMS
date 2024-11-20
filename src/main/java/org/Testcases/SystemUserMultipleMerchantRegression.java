package org.Testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class SystemUserMultipleMerchantRegression extends TestHooks {

	private WebDriver driver;
	int waitTime;

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

	public SystemUserMultipleMerchantRegression() throws InterruptedException {
		this.driver = CustomWebDriverManager.getDriver();
		this.waitTime = CustomWebDriverManager.getWaitTime();
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

	@When("the System Maker clicks the Merchant module")

	public void SystemMakerClicktheSUBISOModule() {

		try {

			BL.clickElement(B.ClickOnMerchant);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	int totalTestCaseCount = 0;

	@Then("the System Maker Merchant Onboarding should prompt users to enter valid inputs using the sheet name {string}")
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

				int rowTestCaseCount = runTestForRow(rowData, rowNumber);
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
				performLogout(rowNumber);
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

	private int runTestForRow(Map<String, String> testData, int rowNumber) throws Exception {

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

	@SuppressWarnings("unused")
	private int validateFieldsForRow(Map<String, String> testData, int TestcaseNo) throws Exception {

		// Initialize the locators
		B = new org.Locators.BankLocators(driver);

		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;

		// Sales Details Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillSalesInfo(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Sales Info");

		// Company Details Section

		validatedFieldsCount += executeStep(() -> {
			try {

				String generatedLegalName = fillCompanyInfo(testData, TestcaseNo);
				testData.put("LegalName", generatedLegalName);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Company Info");

		// Personal Details Section

		validatedFieldsCount += executeStep(() -> {
			try {
				fillPersonalInfo(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Personal Info");

		// Communication Details Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillCommunicationDetailsAdminUserDetails(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Communication Details");

		validatedFieldsCount += executeStep(() -> {
			try {
				fillCommunicationDetailsSettlementReconContactDetails(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Communication Details");

		// Channel Config Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillRiskInfo(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Risk Info");

		// Commercial Section
		validatedFieldsCount += executeStep(() -> {
			try {
				FillDiscountRate(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Merchant Discount Rate");

		// Settlement Info Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillSettlementInfo(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Settlement Info");

		validatedFieldsCount += executeStep(() -> {
			try {
				fillTerminalDetails(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Terminals");

		// KYC Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillKYCDetails(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "KYC Details");

		// Final Submission
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

	private void fillSalesInfo(Map<String, String> testData, int TestcaseNo) throws Exception {

		new Faker();

		String errorMessage = "The data does not match or is empty.";

		String name = testData.get("Aggregator Name");
		String SalesPerson = testData.get("Sales Person");
		String VASCommission = testData.get("VAS Commission");
		String branchcode = testData.get("Branch Code");
		String isoname = testData.get("ISO Name");
		String subisoname = testData.get("SUB ISO Name");
		String Gm = testData.get("GroupMerchant Name");
		String MerchnatReferenceNumber = testData.get("Merchant Reference Number");

		boolean CreateStatus = true; // Assume success initially
		try {
			BL.clickElement(B.Createbutton);
		} catch (AssertionError e) {
			CreateStatus = false; // Set status to false if assertion fails
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Create : ", "Merchant", CreateStatus, errorMessage);

		try {
			BL.clickElement(A.SalesInfo);

			if (MerchnatReferenceNumber != null && !MerchnatReferenceNumber.trim().isEmpty()) {

				BL.clickElement(M.MerchantReferenceNumber);
				BL.enterElement(M.MerchantReferenceNumber, MerchnatReferenceNumber);
				performTabKeyPress();
				boolean nameStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					nameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : Merchant Reference Number",
						MerchnatReferenceNumber, nameStatus, errorMessage);

			}

			if (name != null && !name.trim().isEmpty()) {

				BL.clickElement(ISO.AggregatorName);
				BL.selectDropdownOption(name);
				boolean nameStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(GM.AggregatorFieldRequired, "Field is Required");
					BL.isElementNotDisplayed(GM.AggregatorInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					nameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : Aggregator Name", name, nameStatus,
						errorMessage);

			}
			if (SalesPerson != null && !SalesPerson.trim().isEmpty()) {

				BL.clickElement(GM.salesperson);
				BL.enterElement(GM.salesperson, SalesPerson);
				performTabKeyPress();

				boolean Status = true;

				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : Sales Person :", SalesPerson, Status,
						errorMessage);

			}

			if (VASCommission != null && !VASCommission.trim().isEmpty()) {

				BL.clickElement(A.VASCommissionOne);
				BL.selectDropdownOption(VASCommission);
				String actualValue = BL.getElementValue(A.VASCommissionOne);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(VASCommission.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : VAS Commission", VASCommission,
						Status, errorMessage);

			}

			if (branchcode != null) {

				BL.clickElement(M.ClickonbranchCode);
				BL.enterElement(M.ClickonbranchCode, branchcode);
				BL.selectDropdownOption(branchcode);
//				performTabKeyPress();
				boolean nameStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					nameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : Branch Code", branchcode, nameStatus,
						errorMessage);

			}

			if (isoname != null && !isoname.trim().isEmpty()) {

				BL.clickElement(SUBISO.ISOName);
				BL.selectDropdownOption(isoname);
				boolean nameStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(GM.ISOInvalidDistributors, "Invalid Format");
				} catch (AssertionError e) {
					nameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : ISO Name", isoname, nameStatus,
						errorMessage);

			}

			if (subisoname != null && !subisoname.trim().isEmpty()) {

				BL.clickElement(GM.SUBISO);
				BL.selectDropdownOption(subisoname);
				boolean nameStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(M.SubISOinvalidformat, "Invalid Format");
				} catch (AssertionError e) {
					nameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : SUB ISO Name", isoname, nameStatus,
						errorMessage);

			}

			if (Gm != null && !Gm.trim().isEmpty()) {

				BL.clickElement(M.ClickOnGroupMerchant);
				BL.selectDropdownOption(Gm);
				boolean nameStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(M.GroupMerchantInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					nameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : Group Merchant", Gm, nameStatus,
						errorMessage);

			}

			boolean NextstepStatus = true;
			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
				// Click the Next Step button
				BL.clickElement(B.NextStep);

				// Check if the "Personal Info Page" element is displayed
				if (!BL.isElementDisplayed(A.IntroCompanyInfo, " Company Info Page ")) {
					// Set status to false, add error message, and take a screenshot if element is
					// not displayed
					NextstepStatus = false;
					errorMessageBuilder.append("Personal Info Page element not displayed as expected.");
					CustomWebDriverManager.takeScreenshotStr("Merchant : Sales info ");
				}
			} catch (Exception e) {
				// Handle unexpected errors and take a screenshot
				NextstepStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Merchant :  Sales Info");
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Sales Info : ", "NextStep", NextstepStatus,
					errorMessage);

		}

		catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Sales Info");
			throw e; // Re-throw the exception after handling
		}

	}

	private String fillCompanyInfo(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {

			new Faker();

			String LegalName = testData.get("Legal Name");
			String brand = testData.get("Brand Name");
			String Address = testData.get("Registered Address");
			String location = testData.get("Location");
			String pincode = testData.get("Registered Pincode");
			String type = testData.get("Business Type");
			String registeredNumber = testData.get("Registered Number");
			String pan = testData.get("Company PAN");
			String GstIN = testData.get("GSTIN");
			String nb = testData.get("Nature Of Business");
			String mcc = testData.get("MCC");
			String merchanttype = testData.get("Merchant Type");
			String merchantClassification = testData.get("Merchant Classification");
			String frequency = testData.get("Statement Frequency");
			String Type = testData.get("Statement Type");

			String errorMessage = "The data does not match or is empty.";

			if (LegalName != null && !LegalName.trim().isEmpty()) {

				BL.clickElement(A.ComapnyInfo);

				BL.clickElement(A.LegalName);

				BL.enterElement(A.LegalName, LegalName);
				performTabKeyPress();
				boolean legalNameStatus = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.CompanyLegalNameFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(A.CompanyLegalNameInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					legalNameStatus = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Legal Name", LegalName,
						legalNameStatus, errorMessage);

			}

			if (brand != null && !brand.trim().isEmpty()) {

				BL.clickElement(A.BrandName);

				BL.enterElement(A.BrandName, brand);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.CompanyBrandNameFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(A.CompanyBrandNameInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Brand Name", brand, Status,
						errorMessage);

			}

			if (Address != null && !Address.trim().isEmpty()) {

				BL.clickElement(A.RegisteredAddress);

				BL.enterElement(A.RegisteredAddress, Address);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.CompanyRegAddressInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(A.CompanyRegAddressFieldisRequired, "Field Required");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Registered Address", Address,
						Status, errorMessage);

			}

			boolean LocationStatus = true;
			try {

				BL.clickElement(M.Location);
				BL.clickElement(M.SearchtheLocation);
				BL.enterElement(M.SearchtheLocation, location);

				Thread.sleep(3000);

				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);

				Thread.sleep(3000);
				BL.clickElement(M.CompleteAddress);

				performTabKeyPress();

			} catch (AssertionError e) {
				LocationStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}
			String enteredlocation = BL.getElementValue(M.getLocation);

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Location", enteredlocation,
					LocationStatus, errorMessage);

			if (pincode != null && !pincode.trim().isEmpty()) {

				BL.clickElement(A.RegisteredPincode);
				BL.enterElement(A.RegisteredPincode, pincode);
				BL.selectDropdownOption(pincode);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.CompanyRegPincodeInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(A.CompanyRegPinFieldisRequired, "Field Required");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Registered Pincode", pincode,
						Status, errorMessage);

			}

			if (type != null && !type.trim().isEmpty()) {

				BL.clickElement(A.BusinessType);

				BL.selectDropdownOption(type);
				performTabKeyPress();
				String actualValue = BL.getElementText(A.BusinessType);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						BL.isElementNotDisplayed(A.CompanyBusinessTypFieldisRequired, "Field Required");
						assertEquals(type.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Business Type", type, Status,
						errorMessage);

			}

			boolean DateStatus = true;
			try {
				BL.clickElement(A.EstablishedYearDatepicker);

				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_ENTER);

				r.keyRelease(KeyEvent.VK_ENTER);

				BL.clickElement(A.ApplyButton);

				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
			} catch (AssertionError e) {
				DateStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Established Year", "Current Date",
					DateStatus, errorMessage);
			if (registeredNumber != null && !registeredNumber.trim().isEmpty()) {

				BL.clickElement(A.RegisterNumber);

				BL.enterElement(A.RegisterNumber, registeredNumber);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.CompanyRegNumInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(A.CompanyRegNumFieldisRequired, "Field Required");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Registered Number",
						registeredNumber, Status, errorMessage);

			}

			if (pan != null && !pan.trim().isEmpty()) {

				BL.clickElement(A.CompanyPAN);

				BL.enterElement(A.CompanyPAN, pan);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.CompanyCmpPanInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(A.CompanyRegPanFieldisRequired, "Field Required");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Company PAN", pan, Status,
						errorMessage);

			}

			if (GstIN != null && !GstIN.trim().isEmpty()) {

				BL.clickElement(A.GSTIN);

				BL.enterElement(A.GSTIN, GstIN);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.CompanyCmpGSTInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(A.CompanyCmpGSTFieldisRequired, "Field Required");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : GstIN", GstIN, Status,
						errorMessage);

			}

			if (nb != null && !nb.trim().isEmpty()) {

				BL.clickElement(GM.natureofbusiness);
				BL.selectDropdownOption(nb);

				String actualValue = BL.getElementText(GM.natureofbusiness);
				boolean Status = true; // Assume success initially

				try {
					if (actualValue != null) {
						BL.isElementNotDisplayed(GM.NatureofBusinessFieldRequired, "Filed is Required");
						assertEquals(nb.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Nature Of business", nb, Status,
						errorMessage);

			}

			if (mcc != null && !mcc.trim().isEmpty()) {

				BL.clickElement(GM.mcc);
				BL.CLearElement(GM.mcc);
				BL.enterElement(GM.mcc, mcc);
				BL.selectDropdownOption(mcc);
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(GM.MccFieldRequired, "Field is Required");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : MCC", mcc, Status, errorMessage);

			}

			if (merchanttype != null && !merchanttype.trim().isEmpty()) {

				BL.clickElement(M.MerchantType);
				BL.enterElement(M.MerchantType, merchanttype);
				BL.TerminaltypeselectDropdownOption(merchanttype);

				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(M.MerchantTypeFieldRequired, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Merchant type", merchanttype,
						Status, errorMessage);

			}

			if (merchantClassification != null && !merchantClassification.trim().isEmpty()) {

				BL.clickElement(M.Merchantclarification);
				BL.selectDropdownOption(merchantClassification);
				String actualValue = BL.getElementText(M.Merchantclarification);
				boolean Status = true; // Assume success initially

				try {
					if (actualValue != null) {
						assertEquals(merchantClassification.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Merchant Classification",
						merchantClassification, Status, errorMessage);

			}

			if (frequency != null && !frequency.trim().isEmpty()) {

				BL.clickElement(A.StatementFrequency);
				BL.selectDropdownOption(frequency);
				String actualValue = BL.getElementText(A.StatementFrequency);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(frequency.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Statement Frequency", frequency,
						Status, errorMessage);

			}

			if (Type != null && !Type.trim().isEmpty()) {

				BL.clickElement(A.StatementType);
				BL.selectDropdownOption(Type);
				String actualValue = BL.getElementText(A.StatementType);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						BL.isElementNotDisplayed(A.CompanyStatementTypeFieldisRequired, "Field Required");
						assertEquals(Type.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : Statement Type", Type, Status,
						errorMessage);

			}

			boolean NextstepStatus = true;
			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
				// Click the Next Step button
				BL.clickElement(B.NextStep);

				// Check if the "Personal Info Page" element is displayed
				if (!BL.isElementDisplayed(A.IntroPersonalInfo, "Personal Info Page")) {
					// Set status to false, add error message, and take a screenshot if element is
					// not displayed
					NextstepStatus = false;
					errorMessageBuilder.append("Personal Info Page element not displayed as expected.");
					CustomWebDriverManager.takeScreenshotStr(" Merchant : Company Inof ");
				}
			} catch (Exception e) {
				// Handle unexpected errors and take a screenshot
				NextstepStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Merchant : Company Info");
			}

			// Log the test step with the appropriate status and any error messages
			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Company Info : ", "NextStep", NextstepStatus,
					errorMessageBuilder.toString());

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Company Info");
			throw e; // Re-throw the exception after handling
		}
		return null;

	}

	private void fillPersonalInfo(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {

			String errorMessage = "The data does not match or is empty.";

			Faker faker = new Faker();

			String title = testData.get("Title");
			String FirstName = testData.get("First Name");
			String LastName = testData.get("Last Name");
			String pan = testData.get("PAN");
			String Address = testData.get("Address");
			String pincode = testData.get("Personal Pincode");
			String PMobilenumber = testData.get("Personal Mobile Number");
			String telephone = testData.get("TelePhone Number");
			String emailid = testData.get("Email");
			String Nationality = testData.get("Nationality");
			String aadhaar = testData.get("Aadhaar Number");
			String Passport = testData.get("Passport");

			if (title != null && !title.trim().isEmpty()) {

				BL.clickElement(A.PersonalInfo);
				BL.clickElement(B.AddButton);
				BL.clickElement(A.titlepersonal);
				BL.selectDropdownOption(title);
				String actualValue = BL.getElementText(A.titlepersonal);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						BL.isElementNotDisplayed(A.PersonalinfoTitleFieldrequired, "Field is Required");
						assertEquals(title.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Title", title, Status,
						errorMessage);

			}

			if (FirstName != null && !FirstName.trim().isEmpty()) {

				BL.clickElement(A.FirstNamePersonal);

				BL.enterElement(A.FirstNamePersonal, FirstName);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalinfoFirstNameFieldrequired, "Field is Required");
					BL.isElementNotDisplayed(A.PersonalInfoFirstNameInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : FirstName", FirstName, Status,
						errorMessage);

			}

			if (LastName != null && !LastName.trim().isEmpty()) {

				BL.clickElement(A.LastNamePersonal);

				BL.enterElement(A.LastNamePersonal, LastName);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalInfoLastNameInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : LastName", LastName, Status,
						errorMessage);

			}

			boolean DateStatus = true; // Assume success initially

			try {
				BL.clickElement(A.OpenCalenderPersonal);
				BL.clickElement(A.ChooseMonthandYear);
				BL.clickElement(A.Year);
				BL.clickElement(A.Month);
				BL.clickElement(A.Date);
				BL.clickElement(A.ApplyButton);
				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
			} catch (AssertionError e) {
				DateStatus = false; // Set status to false if assertion fails
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Date Of Birth", "30/11/1998",
					DateStatus, errorMessage);

			if (pan != null && !pan.trim().isEmpty()) {

				BL.clickElement(A.PanPersonal);

				BL.enterElement(A.PanPersonal, pan);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalinfoPANFieldrequired, "Field is Required");
					BL.isElementNotDisplayed(A.PersonalInfoPanInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Pan", pan, Status, errorMessage);

			}

			if (Address != null && !Address.trim().isEmpty()) {

				BL.clickElement(A.AddressPersonal);

				BL.enterElement(A.AddressPersonal, Address);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalinfoAddressFieldrequired, "Field is Required");
					BL.isElementNotDisplayed(A.PersonalInfoAddressInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Address", Address, Status,
						errorMessage);

			}

			if (pincode != null && !pincode.trim().isEmpty()) {

				BL.clickElement(A.PincodePersonal);
				BL.enterElement(A.PincodePersonal, pincode);
				BL.selectDropdownOption(pincode);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {
					BL.isElementNotDisplayed(A.PersonalinfoPincodeFieldrequired, "Field is Required");
					BL.isElementNotDisplayed(A.PersonalInfoPincodeInvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Pincode", pincode, Status,
						errorMessage);

			}

			if (PMobilenumber != null && !PMobilenumber.trim().isEmpty()) {

				// Generate a valid mobile number starting with 9, 8, 7, or 6
				String firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6, 7, 8, or 9
				String remainingDigits = faker.number().digits(9); // Generate 9 random digits
				String Mobilenumber = firstDigit + remainingDigits;

				BL.clickElement(A.MobilePersonal);

				BL.enterElement(A.MobilePersonal, Mobilenumber);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {
					BL.isElementNotDisplayed(A.PersonalinfoMobileFieldrequired, "Field is Required");
					BL.isElementNotDisplayed(A.PersonalInfoMobileInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Mobilenumber", PMobilenumber,
						Status, errorMessage);

			}

			if (telephone != null && !telephone.trim().isEmpty()) {

				BL.clickElement(A.telephonepersonal);

				BL.enterElement(A.telephonepersonal, telephone);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalInfoTelephoneInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Telephone Number", telephone,
						Status, errorMessage);

			}

			if (emailid != null && !emailid.trim().isEmpty()) {

				BL.clickElement(A.emailPersonal);

				BL.enterElement(A.emailPersonal, emailid);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalinfoEmailFieldrequired, "Field is Required");
					BL.isElementNotDisplayed(A.PersonalinfoEmailFieldrequired, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Emailid", emailid, Status,
						errorMessage);

			}

			if (Nationality != null && !Nationality.trim().isEmpty()) {

				BL.clickElement(A.Nationalitypersonal);

				BL.enterElement(A.Nationalitypersonal, Nationality);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalinfoNationalityFieldrequired, "Field is Required");
					BL.isElementNotDisplayed(A.PersonalInfoNationalityInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Nationality", Nationality, Status,
						errorMessage);

			}

			if (aadhaar != null && !aadhaar.trim().isEmpty()) {

				BL.clickElement(A.AadhaarNumberPersonal);

				BL.enterElement(A.AadhaarNumberPersonal, aadhaar);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalInfoAadhaarInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Aadhaar", aadhaar, Status,
						errorMessage);

			}

			if (Passport != null && !Passport.trim().isEmpty()) {

				BL.clickElement(A.PassportNumberPersonal);

				BL.enterElement(A.PassportNumberPersonal, Passport);
				performTabKeyPress();
				boolean Status = true; // Assume success initially

				try {

					BL.isElementNotDisplayed(A.PersonalInfoPassportNumberInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Passport", Passport, Status,
						errorMessage);

			}

			try {

				BL.clickElement(A.OpenCalenderPasswordExpiryDate);

				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_ENTER);

				r.keyRelease(KeyEvent.VK_ENTER);

				BL.clickElement(A.ApplyButton);

				performTabKeyPress();

				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
			} catch (AssertionError e) {
				DateStatus = false; // Set status to false if assertion fails
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : Date", "Passport ExpiryDate",

					DateStatus, errorMessage);

			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
				// Click the save button
				BL.clickElement(B.SaveButton);

				// Check if either "Field is Required" or "Invalid Format" messages are
				// displayed
				boolean isFieldRequiredError = BL.SaveisElementDisplayed(B.Thisfieldrequired, "Field is Required");
				boolean isInvalidFormatError = BL.SaveisElementDisplayed(B.invalidmessage, "Invalid Format");

				// If any error is found, update the status, add messages, and take a single
				// screenshot
				if (isFieldRequiredError || isInvalidFormatError) {
					if (isFieldRequiredError) {
						errorMessageBuilder.append("Field Required Assertion Error; ");
					}

					if (isInvalidFormatError) {
						errorMessageBuilder.append("Invalid Format Assertion Error; ");
					}

					// Take a single screenshot for any error condition
					CustomWebDriverManager.takeScreenshotStr("Merchat : personal Info");
				}

				BL.clickElement(B.OKButton);

			} catch (Exception e) {
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Merchat : personal Info");
			}

			boolean NextstepStatus = true;
			try {
				BL.clickElement(B.NextStep);

				if (!BL.isElementDisplayed(A.CommunicationInfo, "Communication Info Page")) {

				}
			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("merchant : personal Info"); // Take screenshot on error

			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Personal Info : ", "NextStep", NextstepStatus,
					errorMessage);

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Personal Info");
			throw e; // Re-throw the exception after handling
		}

	}

	private void fillCommunicationDetailsAdminUserDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		try {

			String errorMessage = "The data does not match or is empty.";

			String CommName = testData.get("Communication Name");
			String CommPosition = testData.get("Communication Position");
			String CommMobileNumber = testData.get("Communication MobileNumber");
			String CommEmailid = testData.get("Communication EmailId");
			String ADUSer = testData.get("AD User");

			BL.clickElement(B.CommunicationInfo);

			BL.clickElement(B.ClickonCommADD);

			if (CommName != null && !CommName.trim().isEmpty()) {

				BL.clickElement(B.ClickonCommuName);

				BL.enterElement(B.ClickonCommuName, CommName);
				performTabKeyPress();
				boolean CommunicationNameStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.CommunicationNameInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(B.CommunicationNameFieldisRequired, "Field is Required");
				} catch (AssertionError e) {
					CommunicationNameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo,
						"MMS : Merchant Onboarding : Communication Info : Admin user details Communication Name",
						CommName, CommunicationNameStatus, errorMessage);

			}

			if (CommPosition != null && !CommPosition.trim().isEmpty()) {
				BL.clickElement(B.ClickonCommuPosition);

				BL.enterElement(B.ClickonCommuPosition, CommPosition);
				performTabKeyPress();
				boolean CommunicationPositionStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.CommunicationPositionInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(B.CommunicationPositionFieldisRequired, "Field is Required");
				} catch (AssertionError e) {
					CommunicationPositionStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo,
						"MMS : Merchant Onboarding : Communication Info : Admin user details Communication Position",
						CommPosition, CommunicationPositionStatus, errorMessage);

			}

			if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) {
				Faker faker = new Faker();

				// Generate a valid mobile number starting with 9, 8, 7, or 6
				String firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6, 7, 8, or 9
				String remainingDigits = faker.number().digits(9); // Generate 9 random digits
				String communicationMobileNumber = firstDigit + remainingDigits;
				BL.clickElement(B.ClickonCommuMobileNumber);

				BL.enterElement(B.ClickonCommuMobileNumber, communicationMobileNumber);

				performTabKeyPress();
				boolean CommunicationMobileNumberStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.CommunicationMobileInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(B.CommunicationMobileFieldisRequired, "Field is Required");
				} catch (AssertionError e) {
					CommunicationMobileNumberStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo,
						"MMS : Merchant Onboarding : Communication Info : Admin user details Communication MobileNumber",
						communicationMobileNumber, CommunicationMobileNumberStatus, errorMessage);

			}

			if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {

				Faker faker = new Faker();

				// Generate a random email address with @gmail.com
				String randomEmailPrefix = faker.internet().slug(); // Generate a random string for the prefix
				String Communicationemailid = randomEmailPrefix + "@gmail.com";
				BL.clickElement(B.ClickonCommuEmailId);

				BL.enterElement(B.ClickonCommuEmailId, Communicationemailid);
				performTabKeyPress();
				boolean CommunicationEmailIDStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.CommunicationEmailFieldisRequired, "Field is Required");

				} catch (AssertionError e) {
					CommunicationEmailIDStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo,
						"MMS : Merchant Onboarding : Communication Info : Admin user details Communication Emailid",
						Communicationemailid, CommunicationEmailIDStatus, errorMessage);

			}

			if (ADUSer != null && !ADUSer.trim().isEmpty()) {
				BL.clickElement(B.ClickOnAdUsers);
				BL.selectDropdownOption(ADUSer);

				String actualValue = BL.getElementText(B.ClickOnAdUsers);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(ADUSer.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Communication Info : Admin user details AD User",
						ADUSer, Status, errorMessage);

			}

			boolean saveStatus = true;
			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
				// Click the save button
				BL.clickElement(B.SaveButton);

				// Check if either "Field is Required" or "Invalid Format" messages are
				// displayed
				boolean isFieldRequiredError = BL.SaveisElementDisplayed(B.Thisfieldrequired, "Field is Required");
				boolean isInvalidFormatError = BL.SaveisElementDisplayed(B.invalidmessage, "Invalid Format");

				// If any error is found, update the status, add messages, and take a single
				// screenshot
				if (isFieldRequiredError || isInvalidFormatError) {
					saveStatus = false;

					if (isFieldRequiredError) {
						errorMessageBuilder.append("Field Required Assertion Error; ");
					}

					if (isInvalidFormatError) {
						errorMessageBuilder.append("Invalid Format Assertion Error; ");
					}

					// Take a single screenshot for any error condition
					CustomWebDriverManager.takeScreenshotStr("Bank : Communication : Admin");
				}

			} catch (Exception e) {
				saveStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Bank : Communication : Admin");
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Communication Info : ",
					"Admin user details Save Button", saveStatus, errorMessage);

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e; // Re-throw the exception after handling
		}
	}

	private void fillCommunicationDetailsSettlementReconContactDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		try {

			String errorMessage = "The data does not match or is empty.";

			String CommName = testData.get("Communication Name");
			String CommPosition = testData.get("Communication Position");
			String CommMobileNumber = testData.get("Communication MobileNumber");
			String CommEmailid = testData.get("Communication EmailId");

			BL.clickElement(B.CommunicationInfo);

			BL.clickElement(B.ClickonCommSettlementandReconADD);
			if (CommName != null && !CommName.trim().isEmpty()) {

				BL.clickElement(B.ClickonCommuName);

				BL.enterElement(B.ClickonCommuName, CommName);
				performTabKeyPress();
				boolean CommunicationNameStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.CommunicationNameInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(B.CommunicationNameFieldisRequired, "Field is Required");
				} catch (AssertionError e) {
					CommunicationNameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo,
						"MMS : Merchant Onboarding : Communication Info : SettlementReconContactDetails Communication Name",
						CommName, CommunicationNameStatus, errorMessage);

			}

			if (CommPosition != null && !CommPosition.trim().isEmpty()) {
				BL.clickElement(B.ClickonCommuPosition);

				BL.enterElement(B.ClickonCommuPosition, CommPosition);
				performTabKeyPress();
				boolean CommunicationPositionStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.CommunicationPositionInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(B.CommunicationPositionFieldisRequired, "Field is Required");
				} catch (AssertionError e) {
					CommunicationPositionStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo,
						"MMS : Merchant Onboarding : Communication Info : SettlementReconContactDetails Communication Position",
						CommPosition, CommunicationPositionStatus, errorMessage);

			}

			if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) {
				Faker faker = new Faker();

				// Generate a valid mobile number starting with 9, 8, 7, or 6
				String firstDigit = faker.number().numberBetween(6, 10) + ""; // Randomly choose 6, 7, 8, or 9
				String remainingDigits = faker.number().digits(9); // Generate 9 random digits
				String communicationMobileNumber = firstDigit + remainingDigits;

				BL.clickElement(B.ClickonCommuMobileNumber);

				BL.enterElement(B.ClickonCommuMobileNumber, communicationMobileNumber);
				performTabKeyPress();
				boolean CommunicationMobileNumberStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.CommunicationMobileInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(B.CommunicationMobileFieldisRequired, "Field is Required");
				} catch (AssertionError e) {
					CommunicationMobileNumberStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo,
						"MMS : Merchant Onboarding : Communication Info : SettlementReconContactDetails Communication MobileNumber",
						communicationMobileNumber, CommunicationMobileNumberStatus, errorMessage);

			}

			if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {

				Faker faker = new Faker();

				// Generate a random email address with @gmail.com
				String randomEmailPrefix = faker.internet().slug(); // Generate a random string for the prefix
				String Communicationemailid = randomEmailPrefix + "@gmail.com";
				BL.clickElement(B.ClickonCommuEmailId);

				BL.enterElement(B.ClickonCommuEmailId, Communicationemailid);
				performTabKeyPress();
				boolean CommunicationEmailIDStatus = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.CommunicationEmailFieldisRequired, "Field is Required");

				} catch (AssertionError e) {
					CommunicationEmailIDStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo,
						"MMS : Merchant Onboarding : Communication Info : SettlementReconContactDetails Communication Emailid",
						Communicationemailid, CommunicationEmailIDStatus, errorMessage);

			}

			boolean saveStatus = true;
			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
				// Click the save button
				BL.clickElement(B.SaveButton);

				// Check if either "Field is Required" or "Invalid Format" messages are
				// displayed
				boolean isFieldRequiredError = BL.SaveisElementDisplayed(B.Thisfieldrequired, "Field is Required");
				boolean isInvalidFormatError = BL.SaveisElementDisplayed(B.invalidmessage, "Invalid Format");

				// If any error is found, update the status, add messages, and take a single
				// screenshot
				if (isFieldRequiredError || isInvalidFormatError) {
					saveStatus = false;

					if (isFieldRequiredError) {
						errorMessageBuilder.append("Field Required Assertion Error; ");
					}

					if (isInvalidFormatError) {
						errorMessageBuilder.append("Invalid Format Assertion Error; ");
					}

					// Take a single screenshot for any error condition
					CustomWebDriverManager.takeScreenshotStr("Bank : Communication : settlement ");
				}

			} catch (Exception e) {
				saveStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Bank : Communication : settlement");
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Communication Info : ",
					"SettlementReconContactDetails Save Button", saveStatus, errorMessage);

			boolean NextstepStatus = true;
			try {
				BL.clickElement(B.NextStep);
				BL.isElementDisplayed(M.DisplayedonRiskInfo, "Risk Info Page");

			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Communication Info : ", "NextStep", NextstepStatus,
					errorMessage);

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e; // Re-throw the exception after handling
		}
	}

	private void fillRiskInfo(Map<String, String> testData, int TestcaseNo) throws Exception {

		String WDF = testData.get("Week Days From");

		String WDT = testData.get("Week Days To");

		String WEF = testData.get("Week Ends From");

		String WET = testData.get("Week Ends To");

		String VelocityCheckMinutes = testData.get("Velocity Check Minutes");

		String VelocityCheckCount = testData.get("Velocity Check Count");

		String CashPOSCount = testData.get("CashPOS Count");

		String card = testData.get("International Card Acceptance");

		String ICADAILY = testData.get("ICA Daily");

		String ICAWEEKLY = testData.get("ICA Weekly");

		String ICAMonthly = testData.get("ICA Monthly");

		String Channel1Daily = testData.get("Channel 1 Daily");

		String Channel1WEEKLY = testData.get("Channel 1 Weekly");

		String Channel1Monthly = testData.get("Channel 1 Monthly");

		String Channel1Minimum = testData.get("Channel 1 Minimum");

		String Channel1Maximum = testData.get("Channel 1 Maximum");

		String Channel2DAILY = testData.get("Channel 2 Daily");

		String Channel2WEEKLY = testData.get("Channel 2 Weekly");

		String Channel2Monthly = testData.get("Channel 2 Monthly");

		String Channel2Minimum = testData.get("Channel 2 Minimum");

		String Channel2Maximum = testData.get("Channel 2 Maximum");

		String Channel3DAILY = testData.get("Channel 3 Daily");

		String Channel3WEEKLY = testData.get("Channel 3 Weekly");

		String Channel3Monthly = testData.get("Channel 3 Monthly");

		String Channel3Minimum = testData.get("Channel 3 Minimum");

		String Channel3Maximum = testData.get("Channel 3 Maximum");

		String Channel4DAILY = testData.get("Channel 4 Daily");

		String Channel4WEEKLY = testData.get("Channel 4 Weekly");

		String Channel4Monthly = testData.get("Channel 4 Monthly");

		String Channel4Minimum = testData.get("Channel 4 Minimum");

		String Channel4Maximum = testData.get("Channel 4 Maximum");

		String Channel5Daily = testData.get("Channel 5 Daily");

		String Channel5Weekly = testData.get("Channel 5 Weekly");

		String Channel5Monthly = testData.get("Channel 5 Monthly");

		String Channel5Minimum = testData.get("Channel 5 Minimum");

		String Channel5Maximum = testData.get("Channel 5 Maximum");

		Thread.sleep(10000);

		String errorMessage = "Invalid Format";

		try {
			BL.clickElement(A.RiskINfo);
			BL.clickElement(B.GlobalFRMCheckbox);

			if (WDF != null && !WDF.trim().isEmpty()) {

				// Perform the actions for the Velocity Check Minutes

				BL.clickElement(M.WeekDaysFrom);
				BL.enterElement(M.WeekDaysFrom, WDF);
				boolean Status1 = true; // Assume success initially
				try {
					// Check if there is an invalid format
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					// If an AssertionError occurs, set the status to false and capture the error
					// message
					Status1 = false;
					errorMessage = e.getMessage();
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Week Days From", WDF, Status1,
						errorMessage);
			}

			if (WDT != null && !WDT.trim().isEmpty()) {

				// Perform the actions for the Velocity Check Minutes

				BL.clickElement(M.WeekDaysTo);
				BL.enterElement(M.WeekDaysTo, WDT);
				performTabKeyPress();
				boolean Status1 = true; // Assume success initially
				try {
					// Check if there is an invalid format
					BL.isElementNotDisplayed(M.WeekDaysToInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					// If an AssertionError occurs, set the status to false and capture the error
					// message
					Status1 = false;
					errorMessage = e.getMessage();
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Week Days TO", WDT, Status1,
						errorMessage);
			}

			if (WEF != null && !WEF.trim().isEmpty()) {

				// Perform the actions for the Velocity Check Minutes

				BL.clickElement(M.WeekEndFrom);
				BL.enterElement(M.WeekEndFrom, WEF);
				boolean Status1 = true; // Assume success initially
				try {
					// Check if there is an invalid format
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					// If an AssertionError occurs, set the status to false and capture the error
					// message
					Status1 = false;
					errorMessage = e.getMessage();
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Week END From", WEF, Status1,
						errorMessage);
			}

			if (WET != null && !WET.trim().isEmpty()) {

				// Perform the actions for the Velocity Check Minutes

				BL.clickElement(M.WeekEndTo);
				BL.enterElement(M.WeekEndTo, WET);
				performTabKeyPress();
				boolean Status1 = true; // Assume success initially
				try {
					// Check if there is an invalid format
					BL.isElementNotDisplayed(M.WeekEndsToInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					// If an AssertionError occurs, set the status to false and capture the error
					// message
					Status1 = false;
					errorMessage = e.getMessage();
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Week END To", WET, Status1,
						errorMessage);
			}
			if (VelocityCheckMinutes != null && !VelocityCheckMinutes.trim().isEmpty()) {

				// Perform the actions for the Velocity Check Minutes
				BL.clickElement(A.VelocityCheckMinute);

				BL.enterElement(A.VelocityCheckMinute, VelocityCheckMinutes);
				performTabKeyPress();
				boolean Status1 = true; // Assume success initially
				try {
					// Check if there is an invalid format
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					// If an AssertionError occurs, set the status to false and capture the error
					// message
					Status1 = false;
					errorMessage = e.getMessage();
				}

				// Log the test step with the test case number, field, input value, status, and
				// error message (if any)
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Velocity Check Minutes",
						VelocityCheckMinutes, Status1, errorMessage);
			}

			if (VelocityCheckCount != null && !VelocityCheckCount.trim().isEmpty()) {
				BL.clickElement(A.VelocityCheckCount);

				BL.enterElement(A.VelocityCheckCount, VelocityCheckMinutes);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Velocity Check Count",
						VelocityCheckCount, Status, errorMessage);

			}

			if (CashPOSCount != null && !CashPOSCount.trim().isEmpty()) {

				BL.clickElement(A.CashPOSCount);
				BL.enterElement(A.CashPOSCount, CashPOSCount);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : CashPOSCount", CashPOSCount, Status,
						errorMessage);

			}

			if (card != null && !card.trim().isEmpty()) {

				BL.clickElement(A.InternationalCardCount);

				BL.selectDropdownOption(card);
				performTabKeyPress();
				String actualValue = BL.getElementText(A.InternationalCardCount);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(card.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : International Card Acceptance", card,
						Status, errorMessage);

			}

//ICA		

			if (ICADAILY != null && !ICADAILY.trim().isEmpty()) {

				BL.clickElement(A.ICADaily);
				BL.enterElement(A.ICADaily, ICADAILY);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.ICADailyFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(B.ICAdailylessthanweeklylimtError, "Field is Required");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : ICA DAILY", ICADAILY, Status,
						errorMessage);

			}

			if (ICAWEEKLY != null && !ICAWEEKLY.trim().isEmpty()) {

				BL.clickElement(A.ICAWeekly);
				BL.enterElement(A.ICAWeekly, ICAWEEKLY);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.ICAWeeklyFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(B.ICAWeeklygreaterthanDailylimtError, "Field is Required");
					BL.isElementNotDisplayed(B.ICAWeeklylessthanmonthlylimtError, "Field is Required");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : ICA WEEKLY", ICAWEEKLY, Status,
						errorMessage);

			}

			if (ICAMonthly != null && !ICAMonthly.trim().isEmpty()) {

				BL.clickElement(A.ICAMonthly);
				BL.enterElement(A.ICAMonthly, ICAMonthly);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.ICAMonthlyFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(B.ICAMonthlygreaterthanweeklylimtError, "Field is Required");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : ICA Monthly", ICAMonthly, Status,
						errorMessage);

			}

//POS	

			if (Channel1Daily != null && !Channel1Daily.trim().isEmpty()) {
				BL.clickElement(B.POSDaily);

				BL.CLearElement(B.POSDaily);

				BL.enterElement(B.POSDaily, Channel1Daily);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 1 Daily", Channel1Daily,
						Status, errorMessage);

			}

			if (Channel1WEEKLY != null && !Channel1WEEKLY.trim().isEmpty()) {

				BL.clickElement(B.POSWeekly);

				BL.CLearElement(B.POSWeekly);

				BL.enterElement(B.POSWeekly, Channel1WEEKLY);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 1 WEEKLY", Channel1WEEKLY,
						Status, errorMessage);

			}

			if (Channel1Monthly != null && !Channel1Monthly.trim().isEmpty()) {
				BL.clickElement(B.POSMonthly);

				BL.CLearElement(B.POSMonthly);

				BL.enterElement(B.POSMonthly, Channel1Monthly);

				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 1 Monthly", Channel1Monthly,
						Status, errorMessage);

			}

			if (Channel1Minimum != null && !Channel1Minimum.trim().isEmpty()) {
				BL.clickElement(B.POSMinimumAmount);

				BL.CLearElement(B.POSMinimumAmount);

				BL.enterElement(B.POSMinimumAmount, Channel1Minimum);
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info :Channel 1 Minimum", Channel1Minimum,
						Status, errorMessage);

			}

			if (Channel1Maximum != null && !Channel1Maximum.trim().isEmpty()) {
				BL.clickElement(B.POSMaximumAmount);

				BL.CLearElement(B.POSMaximumAmount);

				BL.enterElement(B.POSMaximumAmount, Channel1Maximum);
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 1 Maximum", Channel1Maximum,
						Status, errorMessage);

			}

//UPI

			if (Channel2DAILY != null && !Channel2DAILY.trim().isEmpty()) {
				BL.clickElement(B.UPIDaily);

				BL.CLearElement(B.UPIDaily);

				BL.enterElement(B.UPIDaily, Channel2DAILY);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 2 DAILY", Channel2DAILY,
						Status, errorMessage);

			}

			if (Channel2WEEKLY != null && !Channel2WEEKLY.trim().isEmpty()) {
				BL.clickElement(B.UPIWeekly);

				BL.CLearElement(B.UPIWeekly);

				BL.enterElement(B.UPIWeekly, Channel2WEEKLY);
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 2 WEEKLY", Channel2WEEKLY,
						Status, errorMessage);

			}

			if (Channel2Monthly != null && !Channel2Monthly.trim().isEmpty()) {
				BL.clickElement(B.UPIMonthly);

				BL.CLearElement(B.UPIMonthly);

				BL.enterElement(B.UPIMonthly, Channel2Monthly);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Aggregator Onboarding : Risk Info : Channel 2 Monthly", Channel2Monthly,
						Status, errorMessage);

			}

			if (Channel2Minimum != null && !Channel2Minimum.trim().isEmpty()) {
				BL.clickElement(B.UPIMinimumAmount);

				BL.CLearElement(B.UPIMinimumAmount);

				BL.enterElement(B.UPIMinimumAmount, Channel2Minimum);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 2 Minimum", Channel2Minimum,
						Status, errorMessage);

			}

			if (Channel2Maximum != null && !Channel2Maximum.trim().isEmpty()) {

				BL.clickElement(B.UPIMaximumAmount);

				BL.CLearElement(B.UPIMaximumAmount);

				BL.enterElement(B.UPIMaximumAmount, Channel2Maximum);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 2 Maximum", Channel2Maximum,
						Status, errorMessage);

			}

//AEPS		
			if (Channel3DAILY != null && !Channel3DAILY.trim().isEmpty()) {
				BL.clickElement(B.AEPSDaily);

				BL.CLearElement(B.AEPSDaily);

				BL.enterElement(B.AEPSDaily, Channel3DAILY);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 3 DAILY", Channel3DAILY,
						Status, errorMessage);

			}

			if (Channel3WEEKLY != null && !Channel3WEEKLY.trim().isEmpty()) {
				BL.clickElement(B.AEPSWeekly);

				BL.CLearElement(B.AEPSWeekly);

				BL.enterElement(B.AEPSWeekly, Channel3WEEKLY);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 3 WEEKLY", Channel3WEEKLY,
						Status, errorMessage);

			}

			if (Channel3Monthly != null && !Channel3Monthly.trim().isEmpty()) {
				BL.clickElement(B.AEPSMonthly);

				BL.CLearElement(B.AEPSMonthly);

				BL.enterElement(B.AEPSMonthly, Channel3Monthly);
				performTabKeyPress();

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 3 Monthly", Channel3Monthly,
						Status, errorMessage);

			}

			if (Channel3Minimum != null && !Channel3Minimum.trim().isEmpty()) {
				BL.clickElement(B.AEPSMinimumAmount);

				BL.CLearElement(B.AEPSMinimumAmount);

				BL.enterElement(B.AEPSMinimumAmount, Channel3Minimum);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 3 Minimum", Channel3Minimum,
						Status, errorMessage);

			}

			if (Channel3Maximum != null && !Channel3Maximum.trim().isEmpty()) {

				BL.clickElement(B.AEPSMaximumAmount);

				BL.CLearElement(B.AEPSMaximumAmount);

				BL.enterElement(B.AEPSMaximumAmount, Channel3Maximum);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 3 Maximum", Channel3Maximum,
						Status, errorMessage);

			}

//MATM

			if (Channel4DAILY != null && !Channel4DAILY.trim().isEmpty()) {
				BL.clickElement(B.MATMDaily);

				BL.CLearElement(B.MATMDaily);

				BL.enterElement(B.MATMDaily, Channel4DAILY);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 4 DAILY", Channel4DAILY,
						Status, errorMessage);

			}

			if (Channel4WEEKLY != null && !Channel4WEEKLY.trim().isEmpty()) {
				BL.clickElement(B.MATMWeekly);

				BL.CLearElement(B.MATMWeekly);

				BL.enterElement(B.MATMWeekly, Channel4WEEKLY);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 4 WEEKLY", Channel4WEEKLY,
						Status, errorMessage);

			}

			if (Channel4Monthly != null && !Channel4Monthly.trim().isEmpty()) {
				BL.clickElement(B.MATMMonthly);

				BL.CLearElement(B.MATMMonthly);

				BL.enterElement(B.MATMMonthly, Channel4Monthly);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Equal Value Not Allowed");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 4 Monthly", Channel4Monthly,
						Status, errorMessage);

			}

			if (Channel4Minimum != null && !Channel4Minimum.trim().isEmpty()) {
				BL.clickElement(B.MATMMinimumAmount);

				BL.CLearElement(B.MATMMinimumAmount);

				BL.enterElement(B.MATMMinimumAmount, Channel4Minimum);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 4 Minimum", Channel4Minimum,
						Status, errorMessage);

			}

			if (Channel4Maximum != null && !Channel4Maximum.trim().isEmpty()) {

				BL.clickElement(B.MATMMaximumAmount);

				BL.CLearElement(B.MATMMaximumAmount);

				BL.enterElement(B.MATMMaximumAmount, Channel4Maximum);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 4 Maximum", Channel4Maximum,
						Status, errorMessage);

			}

//PG

			if (Channel5Daily != null && !Channel5Daily.trim().isEmpty()) {
				BL.clickElement(B.PGDaily);

				BL.CLearElement(B.PGDaily);

				BL.enterElement(B.PGDaily, Channel5Daily);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 5 DAILY", Channel5Daily,
						Status, errorMessage);

			}

			if (Channel5Weekly != null && !Channel5Weekly.trim().isEmpty()) {
				BL.clickElement(B.PGWeekly);

				BL.CLearElement(B.PGWeekly);

				BL.enterElement(B.PGWeekly, Channel5Weekly);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 5 WEEKLY", Channel5Weekly,
						Status, errorMessage);

			}

			if (Channel5Monthly != null && !Channel5Monthly.trim().isEmpty()) {
				BL.clickElement(B.PGMonthly);

				BL.CLearElement(B.PGMonthly);

				BL.enterElement(B.PGMonthly, Channel5Monthly);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Equal Value Not Allowed");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 5 Monthly", Channel5Monthly,
						Status, errorMessage);

			}

			if (Channel5Minimum != null && !Channel5Minimum.trim().isEmpty()) {
				BL.clickElement(B.PGMinimumAmount);

				BL.CLearElement(B.PGMinimumAmount);

				BL.enterElement(B.PGMinimumAmount, Channel4Minimum);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 5 Minimum", Channel5Minimum,
						Status, errorMessage);

			}

			if (Channel5Maximum != null && !Channel5Maximum.trim().isEmpty()) {

				BL.clickElement(B.PGMaximumAmount);

				BL.CLearElement(B.PGMaximumAmount);

				BL.enterElement(B.PGMaximumAmount, Channel5Maximum);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : Channel 5 Maximum", Channel5Maximum,
						Status, errorMessage);

			}
			boolean NextstepStatus = true;
			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
				// Click the Next Step button
				BL.clickElement(B.NextStep);

				// Check if the "Personal Info Page" element is displayed
				if (!BL.isElementDisplayed(M.DisplayedonCardBin, " Card Bin Page")) {
					// Set status to false, add error message, and take a screenshot if element is
					// not displayed
					NextstepStatus = false;
					errorMessageBuilder.append("Personal Info Page element not displayed as expected.");
					CustomWebDriverManager.takeScreenshotStr("Merchant : Risk Info ");
				}
			} catch (Exception e) {
				// Handle unexpected errors and take a screenshot
				NextstepStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Merchant : Risk Info");
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Risk Info : ", "NextStep", NextstepStatus,
					errorMessage);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Risk Info");
			throw e;
		}
	}

	private void fillKYCDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		try {

			String errorMessage = "The data does not match or is empty.";

			String poAImage = testData.get("Company Proof of address");

			String Panimage = testData.get("Company Pan Image");
			Thread.sleep(1000);

			BL.ActionclickElement(B.Kyc);

			if (poAImage != null && !poAImage.trim().isEmpty()) {

				Thread.sleep(3000);
				BL.UploadImage(A.CompanyProofofaddressUpload, poAImage);
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : KYC : KYC Details", poAImage, Status,
						errorMessage);

			}

			if (Panimage != null && !Panimage.trim().isEmpty()) {

				Thread.sleep(2000);
				BL.UploadImage(A.CompanyPANUpload, Panimage);
				Thread.sleep(3000);
				BL.clickElement(B.NextStep);

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : KYC : KYC Details - PAN ", Panimage, Status,
						errorMessage);

			}

			boolean NextstepStatus = true;
			try {
				BL.clickElement(B.NextStep);
				if (!BL.isElementDisplayed(M.DisplayedonPaymentBridge, " Payment Bridge Page")) {
					throw new AssertionError("Assertion Error ");
				}
			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Merchant : KYC "); // Take screenshot on error

			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : KYC :", "NextStep", NextstepStatus, errorMessage);

		} catch (Exception e) {
			// Handle and log exceptions
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Merchant : KYC");
			throw e;
		}
	}

	private void FillDiscountRate(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException, IOException {

		try {
			// Initialize BankLocators and AggregatorLocators only once
			if (B == null) {

			}
			if (A == null) {

			}

			// Load cached data for "Channel Bank" sheet
			
			
				String errorMessage = "he data does not match or is empty.";
	
				String DiscountIdFromRegression = testData.get("T & D Ref ID");
	
				List<Map<String, String>> cachedData = cache.getCachedData("Discount Rate Merchant");
				int numberOfRows = cachedData.size();
				System.out.println("Total rows found: " + numberOfRows);
	
				for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
					System.out.println("Running test for row number: " + (currentRow + 1));
					Map<String, String> testData1 = cachedData.get(currentRow);
					System.out.println("Test data: " + testData);
	
					// Retrieve the Merchant ID from the terminal data	
					String DiscountRateID = testData1.get("T & D Ref ID");
	
					if (DiscountIdFromRegression != null && !DiscountIdFromRegression.equals(DiscountRateID)) {
						continue; // Skip processing this terminal record if the Merchant IDs don't match
					}

				// Retrieve data for each field, handling null or empty values
				String channel = testData1.getOrDefault("Channel", "").trim();
				String pricingPlan = testData1.getOrDefault("Pricing plan", "").trim();

				// Clear the key-value arrays before each iteration
				key.clear();
				value.clear();

				// Process Channel Bank Name

				// Process Channel
				if (!channel.isEmpty()) {

					BL.clickElement(A.DiscountRate);
					Thread.sleep(1000);

					BL.clickElement(B.ChannelADD);

					Thread.sleep(1000);
                    BL.clickElement(B.ClickOnChannel);

                    BL.selectDropdownOption(channel);

                    key.add("Channel-" + currentRow);
                    value.add(channel);

                    performTabKeyPress();
                    String actualValue = BL.getElementText(B.ClickOnChannel);

                    boolean Status = true;
                    try {
                    if (actualValue != null) {
                        assertEquals(channel.toLowerCase(), actualValue.toLowerCase());
                    }
                    } catch (AssertionError e) {
                        Status = false;
                        errorMessage = e.getMessage();
                    }
                    logTestStep(TestcaseNo, "MMS : Group Merchant Onboarding : Discount Rate : Channel", channel, Status,
                            errorMessage);

                } else {
                    System.out.println("Channel data is empty for row: " + currentRow);
                }
				// Process Network
				if (!pricingPlan.isEmpty()) {
					Thread.sleep(1000);
					BL.clickElement(A.DiscountRatePricingPlan);
					BL.selectDropdownOption(pricingPlan);

					performTabKeyPress();
					String actualValue = BL.getElementText(A.DiscountRatePricingPlan);

					boolean Status = true;
					try {
						if (actualValue != null) {

							BL.isElementNotDisplayed(A.DiscountRatePricingPlanFieldRequired, "Field is Required");
							assertEquals(pricingPlan.toUpperCase(), actualValue.toUpperCase());
						}
					} catch (AssertionError e) {
						Status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Group Merchant Onboarding : Discount Rate : Pricing Plan", pricingPlan,
							Status, errorMessage);

				} else {
					System.out.println("Network data is empty for row: " + currentRow);
				}

				// Process Save Button
				boolean saveStatus = true;
				try {
					BL.clickElement(B.SaveButton);
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");

				} catch (AssertionError e) {
					saveStatus = false;
					errorMessage = e.getMessage();
				}

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Discount Rate : Save Button", "ISO Discount Rate",
						saveStatus, errorMessage);
			}

			boolean NextstepStatus = true;
			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
				// Click the Next Step button
				BL.clickElement(B.NextStep);

				// Check if the "Personal Info Page" element is displayed
				if (!BL.isElementDisplayed(A.IntroSettlementInfo, " Settlement Info Page ")) {
					// Set status to false, add error message, and take a screenshot if element is
					// not displayed
					NextstepStatus = false;
					errorMessageBuilder.append("Personal Info Page element not displayed as expected.");
					CustomWebDriverManager.takeScreenshotStr("Merchant : Sales info ");
				}
			} catch (Exception e) {
				// Handle unexpected errors and take a screenshot
				NextstepStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Merchant : Discount Rate");
			}
			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : DiscountRate : ", "NextStep", NextstepStatus,
					errorMessage);

		} catch (Exception e) {
			// Handle and log exceptions
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Channel Config-Aggregator");
			throw e;
		}
	}

	private void fillSettlementInfo(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		String errorMessage = "The data does not match or is empty.";

		String paymentmode = testData.get("Payment Mode");
		String Account = testData.get("Account Type");
		String IFSCCode = testData.get("IFSC Code");

		String BanKAccountNumber = testData.get("Bank Account Number");
		String flag = testData.get("Settlement Flag");

		try {

			BL.clickElement(B.SettlementInfo);

			BL.clickElement(B.AddButton);

			if (paymentmode != null && !paymentmode.trim().isEmpty()) {

				BL.clickElement(M.PaymentMode);

				BL.selectDropdownOption(paymentmode);

				String actualValue = BL.getElementText(M.PaymentMode);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(paymentmode.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Settlement Info : Payment Mode", paymentmode,
						Status, errorMessage);

			}

			if (Account != null && !Account.trim().isEmpty()) {
				BL.clickElement(B.SettlementAccountType);

				BL.selectDropdownOption(Account);

				String actualValue = BL.getElementText(B.SettlementAccountType);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						BL.isElementNotDisplayed(B.SettlementAccTypeFieldisRequired, "Field is Required");
						assertEquals(Account.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Settlement Info : Settlement AccountType", Account,
						Status, errorMessage);

			}

			if (BanKAccountNumber != null && !BanKAccountNumber.trim().isEmpty()) {
				BL.clickElement(B.SettlementBankAccountNumber);
				BL.enterElement(B.SettlementBankAccountNumber, BanKAccountNumber);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.SettlementBankAccNumberFieldisRequired, "Field is Required");
					assertEquals(BanKAccountNumber.toUpperCase(),
							BL.getElementText(B.SettlementBankAccountNumber).toUpperCase());
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Settlement Info : BanKAccountNumber",
						BanKAccountNumber, Status, errorMessage);

			}

			if (IFSCCode != null && !IFSCCode.trim().isEmpty()) {

				BL.clickElement(B.SettlementIFSCCode);
				BL.enterElement(B.SettlementIFSCCode, IFSCCode);
				BL.selectDropdownOption(IFSCCode);

				performTabKeyPress();

				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.SettlementIFSCFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(B.SettlementIFSCInvalid, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Settlement Info : IFSC Code", IFSCCode, Status,
						errorMessage);

			}

			boolean saveStatus = true;
			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
				// Click the save button
				BL.clickElement(B.SaveButton);

				// Check if either "Field is Required" or "Invalid Format" messages are
				// displayed
				boolean isFieldRequiredError = BL.SaveisElementDisplayed(B.Thisfieldrequired, "Field is Required");
				boolean isInvalidFormatError = BL.SaveisElementDisplayed(B.invalidmessage, "Invalid Format");

				// If any error is found, update the status, add messages, and take a single
				// screenshot
				if (isFieldRequiredError || isInvalidFormatError) {
					saveStatus = false;

					if (isFieldRequiredError) {
						errorMessageBuilder.append("Field Required Assertion Error; ");
					}

					if (isInvalidFormatError) {
						errorMessageBuilder.append("Invalid Format Assertion Error; ");
					}

					// Take a single screenshot for any error condition
					CustomWebDriverManager.takeScreenshotStr("Merchant : Settlement Bank Details");
				}

			} catch (Exception e) {
				saveStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Error: Unexpected_Save_Error");
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Settlement Info : Save Button", "Settlement Info",
					saveStatus, errorMessage);

			if (flag != null && !flag.trim().isEmpty()) {

				BL.clickElement(M.SettlementFlag);

				BL.selectDropdownOption(flag);
				boolean Status = true; // Assume success initially
				try {

					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Settlement Info : Settlement Flag", flag, Status,
						errorMessage);

			}
			boolean NextstepStatus = true;
			new StringBuilder();

			try {
				// Click the Next Step button
				BL.clickElement(B.NextStep);

				// Check if the "Personal Info Page" element is displayed
				if (!BL.isElementDisplayed(M.DisplayedonTerminals, " Merchant Terminals Page ")) {
					// Set status to false, add error message, and take a screenshot if element is
					// not displayed
					NextstepStatus = false;
					errorMessageBuilder.append("Personal Info Page element not displayed as expected.");
					CustomWebDriverManager.takeScreenshotStr("Merchant : Settlement Details ");
				}
			} catch (Exception e) {
				// Handle unexpected errors and take a screenshot
				NextstepStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Merchant : Discount Rate");
			}
			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Settlement Info : ", "NextStep", NextstepStatus,
					errorMessage);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}

	}

	private void fillTerminalDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {

		try {

			Thread.sleep(10000);
			String errorMessage = "The Terminaldata does not match or is empty.";

			String merchantIdFromRegression = testData.get("T & D Ref ID");

			List<Map<String, String>> cachedData = cache.getCachedData("Terminals");
			int numberOfRows = cachedData.size();
			System.out.println("Total rows found: " + numberOfRows);

			for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
				System.out.println("Running test for row number: " + (currentRow + 1));
				Map<String, String> testData1 = cachedData.get(currentRow);
				System.out.println("Test data: " + testData);

				// Retrieve the Merchant ID from the terminal data
				String terminalMerchantId = testData1.get("T & D Ref ID");

				if (merchantIdFromRegression != null && !merchantIdFromRegression.equals(terminalMerchantId)) {
					continue; // Skip processing this terminal record if the Merchant IDs don't match
				}

				String terminalName = testData1.get("Terminal Name");
				String terminalType = testData1.get("Terminal Type");
				String upiTerminaltype = testData1.get("UPI Terminal Type");
				String upiOfflinetype = testData1.get("UPI Offline Type");
				String deviceModel = testData1.get("Device Model");
				String deviceNumber = testData1.get("Device Number");
				String imeiNumber = testData1.get("IMEI Number");
				String deviceType = testData1.get("Device Type");
				String deviceCommercialmode = testData1.get("Device Commercial Mode");
				String tidFeeapplicable = testData1.get("TID Fee Applicable");
				String DevicePrice = testData1.get("Device Price");
				String InstallationFee = testData1.get("Installation Fee");

				new ArrayList<>();
				new ArrayList<>();

				BL.clickElement(B.AddButton);

				if (terminalName != null && !terminalName.trim().isEmpty()) {
					BL.clickElement(T.TerminalName);
					BL.enterElement(T.TerminalName, terminalName);
					performTabKeyPress();
					boolean status = true;
					try {
						BL.isElementNotDisplayed(M.TerminalNameFieldRequired, "Field is Required");
						BL.isElementNotDisplayed(M.TerminalNameInvalidFormat, "Invalid Format");
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Terminal Name", terminalName,
							status, errorMessage);
				}

				if (terminalType != null && !terminalType.trim().isEmpty()) {
					BL.clickElement(T.Terminaltype);
					BL.TerminaltypeselectDropdownOption(terminalType);

					System.out.println("_______________________________________________" + terminalType);
//					performTabKeyPress();
					String actualValue = BL.getElementText(T.Terminaltype);
					boolean status = true;
					try {
						if (actualValue != null) {
							BL.isElementNotDisplayed(M.TerminalTypeFieldRequired, "Field is Required");
							assertEquals(terminalType.toUpperCase(), actualValue.toUpperCase());
						}
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Terminal Type", terminalType,
							status, errorMessage);
				}

				if (upiTerminaltype != null && !upiTerminaltype.trim().isEmpty()) {
					BL.clickElement(M.UPITerminalType);
					BL.selectDropdownOption(upiTerminaltype);
					performTabKeyPress();
					boolean status = true;
					try {
						BL.isElementNotDisplayed(M.UPITerminalTypeFieldReqired, "Field is Required");
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}
					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : UPI Terminal Type",
							upiTerminaltype, status, errorMessage);
				}

				if (upiOfflinetype != null && !upiOfflinetype.trim().isEmpty()) {
					BL.clickElement(M.UPIofflineType);
					BL.selectDropdownOption(upiOfflinetype);
					boolean status = true;
					try {
						BL.isElementNotDisplayed(M.UPIOfflineTypeFieldReqired, "Field is Required");
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : UPI Offline Type", upiOfflinetype,
							status, errorMessage);
				}

				if (deviceModel != null && !deviceModel.trim().isEmpty()) {
					BL.clickElement(T.DeviceModel);
					BL.enterElement(T.DeviceModel, deviceModel);
					Thread.sleep(1000);
					BL.selectDropdownOption(deviceModel);
					String actualValue = BL.getElementText(T.DeviceModel);
					boolean status = true;
					try {
						if (actualValue != null) {
							assertEquals(deviceModel.toUpperCase(), actualValue.toUpperCase());
						}
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Device Model", deviceModel, status,
							errorMessage);
				}

				if (deviceNumber != null && !deviceNumber.trim().isEmpty()) {
					BL.clickElement(T.DeviceNumber);
					BL.enterElement(T.DeviceNumber, deviceNumber);

					boolean status = true;
					try {
						BL.isElementNotDisplayed(B.InvalidFormat, "Invalidformat");
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Device Number", deviceNumber,
							status, errorMessage);
				}

				if (imeiNumber != null && !imeiNumber.trim().isEmpty()) {
					BL.clickElement(T.IMEINumber);
					BL.enterElement(T.IMEINumber, imeiNumber);
					boolean status = true;
					try {
						BL.isElementNotDisplayed(B.InvalidFormat, "Invalidformat");
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : IMEI Number", imeiNumber, status,
							errorMessage);
				}

				if (deviceType != null && !deviceType.trim().isEmpty()) {
					BL.clickElement(M.DeviceType);
					BL.selectDropdownOption(deviceType);
					String actualValue = BL.getElementText(M.DeviceType);
					boolean status = true;
					try {
						if (actualValue != null) {
							assertEquals(deviceType.toUpperCase(), actualValue.toUpperCase());
						}
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Device Type", deviceType, status,
							errorMessage);
				}

				if (deviceCommercialmode != null && !deviceCommercialmode.trim().isEmpty()) {
					BL.clickElement(T.DeviceCommericialmode);
					BL.selectDropdownOption(deviceCommercialmode);
					String actualValue = BL.getElementText(T.DeviceCommericialmode);
					boolean status = true;
					try {
						if (actualValue != null) {
							BL.isElementNotDisplayed(M.DeviceCommericialModeFieldRequired, "Invalidformat");
							assertEquals(deviceCommercialmode.toUpperCase(), actualValue.toUpperCase());
						}

					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Device Commercial Mode",
							deviceCommercialmode, status, errorMessage);
				}

				if (tidFeeapplicable != null && !tidFeeapplicable.trim().isEmpty()) {
					BL.clickElement(T.TIDFeeApplicable);
					BL.selectDropdownOption(tidFeeapplicable);
					String actualValue = BL.getElementText(T.TIDFeeApplicable);
					boolean status = true;
					try {
						if (actualValue != null) {
							BL.isElementNotDisplayed(M.TidFeeApplicableFieldRequired, "Invalidformat");
							assertEquals(tidFeeapplicable.toUpperCase(), actualValue.toUpperCase());
						}
					} catch (AssertionError e) {
						status = false;
						errorMessage = e.getMessage();
					}

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : TID Fee Applicable",
							tidFeeapplicable, status, errorMessage);

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

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Device Price", DevicePrice, Status,
							errorMessage);
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

					logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Installation Fee", InstallationFee,
							Status, errorMessage);
				}

				StringBuilder errorMessageBuilder = new StringBuilder();

				try {
					BL.clickElement(B.SaveButton);

					// Check if either "Field is Required" or "Invalid Format" messages are
					// displayed
					boolean isFieldRequiredError = BL.SaveisElementDisplayed(B.Thisfieldrequired, "Field is Required");
					boolean isInvalidFormatError = BL.SaveisElementDisplayed(B.invalidmessage, "Invalid Format");

					// If any error is found, update the status, add messages, and take a single
					// screenshot
					if (isFieldRequiredError || isInvalidFormatError) {
						if (isFieldRequiredError) {
							errorMessageBuilder.append("Field Required Assertion Error; ");
						}

						if (isInvalidFormatError) {
							errorMessageBuilder.append("Invalid Format Assertion Error; ");
						}

						// Take a single screenshot for any error condition
						CustomWebDriverManager.takeScreenshotStr("Merchant : Terminal ");
					}

				} catch (Exception e) {
					errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
					CustomWebDriverManager.takeScreenshotStr("Error: Unexpected_Save_Error");

				}

			} // End of for loop

			try {

				BL.clickElement(B.NextStep);

				if (!BL.isElementDisplayed(A.IntroKYC, "KYC Page")) {
					throw new AssertionError("Assertion Error ");

				}
			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Bank : Channel Config "); // Take screenshot on error

			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Terminals : Next Step", "Proceeding to KYC Page", true,
					"");
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Terminal Info");
			throw e;
		}
	}

	@When("the System Verifier clicks the Merchant module")

	public void SystemVerifierClicktheSUBISOModule() {

		try {

			BL.clickElement(B.ClickOnMerchant);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@Then("the System Verifier completes Merchant Onboarding, the system should prompt to verify all steps using the sheet name {string}")
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

				int rowTestCaseCount = runTestForRow1(rowData, rowNumber);
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
				performLogout(rowNumber);
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

	private int runTestForRow1(Map<String, String> testData, int rowNumber) throws Exception {

		// Log the test data for the current row
		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Initialize the locators (e.g., BankLocators)
		B = new org.Locators.BankLocators(driver);

		int testCaseCount = 0;

		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow1(testData, rowNumber);

		return testCaseCount;

	}

	@SuppressWarnings("unused")
	private int validateFieldsForRow1(Map<String, String> testData, int TestcaseNo) throws Exception {

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

		String LegalName = testData.get("LegalName");

		key.clear();
		value.clear();

		try {

			String errorMessage = "The data does not match or is empty.";

			boolean Status = true;
			try {
				Thread.sleep(3000);

				BL.clickElement(B.SearchbyBankName);
				Thread.sleep(1000);

				BL.enterSplitElement(B.SearchbyBankName, LegalName);

				Thread.sleep(3000);

				BL.clickElement(B.ActionClick);

				Thread.sleep(2000);

				BL.ActionclickElement(B.ViewButton);

			} catch (AssertionError e) {
				Status = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS :  Merchant Onboarding :Actions and View", "  Merchant Status Inprogress",
					Status, errorMessage);

			boolean verifiedStatus = true;
			try {

				Thread.sleep(1000);

				BL.isElementDisplayed(A.SalesInfo, "Sales Info");

				BL.clickElement(A.SalesInfo);

//				BL.clickElement(A.ManualTakeOver);
//
//				BL.clickElement(B.YesButton);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Sales Info", verifiedStatus, errorMessage);

			try {

				Thread.sleep(1000);

				BL.isElementDisplayed(A.ComapnyInfo, "Company Info");

				BL.clickElement(A.ComapnyInfo);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Company Info", verifiedStatus,
					errorMessage);

			try {

				Thread.sleep(1000);

				BL.isElementDisplayed(A.PersonalInfo, "Personal Info");

				BL.clickElement(A.PersonalInfo);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Personal Info", verifiedStatus,
					errorMessage);

			try {

				Thread.sleep(1000);

				BL.isElementDisplayed(A.CommunicationInfo, "Communication Info");

				BL.clickElement(A.CommunicationInfo);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Communication Info", verifiedStatus,
					errorMessage);

			try {

				Thread.sleep(1000);

				BL.isElementDisplayed(A.RiskINfo, "Risk Info");

				BL.clickElement(A.RiskINfo);

				BL.clickElement(B.VerifiedandNext);
			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Risk Info", verifiedStatus, errorMessage);

			try {

				Thread.sleep(1000);

				BL.clickElement(M.ClickOnCardBinProfile);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Card/Bin Profile", verifiedStatus,
					errorMessage);

			try {

				Thread.sleep(1000);

				BL.isElementDisplayed(A.DiscountRate, "Discount Rate");

				BL.clickElement(A.DiscountRate);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Discount Rate", verifiedStatus,
					errorMessage);

			try {

				Thread.sleep(1000);
				BL.isElementDisplayed(A.SettlementInfo, "Settlement Info");

				BL.clickElement(A.SettlementInfo);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Settlement Info", verifiedStatus,
					errorMessage);

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

				// Locate all elements matching the criteria
				List<WebElement> tdbutton = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
						"//td//button[@aria-label='Example icon-button with a menu' and contains(@class, 'mat-menu-trigger')]")));

				for (int currentRow = 0; currentRow < tdbutton.size(); currentRow++) {
					WebElement button = tdbutton.get(currentRow); // Access button directly from the list
					try {
						if (button.isDisplayed()) {
							wait.until(ExpectedConditions.elementToBeClickable(button)).click();

							BL.clickElement(B.ViewButton);
							BL.clickElement(B.Verify);

							Thread.sleep(2000);
							Robot r = new Robot();
							r.keyPress(KeyEvent.VK_ESCAPE);
							r.keyRelease(KeyEvent.VK_ESCAPE);

							System.out.println("Button clicked at index: " + currentRow);
						} else {
							System.out.println("Button at index " + currentRow + " is not displayed.");
						}
					} catch (Exception e) {
						System.out.println("Exception occurred while clicking button at index " + currentRow + ": "
								+ e.getMessage());
					}
				}

				driver.navigate().refresh();

				Thread.sleep(3000);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Terminals", verifiedStatus, errorMessage);

			try {

				Thread.sleep(1000);

				BL.isElementDisplayed(B.Kyc, "KYC");

				BL.clickElement(B.Kyc);

				BL.clickElement(B.Kyc);

				BL.clickElement(A.ViewDocument1);

				BL.clickElement(A.Actions);

				BL.clickElement(A.ViewDocumentVerified);

				BL.clickElement(A.ViewDocumentSubmitandNext);

				Thread.sleep(1000);

				BL.clickElement(A.Actions);

				BL.clickElement(A.ViewDocumentVerified);

				BL.clickElement(A.ViewDocumentSubmitandNext);

				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_ESCAPE);

				r.keyRelease(KeyEvent.VK_ESCAPE);

				Thread.sleep(1000);
				BL.clickElement(B.NextStep);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "KYC-Merchant", verifiedStatus,
					errorMessage);

			try {

				Thread.sleep(1000);

				BL.clickElement(B.VerifiedandNext);

			} catch (AssertionError e) {
				verifiedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Verified", "Payment Bridge", verifiedStatus,
					errorMessage);
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.SubmitforApproval);

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Submit for Approval", " Merchant", SaveStatus,
						errorMessage);

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			try {
				BL.clickElement(B.YesButton);
				BL.clickElement(B.OKButton);

				BL.isElementDisplayed(B.VerfiedSuccessCompleted, "Submit for Approval");
				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : System Verifier : Yes Button", "Submit for " + "",
						SaveStatus, errorMessage);

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			BL.clickElement(B.ApproveCancel);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Submit for Approval");
			throw e;
		}
	}

	@When("the System Approver clicks the Merchant module")

	public void SystemApproverClicktheSUBISOModule() {

		try {

			BL.clickElement(B.ClickOnMerchant);

		} catch (Exception e) {

			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());

			exceptionHandler.handleException(e, "Onboarding");

			throw e;

		}

	}

	@Then("the System Approver completes Merchant Onboarding, the system should prompt to Approve using the sheet name {string}")
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

				int rowTestCaseCount = runTestForRow2(rowData, rowNumber);
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
				performLogout(rowNumber);
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

	private int runTestForRow2(Map<String, String> testData, int rowNumber) throws Exception {

		// Log the test data for the current row
		System.out.println("Data for row " + rowNumber + ": " + testData);

		// Initialize the locators (e.g., BankLocators)
		B = new org.Locators.BankLocators(driver);

		int testCaseCount = 0;

		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow2(testData, rowNumber);

		return testCaseCount;

	}

	@SuppressWarnings("unused")
	private int validateFieldsForRow2(Map<String, String> testData, int TestcaseNo) throws Exception {

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

		String LegalName = testData.get("LegalName");

		key.clear();
		value.clear();

		String errorMessag = "The data does not match or is empty.";

		boolean Status = true;
		try {
			Thread.sleep(3000);

			BL.clickElement(B.SearchbyBankName);
			Thread.sleep(1000);

			BL.enterSplitElement(B.SearchbyBankName, LegalName);

		} catch (AssertionError e) {
			Status = false;
			errorMessag = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Search by name", LegalName, Status, errorMessag);
		Thread.sleep(3000);

		BL.ActionclickElement(B.ActionClick);

		Thread.sleep(1000);

		BL.clickElement(B.ViewButton);

		String errorMessage = "Approve Button is not visible.";

		boolean ApprovedStatus = true;

		try {
			BL.clickElement(B.Approve);

			logTestStep(TestcaseNo, "MMS :  Merchant Onboarding : Approval", " Merchant", ApprovedStatus, errorMessage);

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}

		try {
			BL.clickElement(B.YesButton);
			logTestStep(TestcaseNo, "MMS :  Merchant Onboarding : System Approver : Yes", "Approval", ApprovedStatus,
					errorMessage);

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}

		try {

			BL.clickElement(B.OKButton);
			BL.isElementDisplayed(B.VerfiedSuccessCompleted, "Approval");

			logTestStep(TestcaseNo, "MMS :  Merchant Onboarding : System Approver : Success pop-up OK", "Approval",
					ApprovedStatus, errorMessage);

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		BL.clickElement(B.ApproveCancel);

		Thread.sleep(3000);

		BL.clickElement(B.SearchbyBankName);
		Thread.sleep(3000);

		BL.enterSplitElement(B.SearchbyBankName, LegalName);
		Thread.sleep(3000);

		BL.ActionclickElement(B.ActionClick);

		try {

			BL.clickElement(B.ViewButton);

		} catch (AssertionError e) {
			ApprovedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}

		logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Merchant CPID", BL.getElementValue(B.CPID), ApprovedStatus,
				errorMessage);
		BL.clickElement(B.ApproveCancel);

	}

	private void submitForVerification(int TestcaseNo) throws InterruptedException {
		try {
			String errorMessage = "The data does not match or is empty.";
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.SubmitforVerification);

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : Submit for Verification", "Merchant", SaveStatus,
						errorMessage);

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

				logTestStep(TestcaseNo, "MMS : Merchant Onboarding : System Maker : Yes Button",
						"Submit for Verfication", SaveStatus, errorMessage);

			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Maker Verification"); // Take screenshot on error

			}
			BL.clickElement(B.OKButton);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Submit for verification");
			throw e;
		}
	}

	private void logTestStep(int testcaseCount, String fieldName, String fieldValue, Boolean status,
			String errorMessage) {
		String message = "MO Test Case " + testcaseCount + ": " + fieldName + " with value '" + fieldValue + "' "
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

		// Optionally, print to console for debugging
		System.out.println(message);
	}

	private void performTabKeyPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	private void performLogout(int TestcaseNo) throws InterruptedException {

		try {
			String errorMessage = "The data does not match or is empty.";
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.Profile);
				BL.clickElement(B.LogOut);

				logTestStep(TestcaseNo, "MMS :  Merchant Onboarding : Profile & Log Out", " Merchant", SaveStatus,
						errorMessage);

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			try {
				BL.clickElement(B.YesButton);

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}
			logTestStep(TestcaseNo, "MMS :  Merchant Onboarding : Yes Button", "Log-Out", SaveStatus, errorMessage);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Log Out");
			throw e;
		}

	}
}