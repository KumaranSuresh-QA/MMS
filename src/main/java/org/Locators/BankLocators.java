package org.Locators;

import org.Testcases.CustomWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLocators {

	WebDriver driver;
	int waitTime;

// Bank Locators

	@FindBy(xpath = "//mat-error[contains(text(),'Daily Limit Required')]")
	public WebElement DailyLimitrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Weekly Limit Required')]")
	public WebElement WeeklyLimitrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Monthly Limit Required')]")
	public WebElement MOnthlyLimitrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Minimum Amount Required')]")
	public WebElement MinimumAmountrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Maximum Amount Required')]")
	public WebElement MAximumAmountrequired;

	@FindBy(xpath = "//mat-error[contains(text(),'Invalid format') or contains(text(),'Invalid Format')]")
	public WebElement InvalidFormat;

	@FindBy(xpath = "//mat-error[contains(text(), 'Mobile Number should be 30 digits')]")
	public WebElement lessthanMobilenumber;

	@FindBy(xpath = "//mat-error[contains(text(), 'Must be greater than Daily Limit')]")
	public WebElement greaterthanDailyLimit;

	@FindBy(xpath = "//mat-error[contains(text(), 'Must be greater than Weekly Limit')]")
	public WebElement greaterthanweeklyLimit;

	@FindBy(xpath = "//mat-error[contains(text(), 'Daily Limit Must be Less than Weekly Limit')]")
	public WebElement Dailylimitmustbelessthanweeklylimit;

	@FindBy(xpath = "//mat-error[contains(text(), 'Weekly Limit Must be Less than Monthly Limit')]")
	public WebElement WeeklylimitmustbelessthanMonthlylimit;

	@FindBy(xpath = "//mat-error[contains(text(), 'Daily limit & minimum value not be same')]")
	public WebElement Dailylimitmininumvaluenotthesame;

	@FindBy(xpath = "//mat-error[contains(text(), 'Minimum & Maximum Value not be same')]")
	public WebElement minimumandmaximumvaluenotbesame;

	@FindBy(xpath = "//mat-error[contains(text(), 'mmsonboarding.settlement.minLength')]")
	public WebElement minimumbankaccountLengtherrormessage;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[6]")
	public WebElement Saveasdraft;

	@FindBy(xpath = "//span[contains(text(), 'Next Step')]")
	public WebElement NextStep;

	@FindBy(xpath = "//h6[contains(text(), 'Admin User Details')]")
	public WebElement AdminUserDetails;

	@FindBy(xpath = "//button[@class='logo ng-tns-c471-3']")
	public WebElement ClickOnDownArrow;

	@FindBy(xpath = "//button[@class='logo ng-tns-c479-3']")
	public WebElement ClickOnDownArrowSuperadmin;

	@FindBy(xpath = "//span[contains(text(), 'Onboarding')]")
	public WebElement ClickOnOnboarding;

	@FindBy(xpath = "//a[@href='/admin/onboard/banks']")
	public WebElement ClickOnBank;

	@FindBy(xpath = "//a[@href='/admin/onboard/aggregators']")
	public WebElement ClickOnPayfac;

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

	@FindBy(xpath = "//span[contains(text(),'CREATE')]")
	public WebElement Createbutton;

// IntroPage

	@FindBy(xpath = "//h6[contains(text(), 'Channel Configuration')]")
	public WebElement IntroChannelConfiguration;

	@FindBy(xpath = "//h6[contains(text(), 'Global FRM Parameters')]")
	public WebElement IntroGlobalFRMParameters;

	@FindBy(xpath = "//h6[contains(text(), 'ROUTING ONUS')]")
	public WebElement IntroONUS;

	@FindBy(xpath = "//h6[contains(text(), 'Interchange Plan')]")
	public WebElement IntroInterchangePlan;

	@FindBy(xpath = "//h6[contains(text(), 'Bank Details')]")
	public WebElement IntroBankDetails;

	@FindBy(xpath = "//h6[contains(text(), 'Bank Onboarding Configuration')]")
	public WebElement IntroBankonboardingConfig;

	@FindBy(xpath = "//h6[contains(text(), 'Payment Bridge')]")
	public WebElement IntroPaymentBridge;

	@FindBy(xpath = "//h6[contains(text(), 'KYC Config') or contains(text(), 'Personal Documents')]")
	public WebElement IntroKycConfig;

	@FindBy(xpath = "//h6[contains(text(), 'Status History')]")
	public WebElement IntrostatusHistory;

// BankSideMenu

	@FindBy(xpath = "//span[contains(text(), 'General Info')]")
	public WebElement GeneralInfo;

	@FindBy(xpath = "//span[contains(text(), 'Communication Info')]")
	public WebElement CommunicationInfo;

	@FindBy(xpath = "//span[contains(text(), 'Channel Config')]")
	public WebElement ChannelConfig;

	@FindBy(xpath = "//span[contains(text(), 'ONUS Routing')]")
	public WebElement ONUSRouting;

	@FindBy(xpath = "//span[contains(text(), 'Global FRM')]")
	public WebElement GlobalFrm;

	@FindBy(xpath = "//span[contains(text(), 'Commercial')]")
	public WebElement Commercial;

	@FindBy(xpath = "//span[contains(text(), 'Settlement Info')]")
	public WebElement SettlementInfo;

	@FindBy(xpath = "//span[contains(text(), 'Whitelabel')]")
	public WebElement whitelabel;

	@FindBy(xpath = "//span[contains(text(), 'Webhooks')]")
	public WebElement webhooks;

	@FindBy(xpath = "//span[contains(text(), 'KYC')]")
	public WebElement Kyc;

	@FindBy(xpath = "//span[contains(text(), 'Status History')]")
	public WebElement StatusHistory;

	@FindBy(xpath = "//span[contains(text(), 'Change Log')]")
	public WebElement Changelog;

// Bank

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank Name')]")
	public WebElement BankLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Address')]")
	public WebElement AddressLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Pincode')]")
	public WebElement PincodeLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'GST')]")
	public WebElement GSTLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'PAN')]")
	public WebElement PANLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Mars Id')]")
	public WebElement MaridLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Statement Frequency')]")
	public WebElement StatementFrequencyLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Statement Type')]")
	public WebElement StatementTypeLabelName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Domain')]")
	public WebElement DomainLabelName;

	@FindBy(xpath = "//input[@formcontrolname='bankName']")
	public WebElement BankName;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	public WebElement Address;

	@FindBy(xpath = "//input[@formcontrolname='zipCode']")
	public WebElement Pincode;

	@FindBy(xpath = "//span[contains(text(), '600341')]")
	public WebElement SelectPincode;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	public WebElement City;

	@FindBy(xpath = "//input[@formcontrolname='state']")
	public WebElement State;

	@FindBy(xpath = "//input[@formcontrolname='country']")
	public WebElement Country;

	@FindBy(xpath = "//input[@formcontrolname='currencyCode']")
	public WebElement CurrencyCode;

	@FindBy(xpath = "//input[@formcontrolname='gst']")
	public WebElement GST;

	@FindBy(xpath = "//input[@formcontrolname='pan']")
	public WebElement PAN;

	@FindBy(xpath = "//input[@formcontrolname='marsId']")
	public WebElement Marsid;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementFrequency']")
	public WebElement StatementFrequency;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementType']")
	public WebElement StatementType;

	@FindBy(xpath = "//input[@oninput='this.value=this.value.toLowerCase()']")
	public WebElement Domain;

	@FindBy(xpath = "//span[contains(text(),'VERIFY')]")
	public WebElement Verify;

