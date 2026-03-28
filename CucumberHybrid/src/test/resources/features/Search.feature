Feature: Search functionality

Scenario: User searches for a valid product
Given User open the application
When User enter valid product "HP" into search box field
And user click on search button
Then User should get valid product displayed in search result

Scenario: User searches for a invalid product
Given User open the application
When User enter invalid product "Honda" into search box field
And user click on search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User open the application
When User dont enter any product name into search box field
And user click on search button
Then User should get a message about no product matching

