package org.Locators;

import org.Testcases.CustomWebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AggregatorLocators {

	WebDriver driver;
	int waitTime;

// AggregatorLocators

	@FindBy(xpath = "//mat-error[contains(text(), 'Invalid bank name')]")

	public WebElement InvalidBankName;

	@FindBy(xpath = "(//mat-error[contains(text(), 'Please Upload a document')])[1]")

	public WebElement InvalidDocumenterror;

// SideMenu

	@FindBy(xpath = "//span[contains(text(), 'Sales Info')]")

	public WebElement SalesInfo;

	@FindBy(xpath = "//span[contains(text(), 'Company Info')]")

	public WebElement ComapnyInfo;

	@FindBy(xpath = "//span[contains(text(), 'Personal Info')]")

	public WebElement PersonalInfo;

	@FindBy(xpath = "//span[contains(text(), 'Communication Info')]")

	public WebElement CommunicationInfo;

	@FindBy(xpath = "//span[contains(text(), 'Channel Config')]")

	public WebElement ChannelConfig;

	@FindBy(xpath = "//span[contains(text(), 'Risk Info')]")

	public WebElement RiskINfo;

	@FindBy(xpath = "//span[contains(text(), 'Discount Rate')]")

	public WebElement DiscountRate;

	@FindBy(xpath = "//span[contains(text(), 'Settlement Info')]")

	public WebElement SettlementInfo;

	@FindBy(xpath = "//span[contains(text(), 'Whitelabel')]")

	public WebElement Whitelabel;

	@FindBy(xpath = "//span[contains(text(), 'Webhooks')]")

	public WebElement Webhooks;

	@FindBy(xpath = "//span[contains(text(), 'Status History')]")

	public WebElement StatusHistory;

	@FindBy(xpath = "//span[contains(text(), 'Change Log')]")

	public WebElement ChangeLog;

// IntroMenu

	@FindBy(xpath = "//h6[contains(text(), 'Brand Info')]")
	public WebElement IntroCompanyInfo;

	@FindBy(xpath = "//h6[contains(text(), 'Partner / Director / Owner / Trustee details') or contains(text(), 'Partner / Director / Owner / Trustee Details')]")
	public WebElement IntroPersonalInfo;

	@FindBy(xpath = "//h6[contains(text(), 'ADMIN USER Details') or contains(text(), 'Admin User details') or contains(text(), 'Admin User Details')]")
	public WebElement IntroCommunicationInfo;

	@FindBy(xpath = "//h6[text()='Channel Configuration']")
	public WebElement IntroChannelConfig;

	@FindBy(xpath = "//h6[contains(text(), 'KYC Config') or contains(text(), 'Personal Documents')]")

	public WebElement IntroKYC;

	@FindBy(xpath = "//h6[contains(text(), 'FRM Parameters')]")

	public WebElement IntroRiskInfo;

	@FindBy(xpath = "//h6[contains(text(), 'Aggregator Discounts')]")

	public WebElement IntroDiscountRate;

	@FindBy(xpath = "//h6[contains(text(), 'Bank Details')]")

	public WebElement IntroSettlementInfo;

	@FindBy(xpath = "//h6[contains(text(), 'Aggregator Onboarding Configuration')]")

	public WebElement IntroWhitelabel;

	@FindBy(xpath = "//h6[contains(text(), 'Payment Bridge')]")

	public WebElement IntroWebhooks;

// SalesInfo

	@FindBy(xpath = "(//mat-label[contains(text(), 'VAS Commission')])[1]")

	public WebElement VASCommissionLabelOne;

	@FindBy(xpath = "(//mat-select[@formcontrolname='isVasAllowed'])[1]")
	public WebElement VASCommissionOne;

	@FindBy(xpath = "//mat-label[text()='Aggregator Application Date ']")
	public WebElement AggregatorApplicationDateLabel;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[1]")
	public WebElement AggregatorApplicationDateCalenderOne;

	@FindBy(xpath = "//mat-label[contains(text(), 'Agreement Date')]")

	public WebElement AggreementDateLabel;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	public WebElement AggregatorApplicationDateCalenderTwo;

	@FindBy(xpath = "//mat-label[contains(text(), 'Aggregator Code')]")

	public WebElement AggregatorCodeLabel;

	@FindBy(xpath = "//input[@formcontrolname='aggregatorCode']")
	public WebElement AggregatorCode;

	@FindBy(xpath = "//mat-label[contains(text(), 'Allow Self Merchant Onboard')]")

	public WebElement AllowSelfMerchantOnboardLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='allowSelfMerchant']")
	public WebElement AllowSelfMerchantOnboard;

	@FindBy(xpath = "//mat-label[contains(text(), 'Mars Id')]")

	public WebElement MarsIdLabel;

	@FindBy(xpath = "//input[@formcontrolname='marsId']")
	public WebElement MarsId;

	@FindBy(xpath = "//mat-label[contains(text(), 'Auto Deactivation days')]")

	public WebElement AutoDeactivationdayslabel;

	@FindBy(xpath = "//input[@formcontrolname='autoDeactivationDays']")
	public WebElement AutoDeactivationdays;

	@FindBy(xpath = "(//mat-label[contains(text(), 'VAS Commission')])[2]")

	public WebElement VASCommissionLabelTWO;

	@FindBy(xpath = "(//mat-select[@formcontrolname='isVasAllowed'])[2]")
	public WebElement VASCommissionTWO;

	@FindBy(xpath = "//mat-label[contains(text(), 'Is TMS Aggregator')]")

	public WebElement IsTMSAggregatorLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='tmsAggregator']")
	public WebElement IsTMSAggregator;

	@FindBy(xpath = "//mat-label[contains(text(), 'EKyc Required')]")

	public WebElement EKycRequiredLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='isEkycRequired']")
	public WebElement EKycRequired;

