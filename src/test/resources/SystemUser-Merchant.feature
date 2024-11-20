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
	
Feature: System Users - Merchant Onboarding Regression

 This feature aims to test the functionality of the 'Merchant Onboarding' within the application.
 
 
@run @loadData
Scenario: SystemMaker Login
 Given I visit the System Maker Login using sheetname "Credentials" and rownumber 1
 And I enter the credentials and click a login button

@run
 Scenario: System Maker sees Onboarding in Sidemenu
   When System Maker - Onboarding should be displayed in the side menu


@run
Scenario: System Maker sees side menu items in Onboarding
  Then the System Maker should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
  
@run
Scenario: SystemMaker clicks the Merchant module
    When the SystemMaker clicks the Merchant module


Scenario: SystemMaker clicks the Create Button
    When the SystemMaker clicks the Create Button



     Scenario: I Visit the Sales Info in "Merchant Onboarding" 
     When I Visit the Sales Info
     
     Scenario: the "Merchant Reference Number" field should prompt to enter valid inputs in "Merchant Onboarding"
     Then the "Merchant Reference Number" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0

     #Scenario: the user select a valid date in the "Aggregator Application Date" field in "Merchant Onboarding"
     #When the user select a valid date in the "Aggregator Application Date" field in Merchant Onboarding
     
     Scenario: the "Aggregator Name" field should prompt to select the valid inputs in "Merchant Onboarding"
	   Then the "Aggregator Name" field should prompt to select the valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the First "VAS Commission" field should prompt to select Yes or No based on the given input in "Merchant Onboarding"
     Then the First "VAS Commission" field should prompt to select Yes or No based on the given input using sheetname "Merchant Regression" and rownumber 0
     
      Scenario: the "ISO Name" field should prompt to select the valid inputs in "Merchant Onboarding"
	    Then the "ISO Name" field should prompt to select the valid inputs using sheetname "Merchant Regression" and rownumber 0
	    
	    Scenario: the "SUB ISO Name" field should prompt to select the valid inputs in "Merchant Onboarding"
	    Then the "SUB ISO Name" field should prompt to select the valid inputs using sheetname "Merchant Regression" and rownumber 0
	    
	    Scenario: the "Group Merchant Name" field should prompt to select the valid inputs in "Merchant Onboarding"
	    Then the "Group Merchant Name" field should prompt to select the valid inputs using sheetname "Merchant Regression" and rownumber 0
     
      Scenario: the "NextStep" button should be prompted to click on Sales Info in Merchant Onboarding
      Then the "NextStep" button should be prompted to click on Sales Info
      
      
      
      Scenario: I Visit the Company Info in Merchant Onboarding 
      When I Visit the Company Info
     
     Scenario: the "Legal Name" field should prompt to enter valid inputs in Merchant Onboarding    
     Then the "Legal Name" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the "Brand Name" field should prompt to enter valid inputs in Merchant Onboarding
     Then the "Brand Name" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the "Registered Address" field should prompt to enter valid inputs within 230 characters in Merchant Onboarding
     Then the "Registered Address" field should prompt to enter valid inputs within 230 characters using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the "Location" field should prompt to enter valid inputs in Merchant Onboarding
     Then the "Location" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
   
     Scenario: the "Registered Pincode" dropdown should prompt to select valid inputs in Merchant Onboarding
     Then the "Registered Pincode" dropdown should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the "Business Type" dropdown should prompt to select valid inputs in Merchant Onboarding
     Then the "Business Type" dropdown should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the user selects a valid date in the "Established Year" field in Merchant Onboarding
     When the user selects a valid date in the "Established Year" field
     
     Scenario: the "Registered Number" field should prompt to enter valid inputs in Merchant Onboarding
     Then the "Registered Number" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the "Company PAN" field should prompt to enter valid inputs in Merchant Onboarding
     Then the "Company PAN" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the "GSTIN" field should prompt to enter valid inputs in Merchant Onboarding
     Then the "GSTIN" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
     
      Scenario: the "Nature of business" field should prompt to select valid inputs in "Merchant Onboarding"
     Then the "Nature of business" field should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
    
      Scenario: the "MCC" field should prompt to select valid inputs in "Merchant Onboarding"
     Then the "MCC" field should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the "Merchant Type" field should prompt to select valid inputs in "Merchant Onboarding"
     Then the "Merchant Type" field should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
     
      Scenario: the "Merchant Classification" field should prompt to select valid inputs in "Merchant Onboarding"
     Then the "Merchant Classification" field should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
     
      Scenario: the "Statement Frequency" dropdown should prompt to select valid inputs in Company Info in Merchant Onboarding
     Then the "Statement Frequency" dropdown should prompt to select valid inputs in Company Info using sheetname "Merchant Regression" and rownumber 0
     
     Scenario: the "Statement Type" dropdown should prompt to select valid inputs on Company Info in Merchant Onboarding
     Then the "Statement Type" dropdown should prompt to select valid inputs in Company Info using sheetname "Merchant Regression" and rownumber 0
     
     
     Scenario: the "NextStep" button should be prompted to click on Company Info in Merchant Onboarding
     Then the "NextStep" button should be prompted to click on Company Info
     
     
     
        Scenario: Visiting the Personal Info in Merchant Onboarding
          When I visit the Personal Info
          
          
          Scenario: the "Add" button should be prompted to click on personal info in "Merchant Onboarding"
          Then the "Add" button should be prompted to click in personal info
          
          Scenario: the "Title" dropdown should prompt to select valid inputs on Personal Info in "Merchant Onboarding"
          Then the "Title" dropdown should prompt to select valid inputs in Personal Info using sheetname "Merchant Regression" and rownumber 0
            
          Scenario: the "First Name" field should prompt to enter valid inputs in "Merchant Onboarding"
          Then the "First Name" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the "Last Name" field should prompt to enter valid inputs in "Merchant Onboarding"
          Then the "Last Name" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the user select a valid date in the "Date Of Birth" field on Personal Info in "Merchant Onboarding"
          When the user select a valid date in the "Date Of Birth" field in Personal Info
          
          Scenario: the "PAN" field should prompt to enter valid inputs with PAN Format on Personal Info in "Merchant Onboarding"
          Then the "PAN" field should prompt to enter valid inputs with PAN Format in Personal Info using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the "Address" field should prompt to enter valid inputs within 230 characters on personal info in " Merchant Onboarding"
          Then the "Address" field should prompt to enter valid inputs within 230 characters in personal info using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the "Pincode" dropdown should prompt to select valid inputs on Personal Info in "Merchant Onboarding"
          Then the "Pincode" dropdown should prompt to select valid inputs in Personal Info using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the "Mobile Number" field should prompt to enter valid inputs on Personal Info in "Merchant Onboarding"
          Then the "Mobile Number" field should prompt to enter valid inputs in Personal Info using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the "Email ID" field should prompt to enter valid inputs on Personal Info in "Merchant Onboarding"
          Then the "Email ID" field should prompt to enter valid inputs in Personal Info using sheetname "Merchant Regression" and rownumber 0
           
          Scenario: the "Nationality" field should prompt to enter valid inputs in "Merchant Onboarding"
          Then the "Nationality" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the "Aadhaar Number" field should prompt to enter valid inputs on Personal Info in "Merchant Onboarding"
          Then the "Aadhaar Number" field should prompt to enter valid inputs in Personal Info using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the "Passport" field should prompt to enter valid inputs in "Merchant Onboarding"
          Then the "Passport" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
          
          Scenario: the user select a valid date in the "Passport Expiry Date" field on Personal Info in "Merchant Onboarding"
          Then the user select a valid date in the "Passport Expiry Date" field in Personal Info
          
          Scenario: the "Save" button should be prompted to click on Personal Info in "Merchant Onboarding"
          Then the "Save" button should be prompted to click on Personal Info in ISO
          
          Scenario: the "NextStep" button should be prompted to click on Personal Info in "Merchant Onboarding"
          Then the "NextStep" button should be prompted to click on Personal Info
          
                      


 Scenario: Visiting the Communication Info in Merchant Onboarding
 When I visit the Communication Info
    Then the "Add" button should be prompted to click
    
    
