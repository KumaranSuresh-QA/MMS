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

Feature: Aggregator Onboarding Form Validation

 This feature aims to test the functionality of the 'Aggregator Onboarding' within the application.
 

 Scenario: SuperAdmin Login
 Given I visit the SuperAdmin Login using sheetname "Bank" and rownumber 1
 And I enter the credentials and click the login button

Scenario: Verify VAS Commission label
    Given I visit the payfac onboarding page
    Then the First label name should be "VAS Commission"
    
Scenario: Verify "VAS Commission" Field Prompts to Select Yes/No
    Then the First "VAS Commission" field should prompt to select Yes or No based on the given input using sheetname "Aggregator" and rownumber 0
    

 Scenario: Verify Aggregator Application Date label
    Then the label name should be "Aggregator Application Date"
    
Scenario: Validate allowed "Aggregator Application Date" selection with valid input
    When the user select a valid date in the "Aggregator Application Date" field
    
    
 Scenario: Verify Agreement Date label
    Then the label name should be "Agreement Date"
    
 Scenario: Validate allowed "Agreement Date" selection with valid input
    When the user select a valid date in the "Agreement Date" field
    
     Scenario: Verify Aggregator Code label
    Then the label name should be "Aggregator Code"
    
Scenario: Verify Aggregator Code field does not allow proceeding without input
    Then the "Aggregator Code" field should not allow to proceed without any input data
    
 Scenario: Verify "Aggregator Code" field prompts for valid inputs 
    Then the "Aggregator Code" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
            
 Scenario: Verify Allow Self Merchant Onboard label
    Then the label name should be "Allow Self Merchant Onboard"
    
Scenario: Verify "Allow Self Merchant Onboard" Field Prompts to Select Yes/No
    Then the "Allow Self Merchant Onboard" field should prompt to select Yes or No based on the given input using sheetname "Aggregator" and rownumber 0
    
    
 Scenario: Verify Marsid label in Sales Info
    Then the label name should be "Marsid" in Sales Info
    
    Scenario: Verify "Marsid" field does not allow proceeding without input
    Then the "Marsid" field should not allow to proceed without any input data in Sales Info

Scenario: Verify "Marsid" field prompts for valid inputs
    Then the "Marsid" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
Scenario: Verify Auto Deactivation Days label in Sales Info
    Then the label name should be "Auto Deactivation Days" in Sales Info

Scenario: Verify "Auto Deactivation Days" field prompts for valid inputs
    Then the "Auto Deactivation Days" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    

Scenario: Verify VAS Commission label
    Then the Second label name should be "VAS Commission"
    
Scenario: Verify "VAS Commission" Field Prompts to Select Yes/No
    Then the Second "VAS Commission" field should prompt to select Yes or No based on the given input
    
 Scenario: Verify IS TMS Aggregator label
    Then the label name should be "IS TMS Aggregator"
    
Scenario: Verify "IS TMS Aggregator" Field Prompts to Select Yes/No
    Then the "IS TMS Aggregator" field should prompt to select Yes or No based on the given input using sheetname "Aggregator Regression" and rownumber 0      
    
    
 Scenario: Verify EKyc Required label
    Then the label name should be "EKyc Required"
    
Scenario: Verify "EKyc Required" Field Prompts to Select Yes/No
    Then the "EKyc Required" field should prompt to select Yes or No based on the given input using sheetname "Aggregator Regression" and rownumber 0
    
    
 Scenario: Verify "Next" Button is Clickable and Moves to Company Info 
 Then the "NextStep" button should be prompted to click on Sales Info   


 Scenario: Verify "Company Info" in Aggregator Info 
 When I Visit the Company Info

    
 Scenario: Verify Legal Name label
    Then the label name should be "Legal Name"
    
Scenario: Verify Legal Name field does not allow proceeding without input
    Then the "Legal Name" field should not allow to proceed without any input data
    
Scenario: Verify that the "Legal Name" field prompts for invalid input if Less than 2 characters are entered
      Then the "Legal Name" field should prompts for invalid input if Less than 2 characters are entered using sheetname "Aggregator" and rownumber 1
           
 Scenario: Verify "Legal Name" field prompts for valid inputs 
    Then the "Legal Name" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
 Scenario: Verify Brand Name label
    Then the label name should be "Brand Name"
    
Scenario: Verify Brand Name field does not allow proceeding without input
    Then the "Brand Name" field should not allow to proceed without any input data
    
 Scenario: Verify that the "Brand Name" field prompts for invalid input if Less than 2 characters are entered
      Then the "Brand Name" field should prompts for invalid input if Less than 2 characters are entered using sheetname "Aggregator" and rownumber 1   
    
 Scenario: Verify "Brand Name" field prompts for valid inputs 
    Then the "Brand Name" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    Scenario: Verify Registered Address label
    Then the label name should be "Registered Address"
    