// ComapanyInfo

	@FindBy(xpath = "//mat-label[contains(text(), 'Legal Name')]")

	public WebElement LegalNameLabel;

	@FindBy(xpath = "//input[@formcontrolname='legalName']")
	public WebElement LegalName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Brand Name')]")

	public WebElement BrandNameLabel;

	@FindBy(xpath = "//input[@formcontrolname='brandName']")
	public WebElement BrandName;

	@FindBy(xpath = "//mat-label[contains(text(), 'Registered Address')]")

	public WebElement RegisteredAddressLabel;

	@FindBy(xpath = "//input[@formcontrolname='registerAddress']")
	public WebElement RegisteredAddress;

	@FindBy(xpath = "//mat-label[contains(text(), 'Registered Pincode')]")

	public WebElement RegisteredPincodeLabel;

	@FindBy(xpath = "//input[@formcontrolname='registerPin']")
	public WebElement RegisteredPincode;

	@FindBy(xpath = "//mat-label[contains(text(), 'State')]")

	public WebElement StateLabel;

	@FindBy(xpath = "//input[@formcontrolname='state']")
	public WebElement State;

	@FindBy(xpath = "//mat-label[contains(text(), 'City')]")

	public WebElement CityLabel;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	public WebElement City;

	@FindBy(xpath = "//mat-label[contains(text(), 'Business Type')]")

	public WebElement BusinessTypeLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='businessType']")
	public WebElement BusinessType;

	@FindBy(xpath = "//span[contains(text(), 'Trust')]")

	public WebElement SelectOnBusinessType;

	@FindBy(xpath = "//mat-label[contains(text(), 'Established Year')]")

	public WebElement EstablishedYearLabel;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	public WebElement EstablishedYearDatepicker;

	@FindBy(xpath = "//mat-label[contains(text(), 'Registered Number')]")

	public WebElement RegisterNumberLabel;

	@FindBy(xpath = "//input[@formcontrolname='registeredNumber']")
	public WebElement RegisterNumber;

	@FindBy(xpath = "//mat-label[contains(text(), 'Company PAN')]")

	public WebElement ComapanyPANLabel;

	@FindBy(xpath = "//input[@formcontrolname='companyPan']")
	public WebElement CompanyPAN;

	@FindBy(xpath = "//mat-label[contains(text(), 'GSTIN')]")

	public WebElement GSTINLabel;

	@FindBy(xpath = "//input[@formcontrolname='gstin']")
	public WebElement GSTIN;

	@FindBy(xpath = "//mat-label[contains(text(), 'Statement Frequency')]")

	public WebElement StatementFrequencyLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementFrequency']")
	public WebElement StatementFrequency;

	@FindBy(xpath = "//span[contains(text(), 'Monthly')]")

	public WebElement SelectStatementFrequencyQuarterly;

	@FindBy(xpath = "//mat-label[contains(text(), 'Statement Type')]")

	public WebElement StatementTypeLabel;

	@FindBy(xpath = "//mat-select[contains(@formcontrolname, 'statementType')]")

	public WebElement StatementType;

	@FindBy(xpath = "//span[contains(text(), 'Pdf')]")

	public WebElement SelectStatementTypePDF;

	@FindBy(xpath = "//mat-label[contains(text(), 'Email Domain')]")

	public WebElement EmailDoaminLabel;

	@FindBy(xpath = "//input[@oninput='this.value=this.value.toLowerCase()']")
	public WebElement EmailDomain;

