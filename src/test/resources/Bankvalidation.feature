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
Feature: Bank Onboarding Form Validation

 This feature aims to test the functionality of the 'Bank Onboarding' within the application.

 

Scenario: SuperAdmin Login
 Given I visit the SuperAdmin Login using sheetname "Credentials" and rownumber 0
 And I enter the credentials and click the login button
    
   
Scenario: Verify Bank Name label
    Given I visit the bank onboarding page in Super Admin
    When I click on the "Bank Name" field
    Then the label name should be "Bank Name"

     
Scenario: Verify Bank Name field does not allow proceeding without input
    Then the "Bank Name" field should not allow to proceed without any input data    
    
  
Scenario: Verify that the "Bank Name" field prompts for invalid input if more than 30 characters are entered
      Then the "Bank Name" field should prompts for invalid input if more than 30 characters are entered using sheetname "Bank" and rownumber 3
       
     
Scenario: Verify that the "Bank Name" field prompts for invalid input if Lesser than 30 characters are entered
      Then the "Bank Name" field should prompts for Invalid inputs within Lessthan 30 characters using sheetname "Bank" and rownumber 4
    
       
Scenario: Verify that the "Bank Name" field prompts for invalid input if a number is entered
      Then the "Bank Name" field prompts for invalid input if a number is entered using sheetname "Bank" and rownumber 5
     
                  
Scenario: Verify that the "Bank Name" field prompts for invalid input if special characters are entered
          Then the "Bank Name" field prompts for invalid input if special characters are entered using sheetname "Bank" and rownumber 6
    
        
Scenario: Verify that the "Bank Name" field accepts valid inputs of 30 characters
    Then the "Bank Name" field should prompt to enter valid inputs within 30 characters using sheetname "Bank" and rownumber 2
    
    
          
Scenario: Verify Address label
    When I click on the "Address" field
    Then the label name should be "Address"
 
    
   
Scenario: Verify Address field does not allow proceeding without input
    Then the "Address" field should not allow to proceed without any input data    

  
Scenario: Verify Address field prompts for valid inputs within 230 characters
    Then the "Address" field should prompt to enter valid inputs within 230 characters using sheetname "Bank" and rownumber 0
        
      
Scenario: Verify Pincode label
    When I click on the "Pincode" field
    Then the label name should be "Pincode"

  
Scenario: Verify Pincode field does not allow proceeding without input
    Then the "Pincode" field should not allow to proceed without any input data
    
     
Scenario: Verify Pincode dropdown prompts for valid inputs
    Then the "Pincode" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0
    

    
Scenario: Verify "City Name" is Displayed when Pincode is Selected
Then the city name should be displayed.


Scenario: Verify "State Name" is Displayed when Pincode is Selected
Then the state name should be displayed.


Scenario: Verify "Country Name" is Displayed when Pincode is Selected
Then the Country name should be displayed.


Scenario: Verify "Currency Code" Name is Displayed when Pincode is Selected
Then the Currency Code name should be displayed.


Scenario: Verify GST label
    When I click on the "GST" field
    Then the label name should be "GST"
    
    
Scenario: Verify GST field does not allow proceeding without input
    Then the "GST" field should not allow to proceed without any input data    
    



Scenario: Verify GST field prompts for Invalid inputs in GST format
    Then the "GST" field should prompt to enter Invalid inputs with GST format using sheetname "Bank" and rownumber 1
    

Scenario: Verify GST field prompts for valid inputs in GST format
    Then the "GST" field should prompt to enter valid inputs with GST format using sheetname "Bank" and rownumber 0    


Scenario: Verify PAN label
    When I click on the "PAN" field
    Then the label name should be "PAN"
    
   
 Scenario: Verify PAN field does not allow proceeding without input
    Then the "PAN" field should not allow to proceed without any input data  


 Scenario: Verify PAN field prompts for Invalid inputs in PAN format
    Then the "PAN" field should prompt to enter Invalid inputs with PAN format using sheetname "Bank" and rownumber 1


Scenario: Verify PAN field prompts for valid inputs in PAN format
    Then the "PAN" field should prompt to enter valid inputs with PAN format using sheetname "Bank" and rownumber 0


 