Scenario: Verify Registered Address field does not allow proceeding without input
    Then the "Registered Address" field should not allow to proceed without any input data
    
 Scenario: Verify "Registered Address" field prompts for valid inputs 
    Then the "Registered Address" field should prompt to enter valid inputs within 230 characters using sheetname "Aggregator" and rownumber 0
    
   
  Scenario: Verify Registered Pincode label
    Then the label name should be "Registered Pincode"
    
  Scenario: Verify Registered Pincode field does not allow proceeding without input
    Then the "Registered Pincode" field should not allow to proceed without any input data
    
  Scenario: Verify Registered Pincode dropdown prompts for valid inputs
    Then the "Registered Pincode" dropdown should prompt to select valid inputs
    

   Scenario: Verify Registered State label
    Then the label name should be "Registered State"
    
   Scenario: Verify "Registered State Name" is Displayed when Pincode is Selected
   Then the Registered state name should be displayed
   
   Scenario: Verify Registered City label
    Then the label name should be "Registered City"
   
   Scenario: Verify "Registered City Name" is Displayed when Pincode is Selected
   Then the Registered city name should be displayed
   
   
    Scenario: Verify Business Type label
    Then the label name should be "Business Type"
    
     Scenario: Verify "Business Type" field does not allow proceeding without input
    Then the "Business Type" field should not allow to proceed without any input data
    
     Scenario: Verify Business Type dropdown prompts for valid inputs
    Then the "Business Type" dropdown should prompt to select valid inputs
    
    Scenario: Verify Established Year label
    Then the label name should be "Established Year"
    
    Scenario: Validate allowed "Established Year" selection with valid input
    When the user selects a valid date in the "Established Year" field
    
    
    Scenario: Verify Registered Number label
    Then the label name should be "Registered Number"
    
    Scenario: Verify Registered Number field does not allow proceeding without input
    Then the "Registered Number" field should not allow to proceed without any input data
    
    Scenario: Verify "Registered Number" field prompts for valid inputs 
    Then the "Registered Number" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
    Scenario: Verify Company PAN label
    Then the label name should be "Company PAN"
    
    Scenario: Verify Company PAN field does not allow proceeding without input
    Then the "Company PAN" field should not allow to proceed without any input data
    
     Scenario: Verify "Company PAN" field prompts for Invalid inputs 
     Then the "Company PAN" field should prompt to enter Invalid inputs using sheetname "Aggregator" and rownumber 1
    
    Scenario: Verify "Company PAN" field prompts for valid inputs 
    Then the "Company PAN" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
     Scenario: Verify GSTIN label
    Then the label name should be "GSTIN"
    
    Scenario: Verify GSTIN field does not allow proceeding without input
    Then the "GSTIN" field should not allow to proceed without any input data
    
     Scenario: Verify "GSTIN" field prompts for Invalid inputs 
     Then the "GSTIN" field should prompt to enter Invalid inputs using sheetname "Aggregator" and rownumber 1
    
    Scenario: Verify "GSTIN" field prompts for valid inputs 
    Then the "GSTIN" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
     Scenario: Verify Statement Frequency label
    Then the label name should be "Statement Frequency" in Company Info
    
     Scenario: Verify Statement Frequency dropdown prompts for valid inputs in Company Info
    Then the "Statement Frequency" dropdown should prompt to select valid inputs in Company Info
    
     Scenario: Verify Statement Frequency label
    Then the label name should be "Statement Type" in Company Info
    
    Scenario: Verify "Statement Type" field does not allow proceeding without input
    Then the "Statement Type" field should not allow to proceed without any input data in Company Info
    
     Scenario: Verify Statement Frequency dropdown prompts for valid inputs in Company Info
    Then the "Statement Type" dropdown should prompt to select valid inputs in Company Info
    
    
    Scenario: Verify Email Domain label
    Then the label name should be "Email Domain"
    
    Scenario: Verify "Email Domain" field does not allow proceeding without input
    Then the "Email Domain" field should not allow to proceed without any input data
    
    Scenario: Verify Email Domain Field Prompts for Invalid Alphabet Domain Names
    Then the "Email Domain" field should prompt to enter invalid alphabet domain names using sheetname "Aggregator" and rownumber 1


    Scenario: Verify Email Domain Field Prompts for Invalid Number Domain Names
    Then the "Email Domain" field should prompt to enter invalid number domain names using sheetname "Aggregator" and rownumber 2   
    
    Scenario: Verify "Email Domain" field prompts for valid inputs 
    Then the "Email Domain" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
     Scenario: Verify "Next" Button is Clickable and Moves to Personal Info
     Then the "NextStep" button should be prompted to click on Company Info
     
     Scenario: Verify Personal Info "Add" Button is Prompted to Click
    When I visit the Personal Info
    Then the "Add" button should be prompted to click in personal info
    
    
    Scenario: Verify "Personal Info" Label Name is "Title"
    Then the label name should be "Title" in Personal Info
    
    Scenario: Verify "Title" Field Does Not Allow Proceeding Without Input Data
    Then the "Title" field should not allow proceeding without any input data in personal info
    
    Scenario: Verify "Title" dropdown prompts for valid inputs in Personal Info
    Then the "Title" dropdown should prompt to select valid inputs in Personal Info
    
    
     Scenario: Verify "Personal Info" Label Name is "First Name"
    Then the label name should be "First Name" in Personal Info
    
    Scenario: Verify "First Name" Field Does Not Allow Proceeding Without Input Data
    Then the "First Name" field should not allow proceeding without any input data in personal info
    
    Scenario: Verify Personal Info Info "First Name" Field Does Not Allow Numeric Characters
     Then the "First Name" field should not allow numeric characters using sheetname "Aggregator" and rownumber 1
    
     
      Scenario: Verify Personal Info "First Name" Field Does Not Allow Special Characters
     Then the "First Name" field should not allow special characters using sheetname "Aggregator" and rownumber 2         
      
      Scenario: Verify Personal Info "First Name" Field Prompts for Valid Inputs
       Then the "First Name" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
       
     
     Scenario: Verify "Personal Info" Label Name is "Last Name"
    Then the label name should be "Last Name" in Personal Info
    
    
    Scenario: Verify Personal Info "Last Name" Field Does Not Allow Numeric Characters
     Then the "Last Name" field should not allow numeric characters using sheetname "Aggregator" and rownumber 1
    
     
      Scenario: Verify Personal Info "Last Name" Field Does Not Allow Special Characters
     Then the "Last Name" field should not allow special characters using sheetname "Aggregator" and rownumber 2         
      
      Scenario: Verify Personal Info "Last Name" Field Prompts for Valid Inputs
       Then the "Last Name" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
       
       Scenario: Verify "Personal Info" Label Name is "Date of Birth"
       Then the label name should be "Date of Birth" in Personal Info
       
       Scenario: Verify "Date Of Birth" Field Does Not Allow Proceeding Without Input Data
      Then the "Date Of Birth" field should not allow proceeding without any input data in personal info
       
       Scenario: Validate allowed "Date Of Birth" selection with valid input in Personal Info
       When the user select a valid date in the "Date Of Birth" field in Personal Info
       
      Scenario: Verify "PAN" label in Personal Info
      Then the label name should be "PAN" in Personal Info
    
      Scenario: Verify "PAN" field does not allow proceeding without input in Personal Info
      Then the "PAN" field should not allow to proceed without any input data in Personal Info
    
      Scenario: Verify "PAN" field prompts for Invalid inputs in Personal Info
      Then the "PAN" field should prompt to enter Invalid inputs with PAN Format in Personal Info using sheetname "Aggregator" and rownumber 1
    
      Scenario: Verify "PAN" field prompts for valid inputs in personal Imfo
      Then the "PAN" field should prompt to enter valid inputs with PAN Format in Personal Info using sheetname "Aggregator" and rownumber 0
      
        Scenario: Verify "Address" label in Personal Info
       Then the label name should be "Address" in Personal Info
    
    Scenario: Verify "Address" field does not allow proceeding without input in personal info
    Then the "Address" field should not allow to proceed without any input data in personal info
    
    Scenario: Verify "Address" field prompts for valid inputs in personal info 
    Then the "Address" field should prompt to enter valid inputs within 230 characters in personal info using sheetname "Aggregator" and rownumber 0
    
   
    Scenario: Verify "Pincode" label in Personal Info
     Then the label name should be "Pincode" in Personal Info
    
    Scenario: Verify Pincode field does not allow proceeding without input in Personal Info
    Then the "Pincode" field should not allow to proceed without any input data in Personal Info
    
    Scenario: Verify Pincode dropdown prompts for valid inputs in Personal Info
    Then the "Pincode" dropdown should prompt to select valid inputs in Personal Info
    

    Scenario: Verify "State" label in Personal Info
     Then the label name should be "State" in Personal Info
    
    Scenario: Verify "State Name" is Displayed when Pincode is Selected in Personal Info
    Then the "state name" should be displayed in Personal info
   
    Scenario: Verify Registered City label
    Then the label name should be "City" in Personal Info
   
    Scenario: Verify "City Name" is Displayed when Pincode is Selected in Personal Info
    Then the "City name" should be displayed in Personal info
    
    Scenario: Verify "Personal Info" Label Name is "Mobile Number"
    Then the label name should be "Mobile Number" in Personal Info  


    Scenario: Verify "Mobile Number" Field Does Not Allow Proceeding Without Input Data in Personal Info
    Then the "Mobile Number" field should not allow proceeding without any input data in Personal Info              
        
    
    Scenario: Verify "Mobile Number" Field Does Not Allow Less Than Required Digits in Personal Info
    Then the "Mobile Number" field should not allow inputs with fewer digits than required in Personal Info using sheetname "Aggregator" and rownumber 1


    Scenario: Verify "Mobile Number" Field Does Not Allow More Than Required Digits in Personal Info
    Then the "Mobile Number" field should not allow inputs with more digits than required in Personal Info using sheetname "Aggregator" and rownumber 2


    Scenario: Verify "Mobile Number" Field Prompts for Valid Inputs in Personal Info
    Then the "Mobile Number" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator" and rownumber 0
    
    Scenario: Verify "Personal Info" Label Name is "Telephone"
    Then the label name should be "Telephone" in Personal Info    

    
