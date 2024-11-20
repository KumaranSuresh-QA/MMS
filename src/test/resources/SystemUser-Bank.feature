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
Feature: System Users - Bank Onboarding Regression

 This feature aims to test the functionality of the 'BankOnboarding' within the application.

@run @loadData
Scenario: SystemMaker Login
 Given I visit the System Maker Login using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button
 
Scenario: System Maker sees Onboarding in Sidemenu
   When System Maker - Onboarding should be displayed in the side menu
    

Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

Scenario: SystemMaker clicks the bank module
    When the SystemMaker clicks the bank module
   

Scenario: SystemMaker clicks the Create Button
    When the SystemMaker clicks the Create Button
    

 Scenario: Visiting the General Info in Bank Onboarding
    When I Visit the General Info


Scenario: the "Bank Name" field should prompt to enter valid inputs in Bank Onboarding
      Then the "Bank Name" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0

     
Scenario: the "Address" field should prompt to enter valid inputs in Bank Onboarding     
      Then the "Address" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
 
       
Scenario: the "Pincode" field should prompt to select valid inputs in Bank Onboarding     
      Then the "Pincode" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
      
Scenario: the "GST" field should prompt to enter valid inputs in Bank Onboarding     
      Then the "GST" field should prompt to enter valid inputs with GST format using sheetname "Bank Regression" and rownumber 0
       
Scenario: the "PAN" field should prompt to enter valid inputs in Bank Onboarding      
      Then the "PAN" field should prompt to enter valid inputs with PAN format using sheetname "Bank Regression" and rownumber 0
       
Scenario: the "MarsId" field should prompt to enter valid inputs in Bank Onboarding    
      Then the "MarsId" field	should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
       
 Scenario: the "Statement Frequency" field should prompt to select valid inputs in Bank Onboarding    
      Then the "Statement Frequency" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
        
 Scenario: the "Statement Type" field should prompt to select valid inputs in Bank Onboarding          
      Then the "Statement Type" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
        
Scenario: the "Domain" field should prompt to enter valid inputs in Bank Onboarding      
      Then the "Domain" field should prompt to enter the valid domain name using sheetname "Bank Regression" and rownumber 0
      Then the "Domain" field should prompt to enter the valid domain name using sheetname "Bank Regression" and rownumber 1
      Then the "Domain" field should prompt to enter the valid domain name using sheetname "Bank Regression" and rownumber 2
       
Scenario: the "NextStep" field should should be prompted to click on General Info       
      Then the "NextStep" button should be prompted to click on General Info
      
   

Scenario: Visiting the Communication Info in Bank Onboarding
    When I visit the Communication Info
    
Scenario: the "Add" button should be prompted to click in Bank Onboarding      
    Then the "Add" button should be prompted to click
    
Scenario: the "Name" field should prompt to enter valid inputs in Bank Onboarding    
    Then the "Name" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    
Scenario: the "Position" field should prompt to enter valid inputs in Bank Onboarding
    Then the "Position" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    
Scenario: the "Mobile Number" field should prompt to enter valid inputs in Bank Onboarding    
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0 
    
Scenario: the "Email ID" field should prompt to enter valid inputs in Bank Onboarding    
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
    
Scenario: the "AD User" field should prompt to select Yes or No based on the given input in Bank Onboarding    
    Then the "AD User" field should prompt to select Yes or No based on the given input using sheetname "Bank Regression" and rownumber 0
    
Scenario: the "Save" button should be prompted to click on Communication Info in Bank Onboarding     
    Then the "Save" button should be prompted to click on Communication Info
    
Scenario: the "NextStep" button should prompt a click on Communication Info in Bank Onboarding    
    Then The "NextStep" button should prompt a click on Communication Info
    


Scenario: Visiting the "Channel Config" in Bank Onboarding
     When I visit the Channel Config
     
Scenario: the Channel Bank Onboarding should prompt users to enter valid inputs in Bank Onboarding              
     Then the Channel Bank Onboarding should prompt users to enter valid inputs using the sheet name "Channel Bank"
     
Scenario: the "NextStep" button should be prompted to click on channel config in Bank Onboarding     
     Then the "NextStep" button should be prompted to click on channel config
     
 
Scenario: Visiting the ONUS Routing in Bank Onboarding
     When I visit the ONUS Routing
     
Scenario: the "POS ADD BIN" field should prompt to select the Bin based on the given input in Bank Onboarding        
     Then the "POS ADD BIN" field should prompt to select the Bin based on the given input using sheetname "Channel Bank" and rownumber 0
     
Scenario: the "MATM ADD BIN" field should prompt to select the Bin based on the given input in Bank Onboarding     
     Then the "MATM ADD BIN" field should prompt to select the Bin based on the given input using sheetname "Channel Bank" and rownumber 0
     
