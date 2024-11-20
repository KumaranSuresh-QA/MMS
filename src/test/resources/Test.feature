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

Feature: System Users - Bank Onboarding Regressionnn

 This feature aims to test the functionality of the 'BankOnboardingnn' within the application.

  Scenario: SystemMaker Login
 Given I visit the System Maker Login using sheetname "Bank Regression" and rownumber 0
 And I enter the credentials and click a login button

    
  

  Scenario: System Maker sees Onboarding in Sidemenu
    When System Maker - Onboarding should be displayed in the side menu

  Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding

  #Scenario Outline: System Maker can enter mandatory fields in "General Info" of Bank Onboarding
    #When the SystemMaker clicks the bank module
    #And the SystemMaker clicks the Create Button
    #Then the "Bank Name" field should prompt to enter valid inputs using sheetname "Bank Regression" and rowNumber <rowNumber>
    #Then the "Address" field should prompt to enter valid inputs using sheetname "Bank Regression" and rowNumber <rowNumber>
    #Then the "Pincode" dropdown should prompt to select valid inputs 
    #Then the "GST" field should prompt to enter valid inputs with GST format using sheetname "Bank Regression" and rowNumber <rowNumber>
    #Then the "PAN" field should prompt to enter valid inputs with PAN format using sheetname "Bank Regression" and rowNumber <rowNumber>
    #Then the "MarsId" field should prompt to enter valid inputs using sheetname "Bank Regression" and rowNumber <rowNumber>
    #Then the "Domain" field should prompt to enter the valid domain name using sheetname "Bank Regression" and rowNumber <rowNumber>
    #Then the "NextStep" button should be prompted to click on General Info
#
  #
#
  #Examples:
     #| rowNumber |
     #|  1        |
     #|  2        |
     
     
     
    Scenario: System Maker Successfully Completes Mandatory Fields in Bank Onboarding
    When the SystemMaker clicks the bank module
    Then the System Maker Bank Onboarding should prompt users to enter valid inputs using the sheet name "Bank Regression"
    
    
   
    Scenario: System verifier Login
 Given I visit the System Verifier Login using sheetname "Bank Regression" and rownumber 1
 And I enter the credentials and click a login button
      	 
Scenario: System Verifier sees Onboarding in Sidemenu
   When System Verifier - Onboarding should be displayed in the side menu
    

Scenario: System Verifier sees side menu items in Onboarding
  Then the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Verifier clicks the bank module
    When the System Verifier clicks the bank module
    
    
 Scenario: System Verifier Successfully Verifies All Steps in Bank Onboarding

When the System Verifier completes Bank Onboarding, the system should prompt to verify all steps using the sheet name "Bank Regression"


 
 Scenario: System Approver Login
  Given I visit the System Approver Login using sheetname "Bank Regression" and rownumber 2
  And I enter the credentials and click a login button
   
  
  Scenario: System Approver sees Onboarding in Sidemenu
   When System Approver - Onboarding should be displayed in the side menu
  

Scenario: System Approver sees side menu items in Onboarding
  Then the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Approver clicks the bank module
    When the System Approver clicks the bank module
   
Scenario: System Approver Successfully Approve in Bank Onboarding
    When the System Approver completes Bank Onboarding, the system should prompt to Approve using the sheet name "Bank Regression"
   
    
    
    
    

     
      
      
      
      