Scenario: Verify "Telephone" Field Does Not Allow Less Than Required Digits in Personal Info
Then the "Telephone" field should not allow inputs with fewer digits than required in Personal Info using sheetname "Aggregator" and rownumber 1


Scenario: Verify "Telephone" Field Does Not Allow More Than Required Digits in Personal Info
Then the "Telephone" field should not allow inputs with more digits than required in Personal Info using sheetname "Aggregator" and rownumber 2


Scenario: Verify "Telephone" Field Does Not Allow Numbers Without Starting Digit 0 in Personal Info
Then the "Telephone" field should not allow numbers that do not start with the digit 0 in Personal Info using sheetname "Aggregator" and rownumber 0


Scenario: Verify "Telephone" Field Prompts for Valid Inputs in Personal Info
    Then the "Telephone" field should prompt to enter valid inputs in Personal Info
    | TelePhone Number   |
    | 0461234524252      |
    
    
Scenario: Verify "Personal Info" Label Name is "Email ID"
    Then the label name should be "Email ID" in Personal Info
    
    

Scenario: Verify "Email ID" Field Does Not Allow Proceeding Without Input Data in Personal Info
    Then the "Email ID" field should not allow proceeding without any input data in Personal Info


   
Scenario: Verify "Email ID" Field Does Not Allow Missing '@' Symbol in Personal Info
Then the "Email ID" field should not allow inputs missing the '@' symbol in personal info using sheetname "Aggregator" and rownumber 1


Scenario: Verify "Email ID" Field Does Not Allow Missing Domain in Personal Info
Then the "Email ID" field should not allow inputs missing the domain name in Personal Info using sheetname "Aggregator" and rownumber 2



Scenario: Verify "Email ID" Field Does Not Allow Consecutive Dots in Personal Info
Then the Personal Info "Email ID" field should not allow consecutive dots in the email address using sheetname "Aggregator" and rownumber 3


Scenario: Verify "Email ID" Field Does Not Allow Spaces in Personal Info
Then the Personal Info "Email ID" field should not allow spaces in the email address using sheetname "Aggregator" and rownumber 4


Scenario: Verify Communication "Email ID" Field Prompts for Valid Inputs in Personal Info
 Then the "Email ID" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator" and rownumber 0
 
 Scenario: Verify "Personal Info" Label Name is "Nationality"
    Then the label name should be "Nationality" in Personal Info
    
    Scenario: Verify "Nationality" Field Does Not Allow Proceeding Without Input Data
    Then the "Nationality" field should not allow proceeding without any input data in personal info
    
    Scenario: Verify Personal Info Info "Nationality" Field Does Not Allow Numeric Characters
     Then the "Nationality" field should not allow numeric characters using sheetname "Aggregator" and rownumber 1
    
     
      Scenario: Verify Personal Info "Nationality" Field Does Not Allow Special Characters
     Then the "Nationality" field should not allow special characters using sheetname "Aggregator" and rownumber 2       
      
      Scenario: Verify Personal Info "Nationality" Field Prompts for Valid Inputs
       Then the "Nationality" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0     
    
     Scenario: Verify "Personal Info" Label Name is "Aadhaar Number"
    Then the label name should be "Aadhaar Number" in Personal Info             
        
    
    Scenario: Verify "Aadhaar Number" Field Does Not Allow Less Than Required Digits in Personal Info
    Then the "Aadhaar Number" field should not allow inputs with fewer than 12 digits in Personal Info using sheetname "Aggregator" and rownumber 1


    Scenario: Verify "Aadhaar Number" Field Does Not Allow More Than Required Digits in Personal Info
    Then the "Aadhaar Number" field should not allow inputs with more than 12 digits in Personal Info using sheetname "Aggregator" and rownumber 2


    Scenario: Verify "Aadhaar Number" Field Prompts for Valid Inputs in Personal Info
    Then the "Aadhaar Number" field should prompt to enter valid inputs in Personal Info using sheetname "Aggregator" and rownumber 0
    
    
    Scenario: Verify "Personal Info" Label Name is "Passport"
    Then the label name should be "Passport" in Personal Info
    
    
    Scenario: Verify Personal Info Info "Passport" Field Does Not Allow Only Numeric Characters
     Then the "Passport" field should not allow only numeric characters using sheetname "Aggregator" and rownumber 1
    
     
      Scenario: Verify Personal Info "Passport" Field Does Not Allow Special Characters
     Then the "Passport" field should not allow special characters using sheetname "Aggregator" and rownumber 2       
      
      Scenario: Verify Personal Info "Passport" Field Prompts for Valid Inputs
       Then the "Passport" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
       
       Scenario: Verify "Personal Info" Label Name is "Passport Expiry Date"
      Then the label name should be "Passport Expiry Date" in Personal Info
      
       Scenario: Validate allowed "Passport Expiry Date" selection with valid input in Personal Info
       Then the user select a valid date in the "Passport Expiry Date" field in Personal Info
       
       Scenario: Verify "Save" Button is Prompted to Click on Personal Info
       Then the "Save" button should be prompted to click on Personal Info
    
     
      Scenario: Verify "Next" Button is Clickable and Moves to Communication Info
      Then the "NextStep" button should be prompted to click on Personal Info
      
    Scenario: Verify Communication Info "Add" Button is Prompted to Click
    When I visit the Communication Info
    Then the "Add" button should be prompted to click
    

 Scenario: Verify "Communication Info" Label Name is "Name"
    When I click on the "Communication Name" field
    Then the label name should be "Name"


         