Scenario: Verify MarsId label
    When I click on the "Marsid" field
    Then the label name should be "Marsid"
    
   
Scenario: Verify MarsId field prompts for valid inputs
    the "MarsId" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
   
Scenario: Verify Statement Frequency label
    When I click on the "Statement Frequency" field
    Then the label name should be "Statement Frequency"  
    
   
Scenario: Verify Statement Frequency dropdown prompts for valid inputs
    Then the "Statement Frequency" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0
      
Scenario: Verify Statement Type label
    Then the label name should be "Statement Type"
    
     	
Scenario: Verify Statement Type dropdown prompts for valid inputs
    Then the "Statement Type" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0
 
    
Scenario: Verify Domain label
    When I click on the "Domain" field
    Then the label name should be "Domain"
    
    
Scenario: Verify Domain field does not allow proceeding without input
    Then the "Domain" field should not allow to proceed without any input data        
    
   
Scenario: Verify Domain Field Prompts for Invalid Alphabet Domain Names
Then the "Domain" field should prompt to enter invalid alphabet domain names using sheetname "Bank" and rownumber 1


Scenario: Verify Domain Field Prompts for Invalid Number Domain Names
Then the "Domain" field should prompt to enter invalid number domain names using sheetname "Bank" and rownumber 2    
    
   
Scenario: Verify Domain Field Prompts for Valid Domain Names
Then the "Domain" field should prompt to enter valid domain names using sheetname "Bank" and rownumber 0


Scenario: Verify "Save" Button is Prompted and Success Popup is Displayed
    Then To verify if the "Save" button is prompted to click and a success popup is displayed using sheetname "Bank" and rownumber 1



Scenario: Verify "Next" Button is Clickable and Moves to Communication Info Page
        
         
      Then the "Bank Name" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
      Then the "NextStep" button should be prompted to click on General Info
 
         
Scenario: Verify Communication Info "Add" Button is Prompted to Click
    When I visit the Communication Info
    Then the "Add" button should be prompted to click
    

 Scenario: Verify "Communication Info" Label Name is "Name"
    When I click on the "Communication Name" field
    Then the label name should be "Name"


         
Scenario: Verify "Communication Name" Field Does Not Allow Proceeding Without Input Data
    Then the "Communication Name" field should not allow proceeding without any input data    
  
     
Scenario: Verify Communication Info "Name" Field Does Not Allow Numeric Characters
     Then the "Name" field should not allow numeric characters using sheetname "Bank" and rownumber 1
    
     
Scenario: Verify Communication Info "Name" Field Does Not Allow Special Characters
     Then the "Name" field should not allow special characters using sheetname "Bank" and rownumber 2         
    

 
Scenario: Verify Communication Info "Name" Field Prompts for Valid Inputs
    Then the "Name" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0   
    


Scenario: Verify "Communication Info" Label Name is "Position"
    When I click on the "Position" field
    Then the label name should be "Position"

    
Scenario: Verify "Position" Field Does Not Allow Proceeding Without Input Data
    Then the "Position" field should not allow proceeding without any input data    
    
    
Scenario: Verify Communication Info "Position" Field Does Not Allow Numeric Characters
     Then the "Position" field should not allow numeric characters using sheetname "Bank" and rownumber 1
    
    
Scenario: Verify Communication Info "Position" Field Does Not Allow Special Characters
     Then the "Position" field should not allow special characters using sheetname "Bank" and rownumber 2
     
     
Scenario: Verify Communication Info "Position" Field Prompts for Valid Inputs
  Then the "Position" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0     
       
    

Scenario: Verify "Communication Info" Label Name is "Phone Number"
    When I click on the "Phone Number" field
    Then the label name should be "Phone Number"    

    
Scenario: Verify Communication "Phone Number" Field Does Not Allow Less Than Required Digits
Then the "Phone Number" field should not allow inputs with fewer digits than required using sheetname "Bank" and rownumber 1


