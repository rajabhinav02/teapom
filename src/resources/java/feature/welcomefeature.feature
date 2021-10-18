Feature: Test the welcome page
Scenario Outline: Add the tea and click on Add
	Given user is on homescreen with title Welcome
	When user is on "<teaname>" add button is clicked
	#Then user navigates on Menu screen

Examples:
	|teaname|
	|Loose Tea|
	|Herbal Tea|
	
Scenario: Test navigation to all the pages
	Given user is on homescreen with title Welcome
	When user clicks on all the links on left side
	Then link should open in new window