package org.Testcases;

import static org.junit.Assert.assertEquals;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class SystemUserMultipleBankRegression extends TestHooks {
	private WebDriver driver;
	int waitTime;
	int assertwaittime;

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

	public SystemUserMultipleBankRegression() throws InterruptedException {
		this.driver = CustomWebDriverManager.getDriver();
		this.waitTime = CustomWebDriverManager.getWaitTime();

//	this.driver = driver;
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


	@Given("I visit the System Maker Login in Regression using sheetname {string} and rownumber {int}")
	public void i_visit_the_System_maker_login(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		try {
			// ExcelDataCache cache = ExcelDataCache.getInstance();
			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
			System.out.println("sheet name: " + testdata);
			String userName = testdata.get(rowNumber).get("UserName");
			String password = testdata.get(rowNumber).get("Password");
			BL.enterElement(L.EnterOnUserName, userName);
			BL.enterElement(L.EnterOnPassword, password);
			test = ExtentCucumberAdapter.getCurrentStep();
			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + userName
					+ "</td><td style='border: 1px solid black;color: black'>" + password + "</td></tr>" + "</table>";
			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");
			String[][] data = { { "UserName", "Password" }, { userName, password }, };
			Markup m = MarkupHelper.createTable(data);
			// or
			test.log(Status.PASS, m);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "LoginScreen");
			throw e;
		}
	}

	@And("I enter the credentials and click a login button in Regression using sheetname {string} and rownumber {int}")
	public void i_enter_the_credentials_and_click_a_login_button(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		try {
			// ExcelDataCache cache = ExcelDataCache.getInstance();
			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
			System.out.println("sheet name: " + testdata);
			String Captcha = testdata.get(rowNumber).get("Captcha");
			BL.enterElement(L.EnterOnCaptcha, Captcha);
			BL.clickElement(L.ClickOnLogin);
			BL.clickElement(B.OKButton);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "LoginScreen");
			throw e;
		}
	}

	@When("System Maker - Onboarding should be displayed in the side menu")
	public void I_Visit_System_Maker_Onboarding() throws InterruptedException {
		try {
			BL.clickElement(S.ClickOnDownArrow);
			BL.clickElement(S.ClickOnOnboarding);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@Then("the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")
	public void System_Maker_seessidemenu_itemsin_Onboarding() throws InterruptedException {
		try {
			BL.isElementDisplayed(B.ClickOnBank, "Bank");
			BL.isElementDisplayed(B.ClickOnPayfac, "Aggregator");
			BL.isElementDisplayed(B.ClickOnISO, "ISO");
			BL.isElementDisplayed(B.ClickOnSUBISO, "SUB ISO");
			BL.isElementDisplayed(B.ClickOnGM, "Group Merchant");
			BL.isElementDisplayed(B.ClickOnMerchant, "Merchant");
			BL.isElementDisplayed(B.ClickOnTerminal, "Terminal");
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@When("the System Maker clicks the bank module")
	public void SystemMakerClicktheBankModule() {
		try {
			BL.clickElement(B.ClickOnBank);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	int totalTestCaseCount = 0;

	@Then("the System Maker Bank Onboarding should prompt users to enter valid inputs using the sheet name {string}")
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

	private int runTestForRow(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {
		// Log the test data for the current row
		System.out.println("Data for row " + rowNumber + ": " + testData);
		// Initialize the locators (e.g., BankLocators)
		int testCaseCount = 0;
		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow(testData, rowNumber);
		return testCaseCount;
	}

	private void takeScreenshot(int rowNumber) {
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshotPath = "//home//ic-002//eclipse-workspace//MMSCredopay//Screenshorts" + rowNumber + ".png";
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

	private int validateFieldsForRow(Map<String, String> testData, int TestcaseNo) throws Exception {
		int validatedFieldsCount = 0;
		ONUSINDEX = 1;
		validatedFieldsCount += executeStep(() -> {
			try {
//	fillBankDetails(testData, TestcaseNo);
				String generatedBankName = fillBankDetails(testData, TestcaseNo);
				testData.put("bankName", generatedBankName);
			} catch (InterruptedException | AWTException e) {
				//
				e.printStackTrace();
			}
		}, "Bank Details");
		// Communication Details Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillCommunicationDetails(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Communication Details");
		// Channel Config Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillChannelConfig(testData,TestcaseNo);
			} catch (Exception e) {
				//
				e.printStackTrace();
			}
		}, "Channel Config");

		// Global Form Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillGlobalForm(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Global Form");
		// Commercial Section
		validatedFieldsCount += executeStep(() -> {
			try {
				configureCommercialInterChange(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Commercial InterChange");
		validatedFieldsCount += executeStep(() -> {
			try {
				configureCommercialBankOnboarding(testData, TestcaseNo);
			} catch (Exception e) {
				//
				e.printStackTrace();
			}
		}, "Commercial Bank Onboarding");
		// Settlement Info Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillSettlementInfo(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Settlement Info");
		// White Label Section
		validatedFieldsCount += executeStep(() -> {
			try {
				configureWhiteLabel(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "White Label Configuration");
		// Section
		validatedFieldsCount += executeStep(() -> {
			try {
				configureWebhooks(testData, TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Webhook Configuration");
		// KYC Section
		validatedFieldsCount += executeStep(() -> {
			try {
				fillKYCDetails(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
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
//		// Return the total count of validated fields/sections
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

	// Method to fill Bank Details
	private String fillBankDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {
		try {
			String bankName = testData.get("BankName");
			String address = testData.get("Address");
			String pincode = testData.get("Pincode");
			String gst = testData.get("GST");
			String pan = testData.get("PAN");
			String Marsid = testData.get("Mars id");
			String StatementFrequency = testData.get("Statement Frequency");
			String StatementType = testData.get("Statement Type");
			String domains = testData.get("Domain");
			key.clear();
			value.clear();
			String errorMessage = "The data does not match or is empty.";
			new TestCaseManager();

			if (bankName != null && !bankName.trim().isEmpty()) {

				boolean CreateStatus = true; // Assume success initially
				try {
					BL.clickElement(B.Createbutton);
				} catch (AssertionError e) {
					CreateStatus = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Create : ", "Bank", CreateStatus, errorMessage);

				BL.clickElement(B.BankName);
				BL.CLearElement(B.BankName);
				BL.enterElement(B.BankName, bankName);
				performTabKeyPress();
				boolean bankNameStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.GeneralinfoBanknameInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoBanknameRequiredField, "Field is Required");
				} catch (AssertionError e) {
					bankNameStatus = false; // Set status to false if assertion fails
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Bank Name", bankName, bankNameStatus,
						errorMessage);
			}

			if (address != null && !address.trim().isEmpty()) {
				BL.clickElement(B.Address);
				BL.enterElement(B.Address, address);
				performTabKeyPress();
				boolean AddressNameStatus = true; // Assume success initially
				try {

					// Perform assertion check (modify this as per your requirement)
					BL.isElementNotDisplayed(B.GeneralinfoAddressInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoBanknameRequiredField, "Field is Required");
				} catch (AssertionError e) {
					AddressNameStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
//	String getaddress = B.getAddress();
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Address Name", address,
						AddressNameStatus, errorMessage);
			}
			if (pincode != null && !pincode.trim().isEmpty()) {
				BL.clickElement(B.Pincode);
				BL.enterElement(B.Pincode, pincode);
				BL.selectDropdownOption(pincode);
				performTabKeyPress();
				boolean PincodeStatus = true; // Assume success initially
				try {
					// Perform assertion check (modify this as per your requirement)
					BL.isElementNotDisplayed(B.GeneralinfoPincodeInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoPincodeRequiredField, "Field is Required");
				} catch (AssertionError e) {
					PincodeStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Pincode :", pincode, PincodeStatus,
						errorMessage);
			}

			if (gst != null && !gst.trim().isEmpty()) {
				BL.clickElement(B.GST);
				BL.enterElement(B.GST, gst);
				performTabKeyPress();
				boolean GSTStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.GeneralinfogstInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoGSTRequiredField, "Field is Required");
				} catch (AssertionError e) {
					GSTStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : GST :", gst, GSTStatus, errorMessage);
			}

			if (pan != null && !pan.trim().isEmpty()) {
				BL.clickElement(B.PAN);
				BL.enterElement(B.PAN, pan);
				performTabKeyPress();
				boolean PANStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.GeneralinfopanInvalidformat, "Invalid Format");
					BL.isElementNotDisplayed(B.GeneralinfoPanRequiredField, "Field is Required");
				} catch (AssertionError e) {
					PANStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : PAN :", pan, PANStatus, errorMessage);
			}
			if (Marsid.contains("E")) {
				Double Marsid1 = Double.valueOf(Marsid);
				Marsid = String.format("%.0f", Marsid1);
			}
			if (Marsid != null && !Marsid.trim().isEmpty()) {
				BL.clickElement(B.Marsid);
				BL.enterElement(B.Marsid, Marsid);
				performTabKeyPress();
				boolean MarsidStatus = true; // Assume success initially
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Marsid :", Marsid, MarsidStatus,
						errorMessage);
			}
			if (StatementFrequency != null && !StatementFrequency.trim().isEmpty()) {
				BL.clickElement(B.StatementFrequency);
				BL.selectDropdownOption(StatementFrequency);
				performTabKeyPress();

				String actualValue = BL.getElementText(B.StatementFrequency);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null)

					{
						assertEquals(StatementFrequency.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Statement Frequency :",
						StatementFrequency, Status, errorMessage);
			}
			if (StatementType != null && !StatementType.trim().isEmpty()) {
				BL.clickElement(B.StatementType);
				BL.selectDropdownOption(StatementType);
				performTabKeyPress();
				String actualValue = BL.getElementText(B.StatementType);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(StatementType.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : Statement Type :", StatementType,
						Status, errorMessage);
			}
		
			if (domains != null && !domains.trim().isEmpty()) {  
	                String[] DomainArray = domains.split(",");
	                
	                for (String domain : DomainArray) {
	                    domain = domain.trim();
	                    if (!domain.isEmpty()) {
	                        // Enter the domain name
	                        BL.enterElement(B.Domain, domain);
	                        
	                        // Perform Tab key press to trigger the next domain creation
	                        performTabKeyPress();
	                        
	                        boolean Status = true;
	                        // Assume success initially
	                        try {
	                            BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
	                        } catch (AssertionError e) {
	                            Status = false;
	                            errorMessage = e.getMessage(); // Capture error message
	                        }
	                        logTestStep(TestcaseNo, "MMS : Bank Onboarding : Domain Entry", domains, Status, errorMessage);
	                    }
	                }
	            }
			
			
			boolean NextstepStatus = true;

			try {

				BL.clickElement(B.NextStep);
				JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript(
                    "navigator.geolocation.getCurrentPosition = function(success) { "
                    + "success({coords: {latitude: 0, longitude: 0}}); "
                    + "};"
                );
				if (!BL.isElementDisplayed(B.AdminUserDetails, "Communication Info Page")) {
					throw new AssertionError("Assertion Error ");
				}
			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Bank : Genral Info"); // Take screenshot on error

			}
												
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : General Info : ", "NextStep", NextstepStatus,
					errorMessage);
			return bankName;

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "General Info");
			throw e; // Re-throw the exception after handling
		}
	}

	private void logTestStep(int testcaseCount, String fieldName, String fieldValue, Boolean status,
			String errorMessage) {
		String message = "BO Test Case " + testcaseCount + ": " + fieldName + " with value '" + fieldValue + "' "
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

	// Method to fill Communication Details
	private void fillCommunicationDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {
		try {
			String errorMessage = "The data does not match or is empty.";
			String CommName = testData.get("Communication Name");
			String CommPosition = testData.get("Communication Position");
			String CommMobileNumber = testData.get("Communication MobileNumber");
			String CommEmailid = testData.get("Communication EmailId");
			String ADUSer = testData.get("AD User");
			BL.clickElement(B.ClickonCommunicationInfo);
			BL.clickElement(B.AddButton);
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
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Communication Name", CommName,
						CommunicationNameStatus, errorMessage);
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
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Communication Position",
						CommPosition, CommunicationPositionStatus, errorMessage);
			}
			if (CommMobileNumber != null && !CommMobileNumber.trim().isEmpty()) {
				BL.clickElement(B.ClickonCommuMobileNumber);
				BL.enterElement(B.ClickonCommuMobileNumber, CommMobileNumber);
				performTabKeyPress();
				boolean CommunicationMobileNumberStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.CommunicationMobileInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(B.CommunicationMobileFieldisRequired, "Field is Required");
				} catch (AssertionError e) {
					CommunicationMobileNumberStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Communication MobileNumber",
						CommMobileNumber, CommunicationMobileNumberStatus, errorMessage);
			}
			if (CommEmailid != null && !CommEmailid.trim().isEmpty()) {
				BL.clickElement(B.ClickonCommuEmailId);
				BL.enterElement(B.ClickonCommuEmailId, CommEmailid);
				performTabKeyPress();
				boolean CommunicationEmailIDStatus = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.CommunicationEmailInvalidFormat, "Invalid Format");
					BL.isElementNotDisplayed(B.CommunicationEmailFieldisRequired, "Field is Required");
				} catch (AssertionError e) {
					CommunicationEmailIDStatus = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Communication Emailid",
						CommEmailid, CommunicationEmailIDStatus, errorMessage);
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
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : AD User", ADUSer, Status,
						errorMessage);
			}

			boolean saveStatus = true;
			StringBuilder errorMessageBuilder = new StringBuilder();

			try {
			    // Click the save button
			    BL.clickElement(B.SaveButton);

			    // Check if either "Field is Required" or "Invalid Format" messages are displayed
			    boolean isFieldRequiredError = BL.SaveisElementDisplayed(B.Thisfieldrequired, "Field is Required");
			    boolean isInvalidFormatError = BL.SaveisElementDisplayed(B.invalidmessage, "Invalid Format");

			    // If any error is found, update the status, add messages, and take a single screenshot
			    if (isFieldRequiredError || isInvalidFormatError) {
			        saveStatus = false;

			        if (isFieldRequiredError) {
			            errorMessageBuilder.append("Field Required Assertion Error; ");
			        }
			        
			        if (isInvalidFormatError) {
			            errorMessageBuilder.append("Invalid Format Assertion Error; ");
			        }

			        // Take a single screenshot for any error condition
			        CustomWebDriverManager.takeScreenshotStr("Bank : Communication ");
			    }

			} catch (Exception e) {
			    saveStatus = false;
			    errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
			    CustomWebDriverManager.takeScreenshotStr("Error: Unexpected_Save_Error");
			}
			
			// Log the test step regardless of success or failure
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : Save Button", "Communication Info", saveStatus, errorMessage);

			boolean NextstepStatus = true;
			try {

				BL.clickElement(B.NextStep);

				BL.isElementDisplayed(B.IntroChannelConfiguration, "Channel Config Page");

			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Communication Info : ", "NextStep", NextstepStatus,
					errorMessage);
		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Communication Info");
			throw e; // Re-throw the exception after handling
		}
	}

	// channel Config
		int ONUSINDEX = 1;

		private void fillChannelConfig(Map<String, String> testData,int TestcaseNo) throws InterruptedException, AWTException, IOException {
			try {
				if (B == null) {
					// Initialize BankLocators here if needed
				}
				
				String AggregatorIdFromRegression = testData.get("CH & CM Ref ID");

				List<Map<String, String>> cachedData = cache.getCachedData("Channel Bank");
				int numberOfRows = cachedData.size();
				System.out.println("Total rows found: " + numberOfRows);

				for (int currentRow = 1; currentRow <= numberOfRows; currentRow++) {
					System.out.println("Running test for row number: " + currentRow);
			

					Map<String, String> rowData = cachedData.get(currentRow - 1);

					String BankAggregatorId = rowData.get("CH & CM Ref ID");

					if (AggregatorIdFromRegression != null && !AggregatorIdFromRegression.equals(BankAggregatorId)) {
						continue; // Skip processing this terminal record if the Merchant IDs don't match
					}
					
					
					String channel = rowData.getOrDefault("Channel", "").trim().replaceAll("\\s*,\\s*", ",");
					String networkData = rowData.getOrDefault("Network", "").trim().replaceAll("\\s*,\\s*", ",");
					String transactionSet = rowData.getOrDefault("Transaction Sets", "").trim().replaceAll("\\s*,\\s*",
							",");
					String routing = rowData.getOrDefault("Routing", "").trim().replaceAll("\\s*,\\s*", ",");
					String ONUS = rowData.getOrDefault("ONUS Routing", "").trim().replaceAll("\\s*,\\s*", ",");

					System.out.println(ONUS);
					// Run each process step
					processChannelData(TestcaseNo, currentRow, channel, key, value);
					processNetworkData(TestcaseNo, currentRow, networkData, key, value);
					processTransactionSetData(TestcaseNo, currentRow, transactionSet, key, value);
					processRoutingData(TestcaseNo, currentRow, routing, key, value);
					saveAction(TestcaseNo, key, value);
					processONUSEntries(TestcaseNo, currentRow, ONUS);

					// Log input data in structured format
				}

				String errorMessage = "The data does not match or is empty.";
				boolean NextstepStatus = true;
				
				try {
					BL.clickElement(B.ONUSRouting);
					BL.clickElement(B.NextStep);

					if (!BL.isElementDisplayed(B.LabelGlobalFRM, "Global FRM"))

					{
						throw new AssertionError("Assertion Error ");
					}
				} catch (AssertionError e) {

					CustomWebDriverManager.takeScreenshotStr("Bank : Channel Config "); // Take screenshot on error

				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : ONUS Routing : ", "NextStep", NextstepStatus,
						errorMessage);

			} catch (Exception e) {
				ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
				exceptionHandler.handleException(e, "Channel Config And ONUS Routing");
				throw e;
			}
		}
		

		private void processChannelData(int TestcaseNo, int currentRow, String channel, ArrayList<String> key,
				ArrayList<String> value) throws InterruptedException, AWTException {
			String errorMessage = "The data does not match or is empty.";
			if (!channel.isEmpty()) {
				try {
					Thread.sleep(1000);
					BL.clickElement(B.ChannelConfig);
					Thread.sleep(1000);
					BL.clickElement(B.CommercialADD1);
					BL.clickElement(B.CommercialChannel);
					BL.selectDropdownOption(channel);
					key.add("Channel-" + currentRow);
					value.add(channel);
					performTabKeyPress();

					String actualValue = BL.getElementText(B.ClickOnChannel);
					boolean Status = true;
					try {
						if (actualValue != null) {
							assertEquals(channel.toUpperCase(), actualValue.toUpperCase());
							BL.isElementNotDisplayed(B.ChannelnameFieldisRequired, "Field is Required");
						}
					} catch (AssertionError e) {
						Status = false;
						errorMessage = e.getMessage();
					}
					logTestStep(TestcaseNo, "MMS : Bank Onboarding : Channel Config : Channel", channel, Status,
							errorMessage);
				} catch (Exception e) {
					System.out.println("Error in processing Channel data for row: " + currentRow + " - " + e.getMessage());
					throw e;
				}
			} else {
				System.out.println("Channel data is empty for row: " + currentRow);
			}
		}

		// Similar approach to other data methods:
		private void processNetworkData(int TestcaseNo, int currentRow, String networkData, ArrayList<String> key,
				ArrayList<String> value) throws InterruptedException, AWTException {
			String errorMessage = "The data does not match or is empty.";
			if (!networkData.isEmpty()) {
				try {
					String[] networks = networkData.split(",");
					for (String network : networks) {
						network = network.trim();
						if (!network.isEmpty()) {
							BL.clickElement(B.ClickOntNetwork);
							BL.selectDropdownOption(network);
							key.add("Network-" + currentRow);
							value.add(network);
							performTabKeyPress();

						}

					}
					String actualValue = BL.getElementText(B.ClickOntNetwork);
					boolean Status = true;
					try {
						if (actualValue != null) {
							assertEquals(networkData.toUpperCase(), actualValue.toUpperCase());
							BL.isElementNotDisplayed(B.ChannelNetworkFieldisRequired, "Field is Required");
						}
					} catch (AssertionError e) {
						Status = false;
						errorMessage = e.getMessage();
					}
					logTestStep(TestcaseNo, "MMS : Bank Onboarding : Channel Config : Network", networkData, Status,
							errorMessage);

				} catch (Exception e) {
					System.out.println("Error in processing Network data for row: " + currentRow + " - " + e.getMessage());
					throw e;
				}
			} else {
				System.out.println("Network data is empty for row: " + currentRow);
			}
		}

		private void processTransactionSetData(int testcaseNo, int currentRow, String transactionSet, ArrayList<String> key,
				ArrayList<String> value) throws InterruptedException, AWTException {
			String errorMessage = "The data does not match or is empty.";

			if (!transactionSet.isEmpty()) {
				try {
					String[] transa = transactionSet.split(",");
					for (String trans : transa) {
						trans = trans.trim();
						if (!trans.isEmpty()) {
							BL.clickElement(B.ClickOntransaction);
							BL.selectDropdownOption(trans);
							key.add("Transaction Set-" + currentRow);
							value.add(trans);
							performTabKeyPress();
						}
					}
					String actualValue = BL.getElementText(B.ClickOntransaction);
					boolean Status = true;
					try {
						if (actualValue != null) {
							System.out.println("Expected network: " + transactionSet);
							System.out.println("Actual ADUser from UI: " + BL.getElementText(B.ClickOntransaction));
							assertEquals(transactionSet.toUpperCase(), actualValue.toUpperCase());
							BL.isElementNotDisplayed(B.ChannelNetworkFieldisRequired, "Field is Required");
						}
					} catch (AssertionError e) {
						Status = false;
						errorMessage = e.getMessage();
					}

					// Log transaction status
					logTestStep(testcaseNo, "MMS : Bank Onboarding : Channel Config : TransactionSet", transactionSet,
							Status, errorMessage);

				} catch (Exception e) {
					System.out.println("Error in processing Network data for row: " + currentRow + " - " + e.getMessage());
					throw e;
				}
			} else {
				System.out.println("Network data is empty for row: " + currentRow);
			}
		}

		private void processRoutingData(int TestcaseNo, int currentRow, String routing, ArrayList<String> key,
				ArrayList<String> value) throws InterruptedException, AWTException {
			String errorMessage = "The data does not match or is empty.";
			if (!routing.isEmpty()) {
				BL.clickElement(B.ClickOnRouting);
				BL.selectDropdownOption(routing);
				key.add("Routing-" + currentRow);
				value.add(routing);
				performTabKeyPress();

				String actualValue = BL.getElementText(B.ClickOnRouting);

				boolean Status = true;
				try {
					if (actualValue != null) {
						assertEquals(routing.toUpperCase(), actualValue.toUpperCase());
						BL.isElementNotDisplayed(B.ChannelRoutingFieldisRequired, "Field is Required");
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage();
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Channel Config : Routing", routing, Status, errorMessage);
			} else {
				System.out.println("Routing data is empty for row: " + currentRow);
			}
		}

		// Additional helper functions for TransactionSet, Routing, and POSBIN with same
		// structure.

		private void saveAction(int TestcaseNo, ArrayList<String> key, ArrayList<String> value)
				throws InterruptedException {
			String errorMessage = "The data does not match or is empty.";
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.SaveButton);
				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage();
			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Channel Config : Save Button", "Channel Config", SaveStatus,
					errorMessage);
		}

		private void processONUSEntries(int TestcaseNo, int currentRow, String BIN)
				throws InterruptedException, AWTException {
			String errorMessage = "The data does not match or is empty.";
			System.out.println("BIN" + BIN);
			if (!BIN.isEmpty()) {
				try {
					String[] posBinValues = BIN.split("\\s+");
					for (String ONUS : posBinValues) {
						ONUS = ONUS.contains(".0") ? ONUS.replace(".0", "") : ONUS;
						BL.clickElement(B.ONUSRouting);
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
						Thread.sleep(1000);
						WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath("(//td/button[@aria-label='Example icon-button with a menu'])[" + ONUSINDEX + "]")));
						optionElement = wait.until(ExpectedConditions.elementToBeClickable(optionElement));
						optionElement.click();

						BL.clickElement(B.AddBin);
						BL.enterElement(B.ClickOnAddBin, ONUS);
						performTabKeyPress();
						BL.clickElement(B.SubmitOnOnus);
						ONUSINDEX++;

						boolean POSBINStatus = true;
						try {
							BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						} catch (AssertionError e) {
							POSBINStatus = false;
							errorMessage = e.getMessage();
						}
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : ONUS Routing : BIN", ONUS, POSBINStatus,
								errorMessage);
					}
				} catch (Exception e) {
					System.out.println("Error in processing POS BIN for row: " + currentRow + " - " + e.getMessage());
					throw e;
				}
			}
		}

	
	// Method to fill Global Form
	private void fillGlobalForm(Map<String, String> testData, int TestcaseNo) throws Exception {
		String VelocityCheckMinutes = testData.get("Velocity Check Minutes");
		String VelocityCheckCount = testData.get("Velocity Check Count");
		String CashPOSCount = testData.get("CashPOS Count");
		String MicroATMCount = testData.get("Micro ATM Count");
		String card = testData.get("International Card Acceptance");
		String ICADAILY = testData.get("ICA Daily");
		String ICAWEEKLY = testData.get("ICA Weekly");
		String ICAMonthly = testData.get("ICA Monthly");
		
		
		String Channel1DAILY = testData.get("Channel 1 Daily");
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
		String errorMessage = "Invalid Format";
		try {
			Thread.sleep(1000);
			BL.clickElement(B.GlobalFrm);
			Thread.sleep(2000);
			BL.clickElement(B.GlobalFRMCheckbox);
			if (VelocityCheckMinutes != null && !VelocityCheckMinutes.trim().isEmpty()) {
				// Perform the actions for the Velocity Check Minutes
				BL.clickElement(B.VelocityCheckMinute);
				BL.enterElement(B.VelocityCheckMinute, VelocityCheckMinutes);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					// Check if there is an invalid format
					assertEquals(VelocityCheckMinutes, BL.getElementText(B.VelocityCheckMinute));
					BL.isElementNotDisplayed(B.VcheckminutesFieldisRequired, "Field is Required");

				} catch (AssertionError e) {
					// If an AssertionError occurs, set the status to false and capture the error
					// message
					Status = false;
					errorMessage = e.getMessage();
				}
				// Log the test step with the test case number, field, input value, status, and
				// error message (if any)
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Velocity Check Minutes",
						VelocityCheckMinutes, Status, errorMessage);
			}
			if (VelocityCheckCount != null && !VelocityCheckCount.trim().isEmpty()) {
				BL.clickElement(B.VelocityCheckCount);
				BL.enterElement(B.VelocityCheckCount, VelocityCheckCount);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					assertEquals(VelocityCheckCount, BL.getElementText(B.VelocityCheckCount));
					BL.isElementNotDisplayed(B.VcheckcountFieldisRequired, "Field is Required");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Velocity Check Count", VelocityCheckCount,
						Status, errorMessage);
			}
			if (CashPOSCount != null && !CashPOSCount.trim().isEmpty()) {
				BL.clickElement(B.CashPOSCount);
				BL.enterElement(B.CashPOSCount, CashPOSCount);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					assertEquals(CashPOSCount, BL.getElementText(B.CashPOSCount));
					BL.isElementNotDisplayed(B.CashposcountFieldisRequired, "Field is Required");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : CashPOSCount", CashPOSCount, Status,
						errorMessage);
			}
			if (MicroATMCount != null && !MicroATMCount.trim().isEmpty()) {
				BL.clickElement(B.MicroATMCount);
				BL.enterElement(B.MicroATMCount, MicroATMCount);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					assertEquals(MicroATMCount, BL.getElementText(B.MicroATMCount));
					BL.isElementNotDisplayed(B.MicroATMCountFieldisRequired, "Field is Required");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : MicroATMCount", MicroATMCount, Status,
						errorMessage);
			}
			if (card != null && !card.trim().isEmpty()) {
				BL.clickElement(B.InternationalCardCount);

				BL.selectDropdownOption(card);

				boolean Status = true; // Assume success initially

				String actualValue = BL.getElementText(B.InternationalCardCount);
				try {
					if (actualValue != null) {
						System.out.println("Expected network: " + card);
						System.out.println("Actual ADUser from UI: " + BL.getElementText(B.InternationalCardCount));
						assertEquals(card.toUpperCase(), actualValue.toUpperCase());
						BL.isElementNotDisplayed(B.IcardacceptanceFieldisRequired, "Field is Required");
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : International Card Acceptance", card,
						Status, errorMessage);
			}
//ICA	
			if (ICADAILY != null && !ICADAILY.trim().isEmpty()) {
				BL.clickElement(B.ICADaily);
				BL.enterElement(B.ICADaily, ICADAILY);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					assertEquals(ICADAILY, BL.getElementText(B.ICADaily));
					BL.isElementNotDisplayed(B.ICADailyFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(B.ICAdailylessthanweeklylimtError, "Daily Must be less than Weekly Limit");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : ICA DAILY", ICADAILY, Status,
						errorMessage);
			}
			if (ICAWEEKLY != null && !ICAWEEKLY.trim().isEmpty()) {
				BL.clickElement(B.ICAWeekly);
				BL.enterElement(B.ICAWeekly, ICAWEEKLY);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					assertEquals(ICAWEEKLY, BL.getElementText(B.ICAWeekly));
					BL.isElementNotDisplayed(B.ICAWeeklyFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(B.ICAWeeklygreaterthanDailylimtError,
							"Weekly Must be greater than Daily Limit");
					BL.isElementNotDisplayed(B.ICAWeeklylessthanmonthlylimtError,
							"Weekly Must be Less than Daily Limit");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : ICA WEEKLY", ICAWEEKLY, Status,
						errorMessage);
			}
			if (ICAMonthly != null && !ICAMonthly.trim().isEmpty()) {
				BL.clickElement(B.ICAMonthly);
				BL.enterElement(B.ICAMonthly, ICAMonthly);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					assertEquals(ICAMonthly, BL.getElementText(B.ICAMonthly));
					BL.isElementNotDisplayed(B.ICAMonthlyFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(B.ICAMonthlygreaterthanweeklylimtError,
							"Monthly  Must be greater than Weekly Limit");

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : ICA Monthly", ICAMonthly, Status,
						errorMessage);
			}
//POS	
			if (Channel1DAILY != null && !Channel1DAILY.trim().isEmpty()) {
				BL.clickElement(B.POSDaily);
				BL.CLearElement(B.POSDaily);
				BL.enterElement(B.POSDaily, Channel1DAILY);

				boolean Status = true; // Assume success initially
				try {

					System.out.println("Expected network: " + Channel1DAILY);
					System.out.println("Actual ADUser from UI: " + BL.getElementText(B.POSDaily));
					assertEquals(Channel1DAILY, BL.getElementText(B.POSDaily));
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 1 DAILY", Channel1DAILY, Status,
						errorMessage);
			}
			if (Channel1WEEKLY != null && !Channel1WEEKLY.trim().isEmpty()) {
				BL.clickElement(B.POSWeekly);
				BL.CLearElement(B.POSWeekly);
				BL.enterElement(B.POSWeekly, Channel1WEEKLY);

				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel1WEEKLY, BL.getElementText(B.POSWeekly));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 1 WEEKLY", Channel1WEEKLY, Status,
						errorMessage);
			}
			if (Channel1Monthly != null && !Channel1Monthly.trim().isEmpty()) {
				BL.clickElement(B.POSMonthly);
				BL.CLearElement(B.POSMonthly);
				BL.enterElement(B.POSMonthly, Channel1Monthly);

				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel1Monthly, BL.getElementText(B.POSMonthly));

				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 1 Monthly", Channel1Monthly, Status,
						errorMessage);
			}
			if (Channel1Minimum != null && !Channel1Minimum.trim().isEmpty()) {
				BL.clickElement(B.POSMinimumAmount);
				BL.CLearElement(B.POSMinimumAmount);
				BL.enterElement(B.POSMinimumAmount, Channel1Minimum);

				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel1Minimum, BL.getElementText(B.POSMinimumAmount));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 1 Minimum", Channel1Minimum, Status,
						errorMessage);
			}
			if (Channel1Maximum != null && !Channel1Maximum.trim().isEmpty()) {
				BL.clickElement(B.POSMaximumAmount);
				BL.CLearElement(B.POSMaximumAmount);
				BL.enterElement(B.POSMaximumAmount, Channel1Maximum);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel1Maximum, BL.getElementText(B.POSMaximumAmount));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 1 Maximum", Channel1Maximum, Status,
						errorMessage);
			}