Scenario: Verify Communication "Phone Number" Field Does Not Allow More Than Required Digits
Then the "Phone Number" field should not allow inputs with more digits than required using sheetname "Bank" and rownumber 2


Scenario: Verify Communication "Phone Number" Field Does Not Allow Numbers Without Starting Digit 0
Then the "Phone Number" field should not allow numbers that do not start with the digit 0 using sheetname "Bank" and rownumber 0


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
Then the "Mobile Number" field should not allow inputs with fewer digits than required using sheetname "Bank" and rownumber 1


Scenario: Verify Communication "Mobile Number" Field Does Not Allow More Than Required Digits
Then the "Mobile Number" field should not allow inputs with more digits than required using sheetname "Bank" and rownumber 2


Scenario: Verify Communication "Mobile Number" Field Prompts for Valid Inputs
    Then the "Mobile Number" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0   
    
     
Scenario: Verify "Communication Info" Label Name is "Email ID"
    When I click on the "Email ID" field
    Then the label name should be "Email ID"
    
    

Scenario: Verify Communication "Email ID" Field Does Not Allow Proceeding Without Input Data
    Then the "Email ID" field should not allow proceeding without any input data


   
Scenario: Verify Communication "Email ID" Field Does Not Allow Missing '@' Symbol
Then the "Email ID" field should not allow inputs missing the '@' symbol using sheetname "Bank" and rownumber 1


Scenario: Verify Communication "Email ID" Field Does Not Allow Missing Domain
Then the "Email ID" field should not allow inputs missing the domain name using sheetname "Bank" and rownumber 2



Scenario: Verify Communication "Email ID" Field Does Not Allow Consecutive Dots
Then the "Email ID" field should not allow consecutive dots in the email address using sheetname "Bank" and rownumber 3


Scenario: Verify Communication "Email ID" Field Does Not Allow Spaces
Then the "Email ID" field should not allow spaces in the email address using sheetname "Bank" and rownumber 4


Scenario: Verify Communication "Email ID" Field Prompts for Valid Inputs
 Then the "Email ID" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
 
 
     
Scenario: Verify "Communication Info" Label Name is "UserName"
    When I click on the "UserName" field
    Then the label name should be "UserName"


Scenario: Verify "Username" Field is Auto-Filled Based on Entered Email ID
    Then the "Username" field should be auto-filled based on the entered email ID using sheetname "Bank" and rownumber 0


Scenario: Verify "Communication Info" Label Name is "AD User"
    Then the label name should be "AD User"

    
Scenario: Verify "AD User" Field Prompts to Select Yes/No
    Then the "AD User" field should prompt to select Yes or No based on the given input using sheetname "Bank" and rownumber 0


Scenario: Verify "Save" Button is Prompted to Click on Communication Info
    Then the "Save" button should be prompted to click on Communication Info


Scenario: Verify "NextStep" Button is Prompted to Click on Communication Info
    Then the "NextStep" button should be prompted to click on Communication Info
    

 
 Scenario: Verify "Add" Button is Prompted to Click
    When I visit the Channel Config
    Then the "Add" button should be prompted to click
   
  
 Scenario: Verify "Channel Config" Label Name is "Channel"
    Then the label name should be "Channel"      
    
 
Scenario: Verify "POS Channel" Field is Prompted to Select Based on given Input
    Then the "POS Channel" field should prompt to select the channels based on the given input
    
  
 Scenario: Verify "Channel Config" Label Name is "Network"
    Then the label name should be "Network"    
    
    
Scenario: Verify "POS Network" Field is Prompted to Select Based on Given Input
    Then the "POS Network" field should prompt to select the Network based on the given input
    
        
 Scenario: Verify "Channel Config" Label Name is "Transaction Sets"
    Then the label n	ame should be "Transaction Sets"


Scenario: Verify "POS Transaction Sets" Field is Prompted to Select Based on Given Input
    Then the "POS Transaction Sets" field should prompt to select the transaction sets based on the given input
  
   
Scenario: Verify "Channel Config" Label Name is "Routing"
    Then the label name should be "Routing"        


Scenario: Verify "POS Routing" Field is Prompted to Select Based on Given Input
    Then the "POS Routing" field should prompt to select the routing based on the given input