Scenario: the "Name" field should prompt to enter valid inputs in "Merchant Onboarding"
    Then the "Name" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
    
 Scenario: the "Position" field should prompt to enter valid inputs in "Merchant Onboarding"
    Then the "Position" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "Mobile Number" field should prompt to enter valid inputs in " Merchant Onboarding"
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0 
    
    Scenario: the "Email ID" field should prompt to enter valid inputs in "Merchant Onboarding"
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "AD User" field should prompt to select Yes or No based on the given input in "Merchant Onboarding"
    Then the "AD User" field should prompt to select Yes or No based on the given input using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "Save" button should be prompted to click on Communication Info in "Merchant Onboarding"
    Then the "Save" button should be prompted to click on Communication Info
    
    
    
      Scenario: the "Settlement & Recon Contact Details Add" button should be prompted to click
    Then the "Settlement & Recon Contact Details Add" button should be prompted to click
    
    Scenario: the "Name" field should prompt to enter valid inputs in "Merchant Onboarding"
    Then the "Name" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Position" field should prompt to enter valid inputs in "Merchant Onboarding"
    Then the "Position" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Mobile Number" field should prompt to enter valid inputs in "Merchant Onboarding"
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Email ID" field should prompt to enter valid inputs in "Merchant Onboarding"
    Then the "Email ID" field should prompt to enter valid inputs using sheetname "Settlement & Recon Contact" and rownumber 0
    
    Scenario: the "Save" button should be prompted to click on Communication Info in "Merchant Onboarding"
    Then the "Save" button should be prompted to click on Communication Info
    
    Scenario: The "NextStep" button should prompted to click on Communication Info in "Merchant Onboarding"
    Then The "NextStep" button should prompt a click on Communication Info in Merchant
    
    
    
    @run
    Scenario: I visit the Risk Info in Merchant Onboarding
    When I visit the Risk Info
    
    @run
    Scenario: the FRMParameterscheckbox should be checked in Merchant Onboarding
    Then the FRMParameterscheckbox should be checked
    
    Scenario: the "Week Days From" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "Week Days From" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0
    
     Scenario: the "Week Days To" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "Week Days To" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0 
    
     Scenario: the "Week ENDS From" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "Week Ends From" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0 
    
     Scenario: the "Week ENDS To" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "Week Ends To" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0  
    
    Scenario: the "Velocity Check Minutes" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "Velocity Check Minutes" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0 
    
    Scenario: the "Velocity Check Count" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "Velocity Check Count" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "Cash@POS Count" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "Cash@POS Count" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "International Card Acceptence" field should prompt to select Yes or No based on the given input on Risk Info in Merchant Onboarding
    Then the "International Card Acceptence" field should prompt to select Yes or No based on the given input in Risk Info using sheetname "Merchant Regression" and rownumber 0      
    
    Scenario: the "ICA Daily" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "ICA Daily" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0 
    
    Scenario: the "ICA Weekly" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "ICA Weekly" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "ICA Monthly" field should prompt to enter valid inputs on Risk Info in Merchant Onboarding
    Then the "ICA Monthly" field should prompt to enter valid inputs in Risk Info using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "POS Daily" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "POS Daily" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "POS Weekly" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "POS Weekly" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "POS Monthly" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "POS Monthly" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "POS Minimum" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "POS Minimum" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "POS Maximum" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "POS Maximum" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "UPI Daily" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "UPI Daily" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "UPI Weekly" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "UPI Weekly" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "UPI Monthly" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "UPI Monthly" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "UPI Minimum" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "UPI Minimum" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "UPI Maximum" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "UPI Maximum" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "AEPS Daily" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "AEPS Daily" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "AEPS Weekly" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "AEPS Weekly" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "AEPS Monthly" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "AEPS Monthly" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "AEPS Minimum" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "AEPS Minimum" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "AEPS Maximum" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "AEPS Maximum" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "MATM Daily" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "MATM Daily" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "MATM Weekly" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "MATM Weekly" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "MATM Monthly" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "MATM Monthly" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "MATM Minimum" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "MATM Minimum" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "MATM Maximum" field should prompt to enter the valid inputs in Merchant Onboarding 
    Then the "MATM Maximum" field should prompt to enter the valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    Scenario: the "NextStep" button should be prompted to click on Risk Info in Merchant	 Onboarding
    Then the "NextStep" button should be prompted to click on Risk Info in Merchant
    
    
     #@run
     #Scenario: I visit the Card Bin Profile in Merchant Onboarding
     #When I visit the Card Bin Profile
     #
    #
    #Scenario: the "Card Bin Profile" field should prompt to Select the valid BIN in Merchant Onboarding 
    #Then the "Card Bin Profile" field should prompt to Select the valid BIN using sheetname "Merchant Regression" and rownumber 0
    #
     #@run
    #Scenario: the "Save" button should be prompted to click on Card Bin Profile in "Merchant Onboarding"
    #Then the "Save" button should be prompted to click on Card Bin Profile
    
    
    
    #@run
     #Scenario: the "NextStep" button should be prompted to click on Card Bin Profile in Merchant Onboarding
    #Then the "NextStep" button should be prompted to click on Risk Info
    
    
    @run
    Scenario: I visit the Discount Rate in Merchant Onboardng
     When I visit the Discount Rate 

    @run
    Scenario: the "Discount Rate" should prompt users to enter valid inputs in Merchant Onboardng
     Then the "Discount Rate" should prompt users to enter valid inputs using the sheet name "Discount Rate Merchant"
    
    @run 
    Scenario: The "NextStep" button should prompted to click on Discount Rate in Merchant Onboardng   
     Then The "NextStep" button should prompted to click on Discount Rate
     
     
  
  @run
     Scenario: I visit the Settlement Info in Merchant Onboardng
     When I visit the Settlement Info
     