//UPI
			if (Channel2DAILY != null && !Channel2DAILY.trim().isEmpty()) {
				BL.clickElement(B.UPIDaily);
				BL.CLearElement(B.UPIDaily);
				BL.enterElement(B.UPIDaily, Channel2DAILY);
				boolean Status = true; // Assume success initially
				try {

					assertEquals(Channel2DAILY, BL.getElementText(B.UPIDaily));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 2 DAILY", Channel2DAILY, Status,
						errorMessage);
			}
			if ( Channel2WEEKLY!= null && !Channel2WEEKLY.trim().isEmpty()) {
				BL.clickElement(B.UPIWeekly);
				BL.CLearElement(B.UPIWeekly);
				BL.enterElement(B.UPIWeekly, Channel2WEEKLY);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel2WEEKLY, BL.getElementText(B.UPIWeekly));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 2 WEEKLY", Channel2WEEKLY, Status,
						errorMessage);
			}
			if (Channel2Monthly != null && !Channel2Monthly.trim().isEmpty()) {
				BL.clickElement(B.UPIMonthly);
				BL.CLearElement(B.UPIMonthly);
				BL.enterElement(B.UPIMonthly, Channel2Monthly);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel2Monthly, BL.getElementText(B.UPIMonthly));
					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Equal Value Not Allowed");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 2 Monthly", Channel2Monthly, Status,
						errorMessage);
			}
			if (Channel2Minimum != null && !Channel2Minimum.trim().isEmpty()) {
				BL.clickElement(B.UPIMinimumAmount);
				BL.CLearElement(B.UPIMinimumAmount);
				BL.enterElement(B.UPIMinimumAmount, Channel2Minimum);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel2Minimum, BL.getElementText(B.UPIMinimumAmount));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 2 Minimum", Channel2Minimum, Status,
						errorMessage);
			}
			if (Channel2Maximum != null && !Channel2Maximum.trim().isEmpty()) {
				BL.clickElement(B.UPIMaximumAmount);
				BL.CLearElement(B.UPIMaximumAmount);
				BL.enterElement(B.UPIMaximumAmount, Channel2Maximum);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel2Maximum, BL.getElementText(B.UPIMaximumAmount));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 2 Maximum", Channel2Maximum, Status,
						errorMessage);
			}
