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
Feature: Systen User Credentials
 This feature aims to test the functionality of the 'SystemUsers' within the application.


Scenario: System Maker Login
 Given I visit the System Maker Login using sheetname "Bank" and rownumber 2
 And I enter the credentials and click a login button

 
Scenario: if i login as Systen Maker Should be able to see the Bank,Aggrerators,ISO,Groupmerchant,Merchant and Terminal in Onboarding
    Then Should be able to see the Bank, Aggrerators, ISO, Sub ISO, Groupmerchant, Merchant, and Terminal in Onboarding
   
Scenario: if i login as System Maker with Status: New should be able to see Create, View ,Edit and Close buttons in Bank
    Given I am searching in the Bank Onboarding with Status : New
    Then  Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is New
 
    
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: New in Bank
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Bank Onboarding when the status is New
  
       
Scenario: System Maker sees only the Cancel button when viewing in Status: New in Bank

    Given I am searching in the Bank Onboarding with Status :New
    Then I click the View button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is New
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is New
    
Scenario: if i login as System Maker with Status: Inprogress should be able to see Create, View, and Close buttons in Bank
    Given I am searching in the Bank Onboarding with Status : Inprogress
    Then  Should be able to see the Create, View, and Close buttons in the Bank Onboarding when the status is Inprogress
    Then  Should not be able to see the Edit button in the Bank Onboarding when the status is Inprogress
    
    
Scenario: System Maker sees only the Cancel button when viewing in Status: Inprogress in Bank
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is Inprogress
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Inprogress  
    
    
Scenario: if i login as System Maker with Status: Verified should be able to see Create, View, and Close buttons in Bank
    Given I am searching in the Bank Onboarding with Status : Verified
    Then  Should be able to see the Create, View, and Close buttons in the Bank Onboarding when the status is Verified
    Then  Should not be able to see the Edit button in the Bank Onboarding when the status is Verified
    
    
       
Scenario: System Maker sees only the Cancel button when viewing in Status: Verified in Bank
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is Verified
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Verified 
    
 
Scenario: if i login as System Maker with Status: Draft should be able to see Create, View ,Edit and Close buttons in Bank
    Given I am searching in the Bank Onboarding with Status : Draft
    Then  Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is Draft
    
 
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Draft in Bank
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Bank Onboarding when the status is Draft
   
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Draft in Bank

    Given I am searching in the Bank Onboarding with Status : Draft
    Then I click the View button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is Draft
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Draft
   
   
Scenario: if i login as System Maker with Status: Referback should be able to see Create, View ,Edit and Close buttons in Bank
    Given I am searching in the Bank Onboarding with Status : Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is Referback
    
     
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Referback in Bank
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Bank Onboarding when the status is Referback
     Then I Should not be able to see the Submit for Verification button in the Bank Onboarding when the status is Referback
       
       
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Referback in Bank

    Given I am searching in the Bank Onboarding with Status : Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Referback
 

 Scenario: if i login as System Maker with Status: Auto Referback should be able to see Create, View ,Edit and Close buttons in Bank
    Given I am searching in the Bank Onboarding with Status :Auto Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is Auto Referback
  
Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Auto Referback in Bank
  
    
    Then I click the Edit button
    Then should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Bank Onboarding when the status is Auto Referback
  
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Auto Referback in Bank

    Given I am searching in the Bank Onboarding with Status :Auto Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is Auto Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Auto Referback
   

Scenario: if i login as System Maker with Status: Approved should be able to see Create, View ,Edit and Close buttons in Bank
    Given I am searching in the Bank Onboarding with Status : Approved
    Then  Should be able to see the Create, View, Edit and Close buttons in the Bank Onboarding when the status is Approved
    
 
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Approved in Bank
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Bank Onboarding when the status is Approved
    Then I Should not be able to see the Submit for Verification button in the Bank Onboarding when the status is Approved

Scenario: System Maker sees only the Cancel button when viewing in Status: Approved in Bank

    Given I am searching in the Bank Onboarding with Status : Approved
    Then I click the View button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is Approved
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Approved


Scenario: if i login as System Maker with Status: Rejected should be able to see the Create, Edit and View buttons in Bank
    Given  I am searching in the Bank Onboarding with Status : Rejected
    Then   Should be able to see the Create , Edit and View buttons in the Bank Onboarding when the status is Rejected
    Then   Should not be able to see the Close buttons in the Bank Onboarding when the status is Rejected


 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Rejected in Bank
   
    Then I click the edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Bank Onboarding when the status is New


