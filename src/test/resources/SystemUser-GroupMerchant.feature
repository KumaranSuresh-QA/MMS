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


Feature: System Users - Group Merchant Onboarding Regression

 This feature aims to test the functionality of the 'Group Merchant Onboarding' within the application.
 
 
@run @loadData
Scenario: SystemMaker Login
 Given I visit the System Maker Login using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button

 Scenario: System Maker sees Onboarding in Sidemenu
   When System Maker - Onboarding should be displayed in the side menu
    

Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
  

Scenario: SystemMaker clicks the Group Merchant module
    When the SystemMaker clicks the Group Merchant module
    

Scenario: SystemMaker clicks the Create Button
    When the SystemMaker clicks the Create Button
    
    
Scenario: Visiting the Sales Info in Group Merchant Onboarding
    When I Visit the Sales Info
    
    #Scenario: the user select a valid date in the "ISO Application Date" field in "Group Merchant Onboarding"
    #When the user select a valid date in the "ISO Application Date" field
#	  
#	  Scenario: the user select a valid date in the "Agreement Date" field in "Group Merchant Onboarding"
#	  When the user select a valid date in the "Agreement Date" field in ISO
	  
	   Scenario: the "Unique Reference Number" field should prompt to enter the valid inputs in "Group Merchant Onboarding"
	  Then the "Unique Reference Number" field should prompt to enter the valid inputs using sheetname "Group Merchant Regression" and rownumber 0
	  
	  Scenario: the "Aggregator Name" field should prompt to select the valid inputs in "Group Merchant Onboarding"
	  Then the "Aggregator Name" field should prompt to select the valid inputs using sheetname "Group Merchant Regression" and rownumber 0
	  
	   Scenario: the "ISO Name" field should prompt to select the valid inputs in "Group Merchant Onboarding"
	  Then the "ISO Name" field should prompt to select the valid inputs using sheetname "Group Merchant Regression" and rownumber 0
	  
	   Scenario: the "SUB ISO Name" field should prompt to select the valid inputs in "Group Merchant Onboarding"
	  Then the "SUB ISO Name" field should prompt to select the valid inputs using sheetname "Group Merchant Regression" and rownumber 0
    
    Scenario: the "NextStep" button should be prompted to click on Sales Info in "Group Merchant Onboarding"
    Then the "NextStep" button should be prompted to click on Sales Info
    
    
    
     
    

     
     Scenario: Visiting the Company Info in Group Merchant Onboarding
     When I Visit the Company Info
     
     Scenario: the "Legal Name" field should prompt to enter valid inputs in "Group Merchant Onboarding"
     Then the "Legal Name" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "Brand Name" field should prompt to enter valid inputs in "Group Merchant Onboarding"
     Then the "Brand Name" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "Registered Address" field should prompt to enter valid inputs within 230 characters in "Group Merchant Onboarding"
     Then the "Registered Address" field should prompt to enter valid inputs within 230 characters using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "Registered Pincode" dropdown should prompt to select valid inputs in "Group Merchant Onboarding"
     Then the "Registered Pincode" dropdown should prompt to select valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "Business Type" dropdown should prompt to select valid inputs in "Group Merchant Onboarding"
     Then the "Business Type" dropdown should prompt to select valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the user selects a valid date in the "Established Year" field in "Group Merchant Onboarding"
     When the user selects a valid date in the "Established Year" field
     
     Scenario: the "Registered Number" field should prompt to enter valid inputs in "Group Merchant Onboarding"
     Then the "Registered Number" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "Company PAN" field should prompt to enter valid inputs in "Group Merchant Onboarding"
     Then the "Company PAN" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "GSTIN" field should prompt to enter valid inputs in "Group Merchant Onboarding"
     Then the "GSTIN" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "Nature of business" field should prompt to select valid inputs in "Group Merchant Onboarding"
     Then the "Nature of business" field should prompt to select valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "MCC" field should prompt to select valid inputs in "Group Merchant Onboarding"
     Then the "MCC" field should prompt to select valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
     
     Scenario: the "Statement Frequency" dropdown should prompt to select valid inputs on Company Info in "Group Merchant Onboarding"
     Then the "Statement Frequency" dropdown should prompt to select valid inputs in Company Info using sheetname "Group Merchant Regression" and rownumber 0
     
     Scenario: the "Statement Type" dropdown should prompt to select valid inputs on Company Info in "Group Merchant Onboarding"
     Then the "Statement Type" dropdown should prompt to select valid inputs in Company Info using sheetname "Group Merchant Regression" and rownumber 0
     
     
     Scenario: the "NextStep" button should be prompted to click on Company Info in "Group Merchant Onboarding"
     Then the "NextStep" button should be prompted to click on Company Info
 

          Scenario: Visiting the Personal Info in Group Merchant Onboarding
          When I visit the Personal Info
          
          
          Scenario: the "Add" button should be prompted to click on personal info in "Group Merchant Onboarding"
          Then the "Add" button should be prompted to click in personal info
          
          Scenario: the "Title" dropdown should prompt to select valid inputs on Personal Info in "Group Merchant Onboarding"
          Then the "Title" dropdown should prompt to select valid inputs in Personal Info using sheetname "Group Merchant Regression" and rownumber 0
            
          Scenario: the "First Name" field should prompt to enter valid inputs in "Group Merchant Onboarding"
          Then the "First Name" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the "Last Name" field should prompt to enter valid inputs in "Group Merchant Onboarding"
          Then the "Last Name" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the user select a valid date in the "Date Of Birth" field on Personal Info in "Group Merchant Onboarding"
          When the user select a valid date in the "Date Of Birth" field in Personal Info
          
          Scenario: the "PAN" field should prompt to enter valid inputs with PAN Format on Personal Info in "Group Merchant Onboarding"
          Then the "PAN" field should prompt to enter valid inputs with PAN Format in Personal Info using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the "Address" field should prompt to enter valid inputs within 230 characters on personal info in "Group Merchant Onboarding"
          Then the "Address" field should prompt to enter valid inputs within 230 characters in personal info using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the "Pincode" dropdown should prompt to select valid inputs on Personal Info in "Group Merchant Onboarding"
          Then the "Pincode" dropdown should prompt to select valid inputs in Personal Info using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the "Mobile Number" field should prompt to enter valid inputs on Personal Info in "Group Merchant Onboarding"
          Then the "Mobile Number" field should prompt to enter valid inputs in Personal Info using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the "Email ID" field should prompt to enter valid inputs on Personal Info in "Group Merchant Onboarding"
          Then the "Email ID" field should prompt to enter valid inputs in Personal Info using sheetname "Group Merchant Regression" and rownumber 0
           
          Scenario: the "Nationality" field should prompt to enter valid inputs in "Group Merchant Onboarding"
          Then the "Nationality" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the "Aadhaar Number" field should prompt to enter valid inputs on Personal Info in "Group Merchant Onboarding"
          Then the "Aadhaar Number" field should prompt to enter valid inputs in Personal Info using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the "Passport" field should prompt to enter valid inputs in "Group Merchant Onboarding"
          Then the "Passport" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
          
          Scenario: the user select a valid date in the "Passport Expiry Date" field on Personal Info in "Group Merchant Onboarding"
          Then the user select a valid date in the "Passport Expiry Date" field in Personal Info
          
          Scenario: the "Save" button should be prompted to click on Personal Info in "Group Merchant Onboarding"
          Then the "Save" button should be prompted to click on Personal Info in ISO
          
          Scenario: the "NextStep" button should be prompted to click on Personal Info in "Group Merchant Onboarding"
          Then the "NextStep" button should be prompted to click on Personal Info
          
                      


 Scenario: Visiting the Communication Info in Group Merchant Onboarding
 When I visit the Communication Info
    Then the "Add" button should be prompted to click
    
    