Scenario: Verify "Save" Button is Prompted to Click on channel Config
    Then the "Save" button should be prompted to click on Channel COnfig
    
    
  Scenario: Verify "Add" Button is Prompted to Click
    Then the "Add" button should be prompted to click
    
    
    Scenario: Verify "UPI Channel" Field is Prompted to Select Based on given Input
    Then the "UPI Channel" field should prompt to select the channels based on the given input
    
   
Scenario: Verify "UPI Transaction Sets" Field is Prompted to Select Based on Given Input
    Then the "UPI Transaction Sets" field should prompt to select the transaction sets based on the given input
    
    
Scenario: Verify "Save" Button is Prompted to Click on channel Config
    Then the "Save" button should be prompted to click on Channel COnfig
    
Scenario: Verify "Add" Button is Prompted to Click
    Then the "Add" button should be prompted to click
    
    
Scenario: Verify "AEPS Channel" Field is Prompted to Select Based on given Input
    Then the "AEPS Channel" field should prompt to select the channels based on the given input
    
     
Scenario: Verify "AEPS Transaction Sets" Field is Prompted to Select Based on Given Input
    Then the "AEPS Transaction Sets" field should prompt to select the transaction sets based on the given input
   
    
Scenario: Verify "Save" Button is Prompted to Click on channel Config
    Then the "Save" button should be prompted to click on Channel COnfig
    
     
Scenario: Verify "NextStep" Button is Prompted to Click on channel Config
    Then the "NextStep" button should be prompted to click on channel config
    
 
 Scenario: Verify "POS ADD BIN" Field is Prompted to Select Based on Given Input in ONUS Routing
    Then the "POS ADD BIN" field should prompt to select the Bin based on the given input  
    
     
Scenario: Verify "NextStep" Button is Prompted to Click on ONUS Routing
    Then the "NextStep" button should be prompted to click on ONUS Routing 
    
  
 Scenario: Verify the checkbox can be checked and unchecked
    When I visit the Global FRM 
    Then the GlobalFRMcheckbox should be checked
    
    Then the GlobalFRMcheckbox should be unchecked
    

 
Scenario: Verify "Global FRM" Label Name is "Velocity Check Minutes".
    When I click on the "Velocity Check Minutes" field
    Then the label name should be "Velocity Check Minutes"
    
     
Scenario: Verify GlobalFRM "Velocity Check Minutes" Field Does Not Allow Proceeding Without Input Data
    Then the "Velocity Check Minutes" field should not allow proceeding without any input data

   
Scenario: Verify GlobalFRM "Velocity Check Minutes" Field Prompts for Valid Inputs
 Then the "Velocity Check Minutes" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0    
    
  
Scenario: Verify "Global FRM" Label Name is "Velocity Check Count".
    When I click on the "Velocity Check Count" field
    Then the label name should be "Velocity Check Count"
  
     
 Scenario: Verify GlobalFRM "Velocity Check Count" Field Does Not Allow Proceeding Without Input Data
    Then the "Velocity Check Count" field should not allow proceeding without any input data
    
  Scenario: Verify GlobalFRM "Velocity Check Count" Field Prompts for Valid Inputs
 Then the "Velocity Check Count" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0  
    
    
 Scenario: Verify "Global FRM" Label Name is "Cash@POS Count".
    When I click on the "Cash@POS Count" field
    Then the label name should be "Cash@POS Count"
  
    
 Scenario: Verify GlobalFRM "Cash@POS Count" Field Does Not Allow Proceeding Without Input Data
    Then the "Cash@POS Count" field should not allow proceeding without any input data
   
    
  Scenario: Verify GlobalFRM "Cash@POS Count" Field Prompts for Valid Inputs
 Then the "Cash@POS Count" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0      
    
    
 Scenario: Verify "Global FRM" Label Name is "Micro ATM Count".
    When I click on the "Micro ATM Count" field
    Then the label name should be "Micro ATM Count"
  
     
