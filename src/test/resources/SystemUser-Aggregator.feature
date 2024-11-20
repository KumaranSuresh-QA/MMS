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

 This feature aims to test the functionality of the 'AggregatorOnboarding' within the application.
 
 
@run @loadData
Scenario: SystemMaker Login
 Given I visit the System Maker Login using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button


 Scenario: System Maker sees Onboarding in Sidemenu
   When System Maker - Onboarding should be displayed in the side menu



Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
  

Scenario: SystemMaker clicks the Aggregator module
    When the SystemMaker clicks the Aggregator module


Scenario: SystemMaker clicks the Create Button
    When the SystemMaker clicks the Create Button




     Scenario: I Visit the Sales Info in Aggregator Onboarding 
     When I Visit the Sales Info

     Scenario: the First "VAS Commission" field should prompt to select Yes or No based on the given input in Aggregator Onboarding
     Then the First "VAS Commission" field should prompt to select Yes or No based on the given input using sheetname "Aggregator" and rownumber 0
     
     Scenario: the user select a valid date in the "Aggregator Application Date" field in Aggregator Onboarding
     When the user select a valid date in the "Aggregator Application Date" field
     
     Scenario: the user select a valid date in the "Agreement Date" field in Aggregator Onboarding
     When the user select a valid date in the "Agreement Date" field
     
     Scenario: the "Aggregator Code" field should prompt to enter valid inputs in Aggregator Onboarding
     Then the "Aggregator Code" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     #Scenario: the "IS TMS Aggregator" field should prompt to select Yes or No based on the given input in Aggregator Onboarding
     #Then the "IS TMS Aggregator" field should prompt to select Yes or No based on the given input using sheetname "Aggregator Regression" and rownumber 0
     #
     Scenario: the "EKyc Required" field should prompt to select Yes or No based on the given input in Aggregator Onboarding
     Then the "EKyc Required" field should prompt to select Yes or No based on the given input using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "NextStep" button should be prompted to click on Sales Info in Aggregator Onboarding
     Then the "NextStep" button should be prompted to click on Sales Info


      Scenario: I Visit the Company Info in Aggregator Onboarding 
      When I Visit the Company Info
     
     Scenario: the "Legal Name" field should prompt to enter valid inputs in Aggregator Onboarding    
     Then the "Legal Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "Brand Name" field should prompt to enter valid inputs in Aggregator Onboarding
     Then the "Brand Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "Registered Address" field should prompt to enter valid inputs within 230 characters in Aggregator Onboarding
     Then the "Registered Address" field should prompt to enter valid inputs within 230 characters using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "Registered Pincode" dropdown should prompt to select valid inputs in Aggregator Onboarding
     Then the "Registered Pincode" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "Business Type" dropdown should prompt to select valid inputs in Aggregator Onboarding
     Then the "Business Type" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the user selects a valid date in the "Established Year" field in Aggregator Onboarding
     When the user selects a valid date in the "Established Year" field
     
     Scenario: the "Registered Number" field should prompt to enter valid inputs in Aggregator Onboarding
     Then the "Registered Number" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "Company PAN" field should prompt to enter valid inputs in Aggregator Onboarding
     Then the "Company PAN" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "GSTIN" field should prompt to enter valid inputs in Aggregator Onboarding
     Then the "GSTIN" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "Statement Frequency" dropdown should prompt to select valid inputs in Company Info in Aggregator Onboarding
     Then the "Statement Frequency" dropdown should prompt to select valid inputs in Company Info using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "Statement Type" dropdown should prompt to select valid inputs on Company Info in Aggregator Onboarding
     Then the "Statement Type" dropdown should prompt to select valid inputs in Company Info using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "Email Domain" field should prompt to enter valid inputs in Aggregator Onboarding
     Then the "Email Domain" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "NextStep" button should be prompted to click on Company Info in Aggregator Onboarding
     Then the "NextStep" button should be prompted to click on Company Info
  
     
      Scenario: I visit the Personal Info in Aggregator Onboarding
          When I visit the Personal Info
         
     Scenario: the "Add" button should be prompted to click on personal info in Aggregator Onboarding      
          Then the "Add" button should be prompted to click in personal info
          
      Scenario: the "Title" dropdown should prompt to select valid inputs on Personal Info in Aggregator Onboarding    
          Then the "Title" dropdown should prompt to select valid inputs in Personal Info using sheetname "Aggregator Regression" and rownumber 0
          
      Scenario: the "First Name" field should prompt to enter valid inputs in Aggregator Onboarding
          Then the "First Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
       
       Scenario: the "Last Name" field should prompt to enter valid inputs in Aggregator Onboarding
          Then the "Last Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
          
        Scenario: the user select a valid date in the "Date Of Birth" field on Personal Info in Aggregator Onboarding
          When the user select a valid date in the "Date Of Birth" field in Personal Info
          
          Scenario: the "PAN" field should prompt to enter valid inputs with PAN Format on Personal Info in Aggregator Onboarding
          Then the "PAN" field should prompt to enter valid inputs with PAN Format in Personal Info using sheetname "Aggregator Regression" and rownumber 0  
          
          Scenario: the "Address" field should prompt to enter valid inputs within 230 characters on personal info in Aggregator Onboarding
          Then the "Address" field should prompt to enter valid inputs within 230 characters in personal info using sheetname "Aggregator Regression" and rownumber 0
          
          Scenario: the "Pincode" dropdown should prompt to select valid inputs on Personal Info in Aggregator Onboarding
          Then the "Pincode" dropdown should prompt to select valid inputs in Personal Info using sheetname "Aggregator Regression" and rownumber 0
          
          Scenario: the "Mobile Number" field should prompt to enter valid inputs on Personal Info in Aggregator Onboarding
          Then the "Mobile Number" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator Regression" and rownumber 0
          
          Scenario: the "Email ID" field should prompt to enter valid inputs on Personal Info in Aggregator Onboarding
          Then the "Email ID" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator Regression" and rownumber 0
          
          Scenario: the "Nationality" field should prompt to enter valid inputs in Aggregator Onboarding
          Then the "Nationality" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
          
          Scenario: the "Aadhaar Number" field should prompt to enter valid inputs on Personal Info in Aggregator Onboarding
          Then the "Aadhaar Number" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator Regression" and rownumber 0
          
          Scenario: the "Passport" field should prompt to enter valid inputs in Aggregator Onboarding
          Then the "Passport" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
          
          Scenario: the user select a valid date in the "Passport Expiry Date" field on Personal Info in Aggregator Onboarding
          Then the user select a valid date in the "Passport Expiry Date" field in Personal Info
          
          Scenario: the "Save" button should be prompted to click on Personal Info in Aggregator Onboarding
          Then the "Save" button should be prompted to click on Personal Info
          
          Scenario: the "NextStep" button should be prompted to click on Personal Info in Aggregator Onboarding
          Then the "NextStep" button should be prompted to click on Personal Info
          

    
     
    Scenario: Visiting the Communication Info in Aggregator Onboarding
    When I visit the Communication Info
    