Scenario: System Maker sees only the Cancel button when viewing in Status: Rejected in Bank
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is Rejected
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Rejected 

 
Scenario: if i login as System Maker with Status: Closed should be able to see the Create, Edit and View buttons in Bank
    Given I am searching in the Bank Onboarding with Status : Closed
    Then  Should be able to see the Create,Edit and View buttons in the Bank Onboarding when the status is CLosed
    Then  Should not be able to see the Close button in the Bank Onboarding when the status is Closed   
    
    
   
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Closed in Bank
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Bank Onboarding when the status is Closed
    Then I Should not be able to see the Submit for Verification button in the Bank Onboarding when the status is Closed
 
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Closed in Bank

    Given I am searching in the Bank Onboarding with Status : Closed
    Then I click the View button
    Then I should be able to see only the Cancel button in the Bank Onboarding when the status is Closed
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Bank Onboarding when the status is Closed









Scenario: if i login as System Maker with Status: New should be able to see Create, View ,Edit and Close buttons in Payfac
    Given I am searching in the Payfac Onboarding with Status : New
    Then  Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is New
 
    
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: New in Payfac
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Payfac Onboarding when the status is New
  
       
Scenario: System Maker sees only the Cancel button when viewing in Status: New in Payfac

    Given I am searching in the Payfac Onboarding with Status :New
    Then I click the View button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is New
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is New
    
Scenario: if i login as System Maker with Status: Inprogress should be able to see Create, View, and Close buttons in Payfac
    Given I am searching in the Payfac Onboarding with Status : Inprogress
    Then  Should be able to see the Create, View, and Close buttons in the Payfac Onboarding when the status is Inprogress
    Then  Should not be able to see the Edit button in the Payfac Onboarding when the status is Inprogress
    
    
Scenario: System Maker sees only the Cancel button when viewing in Status: Inprogress in Payfac
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is Inprogress
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Inprogress  
    
    
Scenario: if i login as System Maker with Status: Verified should be able to see Create, View, and Close buttons in Payfac
    Given I am searching in the Payfac Onboarding with Status : Verified
    Then  Should be able to see the Create, View, and Close buttons in the Payfac Onboarding when the status is Verified
    Then  Should not be able to see the Edit button in the Payfac Onboarding when the status is Verified
    
    
       
Scenario: System Maker sees only the Cancel button when viewing in Status: Verified in Payfac
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is Verified
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Verified 
    
 
Scenario: if i login as System Maker with Status: Draft should be able to see Create, View ,Edit and Close buttons in Payfac
    Given I am searching in the Payfac Onboarding with Status : Draft
    Then  Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is Draft
    
 
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Draft in Payfac
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Payfac Onboarding when the status is Draft
   
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Draft in Payfac

    Given I am searching in the Payfac Onboarding with Status : Draft
    Then I click the View button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is Draft
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Draft
   
   
Scenario: if i login as System Maker with Status: Referback should be able to see Create, View ,Edit and Close buttons in Payfac
    Given I am searching in the Payfac Onboarding with Status : Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is Referback
    
     
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Referback in Payfac
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Payfac Onboarding when the status is Referback
     Then I Should not be able to see the Submit for Verification button in the Payfac Onboarding when the status is Referback
       
       
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Referback in Payfac

    Given I am searching in the Payfac Onboarding with Status : Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Referback
 

 Scenario: if i login as System Maker with Status: Auto Referback should be able to see Create, View ,Edit and Close buttons in Payfac
    Given I am searching in the Payfac Onboarding with Status :Auto Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is Auto Referback
  
Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Auto Referback in Payfac
  
    
    Then I click the Edit button
    Then should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Payfac Onboarding when the status is Auto Referback
  
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Auto Referback in Payfac

    Given I am searching in the Payfac Onboarding with Status :Auto Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is Auto Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Auto Referback
   

Scenario: if i login as System Maker with Status: Approved should be able to see Create, View ,Edit and Close buttons in Payfac
    Given I am searching in the Payfac Onboarding with Status : Approved
    Then  Should be able to see the Create, View, Edit and Close buttons in the Payfac Onboarding when the status is Approved
    
 
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Approved in Payfac
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Payfac Onboarding when the status is Approved
    Then I Should not be able to see the Submit for Verification button in the Payfac Onboarding when the status is Approved

Scenario: System Maker sees only the Cancel button when viewing in Status: Approved in Payfac

    Given I am searching in the Payfac Onboarding with Status : Approved
    Then I click the View button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is Approved
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Approved