Scenario: Verify GlobalFRM "Micro ATM Count" Field Does Not Allow Proceeding Without Input Data
    Then the "Micro ATM Count" field should not allow proceeding without any input data
    
     
 Scenario: Verify GlobalFRM "Micro ATM Count" Field Prompts for Valid Inputs
    Then the "Micro ATM Count" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0            
    
   
  
 Scenario: Verify "Global FRM" Label Name is "International Card Acceptence".
      Then the label name should be "International Card Acceptence"
      
     
 Scenario: Verify Global FRM "International Card Acceptence" Field Prompts to Select Yes/No
    Then the "International Card Acceptence" field should prompt to select Yes or No based on the given input     
    
 
   
 Scenario: Verify "Global FRM" Label Name is "ICA Daily".
    When I click on the "ICA Daily" field
    Then the label name should be "Daily"
  
  
Scenario: Verify GlobalFRM "ICA Daily" Field Does Not Allow Proceeding Without Input Data
    Then the "ICA Daily" field should not allow proceeding without any input data
   
    
  
 Scenario: Verify GlobalFRM "ICA Daily" Field Prompts for Valid Inputs
    Then the "ICA Daily" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
   
 Scenario: Verify "Global FRM" Label Name is "ICA Weekly".
    When I click on the "ICA Weekly" field
    Then the label name should be "Weekly"
  
  
Scenario: Verify GlobalFRM "ICA Weekly" Field Does Not Allow Proceeding Without Input Data
    Then the "ICA Weekly" field should not allow proceeding without any input data
    
  
     Scenario: Verify GlobalFRM "ICA Weekly" Field Does not allow less than "ICA Daily"
      Then the "ICA Weekly" field Must be greater than "ICA Daily" using sheetname "Bank" and rownumber 1
    
    
     Scenario: Verify GlobalFRM "ICA Weekly" Field Equal Value not allowed "ICA Daily"
    Then the "ICA Weekly" field Must be greater than "ICA Daily" using sheetname "Bank" and rownumber 2
    
    
    Scenario: Verify GlobalFRM "ICA Weekly" Field Prompts for Valid Inputs
    Then the "ICA Weekly" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0                               
    
    
 
 Scenario: Verify "Global FRM" Label Name is "ICA Monthly".
    When I click on the "ICA Monthly" field
    Then the label name should be "Monthly"
  
 
Scenario: Verify GlobalFRM "ICA Monthly" Field Does Not Allow Proceeding Without Input Data
    Then the "ICA Monthly" field should not allow proceeding without any input data
    
  
 Scenario: Verify GlobalFRM "ICA Monthly" Field Does not allow less than "ICA Weekly"
    Then the "ICA Monthly" field Must be greater than "ICA Weekly" using sheetname "Bank" and rownumber 1
    
    
    
     Scenario: Verify GlobalFRM "ICA Monthly" Field Equal Value not allowed "ICA Weekly"
    Then the "ICA Monthly" field Must be greater than "ICA Weekly" using sheetname "Bank" and rownumber 2     
    
   
 Scenario: Verify GlobalFRM "ICA Monthly" Field Prompts for Valid Inputs
    Then the "ICA Monthly" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
    
    
  Scenario: Verify GlobalFRM "UPI Daily" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Daily" field should not allow proceeding without any input data
    
  
 Scenario: Verify GlobalFRM "UPI Daily" Field Prompts for Valid Inputs 
    Then the "UPI Daily" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
   
  
Scenario: Verify GlobalFRM "UPI Weekly" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Weekly" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "UPI Weekly" Field Prompts for Valid Inputs
    Then the "UPI Weekly" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0                               
    
  
  
Scenario: Verify GlobalFRM "UPI Monthly" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Monthly" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "UPI Monthly" Field Prompts for Valid Inputs
    Then the "UPI Monthly" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
  
Scenario: Verify GlobalFRM "UPI Minimum" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Minimum" field should not allow proceeding without any input data
    
  
 Scenario: Verify GlobalFRM "UPI Minimum" Field Prompts for Valid Inputs
    Then the "UPI Minimum" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
    
