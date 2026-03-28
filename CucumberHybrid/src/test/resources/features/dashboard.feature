feature:vefy that the dashboard page is accessible and displays correctly
@smoke
Scenario: Verify that the dashboard page is accessible and displays correctly
Given user is logged in and on the dashboard page
When user views the dashboard page
Then the dashboard page should be displayed correctly with all expected elements visible and functional

@smoke
Scenario: Verify dashboard shows My Account, BBPS and Open FD options
Given user is logged in and on the dashboard page
When user views the dashboard options
Then the dashboard should display "My Account", "BBPS" and "Open FD" options