Scenario: Verify "Communication Name" Field Does Not Allow Proceeding Without Input Data
    Then the "Communication Name" field should not allow proceeding without any input data    
  
     
Scenario: Verify Communication Info "Name" Field Does Not Allow Numeric Characters
     Then the "Name" field should not allow numeric characters using sheetname "Aggregator" and rownumber 1
    
     
Scenario: Verify Communication Info "Name" Field Does Not Allow Special Characters
     Then the "Name" field should not allow special characters using sheetname "Aggregator" and rownumber 2         
    

 
Scenario: Verify Communication Info "Name" Field Prompts for Valid Inputs
    Then the "Name" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0   
    


Scenario: Verify "Communication Info" Label Name is "Position"
    When I click on the "Position" field
    Then the label name should be "Position"

    
Scenario: Verify "Position" Field Does Not Allow Proceeding Without Input Data
    Then the "Position" field should not allow proceeding without any input data    
    
    
Scenario: Verify Communication Info "Position" Field Does Not Allow Numeric Characters
     Then the "Position" field should not allow numeric characters using sheetname "Aggregator" and rownumber 1
    
    
Scenario: Verify Communication Info "Position" Field Does Not Allow Special Characters
     Then the "Position" field should not allow special characters using sheetname "Aggregator" and rownumber 2
     
     
Scenario: Verify Communication Info "Position" Field Prompts for Valid Inputs
  Then the "Position" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0     
       
    

Scenario: Verify "Communication Info" Label Name is "Phone Number"
    When I click on the "Phone Number" field
    Then the label name should be "Phone Number"    

    
Scenario: Verify Communication "Phone Number" Field Does Not Allow Less Than Required Digits
Then the "Phone Number" field should not allow inputs with fewer digits than required using sheetname "Aggregator" and rownumber 1


Scenario: Verify Communication "Phone Number" Field Does Not Allow More Than Required Digits
Then the "Phone Number" field should not allow inputs with more digits than required using sheetname "Aggregator" and rownumber 2


Scenario: Verify Communication "Phone Number" Field Does Not Allow Numbers Without Starting Digit 0
Then the "Phone Number" field should not allow numbers that do not start with the digit 0 using sheetname "Aggregator" and rownumber 0


Scenario: Verify Communication "Phone Number" Field Prompts for Valid Inputs
    Then the "Phone Number" field should prompt to enter valid inputs
    | PhoneNumber   |
    | 0461234524252 |    
    
       
Scenario: Verify "Communication Info" Label Name is "Mobile Number"
    When I click on the "Mobile Number" field
    Then the label name should be "Mobile Number"    


Scenario: Verify "Mobile Number" Field Does Not Allow Proceeding Without Input Data
    Then the "Mobile Number" field should not allow proceeding without any input data              
        
    
Scenario: Verify Communication "Mobile Number" Field Does Not Allow Less Than Required Digits
Then the "Mobile Number" field should not allow inputs with fewer digits than required using sheetname "Aggregator" and rownumber 1


Scenario: Verify Communication "Mobile Number" Field Does Not Allow More Than Required Digits
Then the "Mobile Number" field should not allow inputs with more digits than required using sheetname "Aggregator" and rownumber 2


Scenario: Verify Communication "Mobile Number" Field Prompts for Valid Inputs
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0   
    
     
Scenario: Verify "Communication Info" Label Name is "Email ID"
    When I click on the "Email ID" field
    Then the label name should be "Email ID"
    
    

Scenario: Verify Communication "Email ID" Field Does Not Allow Proceeding Without Input Data
    Then the "Email ID" field should not allow proceeding without any input data


   
Scenario: Verify Communication "Email ID" Field Does Not Allow Missing '@' Symbol
Then the "Email ID" field should not allow inputs missing the '@' symbol using sheetname "Aggregator" and rownumber 1


Scenario: Verify Communication "Email ID" Field Does Not Allow Missing Domain
Then the "Email ID" field should not allow inputs missing the domain name using sheetname "Aggregator" and rownumber 2



Scenario: Verify Communication "Email ID" Field Does Not Allow Consecutive Dots
Then the "Email ID" field should not allow consecutive dots in the email address using sheetname "Aggregator" and rownumber 3


Scenario: Verify Communication "Email ID" Field Does Not Allow Spaces
Then the "Email ID" field should not allow spaces in the email address using sheetname "Aggregator" and rownumber 4


Scenario: Verify Communication "Email ID" Field Prompts for Valid Inputs
 Then the "Email ID" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
 
 
     
Scenario: Verify "Communication Info" Label Name is "UserName"
    When I click on the "UserName" field
    Then the label name should be "UserName"


Scenario: Verify "Username" Field is Auto-Filled Based on Entered Email ID
    Then the "Username" field should be auto-filled based on the entered email ID using sheetname "Aggregator" and rownumber 0


Scenario: Verify "Communication Info" Label Name is "AD User"
    Then the label name should be "AD User"

    
Scenario: Verify "AD User" Field Prompts to Select Yes/No
    Then the "AD User" field should prompt to select Yes or No based on the given input    


Scenario: Verify "Save" Button is Prompted to Click on Communication Info
    Then the "Save" button should be prompted to click on Communication Info


Scenario: Verify "NextStep" Button is Prompted to Click on Communication Info
    Then the "NextStep" button should be prompted to click on Communication Info
    
    
Scenario: Verify Channel Config "Add" Button is Prompted to Click
    When I visit the Channel Config in Aggregator
    Then the Channel Config "Add" button should be prompted to click in Aggregator
    
    
 Scenario: Verify "Channel Config" Label Name is "Bank Name"
    Then the label name should be "Bank Name" in Channel Config
       
Scenario: Verify Channel Config "Bank Name" field does not allow proceeding without input
    Then the Channel Config "Bank Name" field should not allow to proceed without any input data    
    
       
Scenario: Verify that the Channel Config "Bank Name" field prompts for invalid input if a number is entered
      Then the Channel Config "Bank Name" field prompts for invalid input if a number is entered using sheetname "Aggregator" and rownumber 1
     
                  
Scenario: Verify that the Channel Config "Bank Name" field prompts for invalid input if special characters are entered
          Then the Channel Config "Bank Name" field prompts for invalid input if special characters are entered using sheetname "Aggregator" and rownumber 2
    
        
Scenario: Verify that the Channel Config "Bank Name" field accepts valid inputs.
    Then the Channel Config "Bank Name" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
 
    
 Scenario: Verify "Channel Config" Label Name is "Channel"
    Then the label name should be "Channel" in Channel Config
    
     
Scenario: Verify Channel Config "Channel" field does not allow proceeding without input
    Then the Channel Config "Channel" field should not allow to proceed without any input data in Aggregator      
    
    