Scenario: Verify GlobalFRM "UPI Maximum" Field Does Not Allow Proceeding Without Input Data
    Then the "UPI Maximum" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "UPI Maximum" Field Prompts for Valid Inputs
    Then the "UPI Maximum" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    

Scenario: Verify GlobalFRM "AEPS Daily" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Daily" field should not allow proceeding without any input data
    
  
 Scenario: Verify GlobalFRM "AEPS Daily" Field Prompts for Valid Inputs
    Then the "AEPS Daily" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
   
  
Scenario: Verify GlobalFRM "AEPS Weekly" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Weekly" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "AEPS Weekly" Field Prompts for Valid Inputs
    Then the "AEPS Weekly" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0                               
    
  
  
Scenario: Verify GlobalFRM "AEPS Monthly" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Monthly" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "AEPS Monthly" Field Prompts for Valid Inputs
    Then the "AEPS Monthly" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
  
Scenario: Verify GlobalFRM "AEPS Minimum" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Minimum" field should not allow proceeding without any input data
    
  
 Scenario: Verify GlobalFRM "AEPS Minimum" Field Prompts for Valid Inputs
    Then the "AEPS Minimum" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
    
Scenario: Verify GlobalFRM "AEPS Maximum" Field Does Not Allow Proceeding Without Input Data
    Then the "AEPS Maximum" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "AEPS Maximum" Field Prompts for Valid Inputs
    Then the "AEPS Maximum" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0    
    
    
Scenario: Verify GlobalFRM "POS Daily" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Daily" field should not allow proceeding without any input data
    
  
 Scenario: Verify GlobalFRM "POS Daily" Field Prompts for Valid Inputs
    Then the "POS Daily" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
   
  
Scenario: Verify GlobalFRM "POS Weekly" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Weekly" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "POS Weekly" Field Prompts for Valid Inputs
    Then the "POS Weekly" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0                               
    
  
  
Scenario: Verify GlobalFRM "POS Monthly" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Monthly" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "POS Monthly" Field Prompts for Valid Inputs
    Then the "POS Monthly" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
  
Scenario: Verify GlobalFRM "POS Minimum" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Minimum" field should not allow proceeding without any input data
    
  
 Scenario: Verify GlobalFRM "POS Minimum" Field Prompts for Valid Inputs
    Then the "POS Minimum" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
    
Scenario: Verify GlobalFRM "POS Maximum" Field Does Not Allow Proceeding Without Input Data
    Then the "POS Maximum" field should not allow proceeding without any input data
    
   
 Scenario: Verify GlobalFRM "POSMaximum" Field Prompts for Valid Inputs
    Then the "POS Maximum" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
             
  Scenario: Verify "NextStep" Button is Prompted to Click on Global FRM
    Then the "NextStep" button should be prompted to click on Global FRM
    
  
  Scenario: Verify Commercial "Interchange Plan ADD" Button is Prompted to Click
    When I visit the Commercial
    Then the "Interchange Plan Add" button should be prompted to click
    

  
Scenario: Verify Commercial "Interchange Plan" Label Name is "Channel".
    Then the Interchage Plan label name should be "Channel"
    
   
   
