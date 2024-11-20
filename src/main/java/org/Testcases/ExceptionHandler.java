package org.Testcases;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.qameta.allure.Allure;

public class ExceptionHandler {

    private WebDriver driver;  // WebDriver instance
    private ExtentTest test;   // ExtentTest instance for logging

    // Constructor to initialize WebDriver and ExtentTest
    public ExceptionHandler(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    // Method to handle and log exceptions
    public void handleException(Exception e, String sheetName) {
        if (e instanceof NoSuchElementException) {
            logAndCaptureScreenshot(e, sheetName, "No such element found");
        } else if (e instanceof ElementNotInteractableException) {
            logAndCaptureScreenshot(e, sheetName, "Element not interactable");
        } else if (e instanceof TimeoutException) {
            logAndCaptureScreenshot(e, sheetName, "Timeout occurred");
        } else if (e instanceof StaleElementReferenceException) {
            logAndCaptureScreenshot(e, sheetName, "Stale element reference");
        } else if (e instanceof ElementClickInterceptedException) {
            logAndCaptureScreenshot(e, sheetName, "Element click intercepted");
        } else if (e instanceof WebDriverException) {
            logAndCaptureScreenshot(e, sheetName, "WebDriver exception occurred");
        } else if (e instanceof InvalidSelectorException) {
            logAndCaptureScreenshot(e, sheetName, "Invalid selector used");
        } else if (e instanceof JavascriptException) {
            logAndCaptureScreenshot(e, sheetName, "JavaScript execution error");
        } else if (e instanceof UnhandledAlertException) {
            logAndCaptureScreenshot(e, sheetName, "Unhandled alert present");
        } else if (e instanceof InvalidElementStateException) {
            logAndCaptureScreenshot(e, sheetName, "Invalid element state");
        } else {
            logAndCaptureScreenshot(e, sheetName, "An unknown error occurred");
        }
    }

    // Method to capture and log screenshots
    private void logAndCaptureScreenshot(Exception e, String sheetName, String errorMessage) {
	        try {
	            // Take a screenshot
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	            String screenshotPath = "C:\\Users\\DELL 7480\\eclipse-workspace\\MMSCredopay\\Screenshots\\" + sheetName + ".png";
	            String screenshotPath = CustomWebDriverManager.getScreenshotDir() + sheetName + ".png";
	
	            // Save the screenshot to the specified path
	            FileUtils.copyFile(screenshot, new File(screenshotPath));
	
	            // Attach the screenshot to the Allure report
	            Allure.addAttachment("Screenshot for " + sheetName, new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));
	
	            // Attach the screenshot to the Extent report
	            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for " + sheetName);
	
	            // Log the error message in Extent report
	            test.log(Status.FAIL, errorMessage + ": " + e.getMessage());

            // Optionally print the screenshot path for debugging
            System.out.println("Screenshot captured for " + sheetName + ": " + screenshotPath);

        } catch (IOException ex) {
            test.log(Status.FAIL, "Failed to capture screenshot: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}




