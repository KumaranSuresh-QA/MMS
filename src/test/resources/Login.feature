#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login Page Functionality

This feature aims to test the functionality of the 'Login Page' within the application.

Scenario: Verify User Name label
    Given the login page is displayed
    Then the label name should be "User Name"
    
    
Scenario: Verify User Name field prompts for alphanumeric inputs
    Given the login page is displayed
    Then the "User Name" field should prompt to enter valid alphanumeric inputs using sheetname "Bank" and rownumber 0
    Then Error Message Should not be Displayed
 
    
Scenario: Verify User Name field does not allow proceeding without input
    Given the login page is displayed
    Then the "User Name" field should not allow to proceed without any input data
    Then This field is required Error Message Should be Displayed
    
    
Scenario: Verify Password label
    Given the login page is displayed
    Then the label name should be "Password"
  
Scenario: Verify Password link is clickable
    Given the login page is displayed
    Then the "Password" link should be clickable using sheetname "Bank" and rownumber 0  
   
     
Scenario: Verify Password field does not allow proceeding without input
    Given the login page is displayed
    Then the "Password" field should not allow to proceed without any input data   
    Then This field is required Error Message Should be Displayed
    
    
   
 Scenario: Verify Password unhide functionality
    Given the login page is displayed
    When the eye icon next to the "Password" field is clicked
    Then the "Password" should be revealed

Scenario: Verify Password hide functionality
    Given the login page is displayed
    When the eye icon next to the "Password" field is clicked again
    Then the "Password" should be hidden
    
    
Scenario: Verify Captcha presence
    Given the login page is displayed
    Then the "Captcha" should be present and visible on the login page


Scenario: Verify Enter Captcha label
    Given the login page is displayed
    Then the label name should be "Enter Captcha"


 Scenario: Verify Captcha field does not allow proceeding without input
    Given the login page is displayed
    Then the "Captcha" field should not allow to proceed without any input data
    Then Invalid Captcha Error Message Should be Displayed

  Scenario: Verify Captcha Refresh Button

    Given the login page is displayed
    When the "Captcha" refresh button is visible
    
Scenario: Verify Sign In button is clickable
    Given the login page is displayed
    Then the "Sign In" button should be clickable

    
Scenario: Verify Forgot link is clickable
    Given the login page is displayed
    Then the "Forgot" link should be clickable
    
   
Scenario: Verify Image presence
    Given the login page is displayed
    Then the "Image" should be present and visible on the login page

   
Scenario: Verify Terms of Use link is clickable
    Given the login page is displayed
    Then the "Terms of Use" link should be clickable


Scenario: Verify Privacy Policy link is clickable
    Given the login page is displayed
    Then the "Privacy Policy" link should be clickable


Scenario: Verify Contact Support link is clickable
    Given the login page is displayed
    Then the "Contact Support" link should be clickable
    
    