//AEPS	
			if (Channel3DAILY != null && !Channel3DAILY.trim().isEmpty()) {
				BL.clickElement(B.AEPSDaily);
				BL.CLearElement(B.AEPSDaily);
				BL.enterElement(B.AEPSDaily, Channel3DAILY);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel3DAILY, BL.getElementText(B.AEPSDaily));
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 3 DAILY", Channel3DAILY, Status,
						errorMessage);
			}
			if (Channel3WEEKLY != null && !Channel3WEEKLY.trim().isEmpty()) {
				BL.clickElement(B.AEPSWeekly);
				BL.CLearElement(B.AEPSWeekly);
				BL.enterElement(B.AEPSWeekly, Channel3WEEKLY);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel3WEEKLY, BL.getElementText(B.AEPSWeekly));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 3 WEEKLY", Channel3WEEKLY, Status,
						errorMessage);
			}
			if (Channel3Monthly != null && !Channel3Monthly.trim().isEmpty()) {
				BL.clickElement(B.AEPSMonthly);
				BL.CLearElement(B.AEPSMonthly);
				BL.enterElement(B.AEPSMonthly, Channel3Monthly);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel3Monthly, BL.getElementText(B.AEPSMonthly));
					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Equal Value Not Allowed");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 3 Monthly", Channel3Monthly, Status,
						errorMessage);
			}
			if (Channel3Minimum != null && !Channel3Minimum.trim().isEmpty()) {
				BL.clickElement(B.AEPSMinimumAmount);
				BL.CLearElement(B.AEPSMinimumAmount);
				BL.enterElement(B.AEPSMinimumAmount, Channel3Minimum);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel3Minimum, BL.getElementText(B.AEPSMinimumAmount));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 3 Minimum", Channel3Minimum, Status,
						errorMessage);
			}
			if (Channel3Maximum != null && !Channel3Maximum.trim().isEmpty()) {
				BL.clickElement(B.AEPSMaximumAmount);
				BL.CLearElement(B.AEPSMaximumAmount);
				BL.enterElement(B.AEPSMaximumAmount, Channel3Maximum);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel3Maximum, BL.getElementText(B.AEPSMaximumAmount));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 3 Maximum", Channel3Maximum, Status,
						errorMessage);
			}