@run     
     Scenario: the Settlement Info "ADD" button should be prompted to click in Merchant Onboardng
     Then the Settlement Info "ADD" button should be prompted to click
    
    @run 
     Scenario: the Settlement Info "Payment Mode" dropdown should prompt to select valid inputs in Merchant Onboardng
     Then the Settlement Info "Payment Mode" dropdown should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
    
    @run 
     Scenario: the Settlement Info "Account Type" dropdown should prompt to select the valid inputs in Merchant Onboardng
     Then the Settlement Info "Account Type" dropdown should prompt to select the valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     @run
     Scenario: the Settlement Info "Bank Account Number" field should prompt to enter valid inputs in Merchant Onboardng
     Then the Settlement Info "Bank Account Number" field should prompt to enter valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     @run
     Scenario: the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs in Merchant Onboardng
     Then the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
     
     @run
     Scenario: the SettlementInfo "Save" button should be prompted to click in Merchant Onboardng
     Then the SettlementInfo "Save" button should be prompted to click
     
     @run
     Scenario: the Settlement Info "Settlement Flag" dropdown should prompt to select valid inputs in Merchant Onboardng
     Then the Settlement Info "Settlement Flag" dropdown should prompt to select valid inputs using sheetname "Merchant Regression" and rownumber 0
     Then the SettlementInfo "Save" button should be prompted to click
     
     @run
     Scenario: the "NextStep" button should prompted to click on Settlement Info in Merchant Onboardng
     Then the "NextStep" button should prompted to click on Settlement Info in Merchant
         
     @run
    Scenario: I visit the KYC in Merchant Onboarding
    Given I visit the KYC in Aggregator
    
    @run
    Scenario: the KYC "Company Proof of address" field should prompt a selection based on the uploaded image in Merchant Onboarding     
    Then the KYC "Company Proof of address" field should prompt a selection based on the uploaded image using sheetname "Merchant Regression" and rownumber 0
    
    @run
    Scenario: The "NextStep" button should prompted to click on KYC in Merchant Onboarding     
    Then The "NextStep" button should prompted to click on KYC in Merchant
    
    
    
    
    Scenario: System Maker submits the application for verification in Merchant Onboarding
  When the System Maker clicks the "Submit for verification" button


       
