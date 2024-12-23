Feature: User Opinion

Scenario: User Open The Form
Given the user is in the home page
When the user clicks in the accept cookies option
And the user clicks on the lateral button
Then the form appears at the lateral

Scenario: User Does The Form
Given the form appears at the lateral
And the user does the form
And the user sends the form
Then the opinion comment is sent