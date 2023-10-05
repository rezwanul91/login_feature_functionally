Feature: Customer Contact Number Modification functionality

@Sanity @Regression
Scenario: Verify Customer Contact Number Modification functionality
Given I am in landing page http://it.microtechlimited.com
When I Click on Login menu
And Click on Customer Login
Then Enter User Id as david@gmail.com          
And I Enter Password as 1234
And I Click on Login Button
Then Verify that I am in Home Page
And I Click on Profile Menu
And I Click on Update Info
And I Replace the Contact Number to 44555
And I Click Submit button
Then Verify Contact Number is changed to 44555


#Gherkin Language - 
#which has few keywords ie. Feature, Scenario, Given, When, Then, And, * 
#Given - Precondition
#called Test Step