Scenario: if i login as System Maker with Status: Rejected should be able to see the Create, Edit and View buttons in Payfac
    Given  I am searching in the Payfac Onboarding with Status : Rejected
    Then   Should be able to see the Create , Edit and View buttons in the Payfac Onboarding when the status is Rejected
    Then   Should not be able to see the Close buttons in the Payfac Onboarding when the status is Rejected


 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Rejected in Payfac
   
    Then I click the edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Payfac Onboarding when the status is New


Scenario: System Maker sees only the Cancel button when viewing in Status: Rejected in Payfac
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is Rejected
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Rejected 

 
Scenario: if i login as System Maker with Status: Closed should be able to see the Create, Edit and View buttons in Payfac
    Given I am searching in the Payfac Onboarding with Status : Closed
    Then  Should be able to see the Create,Edit and View buttons in the Payfac Onboarding when the status is CLosed
    Then  Should not be able to see the Close button in the Payfac Onboarding when the status is Closed   
    
    
   
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Closed in Payfac
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Payfac Onboarding when the status is Closed
    Then I Should not be able to see the Submit for Verification button in the Payfac Onboarding when the status is Closed
 
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Closed in Payfac

    Given I am searching in the Payfac Onboarding with Status : Closed
    Then I click the View button
    Then I should be able to see only the Cancel button in the Payfac Onboarding when the status is Closed
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Payfac Onboarding when the status is Closed










Scenario: if i login as System Maker with Status: New should be able to see Create, View ,Edit and Close buttons in ISO
    Given I am searching in the ISO Onboarding with Status : New
    Then  Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is New
 
    
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: New in ISO
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the ISO Onboarding when the status is New
  
       
Scenario: System Maker sees only the Cancel button when viewing in Status: New in ISO

    Given I am searching in the ISO Onboarding with Status :New
    Then I click the View button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is New
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is New
    
Scenario: if i login as System Maker with Status: Inprogress should be able to see Create, View, and Close buttons in ISO
    Given I am searching in the ISO Onboarding with Status : Inprogress
    Then  Should be able to see the Create, View, and Close buttons in the ISO Onboarding when the status is Inprogress
    Then  Should not be able to see the Edit button in the ISO Onboarding when the status is Inprogress
    
    
Scenario: System Maker sees only the Cancel button when viewing in Status: Inprogress in ISO
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is Inprogress
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Inprogress  
    
    
Scenario: if i login as System Maker with Status: Verified should be able to see Create, View, and Close buttons in ISO
    Given I am searching in the ISO Onboarding with Status : Verified
    Then  Should be able to see the Create, View, and Close buttons in the ISO Onboarding when the status is Verified
    Then  Should not be able to see the Edit button in the ISO Onboarding when the status is Verified
    
    
       
Scenario: System Maker sees only the Cancel button when viewing in Status: Verified in ISO
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is Verified
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Verified 
    
 
Scenario: if i login as System Maker with Status: Draft should be able to see Create, View ,Edit and Close buttons in ISO
    Given I am searching in the ISO Onboarding with Status : Draft
    Then  Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is Draft
    
 
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Draft in ISO
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the ISO Onboarding when the status is Draft
   
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Draft in ISO

    Given I am searching in the ISO Onboarding with Status : Draft
    Then I click the View button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is Draft
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Draft
   
   
Scenario: if i login as System Maker with Status: Referback should be able to see Create, View ,Edit and Close buttons in ISO
    Given I am searching in the ISO Onboarding with Status : Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is Referback
    
     
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Referback in ISO
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the ISO Onboarding when the status is Referback
     Then I Should not be able to see the Submit for Verification button in the ISO Onboarding when the status is Referback
       
       
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Referback in ISO

    Given I am searching in the ISO Onboarding with Status : Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Referback
 

 Scenario: if i login as System Maker with Status: Auto Referback should be able to see Create, View ,Edit and Close buttons in ISO
    Given I am searching in the ISO Onboarding with Status :Auto Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is Auto Referback
  
Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Auto Referback in ISO
  
    
    Then I click the Edit button
    Then should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the ISO Onboarding when the status is Auto Referback
  
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Auto Referback in ISO

    Given I am searching in the ISO Onboarding with Status :Auto Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is Auto Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Auto Referback
   

Scenario: if i login as System Maker with Status: Approved should be able to see Create, View ,Edit and Close buttons in ISO
    Given I am searching in the ISO Onboarding with Status : Approved
    Then  Should be able to see the Create, View, Edit and Close buttons in the ISO Onboarding when the status is Approved
    
 
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Approved in ISO
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the ISO Onboarding when the status is Approved
    Then I Should not be able to see the Submit for Verification button in the ISO Onboarding when the status is Approved

