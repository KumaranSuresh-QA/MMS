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

Feature: System Users - Aggregator Onboarding Regression

 This feature aims to test the functionality of the 'Aggregator Onboarding' within the application.
 
 
 #@loadDataExcelUtils
 #@run
#Scenario: Load Data from Excel
    #Given I load data from Excel using sheetname "Credentials"
    
Scenario: SystemMaker Login
 Given I visit the System Maker Login in Regression using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button in Regression using sheetname "Credentials" and rownumber 1


   Scenario: System Maker sees Onboarding in Sidemenu
    When System Maker - Onboarding should be displayed in the side menu

  Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
  
  
  Scenario: System Maker clicks the Aggregator module
    When the System Maker clicks the Aggregator module
  
   Scenario: System Maker Successfully Completes Mandatory Fields in Bank Onboarding
    Then the System Maker Aggregator Onboarding should prompt users to enter valid inputs using the sheet name "Aggregator Regression"
    
    
     #Scenario: System verifier Login
 #Given I visit the System Verifier Login in Regression using sheetname "Credentials" and rownumber 2
 #And I enter the credentials and click a login button in Regression using sheetname "Credentials" and rownumber 2
 #
 #
 #Scenario: System Verifier sees Onboarding in Sidemenu in Aggregator Onboarding
   #When System Verifier - Onboarding should be displayed in the side menu
    #
#
#Scenario: System Verifier sees side menu items in Aggregator Onboarding
  #Then the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 #
#
 #Scenario: System Verifier clicks the Aggregator module
    #When the System Verifier clicks the Aggregator module
    #
    #
#Scenario: System Verifier Successfully Verifies All Steps in Aggregator Onboarding
#When the System Verifier completes Aggregator Onboarding, the system should prompt to verify all steps using the sheet name "Aggregator Regression"
 #
 #
#Scenario: System Approver Login
   #Given I visit the System Approver Login in Regression using sheetname "Credentials" and rownumber 3
   #And I enter the credentials and click a login button in Regression using sheetname "Credentials" and rownumber 3
   #
  #
  #Scenario: System Approver sees Onboarding in Sidemenu
   #When System Approver - Onboarding should be displayed in the side menu
  #
#
#Scenario: System Approver sees side menu items in Onboarding
  #Then the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 #
#
 #Scenario: System Approver clicks the Aggregator module
    #When the System Approver clicks the Aggregator module
   #
#Scenario: System Approver Successfully Approve in Aggregator Onboarding
    #When the System Approver completes Aggregator Onboarding, the system should prompt to Approve using the sheet name "Aggregator Regression"
 #
    