// Personal Info

	@FindBy(xpath = "//mat-label[text()='Title']")
	public WebElement titlepersonallabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='title']")
	public WebElement titlepersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'First Name')]")

	public WebElement FirstNamePersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	public WebElement FirstNamePersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Last Name')]")

	public WebElement LastNamePersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	public WebElement LastNamePersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Date Of Birth')]")

	public WebElement DOBPersonllLabel;

	@FindBy(xpath = "//input[@formcontrolname='dob']")
	public WebElement DOBPersonl;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	public WebElement OpenCalenderPersonal;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	public WebElement ChooseMonthandYear;

	@FindBy(xpath = "//div[contains(text(), '1998')]")

	public WebElement Year;

	@FindBy(xpath = "//div[contains(text(), 'NOV')]")

	public WebElement Month;

	@FindBy(xpath = "//div[contains(text(), '30')]")

	public WebElement Date;

	@FindBy(xpath = "//input[@formcontrolname='pan']")
	public WebElement PanPersonal;

	@FindBy(xpath = "//input[@formcontrolname='address']")
	public WebElement AddressPersonal;

	@FindBy(xpath = "//input[@formcontrolname='pincode']")
	public WebElement PincodePersonal;

	@FindBy(xpath = "//input[@formcontrolname='city']")
	public WebElement CityPersonal;

	@FindBy(xpath = "//input[contains(@formcontrolname, 'state')]")

	public WebElement StatePersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Mobile')]")

	public WebElement MobilePersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='mobile']")
	public WebElement MobilePersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Telephone')]")

	public WebElement telephonepersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='telephone']")
	public WebElement telephonepersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Email')]")

	public WebElement emailpersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	public WebElement emailPersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Nationality')]")

	public WebElement NationalitypersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='nationality']")
	public WebElement Nationalitypersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Aadhaar Number')]")

	public WebElement AadhaarNumberLabelPersonal;

	@FindBy(xpath = "//input[@formcontrolname='aadharNumber']")
	public WebElement AadhaarNumberPersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Passport Number')]")

	public WebElement PassportNumberPersonalLabel;

	@FindBy(xpath = "//input[@formcontrolname='passportNumber']")
	public WebElement PassportNumberPersonal;

	@FindBy(xpath = "//mat-label[contains(text(), 'Passport Expiry date')]")

	public WebElement PassportExpiryDatePersonal;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	public WebElement OpenCalenderPasswordExpiryDate;

//   		@FindBy(xpath = "//span[text()='Save'] | //span[text()=' Save ']")

// Channel Config

	@FindBy(xpath = "//mat-label[contains(text(), 'Bank Name')]")

	public WebElement ChannelBankNameLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Channel')]")

	public WebElement ChannelLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Network')]")

	public WebElement CHannelNetworkLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Transaction Sets')]")

	public WebElement ChannelTransactionsetsLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Start Date')]")

	public WebElement ChannelStartDateLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'End Date')]")

	public WebElement ChannelENDDateLabel;

	@FindBy(xpath = "//input[@formcontrolname='bankName']")
	public WebElement ChannelBankName;

	@FindBy(xpath = "//mat-select[@formcontrolname='channel']")
	public WebElement Channel;

	@FindBy(xpath = "//mat-select[@formcontrolname='network']")
	public WebElement ChannelNetwork;

	@FindBy(xpath = "//mat-select[@formcontrolname='transaction']")
	public WebElement ChannelTransaction;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[1]")
	public WebElement ChannelOpencalender1;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	public WebElement ChannelOpencalender2;

	@FindBy(xpath = "//span[contains(text(), 'Apply')]")

	public WebElement ApplyButton;

