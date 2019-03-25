@Login
Feature: Login Page
Description: The purpose of this feature is to launch the application and login
							Verify that Dashboard is displayed when log in
							
Scenario Outline: Login with valid credentials

Given I launch the application 
When I enter username "<username>"
When I enter password "<password>"
When I click login 
Then I verify Dashboard page is displayed

Examples:
|username|password|
|name1  |	passwd	|