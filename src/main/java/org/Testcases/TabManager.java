package org.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class TabManager {
    private WebDriver driver; // Main driver for the initial window

    public TabManager(WebDriver driver) {
        this.driver = driver;
    }

    // Method to initialize a new WebDriver instance
    private WebDriver initializeDriver() {
        // Example for ChromeDriver; modify as needed for your setup
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        return new ChromeDriver();
    }

    // Method to get a WebDriver instance for a specific tab
    public WebDriver getDriverForTab(int tabIndex) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        if (tabIndex < 0 || tabIndex >= windowHandles.size()) {
            throw new IndexOutOfBoundsException("Tab index is out of range: " + tabIndex);
        }

        // Switch to the specified tab
        driver.switchTo().window(windowHandles.get(tabIndex));
        
        // Create a new driver instance for this tab
        WebDriver tabDriver = initializeDriver();
        tabDriver.get(driver.getCurrentUrl()); // Navigate to the same URL as the original driver

        return tabDriver; // Return the new driver instance for this tab
    }

    // Method to close a tab driver
    public void closeTab(WebDriver tabDriver) {
        tabDriver.quit(); // Close the tab driver
    }
}