Scenario: the "Add" button should be prompted to click in Aggregator Onboarding      
    Then the "Add" button should be prompted to click
    
Scenario: the "Name" field should prompt to enter valid inputs in Aggregator Onboarding    
    Then the "Name" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
Scenario: the "Position" field should prompt to enter valid inputs in Aggregator Onboarding
    Then the "Position" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
Scenario: the "Mobile Number" field should prompt to enter valid inputs in Aggregator Onboarding    
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0 
    
Scenario: the "Email ID" field should prompt to enter valid inputs in Aggregator Onboarding    
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
Scenario: the "AD User" field should prompt to select Yes or No based on the given input in Aggregator Onboarding    
    Then the "AD User" field should prompt to select Yes or No based on the given input using sheetname "Aggregator Regression" and rownumber 0
    
Scenario: the "Save" button should be prompted to click on Communication Info in Aggregator Onboarding     
    Then the "Save" button should be prompted to click on Communication Info
    


Scenario: the "Settlement & Recon Contact Details Add" button should be prompted to click in Aggregator Onboarding   
    Then the "Settlement & Recon Contact Details Add" button should be prompted to click
    
 Scenario: the "Name" field should prompt to enter valid inputs in Aggregator Onboarding  
    Then the "Name" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Position" field should prompt to enter valid inputs in Aggregator Onboarding
    Then the "Position" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Mobile Number" field should prompt to enter valid inputs in Aggregator Onboarding
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0 
    
    Scenario: the "Email ID" field should prompt to enter valid inputs in Aggregator Onboarding
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Save" button should be prompted to click on Communication Info in Aggregator Onboarding
    Then the "Save" button should be prompted to click on Communication Info
    
    Scenario: The "NextStep" button should prompt a click on Communication Info in Aggregator Onboarding
    Then The "NextStep" button should prompt a click on Communication Info in Aggregator



Scenario: I visit the Channel Config in Aggregator Onboarding  
     When I visit the Channel Config in Aggregator

