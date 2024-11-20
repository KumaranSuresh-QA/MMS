package org.Testcases;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.model.TestResultContainer;
import java.util.List;
import java.util.UUID;


import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import java.io.ByteArrayInputStream;


public class TestCaseManager {



    private String currentTestCaseUuid;
    private String currentTestSuiteUuid;

    // Starts a new test case in Allure
    public void startNewTestCase(String testName, boolean isSuccess) {
        currentTestCaseUuid = UUID.randomUUID().toString();
        TestResult result = new TestResult()
                .setUuid(currentTestCaseUuid)
                .setName(testName)
                .setStatus(isSuccess ? Status.PASSED : Status.FAILED);
        Allure.getLifecycle().scheduleTestCase(result);
        Allure.getLifecycle().startTestCase(currentTestCaseUuid);
        
    }

    // Ends the current test case
    public void endTestCase(boolean isSuccess) {
        if (currentTestCaseUuid != null) {
            Allure.getLifecycle().updateTestCase(testResult -> {
                testResult.setStatus(isSuccess ? Status.PASSED : Status.FAILED);
            });
            Allure.getLifecycle().stopTestCase(currentTestCaseUuid);
            Allure.getLifecycle().writeTestCase(currentTestCaseUuid);
            currentTestCaseUuid = null;
        }
    }

    // Starts a new test suite for each row
    public void startNewTestSuite(int rowNumber) {
        currentTestSuiteUuid = UUID.randomUUID().toString();
        TestResultContainer suite = new TestResultContainer()
                .setUuid(currentTestSuiteUuid)
                .setName("Test Suite for Row " + rowNumber); // Dynamic suite name for each row
        Allure.getLifecycle().startTestContainer(suite);
    }

    // Ends the current test suite
    public void endTestSuite() {
        if (currentTestSuiteUuid != null) {
            Allure.getLifecycle().stopTestContainer(currentTestSuiteUuid);
            Allure.getLifecycle().writeTestContainer(currentTestSuiteUuid);
            currentTestSuiteUuid = null;
        }
    }

    // Logs input data as an HTML table
    public void logInputDataa(List<String> keys, List<String> values) {
        // Ensure keys and values have the same size
        int maxColumns = Math.min(keys.size(), values.size());
        
        // Adjust lists to the smaller size to avoid ArrayIndexOutOfBoundsException
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
        
        ExtentCucumberAdapter.getCurrentStep();

        // Attach table to Allure/Extent reports
        Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(tableBuilder.toString().getBytes()), "html");
    }

    // Logs an error message in Extent reports
    public void logErrorInExtent(String errorMessage) {
        ExtentCucumberAdapter.addTestStepLog("Error encountered: " + errorMessage);
    }

}


