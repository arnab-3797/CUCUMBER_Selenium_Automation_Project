Feature: CURA health care application test

Background:

Given User navigate to Cura health care homepage
And User clicks on login pages button


Scenario: Login should be success

And User enter the user name as "John Doe"
And User enter the password as "ThisIsNotAPassword"
When User click on login button
Then Login should be successfull

Scenario: Login should not be success

And User enter the user name as "John Doe1"
And User enter the password as "ThisIsNotAPassword1"
When User click on login button
But Login should be failed!