Scenario: System Maker sees only the Cancel button when viewing in Status: Approved in ISO

    Given I am searching in the ISO Onboarding with Status : Approved
    Then I click the View button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is Approved
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Approved


Scenario: if i login as System Maker with Status: Rejected should be able to see the Create, Edit and View buttons in ISO
    Given  I am searching in the ISO Onboarding with Status : Rejected
    Then   Should be able to see the Create , Edit and View buttons in the ISO Onboarding when the status is Rejected
    Then   Should not be able to see the Close buttons in the ISO Onboarding when the status is Rejected


 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Rejected in ISO
   
    Then I click the edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the ISO Onboarding when the status is New


Scenario: System Maker sees only the Cancel button when viewing in Status: Rejected in ISO
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is Rejected
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Rejected 

 
Scenario: if i login as System Maker with Status: Closed should be able to see the Create, Edit and View buttons in ISO
    Given I am searching in the ISO Onboarding with Status : Closed
    Then  Should be able to see the Create,Edit and View buttons in the ISO Onboarding when the status is CLosed
    Then  Should not be able to see the Close button in the ISO Onboarding when the status is Closed   
    
    
   
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Closed in ISO
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the ISO Onboarding when the status is Closed
    Then I Should not be able to see the Submit for Verification button in the ISO Onboarding when the status is Closed
 
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Closed in ISO

    Given I am searching in the ISO Onboarding with Status : Closed
    Then I click the View button
    Then I should be able to see only the Cancel button in the ISO Onboarding when the status is Closed
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the ISO Onboarding when the status is Closed












Scenario: if i login as System Maker with Status: New should be able to see Create, View ,Edit and Close buttons in SUBISO
    Given I am searching in the SUBISO Onboarding with Status : New
    Then  Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is New
 
    
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: New in SUBISO
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the SUBISO Onboarding when the status is New
  
       
Scenario: System Maker sees only the Cancel button when viewing in Status: New in SUBISO

    Given I am searching in the SUBISO Onboarding with Status :New
    Then I click the View button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is New
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is New
    
Scenario: if i login as System Maker with Status: Inprogress should be able to see Create, View, and Close buttons in SUBISO
    Given I am searching in the SUBISO Onboarding with Status : Inprogress
    Then  Should be able to see the Create, View, and Close buttons in the SUBISO Onboarding when the status is Inprogress
    Then  Should not be able to see the Edit button in the SUBISO Onboarding when the status is Inprogress
    
    
Scenario: System Maker sees only the Cancel button when viewing in Status: Inprogress in SUBISO
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Inprogress
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Inprogress  
    
    
Scenario: if i login as System Maker with Status: Verified should be able to see Create, View, and Close buttons in SUBISO
    Given I am searching in the SUBISO Onboarding with Status : Verified
    Then  Should be able to see the Create, View, and Close buttons in the SUBISO Onboarding when the status is Verified
    Then  Should not be able to see the Edit button in the SUBISO Onboarding when the status is Verified
    
    
       
Scenario: System Maker sees only the Cancel button when viewing in Status: Verified in SUBISO
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Verified
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Verified 
    
 
Scenario: if i login as System Maker with Status: Draft should be able to see Create, View ,Edit and Close buttons in SUBISO
    Given I am searching in the SUBISO Onboarding with Status : Draft
    Then  Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is Draft
    
 
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Draft in SUBISO
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the SUBISO Onboarding when the status is Draft
   
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Draft in SUBISO

    Given I am searching in the SUBISO Onboarding with Status : Draft
    Then I click the View button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Draft
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Draft
   
   
Scenario: if i login as System Maker with Status: Referback should be able to see Create, View ,Edit and Close buttons in SUBISO
    Given I am searching in the SUBISO Onboarding with Status : Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is Referback
    
     
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Referback in SUBISO
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the SUBISO Onboarding when the status is Referback
     Then I Should not be able to see the Submit for Verification button in the SUBISO Onboarding when the status is Referback
       
       
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Referback in SUBISO

    Given I am searching in the SUBISO Onboarding with Status : Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Referback
 

 Scenario: if i login as System Maker with Status: Auto Referback should be able to see Create, View ,Edit and Close buttons in SUBISO
    Given I am searching in the SUBISO Onboarding with Status :Auto Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is Auto Referback
  
Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Auto Referback in SUBISO
  
    
    Then I click the Edit button
    Then should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the SUBISO Onboarding when the status is Auto Referback
  
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Auto Referback in SUBISO

    Given I am searching in the SUBISO Onboarding with Status :Auto Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Auto Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Auto Referback
   

