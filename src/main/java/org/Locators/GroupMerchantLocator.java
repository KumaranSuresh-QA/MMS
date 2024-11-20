package org.Locators;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupMerchantLocator {

	WebDriver driver;

	int waitTime;

	WebDriverWait wait;

	@FindBy(xpath = "//input[@formcontrolname='aggAppNumber']")
	public WebElement UniqueReferenceNumber;

	@FindBy(xpath = "//input[@formcontrolname='subDistributors']")
	public WebElement SUBISO;

	@FindBy(xpath = "//input[@formcontrolname='businessNature']")
	public WebElement natureofbusiness;

	@FindBy(xpath = "//input[@formcontrolname='mcc']")
	public WebElement mcc;

	@FindBy(xpath = "(//span[contains(text(), 'Verify Document')])[1]")
	public WebElement VerifyDocument1;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='payment']")
    public WebElement paymentmode;
	
	@FindBy(xpath = "//input[@formcontrolname='salesPerson']")
    public WebElement salesperson;

//IntroPage

	@FindBy(xpath = "//h6[contains(text(), 'Group Merchant Discounts')]")
	public WebElement IntrodiscountRate;

	@FindBy(xpath = "//h6[contains(text(), 'Merchant Onboarding Configuration')]")
	public WebElement IntroWhitelabel;

//GM  sales info field Required

	@FindBy(xpath = "//input[@formcontrolname='aggAppNumber']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement uniqueRefNumFieldRequired;

	@FindBy(xpath = "//input[@formcontrolname='aggregator']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement AggregatorFieldRequired;

// sales info invalid format

	@FindBy(xpath = "//input[@formcontrolname='aggAppNumber']/ancestor::mat-form-field//mat-error[contains(text(), ' Invalid format ')]")
	public WebElement uniqueRefNumInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='aggregator']/ancestor::mat-form-field//mat-error[contains(text(), ' Invalid Aggregator ')]")
	public WebElement AggregatorInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='distributors']/ancestor::mat-form-field//mat-error[contains(text(), ' Invalid Distributor ')]")
	public WebElement ISOInvalidDistributors;

// Company Info

	@FindBy(xpath = "//input[@formcontrolname='businessNature']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement NatureofBusinessFieldRequired;

	@FindBy(xpath = "//input[@formcontrolname='mcc']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement MccFieldRequired;

	@FindBy(xpath = "//input[@formcontrolname='pincode']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoPincodeFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='pincode']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Pincode')]")
	public WebElement PersonalInfoPincodeInvalidformat;

	public GroupMerchantLocator(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}