Scenario: the "NextStep" button should be prompted to click on ONUS Routing in Bank Onboarding     
     Then the "NextStep" button should be prompted to click on ONUS Routing
     
     
    Scenario: Visiting the "Global FRM" in Bank Onboarding
    When I visit the Global FRM
     
    Scenario: the GlobalFRMcheckbox should be checked in Bank Onboarding
    Then the GlobalFRMcheckbox should be checked
    
    Scenario: the "Velocity Check Minutes" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "Velocity Check Minutes" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "Velocity Check Count" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "Velocity Check Count" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "Cash@POS Count" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "Cash@POS Count" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "Micro ATM Count" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "Micro ATM Count" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "International Card Acceptence" field should prompt to select the Yes or No based on the given input in Bank Onboarding 
    Then the "International Card Acceptence" field should prompt to select the Yes or No based on the given input using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "ICA Daily" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "ICA Daily" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "ICA Weekly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "ICA Weekly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "ICA Monthly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "ICA Monthly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "POS Daily" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "POS Daily" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "POS Weekly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "POS Weekly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "POS Monthly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "POS Monthly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "POS Minimum" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "POS Minimum" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "POS Maximum" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "POS Maximum" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "UPI Daily" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "UPI Daily" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "UPI Weekly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "UPI Weekly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "UPI Monthly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "UPI Monthly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "UPI Minimum" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "UPI Minimum" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "UPI Maximum" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "UPI Maximum" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "AEPS Daily" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "AEPS Daily" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "AEPS Weekly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "AEPS Weekly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "AEPS Monthly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "AEPS Monthly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "AEPS Minimum" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "AEPS Minimum" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "AEPS Maximum" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "AEPS Maximum" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "MATM Daily" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "MATM Daily" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "MATM Weekly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "MATM Weekly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "MATM Monthly" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "MATM Monthly" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "MATM Minimum" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "MATM Minimum" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "MATM Maximum" field should prompt to enter the valid inputs in Bank Onboarding 
    Then the "MATM Maximum" field should prompt to enter the valid inputs using sheetname "Bank Regression" and rownumber 0
    
    Scenario: the "NextStep" button should be prompted to click on Global FRM in Bank Onboarding 
    Then the "NextStep" button should be prompted to click on Global FRM
     
     
     
Scenario: I visit the Commercial in Bank Onboarding 
      When I visit the Commercial 

Scenario: the Commercial "Interchange Plan" should prompt users to enter valid inputs in Bank Onboarding
      Then the Commercial "Interchange Plan" should prompt users to enter valid inputs using the sheet name "Commercial"
      
      Scenario: the Commercial "Bank Onboarding" should prompt users to enter valid inputs in Bank Onboarding
      Then the Commercial "Bank Onboarding" should prompt users to enter valid inputs using the sheet name "Commercial"
      
      Scenario: the "NextStep" button should be prompted to click on Commercial in Bank Onboarding
      Then the "NextStep" button should be prompted to click on Commercial
 
     
      Scenario: I visit the Settlement Info in Bank Onboarding in Bank Onboarding
       When I visit the Settlement Info
       
       Scenario: the Settlement Info "ADD" button should be prompted to click in Bank Onboarding       
       Then the Settlement Info "ADD" button should be prompted to click
       
       Scenario: the Settlement Info "Channel" dropdown should prompt to select the valid inputs in Bank Onboarding
       Then the Settlement Info "Channel" dropdown should prompt to select the valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Settlement Info "Account Type" dropdown should prompt to select the valid inputs in Bank Onboarding
       Then the Settlement Info "Account Type" dropdown should prompt to select the valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Settlement Info "Bank Account Number" field should prompt to enter valid inputs in Bank Onboarding
       Then the Settlement Info "Bank Account Number" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs in Bank Onboarding
       Then the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the SettlementInfo "Save" button should be prompted to click in Bank Onboarding
       Then the SettlementInfo "Save" button should be prompted to click
       
       Scenario: the Settlement Info "Settlement Type" dropdown should prompt to select valid inputs in Bank Onboarding 
       Then the Settlement Info "Settlement Type" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the "NextStep" button should be prompted to click on Settlement Info in Bank Onboarding
       Then the "NextStep" button should be prompted to click on Settlement Info
       
      
