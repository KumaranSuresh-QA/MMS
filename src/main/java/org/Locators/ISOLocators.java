package org.Locators;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ISOLocators {

	WebDriver driver;
	
    int waitTime;

	WebDriverWait wait;

	@FindBy(xpath = "//input[@formcontrolname='aggregator']")
	public WebElement AggregatorName;
	
	@FindBy(xpath = "//h6[contains(text(), 'ISO Onboarding Configuration') or contains(text(), 'Sub Iso Onboarding Configuration')]")
	public WebElement IntroWhitelabelISO;
	
	
	@FindBy(xpath = "//h6[contains(text(), 'Iso Discounts') or contains(text(), 'Sub ISO Discounts')]")
    public WebElement IntroDiscountRate;

// ISO Sales info invalid format 
    
    @FindBy(xpath ="//input[@formcontrolname='aggregator']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid aggregator') or contains(text(), 'Invalid Aggregator')]")
    public WebElement ISOAggregatorNameInvalidFormat;
 
 // ISO Personal info
 
    @FindBy(xpath="//input[@formcontrolname='pincode']/ancestor::mat-form-field//mat-error[contains(text(), ' Invalid Pincode' )]")
    public WebElement ISO_SUBISOPincodeInvalidFormat;
   
    
   
	
	
	public ISOLocators(WebDriver driver) {	

		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}