Scenario: if i login as System Maker with Status: Approved should be able to see Create, View ,Edit and Close buttons in SUBISO
    Given I am searching in the SUBISO Onboarding with Status : Approved
    Then  Should be able to see the Create, View, Edit and Close buttons in the SUBISO Onboarding when the status is Approved
    
 
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Approved in SUBISO
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the SUBISO Onboarding when the status is Approved
    Then I Should not be able to see the Submit for Verification button in the SUBISO Onboarding when the status is Approved

Scenario: System Maker sees only the Cancel button when viewing in Status: Approved in SUBISO

    Given I am searching in the SUBISO Onboarding with Status : Approved
    Then I click the View button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Approved
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Approved


Scenario: if i login as System Maker with Status: Rejected should be able to see the Create, Edit and View buttons in SUBISO
    Given  I am searching in the SUBISO Onboarding with Status : Rejected
    Then   Should be able to see the Create , Edit and View buttons in the SUBISO Onboarding when the status is Rejected
    Then   Should not be able to see the Close buttons in the SUBISO Onboarding when the status is Rejected


 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Rejected in SUBISO
   
    Then I click the edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the SUBISO Onboarding when the status is New


Scenario: System Maker sees only the Cancel button when viewing in Status: Rejected in SUBISO
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Rejected
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Rejected 

 
Scenario: if i login as System Maker with Status: Closed should be able to see the Create, Edit and View buttons in SUBISO
    Given I am searching in the SUBISO Onboarding with Status : Closed
    Then  Should be able to see the Create,Edit and View buttons in the SUBISO Onboarding when the status is CLosed
    Then  Should not be able to see the Close button in the SUBISO Onboarding when the status is Closed   
    
    
   
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Closed in SUBISO
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the SUBISO Onboarding when the status is Closed
    Then I Should not be able to see the Submit for Verification button in the SUBISO Onboarding when the status is Closed
 
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Closed in SUBISO

    Given I am searching in the SUBISO Onboarding with Status : Closed
    Then I click the View button
    Then I should be able to see only the Cancel button in the SUBISO Onboarding when the status is Closed
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the SUBISO Onboarding when the status is Closed











Scenario: if i login as System Maker with Status: New should be able to see Create, View ,Edit and Close buttons in GroupMerchant
    Given I am searching in the GroupMerchant Onboarding with Status : New
    Then  Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is New
 
    
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: New in GroupMerchant
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the GroupMerchant Onboarding when the status is New
  
       
Scenario: System Maker sees only the Cancel button when viewing in Status: New in GroupMerchant

    Given I am searching in the GroupMerchant Onboarding with Status :New
    Then I click the View button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is New
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is New
    
Scenario: if i login as System Maker with Status: Inprogress should be able to see Create, View, and Close buttons in GroupMerchant
    Given I am searching in the GroupMerchant Onboarding with Status : Inprogress
    Then  Should be able to see the Create, View, and Close buttons in the GroupMerchant Onboarding when the status is Inprogress
    Then  Should not be able to see the Edit button in the GroupMerchant Onboarding when the status is Inprogress
    
    
Scenario: System Maker sees only the Cancel button when viewing in Status: Inprogress in GroupMerchant
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Inprogress
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Inprogress  
    
    
Scenario: if i login as System Maker with Status: Verified should be able to see Create, View, and Close buttons in GroupMerchant
    Given I am searching in the GroupMerchant Onboarding with Status : Verified
    Then  Should be able to see the Create, View, and Close buttons in the GroupMerchant Onboarding when the status is Verified
    Then  Should not be able to see the Edit button in the GroupMerchant Onboarding when the status is Verified
    
    
       
Scenario: System Maker sees only the Cancel button when viewing in Status: Verified in GroupMerchant
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Verified
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Verified 
    
 
Scenario: if i login as System Maker with Status: Draft should be able to see Create, View ,Edit and Close buttons in GroupMerchant
    Given I am searching in the GroupMerchant Onboarding with Status : Draft
    Then  Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is Draft
    
 
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Draft in GroupMerchant
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Draft
   
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Draft in GroupMerchant

    Given I am searching in the GroupMerchant Onboarding with Status : Draft
    Then I click the View button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Draft
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Draft
   
   
Scenario: if i login as System Maker with Status: Referback should be able to see Create, View ,Edit and Close buttons in GroupMerchant
    Given I am searching in the GroupMerchant Onboarding with Status : Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is Referback
    
     
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Referback in GroupMerchant
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the GroupMerchant Onboarding when the status is Referback
     Then I Should not be able to see the Submit for Verification button in the GroupMerchant Onboarding when the status is Referback
       
       
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Referback in GroupMerchant

    Given I am searching in the GroupMerchant Onboarding with Status : Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Referback
 

 Scenario: if i login as System Maker with Status: Auto Referback should be able to see Create, View ,Edit and Close buttons in GroupMerchant
    Given I am searching in the GroupMerchant Onboarding with Status :Auto Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is Auto Referback
  
Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Auto Referback in GroupMerchant
  
    
    Then I click the Edit button
    Then should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Auto Referback
  
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Auto Referback in GroupMerchant

    Given I am searching in the GroupMerchant Onboarding with Status :Auto Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Auto Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Auto Referback
   

