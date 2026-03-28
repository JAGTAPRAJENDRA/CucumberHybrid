Feature: Registration Functionality

Scenario: User create an account only with mandatory fields
Given User nevigate to register account page.
When user enter the details below fields
|firstName        |saripp              |
|lastName         |Rongee              |
|telephone        |99887000665         |
|password         |1200340000               |
And user select privacy policy
And User click on contineu button
Then User account should get created successfully

Scenario: User create an account with all fields
Given User nevigate to register account page.
When user enter the details below fields
|firstName        |sari               |
|lastName         |Ron56              |
|telephone        |990000112209          |
|password         |1200340000               |
And User select yes for newsletter
And user select privacy policy
And User click on contineu button
Then User account should get created successfully

Scenario: User create an account without filling any details
Given User nevigate to register account page.
When user dont enter any details into fields
And User click on contineu button
Then User should get a proper warning for every mandatory field