Scenario: Verify Commercial "Interchange Plan Channel" Field Does Not Allow Proceeding Without Input Data
    Then the "Interchange Plan Channel" field should not allow proceeding without any input data
    
    
 Scenario: Verify Commercial "Interchange Plan Channel - POS" dropdown prompts for valid inputs
    Then the "Interchange Plan Channel - POS" dropdown should prompt to select valid inputs
    
    
    Scenario: Verify Commercial "Interchange Plan" Label Name is "Pricing Plan".
    Then the Interchange Pricing Plan label name should be "Pricing Plan"
    
   
    Scenario: Verify Commercial "Interchange Pricing Plan" Field Does Not Allow Proceeding Without Input Data
    Then the "Interchange Pricing Plan" field should not allow proceeding without any input data
    
   
    Scenario: Verify Commercial "Interchange Pricing Plan - BANK TEST PLAN" dropdown prompts for valid inputs
    When the "Interchange Pricing Plan - BANK TEST PLAN" dropdown should prompt to select valid inputs
    Then the Commercial "Save" button should be prompted to click
    

    Scenario: Verify Commercial "Bank Onboarding Commercial ADD" Button is Prompted to Click
    Then the "Bank Onboarding Commercial Add" button should be prompted to click
    
 
    Scenario: Verify Commercial "Bank Onboarding Commercial" Label Name is "Channel".
    Then the Bank Onboarding Commercial label name should be "Channel"
    
  
   Scenario: Verify Commercial "Bank Onboarding Commercial Channel" Field Does Not Allow Proceeding Without Input Data
    Then the "Bank Onboarding Commercial Channel" field should not allow proceeding without any input data
    
      
   Scenario: Verify Commercial "Bank Onboarding Commercial Channel - AEPS" dropdown prompts for valid inputs
    Then the "Bank Onboarding Commercial Channel - AEPS" dropdown should prompt to select valid inputs
    
    
    Scenario: Verify Commercial "Bank Onboarding Commercial" Label Name is "Pricing Plan".
    Then the Bank Onboarding Commercial label name should be "Pricing Plan"
       
     
    Scenario: Verify Commercial "Bank Onboarding Commercial Pricing Plan" Field Does Not Allow Proceeding Without Input Data
    Then the "Bank Onboarding Commercial Pricing Plan" field should not allow proceeding without any input data
  
    
    Scenario: Verify Commercial "Bank Onboarding Commercial Pricing Plan - BANK AEPS PLAN" dropdown prompts for valid inputs
    When the "Bank Onboarding Commercial Pricing Plan - BANK AEPS PLAN" dropdown should prompt to select valid inputs
    Then the Commercial "Save" button should be prompted to click    
    
  
    Scenario: Verify "NextStep" Button is Prompted to Click on Commercial
    Then the "NextStep" button should be prompted to click on Commercial
    
        
     
  Scenario: Verify SettlementInfo "ADD" Button is Prompted to Click
    When I visit the Settlement Info
    Then the Settlement Info "ADD" button should be prompted to click
    

  
Scenario: Verify SettlementInfo "Bank Details" Label Name is "Channel".
    Then the label name should be "Channel"
    
    
   
Scenario: Verify Settlement Info "Channel" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Channel" field should not allow proceeding without any input data
    
     
 Scenario: Verify Settlement Info "Channel" dropdown prompts for valid inputs
    Then the Settlement Info "Channel" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0
    
        
   
Scenario: Verify SettlementInfo "Bank Details" Label Name is "Account Type".
    Then the label name should be "Account Type"
    
    
   
Scenario: Verify Settlement Info "Account Type" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Account Type" field should not allow proceeding without any input data
    
 
 Scenario: Verify Settlement Info "Account Type" dropdown prompts for valid inputs
    Then the Settlement Info "Account Type" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0
       


Scenario: Verify SettlementInfo "Bank Details" Label Name is "Bank Account Number".
    Then the label name should be "Bank Account Number"
    
    
    
Scenario: Verify Settlement Info "Bank Account Number" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Bank Account Number" field should not allow proceeding without any input data
    
   
 Scenario: Verify Settlement Info "Bank Account Number" Field Prompts for Invalid Inputs
    Then the Settlement Info "Bank Account Number" field should prompt to enter Invalid inputs using sheetname "Bank" and rownumber 1 
         
  
   Scenario: Verify Settlement Info "Bank Account Number" Field Prompts for valid Inputs
    Then the Settlement Info "Bank Account Number" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0
    
    
    
Scenario: Verify SettlementInfo "Bank Details" Label Name is "IFSC Code".
    Then the label name should be "IFSC Code"
    
    
   
Scenario: Verify Settlement Info "IFSC Code" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "IFSC Code" field should not allow proceeding without any input data
    
  
 Scenario: Verify Settlement Info "IFSC Code" dropdown prompts for valid inputs
    Then the Settlement Info "IFSC Code" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
  
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
     
 
Scenario: Verify SettlementInfo "Wallet Details" Label Name is "Settlement Type".
    Then the label name should be "Settlement Type"
    
      