// Communication Info

	@FindBy(xpath = "//span[contains(text(), 'Communication Info')]")
	public WebElement ClickonCommunicationInfo;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[1]")
	public WebElement ClickonCommADD;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[2]")
	public WebElement ClickonCommSettlementandReconADD;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	public WebElement ClickonCommuName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Name')]")
	public WebElement LabelCommuName;

	@FindBy(xpath = "//input[@formcontrolname='position']")
	public WebElement ClickonCommuPosition;

	@FindBy(xpath = "//mat-label[contains(text(), 'Position')]")
	public WebElement LabelCommuPosition;

	@FindBy(xpath = "//input[@formcontrolname='phone']")
	public WebElement ClickonCommuPhonenumber;

	@FindBy(xpath = "//mat-label[contains(text(), 'Phone Number')]")
	public WebElement LabelCommuPhonenumber;

	@FindBy(xpath = "//input[@formcontrolname='mobile']")
	public WebElement ClickonCommuMobileNumber;

	@FindBy(xpath = "//mat-label[contains(text(), 'Mobile Number')]")
	public WebElement LabelCommuMobileNumber;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	public WebElement ClickonCommuEmailId;

	@FindBy(xpath = "//mat-label[contains(text(), 'Email Id')]")
	public WebElement LabelCommuEmailId;

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	public WebElement ClickonCommuUserName;

	@FindBy(xpath = "//mat-label[contains(text(), 'User Name')]")
	public WebElement LabelCommuUsername;

	@FindBy(xpath = "//mat-select[@formcontrolname='isAdEnabled']")
	public WebElement ClickOnAdUsers;