Scenario: the "Name" field should prompt to enter valid inputs in "Group Merchant Onboarding"
    Then the "Name" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
    
 Scenario: the "Position" field should prompt to enter valid inputs in "Group Merchant Onboarding"
    Then the "Position" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
    
    Scenario: the "Mobile Number" field should prompt to enter valid inputs in "Group Merchant Onboarding"
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0 
    
    Scenario: the "Email ID" field should prompt to enter valid inputs in "Group Merchant Onboarding"
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
    
    Scenario: the "AD User" field should prompt to select Yes or No based on the given input in "Group Merchant Onboarding"
    Then the "AD User" field should prompt to select Yes or No based on the given input using sheetname "Group Merchant Regression" and rownumber 0
    
    Scenario: the "Save" button should be prompted to click on Communication Info in "Group Merchant Onboarding"
    Then the "Save" button should be prompted to click on Communication Info
    
    
    Scenario: the "Settlement & Recon Contact Details Add" button should be prompted to click
    Then the "Settlement & Recon Contact Details Add" button should be prompted to click
    
    Scenario: the "Name" field should prompt to enter valid inputs in "Group Merchant Onboarding"
    Then the "Name" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Position" field should prompt to enter valid inputs in "Group Merchant Onboarding"
    Then the "Position" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Mobile Number" field should prompt to enter valid inputs in "Group Merchant Onboarding"
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Email ID" field should prompt to enter valid inputs in "Group Merchant Onboarding"
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Save" button should be prompted to click on Communication Info in "Group Merchant Onboarding"
    Then the "Save" button should be prompted to click on Communication Info
    
    Scenario: The "NextStep" button should prompted to click on Communication Info in "Group Merchant Onboarding"
    Then The "NextStep" button should prompt a click on Communication Info
           


