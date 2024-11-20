package org.Locators;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SystemUserLocatores {

WebDriver driver;
public WebDriverWait wait;
public int waitTime;

// @FindBy(xpath = "//button[@class='logo ng-tns-c471-4']")
@FindBy(xpath = "//button[contains(@class, 'logo') and not(contains(@class, 'logo-alone'))]")
public WebElement ClickOnDownArrow;

@FindBy(xpath = "(//span[contains(text(), 'Onboarding')])[2]")
public WebElement ClickOnOnboarding;

// @FindBy(xpath = "//span[text()='Banks']")
@FindBy(xpath = "//a[@href='/admin/onboard/banks']")
public WebElement ClickOnBank;

// @FindBy(xpath = "//span[text()='PayFac']")
@FindBy(xpath = "//span[contains(text(), 'Aggregators')]")
public WebElement ClickOnPayfac;

@FindBy(xpath = "//mat-select[@formcontrolname='bankId']")
public WebElement ClickOnBankName;

@FindBy(xpath = "//input[@formcontrolname='payfacName']")
public WebElement EnterOnPayfacName;

@FindBy(xpath = "//a[@href='/admin/onboard/isos']")
public WebElement ClickOnISO;

@FindBy(xpath = "//a[@href='/admin/onboard/sub-isos']")
public WebElement ClickOnSUBISO;

@FindBy(xpath = "//a[@href='/admin/onboard/group-merchants']")
public WebElement ClickOnGM;

@FindBy(xpath = "//a[@href='/admin/onboard/merchants']")
public WebElement ClickOnMerchant;

@FindBy(xpath = "//a[@href='/admin/onboard/terminals']")
public WebElement ClickOnTerminal;
//UserLocators

@FindBy(xpath = "//span[contains(text(), 'CREATE')]")
public WebElement Createbutton;

@FindBy(xpath = "(//button[@aria-label='Example icon-button with a menu'])[4]")
public WebElement Actionbutton;

@FindBy(xpath = "(//button[@aria-label='Example icon-button with a menu'])[4]")
public WebElement Actionviewbutton;

@FindBy(xpath = "//span[contains(text(), 'Edit')]")
public WebElement Editbutton;

@FindBy(xpath = "//span[contains(text(), 'View')]")
public WebElement Viewbutton;

@FindBy(xpath = "//span[contains(text(), 'Close')]")
public WebElement Closebutton;

@FindBy(xpath = "//span[contains(text(), 'MORE FILTERS')]")
public WebElement MoreFilter;

@FindBy(xpath = "//span[contains(text(), 'Status')]")
public WebElement ClickonStatus;

@FindBy(xpath = "//span[contains(text(), 'Filter by Status')]")
public WebElement ClickonFilterByStatus;

@FindBy(xpath = "//span[contains(text(), 'Apply')]")
public WebElement ClickOnApply;

@FindBy(xpath = "//span[contains(text(), 'New')]")
public WebElement StatusNew;

@FindBy(xpath = "//span[contains(text(), 'Pending')]")
public WebElement StatusInprogress;

@FindBy(xpath = "//span[contains(text(), 'Verified')]")
public WebElement StatusVerified;

@FindBy(xpath = "//span[contains(text(), 'Draft')]")
public WebElement StatusDraft;

@FindBy(xpath = "//span[contains(text(), 'ReferBack')]")
public WebElement StatusReferback;

@FindBy(xpath = "//span[contains(text(), 'AutoReferBack')]")
public WebElement StatusAutoReferback;

@FindBy(xpath = "//span[contains(text(), 'Approved')]")
public WebElement StatusApproved;

@FindBy(xpath = "//span[contains(text(), 'Auto Approved')]")
public WebElement StatusAutoApproved;

@FindBy(xpath = "//span[contains(text(), 'Rejected')]")
public WebElement StatusRejected;

@FindBy(xpath = "//span[contains(text(), 'Closed')]")
public WebElement StatusClosed;

//ListPage Status

@FindBy(xpath = "(//span[contains(text(), 'New')])[1]")
public WebElement ListStatusNew;

@FindBy(xpath = "(//span[contains(text(), 'Inprogress')])[1]")
public WebElement ListStatusInprogress;

@FindBy(xpath = "(//span[contains(text(), 'Verified')])[1]")
public WebElement ListStatusVerified;

@FindBy(xpath = "(//span[contains(text(), 'Draft')])[1]")
public WebElement ListStatusDraft;

@FindBy(xpath = "(//span[contains(text(), 'ReferBack')])[1]")
public WebElement ListStatusReferback;

@FindBy(xpath = "(//span[contains(text(), 'Approved')])[1]")
public WebElement ListStatusApproved;

@FindBy(xpath = "(//span[contains(text(), 'Auto Approved')])[1]")
public WebElement ListStatusAutoApproved;

@FindBy(xpath = "(//span[contains(text(), 'Rejected')])[1]")
public WebElement ListStatusRejected;

@FindBy(xpath = "(//span[contains(text(), 'Closed')])[1]")
public WebElement ListStatusClosed;

@FindBy(xpath = "//span[contains(text(), 'CANCEL')]")
public WebElement cancelbutton;

@FindBy(xpath = "//span[contains(text(),' SAVE AS DRAFT')]")
public WebElement Saveasdraft;

@FindBy(xpath = "//span[contains(text(), 'SUBMIT FOR VERIFICATION')]")
public WebElement Submitforverification;

@FindBy(xpath = "(//span[contains(text(),'Refer Back')])[1]")
public WebElement Referback;

@FindBy(xpath = "//span[contains(text(),'Reject')]")
public WebElement Reject;

@FindBy(xpath = "//span[contains(text(),'SUBMIT FOR APPROVAL')]")
public WebElement SubmitforApproval;

@FindBy(xpath = "//span[contains(text(), 'APPROVE')]")
public WebElement Approve;

public SystemUserLocatores(WebDriver driver) {
// initialize elements
this.waitTime = CustomWebDriverManager.getWaitTime();
this.driver = driver;

PageFactory.initElements(driver, this);
}

}
