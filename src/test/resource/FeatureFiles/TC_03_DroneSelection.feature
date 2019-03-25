@DroneSelection
Feature: Drone Selection, Location selection, and Item selection
Description:


Scenario Outline: Select location to pick up item

Given user is on the Drone selection page
When I enter the warehouse "<location_id>"
When I select the drone
When I enter the item to pick up "<item_id>"
When I click on next
Then I am on Destination Address page
Then I verify drone "<drone_id>" has pick correct "<location_id>"
When I enter the Destination "<address>" to be delivered
When I click on next
Then I am on Destination Location page

Examples:

|location_id|drone_id|item_id|address|
|Location_01|Drone_01|item_01|streetAddress|

Scenario Outline: Verify the correct Destination address and item picked

Given I am on Destination Location page
When I select the "<status>" of Instruction 
When I click on unload button
Then I verify and confirm the address displayed
Then I verify the "<item_id>" picked for unload

Examples:
|status|
|reached|


Scenario Outline: Verify the unloaded item 
When I click unload button
When I select the "<status>" of Instruction
Then verify I am on Dashboard page

Examples:
|status|
|unloaded|

Scenario Outline: Navigate to parking lot and status of availablity for next assignment
Given I am on Dashboard page
When I select the "<status>" of Instruction
When I click on the avilable parkingspot button
Then I am on parking page
Then I verify "<drone_id>" is available in the selection list

Examples:
|status|drone_id|
|Ready |Drone_01|