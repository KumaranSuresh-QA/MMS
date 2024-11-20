package org.Testcases;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Allure;

//CorerctOne(10/07)

//public class CustomWebDriverManager {
//    private static WebDriver driver;
//    private static int waitTime; 
//
//    // Method to get the base URL depending on the environment
//    public static String getBaseUrl() {
//        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//        String environment = dotenv.get("ENVIRONMENT", "UAT");
//
//        if (environment.equalsIgnoreCase("PRODUCTION")) {
//            return dotenv.get("PRODUCTIONBASEURL");
//        } else {
//            return dotenv.get("UATBASEURL");
//        }
//    }
//
//    // Method to get the WebDriver instance based on the browser type from the .env file
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            initializeWaitTime(); // Ensure wait time is set before initializing WebDriver
//            Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//            String browser = dotenv.get("BROWSER", "chrome").toLowerCase(); // Get browser from .env
//            String environment = dotenv.get("ENVIRONMENT", "UAT");
//
//            boolean isHeadless = environment.equalsIgnoreCase("PRODUCTION");
//
//            switch (browser) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    if (isHeadless) {
//                        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//                        System.out.println("Running Chrome in headless mode for Production.");
//                    } else {
//                        System.out.println("Running Chrome in normal mode for UAT.");
//                    }
//                    driver = new ChromeDriver(chromeOptions);
//                    break;
//
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    FirefoxOptions firefoxOptions = new FirefoxOptions();
//                    if (isHeadless) {
//                        firefoxOptions.addArguments("--headless");
//                        System.out.println("Running Firefox in headless mode for Production.");
//                    } else {
//                        System.out.println("Running Firefox in normal mode for UAT.");
//                    }
//                    driver = new FirefoxDriver(firefoxOptions);
//                    break;
//
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    EdgeOptions edgeOptions = new EdgeOptions();
//                    if (isHeadless) {
//                        edgeOptions.addArguments("--headless");
//                        System.out.println("Running Edge in headless mode for Production.");
//                    } else {
//                        System.out.println("Running Edge in normal mode for UAT.");
//                    }
//                    driver = new EdgeDriver(edgeOptions);
//                    break;
//
//                default:
//                    throw new IllegalArgumentException("Unsupported browser: " + browser);
//            }
//
//            driver.get(getBaseUrl());
//
//            if (!isHeadless) {
//                driver.manage().window().maximize();
//            }
//        }
//        return driver;
//    }
//    
//    private static void initializeWaitTime() {
//        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//        waitTime = Integer.parseInt(dotenv.get("WAITTIME", "30")); // Default to 30 seconds if not set
//        System.out.println("Wait time set to: " + waitTime + " seconds");
//    }
//
//    public static int getWaitTime() {
//        return waitTime; // Getter for wait time
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}

