package org.Locators;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Duration;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassLocator {

	WebDriver driver;

	int waitTime;
	double AssertwaitTime;


	WebDriverWait wait;

	public BaseClassLocator(WebDriver driver) {

		
		this.waitTime = CustomWebDriverManager.getWaitTime(); // Get wait time from CustomWebDriverManager
		this.AssertwaitTime =CustomWebDriverManager.getAssertWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectDropdownOption(String optionText) {
		// Construct the XPath for the option text in a case-insensitive manner
		String xpathExpression = "//mat-option//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
				+ optionText.toLowerCase() + "')]";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {
			// Wait for the overlay to disappear (if it exists)
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

			// Wait for the dropdown option to be visible and clickable
			WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

			// Scroll the element into view (if needed) and click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
			optionElement.click();
		} catch (TimeoutException e) {
			System.out.println(
					"The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");

			// Try clicking via JavaScript as a fallback
			WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
		}
	}

	public void clickElement(WebElement element) {
	    int maxAttempts = 3; // Maximum number of attempts to click
	    int attempt = 0; // Current attempt count

	    while (attempt < maxAttempts) {
	        try {
	            // Wait for the element to be visible and clickable
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	            wait.until(ExpectedConditions.visibilityOf(element));
	            wait.until(ExpectedConditions.elementToBeClickable(element));

	            // Scroll to the element to ensure it's in view
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	            // Attempt to click the element
	            	element.click();

	            System.out.println("Element clicked successfully.");
	            break; // Exit loop if click is successful

	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Element click intercepted. Trying to click via JavaScript.");
	            try {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	                System.out.println("Element clicked via JavaScript.");
	                break; // Exit loop if JavaScript click is successful
	            } catch (Exception jsException) {
	                System.out.println("JavaScript click also failed.");
	                jsException.printStackTrace();
	            }

	        } catch (StaleElementReferenceException e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                System.out.println("Element clicked via JavaScript.");
                break; // Exit loop if JavaScript click is successful

	        } catch (TimeoutException e) {
	            System.out.println("The element '" + element + "' is not clickable within the timeout.");
	            e.printStackTrace();
	            break; // Exit loop

	        } catch (Exception e) {
	            System.out.println("An unexpected error occurred while trying to click the element.");
	            e.printStackTrace();
	            break; // Exit loop
	        }

	        attempt++; // Increment the attempt counter
	    }
	}

	public void ActionclickElement(WebElement element) {
		int attempts = 0;

		while (attempts < 3) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
				break;

			} catch (StaleElementReferenceException e) {
				attempts++;

			} catch (ElementClickInterceptedException e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
				break;

			} catch (Exception e) {
				System.err.println("An unexpected error occurred: " + e.getMessage());
				break;
			}
		}
	}

	public void actionDoubleClickElement(WebElement element) {
		int attempts = 0;

		while (attempts < 3) {
			try {
				// Wait until the element is clickable
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
				wait.until(ExpectedConditions.elementToBeClickable(element));

				// Perform double-click using Actions class
				Actions actions = new Actions(driver);
				actions.doubleClick(element).perform();
				break;

			} catch (StaleElementReferenceException e) {
				// Retry if a stale element reference occurs
				attempts++;

			} catch (ElementClickInterceptedException e) {
				// Retry with JavaScript if element click is intercepted
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
				break;

			} catch (Exception e) {
				// Log unexpected errors
				System.err.println("An unexpected error occurred: " + e.getMessage());
				break;
			}
		}
	}

	public void enterElement(WebElement element, String text) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(text);

		} catch (ElementClickInterceptedException e) {

			element.sendKeys(text);

		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}

	
	
	public void enterSplitElement(WebElement element, String text) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Loop through each character in the text and send it one by one with a 1-second delay
            for (char ch : text.toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                // Wait for 1 second between each letter
                Thread.sleep(1000);  // 1000 milliseconds = 1 second
            }

        } catch (ElementClickInterceptedException e) {
            // Retry entering text one character at a time if an intercept occurs
            for (char ch : text.toCharArray()) {
                element.sendKeys(String.valueOf(ch));
                // Wait for 1 second between each letter
                Thread.sleep(1000);  // 1000 milliseconds = 1 second
            }

        } catch (TimeoutException e) {
            System.out.println("The input field with formControlName '" + element + "' is not found within the timeout.");
        } catch (InterruptedException e) {
            // Handle InterruptedException
            System.out.println("The thread was interrupted during sleep.");
        }
    }