Scenario: Verify "POS Channel" Field is Prompted to Select Based on given Input
    Then the "POS Channel" field should prompt to select the channels based on the given input in Aggregator
    
   
 Scenario: Verify "Channel Config" Label Name is "Network"
    Then the label name should be "Network" in Channel Config
    
    
Scenario: Verify Channel Config "Network" field does not allow proceeding without input
    Then the Channel Config "Network" field should not allow to proceed without any input data in Aggregator    
    
     
Scenario: Verify "POS Network" Field is Prompted to Select Based on given Input
    Then the "POS Network" field should prompt to select the channels based on the given input in Aggregator
    
       
 Scenario: Verify "Channel Config" Label Name is "Transaction Sets"
    Then the label name should be "Transaction Sets" in Channel Config
    
     
Scenario: Verify Channel Config "Transaction Sets" field does not allow proceeding without input
    Then the Channel Config "Transaction Sets" field should not allow to proceed without any input data in Aggregator       
    
      
Scenario: Verify "POS Transaction Sets" Field is Prompted to Select Based on Given Input
    Then the "POS Transaction Sets" field should prompt to select the transaction sets based on the given input in Aggregator
    
    
   
 Scenario: Verify "Channel Config" Label Name is "Start Date"
    Then the label name should be "Start Date" in Channel Config    
    
  
Scenario: Verify "Start Date" Field is Prompted to Select Based on Given Input
    Then the "Start Date" field should prompt to select the transaction sets based on the given input in Aggregator
    
    
  
 Scenario: Verify "Channel Config" Label Name is "END Date"
    Then the label name should be "END Date" in Channel Config    
    
      
Scenario: Verify "End Date" Field is Prompted to Select Based on Given Input
    Then the "End Date" field should prompt to select the transaction sets based on the given input in Aggregator
    
    
Scenario: Verify "Save" Button is Prompted to Click on Pos Channel Config
    Then the "Save" button should be prompted to click on POS Channel Config           
       
        


    
Scenario: Verify Channel Config "Add" Button is Prompted to Click
    Then the Channel Config "Add" button should be prompted to click in Aggregator
    
    
 Scenario: Verify "Channel Config" Label Name is "Bank Name"
    Then the label name should be "Bank Name" in Channel Config
    
    
Scenario: Verify Channel Config "Bank Name" field does not allow proceeding without input
    Then the Channel Config "Bank Name" field should not allow to proceed without any input data    
    
       
Scenario: Verify that the Channel Config "Bank Name" field prompts for invalid input if a number is entered
      Then the Channel Config "Bank Name" field prompts for invalid input if a number is entered using sheetname "Aggregator" and rownumber 1
     
                  
Scenario: Verify that the Channel Config "Bank Name" field prompts for invalid input if special characters are entered
          Then the Channel Config "Bank Name" field prompts for invalid input if special characters are entered using sheetname "Aggregator" and rownumber 2
    
        
Scenario: Verify that the Channel Config "Bank Name" field accepts valid inputs.
    Then the Channel Config "Bank Name" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
 
   
 Scenario: Verify "Channel Config" Label Name is "Channel"
    Then the label name should be "Channel" in Channel Config
    
     
Scenario: Verify Channel Config "Channel" field does not allow proceeding without input
    Then the Channel Config "Channel" field should not allow to proceed without any input data in Aggregator      
    
    
Scenario: Verify "UPI Channel" Field is Prompted to Select Based on given Input
    Then the "UPI Channel" field should prompt to select the channels based on the given input in Aggregator
    
    
   
 Scenario: Verify "Channel Config" Label Name is "Transaction Sets"
    Then the label name should be "Transaction Sets" in Channel Config
    
   
Scenario: Verify Channel Config "Transaction Sets" field does not allow proceeding without input
    Then the Channel Config "Transaction Sets" field should not allow to proceed without any input data in Aggregator       
    
   
Scenario: Verify "UPI Transaction Sets" Field is Prompted to Select Based on Given Input
    Then the "UPI Transaction Sets" field should prompt to select the transaction sets based on the given input in Aggregator
    
    
   
 Scenario: Verify "Channel Config" Label Name is "Start Date"
    Then the label name should be "Start Date" in Channel Config    
    
  
Scenario: Verify "Start Date" Field is Prompted to Select Based on Given Input
    Then the "Start Date" field should prompt to select the transaction sets based on the given input in Aggregator
    
    
   
 Scenario: Verify "Channel Config" Label Name is "END Date"
    Then the label name should be "END Date" in Channel Config    
    
  
Scenario: Verify "End Date" Field is Prompted to Select Based on Given Input
    Then the "End Date" field should prompt to select the transaction sets based on the given input in Aggregator
    
    
Scenario: Verify "Save" Button is Prompted to Click on Pos Channel Config
    Then the "Save" button should be prompted to click on POS Channel Config   
    
        
    
    
  
Scenario: Verify Channel Config "Add" Button is Prompted to Click
    Then the Channel Config "Add" button should be prompted to click in Aggregator
    
   
 Scenario: Verify "Channel Config" Label Name is "Bank Name"
    Then the label name should be "Bank Name" in Channel Config
    
    
Scenario: Verify Channel Config "Bank Name" field does not allow proceeding without input
    Then the Channel Config "Bank Name" field should not allow to proceed without any input data    
    
       
Scenario: Verify that the Channel Config "Bank Name" field prompts for invalid input if a number is entered
      Then the Channel Config "Bank Name" field prompts for invalid input if a number is entered using sheetname "Aggregator" and rownumber 1
     
                  
Scenario: Verify that the Channel Config "Bank Name" field prompts for invalid input if special characters are entered
          Then the Channel Config "Bank Name" field prompts for invalid input if special characters are entered using sheetname "Aggregator" and rownumber 2
    
        
Scenario: Verify that the Channel Config "Bank Name" field accepts valid inputs.
    Then the Channel Config "Bank Name" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
 
  
 Scenario: Verify "Channel Config" Label Name is "Channel"
    Then the label name should be "Channel" in Channel Config
    

Scenario: Verify Channel Config "Channel" field does not allow proceeding without input
    Then the Channel Config "Channel" field should not allow to proceed without any input data in Aggregator      
    
    
Scenario: Verify "AEPS Channel" Field is Prompted to Select Based on given Input
    Then the "AEPS Channel" field should prompt to select the channels based on the given input in Aggregator
    
    
   
 Scenario: Verify "Channel Config" Label Name is "Transaction Sets"
    Then the label name should be "Transaction Sets" in Channel Config
    
    
Scenario: Verify Channel Config "Transaction Sets" field does not allow proceeding without input
    Then the Channel Config "Transaction Sets" field should not allow to proceed without any input data in Aggregator       
    
 
Scenario: Verify "AEPS Transaction Sets" Field is Prompted to Select Based on Given Input
    Then the "AEPS Transaction Sets" field should prompt to select the transaction sets based on the given input in Aggregator
    
    
   
 Scenario: Verify "Channel Config" Label Name is "Start Date"
    Then the label name should be "Start Date" in Channel Config    
    
  