Scenario: I visit the Whitelabel in Bank Onboarding
       When I visit the Whitelabel
       
       Scenario: the Whitelabel "BankOwnDeployment" dropdown should prompt to select valid inputs in Bank Onboarding
       Then the Whitelabel "BankOwnDeployment" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Whitelabel "Payfac Onboarding" dropdown should prompt to select valid inputs in Bank Onboarding
       Then the Whitelabel "Payfac Onboarding" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Whitelabel "ISO Onboarding" dropdown should prompt to select valid inputs in Bank Onboarding
       Then the Whitelabel "ISO Onboarding" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Whitelabel "Sales Team Onboarding" dropdown should prompt to select valid inputs in Bank Onboarding
       Then the Whitelabel "Sales Team Onboarding" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Whitelabel "Max Number of platform" field should prompt to enter valid inputs in Bank Onboarding
       Then the Whitelabel "Max Number of platform" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the "NextStep" button should be prompted to click on WHiteLabel in Bank Onboarding
       Then the "NextStep" button should be prompted to click on WHiteLabel

    
Scenario: I visit the Webhooks in Bank Onboarding
       When I visit the Webhooks
      
       Scenario: the Webhooks "Add" button should be prompted to click in Bank Onboarding
       Then the Webhooks "Add" button should be prompted to click
       
       Scenario: the Webhooks "Webhook Type" dropdown should prompt to select valid inputs in Bank Onboarding
       Then the Webhooks "Webhook Type" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Webhooks "Webhook URL" field should prompt to enter valid inputs in Bank Onboarding
        Then the Webhooks "Webhook URL" field should prompt to enter valid inputs using sheetname "Bank Regression" and rownumber 0
       
       Scenario: the Webhooks "Save" button should be prompted to click in Bank Onboarding
       Then the Webhooks "Save" button should be prompted to click
       
       Scenario: the "NextStep" button should be prompted to click on Webhooks in Bank Onboarding
       Then the "NextStep" button should be prompted to click on Webhooks
    
       
Scenario: I visit the KYC Config
     When I visit the KYC Config

   
     Scenario: the KYC Config "Add" button should be prompted to click in Bank Onboarding
     Then the KYC Config "Add" button should be prompted to click
 
    
     Scenario: the KYC Config "Business Type" dropdown should prompt to select valid inputs in Bank Onboarding
     Then the KYC Config "Business Type" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
   
    
     Scenario: the Company KYC "Proof of Identity" dropdown should prompt to select valid inputs in Bank Onboarding
     Then the Company KYC "Proof of Identity" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     
     
     Scenario: the Individual "Proof of Identity" dropdown should prompt to select valid inputs in Bank Onboarding
     Then the Individual "Proof of Identity" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     
     
     Scenario: the Individual "Proof of Address" dropdown should prompt to select valid inputs in Bank Onboarding
     Then the Individual "Proof of Address" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     
     
     Scenario: the Individual "Bank Documents" dropdown should prompt to select valid inputs in Bank Onboarding
     Then the Individual "Bank Document" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     
     
     Scenario: the Individual "Tax Documents" dropdown should prompt to select valid inputs in Bank Onboarding
     Then the Individual "Tax Document" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     
     Scenario: the Individual "Other Documents" dropdown should prompt to select valid inputs in Bank Onboarding
     Then the Individual "Other Document" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     
     Scenario: the KYC "Save" button should be prompted to click in Bank Onboarding
     Then the KYC "Save" button should be prompted to click
     @run
     Scenario: the "NextStep" button should be prompted to click on KYC in Bank Onboarding
     Then the "NextStep" button should be prompted to click on KYC
     
     
    
     

  
  Scenario: System Maker submits the application for verification in Bank Onboarding
  When the System Maker clicks the "Submit for verification" button

Scenario: System Maker confirms submission by clicking the "Yes" button in Bank Onboarding
  When the System Maker clicks the "Yes" button to confirm submission
  

Scenario: System Maker logs out by clicking profile and log-out button in Bank Onboarding
  When the System Maker clicks on the profile and log-out button

Scenario: System Maker handles the pop-up and is redirected to the login page in Bank Onboarding
  When the System Maker handles the pop-up by selecting the "Yes" button and redirected to login page
  
  

Scenario: System verifier Login
 Given I visit the System Verifier Login using sheetname "Credentials" and rownumber 2
 And I enter the credentials and click a login button
    
  	 
Scenario: System Verifier sees Onboarding in Sidemenu
   When System Verifier - Onboarding should be displayed in the side menu
    

Scenario: System Verifier sees side menu items in Onboarding
  Then the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Verifier clicks the bank module
    When the System Verifier clicks the bank module
   

 Scenario: System Verifier Ensure the Bank Status - Inprogress
    When the System Verifier ensure the bank status "Inprogress" using sheetname "Bank Regression" and rownumber 0
  
 