//MATM
			if (Channel4DAILY != null && !Channel4DAILY.trim().isEmpty()) {
				BL.clickElement(B.MATMDaily);
				BL.CLearElement(B.MATMDaily);
				BL.enterElement(B.MATMDaily, Channel4DAILY);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel4DAILY, BL.getElementText(B.MATMDaily));
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 4 DAILY", Channel4DAILY, Status,
						errorMessage);
			}
			if (Channel4WEEKLY != null && !Channel4WEEKLY.trim().isEmpty()) {
				BL.clickElement(B.MATMWeekly);
				BL.CLearElement(B.MATMWeekly);
				BL.enterElement(B.MATMWeekly, Channel4WEEKLY);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel4WEEKLY, BL.getElementText(B.MATMWeekly));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 4 WEEKLY", Channel4WEEKLY, Status,
						errorMessage);
			}
			if (Channel4Monthly != null && !Channel4Monthly.trim().isEmpty()) {
				BL.clickElement(B.MATMMonthly);
				BL.CLearElement(B.MATMMonthly);
				BL.enterElement(B.MATMMonthly, Channel4Monthly);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel4Monthly, BL.getElementText(B.MATMMonthly));
					BL.isElementNotDisplayed(B.MonthlyEqualValueNotAllowed, "Equal Value Not Allowed");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 4 Monthly", Channel4Monthly, Status,
						errorMessage);
			}
			if (Channel4Minimum != null && !Channel4Minimum.trim().isEmpty()) {
				BL.clickElement(B.MATMMinimumAmount);
				BL.CLearElement(B.MATMMinimumAmount);
				BL.enterElement(B.MATMMinimumAmount, Channel4Minimum);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel4Minimum, BL.getElementText(B.MATMMinimumAmount));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 4 Minimum", Channel4Minimum, Status,
						errorMessage);
			}
			if (Channel4Maximum != null && !Channel4Maximum.trim().isEmpty()) {
				BL.clickElement(B.MATMMaximumAmount);
				BL.CLearElement(B.MATMMaximumAmount);
				BL.enterElement(B.MATMMaximumAmount, Channel4Maximum);
				boolean Status = true; // Assume success initially
				try {
					assertEquals(Channel4Maximum, BL.getElementText(B.MATMMaximumAmount));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 4 Maximum", Channel4Maximum, Status,
						errorMessage);
			}
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
				logTestStep(TestcaseNo, "MMS : Aggregator Onboarding : Global FRM : Channel 5 DAILY", Channel5Daily, Status,
						errorMessage);

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
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 5 WEEKLY", Channel5Weekly, Status,
						errorMessage);

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
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 5 Monthly", Channel5Monthly, Status,
						errorMessage);

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
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 5 Minimum", Channel5Minimum, Status,
						errorMessage);

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
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : Channel 5 Maximum", Channel5Maximum, Status,
						errorMessage);

			}
			boolean NextstepStatus = true;
			try {
				BL.clickElement(B.NextStep);

				if (!BL.isElementDisplayed(B.IntroInterchangePlan, "Commercial Info")) {
					throw new AssertionError("Assertion Error ");
				}

			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Bank : Global FRM"); // Take screenshot on error

			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Global FRM : ", "NextStep", NextstepStatus, errorMessage);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	// Method to configure Commercial
	private void configureCommercialInterChange(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {
			
			String AggregatorIdFromRegression = testData.get("CH & CM Ref ID");
			String errorMessagee = "The data does not match or is empty.";
			List<Map<String, String>> cachedData = cache.getCachedData("Interchange Channel");
			int numberOfRows = cachedData.size();
			System.out.println("Total rows found: " + numberOfRows);

			for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
				System.out.println("Running test for row number: " + (currentRow + 1));
				Map<String, String> testData1 = cachedData.get(currentRow);
				System.out.println("Test data: " + testData);

				String channel = testData1.getOrDefault("Interchange Channel", "").trim();
				String pricingPlan = testData1.getOrDefault("Interchange Pricing Plan", "").trim();

				String BankAggregatorId = testData1.get("CH & CM Ref ID");

				if (AggregatorIdFromRegression != null && !AggregatorIdFromRegression.equals(BankAggregatorId)) {
					continue; // Skip processing this terminal record if the Merchant IDs don't match
				}
				boolean hasValidData = false;

				// Only process the channel if it’s not null or empty
				if (!channel.isEmpty()) {
					hasValidData = true;
					processField(channel, "Interchange Channel", key, value, currentRow + 1, () -> {
						BL.clickElement(B.Commercial);
						BL.clickElement(B.CommercialADD1);
						BL.clickElement(B.CommercialChannel);
						BL.selectDropdownOption(channel);
						boolean Status = true;
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Interchange Channel", channel,
								Status, "Data matched");
					});
				} else {
					System.out.println("Channel is empty, skipping this field.");
				}

				// Only process the pricing plan if it’s not null or empty
				if (!pricingPlan.isEmpty()) {
					hasValidData = true;
					processField(pricingPlan, "Interchange Pricing Plan", key, value, currentRow + 1, () -> {
						BL.clickElement(B.PricingplanInterchange);
						BL.selectDropdownOption(pricingPlan);
						boolean Status = true;
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Interchange Pricing Plan",
								pricingPlan, Status, "Data matched");
					});
				} else {
					System.out.println("Pricing plan is empty, skipping this field.");
				}

				// Only click the Save button if at least one valid field was processed
				if (hasValidData) {
					boolean SaveStatus = true;
					try {
						Thread.sleep(1000);
						BL.clickElement(B.SaveButton);
						BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
					} catch (AssertionError e) {
						SaveStatus = false;
						errorMessagee = e.getMessage();
					}
					logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Save Button",
							"Commercial Interchange", SaveStatus, errorMessagee);
				} else {
					System.out.println("No valid data found for this row, skipping save operation.");
				}
				
			}
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e;
		}
	}

	private void processField(String fieldData, String fieldName, ArrayList<String> key, ArrayList<String> value,
			int currentRow, Runnable action) throws InterruptedException, AWTException {
		if (isValidInput1(fieldData)) {
			action.run(); // Perform the specific action for the field
			key.add(fieldName + "-" + currentRow);
			value.add(fieldData);
//	performTabKeyPress(); // Ensure to move to the next field
		} else {
			System.out.println(fieldName + " data is null or empty for row: " + currentRow);
		}
	}

	// Helper method to validate input
	private boolean isValidInput1(String input) {
		return input != null && !input.trim().isEmpty();
	}
	
	private void configureCommercialBankOnboarding(Map<String, String> testData, int TestcaseNo) throws Exception {
		try {
			
			String AggregatorIdFromRegression = testData.get("CH & CM Ref ID");
			final String defaultErrorMessage = "The data does not match or is empty.";
			List<Map<String, String>> cachedData = cache.getCachedData("Commercial Channel");
			int numberOfRows = cachedData.size();
			System.out.println("Total rows found: " + numberOfRows);

			for (int currentRow = 0; currentRow < numberOfRows; currentRow++) {
				System.out.println("Running test for row number: " + (currentRow + 1));
				Map<String, String> testData1 = cachedData.get(currentRow);
				System.out.println("Test data: " + testData);
				
				String BankAggregatorId = testData1.get("CH & CM Ref ID");

				if (AggregatorIdFromRegression != null && !AggregatorIdFromRegression.equals(BankAggregatorId)) {
					continue; // Skip processing this terminal record if the Merchant IDs don't match
				}

				String channel = testData1.getOrDefault("Commercial Channel", "").trim();
				String pricingPlan = testData1.getOrDefault("Commercial Pricing Plan", "").trim();

				ArrayList<String> key = new ArrayList<>();
				ArrayList<String> value = new ArrayList<>();
				boolean hasValidData = false;

				// Process "Commercial Channel" if it's valid
				if (!channel.isEmpty()) {
					hasValidData = true;
					processField(channel, "Bank Onboarding Commercial Channel", key, value, currentRow + 1, () -> {
						
						BL.clickElement(B.Commercial);
						BL.clickElement(B.CommercialADD2);
						BL.clickElement(B.CommercialChannel);
						BL.selectDropdownOption(channel);
						logTestStep(TestcaseNo,
								"MMS : Bank Onboarding : Commercial : Bank Onboarding Commercial Channel", channel,
								true, defaultErrorMessage);
					});
				} else {
					System.out.println("Channel is empty, skipping this field.");
				}

				// Process "Pricing Plan" if it's valid
				if (!pricingPlan.isEmpty()) {
					hasValidData = true;
					processField(pricingPlan, "Pricing Plan", key, value, currentRow + 1, () -> {
						BL.clickElement(B.PricingplanBankOnboarding);
						BL.selectDropdownOption(pricingPlan);
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Bank Onboarding Pricing Plan",
								pricingPlan, true, defaultErrorMessage);
					});
				} else {
					System.out.println("Pricing plan is empty, skipping this field.");
				}

				// Attempt to save only if there's valid data
				if (hasValidData) {
					boolean SaveStatus = true;
					String saveErrorMessage = defaultErrorMessage;
					try {
						BL.clickElement(B.SaveButton);
						BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
					} catch (AssertionError e) {
						SaveStatus = false;
						saveErrorMessage = e.getMessage(); // Capture specific error message
					}
					logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : Save Button",
							"Commercial-BankOnboarding", SaveStatus, saveErrorMessage);
				} else {
					System.out.println("No valid data found for this row, skipping save operation.");
				}

				
			}

			// Next Step action and log status outside the loop, as it should run once after
			// all rows are processed
			boolean NextStepStatus = true;
			String nextStepErrorMessage = defaultErrorMessage;

			try {
				BL.clickElement(B.NextStep);
				if (!BL.isElementDisplayed(B.IntroBankDetails, "Settlement Info")) {
					throw new AssertionError("Assertion Error ");
				}
			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Bank : Commercial "); // Take screenshot on error

			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Commercial : NextStep", "NextStep", NextStepStatus,
					nextStepErrorMessage);

		} catch (Exception e) {
			// Use the exception handler to log and handle exceptions gracefully
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Commercial");
			throw e; // Re-throw w the exception after handling
		}
	}
			

	// Method to fill Settlement Info
	private void fillSettlementInfo(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {
		String errorMessage = "The data does not match or is empty.";
		String channel = testData.get("Settlement Channel");
		String Account = testData.get("Account Type");
		String IFSCCode = testData.get("IFSC Code");
		String BanKAccountNumber = testData.get("Bank Account Number");
		String type = testData.get("Settlement Type");
		try {
			BL.clickElement(B.SettlementInfo);
			BL.clickElement(B.AddButton);
			if (channel != null && !channel.trim().isEmpty()) {
				BL.clickElement(B.SettlementChannel);
				BL.selectDropdownOption(channel);
				String actualValue = BL.getElementText(B.SettlementChannel);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						BL.isElementNotDisplayed(B.SettlementChannelFieldisRequired, "Field is Required");
						assertEquals(channel.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : Settlement Channel", channel, Status,
						errorMessage);
			}
			if (Account != null && !Account.trim().isEmpty()) {
				BL.clickElement(B.SettlementAccountType);
				BL.selectDropdownOption(Account);
				boolean Status = true;

				String actualValue = BL.getElementText(B.SettlementAccountType);
				try {
					if (actualValue != null) {
						BL.isElementNotDisplayed(B.SettlementAccTypeFieldisRequired, "Field is Required");
						assertEquals(Account.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : Settlement AccountType", Account,
						Status, errorMessage);
			}
			if (BanKAccountNumber != null && !BanKAccountNumber.trim().isEmpty()) {
				BL.clickElement(B.SettlementBankAccountNumber);
				BL.enterElement(B.SettlementBankAccountNumber, BanKAccountNumber);
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.SettlementBankAccNumberFieldisRequired, "Field is Required");
					assertEquals(BanKAccountNumber, BL.getElementText(B.SettlementBankAccountNumber));
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : BanKAccountNumber",
						BanKAccountNumber, Status, errorMessage);
			}
			if (IFSCCode != null && !IFSCCode.trim().isEmpty()) {
				BL.clickElement(B.SettlementIFSCCode);
				BL.enterElement(B.SettlementIFSCCode, IFSCCode);
				BL.selectDropdownOption(IFSCCode);
				performTabKeyPress();
				String actualValue = BL.getElementText(B.SettlementIFSCCode);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						BL.isElementNotDisplayed(B.SettlementIFSCFieldisRequired, "Field is Required");
						assertEquals(IFSCCode.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : IFSC Code", IFSCCode, Status,
						errorMessage);
			}
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.SaveButton);
				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : Save Button", "Commercial", SaveStatus,
					errorMessage);

			if (type != null && !type.trim().isEmpty()) {
				BL.clickElement(B.SettlementType);
				BL.selectDropdownOption(type);
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : Settlement Type", type, Status,
						errorMessage);
			}
			boolean NextstepStatus = true;
			try {
				BL.clickElement(B.NextStep);
				if (!BL.isElementDisplayed(B.IntroBankonboardingConfig, "Whitelabel")) {
					throw new AssertionError("Assertion Error ");
				}
			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Bank : Settlement Info"); // Take screenshot on error

			}

			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Settlement Info : ", "NextStep", NextstepStatus,
					errorMessage);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Settlement Info");
			throw e;
		}
	}

	// Method to configure White Label
	private void configureWhiteLabel(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {
		String errorMessage = "The data does not match or is empty.";
		String Bank = testData.get("Bank Own Deployment");
		String payfac = testData.get("Payfac Onboarding");
		String ISO = testData.get("ISO Onboarding");
		String Sales = testData.get("Sales Team Onboarding");
		String MaximumNoOfPlatform = testData.get("Maximum No of Platform");
		try {
			BL.clickElement(B.whitelabel);
			if (Bank != null && !Bank.trim().isEmpty()) {
				BL.clickElement(B.WhitelabelBankOwnDeployment);
				BL.selectDropdownOption(Bank);
				String actualValue = BL.getElementText(B.WhitelabelBankOwnDeployment);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(Bank.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Bank Own Deployment", Bank, Status,
						errorMessage);
			}
			if (payfac != null && !payfac.trim().isEmpty()) {
				BL.clickElement(B.WhitelabelPayfacOnboarding);
				BL.selectDropdownOption(payfac);
				String actualValue = BL.getElementText(B.WhitelabelPayfacOnboarding);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(payfac.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Payfac Onboarding", payfac, Status,
						errorMessage);
			}
			if (ISO != null && !ISO.trim().isEmpty()) {
				BL.clickElement(B.WhitelabelISOOnboarding);
				BL.selectDropdownOption(ISO);
				String actualValue = BL.getElementText(B.WhitelabelISOOnboarding);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(ISO.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Whitelabel ISO Onboarding", ISO, Status,
						errorMessage);
			}
			if (Sales != null && !Sales.trim().isEmpty()) {
				BL.clickElement(B.WhitelabelSalesTeamOnboarding);
				BL.selectDropdownOption(Sales);
				String actualValue = BL.getElementText(B.WhitelabelSalesTeamOnboarding);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {
						assertEquals(Sales.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Whitelabel Sales Team Onboarding", Sales,
						Status, errorMessage);
			}
			if (MaximumNoOfPlatform != null && !MaximumNoOfPlatform.trim().isEmpty()) {
				BL.clickElement(B.WhitelabelMaxNumberOfPlatform);
				BL.enterElement(B.WhitelabelMaxNumberOfPlatform, MaximumNoOfPlatform);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.MaxPlatformUserInvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : Maximum No Of Platform",
						MaximumNoOfPlatform, Status, errorMessage);
			}
			boolean NextstepStatus = true;
			try {
				BL.clickElement(B.NextStep);
				if (!BL.isElementDisplayed(B.IntroPaymentBridge, "Webhooks")) {
					throw new AssertionError("Assertion Error ");
				}
			} catch (AssertionError e) {

				CustomWebDriverManager.takeScreenshotStr("Bank : Whitelabel"); // Take screenshot on error

			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Whitelabel : ", " NextStep ", NextstepStatus,
					errorMessage);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Whitelabel");
			throw e;
		}
	}

// Method to configure Webhooks
	private void configureWebhooks(Map<String, String> testData, int TestcaseNo) throws Exception {
		String errorMessage = "The data does not match or is empty.";
		String type = testData.get("Webhook Type");
		String webhookURL = testData.get("Webhook url");
		try {
			BL.clickElement(B.webhooks);
			BL.clickElement(B.AddButton);
			if (type != null && !type.trim().isEmpty()) {
				BL.clickElement(B.WebhookType);
				BL.selectDropdownOption(type);
				String actualValue = BL.getElementText(B.WebhookType);
				boolean Status = true; // Assume success initially
				try {
					if (actualValue != null) {

						assertEquals(type.toUpperCase(), actualValue.toUpperCase());
					}
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Webhooks : Webhook Type", type, Status, errorMessage);
			}
			if (webhookURL != null && !webhookURL.trim().isEmpty()) {
				BL.clickElement(B.WebhookTypeURL);
				BL.enterElement(B.WebhookTypeURL, webhookURL);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.WebhookURLFieldisRequired, "Field is Required");
					BL.isElementNotDisplayed(B.WebhookURLInvalidformat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Webhooks : Webhook URL", webhookURL, Status,
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
					CustomWebDriverManager.takeScreenshotStr("Bank : Webhook ");
				}

			} catch (Exception e) {
				saveStatus = false;
				errorMessageBuilder.append("Unexpected Error: ").append(e.getMessage());
				CustomWebDriverManager.takeScreenshotStr("Error: Unexpected_Save_Error");
			}

			// Log the test step with any errors encountered
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Save Button : ", "Save", saveStatus,
					errorMessageBuilder.toString());

			boolean NextstepStatus = true;
			try {
				BL.clickElement(B.NextStep);
				BL.isElementDisplayed(B.IntroKycConfig, "KYC");
			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Webhooks : ", "NextStep", NextstepStatus, errorMessage);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Webhooks");
			throw e;
		}
	}

	// Method to fill KYC Details