Scenario: System Maker confirms submission by clicking the "Yes" button in Merchant Onboarding
  When the System Maker clicks the "Yes" button to confirm submission
  
          
Scenario: System Maker logs out by clicking profile and log-out button in Merchant Onboarding
  When the System Maker clicks on the profile and log-out button

       
Scenario: System Maker handles the pop-up and is redirected to the login page in Merchant Onboarding
  When the System Maker handles the pop-up by selecting the "Yes" button and redirected to login page
    
    
  Scenario: System verifier Login
 Given I visit the System Verifier Login using sheetname "Credentials" and rownumber 2
 And I enter the credentials and click a login button
    
	 
Scenario: System Verifier sees Onboarding in Sidemenu
   When System Verifier - Onboarding should be displayed in the side menu
    

Scenario: System Verifier sees side menu items in Onboarding
  Then the System Verifier should see Bank, Aggregators, ISO,SUB ISO, Groupmerchant, Merchant, and Terminal in the side menu of Onboarding
 

 Scenario: System Verifier clicks the Merchant module
    When the System Verifier clicks the Merchant module
   

 Scenario: System Verifier Ensure the ISO Status - Inprogress
    When the System Verifier ensure the Group Merchant status "Inprogress" using sheetname "Merchant Regression" and rownumber 0
  

