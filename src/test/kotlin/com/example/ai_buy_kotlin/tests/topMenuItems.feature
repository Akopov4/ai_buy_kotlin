Feature: Testing of top Menu
Scenario: check presence of required menu items in the top menu
Given  Home page is loaded
Then   Home, Solutions, Industries, Patents,News are present in the TOP Menu


Scenario:  Click on item Solutions of top Menu
Given Home page is loaded
When Click on item Solution in the Top bar
Then Sub menu occurs
Then sub menu has green background
Then Our Solutions and Our Platforms are present in Green submenu


Scenario Outline: Click on Submenu items
Given Home page is loaded
When Click on item Solution in the Top bar
When user clicks on <greenSubMenuItem>
Then <subHeading> is visible
Examples: Sub menu items and Headings
Examples:
|greenSubMenuItem| subHeading|
|Our Solutions|Our Solutions|
|Our Platforms|Platforms|

Scenario: Get list of items in Industries dropdown
Given Home page is loaded
When click on Industries in the top bar
Then appropriate values in dropdown are visible