package org.Locators;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SUBISOLocators {
	
	WebDriver driver;

	WebDriverWait wait;
	
	int waitTime;


	@FindBy(xpath = "//input[@formcontrolname='distributors']")
	public WebElement ISOName;
	
	
//SUBISO
	
// sales info invalid format
    
    @FindBy(xpath = "//input[@formcontrolname='aggregator']/ancestor::mat-form-field//mat-error[contains(text(), ' Invalid Aggregator Name ')]")
    public WebElement SubISOAggregatorNameInvalidForamt;
    
    @FindBy(xpath = "//input[@formcontrolname='distributors']/ancestor::mat-form-field//mat-error[contains(text(), ' Invalid ISO Name ')]")
    public WebElement SubISONameInvalidForamt;
 
 
	
	public SUBISOLocators(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}