Scenario: the Channel Aggregator Onboarding should prompt users to enter valid inputs in Aggregator Onboarding     
     Then the Channel Aggregator Onboarding should prompt users to enter valid inputs using the sheet name "Channel Aggregator"     


Scenario: The "NextStep" button should prompted to click on Channel Config in Aggregator Onboarding    
     Then The "NextStep" button should prompted to click on Channel Config in Aggregator
 



Scenario: I visit the KYC in Aggregator Onboarding
    Given I visit the KYC in Aggregator
    
Scenario: the KYC "Company Proof of address" field should prompt a selection based on the uploaded image in Aggregator Onboarding     
    Then the KYC "Company Proof of address" field should prompt a selection based on the uploaded image using sheetname "Aggregator Regression" and rownumber 0
    
Scenario: The "NextStep" button should prompted to click on KYC in Aggregator Onboarding     
    Then The "NextStep" button should prompted to click on KYC in Aggregator
    
 
 
   
Scenario: I visit the Risk Info in Aggregator Onboarding
    When I visit the Risk Info
    
Scenario: the FRMParameterscheckbox should be checked in Aggregator Onboarding
    Then the FRMParameterscheckbox should be checked
    
    Scenario: the "Velocity Check Minutes" field should prompt to enter valid inputs on Risk Info in Aggregator Onboarding
    Then the "Velocity Check Minutes" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0 
    
    Scenario: the "Velocity Check Count" field should prompt to enter valid inputs on Risk Info in Aggregator Onboarding
    Then the "Velocity Check Count" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "Cash@POS Count" field should prompt to enter valid inputs on Risk Info in Aggregator Onboarding
    Then the "Cash@POS Count" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "Micro Atm Count" field should prompt to enter valid inputs on Risk Info in Aggregator Onboarding
    Then the "Micro Atm Count" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
          
    Scenario: the "International Card Acceptence" field should prompt to select Yes or No based on the given input on Risk Info in Aggregator Onboarding
    Then the "International Card Acceptence" field should prompt to select Yes or No based on the given input in Risk Info using sheetname "Aggregator Regression" and rownumber 0      
    
    Scenario: the "ICA Daily" field should prompt to enter valid inputs on Risk Info in Aggregator Onboarding
    Then the "ICA Daily" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0 
    
    Scenario: the "ICA Weekly" field should prompt to enter valid inputs on Risk Info in Aggregator Onboarding
    Then the "ICA Weekly" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "ICA Monthly" field should prompt to enter valid inputs on Risk Info in Aggregator Onboarding
    Then the "ICA Monthly" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "POS Daily" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "POS Daily" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "POS Weekly" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "POS Weekly" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "POS Monthly" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "POS Monthly" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "POS Minimum" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "POS Minimum" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "POS Maximum" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "POS Maximum" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "UPI Daily" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "UPI Daily" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "UPI Weekly" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "UPI Weekly" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "UPI Monthly" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "UPI Monthly" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "UPI Minimum" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "UPI Minimum" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "UPI Maximum" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "UPI Maximum" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "AEPS Daily" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "AEPS Daily" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "AEPS Weekly" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "AEPS Weekly" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "AEPS Monthly" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "AEPS Monthly" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "AEPS Minimum" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "AEPS Minimum" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "AEPS Maximum" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "AEPS Maximum" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "MATM Daily" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "MATM Daily" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "MATM Weekly" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "MATM Weekly" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "MATM Monthly" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "MATM Monthly" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "MATM Minimum" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "MATM Minimum" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "MATM Maximum" field should prompt to enter the valid inputs in Aggregator Onboarding 
    Then the "MATM Maximum" field should prompt to enter the valid inputs using sheetname "Aggregator Regression" and rownumber 0
    
    Scenario: the "NextStep" button should be prompted to click on Risk Info in Aggregator Onboarding
    Then the "NextStep" button should be prompted to click on Risk Info  
    
  
Scenario: I visit the Discount Rate in Aggregator Onboardng
     When I visit the Discount Rate 

Scenario: the "Discount Rate" should prompt users to enter valid inputs in Aggregator Onboardng
     Then the "Discount Rate" should prompt users to enter valid inputs using the sheet name "Discount Rate Aggregator"
     
 Scenario: The "NextStep" button should prompted to click on Discount Rate in Aggregator Onboardng   
     Then The "NextStep" button should prompted to click on Discount Rate


 