Scenario: if i login as System Maker with Status: Approved should be able to see Create, View ,Edit and Close buttons in GroupMerchant
    Given I am searching in the GroupMerchant Onboarding with Status : Approved
    Then  Should be able to see the Create, View, Edit and Close buttons in the GroupMerchant Onboarding when the status is Approved
    
 
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Approved in GroupMerchant
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the GroupMerchant Onboarding when the status is Approved
    Then I Should not be able to see the Submit for Verification button in the GroupMerchant Onboarding when the status is Approved

Scenario: System Maker sees only the Cancel button when viewing in Status: Approved in GroupMerchant

    Given I am searching in the GroupMerchant Onboarding with Status : Approved
    Then I click the View button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Approved
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Approved


Scenario: if i login as System Maker with Status: Rejected should be able to see the Create, Edit and View buttons in GroupMerchant
    Given  I am searching in the GroupMerchant Onboarding with Status : Rejected
    Then   Should be able to see the Create , Edit and View buttons in the GroupMerchant Onboarding when the status is Rejected
    Then   Should not be able to see the Close buttons in the GroupMerchant Onboarding when the status is Rejected


 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Rejected in GroupMerchant
   
    Then I click the edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the GroupMerchant Onboarding when the status is New


Scenario: System Maker sees only the Cancel button when viewing in Status: Rejected in GroupMerchant
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Rejected
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Rejected 

 
Scenario: if i login as System Maker with Status: Closed should be able to see the Create, Edit and View buttons in GroupMerchant
    Given I am searching in the GroupMerchant Onboarding with Status : Closed
    Then  Should be able to see the Create,Edit and View buttons in the GroupMerchant Onboarding when the status is CLosed
    Then  Should not be able to see the Close button in the GroupMerchant Onboarding when the status is Closed   
    
    
   
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Closed in GroupMerchant
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the GroupMerchant Onboarding when the status is Closed
    Then I Should not be able to see the Submit for Verification button in the GroupMerchant Onboarding when the status is Closed
 
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Closed in GroupMerchant

    Given I am searching in the GroupMerchant Onboarding with Status : Closed
    Then I click the View button
    Then I should be able to see only the Cancel button in the GroupMerchant Onboarding when the status is Closed
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the GroupMerchant Onboarding when the status is Closed










Scenario: if i login as System Maker with Status: New should be able to see Create, View ,Edit and Close buttons in Merchant
    Given I am searching in the Merchant Onboarding with Status : New
    Then  Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is New
 
    
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: New in Merchant
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Merchant Onboarding when the status is New
  
       
Scenario: System Maker sees only the Cancel button when viewing in Status: New in Merchant

    Given I am searching in the Merchant Onboarding with Status :New
    Then I click the View button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is New
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is New
    
Scenario: if i login as System Maker with Status: Inprogress should be able to see Create, View, and Close buttons in Merchant
    Given I am searching in the Merchant Onboarding with Status : Inprogress
    Then  Should be able to see the Create, View, and Close buttons in the Merchant Onboarding when the status is Inprogress
    Then  Should not be able to see the Edit button in the Merchant Onboarding when the status is Inprogress
    
    
Scenario: System Maker sees only the Cancel button when viewing in Status: Inprogress in Merchant
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is Inprogress
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Inprogress  
    
    
Scenario: if i login as System Maker with Status: Verified should be able to see Create, View, and Close buttons in Merchant
    Given I am searching in the Merchant Onboarding with Status : Verified
    Then  Should be able to see the Create, View, and Close buttons in the Merchant Onboarding when the status is Verified
    Then  Should not be able to see the Edit button in the Merchant Onboarding when the status is Verified
    
    
       