Scenario: Visiting the Channel Config in "Group Merchant Onboarding"
     When I visit the Channel Config
      
Scenario: the Channel ISO Onboarding should prompt users to enter valid inputs in "Group Merchant Onboarding"    
     Then the Channel ISO Onboarding should prompt users to enter valid inputs using the sheet name "Channel Aggregator"
     
 Scenario: The "NextStep" button should prompted to click on Channel Config in "Group Merchant Onboarding"
     Then The "NextStep" button should prompted to click on Channel Config in GM
     
     
     




Scenario: I visit the Discount Rate in "Group Merchant Onboarding"
     When I visit the Discount Rate 

Scenario: the "Discount Rate" should prompt users to enter valid inputs in "Group Merchant Onboarding"
     Then the "Discount Rate" should prompt users to enter valid inputs using the sheet name "Discount Rate Group Merchant"
     
 Scenario: The "NextStep" button should prompted to click on Discount Rate in "Group Merchant Onboarding"
     Then The "NextStep" button should prompted to click on Discount Rate    
 
        





Scenario: Visiting the Settlement Info in Group Merchant Onboarding 
     When I visit the Settlement Info
     
Scenario: the Settlement Info "ADD" button should be prompted to click     
     Then the Settlement Info "ADD" button should be prompted to click
     
Scenario: the Settlement Info "Channel" dropdown should prompt to select the valid inputs in "Group Merchant Onboarding"
     Then the Settlement Info "Channel" dropdown should prompt to select the valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
Scenario: the Settlement Info "Account Type" dropdown should prompt to select the valid inputs in "Group Merchant Onboarding"
     Then the Settlement Info "Account Type" dropdown should prompt to select the valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
Scenario: the Settlement Info "Bank Account Number" field should prompt to enter valid inputs in "Group Merchant Onboarding" 
     Then the Settlement Info "Bank Account Number" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
Scenario: the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs in "Group Merchant Onboarding"
     Then the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs using sheetname "Group Merchant Regression" and rownumber 0
     
Scenario: the SettlementInfo "Save" button should be prompted to click in "Group Merchant Onboarding"
     Then the SettlementInfo "Save" button should be prompted to click
     
Scenario: the "NextStep" button should prompted to click on Settlement Info in "Group Merchant Onboarding"
     Then the "NextStep" button should prompted to click on Settlement Info
     
       
          

 Scenario: Visiting the Whitelabel in Group Merchant Onboarding 
       When I visit the Whitelabel
  
  Scenario: the Whitelabel "Max Number of platform" field should prompt to enter valid inputs in "Group Merchant Onboarding"
       Then the Whitelabel "Max Number of platform" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
   
    Scenario: the "Save" button should be prompted to click on Company Info in "Group Merchant Onboarding"
     Then the "Save" button should be prompted to click on Whitelabel
   
   Scenario: the "NextStep" button should prompted to click on Whitelabel in "Group Merchant Onboarding"
       Then the "NextStep" button should prompted to click on Whitelabel in ISO
       
     
    
            


 Scenario: Visiting the Webhooks in Group Merchant Onboarding 
       When I visit the Webhooks
       
       Scenario: the Webhooks "Add" button should be prompted to click in "Group Merchant Onboarding"
       Then the Webhooks "Add" button should be prompted to click
       
       Scenario: the Webhooks "Webhook Type" dropdown should prompt to select valid inputs in "Group Merchant Onboarding"
       Then the Webhooks "Webhook Type" dropdown should prompt to select valid inputs using sheetname "Group Merchant Regression" and rownumber 0
       
       Scenario: the Webhooks "Webhook URL" field should prompt to enter valid inputs in "Group Merchant Onboarding"
       Then the Webhooks "Webhook URL" field should prompt to enter valid inputs using sheetname "Group Merchant Regression" and rownumber 0
       
       Scenario: the Webhooks "Save" button should be prompted to click in "Group Merchant Onboarding"
       Then the Webhooks "Save" button should be prompted to click
       
       Scenario: the "NextStep" button should prompted to click on Webhook in "Group Merchant Onboarding"
       Then the "NextStep" button should prompted to click on Webhook in ISO
       
       
       Scenario: Visiting the KYC in Group Merchant Onboarding  
       When I visit the KYC Config
    
       Scenario: the KYC "Company Proof of address" field should prompt a selection based on the uploaded image in the "Group Merchant Onboarding"   
       Then the KYC "Company Proof of address" field should prompt a selection based on the uploaded image using sheetname "Group Merchant Regression" and rownumber 0
    
       Scenario: The "NextStep" button should prompted to click on KYC in "Group Merchant Onboarding"
       Then The "NextStep" button should prompted to click on KYC in GM
       
       
     Scenario: System Maker submits the application for verification in "Group Merchant Onboarding"
  When the System Maker clicks the "Submit for verification" button


       
