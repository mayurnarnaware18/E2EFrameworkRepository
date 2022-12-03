Feature: OrangeHRM login

@regression
Scenario: OrangeHRM default login

Given User is on Login page

When User clicks on Login by entering username as "admin" and password as "admin123"

#Then Login is successful
#And Username is displayed on homepage
Then Login success is "true"
And Username displayed is "true"
And Close the browser


Scenario: OrangeHRM invalid login

Given User is on Login page

When User clicks on Login by entering username as "user" and password as "user123"

#Then Login is unsuccessful
#And Username is not displayed on homepage
Then Login success is "false"
And Username displayed is "false"
And Close the browser