package org.Testcases;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
//import io.qameta.allure.Allure;
//import org.junit.Assert;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//public class TestExecutor {
//    private final List<Map<String, String>> testData;
//    private final String sheetName;
//    private final TestCaseManager testCaseManager;
//    private int totalTestCaseCount = 0;
//    private final WebDriver driver;
//
//    // Constructor
//    public TestExecutor(String sheetName, List<Map<String, String>> testData, WebDriver driver) {
//        this.sheetName = sheetName;
//        this.testData = testData;
//        this.driver = driver;
//        this.testCaseManager = new TestCaseManager();
//    }
//
//    // Main method to execute tests
////    public void executeTests() {
////        int numberOfRows = testData.size();
////        System.out.println("Total rows found: " + numberOfRows);
////
////        // Create a thread pool with the same number of threads as the number of rows
////        ExecutorService executorService = Executors.newFixedThreadPool(numberOfRows);
////
////        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
////            final int index = rowNumber;
////            executorService.submit(() -> {
////                try {
////                    runTestForRow(index);
////                } catch (Exception e) {
////                    System.err.println("Error in row " + (index + 1) + ": " + e.getMessage());
////                }
////            });
////        }
////
////        // Shutdown the thread pool and wait for completion
////        executorService.shutdown();
////        try {
////            executorService.awaitTermination(30, TimeUnit.MINUTES);
////        } catch (InterruptedException e) {
////            Thread.currentThread().interrupt();
////            System.err.println("Error while waiting for thread termination: " + e.getMessage());
////        }
////    }
////
////    // Execute tests for each row
////    private void runTestForRow(int rowNumber) throws Exception {
////        WebDriver currentDriver = driver;
////
////        try {
////            // Open the base URL or a new tab for each row
////            String baseUrl = CustomWebDriverManager.getBaseUrl();
////            if (rowNumber == 0) {
////                currentDriver.get(baseUrl); // Open first row in the current tab
////            } else {
////                ((JavascriptExecutor) currentDriver).executeScript("window.open('" + baseUrl + "', '_blank');");
////                waitForNewTabToLoad();
////                switchToTab(rowNumber);
////            }
////
////            // Retrieve row data from testData
////            Map<String, String> rowData = testData.get(rowNumber);
////            if (rowData == null || rowData.isEmpty()) {
////                System.err.println("No data found for row " + (rowNumber + 1));
////                return; // Skip this row if no data found
////            }
////
////            // Start test case for this row
////            testCaseManager.startNewTestCase("Test Case for Row " + (rowNumber + 1), true);
////            testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));
////
////            // Execute the test logic for this row (implement your business logic here)
////            SystemUserMultipleBankRegression systemUserTest = new SystemUserMultipleBankRegression();
////            int rowTestCaseCount = systemUserTest.runTestForRow(sheetName, rowData, rowNumber + 1);
////            totalTestCaseCount += rowTestCaseCount;
////
////            // End the test case successfully
////            testCaseManager.endTestCase(true);
////        } catch (Exception e) {
////            takeScreenshot(rowNumber + 1); // Take screenshot if there's an error
////            testCaseManager.logErrorInExtent("Error on row " + (rowNumber + 1) + ": " + e.getMessage());
////            Assert.fail("Exception encountered for row " + (rowNumber + 1) + ": " + e.getMessage());
////        }
////    }
////
//    public void executeTests() {
//    	System.out.println("HI");
//        int numberOfRows = testData.size();
//        System.out.println("Total rows found: " + numberOfRows);
//
//        openTabs.add("rowNumber "+0 ); 
//        // Create a thread pool with the same number of threads as the number of rows
//        ExecutorService executorService = Executors.newFixedThreadPool(numberOfRows);
//
//        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
//            int index = rowNumber;
//            executorService.submit(() -> {
//                try {
//                    System.err.println("Error in row " + (index + 1) + ": ");
//
//                    runTestForRow(index);
//                } catch (Exception e) {
//                    System.err.println("Error in row " + (index + 1) + ": " + e.getMessage());
//                }
//            });
//        }
//
//        // Shutdown the thread pool and wait for completion
//        executorService.shutdown();
//        try {
//            executorService.awaitTermination(30, TimeUnit.MINUTES);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.err.println("Error while waiting for thread termination: " + e.getMessage());
//        }
//    }
//
//    private Set<String> openTabs = new HashSet<>(); // Set to keep track of open tab URLs
//
//    // Execute tests for each row
////    private void runTestForRow(int rowNumber) throws Exception {
//////        WebDriver currentDriver = CustomWebDriverManager.getDriver(); // Get a unique WebDriver instance for this thread
////        WebDriver currentDriver = CustomWebDriverManager.getDriver(); // Get a unique WebDriver instance for this thread
////        String baseUrl = CustomWebDriverManager.getBaseUrl(); // Get the base URL
////        System.out.println("rowNumber ==================="+rowNumber);
////        try {
////        	openTabs.add("rowNumber "+rowNumber); 
////            // Open the base URL or a new tab for each row
//////        	TabManager tabManager = new TabManager(currentDriver);
////        	WebDriver tab1Driver;
////        	// Get driver for the first tab
////            String dateuniq = "rowNumber "+rowNumber;
////            if (openTabs.contains(dateuniq)) {
////            	switchToTab(rowNumber);
//////            	tab1Driver = CustomWebDriverManager.getDriver();
////
//////            	tab1Driver = tabManager.getDriverForTab(rowNumber);
////            } else {
////                // Open a new tab if the URL is not open
////                ((JavascriptExecutor) currentDriver).executeScript("window.open('" + baseUrl + "', '_blank');");
////                waitForNewTabToLoad();
////                openTabs.add(dateuniq); // Add the URL to the set of open tabs
////                switchToTab(rowNumber);
////                tab1Driver = CustomWebDriverManager.getDriver();
//////            	tab1Driver = tabManager.getDriverForTab(rowNumber);
////            }
////            // Retrieve row data from testData
////            Map<String, String> rowData = testData.get(rowNumber);
////            if (rowData == null || rowData.isEmpty()) {
////                System.err.println("No data found for row " + (rowNumber + 1));
////                return; // Skip this row if no data found
////            }
////
////            // Start test case for this row
//////            testCaseManager.startNewTestCase("Test Case for Row " + (rowNumber + 1), true);
//////            testCaseManager.logInputDataa(new ArrayList<>(rowData.keySet()), new ArrayList<>(rowData.values()));
////
////            // Execute the test logic for this row (implement your business logic here)
////            if (tab1Driver == null) {
////                System.err.println("tab1Driver is null for row " + (rowNumber + 1));
////                return; // or handle it as per your requirement
////            }
////            SystemUserMultipleBankRegression systemUserTest = new SystemUserMultipleBankRegression() ;
////             
////
////             System.out.println(sheetName+ "========="+rowData + "========="+rowNumber + 1);
////            int rowTestCaseCount = systemUserTest.runTestForRow(sheetName, rowData, rowNumber + 1,tab1Driver);
////            totalTestCaseCount += rowTestCaseCount;
////
////            // End the test case successfully
////            testCaseManager.endTestCase(true);
////        } catch (Exception e) {
////            takeScreenshot(rowNumber + 1); // Take screenshot if there's an error
////            testCaseManager.logErrorInExtent("Error on row " + (rowNumber + 1) + ": " + e.getMessage());
////            Assert.fail("Exception encountered for row " + (rowNumber + 1) + ": " + e.getMessage());
////        } finally {
////            currentDriver.quit(); // Ensure the WebDriver instance is closed after use
////        }
////    }
//
////    // Log dashboard count
//    public void logDashboardCount() {
//        String message = "Total Dashboard Count: " + totalTestCaseCount;
//        ExtentCucumberAdapter.addTestStepLog(message);
//        Allure.parameter("Total Test Case Count", totalTestCaseCount); // Ensure Allure receives a modifiable list
//        System.out.println(message);
//    }
////
////    // Switch to tab
////    private void switchToTab(int tabIndex) {
////        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
////        driver.switchTo().window(windowHandles.get(tabIndex));
////    }
////
////    // Wait for the new tab to load
//    private void waitForNewTabToLoad() {
//        try {
//            Thread.sleep(1000); // Wait for the new tab to load completely
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.err.println("Interrupted while waiting for the new tab: " + e.getMessage());
//        }
//    }
//
//    // Take a screenshot for failed test case
//    private void takeScreenshot(int row) {
//        // Implement screenshot logic here
//        // Example: save screenshot with row number in the name
//    }
//    
//    
// // Execute tests for each row
////    private void runTestForRow(int rowNumber) throws Exception {
////        WebDriver currentDriver = CustomWebDriverManager.getDriver(); // Get a unique WebDriver instance for this thread
////        String baseUrl = CustomWebDriverManager.getBaseUrl(); // Get the base URL
////        System.out.println("rowNumber ===================" + rowNumber);
////
////        try {
////            String dateuniq = "rowNumber " + rowNumber;
////            WebDriver tab1Driver;
////
////            if (openTabs.contains(dateuniq)) {
////                switchToTab(rowNumber);
////                tab1Driver = CustomWebDriverManager.getDriver(); // Retrieve the driver for the switched tab
////            } else {
////                // Open a new tab if the URL is not open
////                ((JavascriptExecutor) currentDriver).executeScript("window.open('" + baseUrl + "', '_blank');");
////                waitForNewTabToLoad(); // Ensure the new tab is loaded
////                openTabs.add(dateuniq); // Add the URL to the set of open tabs
////                switchToTab(rowNumber);
////                tab1Driver = CustomWebDriverManager.getDriver(); // Retrieve the driver for the new tab
////            }
////
////            // Retrieve row data from testData
////            Map<String, String> rowData = testData.get(rowNumber);
////            if (rowData == null || rowData.isEmpty()) {
////                System.err.println("No data found for row " + (rowNumber + 1));
////                return; // Skip this row if no data found
////            }
////
////            // Check if the driver is valid
////            if (tab1Driver == null) {
////                System.err.println("tab1Driver is null for row " + (rowNumber + 1));
////                return; // Handle the null driver case appropriately
////            }
////
////            // Execute the test logic for this row (implement your business logic here)
////            SystemUserMultipleBankRegression systemUserTest = new SystemUserMultipleBankRegression();
////            System.out.println(sheetName + "=========" + rowData + "=========" + (rowNumber + 1));
////            int rowTestCaseCount = systemUserTest.runTestForRow(sheetName, rowData, rowNumber + 1, tab1Driver);
////            totalTestCaseCount += rowTestCaseCount;
////
////            // End the test case successfully
////            testCaseManager.endTestCase(true);
////        } catch (Exception e) {
////            takeScreenshot(rowNumber + 1); // Take screenshot if there's an error
////            testCaseManager.logErrorInExtent("Error on row " + (rowNumber + 1) + ": " + e.getMessage());
////            Assert.fail("Exception encountered for row " + (rowNumber + 1) + ": " + e.getMessage());
////        } finally {
////            // Avoid quitting the driver here to allow each tab to be managed independently
////            // currentDriver.quit(); // Uncomment if you want to close the driver after all tests
////        }
////    }
//
//    private void runTestForRow(int rowNumber) throws Exception {
//        WebDriver currentDriver = CustomWebDriverManager.getDriver(); // Unique driver for this thread
//        String baseUrl = CustomWebDriverManager.getBaseUrl(); // Get the base URL
//        System.out.println("rowNumber ===================" + rowNumber);
//
//        try {
//            String dateuniq = "rowNumber " + rowNumber;
//            WebDriver tab1Driver;
//
//            if (openTabs.contains(dateuniq)) {
//                switchToTab(rowNumber);
//                tab1Driver = CustomWebDriverManager.getDriver(); // Use the driver for the active tab
//            } else {
//                // Open a new tab if the URL is not open
//                ((JavascriptExecutor) currentDriver).executeScript("window.open('" + baseUrl + "', '_blank');");
////                waitForTabToLoad(); // Wait for the new tab to load
//                openTabs.add(dateuniq); // Add the URL to the set of open tabs
//                switchToTab(rowNumber);
//                tab1Driver = CustomWebDriverManager.getDriver(); // Get driver for the new tab
//            }
//
//            // Retrieve row data from testData
//            Map<String, String> rowData = testData.get(rowNumber);
//            if (rowData == null || rowData.isEmpty()) {
//                System.err.println("No data found for row " + (rowNumber + 1));
//                return; // Skip this row if no data found
//            }
//
//            // Pass the unique driver to the test execution
//            SystemUserMultipleBankRegression systemUserTest = new SystemUserMultipleBankRegression();
////            int rowTestCaseCount = systemUserTest.runTestForRow(sheetName, rowData, rowNumber + 1, tab1Driver);
////            totalTestCaseCount += rowTestCaseCount;
//
//            // End the test case successfully
//            testCaseManager.endTestCase(true);
//        } catch (Exception e) {
//            takeScreenshot(rowNumber + 1); // Take screenshot if there's an error
//            testCaseManager.logErrorInExtent("Error on row " + (rowNumber + 1) + ": " + e.getMessage());
//            Assert.fail("Exception encountered for row " + (rowNumber + 1) + ": " + e.getMessage());
//        } finally {
//            // Ensure the driver instance is quit only if it's not needed anymore
//            // CustomWebDriverManager.quitDriver(); // Uncomment if you want to close drivers after all tests
//        }
//    }
//    // Switch to tab
//    private void switchToTab(int tabIndex) {
//        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
//        if (tabIndex < windowHandles.size()) {
//            driver.switchTo().window(windowHandles.get(tabIndex));
//        } else {
//            System.err.println("Invalid tab index: " + tabIndex);
//        }
//    }
//
// 
//}
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.qameta.allure.Allure;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestExecutor {

    private final List<Map<String, String>> testData; // Cached test data
    private final WebDriver driver; // WebDriver instance
    private final List<String> windowHandles = new ArrayList<>(); // To store window handles

    public TestExecutor(String ss,List<Map<String, String>> testData, WebDriver driver) {
        this.testData = testData;
        this.driver = driver;
    }

    public void executeTests() {
        int numberOfRows = testData.size();
        System.out.println("Total rows found: " + numberOfRows);

        // Open tabs and store window handles
        openTabs(numberOfRows);

        // Use ExecutorService for parallel execution
        ExecutorService executorService = Executors.newFixedThreadPool(3); // Allow 3 parallel tests

        // Submit a task for each row of data to be run asynchronously
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            final int index = rowNumber;
            executorService.submit(() -> runTestForRow(index)); // Submit test for each row
        }

        // Shutdown executor service gracefully
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES); // Wait for all tasks to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        logDashboardCount(numberOfRows);
    }

    // Open tabs in the browser and store window handles
    private void openTabs(int numberOfRows) {
        String baseUrl = CustomWebDriverManager.getBaseUrl(); // Get the base URL from the environment

        for (int i = 0; i < numberOfRows; i++) {
            if (i == 0) {
                driver.get(baseUrl); // Open the first URL in the existing tab
                windowHandles.add(driver.getWindowHandle()); // Add the first tab window handle
            } else {
                ((JavascriptExecutor) driver).executeScript("window.open('" + baseUrl + "', '_blank');"); // Open a new tab

                // Fetch all window handles and identify the new handle
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(windowHandles); // Remove existing handles
                windowHandles.addAll(handles); // Add new handle to the list
            }
        }
    }

    // Run tests for a specific row on a new tab
    private void runTestForRow(int rowNumber) {
        try {
            // Fetch test data for the current row
            Map<String, String> data = testData.get(rowNumber);

            // Switch to the tab corresponding to the row number using the stored window handles
            driver.switchTo().window(windowHandles.get(rowNumber));

            // Example: Interact with elements using data from the row
            driver.findElement(By.xpath("//input[@formcontrolname='userName']")).sendKeys(rowNumber + " 00021");
            driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(rowNumber + " 0002");

            // Log the results to Extent and Allure reports
            logTestResult(rowNumber, data);

        } catch (Exception e) {
            System.out.println("Test for row " + rowNumber + " failed: " + e.getMessage());
        }
    }

    // Log the results for each row to reports
    private void logTestResult(int rowNumber, Map<String, String> data) {
        String message = "Test for row " + rowNumber + " executed with data: " + data;
        ExtentCucumberAdapter.addTestStepLog(message);
        Allure.parameter("Test Row " + rowNumber, data);
        System.out.println(message);
    }

    private void logDashboardCount(int totalCount) {
        String message = "Total Dashboard Count: " + totalCount;
        ExtentCucumberAdapter.addTestStepLog(message);
        Allure.parameter("Total Test Case Count", totalCount);
        System.out.println(message);
    }
}