Scenario: I visit the Settlement Info in Aggregator Onboardng 
     When I visit the Settlement Info
     
     Scenario: the Settlement Info "ADD" button should be prompted to click in Aggregator Onboardng
     Then the Settlement Info "ADD" button should be prompted to click
     
     Scenario: the Settlement Info "Channel" dropdown should prompt to select the valid inputs in Aggregator Onboardng
     Then the Settlement Info "Channel" dropdown should prompt to select the valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the Settlement Info "Account Type" dropdown should prompt to select the valid inputs in Aggregator Onboardng
     Then the Settlement Info "Account Type" dropdown should prompt to select the valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the Settlement Info "Bank Account Number" field should prompt to enter valid inputs in Aggregator Onboardng
     Then the Settlement Info "Bank Account Number" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs in Aggregator Onboardng
     Then the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the SettlementInfo "Save" button should be prompted to click in Aggregator Onboardng
     Then the SettlementInfo "Save" button should be prompted to click
     
     Scenario: the Settlement Info "Settlement Mode" dropdown should prompt to select valid inputs in Aggregator Onboardng
     Then the Settlement Info "Settlement Mode" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the Settlement Info "Payment Flag" dropdown should prompt to select valid inputs in Aggregator Onboardng
     Then the Settlement Info "Payment Flag" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
     
     Scenario: the "NextStep" button should prompted to click on Settlement Info in Aggregator Onboardng
     Then the "NextStep" button should prompted to click on Settlement Info in Aggregator
     
  
  
  
Scenario: I visit the Whitelabel in Aggregator Onboardng
       When I visit the Whitelabel
       
       Scenario: the Whitelabel "ISO Onboarding" dropdown should prompt to select valid inputs in Aggregator Onboardng
       Then the Whitelabel "ISO Onboarding" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
       
       Scenario: the Whitelabel "Sales Team Onboarding" dropdown should prompt to select valid inputs in Aggregator Onboardng
       Then the Whitelabel "Sales Team Onboarding" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
       
       Scenario: the Whitelabel "Allow to Create Merchant User" dropdown should prompt to select valid inputs in Aggregator Onboardng
       Then the Whitelabel "Allow to Create Merchant User" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
       
       Scenario: the Whitelabel "Max Number of platform" field should prompt to enter valid inputs in Aggregator Onboardng
       Then the Whitelabel "Max Number of platform" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
       
       Scenario: the Whitelabel "UserName As" dropdown should prompt to select valid inputs in Aggregator Onboardng
       Then the Whitelabel "UserName As" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0 
       
       Scenario: the "NextStep" button should prompted to click on Whitelabel in Aggregator Onboardng
       Then the "NextStep" button should prompted to click on Whitelabel in Aggregator
    


        
       Scenario: I visit the Webhooks in Aggregator Onboarding
       When I visit the Webhooks
       
       Scenario: the Webhooks "Add" button should be prompted to click in Aggregator Onboarding
       Then the Webhooks "Add" button should be prompted to click
       
       Scenario: the Webhooks "Webhook Type" dropdown should prompt to select valid inputs in Aggregator Onboarding
       Then the Webhooks "Webhook Type" dropdown should prompt to select valid inputs using sheetname "Aggregator Regression" and rownumber 0
       
       Scenario: the Webhooks "Webhook URL" field should prompt to enter valid inputs in Aggregator Onboarding
        Then the Webhooks "Webhook URL" field should prompt to enter valid inputs using sheetname "Aggregator Regression" and rownumber 0
       
       Scenario: the Webhooks "Save" button should be prompted to click in Aggregator Onboarding
       Then the Webhooks "Save" button should be prompted to click
       
       Scenario: the "NextStep" button should be prompted to click on Webhooks in Aggregator Onboarding
       Then the "NextStep" button should prompted to click on Webhook in Aggregator
       
       
       
  
 Scenario: System Maker submits the application for verification
  When the System Maker clicks the "Submit for verification" button



Scenario: System Maker confirms submission by clicking the "Yes" button
  When the System Maker clicks the "Yes" button to confirm submission
  
  
  Scenario: System Maker logs out by clicking profile and log-out button
  When the System Maker clicks on the profile and log-out button


Scenario: System Maker handles the pop-up and is redirected to the login page
  When the System Maker handles the pop-up by selecting the "Yes" button and redirected to login page
  
   
Scenario: System verifier Login
 Given I visit the System Verifier Login using sheetname "Credentials" and rownumber 2
 And I enter the credentials and click a login button
    
	 
Scenario: System Verifier sees Onboarding in Sidemenu
   When System Verifier - Onboarding should be displayed in the side menu
    

Scenario: System Verifier sees side menu items in Onboarding
  Then the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Verifier clicks the Aggregator module
    When the System Verifier clicks the Aggregator module
   

 Scenario: System Verifier Ensure the Bank Status - Inprogress
    When the System Verifier ensure the Aggregator status "Inprogress" using sheetname "Aggregator Regression" and rownumber 0
  