Scenario: System Verifier - click on action (Three dot button) and select the view option
    When the System Verifier click on action Three dot button and select the view option
  
 
  Scenario: System Verifier checks "General Info" and clicks "Verified and Next"
  When the System Verifier checks "General Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons


  Scenario: System Verifier checks "Communication Info" and clicks "Verified and Next"
  When the System Verifier checks "Communication Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
   
  
  Scenario: System Verifier checks "Channel Config" and clicks "Verified and Next"
  When the System Verifier checks "Channel Config" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "ONUS Routing" and clicks "Verified and Next"
  When the System Verifier checks "ONUS Routing" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Global FRM" and clicks "Verified and Next"
  When the System Verifier checks "Global FRM" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Commercial" and clicks "Verified and Next"
  When the System Verifier checks "Commerical" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Settlement Info" and clicks "Verified and Next"
  When the System Verifier checks "Settlement Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "WhiteLabel" and clicks "Verified and Next"
  When the System Verifier checks "WhiteLabel" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Webhooks" and clicks "Verified and Next"
  When the System Verifier checks "Webhooks" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "KYC" and clicks "Verified and Next"
  When the System Verifier checks "KYC" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System verifier submits the application for Approval
  When the System verifier clicks the "Submit for Approval" button

  
  Scenario: System verifier confirms submission by clicking the "Yes" button
  When the System verifier clicks the "Yes" button to confirm submission
  
 
  Scenario: System verifier logs out by clicking profile and log-out button
  When the System verifier clicks on the profile and log-out button

 
  Scenario: System Verifier handles the pop-up and is redirected to the login page
  When the System verifier handles the pop-up by selecting the "Yes" button and redirected to login page
  
  
  
Scenario: System Approver Login
  Given I visit the System Approver Login using sheetname "Credentials" and rownumber 3
  And I enter the credentials and click a login button
   
  
 
  Scenario: System Approver sees Onboarding in Sidemenu
   When System Approver - Onboarding should be displayed in the side menu
    
 
Scenario: System Approver sees side menu items in Onboarding
  Then the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Approver clicks the bank module
    When the System Approver clicks the bank module
   
 
 Scenario: System Approver Ensure the Bank Status - Inprogress
    When the System Approver ensure the bank status "Inprogress" using sheetname "Bank Regression" and rownumber 0
  
  
Scenario: System Approver - click on action (Three dot button) and select the view option
    When the System Approver click on action Three dot button and select the view option
    
  
  Scenario: System Approver checks if "General Info" is verified and clicks "NextStep" button
  When the System Approver check if "General Info" is verified and clicks the "NextStep" button  
  
  
  Scenario: System Approver checks if "Communication Info" is verified and clicks "NextStep" button
  When the System Approver check if "Communication Info" is verified and clicks the "NextStep" button
  
  
  Scenario: System Approver checks if "Channel Config" is verified and clicks "NextStep" button
        When the System Approver check if "Channel Config" is verified and clicks the "NextStep" button
        

  Scenario: System Approver checks if "ONUS Routing" is verified and clicks "NextStep" button
        When the System Approver check if "ONUS Routing" is verified and clicks the "NextStep" button
        

  Scenario: System Approver checks if "Global FRM" is verified and clicks "NextStep" button
        When the System Approver check if "Global FRM" is verified and clicks the "NextStep" button
        

  Scenario: System Approver checks if "Commercial" is verified and clicks "NextStep" button
        When the System Approver check if "Commercial" is verified and clicks the "NextStep" button   
        
        
  Scenario: System Approver checks if "Settlement Info" is verified and clicks "NextStep" button
        When the System Approver check if "Settlement Info" is verified and clicks the "NextStep" button
        
        
  Scenario: System Approver checks if "Whitelabel" is verified and clicks "NextStep" button
        When the System Approver check if "Whitelabel" is verified and clicks the "NextStep" button
        
       
  Scenario: System Approver checks if "Webhooks" is verified and clicks "NextStep" button
        When the System Approver check if "Webhooks" is verified and clicks the "NextStep" button
        
         
  Scenario: System Approver checks if "KYC" is verified and clicks "NextStep" button
        When the System Approver check if "KYC" is verified and clicks the "NextStep" button     
        
       
  Scenario: System Approver submits the application for Approve
  When the System Approver clicks the "Submit for Approve" button


  Scenario: System Approver confirms submission by clicking the "Yes" button
     When the System Approver clicks the "Yes" button to confirm submission
   
     
   Scenario: Verify that Bank CPID is generated after changing the status to Approved
    When Verify that Bank CPID is displayed correctly on the "Bank Onboarding List page" using sheetname "Bank Regression" and rownumber 0 
  

  Scenario: System Approver logs out by clicking profile and log-out button
     When the System Approver clicks on the profile and log-out button

   Scenario: System Approver handles the pop-up and is redirected to the login page
      When the System Approver handles the pop-up by selecting the "Yes" button and redirected to login page   
        
  
    
       