Scenario: Verify "Start Date" Field is Prompted to Select Based on Given Input
    Then the "Start Date" field should prompt to select the transaction sets based on the given input in Aggregator
    
      
 Scenario: Verify "Channel Config" Label Name is "END Date"
    Then the label name should be "END Date" in Channel Config    
    
  
Scenario: Verify "End Date" Field is Prompted to Select Based on Given Input
    Then the "End Date" field should prompt to select the transaction sets based on the given input in Aggregator
    
    
Scenario: Verify "Save" Button is Prompted to Click on Pos Channel Config
    Then the "Save" button should be prompted to click on POS Channel Config
  
  
     
Scenario: Verify "NextStep" Button is Prompted to Click on channel Config
    Then the "NextStep" button should be prompted to click on channel config
    
        
Scenario: Verify KYC "Company PAN" field does not allow proceeding without input
    Given I visit the KYC in Aggregator
    Then the KYC "Company PAN" field should not allow to proceed without any input data in Aggregator
    
    
Scenario: Verify that the KYC "Company PAN" field prompts selection based on uploaded image
    Then the KYC "Company PAN" field should prompt a selection based on the uploaded image in the Aggregator using sheetname "Aggregator" and rownumber 0
    
    
Scenario: Verify KYC "GST Registration Certificate" field does not allow proceeding without input
    Then the KYC "GST Registration Certificate" field should not allow to proceed without any input data in Aggregator
    
    
     
Scenario: Verify that the KYC "GST Registration Certificate" field prompts selection based on uploaded image
    Then the KYC "GST Registration Certificate" field should prompt a selection based on the uploaded image in the Aggregator using sheetname "Aggregator" and rownumber 0
                
  
    Scenario: Verify "NextStep" Button is Prompted to Click on KYC
    Then the "NextStep" button should be prompted to click on KYC
    
    
   
    Scenario: Verify the checkbox can be checked and unchecked
    When I visit the Risk Info 
    Then the FRMParameterscheckbox should be checked
    
    Then the FRMParameterscheckbox should be unchecked
    
    
    Scenario: Verify "Risk Info" Label Name is "Velocity Check Minutes".
    When I click on the "Velocity Check Minutes" field in Risk Info
    Then the label name should be "Velocity Check Minutes" in Risk Info
    
    
 Scenario: Verify Risk Info "Velocity Check Minutes" Field Does Not Allow Proceeding Without Input Data
    Then the "Velocity Check Minutes" field should not allow proceeding without any input data in Risk Info

    
Scenario: Verify Risk Info "Velocity Check Minutes" Field Prompts for Valid Inputs
 Then the "Velocity Check Minutes" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator" and rownumber 0 
    
   
Scenario: Verify "Risk Info" Label Name is "Velocity Check Count".
    When I click on the "Velocity Check Count" field in Risk Info
    Then the label name should be "Velocity Check Count" in Risk Info
  
      
 Scenario: Verify Risk Info "Velocity Check Count" Field Does Not Allow Proceeding Without Input Data
    Then the "Velocity Check Count" field should not allow proceeding without any input data in Risk Info
   
    
  Scenario: Verify Risk Info "Velocity Check Count" Field Prompts for Valid Inputs
 Then the "Velocity Check Count" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator" and rownumber 0  
    
 
 Scenario: Verify "Risk Info" Label Name is "Cash@POS Count".
    When I click on the "Cash@POS Count" field in Risk Info
    Then the label name should be "Cash@POS Count" in Risk Info
  
   
 Scenario: Verify Risk Info "Cash@POS Count" Field Does Not Allow Proceeding Without Input Data
    Then the "Cash@POS Count" field should not allow proceeding without any input data in Risk Info
   
  
  Scenario: Verify Risk Info "Cash@POS Count" Field Prompts for Valid Inputs
 Then the "Cash@POS Count" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator" and rownumber 0      
    
    
Scenario: Verify "Risk Info" Label Name is "International Card Acceptence".
      Then the label name should be "International Card Acceptence" in Risk Info
      
      
 Scenario: Verify Risk Info "International Card Acceptence" Field Prompts to Select Yes/No
    Then the "International Card Acceptence" field should prompt to select Yes or No based on the given input in Risk Info     
    
 
    
 Scenario: Verify "Risk Info" Label Name is "ICA Daily".
    When I click on the "ICA Daily" field in Risk Info
    Then the label name should be "Daily" in Risk Info
  
 
Scenario: Verify Risk Info "ICA Daily" Field Does Not Allow Proceeding Without Input Data
    Then the "ICA Daily" field should not allow proceeding without any input data in Risk Info
   
    
  
 Scenario: Verify Risk Info "ICA Daily" Field Prompts for Valid Inputs
    Then the "ICA Daily" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator" and rownumber 0
    
    
   
 Scenario: Verify "Risk Info" Label Name is "ICA Weekly".
    When I click on the "ICA Weekly" field in Risk Info
    Then the label name should be "Weekly" in Risk Info
  
  
Scenario: Verify Risk Info "ICA Weekly" Field Does Not Allow Proceeding Without Input Data
    Then the "ICA Weekly" field should not allow proceeding without any input data in Risk Info
    
   
     Scenario: Verify Risk Info "ICA Weekly" Field Does not allow less than "ICA Daily"
      Then the "ICA Weekly" field Must be greater than "ICA Daily" in Risk Info using sheetname "Aggregator" and rownumber 1
    
    
     Scenario: Verify Risk Info "ICA Weekly" Field Equal Value not allowed "ICA Daily"
    Then the "ICA Weekly" field Must be greater than "ICA Daily" in Risk Info using sheetname "Aggregator" and rownumber 2
    
    
    Scenario: Verify Risk Info "ICA Weekly" Field Prompts for Valid Inputs
    Then the "ICA Weekly" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator" and rownumber 0                               
    
    
  
 Scenario: Verify "Risk Info" Label Name is "ICA Monthly".
    When I click on the "ICA Monthly" field in Risk Info
    Then the label name should be "Monthly" in Risk Info
  
 
Scenario: Verify Risk Info "ICA Monthly" Field Does Not Allow Proceeding Without Input Data
    Then the "ICA Monthly" field should not allow proceeding without any input data in Risk Info
    
   
 Scenario: Verify Risk Info "ICA Monthly" Field Does not allow less than "ICA Weekly"
    Then the "ICA Monthly" field Must be greater than "ICA Weekly" in Risk Info using sheetname "Aggregator" and rownumber 1
    
    
    
     Scenario: Verify Risk Info "ICA Monthly" Field Equal Value not allowed "ICA Weekly"
    Then the "ICA Monthly" field Must be greater than "ICA Weekly" in Risk Info using sheetname "Aggregator" and rownumber 2 
    
  
 Scenario: Verify Risk Info "ICA Monthly" Field Prompts for Valid Inputs
    Then the "ICA Monthly" field should prompt to enter valid inputs in Risk Info using sheetname "Aggregator" and rownumber 0
    
    
  
    
  Scenario: Verify Risk Info "UPI Daily" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Daily" field should not allow proceeding without any input data
    
  
 Scenario: Verify Risk Info "UPI Daily" Field Prompts for Valid Inputs 
    Then the "UPI Daily" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
   
  