Scenario: System Verifier - click on action (Three dot button) and select the view option
    When the System Verifier click on action Three dot button and select the view option
    
    
  Scenario: System Verifier checks "Sales Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier check the Aggregator "Sales Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons


  Scenario: System Verifier checks "Company Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Company Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Personal Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Personal Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
 
 
  Scenario: System Verifier checks "Communication Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Communication Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
   
   
   
  Scenario: System Verifier checks "Channel Config" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Channel Config" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  

  Scenario: System Verifier checks "KYC" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "KYC" to ensure mandatory details are added and clicks the "Verified and Next" buttons in Aggregator
  
 
  Scenario: System Verifier checks "Risk Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Risk Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
 
Scenario: System Verifier checks "Discount Rate" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Discount Rate" to ensure mandatory details are added and clicks the "Verified and Next" buttons

  
  
  Scenario: System Verifier checks "Settlement Info" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Settlement Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
 
  Scenario: System Verifier checks "WhiteLabel" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "WhiteLabel" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  

  Scenario: System Verifier checks "Webhooks" and clicks "Verified and Next" in Aggregator Onboarding
  When the System Verifier checks "Webhooks" to ensure mandatory details are added and clicks the "Verified and Next" buttons
    
  
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
 

 Scenario: System Approver clicks the Aggregator module
    When the System Approver clicks the Aggregator module
   
 
 Scenario: System Approver Ensure the Aggregators Status - Inprogress
    When the System Approver ensure the Aggregator status "Inprogress" using sheetname "Aggregator Regression" and rownumber 0
  
  
Scenario: System Approver - click on action (Three dot button) and select the view option
    When the System Approver click on action Three dot button and select the view option
    
   
  Scenario: System Approver checks if "Seles Info" is verified and clicks "NextStep" button
  When the System Approver check if "Sales Info" is verified and clicks the "NextStep" button
  
   
   Scenario: System Approver checks if "Company Info" is verified and clicks "NextStep" button
  When the System Approver check if "Company Info" is verified and clicks the "NextStep" button
  
   
  Scenario: System Approver checks if "Personal Info" is verified and clicks "NextStep" button
  When the System Approver check if "Personal Info" is verified and clicks the "NextStep" button        
  
   
  Scenario: System Approver checks if "Communication Info" is verified and clicks "NextStep" button
  When the System Approver check if "Communication Info" is verified and clicks the "NextStep" button
  
  
  Scenario: System Approver checks if "Channel Config" is verified and clicks "NextStep" button
        When the System Approver check if "Channel Config" is verified and clicks the "NextStep" button
    
         
   Scenario: System Approver checks if "KYC" is verified and clicks "NextStep" button
        When the System Approver check if "KYC" is verified and clicks the "NextStep" button          
        
 
  Scenario: System Approver checks if "Risk Info" is verified and clicks "NextStep" button
        When the System Approver check if "Risk Info" is verified and clicks the "NextStep" button
        

  Scenario: System Approver checks if "Discount Rate" is verified and clicks "NextStep" button
        When the System Approver check if "Discount Rate" is verified and clicks the "NextStep" button
        
   
  Scenario: System Approver checks if "Settlement Info" is verified and clicks "NextStep" button
        When the System Approver check if "Settlement Info" is verified and clicks the "NextStep" button
        
       
  Scenario: System Approver checks if "Whitelabel" is verified and clicks "NextStep" button
        When the System Approver check if "Whitelabel" is verified and clicks the "NextStep" button
        
     
  Scenario: System Approver checks if "Webhooks" is verified and clicks "NextStep" button
        When the System Approver check if "Webhooks" is verified and clicks the "NextStep" button
        
       
  Scenario: System Approver submits the application for Approve
  When the System Approver clicks the "Submit for Approve" button

 
  Scenario: System Approver confirms submission by clicking the "Yes" button
     When the System Approver clicks the "Yes" button to confirm submission
   
     
   Scenario: Verify that Aggregator CPID is generated after changing the status to Approved
    When Verify that Aggregator CPID is displayed correctly on the "Aggregator Onboarding List page" using sheetname "Aggregator Regression" and rownumber 0 
  
 
  Scenario: System Approver logs out by clicking profile and log-out button
     When the System Approver clicks on the profile and log-out button

 
   Scenario: System Approver handles the pop-up and is redirected to the login page
      When the System Approver handles the pop-up by selecting the "Yes" button and redirected to login page   
    
           
      
      	
     
     
     
   