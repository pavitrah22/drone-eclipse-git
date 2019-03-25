@Dashboard

Feature:Dashboard page
Description: Verify the Dashboard page, 
						Assuming Dashboard page consists of 
						1. AvailableDrone button/link -> On click navigates to list of available drones are displayed
						2. OnDuty button/link -> on click navigates to list of On Duty Drones

Scenario: Verify Dashboard Page and Check the avialablity of drone

Given I am on Dashboard page
When I click on Available Drone button
Then I verify I am on Available drone page
When I choose the assign task to drone button
When I click on next
Then I verify I am on Drone selection page