Scenario: System Verifier - click on action (Three dot button) and select the view option
    When the System Verifier click on action Three dot button and select the view option
    
    
  Scenario: System Verifier checks "Sales Info" and clicks "Verified and Next" in Merchant Onboarding
  When the System Verifier checks "Sales Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons


  Scenario: System Verifier checks "Company Info" and clicks "Verified and Next" in Merchant Onboarding
  When the System Verifier checks "Company Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
  
  Scenario: System Verifier checks "Personal Info" and clicks "Verified and Next" in Merchant Onboarding
  When the System Verifier checks "Personal Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
 
 
  Scenario: System Verifier checks "Communication Info" and clicks "Verified and Next" in Merchant Onboarding
  When the System Verifier checks "Communication Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
   
  
   Scenario: System Verifier checks "Risk Info" and clicks "Verified and Next" in Merchant Onboarding
  When the System Verifier checks "Risk Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons  


Scenario: System Verifier checks "Discount Rate" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Discount Rate" to ensure mandatory details are added and clicks the "Verified and Next" buttons

  
  
  Scenario: System Verifier checks "Settlement Info" and clicks "Verified and Next" in Group Merchant Onboarding
  When the System Verifier checks "Settlement Info" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  
 
  #Scenario: System Verifier checks "WhiteLabel" and clicks "Verified and Next" in Group Merchant Onboarding
  #When the System Verifier checks "WhiteLabel" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  #
#
  #Scenario: System Verifier checks "Webhooks" and clicks "Verified and Next" in Group Merchant Onboarding
  #When the System Verifier checks "Webhooks" to ensure mandatory details are added and clicks the "Verified and Next" buttons
  #
  #Scenario: System Verifier checks "KYC" and clicks "Verified and Next" in Group Merchant Onboarding
  #When the System Verifier checks "KYC" to ensure mandatory details are added and clicks the "Verified and Next" buttons in ISO
  #When the System Verifier checks "KYC" to ensure mandatory details are added and clicks the "Verify Document" button
    
  
  Scenario: System verifier submits the application for Approval
  When the System verifier clicks the "Submit for Approval" button

 
  Scenario: System verifier confirms submission by clicking the "Yes" button
  When the System verifier clicks the "Yes" button to confirm submission
  

  Scenario: System verifier logs out by clicking profile and log-out button
  When the System verifier clicks on the profile and log-out button

 
  Scenario: System Verifier handles the pop-up and is redirected to the login page
  When the System verifier handles the pop-up by selecting the "Yes" button and redirected to login page
      
    
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
