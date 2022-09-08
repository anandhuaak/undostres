Feature: Automated End2End Tests
Description: The purpose of this feature is to test scenarios covering Test Scenarios:-
Login
Register a Patient
Find patient Record
View the patient(Assert minimum 5 values)
Delete registered Patient


Scenario Outline: Verify user login sceanrio
Given user is on Home Page
When user enter Username as "<username>" and Password as "<password>"
Then verify login is successful
Examples:
|username  |password  | 
|Admin     |Admin123  | 

Scenario Outline: Verify patient record creation
Given user is on Home Page
When user enter Username as "<username>" and Password as "<password>"
And user clicks on register patient
And user enter FirstName as "<firstname>" and LastName as "<lastname>"
And user selects gender as "<gender>"
And user enter dob as "<day>" month as "<month>" and year as "<year>"
And user enter address as "<address>"
And user enter phoneno as "<phone>"
Then user clicks on confirm button
Examples:
|username  |password  |firstname |lastname  |gender  |day  |month  |year  |address  |phone|
|Admin     |Admin123  |Aju41     |Francis41 |Male    | 5   |April  |1991  |Navami   |985645878|

Scenario Outline: Verify patient record search
Given user is on Home Page
When user enter Username as "<username>" and Password as "<password>"
And user clicks on find patient record
And user search with FirstName as "<firstname>"
Then verify saved details are displayed with "<firstname>","<lastname>","<gender>"
Examples:
|username  |password  |firstname |lastname  |gender  |day  |month  |year  |address  |phone|
|Admin     |Admin123  |Aju41     |Francis41 |Male    | 5   |April  |1991  |Navami   |985645878|

Scenario Outline: Delete Patient details
Given user is on Home Page
When user enter Username as "<username>" and Password as "<password>"
And user clicks on find patient record
And user search with FirstName as "<firstname>"
And user clicks on the patient details 
Then delete the patient with a reason
Examples:
|username  |password  |firstname |lastname  |gender  |day  |month  |year  |address  |phone|
|Admin     |Admin123  |Aju41     |Francis41 |Male    | 5   |April  |1991  |Navami   |985645878|