// Channel Config

	@FindBy(xpath = "//span[contains(text(), 'Add')]")
	public WebElement ChannelADD;

	@FindBy(xpath = "//mat-label[contains(text(), 'Channel')]")
	public WebElement ChannelLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Network')]")
	public WebElement NetworkLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Transaction Sets')]")
	public WebElement TransactionSetsLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Routing')]")
	public WebElement RoutingLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	public WebElement ClickOnChannel;

	@FindBy(xpath = "//mat-select[@formcontrolname='network']")
	public WebElement ClickOntNetwork;

	@FindBy(xpath = "//mat-select[@formcontrolname='transaction']")
	public WebElement ClickOntransaction;

	@FindBy(xpath = "//mat-select[@formcontrolname='routing']")
	public WebElement ClickOnRouting;

// ONUS Routing

	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElement ActionOnOnusbutton;

	@FindBy(xpath = "//mat-icon[contains(text(), 'edit')]")
	public WebElement AddBin;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	public WebElement ActionOnOnusbutton2;

	@FindBy(xpath = "//input[@formcontrolname='bin']")
	public WebElement ClickOnAddBin;

	@FindBy(xpath = "//span[contains(text(), 'Submit')]")
	public WebElement SubmitOnOnus;

	@FindBy(xpath = "//h6[contains(text(), 'Routing ONUS')]")
	public WebElement LabelONUSROUTING;

// Global FRM

	@FindBy(xpath = "//mat-checkbox[@formcontrolname='frmCheck']")
	public WebElement GlobalFRMCheckbox;

	@FindBy(xpath = "//h6[contains(text(), 'Global FRM Parameters')]")
	public WebElement LabelGlobalFRM;
// Label

	@FindBy(xpath = "//mat-label[contains(text(), 'Velocity Check Minutes')]")
	public WebElement VelocityCheckMinuteLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Velocity Check Count')]")
	public WebElement VelocityCheckCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Cash@POS Count')]")
	public WebElement CashPOSCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Micro ATM Count')]")
	public WebElement MicroATMCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'International Card Acceptance')]")
	public WebElement InternationalCardCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Daily')]")
	public WebElement DailyLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Weekly')]")
	public WebElement WeeklyLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Monthly')]")
	public WebElement MonthlyLabel;

// Click

	@FindBy(xpath = "//input[@formcontrolname='Vcheckminutes']")
	public WebElement VelocityCheckMinute;

	@FindBy(xpath = "//input[@formcontrolname='Vcheckcount']")
	public WebElement VelocityCheckCount;

	@FindBy(xpath = "//input[@formcontrolname='posperdaycount']")
	public WebElement CashPOSCount;

	@FindBy(xpath = "//input[@formcontrolname='Matmcount']")
	public WebElement MicroATMCount;

	@FindBy(xpath = "//mat-select[@formcontrolname='Icardacceptance']")
	public WebElement InternationalCardCount;

	@FindBy(xpath = "//input[@formcontrolname='frmdaily']")
	public WebElement ICADaily;

	@FindBy(xpath = "//input[@formcontrolname='frmweekly']")
	public WebElement ICAWeekly;

	@FindBy(xpath = "//input[@formcontrolname='frmmonthly']")
	public WebElement ICAMonthly;

