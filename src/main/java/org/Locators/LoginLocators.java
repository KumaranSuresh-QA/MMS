package org.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocators {

	WebDriver driver;

	@FindBy(xpath = "//h1[contains(text(), 'Sign In')]")
	public WebElement LoginpageDisplayed;

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	public WebElement EnterOnUserName;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	public WebElement EnterOnPassword;

	@FindBy(xpath = "//input[@formcontrolname='captchaText']")
	public WebElement EnterOnCaptcha;

	@FindBy(xpath = "//mat-label[@for='username']")
	public WebElement LabelUsername;

	@FindBy(xpath = "//mat-label[@for='password']")
	public WebElement LabelPassword;

	@FindBy(xpath = "//span[contains(text(), 'Sign In')]")
	public WebElement ClickOnLogin;

	@FindBy(xpath = "//mat-error[contains(text(), 'This field is required')]")
	public WebElement fieldisrequired;

	@FindBy(xpath = "//span[contains(text(), 'Invalid Username or Password')]")
	public WebElement Invaliduserorpass;

	@FindBy(xpath = "//span[contains(text(), 'Invalid Captcha')]")
	public WebElement InvalidCaptcha;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElement ClickonEyeicon;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[2]/div[1]/div[2]/form[1]/div[1]/div[3]/span[1]/*[1]")
	public WebElement Displayedoncaptcha;

	@FindBy(xpath = "//mat-label[contains(text(), 'Enter Captcha')]")
	public WebElement CaptchaLabelName;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[2]/div[1]/div[2]/form[1]/div[1]/div[3]/button[1]/span[1]/img[1]")
	public WebElement CaptchaRefresh;

	@FindBy(xpath = "//body/app-root[1]/app-signin[1]/mat-grid-list[1]/div[1]/mat-grid-tile[1]/div[1]/div[1]/div[3]/div[1]/p-carousel[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-skeleton-loader[1]/img[1]")
	public WebElement Image;

	@FindBy(xpath = "//span[contains(text(), 'Forgot?')]")
	public WebElement Forgot;

	@FindBy(xpath = "//span[contains(text(), 'Verify OTP & Set Password')]")
	public WebElement Forgoterrormessage;

	@FindBy(xpath = "//a[contains(text(), 'Contact Support')]")
	public WebElement ClickOnContactSupport;

	@FindBy(xpath = "//span[contains(text(), 'Email')]")
	public WebElement ContactSupportVerify;

	@FindBy(xpath = "//a[contains(text(), 'Terms of Use')]")
	public WebElement ClickOnTermOfUse;

	@FindBy(xpath = "//h2[contains(text(), 'Terms and Conditions')]")
	public WebElement TermofuseVerify;

	@FindBy(xpath = "//a[contains(text(), 'Privacy Policy')]")
	public WebElement Clickonprivacy;

	@FindBy(xpath = "//h2[contains(text(), 'Introduction')]")
	public WebElement PrivacypolicyVerify;

	public LoginLocators(WebDriver driver) {
		// initialize elements
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

}