//	private void fillKYCDetails(Map<String, String> testData, int TestcaseNo)
//			throws InterruptedException, AWTException {
//		String business = testData.get("Business Type");
//		String Company = testData.get("Company Proof of Identity");
//		String IndiPOI = testData.get("Individual Proof of Identity");
//		String IndiPOA = testData.get("Individual Proof of address");
//		String IndiBD = testData.get("Individual Bank Document");
//		String IndiTD = testData.get("Individual Tax Document");
//		String IndiOD = testData.get("Individual Other Document");
//		String errorMessage = "The data does not match or is empty.";
//		try {
//			BL.clickElement(B.AddButton);
//			if (business != null && !business.trim().isEmpty()) {
//				BL.clickElement(B.KYCBusinessType);
//				BL.selectDropdownOption(business);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : KYC Business Type", business, Status,
//						errorMessage);
//			}
//			if (Company != null && !Company.trim().isEmpty()) {
//				BL.clickElement(B.proofofIdentityComapany);
//				BL.selectDropdownOption(Company);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof Of Identity Company KYC", Company, Status,
//						errorMessage);
//			}
//			if (IndiPOI != null && !IndiPOI.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualProofOfIdentity);
//				BL.selectDropdownOption(IndiPOI);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof of identity Individual KYC", IndiPOI,
//						Status, errorMessage);
//			}
//			if (IndiPOA != null && !IndiPOA.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualProofOFAddress);
//				BL.selectDropdownOption(IndiPOA);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof of address Individual KYC", IndiPOA,
//						Status, errorMessage);
//			}
//			if (IndiBD != null && !IndiBD.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualBankDocument);
//				BL.selectDropdownOption(IndiBD);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Bank Document Individual KYC", IndiBD, Status,
//						errorMessage);
//			}
//			if (IndiTD != null && !IndiTD.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualTaxDocument);
//				BL.selectDropdownOption(IndiTD);
//				performTabKeyPress();
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : TAX Document Individual KYC", IndiTD, Status,
//						errorMessage);
//			}
//			if (IndiOD != null && !IndiOD.trim().isEmpty()) {
//				BL.clickElement(B.KYCIndividualOtherDocument);
//				BL.selectDropdownOption(IndiOD);
//				performTabKeyPress();
//				logInputData("Other Document Individual KYC", IndiOD);
//				boolean Status = true; // Assume success initially
//				try {
//					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//				} catch (AssertionError e) {
//					Status = false;
//					errorMessage = e.getMessage(); // Capture error message
//				}
//				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Other Document Individual KYC", IndiOD, Status,
//						errorMessage);
//			}
//			boolean SaveStatus = true;
//			try {
//				BL.clickElement(B.SaveButton);
//				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
//			} catch (AssertionError e) {
//				SaveStatus = false;
//				errorMessage = e.getMessage(); // Capture error message
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Save Button", "KYC-BANK", SaveStatus, errorMessage);
//
//			boolean NextstepStatus = true;
//			try {
//				BL.clickElement(B.NextStep);
//				if (!BL.isElementDisplayed(B.IntrostatusHistory, "Status History")) {
//					throw new AssertionError("Assertion Error ");
//				}
//			} catch (AssertionError e) {
//
//				CustomWebDriverManager.takeScreenshotStr("Bank : KYC "); // Take screenshot on error
//
//			}
//			logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : ", "NextStep", NextstepStatus, errorMessage);
//		} catch (Exception e) {
//			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
//			exceptionHandler.handleException(e, "KYC-Bank");
//			throw e;
//		}
//	}
	
	private void fillKYCDetails(Map<String, String> testData, int TestcaseNo)
			throws InterruptedException, AWTException {
		String business = testData.get("Business Type");
		String Companys = testData.get("Company Proof of Identity");
		String NOofCPOI = testData.get("No of CPOI");
		String IndiPOI = testData.get("Individual Proof of Identity");
		String NOofIPOI = testData.get("No of IPOI");
		String IndiPOA = testData.get("Individual Proof of address");
		String NOofIPOA = testData.get("No of IPOA");
		String IndiBD = testData.get("Individual Bank Document");
		String NOofIBD = testData.get("No of IBD");
		String IndiTD = testData.get("Individual Tax Document");
		String NOofITD = testData.get("No of ITD");
		String IndiOD = testData.get("Individual Other Document");
		String NOofIOD = testData.get("No of IOD");
		String errorMessage = "The data does not match or is empty.";

		try {
			BL.clickElement(B.AddButton);

			if (business != null && !business.trim().isEmpty()) {
				BL.clickElement(B.KYCBusinessType);
				BL.selectDropdownOption(business);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : KYC Business Type", business, Status,
						errorMessage);
			}

			if (!Companys.isEmpty()) {

				String[] Cmpny = Companys.split(",");
				for (String company : Cmpny) {
					company = company.trim();
					if (!company.isEmpty()) {
						BL.clickElement(B.proofofIdentityComapany);
						BL.selectDropdownOption(company);

						value.add(company);
						performTabKeyPress();
						boolean Status = true;
						// Assume success initially
						try {
							BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						} catch (AssertionError e) {
							Status = false;
							errorMessage = e.getMessage(); // Capture error message
						}
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof Of Identity Company KYC", Companys,
								Status, errorMessage);
					}
				}
			}

			if (NOofCPOI != null && !NOofCPOI.trim().isEmpty()) {

				BL.clickElement(B.KYCNumberofDocinPoiCompany1);
				BL.CLearElement(B.KYCNumberofDocinPoiCompany1);
				BL.enterElement(B.KYCNumberofDocinPoiCompany1, NOofCPOI);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof Of Identity Company KYC CPOI", NOofCPOI,
						Status, errorMessage);
			}

			if (!IndiPOI.isEmpty()) {

				String[] POI = IndiPOI.split(",");
				for (String POIS : POI) {
					POIS = POIS.trim();
					if (!POIS.isEmpty()) {
						BL.clickElement(B.KYCIndividualProofOfIdentity);
						BL.selectDropdownOption(POIS);
						value.add(POIS);
						performTabKeyPress();
						boolean Status = true;
						// Assume success initially
						try {
							BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						} catch (AssertionError e) {
							Status = false;
							errorMessage = e.getMessage(); // Capture error message
						}
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof Of Identity Company KYC", IndiPOI,
								Status, errorMessage);
					}
				}
			}
			if (NOofIPOI != null && !NOofIPOI.trim().isEmpty()) {

				BL.clickElement(B.KycNumberOfDocinPOiIndividual1);
				BL.CLearElement(B.KycNumberOfDocinPOiIndividual1);
				BL.enterElement(B.KycNumberOfDocinPOiIndividual1, NOofIPOI);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof Of Identity Company KYC IPOI", NOofCPOI,
						Status, errorMessage);
			}

			if (!IndiPOA.isEmpty()) {

				String[] POA = IndiPOA.split(",");
				for (String POAS : POA) {
					POAS = POAS.trim();
					if (!POAS.isEmpty()) {
						BL.clickElement(B.KYCIndividualProofOFAddress);
						BL.selectDropdownOption(POAS);
						value.add(POAS);
						performTabKeyPress();
						boolean Status = true;
						// Assume success initially
						try {
							BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						} catch (AssertionError e) {
							Status = false;
							errorMessage = e.getMessage(); // Capture error message
						}
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof of address Individual KYC",
								IndiPOA, Status, errorMessage);
					}
				}
			}
			if (NOofIPOA != null && !NOofIPOA.trim().isEmpty()) {

				BL.clickElement(B.KycNumberOfDocinPoaIndividual2);
				BL.CLearElement(B.KycNumberOfDocinPoaIndividual2);
				BL.enterElement(B.KycNumberOfDocinPoaIndividual2, NOofIPOA);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Proof Of address Individual KYC IPOA" + "",
						NOofIPOA, Status, errorMessage);
			}

			if (!IndiBD.isEmpty()) {

				String[] BD = IndiBD.split(",");
				for (String BDS : BD) {
					BDS = BDS.trim();
					if (!BDS.isEmpty()) {
						BL.clickElement(B.KYCIndividualBankDocument);
						BL.selectDropdownOption(BDS);
						value.add(BDS);
						performTabKeyPress();
						boolean Status = true;
						// Assume success initially
						try {
							BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						} catch (AssertionError e) {
							Status = false;
							errorMessage = e.getMessage(); // Capture error message
						}
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Bank Document Individual KYC", IndiBD,
								Status, errorMessage);
					}
				}
			}
			if (NOofIBD != null && !NOofIBD.trim().isEmpty()) {

				BL.clickElement(B.KycIndividualBankDocs);
				BL.CLearElement(B.KycIndividualBankDocs);
				BL.enterElement(B.KycIndividualBankDocs, NOofIBD);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Bank Document Individual KYC IBD", NOofIBD,
						Status, errorMessage);
			}

			if (!IndiTD.isEmpty()) {

				String[] TD = IndiTD.split(",");
				for (String TDS : TD) {
					TDS = TDS.trim();
					if (!TDS.isEmpty()) {
						BL.clickElement(B.KYCIndividualTaxDocument);
						BL.selectDropdownOption(TDS);
						value.add(TDS);
						performTabKeyPress();
						boolean Status = true;
						// Assume success initially
						try {
							BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						} catch (AssertionError e) {
							Status = false;
							errorMessage = e.getMessage(); // Capture error message
						}
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : TAX Document Individual KYC", IndiTD,
								Status, errorMessage);
					}
				}
			}
			if (NOofITD != null && !NOofITD.trim().isEmpty()) {

				BL.clickElement(B.KycIndividualTaxDocs);
				BL.CLearElement(B.KycIndividualTaxDocs);
				BL.enterElement(B.KycIndividualTaxDocs, NOofITD);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : TAX Document Individual KYC", NOofITD, Status,
						errorMessage);
			}
			if (!IndiOD.isEmpty()) {

				String[] OD = IndiOD.split(",");
				for (String ODS : OD) {
					ODS = ODS.trim();
					if (!ODS.isEmpty()) {
						BL.clickElement(B.KYCIndividualOtherDocument);
						BL.selectDropdownOption(ODS);
						value.add(ODS);
						performTabKeyPress();
						boolean Status = true;
						// Assume success initially
						try {
							BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
						} catch (AssertionError e) {
							Status = false;
							errorMessage = e.getMessage(); // Capture error message
						}
						logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : TAX Document Individual KYC", IndiOD,
								Status, errorMessage);
					}
				}
			}
			if (NOofIOD != null && !NOofIOD.trim().isEmpty()) {

				BL.clickElement(B.keyPersonNumberofOtherDocIndividual3);
				BL.CLearElement(B.keyPersonNumberofOtherDocIndividual3);
				BL.enterElement(B.keyPersonNumberofOtherDocIndividual3, NOofIOD);
				performTabKeyPress();
				boolean Status = true; // Assume success initially
				try {
					BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
				} catch (AssertionError e) {
					Status = false;
					errorMessage = e.getMessage(); // Capture error message
				}
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : TAX Document Individual KYC", NOofIOD, Status,
						errorMessage);
			}

			boolean SaveStatus = true;
			try {
				BL.clickElement(B.SaveButton);
				BL.isElementNotDisplayed(B.InvalidFormat, "Invalid Format");
			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : Save Button", "KYC-BANK", SaveStatus, errorMessage);
			// Log the inputs
			boolean NextstepStatus = true;
			try {
				BL.clickElement(B.NextStep);
				BL.isElementDisplayed(B.IntrostatusHistory, "Status History");
			} catch (AssertionError e) {
				NextstepStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : KYC : ", "NextStep", NextstepStatus, errorMessage);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "KYC-Bank");
			throw e;
		}
	}

	// Method to submit for verification
	private void submitForVerification(int TestcaseNo) throws InterruptedException {

		try {
			String errorMessage = "The data does not match or is empty.";
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.SubmitforVerification);

				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Submit for Verification", "Bank", SaveStatus,
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

				logTestStep(TestcaseNo, "MMS : Bank Onboarding : System Maker : Yes Button", "Submit for Verification",
						SaveStatus, errorMessage);

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

	// Utility methods
	private void performTabKeyPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	@Given("I visit the System Verifier Login in Regression using sheetname {string} and rownumber {int}")
	public void i_visit_the_System_verifier_login(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		try {
			// ExcelDataCache cache = ExcelDataCache.getInstance();
			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
			System.out.println("sheet name: " + testdata);
			String userName = testdata.get(rowNumber).get("UserName");
			String password = testdata.get(rowNumber).get("Password");
			BL.enterElement(L.EnterOnUserName, userName);
			BL.enterElement(L.EnterOnPassword, password);
			test = ExtentCucumberAdapter.getCurrentStep();
			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + userName
					+ "</td><td style='border: 1px solid black;color: black'>" + password + "</td></tr>" + "</table>";
			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");
			String[][] data = { { "UserName", "Password" }, { userName, password }, };
			Markup m = MarkupHelper.createTable(data);
			// or
			test.log(Status.PASS, m);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "LoginScreen");
			throw e;
		}
	}

	@When("System Verifier - Onboarding should be displayed in the side menu")
	public void I_Visit_System_Verifier_Onboarding() throws InterruptedException {
		try {
			BL.clickElement(S.ClickOnDownArrow);
			BL.clickElement(S.ClickOnOnboarding);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@Then("the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")
	public void System_Verifier_seessidemenu_itemsin_Onboarding() throws InterruptedException {
		try {
			BL.isElementDisplayed(B.ClickOnBank, "Bank");
			BL.isElementDisplayed(B.ClickOnPayfac, "Aggregator");
			BL.isElementDisplayed(B.ClickOnISO, "ISO");
			BL.isElementDisplayed(B.ClickOnSUBISO, "SUB ISO");
			BL.isElementDisplayed(B.ClickOnGM, "Group Merchant");
			BL.isElementDisplayed(B.ClickOnMerchant, "Merchant");
			BL.isElementDisplayed(B.ClickOnTerminal, "Terminal");
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@When("the System Verifier clicks the bank module")
	public void SystemVerifierClicktheBankModule() {
		try {
			BL.clickElement(B.ClickOnBank);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@Then("the System Verifier completes Bank Onboarding, the system should prompt to verify all steps using the sheet name {string}")
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

	private int runTestForRow1(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {
		// Log the test data for the current row
		System.out.println("Data for row " + rowNumber + ": " + testData);
		// Initialize the locators (e.g., BankLocators)
		int testCaseCount = 0;
		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow1(testData, rowNumber);
		return testCaseCount;
	}

	private int validateFieldsForRow1(Map<String, String> testData, int TestcaseNo) throws Exception {
		// Initialize the locators
		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;
		// Bank Details Section
		validatedFieldsCount += executeStep1(() -> {
			try {
				SearchbyBank(testData, TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "SearchbyBank");
		validatedFieldsCount += executeStep(() -> {
			try {
//	fillBankDetails(testData, TestcaseNo);
				GenernalInfoVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "General Info Verified");
		// Communication Details Section
		validatedFieldsCount += executeStep(() -> {
			try {
				CommunicationInfoVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Communication Info Verified");
		// Channel Config Section
		validatedFieldsCount += executeStep(() -> {
			try {
				ChannelConfigVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Channel Config verified");
		// ONUS Section
		validatedFieldsCount += executeStep(() -> {
			try {
				configureONUSVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "ONUS Configuration");
		// Global Form Section
		validatedFieldsCount += executeStep(() -> {
			try {
				GlobalFormVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Global Form");
		// Commercial Section
		validatedFieldsCount += executeStep(() -> {
			try {
				CommercialVerified(TestcaseNo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Commercial Verfied");
		// Settlement Info Section
		validatedFieldsCount += executeStep(() -> {
			try {
				SettlementInfoVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Settlement Info Verified");
		// White Label Section
		validatedFieldsCount += executeStep(() -> {
			try {
				WhiteLabelVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "White Label Configuration Verified");
		// Webhooks Section
		validatedFieldsCount += executeStep(() -> {
			try {
				WebhooksVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Webhook Configuration");
		// KYC Section
		validatedFieldsCount += executeStep(() -> {
			try {
				KYCDetailsVerified(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "KYC Details");
		// Final Submission
		validatedFieldsCount += executeStep(() -> {
			try {
				submitForApproval(TestcaseNo);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Final Submission - Verified");
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

	private void SearchbyBank(Map<String, String> testData, int TestcaseNo) throws InterruptedException, AWTException {
		String Bankname = testData.get("bankName");
//		String Bankname = "PRI BANK";
		key.clear();
		value.clear();
		BL.clickElement(B.SearchbyBankName);
		Thread.sleep(1000);
		BL.enterElement(B.SearchbyBankName, Bankname);
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(4000);
			BL.clickElement(B.ActionClick);
			Thread.sleep(1000);
			BL.clickElement(B.ViewButton);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding :Actions and View", "Bank Status Inprogress", verifiedStatus,
				errorMessage);
	}

	private void GenernalInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.GeneralInfo);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "General Info", verifiedStatus, errorMessage);
	}

	private void CommunicationInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.CommunicationInfo);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Communication Info", verifiedStatus, errorMessage);
	}

	private void ChannelConfigVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.ChannelConfig);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Channel Config", verifiedStatus, errorMessage);
	}

	private void configureONUSVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.ONUSRouting);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "ONUS Routing", verifiedStatus, errorMessage);
	}

	private void GlobalFormVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.GlobalFrm);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Global FRM", verifiedStatus, errorMessage);
	}

	private void CommercialVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.Commercial);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Commercial", verifiedStatus, errorMessage);
	}

	private void SettlementInfoVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.SettlementInfo);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Settlement Info", verifiedStatus, errorMessage);
	}

	private void WhiteLabelVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.whitelabel);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified ", "Whitelabel", verifiedStatus, errorMessage);
	}

	private void WebhooksVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.webhooks);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "Webhooks", verifiedStatus, errorMessage);
	}

	private void KYCDetailsVerified(int TestcaseNo) throws InterruptedException, AWTException {
		String errorMessage = "Verified Button is not displayed.";
		boolean verifiedStatus = true;
		try {
			Thread.sleep(1000);
			BL.clickElement(B.VerifiedandNext);
		} catch (AssertionError e) {
			verifiedStatus = false;
			errorMessage = e.getMessage(); // Capture error message
		}
		logTestStep(TestcaseNo, "MMS : Bank Onboarding : Verified", "KYC", verifiedStatus, errorMessage);
	}

	private void submitForApproval(int TestcaseNo) throws InterruptedException, AWTException {

		try {

			String errorMessage = "The data does not match or is empty.";
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.SubmitforApproval);

				logTestStep(TestcaseNo, "MMS : Bank Onboarding : 	proval", "Bank", SaveStatus, errorMessage);

			} catch (AssertionError e) {
				SaveStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			try {
				BL.clickElement(B.YesButton);
				BL.clickElement(B.OKButton);

				BL.isElementDisplayed(B.VerfiedSuccessCompleted, "Submit for Approval");

				logTestStep(TestcaseNo, "MMS : Bank Onboarding : System Verifier : Yes Button", "Submit for Approval",
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

	@Given("I visit the System Approver Login in Regression using sheetname {string} and rownumber {int}")
	public void i_visit_the_System_Approver_login(String sheetName, int rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		try {
			// ExcelDataCache cache = ExcelDataCache.getInstance();
			List<Map<String, String>> testdata = cache.getCachedData(sheetName);
			System.out.println("sheet name: " + testdata);
			String userName = testdata.get(rowNumber).get("UserName");
			String password = testdata.get(rowNumber).get("Password");
			BL.enterElement(L.EnterOnUserName, userName);
			BL.enterElement(L.EnterOnPassword, password);
			test = ExtentCucumberAdapter.getCurrentStep();
			String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
					+ "<tr><td style='border: 1px solid black;color: black'>UserName</td><td style='border: 1px solid black;color: black'>Password</td></tr>"
					+ "<tr><td style='border: 1px solid black;color: black'>" + userName
					+ "</td><td style='border: 1px solid black;color: black'>" + password + "</td></tr>" + "</table>";
			Allure.addAttachment("Input Datas", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");
			String[][] data = { { "UserName", "Password" }, { userName, password }, };
			Markup m = MarkupHelper.createTable(data);
			// or
			test.log(Status.PASS, m);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "LoginScreen");
			throw e;
		}
	}

	@When("System Approver - Onboarding should be displayed in the side menu")
	public void I_Visit_System_Approver_Onboarding() throws InterruptedException {
		try {
			BL.clickElement(S.ClickOnDownArrow);
			BL.clickElement(S.ClickOnOnboarding);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@Then("the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding")
	public void System_Approver_seessidemenu_itemsin_Onboarding() throws InterruptedException {
		try {
			BL.isElementDisplayed(B.ClickOnBank, "Bank");
			BL.isElementDisplayed(B.ClickOnPayfac, "Aggregator");
			BL.isElementDisplayed(B.ClickOnISO, "ISO");
			BL.isElementDisplayed(B.ClickOnSUBISO, "SUB ISO");
			BL.isElementDisplayed(B.ClickOnGM, "Group Merchant");
			BL.isElementDisplayed(B.ClickOnMerchant, "Merchant");
			BL.isElementDisplayed(B.ClickOnTerminal, "Terminal");
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@When("the System Approver clicks the bank module")
	public void SystemApproverClicktheBankModule() {
		try {
			BL.clickElement(B.ClickOnBank);
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Onboarding");
			throw e;
		}
	}

	@Then("the System Approver completes Bank Onboarding, the system should prompt to Approve using the sheet name {string}")
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

	private int runTestForRow2(String sheetName, Map<String, String> testData, int rowNumber) throws Exception {
		// Log the test data for the current row
		System.out.println("Data for row " + rowNumber + ": " + testData);
		// Initialize the locators (e.g., BankLocators)
		int testCaseCount = 0;
		// Validate fields for the current row using testData
		testCaseCount += validateFieldsForRow2(testData, rowNumber);
		return testCaseCount;
	}

	@SuppressWarnings("unused")
	private int validateFieldsForRow2(Map<String, String> testData, int TestcaseNo) throws Exception {
		// Initialize the locators
		// Initialize a counter to track the number of validated fields/sections
		int validatedFieldsCount = 0;
		// Bank Details Section
		validatedFieldsCount += executeStep1(() -> {
			try {
				SearchbyBankApprove(testData);
			} catch (InterruptedException | AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "SearchbyBankApprove");
		validatedFieldsCount += executeStep2(() -> {
			try {
				approveBankOnboarding(testData, TestcaseNo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "approveBankOnboarding");

		validatedFieldsCount += executeStep2(() -> {
			try {
				getCpid(testData, TestcaseNo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "getCpid");
		// Return the total count of validated fields/sections
		return validatedFieldsCount;
	}

	private int executeStep2(Runnable step, String stepName) {
		try {
			step.run();
			return 1;
		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, stepName);
			return 0; // Return 0 for failed execution
		}
	}

	private void SearchbyBankApprove(Map<String, String> testData) throws InterruptedException, AWTException {
		String Bankname = testData.get("bankName");
		key.clear();
		value.clear();
		BL.clickElement(B.SearchbyBankName);
		Thread.sleep(1000);
		BL.enterSplitElement(B.SearchbyBankName, Bankname);
		try {
			Thread.sleep(3000);
			BL.clickElement(B.ActionClick);
			Thread.sleep(1000);
			BL.clickElement(B.ViewButton);
		} catch (AssertionError e) {
		}

	}

	private void approveBankOnboarding(Map<String, String> testData, int TestcaseNo) throws InterruptedException {
		B = new org.Locators.BankLocators(driver);
		key.clear();
		value.clear();

		try {
			String errorMessage = "The data does not match or is empty.";
			boolean ApprovedStatus = true;
			try {
				BL.clickElement(B.Approve);

				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Approval", "Bank", ApprovedStatus, errorMessage);

			} catch (AssertionError e) {
				ApprovedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

			try {
				BL.clickElement(B.YesButton);
				BL.clickElement(B.OKButton);

				BL.isElementDisplayed(B.VerfiedSuccessCompleted, "Approval");

				BL.clickElement(B.ApproveCancel);
				logTestStep(TestcaseNo, "MMS : Bank Onboarding : System Approver : Yes", "Approval", ApprovedStatus,
						errorMessage);

			} catch (AssertionError e) {
				ApprovedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Submit for Approval");
			throw e;
		}

	}

	private void getCpid(Map<String, String> testData, int TestcaseNo) throws InterruptedException {

		B = new org.Locators.BankLocators(driver);
		String Bankname = testData.get("bankName");
		key.clear();
		value.clear();

		try {
			String errorMessage = "The data does not match or is empty.";
			boolean ApprovedStatus = true;

			try {
				BL.clickElement(B.SearchbyBankName);
				Thread.sleep(1000);
				BL.enterSplitElement(B.SearchbyBankName, Bankname);
				Thread.sleep(4000);
				BL.clickElement(B.ActionClick);
				Thread.sleep(1000);
				BL.clickElement(B.ViewButton);
			} catch (AssertionError e) {
				ApprovedStatus = false;
				errorMessage = e.getMessage(); // Capture error message
			}
			logTestStep(TestcaseNo, "MMS : Bank Onboarding :  Bank CPID", BL.getElementValue(B.CPID), ApprovedStatus,
					errorMessage);
			BL.clickElement(B.ApproveCancel);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Submit for Approval");
			throw e;
		}
	}

	private void performLogout(int TestcaseNo) throws InterruptedException {

		try {
			String errorMessage = "The data does not match or is empty.";
			boolean SaveStatus = true;
			try {
				BL.clickElement(B.Profile);
				BL.clickElement(B.LogOut);

				logTestStep(TestcaseNo, "MMS : Bank Onboarding : Profile & Log Out", "Bank", SaveStatus, errorMessage);

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
			logTestStep(TestcaseNo, "MMS : Bank Onboarding : Yes Button", "Log-Out", SaveStatus, errorMessage);

		} catch (Exception e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Log Out");
			throw e;
		}

	}
}