Scenario: System Maker sees only the Cancel button when viewing in Status: Verified in Merchant
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is Verified
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Verified 
    
 
Scenario: if i login as System Maker with Status: Draft should be able to see Create, View ,Edit and Close buttons in Merchant
    Given I am searching in the Merchant Onboarding with Status : Draft
    Then  Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is Draft
    
 
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Draft in Merchant
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Merchant Onboarding when the status is Draft
   
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Draft in Merchant

    Given I am searching in the Merchant Onboarding with Status : Draft
    Then I click the View button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is Draft
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Draft
   
   
Scenario: if i login as System Maker with Status: Referback should be able to see Create, View ,Edit and Close buttons in Merchant
    Given I am searching in the Merchant Onboarding with Status : Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is Referback
    
     
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Referback in Merchant
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Merchant Onboarding when the status is Referback
     Then I Should not be able to see the Submit for Verification button in the Merchant Onboarding when the status is Referback
       
       
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Referback in Merchant

    Given I am searching in the Merchant Onboarding with Status : Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Referback
 

 Scenario: if i login as System Maker with Status: Auto Referback should be able to see Create, View ,Edit and Close buttons in Merchant
    Given I am searching in the Merchant Onboarding with Status :Auto Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is Auto Referback
  
Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Auto Referback in Merchant
  
    
    Then I click the Edit button
    Then should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Merchant Onboarding when the status is Auto Referback
  
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Auto Referback in Merchant

    Given I am searching in the Merchant Onboarding with Status :Auto Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is Auto Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Auto Referback
   

Scenario: if i login as System Maker with Status: Approved should be able to see Create, View ,Edit and Close buttons in Merchant
    Given I am searching in the Merchant Onboarding with Status : Approved
    Then  Should be able to see the Create, View, Edit and Close buttons in the Merchant Onboarding when the status is Approved
    
 
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Approved in Merchant
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Merchant Onboarding when the status is Approved
    Then I Should not be able to see the Submit for Verification button in the Merchant Onboarding when the status is Approved

Scenario: System Maker sees only the Cancel button when viewing in Status: Approved in Merchant

    Given I am searching in the Merchant Onboarding with Status : Approved
    Then I click the View button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is Approved
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Approved


Scenario: if i login as System Maker with Status: Rejected should be able to see the Create, Edit and View buttons in Merchant
    Given  I am searching in the Merchant Onboarding with Status : Rejected
    Then   Should be able to see the Create , Edit and View buttons in the Merchant Onboarding when the status is Rejected
    Then   Should not be able to see the Close buttons in the Merchant Onboarding when the status is Rejected


 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Rejected in Merchant
   
    Then I click the edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Merchant Onboarding when the status is New


Scenario: System Maker sees only the Cancel button when viewing in Status: Rejected in Merchant
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is Rejected
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Rejected 

 
Scenario: if i login as System Maker with Status: Closed should be able to see the Create, Edit and View buttons in Merchant
    Given I am searching in the Merchant Onboarding with Status : Closed
    Then  Should be able to see the Create,Edit and View buttons in the Merchant Onboarding when the status is CLosed
    Then  Should not be able to see the Close button in the Merchant Onboarding when the status is Closed   
    
    
   
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Closed in Merchant
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Merchant Onboarding when the status is Closed
    Then I Should not be able to see the Submit for Verification button in the Merchant Onboarding when the status is Closed
 
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Closed in Merchant

    Given I am searching in the Merchant Onboarding with Status : Closed
    Then I click the View button
    Then I should be able to see only the Cancel button in the Merchant Onboarding when the status is Closed
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Merchant Onboarding when the status is Closed










Scenario: if i login as System Maker with Status: New should be able to see Create, View ,Edit and Close buttons in Terminal
    Given I am searching in the Terminal Onboarding with Status : New
    Then  Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is New
 
    
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: New in Terminal
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Terminal Onboarding when the status is New
  
       
Scenario: System Maker sees only the Cancel button when viewing in Status: New in Terminal

    Given I am searching in the Terminal Onboarding with Status :New
    Then I click the View button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is New
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is New
    
Scenario: if i login as System Maker with Status: Inprogress should be able to see Create, View, and Close buttons in Terminal
    Given I am searching in the Terminal Onboarding with Status : Inprogress
    Then  Should be able to see the Create, View, and Close buttons in the Terminal Onboarding when the status is Inprogress
    Then  Should not be able to see the Edit button in the Terminal Onboarding when the status is Inprogress
    
    
Scenario: System Maker sees only the Cancel button when viewing in Status: Inprogress in Terminal
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is Inprogress
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Inprogress  
    
    
Scenario: if i login as System Maker with Status: Verified should be able to see Create, View, and Close buttons in Terminal
    Given I am searching in the Terminal Onboarding with Status : Verified
    Then  Should be able to see the Create, View, and Close buttons in the Terminal Onboarding when the status is Verified
    Then  Should not be able to see the Edit button in the Terminal Onboarding when the status is Verified
    
    
       