// POS

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[1]")
	public WebElement POSDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[1]")
	public WebElement POSWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[1]")
	public WebElement POSMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[1]")
	public WebElement POSMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[1]")
	public WebElement POSMaximumAmount;

// UPI

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[2]")
	public WebElement UPIDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[2]")
	public WebElement UPIWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[2]")
	public WebElement UPIMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[2]")
	public WebElement UPIMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[2]")
	public WebElement UPIMaximumAmount;

// AEPS

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[3]")
	public WebElement AEPSDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[3]")
	public WebElement AEPSWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[3]")
	public WebElement AEPSMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[3]")
	public WebElement AEPSMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[3]")
	public WebElement AEPSMaximumAmount;

// MATM

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[4]")
	public WebElement MATMDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[4]")
	public WebElement MATMWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[4]")
	public WebElement MATMMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[4]")
	public WebElement MATMMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[4]")
	public WebElement MATMMaximumAmount;

	// PG

	@FindBy(xpath = "(//input[@formcontrolname='dailyLimit'])[5]")
	public WebElement PGDaily;

	@FindBy(xpath = "(//input[@formcontrolname='weeklyLimit'])[5]")
	public WebElement PGWeekly;

	@FindBy(xpath = "(//input[@formcontrolname='monthlyLimit'])[5]")
	public WebElement PGMonthly;

	@FindBy(xpath = "(//input[@formcontrolname='minimumAmount'])[5]")
	public WebElement PGMinimumAmount;

	@FindBy(xpath = "(//input[@formcontrolname='maximumAmount'])[5]")
	public WebElement PGMaximumAmount;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[1]")
	public WebElement CommercialADD1;

	@FindBy(xpath = "(//span[contains(text(), 'Add')])[2]")

	public WebElement CommercialADD2;

	@FindBy(xpath = "//mat-label[contains(text(), 'Channel')]")
	public WebElement CommercialChannelLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	public WebElement CommercialChannel;

	@FindBy(xpath = "//input[@formcontrolname='interchangePlan']")
	public WebElement PricingplanInterchange;

	@FindBy(xpath = "//input[@formcontrolname='pricingPlanDescription']")
	public WebElement PricingplanBankOnboarding;

	@FindBy(xpath = "//mat-label[contains(text(), 'Pricing Plan')]")
	public WebElement Pricingplanlabel;

	@FindBy(xpath = "//span[contains(text(), 'Save')]")
	public WebElement SaveButton;

	// Settleinfo

	@FindBy(xpath = "//mat-label[contains(text(), 'Channel')]")

	public WebElement SettlementChannelLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	public WebElement SettlementChannel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Account Type')]")

	public WebElement SettlementAccountTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='accountType']")
	public WebElement SettlementAccountType;

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank A/C Number')]")

	public WebElement SettlementBackAccountLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankAccountNumber']")
	public WebElement SettlementBankAccountNumber;

	@FindBy(xpath = "//mat-label[contains(text(), 'IFSC Code')]")

	public WebElement SettlementIFSCCodeLabel;

	@FindBy(xpath = "//input[@formcontrolname='ifsc']")
	public WebElement SettlementIFSCCode;

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank Name')]")

	public WebElement SettlementBankNameLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankName']")
	public WebElement SettlementBankName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Branch')]")

	public WebElement SettlementBranchLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankBranch']")
	public WebElement SettlementBranch;

	@FindBy(xpath = "//mat-label[contains(text(), 'City')]")

	public WebElement SettlementCityLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankCity']")
	public WebElement SettlementCity;

	@FindBy(xpath = "//mat-label[contains(text(), 'Settlement Type')]")

	public WebElement SettlementTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='settlementType']")
	public WebElement SettlementType;

	// WhiteLabel

	// Label

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank Own Deployment')]")
	public WebElement WhiteLabelBankOwnDeployemntLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'PayFac Onboarding')]")
	public WebElement WhitelabelPayfacOnboardingLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'ISO Onboarding')]")
	public WebElement WhitelabelISOOnboardingLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Sales Team Onboarding')]")
	public WebElement WhitelabelSalesTeamOnboardingLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Max Number of Platform Users')]")
	public WebElement WhitelabelMaximumNumberOfPlatformLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='bankOwnDeployement']")
	public WebElement WhitelabelBankOwnDeployment;

	@FindBy(xpath = "//mat-select[@formcontrolname='payfacOnBoarding']")
	public WebElement WhitelabelPayfacOnboarding;

	@FindBy(xpath = "//mat-select[@formcontrolname='isoOnBoarding']")
	public WebElement WhitelabelISOOnboarding;

	@FindBy(xpath = "//mat-select[@formcontrolname='directSaleOnBoarding']")
	public WebElement WhitelabelSalesTeamOnboarding;

	@FindBy(xpath = "//input[@formcontrolname='maxPlatformUser']")
	public WebElement WhitelabelMaxNumberOfPlatform;

	@FindBy(xpath = "//div[contains(@class, 'mat-select-panel') and @role='listbox']//mat-option//span[contains(text(), 'Yes')]")
	public WebElement WhitelabelYES;

	@FindBy(xpath = "//div[contains(@class, 'mat-select-panel') and @role='listbox']//mat-option//span[contains(text(), 'No')]")
	public WebElement WhitelabelNO;