//	public void enterSplitElement(WebElement element, String text) throws InterruptedException {
//	    try {
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
//	        wait.until(ExpectedConditions.elementToBeClickable(element));
//
//	        // Split the text by space to get each word
//	        String[] words = text.split(" ");
//
//	        // Loop through each word with an index to check if it’s the last word
//	        for (int i = 0; i < words.length; i++) {
//	            String word = words[i];
//
//	            // Enter each character of the word
//	            for (char ch : word.toCharArray()) {
//	                element.sendKeys(String.valueOf(ch));
//	            }
//
//	            // Add a space after each word except the last one
//	            if (i < words.length - 1) {
//	                Thread.sleep(1000);
//	                element.sendKeys(" ");
//	            }
//	        }
//
//	    } catch (ElementClickInterceptedException e) {
//	        // Fallback logic in case of an ElementClickInterceptedException
//	        String[] words = text.split(" ");
//	        
//	        for (int i = 0; i < words.length; i++) {
//	            String word = words[i];
//	            
//	            for (char ch : word.toCharArray()) {
//	                element.sendKeys(String.valueOf(ch));
//	            }
//
//	            if (i < words.length - 1) {
//	                Thread.sleep(1000);
//	                element.sendKeys(" ");
//	            }
//	        }
//
//	    } catch (TimeoutException e) {
//	        System.out.println("The input field with formControlName '" + element + "' is not found within the timeout.");
//	    }
//	}
//

	public void UploadImage(WebElement element, String text) {

		try {

			element.sendKeys(text);

		} catch (ElementClickInterceptedException e) {

			element.sendKeys(text);

		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}

	public boolean isElementDisplayed(WebElement element, String elementName) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis((long) (AssertwaitTime * 1000)));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {

			wait.until(ExpectedConditions.visibilityOf(element));

			assertTrue(elementName + " is displayed.", element.isDisplayed());

			return true;

		} catch (NoSuchElementException e) {
			System.out.println(elementName + " is not displayed.");
			return false;

		} catch (TimeoutException e) {
			System.out.println(elementName + " is not displayed due to timeout.");
			return false;
		}
	}
	
	
	public boolean SaveisElementDisplayed(WebElement element, String elementName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis((long) (AssertwaitTime * 500)));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

		try {

			wait.until(ExpectedConditions.visibilityOf(element));

			assertTrue(elementName + " is displayed.", element.isDisplayed());

			return true;

		} catch (NoSuchElementException e) {
			System.out.println(elementName + " is not displayed.");
			return false;

		} catch (TimeoutException e) {
			System.out.println(elementName + " is not displayed due to timeout.");
			return false;
		}
	}
	


	public boolean isElementNotDisplayed(WebElement element, String elementName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis((long) (AssertwaitTime * 1000)));
        boolean isDisplayed;

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            isDisplayed = element.isDisplayed();
            assertFalse(isDisplayed, elementName + " is displayed, but it should not be.");
            return false;
        } catch (NoSuchElementException | TimeoutException e) {
            // If element is not found or not visible within the timeout, it's considered not displayed
            return true;
        }
    }


	public void CLearElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		try {

			wait.until(ExpectedConditions.visibilityOf(element));

			element.clear();

		} catch (ElementClickInterceptedException e) {

			element.clear();

		} catch (TimeoutException e) {
			System.out
					.println("The input field with formControlName '" + element + "' is not found within the timeout.");
		}
	}

	public String getElementValue(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			// Get the current value of the input field using the "value" attribute
			return element.getAttribute("value");
		} catch (NoSuchElementException e) {
			System.out.println("Element is not found: " + element);
			return null;
		} catch (TimeoutException e) {
			System.out.println("The input field is not found within the timeout.");
			return null;
		}
	}

	public String getElementText(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	    try {
	        wait.until(ExpectedConditions.visibilityOf(element));
	        
	        String text = element.getText().trim();

	        // If it's an input field and the text is empty, retrieve the "value" attribute instead
	        if (text.isEmpty() && element.getTagName().equalsIgnoreCase("input")) {
	            text = element.getAttribute("value").trim();
	        }

	        // Remove spaces around commas
	        text = text.replaceAll("\\s*,\\s*", ",");

	        // Convert text to lowercase
	        return text.toLowerCase(); // or text.toUpperCase() for uppercase
	    } catch (NoSuchElementException e) {
	        System.out.println("Element is not found: " + element);
	        return null;
	    } catch (TimeoutException e) {
	        System.out.println("The input field is not found within the timeout.");
	        return null;
	    }
	}
	
	
	public void TerminaltypeselectDropdownOption(String optionText) {
        // Construct the XPath for the option text in a case-insensitive manner
        String xpathExpression = "//mat-option//span[normalize-space(text())='" + optionText + "']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

        try {
            // Wait for the overlay to disappear (if it exists)
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

            // Wait for the dropdown option to be visible and clickable
            WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

            // Scroll the element into view (if needed) and click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
            optionElement.click();
        } catch (TimeoutException e) {
            System.out.println(
                    "The dropdown option '" + optionText + "' is not found or not clickable within the timeout.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted for '" + optionText + "'. Trying to click via JavaScript.");

            // Try clicking via JavaScript as a fallback
            WebElement optionElement = driver.findElement(By.xpath(xpathExpression));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
        }
    }
}