Scenario: Verify Risk Info "UPI Weekly" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Weekly" field should not allow proceeding without any input data

   
 Scenario: Verify Risk Info "UPI Weekly" Field Prompts for Valid Inputs
    Then the "UPI Weekly" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0                               
    
  
   
Scenario: Verify Risk Info "UPI Monthly" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Monthly" field should not allow proceeding without any input data
    
  
 Scenario: Verify Risk Info "UPI Monthly" Field Prompts for Valid Inputs
    Then the "UPI Monthly" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
  
Scenario: Verify Risk Info "UPI Minimum" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Minimum" field should not allow proceeding without any input data
    
  
 Scenario: Verify Risk Info "UPI Minimum" Field Prompts for Valid Inputs
    Then the "UPI Minimum" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
    
Scenario: Verify Risk Info "UPI Maximum" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Maximum" field should not allow proceeding without any input data
    

 Scenario: Verify Risk Info "UPI Maximum" Field Prompts for Valid Inputs
    Then the "UPI Maximum" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    

Scenario: Verify Risk Info "AEPS Daily" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Daily" field should not allow proceeding without any input data
    
  
 Scenario: Verify Risk Info "AEPS Daily" Field Prompts for Valid Inputs
    Then the "AEPS Daily" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
   
   
Scenario: Verify Risk Info "AEPS Weekly" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Weekly" field should not allow proceeding without any input data
    
    
 Scenario: Verify Risk Info "AEPS Weekly" Field Prompts for Valid Inputs
    Then the "AEPS Weekly" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0                               
    
  

Scenario: Verify Risk Info "AEPS Monthly" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Monthly" field should not allow proceeding without any input data
    
   
 Scenario: Verify Risk Info "AEPS Monthly" Field Prompts for Valid Inputs
    Then the "AEPS Monthly" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
 
Scenario: Verify Risk Info "AEPS Minimum" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Minimum" field should not allow proceeding without any input data
    
  
 Scenario: Verify Risk Info "AEPS Minimum" Field Prompts for Valid Inputs
    Then the "AEPS Minimum" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
   
Scenario: Verify Risk Info "AEPS Maximum" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Maximum" field should not allow proceeding without any input data
    
    
 Scenario: Verify Risk Info "AEPS Maximum" Field Prompts for Valid Inputs
    Then the "AEPS Maximum" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0    
    
   
Scenario: Verify Risk Info "POS Daily" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Daily" field should not allow proceeding without any input data
    
  
 Scenario: Verify Risk Info "POS Daily" Field Prompts for Valid Inputs
    Then the "POS Daily" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
  
Scenario: Verify Risk Info "POS Weekly" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Weekly" field should not allow proceeding without any input data
    
  
 Scenario: Verify Risk Info "POS Weekly" Field Prompts for Valid Inputs
    Then the "POS Weekly" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0                               
    
 
  
Scenario: Verify Risk Info "POS Monthly" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Monthly" field should not allow proceeding without any input data
    
   
 Scenario: Verify Risk Info "POS Monthly" Field Prompts for Valid Inputs
    Then the "POS Monthly" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
  
  
Scenario: Verify Risk Info "POS Minimum" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Minimum" field should not allow proceeding without any input data
    
  
 Scenario: Verify Risk Info "POS Minimum" Field Prompts for Valid Inputs
    Then the "POS Minimum" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
    
     
Scenario: Verify Risk Info "POS Maximum" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Maximum" field should not allow proceeding without any input data
    
   
 Scenario: Verify Risk Info "POSMaximum" Field Prompts for Valid Inputs
    Then the "POS Maximum" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0
    
              
  Scenario: Verify "NextStep" Button is Prompted to Click on Risk Info
    Then the "NextStep" button should be prompted to click on Risk Info
    
    
 
     Scenario: Verify Discount Rate "ADD" Button is Prompted to Click
     When I visit the Discount Rate
     Then the Discount Rate "ADD" button should be prompted to click
    
     Scenario: Verify "POS Channel" Field is Prompted to Select Based on given Input
     Then the "POS Channel" field should prompt to select the channels based on the given input in Aggregator
    
     Scenario: Verify POS "Pricing Plan" Field is Prompted to Select Based on given Input
     Then the POS "Pricing Plan" field should prompt to select the channels based on the given input in Aggregator
     Then the DiscountRate "Save" button should be prompted to click
     
     
     Scenario: Verify Discount Rate "ADD" Button is Prompted to Click
     Then the Discount Rate "ADD" button should be prompted to click
    
     Scenario: Verify "UPI Channel" Field is Prompted to Select Based on given Input
     Then the "UPI Channel" field should prompt to select the channels based on the given input in Aggregator
    
     Scenario: Verify POS "Pricing Plan" Field is Prompted to Select Based on given Input
     Then the UPI "Pricing Plan" field should prompt to select the channels based on the given input in Aggregator
     Then the DiscountRate "Save" button should be prompted to click
     
     
     
     Scenario: Verify Discount Rate "ADD" Button is Prompted to Click
     Then the Discount Rate "ADD" button should be prompted to click
    
     Scenario: Verify "AEPS Channel" Field is Prompted to Select Based on given Input
     Then the "AEPS Channel" field should prompt to select the channels based on the given input in Aggregator
    
     Scenario: Verify AEPS "Pricing Plan" Field is Prompted to Select Based on given Input
     Then the AEPS "Pricing Plan" field should prompt to select the channels based on the given input in Aggregator
     Then the DiscountRate "Save" button should be prompted to click
     
     
     
      
    
    
    
Scenario: Verify SettlementInfo "ADD" Button is Prompted to Click
    When I visit the Settlement Info
    Then the Settlement Info "ADD" button should be prompted to click       
    

  
Scenario: Verify SettlementInfo "Bank Details" Label Name is "Channel".
    Then the label name should be "Channel"
    
    
   
Scenario: Verify Settlement Info "Channel" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Channel" field should not allow proceeding without any input data
    
     
 Scenario: Verify Settlement Info "Channel" dropdown prompts for valid inputs
    Then the Settlement Info "Channel" dropdown should prompt to select valid inputs
    
        
   
Scenario: Verify SettlementInfo "Bank Details" Label Name is "Account Type".
    Then the label name should be "Account Type"
    
    
  