// KYC

	@FindBy(xpath = "(//input[@type='file'])[2]")
	public WebElement CompanyProofofaddressUpload;

	@FindBy(xpath = "(//input[@type='file'])[9]")
	public WebElement CompanyPANUpload;

	@FindBy(xpath = "(//input[@type='file'])[13]")
	public WebElement GSTCertificateUpload;

	@FindBy(xpath = "(//input[@type='file'])[4]")
	public WebElement AadhaarUpload;

// RiskInfo

// Label
	@FindBy(xpath = "//mat-label[contains(text(), 'Velocity Check Minutes')]")

	public WebElement VelocityCheckMinuteLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Velocity Check Count')]")

	public WebElement VelocityCheckCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Cash@POS Count')]")

	public WebElement CashPOSCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'International Card Acceptance')]")

	public WebElement InternationalCardCountLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Daily')]")

	public WebElement DailyLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Weekly')]")

	public WebElement WeeklyLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Monthly')]")

	public WebElement MonthlyLabel;

// Click

	@FindBy(xpath = "//input[@formcontrolname='vCheckMinutes']")
	public WebElement VelocityCheckMinute;

	@FindBy(xpath = "//input[@formcontrolname='vCheckCount']")
	public WebElement VelocityCheckCount;

	@FindBy(xpath = "//input[@formcontrolname='posPerDayCount']")
	public WebElement CashPOSCount;

	@FindBy(xpath = "//input[@formcontrolname='matmCount']")
	public WebElement microatmcount;

	@FindBy(xpath = "//mat-select[@formcontrolname='iCardAcceptance']")
	public WebElement InternationalCardCount;

	@FindBy(xpath = "//input[@formcontrolname='frmDaily']")
	public WebElement ICADaily;

	@FindBy(xpath = "//input[@formcontrolname='frmWeekly']")
	public WebElement ICAWeekly;

	@FindBy(xpath = "//input[@formcontrolname='frmMonthly']")
	public WebElement ICAMonthly;

// DiscountRate

	@FindBy(xpath = "//input[@formcontrolname='pricingPlanDescription']")
	public WebElement DiscountRatePricingPlan;

// Settlement

	@FindBy(xpath = "//mat-label[contains(text(), 'Settlement Mode')]")

	public WebElement SettlementModeLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'Payment Flag')]")

	public WebElement PaymentFlagLabel;

	@FindBy(xpath = "//mat-select[@formcontrolname='settlementMode']")
	public WebElement SettlementMode;

	@FindBy(xpath = "//mat-select[@formcontrolname='paymentFlag']")
	public WebElement PaymentFlag;

	@FindBy(xpath = "//mat-chip-list[@formcontrolname='customMail']")
	public WebElement StatementEmail;

	@FindBy(xpath = "//mat-error[text()=' This field is required ']")
	public WebElement Statementemailfieldrequired;

	@FindBy(xpath = "//span[text()='Aggregator Gross Settlement']")
	public WebElement SelectOnSettlementMode;

	@FindBy(xpath = "//span[contains(text(), 'D')]")

	public WebElement SelectOnPaymenrFlag;

// WhiteLabel

	@FindBy(xpath = "//mat-label[contains(text(), 'Allow to Create Merchant User')]")

	public WebElement AllowtocreateMerchantLabel;

	@FindBy(xpath = "//mat-label[contains(text(), 'UserName As')]")

	public WebElement UserNameAsLabl;

	@FindBy(xpath = "//mat-select[@formcontrolname='createMerchentUser']")
	public WebElement CreateMerchantUser;

	@FindBy(xpath = "//mat-select[@formcontrolname='userNameAs']")
	public WebElement UserNameAs;

	@FindBy(xpath = "//span[contains(text(), 'phone')]")

	public WebElement SelectonUserNameAs;

// Manual Takeover

	@FindBy(xpath = "//span[contains(text(), 'Manual Takeover')]")
	public WebElement ManualTakeOver;

	@FindBy(xpath = "(//span[contains(text(), 'View Document')])[1]")
	public WebElement ViewDocument1;

	@FindBy(xpath = "(//span[contains(text(), 'View Document')])[2]")
	public WebElement ViewDocument2;

	@FindBy(xpath = "(//span[contains(text(), 'View Document')])[3]")
	public WebElement ViewDocument3;

	@FindBy(xpath = "//mat-select[@formcontrolname='type']")
	public WebElement Actions;

	@FindBy(xpath = "//span[contains(text(), 'Verified')]")
	public WebElement ViewDocumentVerified;

	@FindBy(xpath = "//span[contains(text(), 'Submit & Next')]")
	public WebElement ViewDocumentSubmitandNext;