Scenario: System Maker sees only the Cancel button when viewing in Status: Verified in Terminal
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is Verified
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Verified 
    
 
Scenario: if i login as System Maker with Status: Draft should be able to see Create, View ,Edit and Close buttons in Terminal
    Given I am searching in the Terminal Onboarding with Status : Draft
    Then  Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is Draft
    
 
 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Draft in Terminal
    Then I click the Edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Terminal Onboarding when the status is Draft
   
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Draft in Terminal

    Given I am searching in the Terminal Onboarding with Status : Draft
    Then I click the View button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is Draft
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Draft
   
   
Scenario: if i login as System Maker with Status: Referback should be able to see Create, View ,Edit and Close buttons in Terminal
    Given I am searching in the Terminal Onboarding with Status : Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is Referback
    
     
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Referback in Terminal
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Terminal Onboarding when the status is Referback
     Then I Should not be able to see the Submit for Verification button in the Terminal Onboarding when the status is Referback
       
       
     
Scenario: System Maker sees only the Cancel button when viewing in Status: Referback in Terminal

    Given I am searching in the Terminal Onboarding with Status : Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Referback
 

 Scenario: if i login as System Maker with Status: Auto Referback should be able to see Create, View ,Edit and Close buttons in Terminal
    Given I am searching in the Terminal Onboarding with Status :Auto Referback
    Then  Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is Auto Referback
  
Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Auto Referback in Terminal
  
    
    Then I click the Edit button
    Then should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Terminal Onboarding when the status is Auto Referback
  
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Auto Referback in Terminal

    Given I am searching in the Terminal Onboarding with Status :Auto Referback
    Then I click the View button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is Auto Referback
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Auto Referback
   

Scenario: if i login as System Maker with Status: Approved should be able to see Create, View ,Edit and Close buttons in Terminal
    Given I am searching in the Terminal Onboarding with Status : Approved
    Then  Should be able to see the Create, View, Edit and Close buttons in the Terminal Onboarding when the status is Approved
    
 
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Approved in Terminal
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Terminal Onboarding when the status is Approved
    Then I Should not be able to see the Submit for Verification button in the Terminal Onboarding when the status is Approved

Scenario: System Maker sees only the Cancel button when viewing in Status: Approved in Terminal

    Given I am searching in the Terminal Onboarding with Status : Approved
    Then I click the View button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is Approved
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Approved


Scenario: if i login as System Maker with Status: Rejected should be able to see the Create, Edit and View buttons in Terminal
    Given  I am searching in the Terminal Onboarding with Status : Rejected
    Then   Should be able to see the Create , Edit and View buttons in the Terminal Onboarding when the status is Rejected
    Then   Should not be able to see the Close buttons in the Terminal Onboarding when the status is Rejected


 Scenario: System Maker sees Cancel, Save as Draft, and Submit for Verification buttons when editing in Status: Rejected in Terminal
   
    Then I click the edit button
    Then I should be able to see the Cancel, Save as Draft, and Submit for Verification buttons in the Terminal Onboarding when the status is New


Scenario: System Maker sees only the Cancel button when viewing in Status: Rejected in Terminal
    
    Then I click the view button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is Rejected
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Rejected 

 
Scenario: if i login as System Maker with Status: Closed should be able to see the Create, Edit and View buttons in Terminal
    Given I am searching in the Terminal Onboarding with Status : Closed
    Then  Should be able to see the Create,Edit and View buttons in the Terminal Onboarding when the status is CLosed
    Then  Should not be able to see the Close button in the Terminal Onboarding when the status is Closed   
    
    
   
 Scenario: System Maker sees Cancel and Save as Draft buttons when editing in Status: Closed in Terminal
    Then I click the Edit button
    Then I should be able to see the Cancel and Save as Draft buttons in the Terminal Onboarding when the status is Closed
    Then I Should not be able to see the Submit for Verification button in the Terminal Onboarding when the status is Closed
 
      
Scenario: System Maker sees only the Cancel button when viewing in Status: Closed in Terminal

    Given I am searching in the Terminal Onboarding with Status : Closed
    Then I click the View button
    Then I should be able to see only the Cancel button in the Terminal Onboarding when the status is Closed
    Then I Should not be able to see the Save as Draft and Submit for Verification buttons in the Terminal Onboarding when the status is Closed