Scenario: Verify Settlement Info "Account Type" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Account Type" field should not allow proceeding without any input data
    
 

 Scenario: Verify Settlement Info "Account Type" dropdown prompts for valid inputs
    Then the Settlement Info "Account Type" dropdown should prompt to select valid inputs 
       


Scenario: Verify SettlementInfo "Bank Details" Label Name is "Bank Account Number".
    Then the label name should be "Bank Account Number"
    
    
    
Scenario: Verify Settlement Info "Bank Account Number" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Bank Account Number" field should not allow proceeding without any input data
    
  
   
 Scenario: Verify Settlement Info "Bank Account Number" Field Prompts for Invalid Inputs
    Then the Settlement Info "Bank Account Number" field should prompt to enter Invalid inputs using sheetname "Aggregator" and rownumber 1 
         
 
   Scenario: Verify Settlement Info "Bank Account Number" Field Prompts for valid Inputs
    Then the Settlement Info "Bank Account Number" field should prompt to enter valid inputs using sheetname "Aggregator" and rownumber 0 
    
    
    
Scenario: Verify SettlementInfo "Bank Details" Label Name is "IFSC Code".
    Then the label name should be "IFSC Code"
    
    
    
Scenario: Verify Settlement Info "IFSC Code" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "IFSC Code" field should not allow proceeding without any input data
    
   
 Scenario: Verify Settlement Info "IFSC Code" dropdown prompts for valid inputs
    Then the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs
    

Scenario: Verify SettlementInfo "Bank Details" Label Name is "Bank Name".
    Then the "SettlementInfo" label name should be "Bank Name"
 
    
 Scenario: Verify Settlement Info "Bank Name" is Displayed when IFSC Code is Selected
    Then the Bank Name should be displayed
    
    
Scenario: Verify SettlementInfo "Bank Details" Label Name is "Branch".
    Then the label name should be "Branch"
    
     
 Scenario: Verify Settlement Info "Branch" is Displayed when IFSC Code is Selected
     Then the Branch should be displayed
     
 
Scenario: Verify SettlementInfo "Bank Details" Label Name is "City".
    Then the "SettlementInfo" label name should be "City"  

  
 Scenario: Verify Settlement Info "City" is Displayed when IFSC Code is Selected
     Then the CityName should be displayed
     Then the SettlementInfo "Save" button should be prompted to click 
     
 
Scenario: Verify SettlementInfo "Settlement Mode" Label Name
    Then the label name should be "Settlement Mode"
    
      
Scenario: Verify Settlement Info "Settlement Mode" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Settlement Mode" field should not allow proceeding without any input data   
     
    
 Scenario: Verify Settlement Info "Settlement Mode" dropdown prompts for valid inputs
    Then the Settlement Info "Settlement Mode" dropdown should prompt to select valid inputs
    
    
  
Scenario: Verify SettlementInfo "Payment Flag" Label Name
    Then the label name should be "Payment Flag"
    
     
Scenario: Verify Settlement Info "Payment Flag" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Payment Flag" field should not allow proceeding without any input data   
     
   
 Scenario: Verify Settlement Info "Payment Flag" dropdown prompts for valid inputs
    Then the Settlement Info "Payment Flag" dropdown should prompt to select valid inputs           
     
   
  Scenario: Verify "NextStep" Button is Prompted to Click on Settlement Info
    Then the "NextStep" button should be prompted to click on Settlement Info
   
   
    
    
 
Scenario: Verify Whitelabel Label Name is "ISO Onboarding".
     When I visit the Whitelabel
    Then the "Whitelabel" label name should be "ISO Onboarding"
    
   
 Scenario: Verify Whitelabel "ISO Onboarding" dropdown prompts for valid inputs
    Then the Whitelabel "ISO Onboarding" dropdown should prompt to select valid inputs
    
     
Scenario: Verify Whitelabel Label Name is "Sales Team Onboarding".
    Then the "Whitelabel" label name should be "Sales Team Onboarding"
    
    
 Scenario: Verify Whitelabel "Sales Team Onboarding" dropdown prompts for valid inputs
    Then the Whitelabel "Sales Team Onboarding" dropdown should prompt to select valid inputs
    
  
Scenario: Verify Whitelabel Label Name is "Allow to Create Merchant User".
    Then the "Whitelabel" label name should be "Allow to Create Merchant User"
    
    
 Scenario: Verify Whitelabel "Allow to Create Merchant User" dropdown prompts for valid inputs
    Then the Whitelabel "Allow to Create Merchant User" dropdown should prompt to select valid inputs
    
 
   Scenario: Verify Settlement Info "Max Number of platform" Field Prompts for valid Inputs
    Then the Whitelabel "Max Number of platform" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
  
Scenario: Verify Whitelabel Label Name is "UserName As".
    Then the "Whitelabel" label name should be "UserName As"
    
    
 Scenario: Verify Whitelabel "UserName As" dropdown prompts for valid inputs
    Then the Whitelabel "UserName As" dropdown should prompt to select valid inputs  
     
 
   
  Scenario: Verify "NextStep" Button is Prompted to Click on WhiteLabel
    Then the "NextStep" button should be prompted to click on WHiteLabel
    
    
  Scenario: Verify Webhooks "ADD" Button is Prompted to Click
    When I visit the Webhooks
    Then the Webhooks "Add" button should be prompted to click
    
  
Scenario: Verify Webhooks Label Name is "Webhook Type".
    Then the "Webhooks" label name should be "Webhook Type"
    
     
Scenario: Verify Webhooks "Webhook Type" Field Does Not Allow Proceeding Without Input Data
    Then the Webhooks "Webhook Type" field should not allow proceeding without any input data   
     
  
 Scenario: Verify Webhooks "Webhook Type" dropdown prompts for valid inputs
    Then the Webhooks "Webhook Type" dropdown should prompt to select valid inputs  
    
 
Scenario: Verify Webhooks Label Name is "Webhook Url".
    Then the "Webhooks" label name should be "Webhook Url"
    
    
   
Scenario: Verify Webhooks "Webhook Url" Field Does Not Allow Proceeding Without Input Data
    Then the Webhooks "Webhook Url" field should not allow proceeding without any input data
    
    
   
 Scenario: Verify Webhooks "Webhook Url" Field Prompts for Invalid Inputs
    Then the Webhooks "Webhook URL" field should prompt to enter Invalid inputs using sheetname "Bank" and rownumber 1 
         
 
   Scenario: Verify  Webhooks "Webhook Url" Field Prompts for valid Inputs
    Then the Webhooks "Webhook URL" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0     
    
    
    
   Scenario: Verify Webhooks "SAVE" Button is Prompted to Click
    Then the Webhooks "Save" button should be prompted to click   
    
       
    
  Scenario: Verify "NextStep" Button is Prompted to Click on Webhooks
    Then the "NextStep" button should be prompted to click on Webhooks          
    
    
    
    
    


    
    
    
   