// Webhook

// Label

	@FindBy(xpath = "//mat-label[contains(text(), 'Webhook Type')]")
	public WebElement WebhookTypeLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Webhook Url')]")
	public WebElement WebhookURLLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='type']")
	public WebElement WebhookType;

	@FindBy(xpath = "//input[@formcontrolname='url']")
	public WebElement WebhookTypeURL;

// KYC

	@FindBy(xpath = "//span[contains(text(), 'Add')]")
	public WebElement AddButton;

	@FindBy(xpath = "//mat-select[@formcontrolname='businessType']")
	public WebElement KYCBusinessType;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualPoi']")
	public WebElement proofofIdentityComapany;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinPoi']")
	public WebElement KYCNumberofDocinPoiCompany1;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualPoa']")
	public WebElement proofofaddress;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinPoa']")
	public WebElement KYCNumberofDocinPoaCompany2;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualBankDoc']")
	public WebElement KYCBankDoc;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinBank']")
	public WebElement KYCNumberofDocinBankCompany3;

	@FindBy(xpath = "//mat-select[@formcontrolname='individualTaxDoc']")
	public WebElement KYCTaxDoc;

	@FindBy(xpath = "//input[@formcontrolname='individualNumberofDocinTax']")
	public WebElement KYCNumberofDocinTaxCompany4;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonPoi']")
	public WebElement KYCIndividualProofOfIdentity;

	@FindBy(xpath = "//span[contains(text(), 'Aadhaar')]")
	public WebElement Aadhaar;

	@FindBy(xpath = "//input[@formcontrolname='numberofDocinPoi']")
	public WebElement KycNumberOfDocinPOiIndividual1;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonPoa']")
	public WebElement KYCIndividualProofOFAddress;

	@FindBy(xpath = "//input[@formcontrolname='numberofDocinPoa']")
	public WebElement KycNumberOfDocinPoaIndividual2;

	@FindBy(xpath = "//input[@formcontrolname='numberofDocinBank']")
	public WebElement KycIndividualBankDocs;

	@FindBy(xpath = "//input[@formcontrolname='numberofDocinTax']")
	public WebElement KycIndividualTaxDocs;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonotherDoc']")
	public WebElement KYCIndividualOtherDocument;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonTaxDoc']")
	public WebElement KYCIndividualTaxDocument;

	@FindBy(xpath = "//mat-select[@formcontrolname='keyPersonBankDoc']")
	public WebElement KYCIndividualBankDocument;

	@FindBy(xpath = "//input[@formcontrolname='keyPersonNumberofOtherDoc']")
	public WebElement keyPersonNumberofOtherDocIndividual3;

// Submit

	@FindBy(xpath = "//span[contains(text(), 'SUBMIT FOR VERIFICATION')]")
	public WebElement SubmitforVerification;

	@FindBy(xpath = "//span[contains(text(), 'OK')]")
	public WebElement OKButton;

