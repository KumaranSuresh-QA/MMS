package org.Testcases;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.model.TestResultContainer;
import java.util.List;
import java.util.UUID;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.io.ByteArrayInputStream;

public class ExtentTestCaseManager {

    private String currentTestCaseUuid;
    private String currentTestSuiteUuid;
    private ExtentReports extentReports; // Your ExtentReports instance
    private ExtentTest extentTest; // Current test instance for ExtentReports

    public ExtentTestCaseManager(ExtentReports extentReports) {
        this.extentReports = extentReports;	
    }

    // Starts a new test case in Allure and Extent Reports
    public void startNewTestCase(String testName, boolean isSuccess) {
        currentTestCaseUuid = UUID.randomUUID().toString();

        // Allure
        TestResult result = new TestResult()
                .setUuid(currentTestCaseUuid)
                .setName(testName)
                .setStatus(isSuccess ? Status.PASSED : Status.FAILED);
        Allure.getLifecycle().scheduleTestCase(result);
        Allure.getLifecycle().startTestCase(currentTestCaseUuid);

        // Extent Reports
        extentTest = extentReports.createTest(testName);
    }

    // Ends the current test case
    public void endTestCase(boolean isSuccess) {
        // Update Allure
        if (currentTestCaseUuid != null) {
            Allure.getLifecycle().updateTestCase(testResult -> {
            	  testResult.setStatus(isSuccess ? Status.PASSED : Status.FAILED);
            });
            Allure.getLifecycle().stopTestCase(currentTestCaseUuid);
            Allure.getLifecycle().writeTestCase(currentTestCaseUuid);
            currentTestCaseUuid = null;
        }

        // Update Extent Reports
        if (extentTest != null) {
            if (isSuccess) {
                extentTest.log(com.aventstack.extentreports.Status.PASS,  "Test case completed successfully");
            } else {
                extentTest.log(com.aventstack.extentreports.Status.FAIL, "Test case failed");
            }
            extentReports.flush(); // Flush reports to save them
        }
    }

    // Starts a new test suite for each row
    public void startNewTestSuite(int rowNumber) {
        currentTestSuiteUuid = UUID.randomUUID().toString();

        // Allure
        TestResultContainer suite = new TestResultContainer()
                .setUuid(currentTestSuiteUuid)
                .setName("Test Suite for Row " + rowNumber);
        Allure.getLifecycle().startTestContainer(suite);

        // Extent Reports
        extentTest = extentReports.createTest("Suite for Row " + rowNumber);
    }

    // Ends the current test suite
    public void endTestSuite() {
        // End Allure
        if (currentTestSuiteUuid != null) {
            Allure.getLifecycle().stopTestContainer(currentTestSuiteUuid);
            Allure.getLifecycle().writeTestContainer(currentTestSuiteUuid);
            currentTestSuiteUuid = null;
        }

        // Update Extent Reports
        if (extentTest != null) {
            extentTest.log(com.aventstack.extentreports.Status.INFO, "Test Suite completed");
        }
    }

    // Logs input data as an HTML table
    public void logInputData(List<String> keys, List<String> values) {
        // Ensure keys and values have the same size
        int maxColumns = Math.min(keys.size(), values.size());

        // Adjust lists to the smaller size
        List<String> adjustedKeys = keys.subList(0, maxColumns);
        List<String> adjustedValues = values.subList(0, maxColumns);

        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append("<table style='color: black; border: 1px solid black; border-collapse: collapse;'>");

        // Add headers
        tableBuilder.append("<tr>");
        for (String key : adjustedKeys) {
            tableBuilder.append("<th style='border: 1px solid black;'>").append(key).append("</th>");
        }
        tableBuilder.append("</tr>");

        // Add values
        tableBuilder.append("<tr>");
        for (String value : adjustedValues) {
            tableBuilder.append("<td style='border: 1px solid black;'>").append(value).append("</td>");
        }
        tableBuilder.append("</tr>");
        tableBuilder.append("</table>");

        // Attach table to Allure and Extent Reports
        Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(tableBuilder.toString().getBytes()), "html");
        extentTest.log(com.aventstack.extentreports.Status.INFO, MarkupHelper.createTable(new String[][]{adjustedKeys.toArray(new String[0]), adjustedValues.toArray(new String[0])}));
    }

    // Logs an error message in Extent reports
    public void logErrorInExtent(String errorMessage) {
        if (extentTest != null) {
            extentTest.log(com.aventstack.extentreports.Status.FAIL, "Error encountered: " + errorMessage);
        }
    }
}
