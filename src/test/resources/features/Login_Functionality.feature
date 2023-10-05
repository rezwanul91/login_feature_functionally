Feature: Employee Login Functionality

@Sanity
Scenario: Verify Employee Login Functionality
Given I am in landing page
When I click on Login menu
Then Click on Employee Login Menu
Then Enter User Id as testpilot@gmail.com
And Enter Password as 1234
And I click on Login Button
Then Verify I am in my Home Page