// LogOut

	@FindBy(xpath = "//button[@title='profile']")
	public WebElement Profile;

	@FindBy(xpath = "//mat-icon[contains(text(), 'logout')]")

	public WebElement LogOut;

	@FindBy(xpath = "//span[contains(text(),'YES') or contains(text(),'Yes')]")

	public WebElement YesButton;

	@FindBy(xpath = "//span[contains(text(),'NO') or contains(text(),'No')]")

	public WebElement NoButton;

	@FindBy(xpath = "//input[@name='name1']")
	public WebElement SearchbyBankName;

	@FindBy(xpath = "(//button[@aria-label='Example icon-button with a menu'])[3]")
	public WebElement ActionClick;

	@FindBy(xpath = "//span[contains(text(),'View')]")
	public WebElement ViewButton;

	@FindBy(xpath = "//span[contains(text(),'Verified & Next')]")
	public WebElement VerifiedandNext;

	@FindBy(xpath = "//span[contains(text(),'SUBMIT FOR APPROVAL')]")
	public WebElement SubmitforApproval;

	@FindBy(xpath = "//span[contains(text(),'Verified')]")
	public WebElement Verified;

	@FindBy(xpath = "//span[contains(text(),'APPROVE')]")
	public WebElement Approve;

	@FindBy(xpath = "//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'cancel')]")
	public WebElement ApproveCancel;

	@FindBy(xpath = "//input[@formcontrolname='cpid'] | //input[@formcontrolname='cpId']")
	public WebElement CPID;

