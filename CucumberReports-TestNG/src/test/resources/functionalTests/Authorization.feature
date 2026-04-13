@Api
Feature: Authorization End 2 End Test
Description: Authorization feature

Background: Generate authorization token
Given Generate the access token for authentication

@device_Windows @author_Anil
Scenario: Verify the the access token is generated susscessfully using valid credentials
Given Request is sent to the server
When Request is received at the server
Then Verify the response status code 
And  Verify the response status line
And  Verify the response schema
And  Verify the response body data