@activity3
Feature: Testing with Tags
  
  @SimpleAlert @SmokeTest
  Scenario: Testing with Simple alert
    Given User is on the page
    When User clicks the Simple Alert button
 	Then Alert opens
	And Read the text from it and print it
	And Close the alert
	And Read the result text
    
  
  @ConfirmAert
  Scenario: Testing with confirm alert
    Given User is on the page
	When User clicks the Confirm Alert button
	Then Alert opens
	And Read the text from it and print it
	And Close the alert with Cancel
	And Read the result text
  
  
  @PromptAlert
  Scenario: Testing with Prompt alert
    Given User is on the page
	When User clicks the Prompt Alert button
	Then Alert opens
	And Read the text from it and print it
	And Write a custom message in it
	And Close the alert
	And Read the result text