//  General info InvalidFormat 

	@FindBy(xpath = "//input[@formcontrolname='bankName']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement GeneralinfoBanknameInvalidformat;

	@FindBy(xpath = "//input[@formcontrolname='address']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement GeneralinfoAddressInvalidformat;

	@FindBy(xpath = "//input[@formcontrolname='zipCode']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement GeneralinfoPincodeInvalidformat;

	@FindBy(xpath = "//input[@formcontrolname='gst']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement GeneralinfogstInvalidformat;

	@FindBy(xpath = "//input[@formcontrolname='pan']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement GeneralinfopanInvalidformat;

	@FindBy(xpath = "//mat-chip-list[@formcontrolname='domain']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement GeneralinfoDomainInvalidformat;

// 	General	Required Field		

	@FindBy(xpath = "//input[@formcontrolname='bankName']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement GeneralinfoBanknameRequiredField;

	@FindBy(xpath = "//input[@formcontrolname='address']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement GeneralinfoAddressRequiredField;

	@FindBy(xpath = "//input[@formcontrolname='zipCode']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement GeneralinfoPincodeRequiredField;

	@FindBy(xpath = "//input[@formcontrolname='gst']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement GeneralinfoGSTRequiredField;

	@FindBy(xpath = "//input[@formcontrolname='pan']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement GeneralinfoPanRequiredField;

	@FindBy(xpath = "//input[@oninput='this.value=this.value.toLowerCase()']/ancestor::mat-form-field//mat-error[contains(text(), 'This field is required ')]")
	public WebElement GeneralinfoDomainRequiredField;

// Communication invalid format & Admin/settlement RECON

	@FindBy(xpath = "//input[@formcontrolname='name']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement CommunicationNameInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='position']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement CommunicationPositionInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='phone']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement CommunicationPhoneInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='mobile']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement CommunicationMobileInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='email']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement CommunicationEmailInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='userName']/ancestor::mat-form-field//mat-error[contains(text(), 'User name should contain minimum 10 characters')]")

	public WebElement CommunicationUserNameInvalidFormat;

	@FindBy(xpath = "//mat-error[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'invalid format')]")
	public WebElement invalidmessage;

// Communication Field is Required &Admin/settlement RECON

	@FindBy(xpath = "//input[@formcontrolname='name']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")

	public WebElement CommunicationNameFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='position']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")

	public WebElement CommunicationPositionFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='mobile']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")

	public WebElement CommunicationMobileFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='email']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")

	public WebElement CommunicationEmailFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='userName']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CommunicationUserNameFieldisRequired;

	@FindBy(xpath = "//mat-error[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'this field is required')]")
	public WebElement Thisfieldrequired;

// channel info field is required

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ChannelnameFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='transaction']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ChannelTransactionFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='network']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ChannelNetworkFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='routing']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ChannelRoutingFieldisRequired;

// Global FRM field is required

	@FindBy(xpath = "//input[@formcontrolname='Vcheckminutes']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement VcheckminutesFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='Vcheckcount']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement VcheckcountFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='posperdaycount']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CashposcountFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='Matmcount']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement MicroATMCountFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='Icardacceptance']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement IcardacceptanceFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='frmdaily']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ICADailyFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='frmweekly']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ICAWeeklyFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='frmmonthly']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ICAMonthlyFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='frmdaily']/ancestor::mat-form-field//mat-error[contains(text(), ' Must be less than Weekly Limit ')]")
	public WebElement ICAdailylessthanweeklylimtError;

	@FindBy(xpath = "//input[@formcontrolname='frmweekly']/ancestor::mat-form-field//mat-error[contains(text(), ' Must be less than Monthly Limit ')]")
	public WebElement ICAWeeklylessthanmonthlylimtError;

	@FindBy(xpath = "//input[@formcontrolname='frmweekly']/ancestor::mat-form-field//mat-error[contains(text(), ' Must be greater than Daily Limit ')]")
	public WebElement ICAWeeklygreaterthanDailylimtError;

	@FindBy(xpath = "//input[@formcontrolname='frmmonthly']/ancestor::mat-form-field//mat-error[contains(text(), ' Must be greater than Weekly Limit ')]")
	public WebElement ICAMonthlygreaterthanweeklylimtError;

	@FindBy(xpath = "//input[@formcontrolname='monthlyLimit']/following-sibling::mat-error[contains(text(), ' Equal value not allowed ')]")
	public WebElement MonthlyEqualValueNotAllowed;

// Commercial Interchange Plan

	@FindBy(xpath = "//input[@formcontrolname='interchangePlan']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement InterchangeplanPricingPlanFieldisRequired;

// Commercial BANKONBOARDING COMMERCIAL

	@FindBy(xpath = "//input[@formcontrolname='pricingPlanDescription']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement BankOnboardingPricingPlanFieldisRequired;

// Settlement Field is Required

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement SettlementChannelFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='accountType']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement SettlementAccTypeFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='bankAccountNumber']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement SettlementBankAccNumberFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='bankAccountNumber']/ancestor::mat-form-field//mat-error[contains(text(), ' mmsonboarding.settlement.minLength ')]")
	public WebElement SettlementAccNumberMinLength;

	@FindBy(xpath = "//input[@formcontrolname='ifsc']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement SettlementIFSCFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='ifsc']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid ifsc') or contains(text(), 'Invalid IFSC')]")
	public WebElement SettlementIFSCInvalid;

	@FindBy(xpath = "//input[@formcontrolname='bankName']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement SettlementBankNameFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='bankBranch']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement SettlementBranchNameFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='bankCity']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement SettlementCityNameFieldisRequired;

// Whitelabel BANK ONBOARDING CONFIGURATION

	@FindBy(xpath = "//input[@formcontrolname='maxPlatformUser']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement MaxPlatformUserInvalidFormat;

// Webhook WEBHOOKURL
	@FindBy(xpath = "//input[@formcontrolname='url']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement WebhookURLFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='type']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement Webhooktypes;

	@FindBy(xpath = "//input[@formcontrolname='url']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid Format') or contains(text(), 'Invalid format')]")
	public WebElement WebhookURLInvalidformat;

//clear refresh close

	@FindBy(xpath = "//mat-icon[contains(text(),'refresh')]")
	public WebElement refresh;

	@FindBy(xpath = "//app-table-header/div[@id='container']/form[1]/div[2]/button[4]/span[1]/*[1]")
	public WebElement Clear;

	@FindBy(xpath = "//button[@class='close']")
	public WebElement Close;

// verified sucess

	@FindBy(xpath = "//h2[contains(normalize-space(text()), 'Successfully Completed')]")
	public WebElement VerfiedSuccessCompleted;

	public BankLocators(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime(); // Get wait time from CustomWebDriverManager
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}