Scenario: System Maker confirms submission by clicking the "Yes" button in "Group Merchant Onboarding"
  When the System Maker clicks the "Yes" button to confirm submission
  
          
Scenario: System Maker logs out by clicking profile and log-out button in "Group Merchant Onboarding"
  When the System Maker clicks on the profile and log-out button

       
Scenario: System Maker handles the pop-up and is redirected to the login page in "Group Merchant Onboarding"
  When the System Maker handles the pop-up by selecting the "Yes" button and redirected to login page
  
  
  
   Scenario: System verifier Login
 Given I visit the System Verifier Login using sheetname "Credentials" and rownumber 2
 And I enter the credentials and click a login button
    
	 
Scenario: System Verifier sees Onboarding in Sidemenu
   When System Verifier - Onboarding should be displayed in the side menu
    

Scenario: System Verifier sees side menu items in Onboarding
  Then the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Verifier clicks the Group Merchant module
    When the System Verifier clicks the Group Merchant module
   

 Scenario: System Verifier Ensure the ISO Status - Inprogress
    When the System Verifier ensure the Group Merchant status "Inprogress" using sheetname "Group Merchant Regression" and rownumber 0
  

Scenario: System Verifier - click on action (Three dot button) and select the view option
    When the System Verifier click on action Three dot button and select the view option
    
    
  Scenario: System Verifier checks "Sales Info" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Sales Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons


  Scenario: System Verifier checks "Company Info" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Company Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Personal Info" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Personal Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
 
 
  Scenario: System Verifier checks "Communication Info" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Communication Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
   
   
   
  Scenario: System Verifier checks "Channel Config" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Channel Config" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  

Scenario: System Verifier checks "Discount Rate" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Discount Rate" to ensure mandatory details are added and clicks the "Verified and Next" buttons

  
  
  Scenario: System Verifier checks "Settlement Info" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Settlement Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
 
  Scenario: System Verifier checks "WhiteLabel" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "WhiteLabel" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  

  Scenario: System Verifier checks "Webhooks" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Webhooks" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  Scenario: System Verifier checks "KYC" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "KYC" to ensure mandatory details are added and clicks the "Verified and Next" buttons in ISO
  #When the System Verifier checks "KYC" to ensure mandatory details are added and clicks the "Verify Document" button
    
  
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
    

Scenario: System Approver sees side menu items in Group Merchant Onboarding
  Then the System Approver should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Approver clicks the Group Merchant module
    When the System Approver clicks the Group Merchant module
   
 
 Scenario: System Approver Ensure the SUB ISO Status - Inprogress
    When the System Approver ensure the Group Merchant status "Inprogress" using sheetname "Group Merchant Regression" and rownumber 0
  
  
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
    
      
  Scenario: System Approver checks if "Discount Rate" is verified and clicks "NextStep" button
        When the System Approver check if "Discount Rate" is verified and clicks the "NextStep" button
        
   
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
   
     
   Scenario: Verify that Group Merchant CPID is generated after changing the status to Approved
    When Verify that Group Merchant CPID is displayed correctly on the "Group Merchant Onboarding List page" using sheetname "Group Merchant Regression" and rownumber 0 
  
 
  Scenario: System Approver logs out by clicking profile and log-out button
     When the System Approver clicks on the profile and log-out button

 
   Scenario: System Approver handles the pop-up and is redirected to the login page
      When the System Approver handles the pop-up by selecting the "Yes" button and redirected to login page     
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
           
    
    
