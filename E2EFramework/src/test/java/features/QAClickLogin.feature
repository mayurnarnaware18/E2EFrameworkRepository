Feature: QAClick Login

Scenario Outline: QA Click invalid Data Driven login 

Given Launch QAClick application
And Click login to land on Login Page

When User tries Login with username as <username> and password as <password>

Then Login is unsuccessful
And Close browser

Examples: 
|username		|password		|
|a@b.com		|11111			|
|c@d.com		|22222			|
|e@f.com		|33333			|
|g@h.com		|44444			|