Scenario: Verify Settlement Info "Settlement Type" Field Does Not Allow Proceeding Without Input Data
    Then the Settlement Info "Settlement Type" field should not allow proceeding without any input data   
     
   
 Scenario: Verify Settlement Info "Settlement Type" dropdown prompts for valid inputs
    Then the Settlement Info "Settlement Type" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0    
     
    
  Scenario: Verify "NextStep" Button is Prompted to Click on Settlement Info
    Then the "NextStep" button should be prompted to click on Settlement Info
   
   
  
Scenario: Verify Whitelabel Label Name is "Bank Own Deployment".
    When I visit the Whitelabel
    Then the "Whitelabel" label name should be "Bank Own Deployment"
    
    
 Scenario: Verify Whitelabel "BankOwnDeployment" dropdown prompts for valid inputs
    Then the Whitelabel "BankOwnDeployment" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
    
  
Scenario: Verify Whitelabel Label Name is "Payfac Onboarding".
    Then the "Whitelabel" label name should be "Payfac Onboarding"
    
    
 Scenario: Verify Whitelabel "Payfac Onboarding" dropdown prompts for valid inputs
    Then the Whitelabel "Payfac Onboarding" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
    
    
 
Scenario: Verify Whitelabel Label Name is "ISO Onboarding".
    Then the "Whitelabel" label name should be "ISO Onboarding"
    
   
 Scenario: Verify Whitelabel "ISO Onboarding" dropdown prompts for valid inputs
    Then the Whitelabel "ISO Onboarding" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
    
  
Scenario: Verify Whitelabel Label Name is "Sales Team Onboarding".
    Then the "Whitelabel" label name should be "Sales Team Onboarding"
    
    
 Scenario: Verify Whitelabel "Sales Team Onboarding" dropdown prompts for valid inputs
    Then the Whitelabel "Sales Team Onboarding" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0
    

   Scenario: Verify Whitelabel "Max Number of platform" Field Prompts for valid Inputs
    Then the Whitelabel "Max Number of platform" field should prompt to enter valid inputs using sheetname "Bank" and rownumber 0       
 
  
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
    Then the Webhooks "Webhook Type" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
    
  
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
    
    
       
   Scenario: Verify KYC Config "ADD" Button is Prompted to Click
    When I visit the KYC Config
    Then the KYC Config "Add" button should be prompted to click
    
    
       
 Scenario: Verify KYC Config "Business Type" dropdown prompts for valid inputs
    Then the KYC Config "Business Type" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
    
    
        
 Scenario: Verify Company KYC "Proof of Identity" dropdown prompts for valid inputs
    Then the Company KYC "Proof of Identity" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
    
    
Scenario: Verify Individual "Proof of Identity" dropdown prompts for valid inputs
    Then the Individual "Proof of Identity" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
    
    
        
 Scenario: Verify Individual "Proof of Address" dropdown prompts for valid inputs
    Then the Individual "Proof of Address" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0
    
    
Scenario: Verify Individual "Bank Documents" dropdown prompts for valid inputs     
    Then the Individual "Bank Documents" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0
    
        
 Scenario: Verify Individual "Other Documents" dropdown prompts for valid inputs
    Then the Individual "Other Documents" dropdown should prompt to select valid inputs using sheetname "Bank" and rownumber 0 
    
       
   Scenario: Verify KYC "SAVE" Button is Prompted to Click
    Then the KYC "Save" button should be prompted to click   
    
    
     Then the KYC Config "Business Type" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     Then the Company KYC "Proof of Identity" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     Then the Individual "Proof of Identity" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     Then the Individual "Proof of Address" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     Then the Individual "Bank Documents" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
     Then the Individual "Other Documents" dropdown should prompt to select valid inputs using sheetname "Bank Regression" and rownumber 0
    
    
     
  Scenario: Verify "NextStep" Button is Prompted to Click on KYC
    Then the "NextStep" button should be prompted to click on KYC 
    
      
  Scenario: Verify "Submit for verification" Button is Prompted to Click on BankOnboarding
    Then the "Submit for verification" button should be prompted to click on BankOnboarding   
                    
       
     
     