public class CustomWebDriverManager {
    private static WebDriver driver;
    private static int waitTime;
    private static double assertWaitTime;
    private static Dotenv dotenv;
    // Method to get the base URL depending on the environment
    public static String getBaseUrl() {
          dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
        String environment = dotenv.get("ENVIRONMENT", "UAT");

        if (environment.equalsIgnoreCase("PRODUCTION")) {
            return dotenv.get("PRODUCTIONBASEURL");
        } else {
            return dotenv.get("UATBASEURL");
        }
    }

//     Method to get the WebDriver instance based on the browser type from the .env file
    public static WebDriver getDriver() {
        if (driver == null) {
            initializeWaitTime();
            initializeAssertWaitTime();

            // Ensure wait time is set before initializing WebDriver
            Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
            String browser = dotenv.get("BROWSER", "chrome").toLowerCase(); // Get browser from .env
            String environment = dotenv.get("ENVIRONMENT", "UAT");

            boolean isHeadless = environment.equalsIgnoreCase("PRODUCTION");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless) {
                        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                        System.out.println("Running Chrome in headless mode for Production.");
                    } else {
                        System.out.println("Running Chrome in normal mode for UAT.");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        firefoxOptions.addArguments("--headless");
                        System.out.println("Running Firefox in headless mode for Production.");
                    } else {
                        System.out.println("Running Firefox in normal mode for UAT.");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (isHeadless) {
                        edgeOptions.addArguments("--headless");
                        System.out.println("Running Edge in headless mode for Production.");
                    } else {
                        System.out.println("Running Edge in normal mode for UAT.");
                    }
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.get(getBaseUrl());

            if (!isHeadless) {
                driver.manage().window().maximize();
            }

            clearCache(); // Call to clear cache after driver initialization
        }
        return driver;
    }
    
//    public static WebDriver getDriver() {
//	    if (driver == null) {
//	        initializeWaitTime();
//	       
//	        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
//	        String browser = dotenv.get("BROWSER", "chrome").toLowerCase();
//	        String environment = dotenv.get("ENVIRONMENT", "UAT");
//	        boolean isHeadless = environment.equalsIgnoreCase("PRODUCTION");
//
//	        switch (browser) {
//	            case "chrome":
//	                WebDriverManager.chromedriver().setup();
//	                ChromeOptions chromeOptions = new ChromeOptions();
////	                chromeOptions.setBinary("/usr/bin/google-chrome");
//
//	                Map<String, Object> prefs = new HashMap<>();
//	                prefs.put("profile.default_content_setting_values.geolocation", 2); // Block location
//	                chromeOptions.setExperimentalOption("prefs", prefs);
//	                chromeOptions.addArguments("--disable-user-media-security=true");
//	                
//	                chromeOptions.addArguments("--disable-popup-blocking");
//	                chromeOptions.addArguments("--disable-geolocation");
//				    chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
//				    chromeOptions.addArguments("--no-default-browser-check");
//				    chromeOptions.addArguments("user-data-dir=/tmp/chrome"); // Use a temporary profile directory
//				    chromeOptions.addArguments("--use-fake-ui-for-media-stream");
//				    chromeOptions.addArguments("--use-fake-device-for-media-stream");
//				    
//				    chromeOptions.addArguments("--disable-location-requests");
//
//	                if (isHeadless) {
//	                    chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//	                    System.out.println("Running Chrome in headless mode for Production.");
//	                }
//	                
//	                driver = new ChromeDriver(chromeOptions);
//
//	                // Override geolocation using JavaScript
//	                JavascriptExecutor js = (JavascriptExecutor) driver;
//	                js.executeScript("navigator.geolocation.getCurrentPosition = function(success) {" +
//	                                 "success({coords: {latitude: 0, longitude: 0}}); }");
//	                break;
//
//	            case "firefox":
//	                WebDriverManager.firefoxdriver().setup();
//	                FirefoxOptions firefoxOptions = new FirefoxOptions();
//	                if (isHeadless) {
//	                    firefoxOptions.addArguments("--headless");
//	                    System.out.println("Running Firefox in headless mode for Production.");
//	                }
//	                driver = new FirefoxDriver(firefoxOptions);
//	                break;
//
//	            case "edge":
//	                WebDriverManager.edgedriver().setup();
//	                EdgeOptions edgeOptions = new EdgeOptions();
//	                if (isHeadless) {
//	                    edgeOptions.addArguments("--headless");
//	                    System.out.println("Running Edge in headless mode for Production.");
//	                }
//	                driver = new EdgeDriver(edgeOptions);
//	                break;
//
//	            default:
//	                throw new IllegalArgumentException("Unsupported browser: " + browser);
//	        }
//
//	        driver.get(getBaseUrl());
//
//	        if (!isHeadless) {
//	            driver.manage().window().maximize();
//	        }
//
//	        clearCache();
//	    }
//	    return driver;
//	}
    
    
    private static void initializeWaitTime() {
        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
        waitTime = Integer.parseInt(dotenv.get("WAITTIME", "30")); // Default to 30 seconds if not set
        System.out.println("Wait time set to: " + waitTime + " seconds");
    }

    public static int getWaitTime() {
        return waitTime; // Getter for wait time
    }

    private static void initializeAssertWaitTime() {
        Dotenv dotenv = Dotenv.configure().directory("src/test/resources").filename("run.env").load();
        assertWaitTime = Double.parseDouble(dotenv.get("ASSERTATIONWAITTIME", "0.5")); // Default to 5 seconds if not set
        System.out.println("Assert wait time set to: " + assertWaitTime + " seconds");
    }

    public static double getAssertWaitTime() {
        return assertWaitTime; // Getter for assert wait time
    }

    public static void main(String[] args) {
        initializeWaitTime();
        initializeAssertWaitTime();
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
 
    
    
    
 
    // Method to clear browser cache
    private static void clearCache() {
        if (driver != null) {
            // Clear cookies
            driver.manage().deleteAllCookies();
            System.out.println("Cache cleared: All cookies deleted.");

            // Verify cache cleared
            verifyCacheCleared();
        }
    }

    private static void verifyCacheCleared() {
        // Check for remaining cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        if (cookies.isEmpty()) {
            System.out.println("Cookies cleared successfully.");
        } else {
            System.out.println("There are still cookies present: " + cookies.size());
        }

        // Check Local Storage
        try {
            ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
            System.out.println("Local storage cleared successfully.");
        } catch (Exception e) {
            System.out.println("Error clearing local storage: " + e.getMessage());
        }

        // Check Session Storage
        try {
            ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
            System.out.println("Session storage cleared successfully.");
        } catch (Exception e) {
            System.out.println("Error clearing session storage: " + e.getMessage());
        }
    }
    public static String getExcelFilePath() {
        return dotenv.get("EXCELFILEPATH");
    }
    public static String getScreenshotDir() {
        return dotenv.get("SCREENSHOT_DIR");
    }
    
    public static void takeScreenshotStr(String rowNumber) throws InterruptedException {
        try {
        	
        	
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = getScreenshotDir() + rowNumber + ".png";
            
            FileUtils.copyFile(screenshot, new File(screenshotPath));

            Allure.addAttachment("Screenshot for Row " + rowNumber,
                    new ByteArrayInputStream(FileUtils.readFileToByteArray(screenshot)));

            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath, "Screenshot for Row " + rowNumber);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void Report() {
    	
    	 ExtentReports extentReports = ReportManager.getExtentReports();
    	 extentReports.createTest("Sample Test").info("This is a test log");

    	    // Flush the reports
    	    ReportManager.flushReports();
    }
}