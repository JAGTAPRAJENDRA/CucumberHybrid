Feature: Login functionality 
@smoke
Scenario: Login with valid credentials
Given user nevigate to login page
When User enter valid email address "saripronge1122@gmail.com" into email field
And user enter valid password "test1010" into password fiels
And user clicks on login button
Then user should get succesfully loged in

Scenario: Login with invalid credentials
Given user nevigate to login page
When User enter invalid email address into email field
And user enter invalid password "test" into password fiels
And user clicks on login button
Then User should get a proper warning message about credential mismatch

Scenario: Login with valid email and invalid password
Given user nevigate to login page
When User enter valid email address "saripronge1122@gmail.com" into email field
And user enter invalid password "test" into password fiels
And user clicks on login button
Then User should get a proper warning message about credential mismatch

Scenario: Login with invalid email and valid password
Given user nevigate to login page
When User enter invalid email address into email field
And user enter valid password "test123" into password fiels
And user clicks on login button
Then User should get a proper warning message about credential mismatch

Scenario: Login without providing any credentials
Given user nevigate to login page
When User dont enter email adress
And User dont enter password
And user clicks on login button
Then User should get a proper warning message about credential mismatch  


