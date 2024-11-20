package org.Locators;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TerminalLocators {

	WebDriver driver;
	int waitTime;

	@FindBy(xpath = "//input[@formcontrolname='merchant']")
	 public WebElement Merchant;			
	
	  @FindBy(xpath = "//input[@formcontrolname='terminalName']")
	  public WebElement TerminalName;
		

	 @FindBy(xpath = "//mat-select[@formcontrolname='terminalType']")
	 public WebElement Terminaltype;
	 	
	 
	 @FindBy(xpath = "//input[@formcontrolname='deviceModel']")
	 public WebElement DeviceModel;
		
	 @FindBy(xpath = "//input[@formcontrolname='deviceNumber']")
	 public WebElement DeviceNumber;
	 
	 @FindBy(xpath = "//input[@formcontrolname='activeDeviceNumber']")
	 public WebElement ActiveDeviceNumber;
	 
	 @FindBy(xpath = "//input[@formcontrolname='imeiNumber']")
	 public WebElement IMEINumber;
	 
	 @FindBy(xpath = "//mat-select[@formcontrolname='deviceComercialMode']")
	 public WebElement DeviceCommericialmode;
	 
	 @FindBy(xpath ="//mat-select[@formcontrolname='tidFeeApplicable']")
	 public WebElement TIDFeeApplicable;
	 
	 @FindBy(xpath = "//input[@formcontrolname='devicePrice']")
	 public WebElement Deviceprice;
	 
	 @FindBy(xpath = "//input[@formcontrolname='installationFee']")
	 public WebElement InstallationFee;
	 
	 @FindBy(xpath = "//h6[contains(text(),'Transaction Sets')]")
     public WebElement DisplayTransctionSet;
     
     @FindBy(xpath = "//span[contains(text(), 'Transaction Set')]")
     public WebElement TransctionSet;

	public TerminalLocators(WebDriver driver) {
		this.waitTime = CustomWebDriverManager.getWaitTime();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
}