// Sales Info

	@FindBy(xpath = "//input[@formcontrolname='aggregatorCode']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement AggregatorCodefieldrequired;

//  Company Info Invalid Format

	@FindBy(xpath = "//input[@formcontrolname='legalName']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement CompanyLegalNameInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='brandName']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement CompanyBrandNameInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='registerAddress']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement CompanyRegAddressInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='registerPin']/ancestor::mat-form-field//mat-error[contains(text(), '  Invalid Pincode ')]")
	public WebElement CompanyRegPincodeInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='registeredNumber']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement CompanyRegNumInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='companyPan']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement CompanyCmpPanInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='gstin']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement CompanyCmpGSTInvalidFormat;

	@FindBy(xpath = "//mat-chip-list[@formcontrolname='emailDomain']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement CompanyEmailDomainInvalidFormat;

// Company Info Field is Required

	@FindBy(xpath = "//input[@formcontrolname='legalName']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyLegalNameFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='brandName']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyBrandNameFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='registerAddress']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyRegAddressFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='registerPin']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyRegPinFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='businessType']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyBusinessTypFieldisRequired;

	@FindBy(xpath = "//mat-chip-list[@formcontrolname='emailDomain']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyEmailDomainFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='establishYear']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyCalenderFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='registeredNumber']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyRegNumFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='companyPan']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyRegPanFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='gstin']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyCmpGSTFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='statementType']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement CompanyStatementTypeFieldisRequired;

// Personal Info

	@FindBy(xpath = "//mat-select[@formcontrolname='title']/ancestor::mat-form-field//mat-error[contains(text(), 'This field is required ')]")
	public WebElement PersonalinfoTitleFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='firstName']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoFirstNameFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='dob']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoDOBFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='pan']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoPANFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='address']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoAddressFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='pincode']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoPincodeFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='mobile']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoMobileFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='email']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoEmailFieldrequired;

	@FindBy(xpath = "//input[@formcontrolname='nationality']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PersonalinfoNationalityFieldrequired;

// Personal info invalid format

	@FindBy(xpath = "//input[@formcontrolname='firstName']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoFirstNameInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='lastName']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoLastNameInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='pan']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoPanInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='address']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoAddressInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='mobile']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoMobileInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='telephone']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoTelephoneInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='email']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoEmailInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='nationality']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoNationalityInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='aadharNumber']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoAadhaarInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='passportNumber']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), 'Invalid Format')]")
	public WebElement PersonalInfoPassportNumberInvalidFormat;

	@FindBy(xpath = "//input[@formcontrolname='pincode']/ancestor::mat-form-field//mat-error[contains(text(), 'Invalid format') or contains(text(), '  Invalid Pincode ')]")
	public WebElement PersonalInfoPincodeInvalidFormat;

// Channel info

	@FindBy(xpath = "//input[@formcontrolname='bankName']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ChannelAggregatorBankNameFieldRequired;

	@FindBy(xpath = "//input[@formcontrolname='bankName']/ancestor::mat-form-field//mat-error[contains(text(), ' Invalid bank name ')]")
	public WebElement ChannelAggregatorBankNameInvalidBankName;

	@FindBy(xpath = "//input[@formcontrolname='startDate']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ChannelStartDateFieldisRequired;

	@FindBy(xpath = "//input[@formcontrolname='endDate']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement ChannelEndDateFieldisRequired;

// Discount Rate

	@FindBy(xpath = "//input[@formcontrolname='pricingPlanDescription']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement DiscountRatePricingPlanFieldRequired;

//Aggregator settlement info field Required

	@FindBy(xpath = "//mat-select[@formcontrolname='settlementMode']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement SettlementmodeFieldisRequired;

	@FindBy(xpath = "//mat-select[@formcontrolname='paymentFlag']/ancestor::mat-form-field//mat-error[contains(text(), ' This field is required ')]")
	public WebElement PaymentFlagFieldisRequired;

	public AggregatorLocators(WebDriver driver) {

		this.waitTime = CustomWebDriverManager.getWaitTime(); // Get wait time from CustomWebDriverManager
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}